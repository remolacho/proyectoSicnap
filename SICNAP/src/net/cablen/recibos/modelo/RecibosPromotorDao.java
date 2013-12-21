package net.cablen.recibos.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.cablen.helppers.Conexion;
import net.cablen.helppers.Usuario;
import net.cablen.helppers.ValidarCampos;
import net.cablen.precintos.modelo.PrecintosPromotor;
import net.cablen.promotor.modelo.PromotoresDao;

public class RecibosPromotorDao {

	public int guardar(RecibosPromotor rProm) { 

		int id = 0;  
		Statement stmt = Conexion.getSratement();

		try {
			
			String sql = "INSERT INTO  recibos_promotor (" + 
                    	 "codigo_recibo,codigo_promotor,fecha_registro," +
                    	 "estatus) VALUES (" +
                    	 rProm.getCodigoRecibo() + "," +
                    	 rProm.getPromotor().getCodPromotor() + ",'" +
                    	 rProm.getFechaRegistro()  + "'," +
                    	 rProm.getEstatus() + ")";
			
			id = stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			return -2;
		}
		
		return id;
          
    }  
	
	
	public int updateEstatus(RecibosPromotor rProm){
		
		
		int id = 0;  
		Statement stmt = Conexion.getSratement();

		try {
			
			String sql = "UPDATE  recibos_promotor SET " + 
                    	 "estatus=1,fecha_proceso='" + ValidarCampos.soloFecha()  + "' " +
                    	 "WHERE codigo_recibo=" + rProm.getCodigoRecibo();
           // System.out.println(sql);        	
			id = stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			return -2;
		}
		
		return id;
		
		
	}
	
	public List<RecibosPromotor> listByEstatus(int estatus){
		
		    List<RecibosPromotor> listaRecibos = new ArrayList<RecibosPromotor>(); 
			RecibosPromotor recibo;
			Statement stmt = Conexion.getSratement();
			
			ArrayList<Integer> codigo_promotor = new ArrayList<>();
			
			try {
				
				
				ResultSet rset = stmt.executeQuery(	"SELECT * FROM  recibos_promotor WHERE estatus=" + estatus);
				
				PromotoresDao promotorDao = new PromotoresDao();
				
				while (rset.next()){
					recibo = new RecibosPromotor();
					recibo.setId(rset.getInt("id"));
					recibo.setCodigoRecibo(rset.getLong("codigo_recibo"));
					recibo.setEstatus(rset.getInt("estatus"));
					recibo.setFechaProceso(rset.getString("fecha_proceso"));
					recibo.setFechaRegistro(rset.getString("fecha_registro"));
					codigo_promotor.add(rset.getInt("codigo_promotor"));
					listaRecibos.add(recibo);
					recibo = null;
				}   
				
				rset.close();
				
				for (int i=0;i<listaRecibos.size();i++){
					
					listaRecibos.get(i).setPromotor(promotorDao.findById(codigo_promotor.get(i)));
					
				}

				codigo_promotor = null;
				
				promotorDao = null;
		
			} catch (SQLException e) {
				System.out.println(e.toString() + " Error Contratos Promotor Dao findByProcess");		
			}
			
	        
	        return listaRecibos;
		
	}
	
	public List<RecibosPromotor> listByPromotor(int cProm, int estatus){
		
	    List<RecibosPromotor> listaRecibos = new ArrayList<RecibosPromotor>(); 
		RecibosPromotor recibo;
		Statement stmt = Conexion.getSratement();
		
		ArrayList<Integer> codigo_promotor = new ArrayList<>();
		
		try {
			
			
			ResultSet rset = stmt.executeQuery("SELECT * FROM  recibos_promotor WHERE estatus=" + estatus + " AND codigo_promotor=" + cProm);
			
			PromotoresDao promotorDao = new PromotoresDao();
			
			while (rset.next()){
				recibo = new RecibosPromotor();
				recibo.setId(rset.getInt("id"));
				recibo.setCodigoRecibo(rset.getLong("codigo_recibo"));
				recibo.setEstatus(rset.getInt("estatus"));
				recibo.setFechaProceso(rset.getString("fecha_proceso"));
				recibo.setFechaRegistro(rset.getString("fecha_registro"));
				codigo_promotor.add(rset.getInt("codigo_promotor"));
				listaRecibos.add(recibo);
				recibo = null;
			}   
			
			rset.close();
			
			for (int i=0;i<listaRecibos.size();i++){
				
				listaRecibos.get(i).setPromotor(promotorDao.findById(codigo_promotor.get(i)));
				
			}

			codigo_promotor = null;
			
			promotorDao = null;
	
		} catch (SQLException e) {
			System.out.println(e.toString() + " Error Contratos Promotor Dao findByProcess");		
		}
		
        
        return listaRecibos;
	
	}
	
	public List<RecibosPromotor> listByRecibo(long numRecibo, int estatus){
		
	    List<RecibosPromotor> listaRecibos = new ArrayList<RecibosPromotor>(); 
		RecibosPromotor recibo;
		Statement stmt = Conexion.getSratement();
		
		ArrayList<Integer> codigo_promotor = new ArrayList<>();
		
		try {
			
			
			ResultSet rset = stmt.executeQuery(	"SELECT * FROM  recibos_promotor WHERE estatus=" + estatus + " AND codigo_recibo=" + numRecibo);
			
			PromotoresDao promotorDao = new PromotoresDao();
			
			while (rset.next()){
				recibo = new RecibosPromotor();
				recibo.setId(rset.getInt("id"));
				recibo.setCodigoRecibo(rset.getLong("codigo_recibo"));
				recibo.setEstatus(rset.getInt("estatus"));
				recibo.setFechaProceso(rset.getString("fecha_proceso"));
				recibo.setFechaRegistro(rset.getString("fecha_registro"));
				codigo_promotor.add(rset.getInt("codigo_promotor"));
				listaRecibos.add(recibo);
				recibo = null;
			}   
			
			rset.close();
			
			for (int i=0;i<listaRecibos.size();i++){
				
				listaRecibos.get(i).setPromotor(promotorDao.findById(codigo_promotor.get(i)));
				
			}

			codigo_promotor = null;
			
			promotorDao = null;
	
		} catch (SQLException e) {
			System.out.println(e.toString() + " Error Contratos Promotor Dao findByProcess");		
		}
		
        
        return listaRecibos;
	
	}
	
	public RecibosPromotor findByCodigo(long codigo){
		
	  
		RecibosPromotor recibo;
		Statement stmt = Conexion.getSratement();
		recibo = new RecibosPromotor();
		
		try {
			
			int codigo_promotor = 0;
			
			ResultSet rset = stmt.executeQuery(	"SELECT * FROM  recibos_promotor WHERE codigo_recibo=" + codigo);
			
			PromotoresDao promotorDao = new PromotoresDao();
			
			if (rset.next()){
				recibo.setId(rset.getInt("id"));
				recibo.setCodigoRecibo(rset.getLong("codigo_recibo"));
				recibo.setEstatus(rset.getInt("estatus"));
				recibo.setFechaProceso(rset.getString("fecha_proceso"));
				recibo.setFechaRegistro(rset.getString("fecha_registro"));
				codigo_promotor = rset.getInt("codigo_promotor");
			}   
			
			rset.close();
			
			recibo.setPromotor(promotorDao.findById(codigo_promotor));
			promotorDao = null;
		    return recibo;
	
		} catch (SQLException e) {
			System.out.println(e.toString() + " Error Contratos Promotor Dao findByProcess");	
		    return recibo;
		}

       
	
}
	
	
}
