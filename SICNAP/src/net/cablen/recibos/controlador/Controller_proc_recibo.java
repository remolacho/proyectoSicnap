package net.cablen.recibos.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import net.cablen.helppers.Usuario;
import net.cablen.helppers.ValidarCampos;
import net.cablen.recibos.modelo.DetalleRecibos;
import net.cablen.recibos.modelo.Recibo;
import net.cablen.recibos.modelo.RecibosPromotor;
import net.cablen.recibos.vista.VistaProcRecibos;

public class Controller_proc_recibo implements ActionListener,InternalFrameListener{

	VistaProcRecibos vProc = null;
	
	public Controller_proc_recibo(VistaProcRecibos vista) {
	
		this.vProc = vista;
		
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
		
		this.vProc.getLblFecha().setText(ValidarCampos.soloFecha());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==vProc.getBtmProcesar()){
			
			String result ="";
			
			if (vProc.getTxtFechaR().getDate() != null){
				
				if (!vProc.getTxtAbonado().getText().equals("") && !vProc.getTxtMonto().getText().equals("") && 
					!vProc.getTxtCajero().getText().equals("")) {
					
					DetalleRecibos detalle = new DetalleRecibos();
					RecibosPromotor reciboPromotor = new RecibosPromotor();
					Recibo recibo = new Recibo();
				
					reciboPromotor.setCodigoRecibo(Long.parseLong(vProc.getLblRecibo().getText()));
					detalle.setRecibosPromotor(reciboPromotor);
					detalle.setAbonado(vProc.getTxtAbonado().getText());
					detalle.setTitular(vProc.getTxtTitular().getText());
					detalle.setTelefono(vProc.getTxtTelefono().getText());
					detalle.setFechaProceso(ValidarCampos.soloFecha());
					detalle.setFechaRecibo(ValidarCampos.soloFecha(vProc.getTxtFechaR().getDate()));
					detalle.setMonto(Float.parseFloat(vProc.getTxtMonto().getText().replace(",", ".")));
					detalle.setUserCaja(vProc.getTxtCajero().getText());
					detalle.setUserSistema(Usuario.getUser().getLogin());
					detalle.setEstatus(1);
					result = recibo.procesarRecibo(detalle);
					JOptionPane.showMessageDialog(null,result);
					vProc.dispose();
					detalle=null;
					recibo=null;
					reciboPromotor=null;
					
				}else{
					JOptionPane.showMessageDialog(null,"Agregar los campos que se encuentran vacios");
				}					
			}else{				
				JOptionPane.showMessageDialog(null,"Seleccion la fecha");				
			}
		}
		
	}
	
}
