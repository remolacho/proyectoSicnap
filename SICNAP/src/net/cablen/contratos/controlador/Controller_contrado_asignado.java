package net.cablen.contratos.controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import net.cablen.contratos.modelo.Contratos;
import net.cablen.contratos.vista.VistaContratoAsignad;
import net.cablen.contratos.ws.Abonado;

public class Controller_contrado_asignado implements KeyListener {

	VistaContratoAsignad vContAsig;
	
	public Controller_contrado_asignado(VistaContratoAsignad vista) {
		// TODO Auto-generated constructor stub
		vContAsig = vista;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getSource() == vContAsig.getTxtContrato()){
			
			int tope = 9;
			int tamano = 0;
			int iterar = 0;
			String cerosIzq ="";
			
			if (e.getKeyCode() == 10){
				
				Contratos contrato = new Contratos();
				try {
					tamano = vContAsig.getTxtContrato().getText().length();
					iterar = tope - tamano;
					
					for (int i=0;i<iterar;i++){
						cerosIzq = cerosIzq + "0";
					}
					//System.out.println(valor + vContAsig.getTxtContrato().getText());
					Abonado abonado = contrato.wsAbonado(cerosIzq + vContAsig.getTxtContrato().getText());
					this.newAbonado();
					
					if (abonado.getError() == 0){
						
						vContAsig.getLblContrato().setText(abonado.getContrato());
						vContAsig.getLblAbonado().setText(abonado.getAbonado());
						vContAsig.getLblFecha().setText(abonado.getFechAlta());
						vContAsig.getLblNombre().setText(abonado.getNomCompleto());
						vContAsig.getLblSector().setText(abonado.getSector());
						vContAsig.getLblError().setText(Integer.toString(abonado.getError()));
						vContAsig.getLblMensaje().setText(abonado.getDescError());
						
					}else {
						
						vContAsig.getLblError().setText(Integer.toString(abonado.getError()));
						vContAsig.getLblMensaje().setText(abonado.getDescError());
						
					}
					
				} catch (RemoteException e1) {
					JOptionPane.showMessageDialog(null,"Servicio AbonadoPorContratos error " + e1.toString());
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
		
	}

	private void newAbonado(){
		
		vContAsig.getLblContrato().setText("________");
		vContAsig.getLblAbonado().setText("________");
		vContAsig.getLblFecha().setText("________");
		vContAsig.getLblNombre().setText("________");
		vContAsig.getLblSector().setText("________");
		
	}
	
}
