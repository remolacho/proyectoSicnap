package net.cablen.helppers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Conexion {
	
    private static Statement stmGenerico;
	private static Connection cnn=null;
	
	public static Connection iniciarConexion() throws ClassNotFoundException{
		
		Class.forName("com.mysql.jdbc.Driver");
        String servidor = "jdbc:mysql://10.2.1.50:3306/cable_norte_desarrollo";
        String usuarioDB="cablen";
        String passwordDB="Asystem98jk";
        
        try {
			cnn = DriverManager.getConnection(servidor,usuarioDB,passwordDB);
			stmGenerico = cnn.createStatement();
			System.out.println("Conectado");		
		} catch (SQLException e) {	
			System.out.println(e.toString());	
			JOptionPane.showMessageDialog(null,"Error al conectar con la BD","SICNAPP", 0);	
			return null;
		}
		
		return cnn;
		
	}
	
	public static void desconectar() {
		try {
			stmGenerico.close();
			cnn.close();
			System.out.println("Desconectado de la BD");			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Statement getSratement(){
		
		return stmGenerico;
		
	}

}
