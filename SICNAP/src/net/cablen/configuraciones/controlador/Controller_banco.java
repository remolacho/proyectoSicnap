package net.cablen.configuraciones.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import net.cablen.bancos.modelo.Bancos;
import net.cablen.bancos.modelo.BancosDao;
import net.cablen.configuraciones.vista.VistaBancos;



public class Controller_banco implements ActionListener,InternalFrameListener{

	VistaBancos vBancos;
	
	
	public Controller_banco(VistaBancos vista) {

		this.vBancos = vista;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vBancos.getBtmGuardar()){
			
			String codigo = "";
			String id ="";
			codigo = vBancos.getTxtNombre().getText() + " " + vBancos.getTxtCodigo().getText();
			id = vBancos.getTxtID().getText();
			Bancos banco = new Bancos();
			BancosDao dao = new BancosDao();
			banco.setIdBanco(Integer.parseInt(id));
			banco.setCodigo(codigo);
			banco.setNombre(vBancos.getTxtNombre().getText());
			
			if (dao.guardar(banco) > 0){
				JOptionPane.showMessageDialog(null, "Datos Almacenados con exito");
				vBancos.getTxtID().setText(Integer.toString(dao.maxID()));
				vBancos.getTxtCodigo().setText("");
				vBancos.getTxtNombre().setText("");
			}else{
				JOptionPane.showMessageDialog(null, "Problemas al almacenar el banco");
			}
			
			banco = null;
			dao = null;
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
		
		BancosDao dao = new BancosDao();
		vBancos.getTxtID().setText(Integer.toString(dao.maxID()));
		dao = null;
		
	}

}
