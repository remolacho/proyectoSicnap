package net.cablen.recibos.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import net.cablen.helppers.Conexion;
import net.cablen.promotor.modelo.Promotores;
import net.cablen.promotor.modelo.PromotoresDao;

public class DetalleRecibosDao {

	public int guardar(DetalleRecibos detalle){
		
		int id = 0;  
		Statement stmt = Conexion.getSratement();

		try {
			
			String sql = "INSERT INTO detalle_recibos (" + 
                    	 "codigo_recibo,abonado,titular," +
                    	 "telefono,monto,user_caja,fecha_proceso,"+
                    	 "user_sistema,estatus,fecha_recibo) VALUES (" +
                         detalle.getRecibosPromotor().getCodigoRecibo() + ",'" +
                    	 detalle.getAbonado() + "','" +
						 detalle.getTitular() + "','" +
                    	 detalle.getTelefono() + "'," +
						 detalle.getMonto() + ",'" +
                    	 detalle.getUserCaja() + "','" +
						 detalle.getFechaProceso() + "','" + 
                    	 detalle.getUserSistema() + "'," + 
						 detalle.getEstatus() + ",'" + 
                    	 detalle.getFechaRecibo() + "')";
			
			id = stmt.executeUpdate(sql);
			//System.out.println(sql);
		} catch (SQLException e) {
			System.out.println(e.toString());
			return -2;
		}

		return id;
		
	}
	
	public List<DetalleRecibos> listByFiltro(String query){
		
	    List<DetalleRecibos> listaDetalle = new ArrayList<DetalleRecibos>(); 
		DetalleRecibos detalle;
		RecibosPromotor recibo;
		Promotores promotor;
		
		Statement stmt = Conexion.getSratement();

		try {
			
			String sql = "SELECT d.*, r.*, p.*  FROM detalle_recibos d  " + 
                         "INNER JOIN   recibos_promotor r  ON  " + 
                         "(d.codigo_recibo = r.codigo_recibo) INNER JOIN " +
                         "promotores p ON (r.codigo_promotor = p.cod_promotor) " +
                         query;
                    
			ResultSet rset = stmt.executeQuery(sql);
			
		//	System.out.println(sql);
			RecibosPromotorDao reciboDao = new RecibosPromotorDao();
				
			while (rset.next()){
				
				detalle = new DetalleRecibos();
			    promotor = new Promotores();
			    recibo = new RecibosPromotor();
				detalle.setId(rset.getInt("d.id"));			
				detalle.setAbonado(rset.getString("d.abonado"));
				detalle.setTitular(rset.getString("d.titular"));
				detalle.setTelefono(rset.getString("d.telefono"));
				detalle.setMonto(rset.getFloat("d.monto"));
				detalle.setUserCaja(rset.getString("d.user_caja"));
				detalle.setFechaProceso(rset.getString("d.fecha_proceso"));
				detalle.setUserSistema(rset.getString("d.user_sistema"));
				detalle.setEstatus(rset.getInt("d.estatus"));
				detalle.setFechaRecibo(rset.getString("d.fecha_recibo"));
				promotor.setCedula(rset.getString("p.cedula"));
				promotor.setApellido(rset.getString("p.apellido"));
				promotor.setNombre(rset.getString("p.nombre"));
				recibo.setCodigoRecibo(rset.getLong("d.codigo_recibo"));
				recibo.setPromotor(promotor);
				detalle.setRecibosPromotor(recibo);
				listaDetalle.add(detalle);
				detalle = null;
				promotor = null;
				recibo  = null;
				
			}   
			
			rset.close();

		} catch (SQLException e) {
			//System.out.println(e.toString() + " Error Contratos Promotor Dao findByProcess");	
			JOptionPane.showMessageDialog(null, "Error en la consulta");
		}
		
        
        return listaDetalle;
	
	}
	
}
