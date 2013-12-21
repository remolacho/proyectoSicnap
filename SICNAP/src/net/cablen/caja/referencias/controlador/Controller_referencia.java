package net.cablen.caja.referencias.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import net.cablen.caja.conciliaciones.modelo.Conciliacion;
import net.cablen.caja.conciliaciones.modelo.Conciliaciones;
import net.cablen.caja.referencias.modelo.Referencia;
import net.cablen.caja.referencias.modelo.Referencias;
import net.cablen.caja.referencias.vista.VistaReferencia;
import net.cablen.helppers.Usuario;
import net.cablen.helppers.ValidarCampos;
import net.cablen.permisos.modelo.PermisosDao;
import net.cablen.principal.vistas.VisorMDI;

public class Controller_referencia implements ActionListener, InternalFrameListener{

	VistaReferencia vistaRef = null;
	PermisosDao perDao = null;
	JDesktopPane content = null;
	
	public Controller_referencia(VistaReferencia ref) {
		 this.vistaRef  = ref;
		 this.perDao = new PermisosDao();
		 this.content = VisorMDI.getFrmMenu().formMdi;
	}
	
	@Override
	public void internalFrameActivated(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameClosed(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameClosing(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameIconified(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameOpened(InternalFrameEvent arg0) {
		
		Conciliacion objC = new Conciliacion();
		vistaRef.getCmbUser().setModel(new DefaultComboBoxModel(objC.cargarUserCaja()));
		objC = null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == vistaRef.getBtmAgregar()){
			String msg ="";
			Referencia refM = new Referencia();
			Referencias ref = new Referencias(); 
			Conciliaciones conc = new Conciliaciones();
			conc.setIdConciliacion(Integer.parseInt(vistaRef.getLblConcilia().getText()));
			ref.setReferencia(vistaRef.getLblRef().getText());
			ref.setConciliaciones(conc);
			ref.setBanco(vistaRef.getTxtBanco().getText());
			ref.setDetalle(vistaRef.getTxtDetalle().getText());
			ref.setEstatus(0);
			ref.setFechaBancaria(ValidarCampos.soloFecha(vistaRef.getTxtFecha().getDate()));
			ref.setFechaRegistro(ValidarCampos.soloFecha());
			try {
				ref.setMonto(Float.parseFloat(vistaRef.getTxtMonto().getText().replace(",",".")));
			} catch (Exception e2) {}			
			ref.setTipoDepo(vistaRef.getCmbTipo().getSelectedItem().toString());
			ref.setUserCaja(vistaRef.getCmbUser().getSelectedItem().toString());
			ref.setUserSistema(Usuario.getUser().getLogin());
			msg = refM.Agregar(ref);
			JOptionPane.showMessageDialog(null, msg);
			refM.updateRefErr();
			vistaRef.dispose();
			refM = null;
			
		}
		
	}

}
