package net.cablen.contratos.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;

import net.cablen.contratos.modelo.Contratos;
import net.cablen.contratos.vista.AsignarPreContrato;
import net.cablen.permisos.modelo.PermisosDao;
import net.cablen.principal.vistas.VistaMDI;
import net.cablen.promotor.modelo.Promotores;
import net.cablen.promotor.vistas.ListPromotor;

public class Controller_asignar_pre_contrato implements ActionListener,CaretListener {

	private AsignarPreContrato vistaAsignarPreContrato;
	private ListPromotor vistaListPromotor;
	private JDesktopPane content;
	private VistaMDI vistaMdi;
	
	private String boxy = null;
	private long cant;
	private String  cedula;
	private String nombre;
	private long contratoInicial;
	private long contratoFinal;
	PermisosDao perDao;
	
	public Controller_asignar_pre_contrato(VistaMDI mdi,AsignarPreContrato vista){
		
		this.vistaAsignarPreContrato = vista;
		this.vistaMdi = mdi;
		this.content = vistaMdi.formMdi;
		this.perDao = new PermisosDao();
	}

	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource() == this.vistaAsignarPreContrato.getBtmGenerar()){
			
			if (contratoInicial > 0){
			
				DefaultTableModel modelo = new DefaultTableModel();
				JTable tabla = this.vistaAsignarPreContrato.getTabla();
				Contratos contratos = new Contratos(contratoInicial,(int)cant,cedula,boxy);
				String msg = contratos.assignToPromoter();
				JOptionPane.showMessageDialog(null,msg + " " + nombre,"SICNAPP", 1);	
				tabla.setModel(modelo);
				this.vistaAsignarPreContrato.setTabla(tabla);
				this.vistaAsignarPreContrato.getBtmGenerar().setEnabled(false);
				this.vistaAsignarPreContrato.getTxtCantidad().setText("0");
				JTextField txt = vistaAsignarPreContrato.getTxtContrato();
				txt.setText("0");
				vistaAsignarPreContrato.setTxtContrato(txt);
				vistaAsignarPreContrato.getTxtCedula().setText("");
				vistaAsignarPreContrato.getLblFieldNombre().setText("_");
				vistaAsignarPreContrato.getLblFieldApellido().setText("_");
				contratos = null;
				txt=null;
				tabla = null;
				modelo = null;	
				contratos = null;
			}
			
		}
		
		if(e.getSource() == this.vistaAsignarPreContrato.getBtmCargar()){
			
			if(vistaAsignarPreContrato.getrCCS().isSelected()==true)
			{
			   vistaAsignarPreContrato.getrInt().setSelected(false);
			   boxy = vistaAsignarPreContrato.getrCCS().getText();
			   //System.out.println(boxy);
			}else if (vistaAsignarPreContrato.getrInt().isSelected()==true){
				vistaAsignarPreContrato.getrCCS().setSelected(false);
			     boxy = vistaAsignarPreContrato.getrInt().getText();
			  // System.out.println(boxy);
			}
			
			DefaultTableModel modelo = new DefaultTableModel();
			JTable tabla = this.vistaAsignarPreContrato.getTabla();
			
			//inicia las variables a enviar al modelo contrato por su constructor
			contratoFinal = Long.parseLong(this.vistaAsignarPreContrato.getTxtCantidad().getText());
			cedula = this.vistaAsignarPreContrato.getTxtCedula().getText();
			nombre =  this.vistaAsignarPreContrato.getLblFieldNombre().getText() + " " +  this.vistaAsignarPreContrato.getLblFieldApellido().getText();
			contratoInicial = Long.parseLong(this.vistaAsignarPreContrato.getTxtContrato().getText());
			cant =  ((contratoFinal + 1) -  contratoInicial);
			
			if(contratoInicial > 0 && cant > 0) {
			
				Object data [] = new Object[4];
			
				modelo.addColumn("Contrato");
				modelo.addColumn("Cedula");
				modelo.addColumn("Nombre");
				modelo.addColumn("Boxy");
			
				long acum = contratoInicial; //este acumulador adopta el valor inicial del pre contrato para ser incrementado en el jtable
			
				for (int i=0;i<cant;i++){
				
					data[0] = acum ;
					data[1] = cedula ;
					data[2] = nombre;
					data[3] = boxy;
					modelo.addRow(data);
					acum ++;
				
				}
			
				tabla.setModel(modelo);
				this.vistaAsignarPreContrato.getBtmGenerar().setEnabled(true);

				tabla = null;
				modelo = null;
				data = null;
			}else {
				
				JOptionPane.showMessageDialog(null,"No hay contratos asignados","SICNAPP", 1);	
				
			}
		}
		
		
		if (this.vistaAsignarPreContrato != null){
			if (e.getSource() == this.vistaAsignarPreContrato.getBtmPromotor()){
				if (perDao.Acceso("ListPromotor") == 1){
					vistaListPromotor = new ListPromotor("Lista de Promotores");				
					centrarFrm (vistaListPromotor,vistaMdi);
					content.add(vistaListPromotor);// Agregamos el frame al escritorio
					try {
						vistaListPromotor.setSelected(true);// Decimos que comience Enfocado				
					} 
					catch (PropertyVetoException e1) {}
				
					this.close(this.vistaAsignarPreContrato);
				}
			}
		}
		
			
	}

	@Override
	public void caretUpdate(CaretEvent e) {
		
		if (e.getSource() == this.vistaAsignarPreContrato.getTxtCedula()){
		
			Promotores promotor=null;
			JTextField txtCedula = this.vistaAsignarPreContrato.getTxtCedula();
			JLabel lblNombre = this.vistaAsignarPreContrato.getLblFieldNombre();
			JLabel lblApellido = this.vistaAsignarPreContrato.getLblFieldApellido();
			Contratos contrato = new Contratos();
			promotor = contrato.cargarPromotor(txtCedula.getText());
			lblNombre.setText(promotor.getNombre());
			lblApellido.setText(promotor.getApellido());
			this.vistaAsignarPreContrato.setLblFieldNombre(lblNombre);
			this.vistaAsignarPreContrato.setLblFieldApellido(lblApellido);
				
			promotor=null;
			txtCedula = null;
			lblNombre = null;
			lblApellido = null;
			contrato = null;
			
		}
		
	}

    public void centrarFrm (JInternalFrame hijo ,VistaMDI padre){		
		 
		 hijo.setLocation(padre.getWidth()/2 - hijo.getWidth()/2 ,
		 padre.getHeight()/2 - hijo.getHeight()/2 - 20); 
		 // CENTRA EL FORMULARIO
		 
	 }
    
    private void close(AsignarPreContrato vista){
    	vista.dispose();
    }


}
