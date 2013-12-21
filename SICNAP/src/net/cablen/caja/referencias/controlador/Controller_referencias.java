package net.cablen.caja.referencias.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyVetoException;
import java.util.List;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

import net.cablen.caja.conciliaciones.modelo.Conciliacion;
import net.cablen.caja.conciliaciones.modelo.Conciliaciones;
import net.cablen.caja.conciliaciones.vista.VistaConciliacion;
import net.cablen.caja.estadoDeCuentas.modelo.EstadoDeCuentas;
import net.cablen.caja.estadoDeCuentas.modelo.EstadosCuenta;
import net.cablen.caja.referencias.modelo.Referencias;
import net.cablen.caja.referencias.vista.AsignarReferencias;
import net.cablen.caja.referencias.vista.VistaSerialesRef;
import net.cablen.contratos.vista.AsignarPreContrato;
import net.cablen.helppers.Usuario;
import net.cablen.helppers.ValidarCampos;
import net.cablen.permisos.modelo.PermisosDao;
import net.cablen.principal.vistas.VisorMDI;
import net.cablen.principal.vistas.VistaMDI;

public class Controller_referencias implements ActionListener,KeyListener,InternalFrameListener{

	AsignarReferencias vref;
	PermisosDao perDao;
	JDesktopPane content;
	
