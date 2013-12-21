package net.cablen.soporte.estatus.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.cablen.helppers.Conexion;

public class TshEstatusDao {

	public List<TshEstatus> listaEstatusCC(){
		
		List<TshEstatus> lista = null;
		
		TshEstatus objEst = null;
		
		try {
			
			
			String sql = "SELECT * FROM tsh_estatus WHERE estatus=1 AND categoria='cc' AND id_estatus > 1002";
			//System.out.println(sql);
			Statement stmt = Conexion.getSratement();
			ResultSet rset = stmt.executeQuery(sql);
		
		    lista  = new ArrayList<TshEstatus>();
			
			while (rset.next()){
				objEst = new TshEstatus();
				objEst.setIdEstatus(rset.getInt("id_estatus"));
				objEst.setDescripcion(rset.getString("descripcion"));
				objEst.setEstatus(rset.getInt("estatus"));		
				objEst.setCategoria(rset.getString("categoria"));	
				lista.add(objEst);
				objEst = null;
			}
			
			rset.close();
			return lista;
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			return lista;
		}
		
	}
	
public List<TshEstatus> listaEstatusCA(){
		
		List<TshEstatus> lista = null;
		
		TshEstatus objEst = null;
		
		try {
			
			
			String sql = "SELECT * FROM tsh_estatus WHERE estatus=1 AND categoria='ca' AND id_estatus > 1002";
			//System.out.println(sql);
			Statement stmt = Conexion.getSratement();
			ResultSet rset = stmt.executeQuery(sql);
		
		    lista  = new ArrayList<TshEstatus>();
			
			while (rset.next()){
				objEst = new TshEstatus();
				objEst.setIdEstatus(rset.getInt("id_estatus"));
				objEst.setDescripcion(rset.getString("descripcion"));
				objEst.setEstatus(rset.getInt("estatus"));		
				objEst.setCategoria(rset.getString("categoria"));
				lista.add(objEst);
				objEst = null;
			}
			
			rset.close();
			return lista;
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			return lista;
		}
		
	}
	
}
