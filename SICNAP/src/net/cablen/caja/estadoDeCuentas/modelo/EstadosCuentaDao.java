package net.cablen.caja.estadoDeCuentas.modelo;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.cablen.helppers.Conexion;

public class EstadosCuentaDao {
	
	PrintWriter logTmp = null;
	
	public int guardar(EstadosCuenta estCu){

		int id = 0;  
		Statement stmt = Conexion.getSratement();
		try{
			String sql = "INSERT INTO  estados_cuenta " +
						 "(referencia,fecha_pago,descripcion,monto,cod_banco,estatus) VALUES ('" +
				     	 estCu.getReferencia() + "','" + 
				     	 estCu.getFechaPago()  + "','" +
				     	 estCu.getDescripcion() + "'," +
				     	 estCu.getMonto() + ",'" +
				     	 estCu.getCodBanco() + "'," +
				     	 estCu.getEstatus()  + ")";
		
			id = stmt.executeUpdate(sql);
		
	   } catch (SQLException e) { 
		   // System.out.println(e.toString());
		   return -2;
	   }
	
	   return id;

	}
	
	
	public EstadosCuenta findByRef(String ref){
		
		try {
			
			EstadosCuenta objEst = null;
			String sql ="SELECT * FROM  estados_cuenta WHERE referencia='" + ref + "' AND estatus=0";
			Statement stmt = Conexion.getSratement();
			ResultSet rset = stmt.executeQuery(sql);
			
			if (rset.next()){	
				objEst = new EstadosCuenta();
				objEst.setReferencia(rset.getString("referencia"));
				objEst.setDescripcion(rset.getString("descripcion"));
				objEst.setCodBanco(rset.getString("cod_banco"));
				objEst.setMonto(rset.getFloat("monto"));
				objEst.setFechaPago(rset.getString("fecha_pago"));
				objEst.setEstatus(rset.getInt("estatus"));
			}
			
			rset.close();

			return objEst;
			
		} catch (SQLException e) {
			return null;
		}
		
	}
	
	
	public int updateEstatus(String ref){
		
		int result = 0;
		String sql = "UPDATE estados_cuenta SET estatus=1 WHERE referencia='" + ref + "'";

		try {
			Statement stmt = Conexion.getSratement();
			result = stmt.executeUpdate(sql);
			return result;
		} catch (SQLException e) {
			return -1;
		}
		
		
	}
	
	

}
