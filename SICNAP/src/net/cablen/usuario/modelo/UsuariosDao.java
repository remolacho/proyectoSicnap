package net.cablen.usuario.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.cablen.helppers.Conexion;

public class UsuariosDao {

	public Usuarios validarAcceso(Usuarios user){
	
		Statement stmt;
		String pass="";
		int estatus = 0;
		
		try {
			
			Privilegios priv = new Privilegios();
			stmt = Conexion.getSratement();
			ResultSet rset = stmt.executeQuery
					 ("SELECT * FROM usuarios WHERE login='" + user.getLogin() +
				      "' AND clave='" + user.getClave() + "'");
			 
			 if (rset.next()){
				pass = rset.getString("clave");
				estatus = rset.getInt("estatus");
				
				if (pass.equals(user.getClave()) && estatus > 0 ){
					
					user.setId(rset.getInt("id"));
					user.setCedula(rset.getString("cedula"));
					user.setNombre(rset.getString("nombre"));
					user.setApellido(rset.getString("apellido"));
					user.setTelefono(rset.getString("telefono"));
					user.setClave(rset.getString("clave"));			
					user.setLogin(rset.getString("login"));
					user.setEstatus(rset.getInt("estatus"));
					priv.setId(rset.getInt("id_privilegio"));
					user.setPrivilegios(priv);
					rset.close();
					
					return user;
					
				}else{
					rset.close();
					return null;
				}
				
			}else {
				rset.close();
				return null;
			}  
				
		} catch (SQLException e) {
			System.out.println(e.toString() + "Error user");
			return null;
		}
			
	}
	
	public List<Usuarios> lista(){
		
		List<Usuarios> lista = null;
		Usuarios user = null;
		Privilegios priv = null;
		
		try {
			
			String sql = "SELECT * FROM  usuarios";
			Statement stmt = Conexion.getSratement();
			ResultSet rset = stmt.executeQuery(sql);
			lista = new ArrayList<Usuarios>();
		
			while (rset.next()){
				user = new Usuarios();
				priv = new Privilegios();
				user.setId(rset.getInt("id"));
				user.setCedula(rset.getString("cedula"));
				user.setNombre(rset.getString("nombre"));
				user.setApellido(rset.getString("apellido"));
				user.setTelefono(rset.getString("telefono"));
				user.setClave(rset.getString("clave"));			
				user.setLogin(rset.getString("login"));
				user.setEstatus(rset.getInt("estatus"));
				priv.setId(rset.getInt("id_privilegio"));
				user.setPrivilegios(priv);
				lista.add(user);
				user = null;
				priv = null;
				
			}
			
			rset.close();
			return lista;
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			return lista;
		}
		
	}
	
}
