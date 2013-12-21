package net.cablen.contratos.modelo;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.cablen.helppers.Conexion;
import net.cablen.promotor.modelo.PromotoresDao;

public class ContratosPromotorDao implements Serializable{

	private static final long serialVersionUID = 1L;

		public int guardar(ContratosPromotor cProm) { 

			int id = 0;  
			Statement stmt = Conexion.getSratement();

			try {
				
				String sql = "INSERT INTO contratos_promotor (" + 
                        	 "codigo_promotor,codigo_contrato,fecha_registro," +
                        	 "boxy,estatus) VALUES (" +
                        	 cProm.getPromotores().getCodPromotor() + "," +
                        	 cProm.getCodigoContrato() + ",'" +
                        	 cProm.getFechaRegistro()  + "','" +
                           	 cProm.getBoxy() + "'," +
                        	 cProm.getEstatus() + ")";
				
				id = stmt.executeUpdate(sql);
				
			} catch (SQLException e) {
				System.out.println(e.toString());
				return -2;
			}
			
			return id;
	          
	    }  
		
	    public int actualizarEstatus(String strContratos)
	    { 

	    	int id=0;
			Statement stmt = Conexion.getSratement();
		    Date fecha = new Date();  
		    String patron = "yyyy/MM/dd";	    
		    SimpleDateFormat formato = new SimpleDateFormat(patron);

	    	String sql = "UPDATE contratos_promotor SET estatus=1,fecha_proceso='" + 
	    	             formato.format(fecha)  + "' WHERE estatus=0 AND codigo_contrato IN (" +
	    	             strContratos + ")";
	    	//System.out.println(sql);
	    	try {

				id = stmt.executeUpdate(sql);	
				
			} catch (SQLException e) {
				System.out.println(e.toString());
				return -2;
			}
			
			return id;

	    }  

	    public int eliminar(ContratosPromotor cProm)
	    { 
	    	int id=0;      
	        return id;
	    }  
	    

	    public ContratosPromotor findById(int idCProm)
	    { 
	    	ContratosPromotor cotrato = null;   
	        return cotrato; 
	    }  


		public List<ContratosPromotor> obtenerLista() {
			
			List<ContratosPromotor> listaContratos = null;  

		
	        
	        return listaContratos;
			
			
		}
		
	    public List<ContratosPromotor> findByPromotor(int cod) 
	    { 
	    	
	        List<ContratosPromotor> listaContratos = new ArrayList<ContratosPromotor>(); 
			ContratosPromotor contratos;
			Statement stmt = Conexion.getSratement();
			
			ArrayList<Integer> codigo_promotor = new ArrayList<>();
			
			try {
				
				
				ResultSet rset = stmt.executeQuery("SELECT * FROM contratos_promotor WHERE estatus=0 " + 
				                                   "AND codigo_promotor=" + cod  );
				
				PromotoresDao promotorDao = new PromotoresDao();
				
				while (rset.next()){
					contratos = new ContratosPromotor();
					contratos.setId(rset.getLong("id"));
					contratos.setBoxy(rset.getString("boxy"));	
					contratos.setCodigoContrato(rset.getLong("codigo_contrato"));
					contratos.setEstatus(rset.getInt("estatus"));
					contratos.setFechaProceso(rset.getString("fecha_proceso"));
					contratos.setFechaRegistro(rset.getString("fecha_registro"));
					codigo_promotor.add(rset.getInt("codigo_promotor"));
					listaContratos.add(contratos);
					contratos = null;
				}   
				
				rset.close();
				
				for (int i=0;i<listaContratos.size();i++){
					
					listaContratos.get(i).setPromotores(promotorDao.findById(codigo_promotor.get(i)));
					
				}

				codigo_promotor = null;
				
				promotorDao = null;
		
			} catch (SQLException e) {
				System.out.println(e.toString() + " Error Contratos Promotor Dao findByProcess");		
			}
			
	        
	        return listaContratos;

	    } 
	    
