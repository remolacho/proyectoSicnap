package net.cablen.promotor.modelo;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import net.cablen.contratos.modelo.ContratosPromotor;
import net.cablen.helppers.Conexion;

public class PromotoresDao implements Serializable{

	private static final long serialVersionUID = 1L;

	  
		public int guardar(Promotores prom){ 
	      
			int id = 0;  
			Statement stmt = Conexion.getSratement();

			try {
				
				String sql = "INSERT INTO promotores (" + 
                        	 "cod_promotor,cedula,nombre," +
                        	 "apellido,telefono_fijo,telefono_movil,estatus) VALUES (" +
                        	 prom.getCodPromotor()+ ",'" +
                        	 prom.getCedula() + "','" +
                        	 prom.getNombre()  + "','" +
                        	 prom.getApellido() + "','" +
                        	 prom.getTelefonoFijo() + "','" +
                        	 prom.getTelefonoMovil() + "'," +
                        	 prom.getEstatus() + ")";
				
				id = stmt.executeUpdate(sql);
				
			} catch (SQLException e) {
				System.out.println(e.toString());
				return -2;
			}
			
			return id;
	    }  

	    public int actualizar(Promotores prom) 
	    { 
			int id = 0;  
			Statement stmt = Conexion.getSratement();

			try {
				
				String sql = "UPDATE promotores SET " +
                        	 "cod_promotor=" + prom.getCodPromotor()+ "," +
                        	 "cedula='" + prom.getCedula() + "'," +
                        	 "nombre='" +  prom.getNombre() + "'," +
                        	 "apellido='" +  prom.getApellido()  + "'," +
                        	 "telefono_fijo='" +  prom.getTelefonoFijo() + "'," +
                        	 "telefono_movil='" +  prom.getTelefonoMovil() + "'," +
                        	 "estatus=" + prom.getEstatus() + 
                        	 " WHERE cod_promotor=" + prom.getCodPromotor();

				id = stmt.executeUpdate(sql);
				
			} catch (SQLException e) {
				System.out.println(e.toString());
				return -2;
			}
			
			return id;
	        
	    }  

	    public int eliminar(Promotores prom) 
	    { 
	    	int id=0;

	        
	        return id;
	        
	    }  

	    public Promotores findById(int idProm) 
	    { 
	    	Promotores promotor = new Promotores();
			Statement stmt;
			
			try {
				
				stmt = Conexion.getSratement();
				ResultSet rset = stmt.executeQuery
						 ("SELECT * FROM promotores WHERE cod_promotor=" + idProm);
				
				 if (rset.next()){
					promotor = new Promotores();
					promotor.setCodPromotor(rset.getInt("cod_promotor"));
					promotor.setCedula(rset.getString("cedula"));
					promotor.setNombre(rset.getString("nombre"));
					promotor.setApellido(rset.getString("apellido"));
					promotor.setTelefonoFijo(rset.getString("telefono_fijo"));
					promotor.setTelefonoMovil(rset.getString("telefono_movil"));
					promotor.setEstatus(rset.getInt("estatus"));
				}else {
					promotor = new Promotores();
					promotor.setCodPromotor(0);
					promotor.setCedula("");
					promotor.setNombre("");
					promotor.setApellido("");
					promotor.setTelefonoFijo("");
					promotor.setTelefonoMovil("");
					promotor.setEstatus(0);
					
				}  
				
				rset.close();
				
			} catch (SQLException e) {
				System.out.println(e.toString() + "Error findById");		
			}
			
			
	        return promotor;
	        
	    }  


		public List<Promotores> obtenerLista() {
			
			List<Promotores> listaPromotores = new ArrayList<Promotores>(); 
			Promotores promotor;
			Statement stmt;
			
			try {
				
				stmt = Conexion.getSratement();
				ResultSet rset = stmt.executeQuery("SELECT * FROM promotores");
				
				while (rset.next()){
					promotor = new Promotores();
					promotor.setCodPromotor(rset.getInt("cod_promotor"));
					promotor.setCedula(rset.getString("cedula"));
					promotor.setNombre(rset.getString("nombre"));
					promotor.setApellido(rset.getString("apellido"));
					promotor.setTelefonoFijo(rset.getString("telefono_fijo"));
					promotor.setTelefonoMovil(rset.getString("telefono_movil"));
					promotor.setEstatus(rset.getInt("estatus"));
					listaPromotores.add(promotor);
					promotor = null;
				}   
				rset.close();					
			} catch (SQLException e) {
				System.out.println(e.toString());		
			}
			
			
	        return listaPromotores;
			
			
		}
		
	    public Promotores findByCedula(String ced)
	    { 
	    	
	    	Promotores promotor = new Promotores();
			Statement stmt;
			try {
				
				stmt = Conexion.getSratement();
				ResultSet rset = stmt.executeQuery
						 ("SELECT * FROM promotores WHERE cedula='" + ced + "'");
				
				 if (rset.next()){
					promotor = new Promotores();
					promotor.setCodPromotor(rset.getInt("cod_promotor"));
					promotor.setCedula(rset.getString("cedula"));
					promotor.setNombre(rset.getString("nombre"));
					promotor.setApellido(rset.getString("apellido"));
					promotor.setTelefonoFijo(rset.getString("telefono_fijo"));
					promotor.setTelefonoMovil(rset.getString("telefono_movil"));
					promotor.setEstatus(rset.getInt("estatus"));
				}else {
					promotor = new Promotores();
					promotor.setCodPromotor(0);
					promotor.setCedula("");
					promotor.setNombre("");
					promotor.setApellido("");
					promotor.setTelefonoFijo("");
					promotor.setTelefonoMovil("");
					promotor.setEstatus(0);
					
				} 
				
				 rset.close();
							
			} catch (SQLException e) {
				System.out.println(e.toString() + " error");		
			}
			
			
	        return promotor;
		    

	    } 
	    
		public List<Promotores> findByApellido(String ape) {
			
			List<Promotores> listaPromotores = new ArrayList<Promotores>(); 
			Promotores promotor;
			Statement stmt;
			try {
				
				stmt = Conexion.getSratement();
				ResultSet rset = stmt.executeQuery("SELECT * FROM promotores WHERE apellido LIKE '%" + ape + "%'");
				
				while (rset.next()){
					promotor = new Promotores();
					promotor.setCodPromotor(rset.getInt("cod_promotor"));
					promotor.setCedula(rset.getString("cedula"));
					promotor.setNombre(rset.getString("nombre"));
					promotor.setApellido(rset.getString("apellido"));
					promotor.setTelefonoFijo(rset.getString("telefono_fijo"));
					promotor.setTelefonoMovil(rset.getString("telefono_movil"));
					promotor.setEstatus(rset.getInt("estatus"));
					listaPromotores.add(promotor);
					promotor = null;
				}   
				
				rset.close();
				
			} catch (SQLException e) {
				System.out.println(e.toString());		
			}
			
			
	        return listaPromotores;
			
			
		}
		
		  public int correlativo(){

				Statement stmt = Conexion.getSratement();
				int id=0;
	
				
				try {
					
					ResultSet rset = stmt.executeQuery("SELECT MAX(cod_promotor) AS id FROM promotores");
					
					while (rset.next()){
						id = rset.getInt("id") + 1;
					}   
					
					rset.close();
					
			
				} catch (SQLException e) {
					System.out.println(e.toString());
					return id;		
				}
				
		        
		        return id;
	    	
	    }

		
	    
	  
}
