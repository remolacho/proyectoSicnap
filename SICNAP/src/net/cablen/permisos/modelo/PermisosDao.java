package net.cablen.permisos.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.cablen.helppers.Conexion;
import net.cablen.helppers.Usuario;
import net.cablen.promotor.modelo.Promotores;
import net.cablen.usuario.modelo.Usuarios;

public class PermisosDao {

	
	public int Acceso(String clase){
		
		Usuarios user =  Usuario.getUser();
		int result = 0;
		String sql= "SELECT * FROM permisos WHERE formulario='" + clase + "' AND id_privilegio=" + user.getPrivilegios().getId();
		//System.out.println(sql);
		Statement stmt;
		try {
			
			stmt = Conexion.getSratement();
			ResultSet rset = stmt.executeQuery
					 (sql);
			
			if (rset.next()){
				result = 1;
			}else {
				result = 0;	
			} 
			
			 rset.close();
						
		} catch (SQLException e) {
			System.out.println(e.toString() + " error");	
			result = 0;
		}
		
		
        return result;
		
		
	}
	
	
}
