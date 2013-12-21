package net.cablen.precintos.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.cablen.contratos.modelo.ContratosPromotor;
import net.cablen.helppers.Conexion;
import net.cablen.promotor.modelo.PromotoresDao;

public class PrecintosPromotorDao {

	public int guardar(PrecintosPromotor pProm) { 

		int id = 0;  
		Statement stmt = Conexion.getSratement();

		try {
			
			String sql = "INSERT INTO  precintos_promotor (" + 
                    	 "precinto,codigo_promotor,fecha_registro," +
                    	 "boxy,estatus) VALUES ('" +
                    	 pProm.getPrecinto() + "'," +
                    	 pProm.getPromotores().getCodPromotor() + ",'" +
                    	 pProm.getFechaRegistro()  + "','" +
                    	 pProm.getBoxy() + "'," +
                    	 pProm.getEstatus() + ")";
			
			id = stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			return -2;
		}
		
		return id;
          
    }  
	
	 public List<PrecintosPromotor> findByProcess() 
	    { 
	        List<PrecintosPromotor> listaPrecintos = new ArrayList<PrecintosPromotor>(); 
			PrecintosPromotor precinto;
			Statement stmt = Conexion.getSratement();
			
			ArrayList<Integer> codigo_promotor = new ArrayList<>();
			
			try {
				
				
				ResultSet rset = stmt.executeQuery("SELECT * FROM precintos_promotor WHERE estatus=0");
				
				PromotoresDao promotorDao = new PromotoresDao();
				
				while (rset.next()){
					precinto = new PrecintosPromotor();
					precinto.setId(rset.getLong("id"));
					precinto.setBoxy(rset.getString("boxy"));	
					precinto.setPrecinto(rset.getString("precinto"));
					precinto.setEstatus(rset.getInt("estatus"));
					precinto.setFechaProceso(rset.getString("fecha_proceso"));
					precinto.setFechaRegistro(rset.getString("fecha_registro"));
					codigo_promotor.add(rset.getInt("codigo_promotor"));
					listaPrecintos.add(precinto);
					precinto = null;
				}   
				
				rset.close();
				
				for (int i=0;i<listaPrecintos.size();i++){
					
					listaPrecintos.get(i).setPromotores(promotorDao.findById(codigo_promotor.get(i)));
					
				}

				codigo_promotor = null;
				
				promotorDao = null;
		
			} catch (SQLException e) {
				System.out.println(e.toString() + " Error Contratos Promotor Dao findByProcess");		
			}
			
	        
	        return listaPrecintos;

	    } 
	 
	 
	 public List<PrecintosPromotor> findAll()  { 
		   
		    List<PrecintosPromotor> listaPrecintos = new ArrayList<PrecintosPromotor>(); 
			PrecintosPromotor precinto;
			Statement stmt = Conexion.getSratement();
			
			ArrayList<Integer> codigo_promotor = new ArrayList<>();
			
			try {
				
				
				ResultSet rset = stmt.executeQuery("SELECT * FROM precintos_promotor");
				
				PromotoresDao promotorDao = new PromotoresDao();
				
				while (rset.next()){
					precinto = new PrecintosPromotor();
					precinto.setId(rset.getLong("id"));
					precinto.setBoxy(rset.getString("boxy"));	
					precinto.setPrecinto(rset.getString("precinto"));
					precinto.setEstatus(rset.getInt("estatus"));
					precinto.setFechaProceso(rset.getString("fecha_proceso"));
					precinto.setFechaRegistro(rset.getString("fecha_registro"));
					codigo_promotor.add(rset.getInt("codigo_promotor"));
					listaPrecintos.add(precinto);
					precinto = null;
				}   
				
				rset.close();
				
				for (int i=0;i<listaPrecintos.size();i++){
					
					listaPrecintos.get(i).setPromotores(promotorDao.findById(codigo_promotor.get(i)));
					
				}

				codigo_promotor = null;
				
				promotorDao = null;
		
			} catch (SQLException e) {
				System.out.println(e.toString() + " Error Contratos Promotor Dao findByProcess");		
			}
			
	        
	        return listaPrecintos;

	    } 
	 