	    public List<ContratosPromotor> findByProcess() 
	    { 
	        List<ContratosPromotor> listaContratos = new ArrayList<ContratosPromotor>(); 
			ContratosPromotor contratos;
			Statement stmt = Conexion.getSratement();
			
			ArrayList<Integer> codigo_promotor = new ArrayList<>();
			
			try {
				
				
				ResultSet rset = stmt.executeQuery("SELECT * FROM contratos_promotor WHERE estatus=0");
				
				PromotoresDao promotorDao = new PromotoresDao();
				
				while (rset.next()){
					contratos = new ContratosPromotor();
					contratos.setId(rset.getLong("id"));
					contratos.setBoxy(rset.getString("boxy"));	
					contratos.setCodigoContrato(rset.getLong("codigo_contrato"));
					contratos.setEstatus(rset.getInt("estatus"));
					contratos.setFechaProceso(rset.getString("fecha_proceso"));
					contratos.setFechaRegistro(rset.getString("fecha_registro"));
					codigo_promotor.add(rset.getInt("codigo_promotor"));
					listaContratos.add(contratos);
					contratos = null;
				}   
				
				rset.close();
				
				for (int i=0;i<listaContratos.size();i++){
					
					listaContratos.get(i).setPromotores(promotorDao.findById(codigo_promotor.get(i)));
					
				}

				codigo_promotor = null;
				
				promotorDao = null;
		
			} catch (SQLException e) {
				System.out.println(e.toString() + " Error Contratos Promotor Dao findByProcess");		
			}
			
	        
	        return listaContratos;

	    } 
	    
	    
	    public List<ContratosPromotor> findByEstatus(int estatus) 
	    { 
	        List<ContratosPromotor> listaContratos = new ArrayList<ContratosPromotor>(); 
			ContratosPromotor contratos;
			Statement stmt = Conexion.getSratement();
			
			ArrayList<Integer> codigo_promotor = new ArrayList<>();
			
			try {
				
				
				ResultSet rset = stmt.executeQuery("SELECT * FROM contratos_promotor WHERE estatus=" + estatus);
				
				PromotoresDao promotorDao = new PromotoresDao();
				
				while (rset.next()){
					contratos = new ContratosPromotor();
					contratos.setId(rset.getLong("id"));
					contratos.setBoxy(rset.getString("boxy"));	
					contratos.setCodigoContrato(rset.getLong("codigo_contrato"));
					contratos.setEstatus(rset.getInt("estatus"));
					contratos.setFechaProceso(rset.getString("fecha_proceso"));
					contratos.setFechaRegistro(rset.getString("fecha_registro"));
					codigo_promotor.add(rset.getInt("codigo_promotor"));
					listaContratos.add(contratos);
					contratos = null;
				}   
				
				rset.close();
				
				for (int i=0;i<listaContratos.size();i++){
					
					listaContratos.get(i).setPromotores(promotorDao.findById(codigo_promotor.get(i)));
					
				}

				codigo_promotor = null;
				
				promotorDao = null;
		
			} catch (SQLException e) {
				System.out.println(e.toString() + " Error Contratos Promotor Dao findByProcess");		
			}
			
	        
	        return listaContratos;

	    } 
	    
