package net.cablen.soporte.callCenter.troubleshooting.controlador;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

import net.cablen.caja.conciliaciones.modelo.Conciliaciones;
import net.cablen.helppers.Usuario;
import net.cablen.helppers.ValidarCampos;
import net.cablen.soporte.actividades.modelo.TshActividades;
import net.cablen.soporte.callCenter.troubleshooting.modelo.CallCenter;
import net.cablen.soporte.callCenter.troubleshooting.modelo.Troubleshooting;
import net.cablen.soporte.callCenter.troubleshooting.modelo.TroubleshootingDao;
import net.cablen.soporte.callCenter.troubleshooting.vista.VistaTroubleshooting;
import net.cablen.soporte.estatus.modelo.TshEstatus;
import net.cablen.soporte.ws.Abonado;
import net.cablen.soporte.ws.ServicioAboProxy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.List;


public class Controller_troubleshooting implements ActionListener,KeyListener,InternalFrameListener,MouseListener{
	
	int limite = 500;
	VistaTroubleshooting vTrou = null;
	Abonado[] lista = null;
	String idActividad  ="";
	boolean swSave = false;//bandera para obligar al usuario a realizar los pasos para poder guardar los datos
	String codAbonado ="";
	
	public Controller_troubleshooting(VistaTroubleshooting vista) {
		// TODO Auto-generated constructor stub
		this.vTrou = vista;
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
		
		CallCenter cc = new CallCenter();
	
		DefaultComboBoxModel mdlCombo= new DefaultComboBoxModel();
	    this.vTrou.getCmbActividad().setModel(mdlCombo);
	    List<TshActividades> lista =  cc.cargarActividades();
	    int tamano = lista.size();
	    for (int i=0;i< tamano;i++){
	    	  mdlCombo.addElement(lista.get(i).getIdActividad()  + " - " + lista.get(i).getActividad()); 
	    }
	  
	  
	    this.vTrou.getLblFecha().setText(new Date().toString());
	    
		String incidencia = cc.IniciarIncidencia();
	    this.vTrou.getTxtIncidencia().setText(incidencia);
	    this.vTrou.getLblCorrelativo().setText(incidencia.substring(4));
		cc = null;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == vTrou.getCmbActividad()){
			String subStr = this.vTrou.getCmbActividad().getSelectedItem().toString();
			idActividad =  subStr.substring(0,4);
		}
		
		//validamos las distintas opciones para que el usuario final cumpla con el objetivo 	//3391029 6355705
		if (e.getSource() == vTrou.getBtmSave()){
			String msg ="";
			int regTable =  this.vTrou.getTable().getRowCount();//cantidad de registros de la tabla
			boolean swCv = this.vTrou.getTxtAbonado().getText().isEmpty();
			
			CallCenter objCC = new CallCenter();
			Troubleshooting objTrou = new Troubleshooting();
			TshActividades objAct = new TshActividades();
			TshEstatus objEst = new TshEstatus();
			
			if (swSave){
				 if (regTable > 0){
					  if (!swCv){
						 if (!this.vTrou.getTxtDetalle().getText().isEmpty()){
							 if (!this.vTrou.getTxtComentario().getText().isEmpty()){
								 codAbonado = this.vTrou.getTxtAbonado().getText();
								 objEst.setIdEstatus(1000);
								 objAct.setIdActividad(Integer.parseInt(idActividad));
								 objTrou.setIdCorrelativo(Long.parseLong(this.vTrou.getLblCorrelativo().getText()));
								 objTrou.setIncidencia(this.vTrou.getTxtIncidencia().getText());
								 objTrou.setUserSistema(Usuario.getUser().getLogin());
								 objTrou.setFechaApertura(ValidarCampos.soloFecha());
								 objTrou.setTshActividades(objAct);
								 objTrou.setTshEstatus(objEst);
								 objTrou.setDetalleReclamo(this.vTrou.getTxtDetalle().getText());
								 objTrou.setComentarioInicial(this.vTrou.getTxtComentario().getText());
								 objTrou.setAbonado(codAbonado);
								 objTrou.setEstatus(1);
								 msg = objCC.asignarIncidencia(objTrou);
								 
								 JOptionPane.showMessageDialog(null,msg);
								 
								 if (msg.substring(0, 2).equals("OK")){
									 this.vTrou.getTxtCedula().setText("");
									 this.nuevo();
								 }
								 
							 }else{
								 JOptionPane.showMessageDialog(null,"Debes llenar el comentario");
							 }
						 }else{
							 JOptionPane.showMessageDialog(null,"Debes llenar el detalle");
						 }
					 }else {
						 JOptionPane.showMessageDialog(null,"Debes seleccionar un abonado de la tabla");
					 }
				 }else {
					 if (idActividad.equals("1010")){
						 if (!this.vTrou.getTxtDetalle().getText().isEmpty()){
							 if (!this.vTrou.getTxtComentario().getText().isEmpty()){
								 codAbonado = this.vTrou.getTxtCedula().getText();
								 objEst.setIdEstatus(1001);
								 objAct.setIdActividad(Integer.parseInt(idActividad));
								 objTrou.setIdCorrelativo(Long.parseLong(this.vTrou.getLblCorrelativo().getText()));
								 objTrou.setIncidencia(this.vTrou.getTxtIncidencia().getText());
								 objTrou.setUserSistema(Usuario.getUser().getLogin());
								 objTrou.setFechaApertura(ValidarCampos.soloFecha());
								 objTrou.setTshActividades(objAct);
								 objTrou.setTshEstatus(objEst);
								 objTrou.setDetalleReclamo(this.vTrou.getTxtDetalle().getText());
								 objTrou.setComentarioInicial(this.vTrou.getTxtComentario().getText());
								 objTrou.setAbonado(codAbonado);
								 objTrou.setEstatus(1);
								 msg = objCC.asignarIncidencia(objTrou);
								
								 JOptionPane.showMessageDialog(null,msg);
								 
								 if (msg.substring(0, 2).equals("OK")){
									 this.vTrou.getTxtCedula().setText("");
									 this.nuevo();
								 }
								 
							 }else{
								 JOptionPane.showMessageDialog(null,"Debes llenar el comentario");
							 }
						 }else{
							 JOptionPane.showMessageDialog(null,"Debes llenar el detalle");
						 }
					 }else{
						 JOptionPane.showMessageDialog(null,"Debes seleccionar la actividad 1010 si desea asociar la incidencia a una peticion del servicio en la zona del futuro cliente");
					 }
				 }
			}else{
				JOptionPane.showMessageDialog(null,"Debes teclear la Ci en el campo correspondiente y pulsar enter");
			}
			
			
			objTrou = null;
			objAct  = null;
			objEst  = null;
			objCC   = null;
			
		}
		

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
	
