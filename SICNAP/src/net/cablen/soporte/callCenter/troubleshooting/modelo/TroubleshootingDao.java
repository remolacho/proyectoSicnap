package net.cablen.soporte.callCenter.troubleshooting.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.cablen.helppers.Conexion;
import net.cablen.helppers.Usuario;
import net.cablen.helppers.ValidarCampos;
import net.cablen.soporte.actividades.modelo.TshActividades;
import net.cablen.soporte.estatus.modelo.TshEstatus;

public class TroubleshootingDao {

	private long iniciarInc(){
		
		long correlativo=0;
		
		try {
			
			String sql ="SELECT MAX(id_correlativo) as inc FROM troubleshooting";
			Statement stmt = Conexion.getSratement();
			ResultSet rset = stmt.executeQuery(sql);
			
			if (rset.next()){
				correlativo = rset.getLong("inc");				
				if(correlativo == 0){ // cuando no hay registros hay que crear uno
					correlativo =1000;		
				}
			}
			//System.out.println(correlativo);
			rset.close();
			return correlativo;
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			return -1;
		}

	}
	
	public long crearIncidencia(){
		long incremento = this.iniciarInc();   
		if (incremento > 0){
		   incremento = (incremento + 1);
		   String sql = "INSERT INTO troubleshooting (id_correlativo,incidencia,user_sistema,estatus) VALUES (" +
	    		        incremento + ",'INC-" + incremento + "','" + Usuario.getUser().getLogin() + "',0)" ;
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
	
	public long asignarIncidencia(Troubleshooting trou){
		  
		long incremento = 0;
		
	     String sql = "UPDATE troubleshooting SET fecha_apertura='" + trou.getFechaApertura() + "'," +
	                  "id_actividad_tsh=" + trou.getTshActividades().getIdActividad() + "," + 
	    		      "id_estatus_tsh=" + trou.getTshEstatus().getIdEstatus() + "," +
	                  "detalle_reclamo='" + trou.getDetalleReclamo() + "'," +
	    		      "comentario_inicial='" + trou.getComentarioInicial() + "'," + 
	                  "abonado='" + trou.getAbonado() + "'," +
	    		      "estatus=" + trou.getEstatus() + " " + 
	    		      "WHERE estatus=0 AND user_sistema='" + trou.getUserSistema() + "' AND " +
	    		      "id_correlativo=" + trou.getIdCorrelativo();
	     
	    // System.out.println(sql);
	     
		 try {
				Statement stmt = Conexion.getSratement();
				stmt.executeUpdate(sql);
				incremento = this.iniciarInc() + 1; 
				return incremento;
		} catch (SQLException e) {
				System.out.println(e.toString());
				return -1;
		}

	}
	
	
	public long findByUserSystem(String user){
		
		
		long correlativo = 0;
		
		try {
			
			String sql = "SELECT id_correlativo FROM troubleshooting WHERE user_sistema='" + user + "' AND estatus=0";
			Statement stmt = Conexion.getSratement();
			ResultSet rset = stmt.executeQuery(sql);
			
			if (rset.next()){
				correlativo = rset.getLong("id_correlativo");				
			}else{
				correlativo = 0;
			}
			
			rset.close();
			
			return correlativo;
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			return -1;
		}
		
		
	}
	
	public List<Troubleshooting> findIncAbiertas(String strSql){
		
		List<Troubleshooting> lista = null;
		Troubleshooting objTro = null;
		TshActividades objAct = null;
		TshEstatus objEstatus = null;
		try {
			
			//estatus 1000 en callcenter significa abierta ----  categoria cc es call center
			String sql = "SELECT t.*,a.*, e.* FROM troubleshooting t " +
						 "INNER JOIN  tsh_actividades a ON (t.id_actividad_tsh = a.id_actividad) " +
						 "INNER JOIN  tsh_estatus e ON (t.id_estatus_tsh = e.id_estatus) " +
			             " WHERE t.estatus=1 AND t.user_sistema='" + Usuario.getUser().getLogin() + 
			             "' AND t.id_estatus_tsh <= 1001 AND a.categoria='cc' " +  strSql;
			//System.out.println(sql);
			Statement stmt = Conexion.getSratement();
			ResultSet rset = stmt.executeQuery(sql);
		
		    lista  = new ArrayList<Troubleshooting>();
			
			while (rset.next()){
				objTro = new Troubleshooting();
				objAct = new TshActividades();
				objEstatus = new TshEstatus();
				objTro.setIdCorrelativo(rset.getLong("t.id_correlativo"));
				objTro.setIncidencia(rset.getString("t.incidencia"));
				objTro.setUserSistema(rset.getString("t.user_sistema"));
				objTro.setFechaApertura(rset.getString("t.fecha_apertura"));
				objAct.setIdActividad(rset.getInt("t.id_actividad_tsh"));
				objAct.setActividad(rset.getString("a.actividad"));
				objAct.setEstatus(rset.getInt("a.estatus"));
				objAct.setCategoria(rset.getString("a.categoria"));
				objEstatus.setIdEstatus(rset.getInt("t.id_estatus_tsh"));
				objEstatus.setDescripcion(rset.getString("e.descripcion"));
				objEstatus.setEstatus(rset.getInt("e.estatus"));
				objEstatus.setCategoria(rset.getString("e.categoria"));
				objTro.setTshActividades(objAct);
				objTro.setTshEstatus(objEstatus);
				objTro.setDetalleReclamo(rset.getString("t.detalle_reclamo"));
				objTro.setComentarioInicial(rset.getString("t.comentario_inicial"));
				objTro.setAbonado(rset.getString("t.abonado"));
				objTro.setEstatus(rset.getInt("t.estatus"));
				lista.add(objTro);
				objTro = null;
				objAct = null;
				objEstatus = null;
			}
			
			rset.close();
			return lista;
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			return lista;
		}
		
	}
	
	public int cerrarIncidencia(Troubleshooting obj){
		
		int result = 0;
		
	     String sql = "UPDATE troubleshooting SET fecha_cierre='" + ValidarCampos.soloFecha() + "'," +
	                  "comentario_final='" + obj.getComentarioFinal() + "'," + 
	    		      "id_estatus_tsh=" + obj.getTshEstatus().getIdEstatus() + 
	    		      " WHERE estatus=1 AND user_sistema='" + obj.getUserSistema() + "' AND " +
	    		      "incidencia='" + obj.getIncidencia() + "'";
	     
	   // System.out.println(sql);
	     
		 try {
				Statement stmt = Conexion.getSratement();
				result = stmt.executeUpdate(sql);		
		} catch (SQLException e) {
				System.out.println(e.toString());
				result = -1;
		}	
		
		return result;
	}
	
	
	public List<Troubleshooting> findFilter(String strSql){
		
		List<Troubleshooting> lista = null;
		Troubleshooting objTro = null;
		TshActividades objAct = null;
		TshEstatus objEstatus = null;
		try {
			
			//estatus 1000 en callcenter significa abierta ----  categoria cc es call center
			String sql = "SELECT t.*,a.*, e.* FROM troubleshooting t " +
						 "INNER JOIN  tsh_actividades a ON (t.id_actividad_tsh = a.id_actividad) " +
						 "INNER JOIN  tsh_estatus e ON (t.id_estatus_tsh = e.id_estatus) " +
			             " WHERE e.categoria='cc' AND t.estatus=1 " + strSql;
			//System.out.println(sql);
			Statement stmt = Conexion.getSratement();
			ResultSet rset = stmt.executeQuery(sql);
		
		    lista  = new ArrayList<Troubleshooting>();
			
			while (rset.next()){
				objTro = new Troubleshooting();
				objAct = new TshActividades();
				objEstatus = new TshEstatus();
				objTro.setIdCorrelativo(rset.getLong("t.id_correlativo"));
				objTro.setIncidencia(rset.getString("t.incidencia"));
				objTro.setUserSistema(rset.getString("t.user_sistema"));
				objTro.setFechaApertura(rset.getString("t.fecha_apertura"));
				objAct.setIdActividad(rset.getInt("t.id_actividad_tsh"));
				objAct.setActividad(rset.getString("a.actividad"));
				objAct.setEstatus(rset.getInt("a.estatus"));
				objAct.setCategoria(rset.getString("a.categoria"));
				objEstatus.setIdEstatus(rset.getInt("t.id_estatus_tsh"));
				objEstatus.setDescripcion(rset.getString("e.descripcion"));
				objEstatus.setEstatus(rset.getInt("e.estatus"));
				objEstatus.setCategoria(rset.getString("e.categoria"));
				objTro.setTshActividades(objAct);
				objTro.setTshEstatus(objEstatus);
				objTro.setDetalleReclamo(rset.getString("t.detalle_reclamo"));
				objTro.setComentarioInicial(rset.getString("t.comentario_inicial"));
				objTro.setComentarioFinal(rset.getString("t.comentario_final"));
				objTro.setFechaCierre(rset.getString("t.fecha_cierre"));
				objTro.setAbonado(rset.getString("t.abonado"));
				objTro.setEstatus(rset.getInt("t.estatus"));
				lista.add(objTro);
				objTro = null;
				objAct = null;
				objEstatus = null;
			}
			
			rset.close();
			return lista;
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			return lista;
		}
		
	}
	
}
