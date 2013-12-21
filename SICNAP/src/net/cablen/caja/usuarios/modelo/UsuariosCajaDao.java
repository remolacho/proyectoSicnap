package net.cablen.caja.usuarios.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.cablen.bancos.modelo.Bancos;
import net.cablen.helppers.Conexion;

public class UsuariosCajaDao {

	public List<UsuariosCaja> lista (){
		
		List<UsuariosCaja> lista = null;
	    UsuariosCaja user = null;
		String sql ="SELECT * FROM  usuarios_caja";

		try {
			Statement stmt = Conexion.getSratement();
			ResultSet rset;
			rset = stmt.executeQuery(sql);
			lista = new ArrayList<>();
			while (rset.next()){	
				user = new UsuariosCaja();
				user.setCodigo(rset.getString("codigo"));
				user.setAlias(rset.getString("alias"));
				user.setNombre(rset.getString("nombre"));
				lista.add(user);
				user = null;
			}
			
			rset.close();
			return lista;
			
		} catch (SQLException e) {
			return lista;
		}
	
	}
	
	
	public int guardar(UsuariosCaja obj){
		int result;
		
		   String sql = "INSERT INTO usuarios_caja (codigo,alias,nombre) VALUES ('" +
	    		        obj.getCodigo() + "','" + obj.getAlias() + "','" + obj.getNombre()  + "')" ;
			try {
				Statement stmt = Conexion.getSratement();
				result = stmt.executeUpdate(sql);
				return result;
			} catch (SQLException e) {
				System.out.println(e.toString());
				return -1;
			}
	}
	
}