	public Controller_referencias(AsignarReferencias vista) {
		this.vref = vista;
		this.perDao = new PermisosDao();
		this.content = VisorMDI.getFrmMenu().formMdi;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == vref.getTxtRef()){
			if(e.getKeyCode() == 10){
				//System.out.println(vref.getSerial() + vref.getTxtRef().getText());
				EstadosCuenta objEst = null;
				EstadoDeCuentas objMod = new EstadoDeCuentas();
				objEst = objMod.obtener(vref.getTxtSerial().getText() + vref.getTxtRef().getText());
				
				if (objEst != null){
					vref.getLblBanco().setText(objEst.getCodBanco());
					vref.getLblMonto().setText(Float.toString(objEst.getMonto()));
					vref.getLblFecha().setText(objEst.getFechaPago());
					vref.getTxtDetalle().setText(objEst.getDescripcion());
					vref.getBtmAgregar().setEnabled(true);
					vref.getTxtRef().setEditable(false);
				}else{
					JOptionPane.showMessageDialog(null,"No hay datos relacionqados a esta referencia");
					vref.getBtmAgregar().setEnabled(false);
				}
				
				objMod = null;
				objEst =null;
	
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
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == vref.getBtmAgregar()){
			/*Si = 0 No = 1*/
			int respuesta = JOptionPane.showConfirmDialog(null, "Desea asignar la referencia?", "Confirmar Proceso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
           
			if (respuesta == 0){
            	
				List<Referencias> lista = null;
            	String msg = "";
            	Conciliacion conciliar  = new Conciliacion();
            	Conciliaciones objCon = new Conciliaciones();
            	Referencias ref = new Referencias();
            	objCon.setIdConciliacion(Integer.parseInt(vref.getLblConciliacion().getText()));
            	ref.setBanco(vref.getLblBanco().getText());
            	ref.setConciliaciones(objCon);
            	ref.setDetalle(vref.getTxtDetalle().getText());
            	ref.setEstatus(0);
            	ref.setFechaBancaria(vref.getLblFecha().getText());
            	ref.setFechaRegistro(ValidarCampos.soloFecha());
            	ref.setMonto(Float.parseFloat(vref.getLblMonto().getText()));
            	ref.setReferencia(vref.getTxtSerial().getText() + vref.getTxtRef().getText());
            	ref.setTipoDepo(vref.getCmbTipo().getSelectedItem().toString());
            	ref.setUserSistema(Usuario.getUser().getLogin());
            	msg = conciliar.agregarReferencia(ref);
			
            	if(!msg.equals("")){
            		JOptionPane.showMessageDialog(null,msg);
            	}
			
            	this.newRef();
			

            	lista =  conciliar.listaXConciliacion(Integer.parseInt(vref.getLblConciliacion().getText()),0);
			
            	if (lista != null){
            		cargarTabla(lista);
            		vref.getBtmConciliar().setEnabled(true);
            	}

            	lista = null;
            	conciliar =null;
            	ref = null;
            	objCon = null;
            	
            }

		}
		
		if (e.getSource() == vref.getBtmConciliar()){
			
			if (perDao.Acceso("VistaConciliacion") == 1){	
				
				String monto =vref.getLblTotal().getText();
				String conciliacion = vref.getLblConciliacion().getText();
				String user = Usuario.getUser().getLogin();
				
				VistaConciliacion vistaConciliacion = new VistaConciliacion("VistaConciliacion",conciliacion,user,monto,vref);				
				centrarFrm (vistaConciliacion, VisorMDI.getFrmMenu());
				content.add(vistaConciliacion);// Agregamos el frame al escritorio
				
				try {
					vistaConciliacion.setSelected(true);// Decimos que comience Enfocado				
				} 
				catch (PropertyVetoException e1) {}
				
			}
		}
		
		if (e.getSource() == vref.getBtmReset()){
			
			this.newRef();
			
		}
		
		
		if (e.getSource() == vref.getCmbTipo()){
			
			int tipoRef =  vref.getCmbTipo().getSelectedIndex();
			this.newRef();
			
			if (tipoRef == 0){
				if (perDao.Acceso("VistaSerialesRef") == 1){	
					VistaSerialesRef vSerial = new VistaSerialesRef("Seriales de los Puntos de Venta",vref);				
					centrarFrm (vSerial, VisorMDI.getFrmMenu());
					content.add(vSerial);// Agregamos el frame al escritorio
					
					try {
						vSerial.setSelected(true);// Decimos que comience Enfocado				
					} 
					catch (PropertyVetoException e1) {}
					
				}
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
		
		int conciliacion = 0;
		Conciliacion objC = new Conciliacion();
		conciliacion = objC.asignarConciliacion();
	    
		if (conciliacion > 0){
			
			vref.getLblConciliacion().setText(Integer.toString(conciliacion));
			
			List<Referencias> lista = null;
			lista =  objC.listaXConciliacion(Integer.parseInt(vref.getLblConciliacion().getText()),0);
			
			if (lista.size() > 0){
				cargarTabla(lista);
				vref.getBtmConciliar().setEnabled(true);
			}
			
		}else{
			JOptionPane.showMessageDialog(null,"Error al cargar el contenedor llamar a sistemas");
			vref.getBtmAgregar().setEnabled(false);
		}
		
		objC = null;
		
	}
	
	private void cargarTabla(List<Referencias> lista){
	
		float totalCaja = 0;
		DefaultTableModel modelo = new DefaultTableModel();
		JTable tabla = this.vref.getTable();
		Object data [] = new Object[5];
		modelo.addColumn("Referencia");
		modelo.addColumn("Banco");
		modelo.addColumn("Monto");
		modelo.addColumn("Tipo");
		modelo.addColumn("Fecha Bancaria");
		
		for (int i=0;i<lista.size();i++){
			
		    data[0] = lista.get(i).getReferencia();
		    data[1] = lista.get(i).getBanco();
		    data[2] = lista.get(i).getMonto();
		    data[3] = lista.get(i).getTipoDepo();
		    data[4] = lista.get(i).getFechaBancaria();
		    totalCaja +=  lista.get(i).getMonto();
		    modelo.addRow(data);
	          
		}
		
	    vref.getLblTotal().setText(Float.toString(totalCaja));
		tabla.setModel(modelo);
		this.vref.setTable(tabla);
		
	}
	
	private void newRef(){

		vref.getTxtRef().setText("");
		vref.getLblMonto().setText("0.00");
		vref.getLblBanco().setText("___");
		vref.getLblFecha().setText("___");
		vref.getTxtDetalle().setText("");
		vref.getTxtSerial().setText("");
		vref.getTxtRef().setEditable(true);
		vref.getBtmAgregar().setEnabled(false);
	
	}
	
    public void centrarFrm (JInternalFrame hijo ,VistaMDI padre){		
		 
		 hijo.setLocation(padre.getWidth()/2 - hijo.getWidth()/2 ,
		 padre.getHeight()/2 - hijo.getHeight()/2 - 20); 
		 // CENTRA EL FORMULARIO
		 
	 }

}