	    public List<ContratosPromotor> findByBoxy(String boxy) 
	    { 
	        List<ContratosPromotor> listaContratos = new ArrayList<ContratosPromotor>(); 
			ContratosPromotor contratos;
			Statement stmt = Conexion.getSratement();
			
			ArrayList<Integer> codigo_promotor = new ArrayList<>();
			
			try {
				
				
				ResultSet rset = stmt.executeQuery("SELECT * FROM contratos_promotor WHERE estatus=0 AND  boxy LIKE '%" + boxy + "%'");
				
				PromotoresDao promotorDao = new PromotoresDao();
				
				while (rset.next()){
					contratos = new ContratosPromotor();
					contratos.setId(rset.getLong("id"));
					contratos.setBoxy(rset.getString("boxy"));	
					contratos.setCodigoContrato(rset.getLong("codigo_contrato"));
					contratos.setEstatus(rset.getInt("estatus"));
					contratos.setFechaProceso(rset.getString("fecha_proceso"));
					contratos.setFechaRegistro(rset.getString("fecha_registro"));
					codigo_promotor.add(rset.getInt("codigo_promotor"));
					listaContratos.add(contratos);
					contratos = null;
				}   
				
				rset.close();
				
				for (int i=0;i<listaContratos.size();i++){
					
					listaContratos.get(i).setPromotores(promotorDao.findById(codigo_promotor.get(i)));
					
				}

				codigo_promotor = null;
				
				promotorDao = null;
		
			} catch (SQLException e) {
				System.out.println(e.toString() + " Error Contratos Promotor Dao findByProcess");		
			}
			
	        
	        return listaContratos;

	    } 
	    
	    
	    public List<ContratosPromotor> findAll() 
	    { 
	        List<ContratosPromotor> listaContratos = new ArrayList<ContratosPromotor>(); 
			ContratosPromotor contratos;
			Statement stmt = Conexion.getSratement();
			
			ArrayList<Integer> codigo_promotor = new ArrayList<>();
			
			try {
				
				
				ResultSet rset = stmt.executeQuery("SELECT * FROM contratos_promotor");
				
				PromotoresDao promotorDao = new PromotoresDao();
				
				while (rset.next()){
					contratos = new ContratosPromotor();
					contratos.setId(rset.getLong("id"));
					contratos.setBoxy(rset.getString("boxy"));	
					contratos.setCodigoContrato(rset.getLong("codigo_contrato"));
					contratos.setEstatus(rset.getInt("estatus"));
					contratos.setFechaProceso(rset.getString("fecha_proceso"));
					contratos.setFechaRegistro(rset.getString("fecha_registro"));
					codigo_promotor.add(rset.getInt("codigo_promotor"));
					listaContratos.add(contratos);
					contratos = null;
				}   
				
				rset.close();
				
				for (int i=0;i<listaContratos.size();i++){
					
					listaContratos.get(i).setPromotores(promotorDao.findById(codigo_promotor.get(i)));
					
				}

				codigo_promotor = null;
				
				promotorDao = null;
		
			} catch (SQLException e) {
				System.out.println(e.toString() + " Error Contratos Promotor Dao findByProcess");		
			}
			
	        
	        return listaContratos;

	    } 

	    public List<ContratosPromotor> findByStr(String strSql) 
	    { 
	        List<ContratosPromotor> listaContratos = new ArrayList<ContratosPromotor>(); 
			ContratosPromotor contratos;
			Statement stmt = Conexion.getSratement();
			
			ArrayList<Integer> codigo_promotor = new ArrayList<>();
			
			try {
				
				String sql = "SELECT * FROM contratos_promotor WHERE estatus=" + strSql;
				//System.out.println(sql);
				ResultSet rset = stmt.executeQuery(sql);
				
				PromotoresDao promotorDao = new PromotoresDao();
				
				while (rset.next()){
					contratos = new ContratosPromotor();
					contratos.setId(rset.getLong("id"));
					contratos.setBoxy(rset.getString("boxy"));	
					contratos.setCodigoContrato(rset.getLong("codigo_contrato"));
					contratos.setEstatus(rset.getInt("estatus"));
					contratos.setFechaProceso(rset.getString("fecha_proceso"));
					contratos.setFechaRegistro(rset.getString("fecha_registro"));
					codigo_promotor.add(rset.getInt("codigo_promotor"));
					listaContratos.add(contratos);
					contratos = null;
				}   
				
				rset.close();
				
				for (int i=0;i<listaContratos.size();i++){
					
					listaContratos.get(i).setPromotores(promotorDao.findById(codigo_promotor.get(i)));
					
				}

				codigo_promotor = null;
				
				promotorDao = null;
		
			} catch (SQLException e) {
				System.out.println(e.toString() + " Error Contratos Promotor Dao findByProcess");		
			}
			
	        
	        return listaContratos;

	    } 
	  
}
