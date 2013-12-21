package net.cablen.principal;

import javax.swing.JOptionPane;

import net.cablen.helppers.Conexion;
import net.cablen.usuario.vista.Login;


public class Iniciar {

	
	public static void main(String[] args) {
		  
		try {
			Conexion.iniciarConexion();
		    Login login = new Login();
		    login.iniciar();
		} catch (ClassNotFoundException e ) {
			JOptionPane.showMessageDialog(null,"Error al conectar con la BD","SICNAPP", 0);	
		}

	}

}
