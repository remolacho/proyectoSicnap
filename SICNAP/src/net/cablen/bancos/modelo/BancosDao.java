package net.cablen.bancos.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.cablen.helppers.Conexion;
import net.cablen.helppers.Usuario;
import net.cablen.oficinas.modelo.Oficinas;

public class BancosDao {
	
	public List<Bancos> lista (){
		
		List<Bancos> lista = null;
	    Bancos banco = null;
		String sql ="SELECT * FROM  bancos";

		try {
			Statement stmt = Conexion.getSratement();
			ResultSet rset;
			rset = stmt.executeQuery(sql);
			lista = new ArrayList<>();
			
			while (rset.next()){	
				banco = new Bancos();
				banco.setIdBanco(rset.getInt("id_banco"));
				banco.setCodigo(rset.getString("codigo"));
				banco.setNombre(rset.getString("nombre"));
				lista.add(banco);
				banco = null;
			}
			
			rset.close();
			return lista;
			
		} catch (SQLException e) {
			return lista;
		}
		
	
	
	}
	
	public int maxID(){
		int id = 1000;
		
		try {
			
			String sql = "SELECT MAX(id_banco) AS id FROM bancos";
			Statement stmt = Conexion.getSratement();
			ResultSet rset = stmt.executeQuery(sql);
			
			if (rset.next()){
				id = rset.getInt("id");				
				if(id == 0){ // cuando no hay registros hay que crear uno
					id = 999;		
				}
			}
			
			rset.close();
			return id + 1;
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			return -1;
		}
	}
	
	public int guardar(Bancos obj){
		int result;
		
		   String sql = "INSERT INTO bancos (id_banco,codigo,nombre) VALUES (" +
	    		        obj.getIdBanco() + ",'" + obj.getCodigo() + "','" + obj.getNombre()  + "')" ;
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
