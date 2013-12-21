package net.cablen.soporte.actividades.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.cablen.helppers.Conexion;

public class TshActividadesDao {

	public List<TshActividades> listaActividadesCC(){
		
		List<TshActividades> lista = null;
		TshActividades objAct = null;
		
		try {
			
			
			String sql = "SELECT * FROM tsh_actividades WHERE estatus=1 AND categoria='cc'";
			//System.out.println(sql);
			Statement stmt = Conexion.getSratement();
			ResultSet rset = stmt.executeQuery(sql);
		
		    lista  = new ArrayList<TshActividades>();
			
			while (rset.next()){
				objAct = new TshActividades();
				objAct.setIdActividad(rset.getInt("id_actividad"));
				objAct.setActividad(rset.getString("actividad"));
				objAct.setEstatus(rset.getInt("estatus"));
				objAct.setCategoria(rset.getString("categoria"));
				lista.add(objAct);
				objAct = null;
			}
			
			rset.close();
			return lista;
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			return lista;
		}
		
	}
	
	public List<TshActividades> listaActividadesCA(){
		
		List<TshActividades> lista = null;
		TshActividades objAct = null;
		
		try {
			
			
			String sql = "SELECT * FROM tsh_actividades WHERE estatus=1 AND categoria='ca'";
			//System.out.println(sql);
			Statement stmt = Conexion.getSratement();
			ResultSet rset = stmt.executeQuery(sql);
		
		    lista  = new ArrayList<TshActividades>();
			
			while (rset.next()){
				objAct = new TshActividades();
				objAct.setIdActividad(rset.getInt("id_actividad"));
				objAct.setActividad(rset.getString("actividad"));
				objAct.setEstatus(rset.getInt("estatus"));
				objAct.setCategoria(rset.getString("categoria"));
				lista.add(objAct);
				objAct = null;
			}
			
			rset.close();
			return lista;
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			return lista;
		}
		
	}
	
}
