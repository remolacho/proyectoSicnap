package net.cablen.caja.conciliaciones.controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import net.cablen.caja.conciliaciones.modelo.Conciliacion;
import net.cablen.caja.conciliaciones.modelo.Conciliaciones;
import net.cablen.caja.conciliaciones.vista.VistaConciliacion;
import net.cablen.caja.referencias.vista.AsignarReferencias;
import net.cablen.helppers.Usuario;
import net.cablen.helppers.ValidarCampos;

public class Controller_conciliacion implements ActionListener,KeyListener,InternalFrameListener{

	VistaConciliacion vistaConc = null;
	AsignarReferencias vRef = null;
	
	public Controller_conciliacion(VistaConciliacion vistaC, AsignarReferencias vistaR) {
		this.vistaConc = vistaC;
		this.vRef = vistaR;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
	  
	    	if(e.getSource() == vistaConc.getTxtMontoZ()){
					
	    		if(e.getKeyCode() == 10){
				
	    			float montoZ,recaudo,diferencia;
				
	    			try {
	    				montoZ = Float.parseFloat(vistaConc.getTxtMontoZ().getText().replace(",", "."));

	    			} catch (Exception e2) {
	    				montoZ = 0;
	    			}
				
	    			recaudo = Float.parseFloat(vistaConc.getLblMonto().getText());
	    			diferencia = recaudo - montoZ;
	    			if (diferencia <= -1){
	    				JOptionPane.showMessageDialog(null,"El monto da negativo no se puede proceder a conciliar la caja");
	    				vistaConc.getLblDif().setForeground(Color.RED);
	    				vistaConc.getBtmConciliar().setEnabled(false);
	    			}else{
	    				vistaConc.getLblDif().setForeground(Color.BLACK);	  
	    				vistaConc.getBtmConciliar().setEnabled(true);
	    			}
		    
	    			vistaConc.getLblDif().setText(Float.toString(diferencia));
				
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
	    
			if(e.getSource() == vistaConc.getBtmConciliar()){
			
				String msg ="";
				if(!vistaConc.getTxtFactI().getText().equals("") && !vistaConc.getTxtFactF().getText().equals("")){
				
					if(!vistaConc.getTxtMontoZ().getText().equals("") && !vistaConc.getTxtNumZ().getText().equals("")){
					
						try {
						
							if (!vistaConc.getFechaCaja().getDate().toString().equals("")){
							
								/*Si = 0 No = 1*/
								int respuesta = JOptionPane.showConfirmDialog(null, "Desea conciliar la caja?", "Confirmar Proceso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				           
								if (respuesta == 0){
							
									Conciliacion objConcilia = new Conciliacion();
									Conciliaciones conciliacion = new Conciliaciones();
							
									conciliacion.setDetalleError(vistaConc.getTxtDetalle().getText());
									conciliacion.setDifeMonto(Float.parseFloat(vistaConc.getLblDif().getText()));
									conciliacion.setFacturaFinal(vistaConc.getTxtFactF().getText());
									conciliacion.setFacturaInicial(vistaConc.getTxtFactI().getText());
									conciliacion.setFechaCaja(ValidarCampos.soloFecha(vistaConc.getFechaCaja().getDate()));
									conciliacion.setFechaRegistro(ValidarCampos.soloFecha());
									conciliacion.setIdConciliacion(Integer.parseInt(vistaConc.getLblConciliacion().getText()));
									conciliacion.setMaquinaFiscal(vistaConc.getCmbFiscal().getSelectedItem().toString());
									conciliacion.setMontoFinal(Float.parseFloat(vistaConc.getLblMonto().getText()));
									conciliacion.setMontoZ(Float.parseFloat(vistaConc.getTxtMontoZ().getText().replace(",", ".")));
									conciliacion.setReporteZ(vistaConc.getTxtNumZ().getText());
									conciliacion.setUserCaja(vistaConc.getCmbUserCaja().getSelectedItem().toString());
									conciliacion.setUserSistema(Usuario.getUser().getLogin());
									conciliacion.setOficina(vistaConc.getCmbOficina().getSelectedItem().toString());
									conciliacion.setEstatus(1);
									msg = objConcilia.CerrarConciliacion(conciliacion); 
							
									if (msg.equals("")){
										JOptionPane.showMessageDialog(null, "Se finalizo con exito la conciliacion ");
										if (vRef != null)
											vRef.dispose();
										vistaConc.dispose();
									}else{
								
										JOptionPane.showMessageDialog(null, msg);
								
									}
							
									conciliacion=null;
									objConcilia = null;
								
								}
								
							}	
						
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null,"Debes seleccionar la fecha de el cierre de caja " + e2.toString());
						}
					
					}else{			
						JOptionPane.showMessageDialog(null,"Hay campos vacios Numero Reporte Z");
					}
				
				}else{	
					JOptionPane.showMessageDialog(null,"Hay campos vacios Factura Inicial, Factura Final");		
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
		Conciliacion objC = new Conciliacion();
		vistaConc.getCmbUserCaja().setModel(new DefaultComboBoxModel(objC.cargarUserCaja()));
		vistaConc.getCmbFiscal().setModel(new DefaultComboBoxModel(objC.cargarMaquinasFiscales()));
		vistaConc.getCmbOficina().setModel(new DefaultComboBoxModel(objC.cargarOficinas()));
		objC = null;
	
	}

}
