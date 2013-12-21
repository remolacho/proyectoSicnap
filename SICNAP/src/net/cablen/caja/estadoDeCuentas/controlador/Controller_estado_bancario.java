package net.cablen.caja.estadoDeCuentas.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import net.cablen.caja.estadoDeCuentas.modelo.EstadoDeCuentas;
import net.cablen.caja.estadoDeCuentas.vista.VistaCargarEstados;

public class Controller_estado_bancario implements ActionListener{

	VistaCargarEstados vEdoBan;
	File fileExcel;
	
	public Controller_estado_bancario(VistaCargarEstados vista) {
	
		this.vEdoBan  = vista;
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource() == vEdoBan.getBtmExaminar()) {

			JFileChooser dialogo = new JFileChooser();
			int returnVal = dialogo.showOpenDialog(vEdoBan);
		
			if (returnVal == dialogo.APPROVE_OPTION){
				
				fileExcel = dialogo.getSelectedFile();
				vEdoBan.getLblPath().setText(fileExcel.toString());
				vEdoBan.getBtmSubir().setEnabled(true);
				fileExcel = null;
				
			}
		}
		
		
		if (e.getSource() == vEdoBan.getBtmSubir()){
			
			EstadoDeCuentas con = new EstadoDeCuentas();
			con.cargarEstado(vEdoBan.getLblPath().getText());
			
		}
		
		
	}
}