	 public List<PrecintosPromotor> findByBoxy(String boxy)  { 
		   
		    List<PrecintosPromotor> listaPrecintos = new ArrayList<PrecintosPromotor>(); 
			PrecintosPromotor precinto;
			Statement stmt = Conexion.getSratement();
			
			ArrayList<Integer> codigo_promotor = new ArrayList<>();
			
			try {
				
				
				ResultSet rset = stmt.executeQuery(	"SELECT * FROM precintos_promotor WHERE estatus=0 AND  boxy LIKE '%" + boxy + "%'");
				
				PromotoresDao promotorDao = new PromotoresDao();
				
				while (rset.next()){
					precinto = new PrecintosPromotor();
					precinto.setId(rset.getLong("id"));
					precinto.setBoxy(rset.getString("boxy"));	
					precinto.setPrecinto(rset.getString("precinto"));
					precinto.setEstatus(rset.getInt("estatus"));
					precinto.setFechaProceso(rset.getString("fecha_proceso"));
					precinto.setFechaRegistro(rset.getString("fecha_registro"));
					codigo_promotor.add(rset.getInt("codigo_promotor"));
					listaPrecintos.add(precinto);
					precinto = null;
				}   
				
				rset.close();
				
				for (int i=0;i<listaPrecintos.size();i++){
					
					listaPrecintos.get(i).setPromotores(promotorDao.findById(codigo_promotor.get(i)));
					
				}

				codigo_promotor = null;
				
				promotorDao = null;
		
			} catch (SQLException e) {
				System.out.println(e.toString() + " Error Contratos Promotor Dao findByProcess");		
			}
			
	        
	        return listaPrecintos;

	    } 
	 
	 	public List<PrecintosPromotor> findByEstatus(int estatus)  { 
		   
		    List<PrecintosPromotor> listaPrecintos = new ArrayList<PrecintosPromotor>(); 
			PrecintosPromotor precinto;
			Statement stmt = Conexion.getSratement();
			
			ArrayList<Integer> codigo_promotor = new ArrayList<>();
			
			try {
				
				
				ResultSet rset = stmt.executeQuery(	"SELECT * FROM precintos_promotor WHERE estatus=" + estatus);
				
				PromotoresDao promotorDao = new PromotoresDao();
				
				while (rset.next()){
					precinto = new PrecintosPromotor();
					precinto.setId(rset.getLong("id"));
					precinto.setBoxy(rset.getString("boxy"));	
					precinto.setPrecinto(rset.getString("precinto"));
					precinto.setEstatus(rset.getInt("estatus"));
					precinto.setFechaProceso(rset.getString("fecha_proceso"));
					precinto.setFechaRegistro(rset.getString("fecha_registro"));
					codigo_promotor.add(rset.getInt("codigo_promotor"));
					listaPrecintos.add(precinto);
					precinto = null;
				}   
				
				rset.close();
				
				for (int i=0;i<listaPrecintos.size();i++){
					
					listaPrecintos.get(i).setPromotores(promotorDao.findById(codigo_promotor.get(i)));
					
				}

				codigo_promotor = null;
				
				promotorDao = null;
		
			} catch (SQLException e) {
				System.out.println(e.toString() + " Error Contratos Promotor Dao findByProcess");		
			}
			
	        
	        return listaPrecintos;

	    } 
	 	
	 	  public int actualizarEstatus(String strPrecintos)
		    { 

		    	int id=0;
				Statement stmt = Conexion.getSratement();
			    Date fecha = new Date();  
			    String patron = "yyyy/MM/dd";	    
			    SimpleDateFormat formato = new SimpleDateFormat(patron);

		    	String sql = "UPDATE precintos_promotor SET estatus=1,fecha_proceso='" + 
		    	             formato.format(fecha)  + "' WHERE estatus=0 AND precinto IN (" +
		    	             strPrecintos + ")";
		    	//System.out.println(sql);
		    	try {

					id = stmt.executeUpdate(sql);	
					
				} catch (SQLException e) {
					System.out.println(e.toString());
					return -2;
				}
				
				return id;

		    }
	 	  
	 	    public List<PrecintosPromotor> findByStr(String strSql) 
		    { 
		        List<PrecintosPromotor> listaPrecintos = new ArrayList<PrecintosPromotor>(); 
				PrecintosPromotor precinto;
				Statement stmt = Conexion.getSratement();
				
				ArrayList<Integer> codigo_promotor = new ArrayList<>();
				
				try {
					
					String sql = "SELECT * FROM precintos_promotor WHERE estatus=" + strSql;
					//System.out.println(sql);
					ResultSet rset = stmt.executeQuery(sql);
					
					PromotoresDao promotorDao = new PromotoresDao();
					
					while (rset.next()){
						precinto = new PrecintosPromotor();
						precinto.setId(rset.getLong("id"));
						precinto.setBoxy(rset.getString("boxy"));	
						precinto.setPrecinto(rset.getString("precinto"));
						precinto.setEstatus(rset.getInt("estatus"));
						precinto.setFechaProceso(rset.getString("fecha_proceso"));
						precinto.setFechaRegistro(rset.getString("fecha_registro"));
						codigo_promotor.add(rset.getInt("codigo_promotor"));
						listaPrecintos.add(precinto);
						precinto = null;
					}  
					
					rset.close();
					
					for (int i=0;i<listaPrecintos.size();i++){
						
						listaPrecintos.get(i).setPromotores(promotorDao.findById(codigo_promotor.get(i)));
						
					}

					codigo_promotor = null;
					
					promotorDao = null;
			
				} catch (SQLException e) {
					System.out.println(e.toString() + " Error Contratos Promotor Dao findByProcess");		
				}
				
		        
		        return listaPrecintos;

		    } 

	
}
