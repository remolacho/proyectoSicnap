package net.cablen.caja.maquinaFiscal.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.cablen.bancos.modelo.Bancos;
import net.cablen.caja.usuarios.modelo.UsuariosCaja;
import net.cablen.helppers.Conexion;

public class MaquinasFiscalesDao {

public List<MaquinasFiscales> lista (){
		
		List<MaquinasFiscales> lista = null;
	    MaquinasFiscales maquina = null;
		String sql ="SELECT * FROM   maquinas_fiscales";

		try {
			Statement stmt = Conexion.getSratement();
			ResultSet rset;
			rset = stmt.executeQuery(sql);
			lista = new ArrayList<>();
			while (rset.next()){	
				maquina = new MaquinasFiscales();
				maquina.setId(rset.getInt("id"));
				maquina.setSerial(rset.getString("serial"));
				lista.add(maquina);
				maquina = null;
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
		
		String sql = "SELECT MAX(id) AS idF FROM maquinas_fiscales";
		Statement stmt = Conexion.getSratement();
		ResultSet rset = stmt.executeQuery(sql);
		
		if (rset.next()){
			id = rset.getInt("idF");				
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

public int guardar(MaquinasFiscales obj){
	int result;
	
	   String sql = "INSERT INTO  maquinas_fiscales (id,serial) VALUES (" +
    		        obj.getId() + ",'" + obj.getSerial() + "')" ;
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