		if (e.getSource() == this.vTrou.getTable()){
			if (e.getClickCount() == 2){
				int indice = vTrou.getTable().getSelectedRow();
				Abonado abo = lista[indice];
				this.vTrou.getTxtAbonado().setText(abo.getABONUMERO().trim());
				this.vTrou.getTxtNombre().setText(abo.getABONOMBRE().trim());
				this.vTrou.getTxtReferencia().setText(abo.getDETALLE().trim());
				this.vTrou.getTxtDomicilio().setText(abo.getOTRDOMI().trim());
				this.vTrou.getTxtCiduad().setText(abo.getCIUDAD().trim());
				this.vTrou.getTxtCalle().setText(abo.getCALLE().trim());
				//se genera este try debido a los valores nulos que arroja la consulta
				try {
					this.vTrou.getTxtTelefono().setText(abo.getCOD_ZONA()+ abo.getTELEFONO().trim());
				} catch (Exception e2) {
				}				
				this.vTrou.getTxtPoste().setText(abo.getNUMPOSTE().trim());
				this.vTrou.getTxtSaldo().setText(Float.toString(abo.getSALDO()));
				abo = null;
			}	
		}	
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
	
		if (e.getSource() == vTrou.getTxtCedula()){
			if (e.getKeyCode() == 10){
				if(!vTrou.getTxtCedula().getText().isEmpty()) {	
					CallCenter cc = new CallCenter();
					lista = cc.lista(this.vTrou.getTxtCedula().getText());
					
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
		if (e.getSource() == this.vTrou.getTxtComentario()){
			if(this.vTrou.getTxtComentario().getText().length() == limite){
				e.consume();
			}
		}
	
	}
	
	private void cargarTabla(Abonado[] lista){
		
		DefaultTableModel modelo = new DefaultTableModel();
		JTable tabla = this.vTrou.getTable();
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
		this.vTrou.setTable(tabla);
		
	}
	
	private void nuevo(){
	
		DefaultTableModel modelo = new DefaultTableModel();
		CallCenter cc = new CallCenter();
		String incidencia = cc.IniciarIncidencia();
	    this.vTrou.getTxtIncidencia().setText(incidencia);
	    this.vTrou.getLblCorrelativo().setText(incidencia.substring(4));
		this.vTrou.getTxtAbonado().setText("");
		this.vTrou.getTxtNombre().setText("");
		this.vTrou.getTxtReferencia().setText("");
		this.vTrou.getTxtDomicilio().setText("");
		this.vTrou.getTxtCiduad().setText("");
		this.vTrou.getTxtCalle().setText("");
		this.vTrou.getTxtTelefono().setText("");
		this.vTrou.getTxtPoste().setText("");
		this.vTrou.getTxtSaldo().setText(Float.toString(0));
		this.vTrou.getTxtDetalle().setText("");
		this.vTrou.getTxtComentario().setText("");
		this.vTrou.getTable().setModel(modelo);
		cc = null;
		
	}
	
}
