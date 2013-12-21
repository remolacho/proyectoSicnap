package net.cablen.oficinas.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.cablen.caja.maquinaFiscal.modelo.MaquinasFiscales;
import net.cablen.helppers.Conexion;

public class OficinasDao {

	public List<Oficinas> lista (){
		
		List<Oficinas> lista = null;
	    Oficinas oficina = null;
		String sql ="SELECT * FROM  oficinas";

		try {
			Statement stmt = Conexion.getSratement();
			ResultSet rset;
			rset = stmt.executeQuery(sql);
			lista = new ArrayList<>();
			while (rset.next()){	
				oficina = new Oficinas();
				oficina.setIdOficina(rset.getInt("id_oficina"));
				oficina.setOficina(rset.getString("oficina"));
				oficina.setPunto(rset.getString("punto"));
				lista.add(oficina);
				oficina = null;
			}
			
			rset.close();
			return lista;
			
		} catch (SQLException e) {
			return lista;
		}
	}
	
	
public List<Oficinas> listaByFiltro (String like){
		
		List<Oficinas> lista = null;
	    Oficinas oficina = null;
		String sql ="SELECT * FROM  oficinas WHERE oficina LIKE '%" + like + "%'";

		try {
			Statement stmt = Conexion.getSratement();
			ResultSet rset;
			rset = stmt.executeQuery(sql);
			lista = new ArrayList<>();
			while (rset.next()){	
				oficina = new Oficinas();
				oficina.setIdOficina(rset.getInt("id_oficina"));
				oficina.setOficina(rset.getString("oficina"));
				oficina.setPunto(rset.getString("punto"));
				lista.add(oficina);
				oficina = null;
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
			
			String sql = "SELECT MAX(id_oficina) AS id FROM oficinas";
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

	public int guardar(Oficinas obj){
		int result;
		
		   String sql = "INSERT INTO  oficinas (id_oficina,oficina,punto) VALUES (" +
	    		        obj.getIdOficina() + ",'" + obj.getOficina() + "','" + obj.getPunto() + "')" ;
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
