package net.cablen.soporte.cartera.recuperacion.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.cablen.helppers.Conexion;
import net.cablen.helppers.Usuario;
import net.cablen.soporte.callCenter.troubleshooting.modelo.Troubleshooting;

public class CarteraDao {

	public long findByUserSystem(String user){
		
		
		long correlativo = 0;
		
		try {
			
			String sql = "SELECT id_correlativo_cart FROM cartera WHERE user_sistema='" + user + "' AND estatus=0";
			Statement stmt = Conexion.getSratement();
			ResultSet rset = stmt.executeQuery(sql);
			
			if (rset.next()){
				correlativo = rset.getLong("id_correlativo_cart");				
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

	public long crearTicket(){
		long incremento = this.iniciarTicket();   
		if (incremento > 0){
			incremento = (incremento + 1);
			String sql = "INSERT INTO cartera (id_correlativo_cart,ticket_cart,user_sistema,estatus) VALUES (" +
    		        incremento + ",'TIC-" + incremento + "','" + Usuario.getUser().getLogin() + "',0)" ;
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

	private long iniciarTicket(){
		
		long correlativo=0;
		
		try {
			
			String sql ="SELECT MAX(id_correlativo_cart) as tik FROM cartera";
			Statement stmt = Conexion.getSratement();
			ResultSet rset = stmt.executeQuery(sql);
			
			if (rset.next()){
				correlativo = rset.getLong("tik");				
				if(correlativo == 0){ // cuando no hay registros hay que crear uno
					correlativo =1000;		
				}
			}
			//System.out.println(correlativo);
			rset.close();
			return correlativo;
			
		} catch (SQLException e) {
			System.out.println("iniciar ticket " + e.toString());
			return -1;
		}

	}
	
	public long asignarTicket(Cartera cartera){
		  
		long incremento = 0;
		
	     String sql = "UPDATE cartera SET fecha_llamada='" + cartera.getFechaLlamada() + "'," +
	                  "id_actividad=" + cartera.getTshActividades().getIdActividad() + "," + 
	    		      "id_estatus=" + cartera.getTshEstatus().getIdEstatus() + "," +
	                  "detalle='" + cartera.getDetalle() + "'," +
	    		      "comentario_inicial='" + cartera.getComentarioInicial() + "'," + 
	                  "abonado='" + cartera.getAbonado() + "'," +
	    		      "estatus=" + cartera.getEstatus() + "," +
	    		      "fecha_compromiso='" + cartera.getFechaCompromiso() + "' " + 
	    		      "WHERE estatus=0 AND user_sistema='" + cartera.getUserSistema() + "' AND " +
	    		      "id_correlativo_cart=" + cartera.getIdCorrelativoCart();
	     
	  // System.out.println(sql);
	     
		 try {
				Statement stmt = Conexion.getSratement();
				stmt.executeUpdate(sql);
				incremento = this.iniciarTicket() + 1; 
				return incremento;
		} catch (SQLException e) {
				System.out.println(e.toString());
				return -1;
		}
		

		
	}
	
	
}
