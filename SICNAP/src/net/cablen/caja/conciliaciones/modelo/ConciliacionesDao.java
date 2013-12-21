package net.cablen.caja.conciliaciones.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.cablen.caja.referencias.modelo.Referencias;
import net.cablen.helppers.Conexion;
import net.cablen.helppers.Usuario;

public class ConciliacionesDao {

	private int maxId(){
		
		int num_conciliacion = 0;
		
		try {
			
			String sql = "SELECT MAX(id_conciliacion) AS id FROM conciliaciones";
			Statement stmt = Conexion.getSratement();
			ResultSet rset = stmt.executeQuery(sql);
			
			if (rset.next()){
				num_conciliacion = rset.getInt("id");				
				if(num_conciliacion == 0){ // cuando no hay registros hay que crear uno
					num_conciliacion = 999;		
				}
			}
			
			rset.close();
			return num_conciliacion;
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			return -1;
		}
		
	}
	
	
	public int crearConciliacion(){
		
			int incremento = this.maxId();   
			if (incremento > 0){
			   incremento = (incremento + 1);
			   String sql = "INSERT INTO conciliaciones (id_conciliacion,user_sistema,estatus) VALUES (" +
		    		        incremento + ",'" + Usuario.getUser().getLogin() + "',0)" ;
				try {
					Statement stmt = Conexion.getSratement();
					stmt.executeUpdate(sql);
					return incremento;
				} catch (SQLException e) {
					System.out.println(e.toString());
					return -1;
				}
			}else{
				System.out.println("incremento " + incremento );
				return -1;
			}
		
	}
	
	public int findByUserSystem(String user){
		
	
		int num_conciliacion = 0;
		
		try {
			
			String sql = "SELECT id_conciliacion FROM conciliaciones WHERE user_sistema='" + user + "' AND estatus=0";
			Statement stmt = Conexion.getSratement();
			ResultSet rset = stmt.executeQuery(sql);
			
			if (rset.next()){
				
				num_conciliacion = rset.getInt("id_conciliacion");				
			
			}else{
				
				num_conciliacion = 0;
				
			}
			
			rset.close();
			
			return num_conciliacion;
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			return -1;
		}
		
		
	}
	
	public int update(Conciliaciones conciliacion){
		
		int result = 0;
		String sql ="UPDATE  conciliaciones SET " +
				    "id_conciliacion=" + conciliacion.getIdConciliacion() + "," +
			    	"user_sistema='" + conciliacion.getUserSistema() + "'," +
				    "user_caja='" + conciliacion.getUserCaja() + "'," +
				    "fecha_registro='" + conciliacion.getFechaRegistro() + "'," +
				    "monto_final=" + conciliacion.getMontoFinal() + "," +
				    "fecha_caja='" + conciliacion.getFechaCaja() + "'," +
				    "factura_inicial='" + conciliacion.getFacturaInicial() + "'," +
				    "factura_final='" + conciliacion.getFacturaFinal() + "'," +
				    "reporte_z='" +  conciliacion.getReporteZ() + "'," +
				    "monto_z=" + conciliacion.getMontoZ() + "," +
					"maquina_fiscal='" + conciliacion.getMaquinaFiscal() + "'," + 
				    "dife_monto=" +  conciliacion.getDifeMonto() + "," +
					"detalle_error='" + conciliacion.getDetalleError() + "'," +
				    "estatus="+ conciliacion.getEstatus() + "," +
				    "oficina='" + conciliacion.getOficina() + "' " +
				    "WHERE id_conciliacion=" +  conciliacion.getIdConciliacion();
		
		//System.out.println(sql);
		
		try {
			Statement stmt = Conexion.getSratement();
			result = stmt.executeUpdate(sql);
			return result;
		} catch (SQLException e) {
			//System.out.println(sql);
			return -1;
		}
	}
	
