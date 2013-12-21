package net.cablen.recibos.modelo;

import java.util.List;

import net.cablen.helppers.Usuario;
import net.cablen.helppers.ValidarCampos;
import net.cablen.promotor.modelo.Promotores;

public class Recibo {

	private long[] arrayRecibos;
	private Promotores promotor;
	
	public Recibo() {
		// TODO Auto-generated constructor stub
	}
	
	public Recibo(long[] recibos,Promotores promotor) {
		this.promotor = promotor;
		this.arrayRecibos = recibos;
	}
	
	public String asigRecibos(){
		
		int cantidad = arrayRecibos.length;
		int result = 0;
		String msg ="";
		RecibosPromotorDao dao = new RecibosPromotorDao();
		
		for (int i=0;i< cantidad;i++){
			RecibosPromotor recibo = new RecibosPromotor();
			recibo.setCodigoRecibo(arrayRecibos[i]);
			recibo.setFechaRegistro(ValidarCampos.soloFecha());
			recibo.setEstatus(0);
			recibo.setPromotor(promotor);
			result = dao.guardar(recibo);
			recibo = null;
			
			if (result < 0){
				msg = "Se almacenaron pero con problemas llamar a sistemas";
			}
			
		}
		
		dao = null;
		
		return msg;
		
	}
	
	public String procesarRecibo(DetalleRecibos detalle){
		String msg ="";
		
		DetalleRecibosDao daoDetalle = new DetalleRecibosDao();
		RecibosPromotorDao daoRecibo = new RecibosPromotorDao();
		
		if (daoDetalle.guardar(detalle) > 0) {
			if (daoRecibo.updateEstatus(detalle.getRecibosPromotor()) > 0){
				msg = "Datos almacenados con exito";
			}else{
				msg = "Se presentaron problemas en el actualizar el estatus del recibo llamar a sistemas";
			}
	
		}else{
			msg = "Se presentaron problemas en el almacenamiento del recibo llamar a sistemas";
		}
		
		daoRecibo = null;
		daoDetalle = null;
		return msg;
		
	}
	
	
	public List<RecibosPromotor> listByEstatus(int estatus){
		
		List<RecibosPromotor> lista = null;
		RecibosPromotorDao dao = new RecibosPromotorDao();
		lista = dao.listByEstatus(estatus);
		return lista;
		
	}
	
	public List<RecibosPromotor> listByPromotor(int cProm,int estatus){
		
		List<RecibosPromotor> lista = null;
		RecibosPromotorDao dao = new RecibosPromotorDao();
		lista = dao.listByPromotor(cProm, estatus);
		return lista;
		
	}
	
	public List<RecibosPromotor> listByRecibo(long recibo,int estatus){
		
		List<RecibosPromotor> lista = null;
		RecibosPromotorDao dao = new RecibosPromotorDao();
		lista = dao.listByRecibo(recibo, estatus);
		return lista;
		
	}
	
	public List<DetalleRecibos> listDetalleByFiltro(String query){
		List<DetalleRecibos> lista = null;
		DetalleRecibosDao dao = new DetalleRecibosDao();
		lista = dao.listByFiltro(query);
		return lista;
	}
	
	
	
}
