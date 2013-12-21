package net.cablen.caja.referencias.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.cablen.caja.conciliaciones.modelo.Conciliacion;
import net.cablen.caja.conciliaciones.modelo.Conciliaciones;
import net.cablen.helppers.Conexion;

public class ReferenciasDao {
	
	public List<Referencias> listByCociliacion(int id, int estatus){
		
		List<Referencias> lista = null;
		Referencias objRef = null;
		
		try {
			
			String sql = "SELECT * FROM  referencias WHERE id_conciliacion=" + id + " AND estatus=" + estatus;
			Statement stmt = Conexion.getSratement();
			ResultSet rset = stmt.executeQuery(sql);
			lista = new ArrayList<Referencias>();
		
			while (rset.next()){
				objRef = new Referencias();
				objRef.setReferencia(rset.getString("referencia"));
				objRef.setBanco(rset.getString("banco"));
				objRef.setUserCaja(rset.getString("user_caja"));
				objRef.setMonto(rset.getFloat("monto"));
				objRef.setFechaRegistro(rset.getString("fecha_registro"));
				objRef.setFechaBancaria(rset.getString("fecha_bancaria"));
				objRef.setUserSistema(rset.getString("user_sistema"));
				objRef.setDetalle(rset.getString("detalle"));
				objRef.setTipoDepo(rset.getString("tipo_depo"));
				lista.add(objRef);
				objRef = null;
			}
			
			rset.close();
			return lista;
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			return lista;
		}
		
	}
	
	public List<Referencias> listByFiltro(String strSql){
		
		List<Referencias> lista = null;
		Referencias objRef = null;
		Conciliaciones conciliacion = null;
		
		try {
			
			String sql = "SELECT * FROM  referencias WHERE estatus=1 " + strSql + " ORDER BY id_conciliacion";
			//System.out.println(sql);
			Statement stmt = Conexion.getSratement();
			ResultSet rset = stmt.executeQuery(sql);
			lista = new ArrayList<Referencias>();
		
			while (rset.next()){
				objRef = new Referencias();
				conciliacion = new Conciliaciones();
				objRef.setReferencia(rset.getString("referencia"));
				objRef.setBanco(rset.getString("banco"));
				objRef.setUserCaja(rset.getString("user_caja"));
				objRef.setMonto(rset.getFloat("monto"));
				objRef.setFechaRegistro(rset.getString("fecha_registro"));
				objRef.setFechaBancaria(rset.getString("fecha_bancaria"));
				objRef.setUserSistema(rset.getString("user_sistema"));
				objRef.setDetalle(rset.getString("detalle"));
				objRef.setTipoDepo(rset.getString("tipo_depo"));
				conciliacion.setIdConciliacion(rset.getInt("id_conciliacion"));
				objRef.setConciliaciones(conciliacion);
				lista.add(objRef);
				objRef = null;
				conciliacion = null;
			}
			
			rset.close();
			return lista;
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			return lista;
		}
		
	}
	
	public List<Referencias> listByReferencian(String ref, int estatus){
		
		List<Referencias> lista = null;
		Referencias objRef = null;
		
		try {
			
			String sql = "SELECT * FROM  referencias WHERE referencia LIKE '%" + ref + "%' AND estatus=" + estatus;
			Statement stmt = Conexion.getSratement();
			ResultSet rset = stmt.executeQuery(sql);
			lista = new ArrayList<Referencias>();
		
			while (rset.next()){
				objRef = new Referencias();
				objRef.setReferencia(rset.getString("referencia"));
				objRef.setBanco(rset.getString("banco"));
				objRef.setUserCaja(rset.getString("user_caja"));
				objRef.setMonto(rset.getFloat("monto"));
				objRef.setFechaRegistro(rset.getString("fecha_registro"));
				objRef.setFechaBancaria(rset.getString("fecha_bancaria"));
				objRef.setUserSistema(rset.getString("user_sistema"));
				objRef.setDetalle(rset.getString("detalle"));
				objRef.setTipoDepo(rset.getString("tipo_depo"));
				lista.add(objRef);
				objRef = null;
			}
			
			rset.close();
			return lista;
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			return lista;
		}
		
	}
	
	public int agregar(Referencias ref){
		
		int result = 0;
		String sql = "INSERT INTO referencias (referencia,banco,user_caja,monto,fecha_registro," +
				     "fecha_bancaria,user_sistema,detalle,id_conciliacion," +
				     "estatus,tipo_depo) VALUES ('" + 
				     ref.getReferencia() + "','" +
				     ref.getBanco() + "',''," +
				     ref.getMonto() + ",'" + 
				     ref.getFechaRegistro() + "','" + 
				     ref.getFechaBancaria() + "','" +
				     ref.getUserSistema() +"','" + 
				     ref.getDetalle() + "'," +
				     ref.getConciliaciones().getIdConciliacion() + "," + 
				     ref.getEstatus() + ",'" + 
				     ref.getTipoDepo() + "')";

		try {
			Statement stmt = Conexion.getSratement();
			result = stmt.executeUpdate(sql);
			return result;
		} catch (SQLException e) {
			return -1;
		}
		
	}
	
	
	public int updateUserEstatus(String user, int id){
		
		int result = 0;
		String sql = "UPDATE referencias set estatus=1, user_caja='" + user + "' WHERE id_conciliacion=" + id;
		
		try {
			Statement stmt = Conexion.getSratement();
			result = stmt.executeUpdate(sql);
			return result;
		} catch (SQLException e) {
			System.out.println(sql);
			System.out.println(e.toString());
			return -1;
		}
		
	}
	
	
	public int UpdateRefErr(){
		
		int result = 0;
		int correlativo = 0;
		correlativo = this.buscarRefErr() + 1;
		
		
		try {
			
		    if (correlativo > 0){
		    	String sql = "UPDATE referenciaerronea SET correlativo=" + correlativo +" WHERE id=1000";
		    	Statement stmt = Conexion.getSratement();
				result = stmt.executeUpdate(sql);
		    }else{ 	
		    	result = -1;	
		    }
			
			return result;
			
		} catch (SQLException e) {
			
			return -1;
	
		}
		
	}
	
	public int buscarRefErr(){
		
		try {
			int refrr = 0;
			String sql = "SELECT correlativo  FROM  referenciaerronea WHERE id=1000";
			Statement stmt = Conexion.getSratement();
			ResultSet rset = stmt.executeQuery(sql);
		
			if (rset.next()){
				refrr = rset.getInt("correlativo");
			}
			
			rset.close();
			return refrr;
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			return -1;
		}
		
	}
	
	

}
