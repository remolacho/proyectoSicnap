package net.cablen.contratos.modelo;

import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import net.cablen.helppers.Conexion;

public class HistorialContratosDao implements Serializable{

	private static final long serialVersionUID = 1L;

    
		public int guardar(HistorialContratos hCont){ 
	      
			int id = 0; 
			Statement stmt = Conexion.getSratement();
			try {
				
				String sql = "INSERT INTO historial_contratos (" + 
                        	 "codigo_promotor,cant_contratos,fecha_asignado," +
                        	 "contrato_inicial,	contrato_final,login_user) VALUES (" +
                        	 hCont.getPromotores().getCodPromotor() + "," +
                        	 hCont.getCantContratos() + ",'" +
                        	 hCont.getFechaAsignado()  + "'," +
                        	 hCont.getContratoInicial() + "," +
                        	 hCont.getContratoFinal() + ",'" +
                        	 hCont.getLoginUser() +  "')";
				
							
				id = stmt.executeUpdate(sql);

			} catch (SQLException e) {
				System.out.println(e.toString());
				return -2;
			}
			
			return id;
	        
	    }  

	    public int actualizar(HistorialContratos hCont)
	    { 
	    	int id=0;
		       
	   
	        
	        return id;
	        
	    }  

	    public int eliminar(HistorialContratos hCont)
	    { 
	    	
	    	int id=0;
	    	
	   
	        
	        return id;
	    }  

	    public HistorialContratos findById(int idHist)
	    { 
	    	HistorialContratos hist = null;   
	   
	        
	        return hist; 
	       
	    }  


		public List<HistorialContratos> obtenerLista() {
			
			//listaHistorial =  HibernateUtil.sesion.createCriteria("net.cablen.contratos.modelo.HistorialContratos").list();

			List<HistorialContratos> listaHistorial = null;  
	        return listaHistorial;
			
		}
		
	    public List<HistorialContratos> findByPromotor(String ced) 
	    { 
	       
	        List<HistorialContratos> listaHistorial = null;    
	        return listaHistorial; 
	        
	        
	        
	    }

}
