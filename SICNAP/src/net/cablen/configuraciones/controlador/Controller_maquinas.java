package net.cablen.configuraciones.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import net.cablen.caja.maquinaFiscal.modelo.MaquinasFiscales;
import net.cablen.caja.maquinaFiscal.modelo.MaquinasFiscalesDao;
import net.cablen.configuraciones.vista.VistaMaquinas;

public class Controller_maquinas implements ActionListener,InternalFrameListener{
	
	VistaMaquinas vMaquinas = null;
	
	public Controller_maquinas(VistaMaquinas vista) {
		vMaquinas = vista;
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
		MaquinasFiscalesDao dao = new MaquinasFiscalesDao();
		vMaquinas.getTxtID().setText(Integer.toString(dao.maxID()));
		dao = null;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vMaquinas.getBtmGuardar()){
			
			String codigo = "";
			String id ="";
			id = vMaquinas.getTxtID().getText();
			MaquinasFiscales maquina = new MaquinasFiscales();
			MaquinasFiscalesDao dao = new MaquinasFiscalesDao();
			maquina.setId(Integer.parseInt(id));
			maquina.setSerial(vMaquinas.getTxtNombre().getText());
			
			if (dao.guardar(maquina) > 0){
				JOptionPane.showMessageDialog(null, "Datos Almacenados con exito");
				vMaquinas.getTxtID().setText(Integer.toString(dao.maxID()));
				vMaquinas.getTxtNombre().setText("");
			}else{
				JOptionPane.showMessageDialog(null, "Problemas al almacenar la maquina");
			}
			
			maquina = null;
			dao = null;
		}
		
	}

}