	public List<Conciliaciones> listByEstatus(int estatus){
		
		List<Conciliaciones> lista = null;
		
		Conciliaciones objCon = null;
		
		try {
			
			
			String sql = "SELECT * FROM  conciliaciones WHERE estatus=" + estatus;
			Statement stmt = Conexion.getSratement();
			ResultSet rset = stmt.executeQuery(sql);
		
		    lista = new ArrayList<Conciliaciones>();
			
			while (rset.next()){
				objCon = new Conciliaciones();
				objCon.setIdConciliacion(rset.getInt("id_conciliacion"));
				objCon.setUserSistema(rset.getString("user_sistema"));
				objCon.setUserCaja(rset.getString("user_caja"));
				objCon.setFechaRegistro(rset.getString("fecha_registro"));
				objCon.setMontoFinal(rset.getFloat("monto_final"));
				objCon.setFechaCaja(rset.getString("fecha_caja"));
				objCon.setFacturaInicial(rset.getString("factura_inicial"));
				objCon.setFacturaFinal(rset.getString("factura_final"));
				objCon.setReporteZ(rset.getString("reporte_z"));
				objCon.setMontoZ(rset.getFloat("monto_z"));
				objCon.setMaquinaFiscal(rset.getString("maquina_fiscal"));
				objCon.setDifeMonto(rset.getFloat("dife_monto"));
				objCon.setDetalleError(rset.getString("detalle_error"));
				objCon.setEstatus(rset.getInt("estatus"));
				objCon.setOficina(rset.getString("oficina"));
				lista.add(objCon);
				objCon = null;
			}
			
			rset.close();
			return lista;
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			return lista;
		}
		
	}
	
	
	public List<Conciliaciones> listByMaquina(String maquina){
		
		List<Conciliaciones> lista = null;
		
		Conciliaciones objCon = null;
		
		try {
			
			
			String sql = "SELECT * FROM  conciliaciones WHERE maquina_fiscal='" + maquina + "' AND estatus=1";
			//System.out.println(sql);
			Statement stmt = Conexion.getSratement();
			ResultSet rset = stmt.executeQuery(sql);
		
		    lista = new ArrayList<Conciliaciones>();
			
			while (rset.next()){
				objCon = new Conciliaciones();
				objCon.setIdConciliacion(rset.getInt("id_conciliacion"));
				objCon.setUserSistema(rset.getString("user_sistema"));
				objCon.setUserCaja(rset.getString("user_caja"));
				objCon.setFechaRegistro(rset.getString("fecha_registro"));
				objCon.setMontoFinal(rset.getFloat("monto_final"));
				objCon.setFechaCaja(rset.getString("fecha_caja"));
				objCon.setFacturaInicial(rset.getString("factura_inicial"));
				objCon.setFacturaFinal(rset.getString("factura_final"));
				objCon.setReporteZ(rset.getString("reporte_z"));
				objCon.setMontoZ(rset.getFloat("monto_z"));
				objCon.setMaquinaFiscal(rset.getString("maquina_fiscal"));
				objCon.setDifeMonto(rset.getFloat("dife_monto"));
				objCon.setDetalleError(rset.getString("detalle_error"));
				objCon.setEstatus(rset.getInt("estatus"));
				objCon.setOficina(rset.getString("oficina"));
				lista.add(objCon);
				objCon = null;
			}
			
			rset.close();
			return lista;
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			return lista;
		}
		
	}
	
	
	public List<Conciliaciones> listByOficina(String oficina){
		
		List<Conciliaciones> lista = null;
		
		Conciliaciones objCon = null;
		
		try {
			
			
			String sql = "SELECT * FROM  conciliaciones WHERE oficina='" + oficina + "' AND estatus=1";
			//System.out.println(sql);
			Statement stmt = Conexion.getSratement();
			ResultSet rset = stmt.executeQuery(sql);
		
		    lista = new ArrayList<Conciliaciones>();
			
			while (rset.next()){
				objCon = new Conciliaciones();
				objCon.setIdConciliacion(rset.getInt("id_conciliacion"));
				objCon.setUserSistema(rset.getString("user_sistema"));
				objCon.setUserCaja(rset.getString("user_caja"));
				objCon.setFechaRegistro(rset.getString("fecha_registro"));
				objCon.setMontoFinal(rset.getFloat("monto_final"));
				objCon.setFechaCaja(rset.getString("fecha_caja"));
				objCon.setFacturaInicial(rset.getString("factura_inicial"));
				objCon.setFacturaFinal(rset.getString("factura_final"));
				objCon.setReporteZ(rset.getString("reporte_z"));
				objCon.setMontoZ(rset.getFloat("monto_z"));
				objCon.setMaquinaFiscal(rset.getString("maquina_fiscal"));
				objCon.setDifeMonto(rset.getFloat("dife_monto"));
				objCon.setDetalleError(rset.getString("detalle_error"));
				objCon.setEstatus(rset.getInt("estatus"));
				objCon.setOficina(rset.getString("oficina"));
				lista.add(objCon);
				objCon = null;
			}
			
			rset.close();
			return lista;
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			return lista;
		}
		
	}
	
