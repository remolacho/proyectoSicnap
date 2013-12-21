package net.cablen.soporte.cartera.recuperacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

import net.cablen.helppers.Usuario;
import net.cablen.helppers.ValidarCampos;
import net.cablen.soporte.actividades.modelo.TshActividades;
import net.cablen.soporte.cartera.recuperacion.modelo.Cartera;
import net.cablen.soporte.cartera.recuperacion.modelo.ProntoPago;
import net.cablen.soporte.cartera.recuperacion.vista.VistaCarteraApertura;
import net.cablen.soporte.estatus.modelo.TshEstatus;
import net.cablen.soporte.ws.Abonado;

public class Controller_cartera_apertura implements MouseListener,InternalFrameListener,KeyListener,ActionListener {

	private VistaCarteraApertura vCartera;
	int limite = 500;
	Abonado[] lista = null;
	String idActividad  ="";
	boolean swSave = false;//bandera para obligar al usuario a realizar los pasos para poder guardar los datos
	String codAbonado ="";
	int idEstatus=0;
	
	public Controller_cartera_apertura(VistaCarteraApertura vista) {
		// TODO Auto-generated constructor stub
		this.vCartera = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == vCartera.getCmbAct()){
			String subStr = this.vCartera.getCmbAct().getSelectedItem().toString();
			idActividad =  subStr.substring(0,4);
		}
		
