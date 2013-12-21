package net.cablen.soporte.callCenter.troubleshooting.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import net.cablen.helppers.ValidarCampos;
import net.cablen.permisos.modelo.PermisosDao;
import net.cablen.principal.vistas.VisorMDI;
import net.cablen.principal.vistas.VistaMDI;
import net.cablen.soporte.actividades.modelo.TshActividades;
import net.cablen.soporte.callCenter.troubleshooting.modelo.CallCenter;
import net.cablen.soporte.callCenter.troubleshooting.modelo.Troubleshooting;
import net.cablen.soporte.callCenter.troubleshooting.vista.VistaCerrarIncidencia;
import net.cablen.soporte.callCenter.troubleshooting.vista.VistaListTroubleshooting;
import net.cablen.soporte.estatus.modelo.TshEstatus;

public class Controller_troubleshooting_cerrar implements ActionListener,InternalFrameListener{

	VistaCerrarIncidencia vCerrar = null;
	Troubleshooting objTrou = null;
	PermisosDao perDao;
	JDesktopPane content;
	
	public Controller_troubleshooting_cerrar(VistaCerrarIncidencia vista, Troubleshooting trou) {
		this.objTrou = trou; 
		this.vCerrar = vista;
		this.perDao = new PermisosDao();
		this.content = VisorMDI.getFrmMenu().formMdi;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.vCerrar.getBmtProc()){
		    if (this.vCerrar.getTxtComentarioF().getText().length()>0){
		    	
				/*Si = 0 No = 1*/
				int respuesta = JOptionPane.showConfirmDialog(null, "Desea cerrar la Incidencia?", "Confirmar Proceso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		    	
				if (respuesta == 0){
					
					String msg ="";
					CallCenter cc = new CallCenter();
					this.objTrou.setComentarioFinal(this.vCerrar.getTxtComentarioF().getText());
					this.objTrou.getTshEstatus().setIdEstatus(Integer.parseInt(this.vCerrar.getCmbEstatus().getSelectedItem().toString().substring(0,4)));
					msg = cc.cerrarInc(this.objTrou);
					cc = null;
					
					if (msg.equals("")){
						JOptionPane.showMessageDialog(null, "Incidencia Procesada con Exito");
						if (perDao.Acceso("VistaListTroubleshooting") == 1){
							VistaListTroubleshooting vTrou= new VistaListTroubleshooting("Incidencias");
							centrarFrm (vTrou,VisorMDI.getFrmMenu());
							content.add(vTrou);// Agregamos el frame al escritorio
							try {
								vTrou.setSelected(true);// Decimos que comience Enfocado
								this.vCerrar.dispose();
							} 
							catch (PropertyVetoException e1) {}				
						}
					}else{
						JOptionPane.showMessageDialog(null, msg);
					}
					
		    	}
		    	
			}else {
				JOptionPane.showMessageDialog(null,"Debes ingresar un comentario de cierre");
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
		
		this.vCerrar.getLblEstatusAct().setText("Estatus: " + objTrou.getTshEstatus().getDescripcion());
		this.vCerrar.getLblFecha().setText(new Date().toString());
		this.vCerrar.getLblUser().setText(objTrou.getUserSistema());
		this.vCerrar.getLblFechaAper().setText(objTrou.getFechaApertura());
		this.vCerrar.getLblActividad().setText(objTrou.getTshActividades().getActividad());
		this.vCerrar.getLblDetalle().setText(objTrou.getDetalleReclamo());
		this.vCerrar.getTxtComentarioI().setText(objTrou.getComentarioInicial());
		this.vCerrar.getTxtAbonado().setText(objTrou.getAbonado());
		List<TshEstatus> lista = null;
		CallCenter cc = new CallCenter();
		lista = cc.findListEstatus();
		
		DefaultComboBoxModel mdlCombo= new DefaultComboBoxModel();
		this.vCerrar.getCmbEstatus().setModel(mdlCombo);
	    int tamano = lista.size();
	    for (int i=0;i< tamano;i++){
	    	  mdlCombo.addElement(lista.get(i).getIdEstatus()  + " - " + lista.get(i).getDescripcion()); 
	    }
	    
	    cc = null;
		
	}
	
    public void centrarFrm (JInternalFrame hijo ,VistaMDI padre){		
		 
		 hijo.setLocation(padre.getWidth()/2 - hijo.getWidth()/2 ,
		 padre.getHeight()/2 - hijo.getHeight()/2 - 20); 
		 // CENTRA EL FORMULARIO
		 
	 }
	
}
