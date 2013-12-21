package net.cablen.recibos.controlador;

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
import net.cablen.principal.vistas.VisorMDI;
import net.cablen.principal.vistas.VistaMDI;
import net.cablen.promotor.modelo.Promotores;
import net.cablen.promotor.vistas.ListPromotor;
import net.cablen.recibos.modelo.Recibo;
import net.cablen.recibos.vista.AsignarRecibos;

public class Controller_asig_recibos  implements ActionListener,CaretListener{
	
	private AsignarRecibos vAsigR;
	private VistaMDI vistaMdi;
	private JDesktopPane content;
	private PermisosDao perDao;
	private Promotores promotor;
	
	public Controller_asig_recibos(AsignarRecibos vista) {
		// TODO Auto-generated constructor stub
		this.vAsigR = vista;
		this.vistaMdi = VisorMDI.getFrmMenu();
		this.content = vistaMdi.formMdi;
		this.perDao = new PermisosDao();
	}
	
	@Override
	public void caretUpdate(CaretEvent e) {
		if(e.getSource() == this.vAsigR.getTxtCedula()){
			
			Contratos modelo = new Contratos();
			promotor = modelo.cargarPromotor(vAsigR.getTxtCedula().getText());
			//System.out.println(vPrecintos.getTxtCedula().getText());
			vAsigR.getLblFieldNombre().setText(promotor.getNombre());
			vAsigR.getLblFieldApellido().setText(promotor.getApellido());
			modelo=null;
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vAsigR.getBtmPromotor()){
			if(perDao.Acceso("ListPromotor") == 1){
				ListPromotor listaPro = new ListPromotor("Lista de Entes",vAsigR);
				centrarFrm (listaPro,vistaMdi);
				content.add(listaPro);// Agregamos el frame al escritorio
				try {
					listaPro.setSelected(true);// Decimos que comience Enfocado				
				} 
				catch (PropertyVetoException e1) {}
				//vPrecintos.dispose();			
			}
		}
		
		
		if(e.getSource() == vAsigR.getBtmCargar()){


			DefaultTableModel modelo = new DefaultTableModel();
			JTable tabla = this.vAsigR.getTabla();
			
			//inicia las variables a enviar al modelo contrato por su constructor
			long precintoFinal = Long.parseLong(this.vAsigR.getTxtReciboF().getText());
			String cedula = this.vAsigR.getTxtCedula().getText();
			String nombre =  this.vAsigR.getLblFieldNombre().getText() + " " +  this.vAsigR.getLblFieldApellido().getText();
			long precintoInicial = Long.parseLong(this.vAsigR.getTxtReciboI().getText());
			long cant =  ((precintoFinal + 1) -  precintoInicial);
			
			if(precintoInicial > 0 && cant > 0) {
			
				Object data [] = new Object[3];
			
				modelo.addColumn("Precinto");
				modelo.addColumn("Cedula");
				modelo.addColumn("Nombre");
			
				long acum = precintoInicial; //este acumulador adopta el valor inicial del pre contrato para ser incrementado en el jtable
			
				for (int i=0;i<cant;i++){
				
					data[0] = Long.toString(acum);
					data[1] = cedula ;
					data[2] = nombre;
					modelo.addRow(data);
					acum ++;
				
				}
			
				tabla.setModel(modelo);
				this.vAsigR.getBtmGenerar().setEnabled(true);

				tabla = null;
				modelo = null;
				data = null;
			}else {
				
				JOptionPane.showMessageDialog(null,"No hay recibos asignados","SICNAPP", 1);	
				
			}
			
		}
		
		if(e.getSource() == vAsigR.getBtmGenerar()){
			
			int cantidad = vAsigR.getTabla().getRowCount();
			long [] recibos = new long[cantidad];
			
			for(int i=0;i<cantidad;i++){
				recibos[i] = Long.parseLong(vAsigR.getTabla().getValueAt(i,0).toString());
			}
			
			Recibo recibo = new Recibo(recibos, promotor);
			String msg = recibo.asigRecibos();
			
			if (!msg.equals("")){
				JOptionPane.showMessageDialog(null, msg);
			}else{	
				JOptionPane.showMessageDialog(null, "Se almacenaron con exito todos los Recibos");
			}
			
			vAsigR.getBtmGenerar().setEnabled(false);
			vAsigR.getTxtCedula().setText("");
			vAsigR.getTxtReciboI().setText("0");
			vAsigR.getTxtReciboF().setText("0");
			DefaultTableModel modelo = new DefaultTableModel();
			JTable tabla = this.vAsigR.getTabla();	
			tabla.setModel(modelo);
			
			recibo = null;
			promotor = null;
			
		}
		
		
	}
	
    public void centrarFrm (JInternalFrame hijo ,VistaMDI padre){		
		 
		 hijo.setLocation(padre.getWidth()/2 - hijo.getWidth()/2 ,
		 padre.getHeight()/2 - hijo.getHeight()/2 - 20); 
		 // CENTRA EL FORMULARIO
		 
	 }

}
