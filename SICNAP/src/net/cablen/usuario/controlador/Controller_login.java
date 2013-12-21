package net.cablen.usuario.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import net.cablen.helppers.Conexion;
import net.cablen.helppers.Usuario;
import net.cablen.principal.vistas.VisorMDI;
import net.cablen.usuario.modelo.Usuarios;
import net.cablen.usuario.modelo.UsuariosDao;
import net.cablen.usuario.vista.Login;

public class Controller_login implements WindowListener,ActionListener,KeyListener {
    
	Login vLogin;
	int intentos = 0;
	
	public Controller_login(Login vista) {
	   this.vLogin = vista;
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		Conexion.desconectar();
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == vLogin.getBtmSalir()){
			
			vLogin.dispose();
		    Conexion.desconectar();
		}
		
		if(e.getSource() == vLogin.getBtmOk()){
		
			intentos ++;
			Usuarios user = new Usuarios();
			Usuarios resulUser = null;
			UsuariosDao userDao = new UsuariosDao();
			
			user.setLogin(vLogin.getTxtLogin().getText());
			user.setClave(vLogin.getTxtPass().getText());
			
			resulUser = userDao.validarAcceso(user);
			
			if(intentos <= 3){
				if (resulUser != null){
					
					if (resulUser.getPrivilegios().getId() > 0){
			
						//VistaMDI mdi = new VistaMDI();
						Usuario.setUser(resulUser);
						VisorMDI.getFrmMenu().inicializar();
						vLogin.dispose();
				
					}else{
				
						JOptionPane.showMessageDialog(null,"Acceso Denegado","SICNAPP",0);
				
					}
					
				}else{
					
					JOptionPane.showMessageDialog(null,"Acceso Denegado","SICNAPP",0);
					
				}
				
			}else{
				
				JOptionPane.showMessageDialog(null,"Intente mas tarde","SICNAPP",0);
				vLogin.dispose();
			    Conexion.desconectar();
				
			}
			
			
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		int limite=12;
	
		if (e.getSource() == vLogin.getTxtLogin()){
			
			if(vLogin.getTxtLogin().getText().length() > limite){
				
				e.consume();
				
			}
			
		}
		
	}

}