		//validamos las distintas opciones para que el usuario final cumpla con el objetivo 	//3391029 6355705
		if (e.getSource() == vCartera.getBtmGuardar()){
			
			String msg ="";
			int regTable =  this.vCartera.getTable().getRowCount();//cantidad de registros de la tabla
			boolean swCv = this.vCartera.getTxtAbonado().getText().isEmpty();
			TshActividades objAct = new TshActividades();
			TshEstatus objEst = new TshEstatus();
			Cartera objCartera = new Cartera();
			ProntoPago objP = new ProntoPago();
			
			if (swSave){
				 if (regTable > 0){
					 if (!swCv){
						 if (!this.vCartera.getTxtDescripcion().getText().isEmpty()){
							 if (!this.vCartera.getTxtComentario().getText().isEmpty()){
								 codAbonado = this.vCartera.getTxtAbonado().getText();
								 objAct.setIdActividad(Integer.parseInt(idActividad));
								 objCartera.setIdCorrelativoCart(Long.parseLong(this.vCartera.getLblCorrelativo().getText()));
								 objCartera.setTicketCart(this.vCartera.getLblInc().getText());
								 objCartera.setUserSistema(Usuario.getUser().getLogin());
								 objCartera.setFechaLlamada(ValidarCampos.soloFecha());	
								 objCartera.setTshActividades(objAct);
								 objCartera.setDetalle(this.vCartera.getTxtDescripcion().getText());
								 objCartera.setComentarioInicial(this.vCartera.getTxtComentario().getText());
								 objCartera.setAbonado(codAbonado);
								 objCartera.setEstatus(1);
								
								 //bloque para validar si debe ingresar fecha de compromiso.
								 
								 int swFecha = 0;
								 
								 if (this.vCartera.getChFecha().isSelected()){
									 idEstatus = 1002; //se le asigna el valor del estatus de fecha de compromiso de la tabla tsEstatus parqa cartera
									 try {
										 objCartera.setFechaCompromiso(ValidarCampos.soloFecha(vCartera.getTxtFecha().getDate()));
										 if (ValidarCampos.compararFechas(this.vCartera.getTxtFecha().getDate()) > 0){ //valida que la fecha sea igual o mayor
											 swFecha = 1;
										 }else{
											 JOptionPane.showMessageDialog(null,"la fecha es menor o igual a la actual");
										 } 
									 } catch (Exception e2) {
										 swFecha = 0;
									 }
								 }else{
									 idEstatus = 1008; //se le asigna el valor del estatus de abierta de la tabla tsEstatus parqa cartera
									 objCartera.setFechaCompromiso(ValidarCampos.soloFecha());
									 swFecha = 2;
								 }
								 
								 objEst.setIdEstatus(idEstatus);
								 objCartera.setTshEstatus(objEst);
								 
								 if (swFecha > 0){
									
										 msg = objP.asignarTicket(objCartera);
										 JOptionPane.showMessageDialog(null,msg);
										 if (msg.substring(0, 2).equals("OK")){
											 this.vCartera.getTxtCedula().setText("");
											 this.nuevo();
										 }
									
								 }else{
									 JOptionPane.showMessageDialog(null,"debes seleccionar la fecha de compromiso");
								 }
								 
								 //fin bloque
							 }else{
								 JOptionPane.showMessageDialog(null,"Debes llenar el comentario");
							 }
						 }else{
							 JOptionPane.showMessageDialog(null,"Debes llenar el detalle");
						 }
					 }else{
						 JOptionPane.showMessageDialog(null,"Debes seleccionar un abonado de la tabla");
					 }
				 }else{
					 JOptionPane.showMessageDialog(null,"No hay registros en la tabla");
				 }
			}else{
				JOptionPane.showMessageDialog(null,"Debes teclear la Ci en el campo correspondiente y pulsar enter");
			}
		}
		
	}

	@Override 		//validamos las distintas opciones para que el usuario final cumpla con el objetivo 	//3391029 6355705
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() ==  this.vCartera.getTxtCedula()){
			if (e.getKeyCode() == 10){
				if(!vCartera.getTxtCedula().getText().isEmpty()) {	
					ProntoPago pp = new ProntoPago();
					lista = pp.lista(this.vCartera.getTxtCedula().getText());
					
					switch (lista[0].getABONUMERO()) {
						case "0":
							JOptionPane.showMessageDialog(null,"No hay registros asociados a esta CI");
							this.nuevo();
							swSave = true;
							break;
						case "-1":
							JOptionPane.showMessageDialog(null,"Problemas en la consulta");
							this.nuevo();
							swSave = false;
							break;
						default:
							cargarTabla(lista);
							swSave = true;
							break;
					}
					
				}else{
					JOptionPane.showMessageDialog(null,"Debes ingresar la CI");
					swSave = false;
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.vCartera.getTxtComentario()){
			if(this.vCartera.getTxtComentario().getText().length() == limite){
				e.consume();
			}
		}
	}

	@Override
	public void internalFrameActivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameClosed(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameClosing(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameIconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameOpened(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		ProntoPago pp = new ProntoPago();
		
		DefaultComboBoxModel mdlCombo= new DefaultComboBoxModel();
	    this.vCartera.getCmbAct().setModel(mdlCombo);
	    List<TshActividades> lista =  pp.cargarActividades();
	    int tamano = lista.size();
	    for (int i=0;i< tamano;i++){
	    	  mdlCombo.addElement(lista.get(i).getIdActividad()  + " - " + lista.get(i).getActividad()); 
	    }
	  
	  
	    this.vCartera.getLblFecha().setText(new Date().toString());
	    
		String ticket = pp.iniciarTicket();
	    this.vCartera.getLblInc().setText(ticket);
	    this.vCartera.getLblCorrelativo().setText(ticket.substring(4));
	    pp = null;
	    
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == this.vCartera.getTable()){
			if (e.getClickCount() == 2){
				int indice = vCartera.getTable().getSelectedRow();
				Abonado abo = lista[indice];
				this.vCartera.getTxtAbonado().setText(abo.getABONUMERO().trim());
				this.vCartera.getTxtNombre().setText(abo.getABONOMBRE().trim());
				this.vCartera.getTxtReferencia().setText(abo.getDETALLE().trim());
				this.vCartera.getTxtDomi().setText(abo.getOTRDOMI().trim());
				this.vCartera.getTxtCiudad().setText(abo.getCIUDAD().trim());
				this.vCartera.getTxtCalle().setText(abo.getCALLE().trim());
				//se genera este try debido a los valores nulos que arroja la consulta
				try {
					this.vCartera.getTxtTelefono().setText(abo.getCOD_ZONA()+ abo.getTELEFONO().trim());
				} catch (Exception e2) {
				}				
				this.vCartera.getTxtPoste().setText(abo.getNUMPOSTE().trim());
				this.vCartera.getTxtSaldo().setText(Float.toString(abo.getSALDO()));
				abo = null;
			}	
		}
		
		if(e.getSource() == this.vCartera.getChFecha()){
			if(this.vCartera.getChFecha().isSelected()){
				this.vCartera.getTxtFecha().setEnabled(true);				
			}else{
				this.vCartera.getTxtFecha().setEnabled(false);
			}
		}
		
	}
	
	private void cargarTabla(Abonado[] lista){
		
		DefaultTableModel modelo = new DefaultTableModel();
		JTable tabla = this.vCartera.getTable();
		Object data [] = new Object[5];
		modelo.addColumn("Abonado");
		modelo.addColumn("Nombre");
		modelo.addColumn("Ciudad");
		modelo.addColumn("Telefono");
		modelo.addColumn("Saldo");
		
		for (int i=0;i<lista.length;i++){
			
		    data[0] = lista[i].getABONUMERO();
		    data[1] = lista[i].getABONOMBRE();
		    data[2] = lista[i].getCIUDAD();
		    data[3] = lista[i].getCOD_ZONA() + lista[i].getTELEFONO();
		    data[4] = lista[i].getSALDO();
		    modelo.addRow(data);
	          
		}
		
		tabla.setModel(modelo);
		tabla.setModel(modelo);
		this.vCartera.setTable(tabla);
		
	}
	
	
	private void nuevo(){
		
	    DefaultTableModel modelo = new DefaultTableModel();
		ProntoPago pp = new ProntoPago();
		String ticket = pp.iniciarTicket();
	    this.vCartera.getLblInc().setText(ticket);
	    this.vCartera.getLblCorrelativo().setText(ticket.substring(4));
		this.vCartera.getTxtAbonado().setText("");
		this.vCartera.getTxtNombre().setText("");
		this.vCartera.getTxtReferencia().setText("");
		this.vCartera.getTxtDomi().setText("");
		this.vCartera.getTxtCiudad().setText("");
		this.vCartera.getTxtCalle().setText("");
		this.vCartera.getTxtTelefono().setText("");
		this.vCartera.getTxtPoste().setText("");
		this.vCartera.getTxtSaldo().setText(Float.toString(0));
		this.vCartera.getTxtDescripcion().setText("");
	 	this.vCartera.getTxtComentario().setText("");
		this.vCartera.getTable().setModel(modelo);
		this.vCartera.getTxtFecha().setDate(null);
		pp = null;
		
	}
	
}
