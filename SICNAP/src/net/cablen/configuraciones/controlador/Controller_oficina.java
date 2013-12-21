package net.cablen.configuraciones.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import net.cablen.configuraciones.vista.VistaOficina;
import net.cablen.oficinas.modelo.Oficinas;
import net.cablen.oficinas.modelo.OficinasDao;

public class Controller_oficina implements ActionListener,InternalFrameListener{
   
	VistaOficina vOfivcina = null;
	
	public Controller_oficina(VistaOficina vista) {
	
		this.vOfivcina = vista;
	
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
		OficinasDao dao = new OficinasDao();
		vOfivcina.getTxtID().setText(Integer.toString(dao.maxID()));
		dao = null;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	if (e.getSource() == vOfivcina.getBtmGuardar()){
			

			String id ="";
			id = vOfivcina.getTxtID().getText();
			Oficinas oficina = new Oficinas();
			OficinasDao dao = new OficinasDao();
			oficina.setIdOficina(Integer.parseInt(id));
			oficina.setOficina(vOfivcina.getTxtNombre().getText());
			oficina.setPunto(vOfivcina.getTxtPunto().getText());
			
			if (dao.guardar(oficina) > 0){
				JOptionPane.showMessageDialog(null, "Datos Almacenados con exito");
				vOfivcina.getTxtID().setText(Integer.toString(dao.maxID()));
				vOfivcina.getTxtNombre().setText("");
				vOfivcina.getTxtPunto().setText("");
			}else{
				JOptionPane.showMessageDialog(null, "Problemas al almacenar la oficina");
			}
			
			oficina = null;
			dao = null;
		}
		
	}
}