	public List<Conciliaciones> listByUser(String user){
		
		List<Conciliaciones> lista = null;
		
		Conciliaciones objCon = null;
		
		try {
			
			
			String sql = "SELECT * FROM  conciliaciones WHERE user_caja='" + user + "' AND estatus=1";
			//System.out.println(sql);
			Statement stmt = Conexion.getSratement();
			ResultSet rset = stmt.executeQuery(sql);
		
		    lista = new ArrayList<Conciliaciones>();
			
			while (rset.next()){
				objCon = new Conciliaciones();
				objCon.setIdConciliacion(rset.getInt("id_conciliacion"));
				objCon.setUserSistema(rset.getString("user_sistema"));
				objCon.setUserCaja(rset.getString("user_caja"));
				objCon.setFechaRegistro(rset.getString("fecha_registro"));
				objCon.setMontoFinal(rset.getFloat("monto_final"));
				objCon.setFechaCaja(rset.getString("fecha_caja"));
				objCon.setFacturaInicial(rset.getString("factura_inicial"));
				objCon.setFacturaFinal(rset.getString("factura_final"));
				objCon.setReporteZ(rset.getString("reporte_z"));
				objCon.setMontoZ(rset.getFloat("monto_z"));
				objCon.setMaquinaFiscal(rset.getString("maquina_fiscal"));
				objCon.setDifeMonto(rset.getFloat("dife_monto"));
				objCon.setDetalleError(rset.getString("detalle_error"));
				objCon.setEstatus(rset.getInt("estatus"));
				objCon.setOficina(rset.getString("oficina"));
				lista.add(objCon);
				objCon = null;
			}
			
			rset.close();
			return lista;
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			return lista;
		}
		
	}
	
	
public List<Conciliaciones> listByUserSis(String sis){
		
		List<Conciliaciones> lista = null;
		
		Conciliaciones objCon = null;
		
		try {
			
			
			String sql = "SELECT * FROM  conciliaciones WHERE user_sistema='" + sis + "' AND estatus=1";
			//System.out.println(sql);
			Statement stmt = Conexion.getSratement();
			ResultSet rset = stmt.executeQuery(sql);
		
		    lista = new ArrayList<Conciliaciones>();
			
			while (rset.next()){
				objCon = new Conciliaciones();
				objCon.setIdConciliacion(rset.getInt("id_conciliacion"));
				objCon.setUserSistema(rset.getString("user_sistema"));
				objCon.setUserCaja(rset.getString("user_caja"));
				objCon.setFechaRegistro(rset.getString("fecha_registro"));
				objCon.setMontoFinal(rset.getFloat("monto_final"));
				objCon.setFechaCaja(rset.getString("fecha_caja"));
				objCon.setFacturaInicial(rset.getString("factura_inicial"));
				objCon.setFacturaFinal(rset.getString("factura_final"));
				objCon.setReporteZ(rset.getString("reporte_z"));
				objCon.setMontoZ(rset.getFloat("monto_z"));
				objCon.setMaquinaFiscal(rset.getString("maquina_fiscal"));
				objCon.setDifeMonto(rset.getFloat("dife_monto"));
				objCon.setDetalleError(rset.getString("detalle_error"));
				objCon.setEstatus(rset.getInt("estatus"));
				objCon.setOficina(rset.getString("oficina"));
				lista.add(objCon);
				objCon = null;
			}
			
			rset.close();
			return lista;
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			return lista;
		}
		
	}
	
	
	public List<Conciliaciones> listByFiltro(String strSql){
		
		List<Conciliaciones> lista = null;
		
		Conciliaciones objCon = null;
		
		try {
			
			
			String sql = "SELECT * FROM  conciliaciones" + strSql;
			//System.out.println(sql);
			Statement stmt = Conexion.getSratement();
			ResultSet rset = stmt.executeQuery(sql);
		
		    lista = new ArrayList<Conciliaciones>();
			
			while (rset.next()){
				objCon = new Conciliaciones();
				objCon.setIdConciliacion(rset.getInt("id_conciliacion"));
				objCon.setUserSistema(rset.getString("user_sistema"));
				objCon.setUserCaja(rset.getString("user_caja"));
				objCon.setFechaRegistro(rset.getString("fecha_registro"));
				objCon.setMontoFinal(rset.getFloat("monto_final"));
				objCon.setFechaCaja(rset.getString("fecha_caja"));
				objCon.setFacturaInicial(rset.getString("factura_inicial"));
				objCon.setFacturaFinal(rset.getString("factura_final"));
				objCon.setReporteZ(rset.getString("reporte_z"));
				objCon.setMontoZ(rset.getFloat("monto_z"));
				objCon.setMaquinaFiscal(rset.getString("maquina_fiscal"));
				objCon.setDifeMonto(rset.getFloat("dife_monto"));
				objCon.setDetalleError(rset.getString("detalle_error"));
				objCon.setEstatus(rset.getInt("estatus"));
				objCon.setOficina(rset.getString("oficina"));
				lista.add(objCon);
				objCon = null;
			}
			
			rset.close();
			return lista;
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			return lista;
		}
		
	}
	
}
