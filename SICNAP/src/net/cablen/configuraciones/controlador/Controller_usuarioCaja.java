package net.cablen.configuraciones.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import net.cablen.caja.usuarios.modelo.UsuariosCaja;
import net.cablen.caja.usuarios.modelo.UsuariosCajaDao;
import net.cablen.configuraciones.vista.VistaUserCaja;

public class Controller_usuarioCaja implements ActionListener {

	VistaUserCaja vUser = null;
	
	public Controller_usuarioCaja(VistaUserCaja vista) {
		this.vUser=vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == vUser.getBtmGuardar()){
			
			String codigo = "";
			String id ="";
			id = vUser.getTxtID().getText();
			UsuariosCaja user = new UsuariosCaja();
			UsuariosCajaDao dao = new UsuariosCajaDao();
			user.setCodigo(id);
			user.setAlias(id);
			user.setNombre(vUser.getTxtNombre().getText());
			
			if (dao.guardar(user) > 0){
				JOptionPane.showMessageDialog(null, "Datos Almacenados con exito");
				vUser.getTxtID().setText("");
				vUser.getTxtNombre().setText("");
			}else{
				JOptionPane.showMessageDialog(null, "Problemas al almacenar el Cajero");
			}
			
			user = null;
			dao = null;
		}
		
	}
}
