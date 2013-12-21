package net.cablen.precintos.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;


import net.cablen.contratos.modelo.Contratos;
import net.cablen.permisos.modelo.PermisosDao;
import net.cablen.precintos.modelo.Precinto;
import net.cablen.precintos.vista.VistaAsignarPrecinto;
import net.cablen.principal.vistas.VisorMDI;
import net.cablen.principal.vistas.VistaMDI;
import net.cablen.promotor.modelo.Promotores;
import net.cablen.promotor.vistas.ListPromotor;

public class Controller_asignar_precinto implements ActionListener,CaretListener {

	VistaAsignarPrecinto vPrecintos;
	private VistaMDI vistaMdi;
	private JDesktopPane content;
	PermisosDao perDao;
	private String boxy = "";
	private Promotores promotor;
	
	public Controller_asignar_precinto(VistaAsignarPrecinto vista) {
		// TODO Auto-generated constructor stub
		this.vPrecintos = vista;
		this.vistaMdi = VisorMDI.getFrmMenu();
		this.content = vistaMdi.formMdi;
		this.perDao = new PermisosDao();
	}
	
	@Override
	public void caretUpdate(CaretEvent e) {
		
		if(e.getSource() == this.vPrecintos.getTxtCedula()){
			
			Contratos modelo = new Contratos();
			promotor = modelo.cargarPromotor(vPrecintos.getTxtCedula().getText());
			//System.out.println(vPrecintos.getTxtCedula().getText());
			vPrecintos.getLblNombre().setText(promotor.getNombre());
			vPrecintos.getLblApellido().setText(promotor.getApellido());
			modelo=null;
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == vPrecintos.getBtmPromotor()){
			if(perDao.Acceso("ListPromotor") == 1){
				ListPromotor listaPro = new ListPromotor("Lista de Entes",vPrecintos);
				centrarFrm (listaPro,vistaMdi);
				content.add(listaPro);// Agregamos el frame al escritorio
				try {
					listaPro.setSelected(true);// Decimos que comience Enfocado				
				} 
				catch (PropertyVetoException e1) {}
				//vPrecintos.dispose();			
			}
		}
		
		if(e.getSource() == vPrecintos.getBtmCargar()){

			if(vPrecintos.getrCCS().isSelected()==true)
			{
			   vPrecintos.getrInt().setSelected(false);
			   boxy = vPrecintos.getrCCS().getText();
			}else if (vPrecintos.getrInt().isSelected()==true){
				vPrecintos.getrCCS().setSelected(false);
			    boxy = vPrecintos.getrInt().getText();
			}
			
			DefaultTableModel modelo = new DefaultTableModel();
			JTable tabla = this.vPrecintos.getTable();
			
			//inicia las variables a enviar al modelo contrato por su constructor
			long precintoFinal = Long.parseLong(this.vPrecintos.getTxtFinal().getText());
			String cedula = this.vPrecintos.getTxtCedula().getText();
			String nombre =  this.vPrecintos.getLblNombre().getText() + " " +  this.vPrecintos.getLblApellido().getText();
			long precintoInicial = Long.parseLong(this.vPrecintos.getTxtInicial().getText());
			long cant =  ((precintoFinal + 1) -  precintoInicial);
			
			if(precintoInicial > 0 && cant > 0) {
			
				Object data [] = new Object[4];
			
				modelo.addColumn("Precinto");
				modelo.addColumn("Cedula");
				modelo.addColumn("Ente");
				modelo.addColumn("Boxy");
			
				long acum = precintoInicial; //este acumulador adopta el valor inicial del pre contrato para ser incrementado en el jtable
			
				for (int i=0;i<cant;i++){
				
					data[0] = Long.toString(acum) + vPrecintos.getCmbFinal().getSelectedItem() + vPrecintos.getCmbColor().getSelectedItem();
					data[1] = cedula ;
					data[2] = nombre;
					data[3] = boxy;
					modelo.addRow(data);
					acum ++;
				
				}
			
				tabla.setModel(modelo);
				this.vPrecintos.getBtmGenerar().setEnabled(true);

				tabla = null;
				modelo = null;
				data = null;
			}else {
				
				JOptionPane.showMessageDialog(null,"No hay precintos asignados","SICNAPP", 1);	
				
			}
			
		}
		
		if(e.getSource() == vPrecintos.getBtmGenerar()){
			
			int cantidad = vPrecintos.getTable().getRowCount();
			String [] prencintos = new String[cantidad];
			
			for(int i=0;i<cantidad;i++){
				prencintos[i] = vPrecintos.getTable().getValueAt(i,0).toString();
			}
			
			Precinto precinto = new Precinto(boxy, prencintos, promotor);
			String msg = precinto.asigPrecintos();
			
			if (!msg.equals("")){
				JOptionPane.showMessageDialog(null, msg);
			}else{	
				JOptionPane.showMessageDialog(null, "Se almacenaron con exito todos los precintos");
			}
			
			vPrecintos.getBtmGenerar().setEnabled(false);
			vPrecintos.getTxtCedula().setText("");
			vPrecintos.getTxtInicial().setText("0");
			vPrecintos.getTxtFinal().setText("0");
			DefaultTableModel modelo = new DefaultTableModel();
			JTable tabla = this.vPrecintos.getTable();	
			tabla.setModel(modelo);
			
			precinto = null;
			promotor = null;
			
		}
		
		
	}
	
    public void centrarFrm (JInternalFrame hijo ,VistaMDI padre){		
		 
		 hijo.setLocation(padre.getWidth()/2 - hijo.getWidth()/2 ,
		 padre.getHeight()/2 - hijo.getHeight()/2 - 20); 
		 // CENTRA EL FORMULARIO
		 
	 }

}
