package net.cablen.promotor.modelo;

import java.util.List;

public class Promotor {
	
	public Promotores findById(int idProm){
		Promotores promotor = null;
		PromotoresDao dao = new PromotoresDao();
		promotor = dao.findById(idProm);
		dao= null;
		return promotor;
		
	}
	
	public List<Promotores> listaPromotores(){
		
		List <Promotores> lista=null ;
		PromotoresDao dao = new PromotoresDao();
		lista = dao.obtenerLista();
	
		return lista;
		
	}
	
	
	public List<Promotores> listaByApellido(String ape){
		
		List <Promotores> lista=null ;
		PromotoresDao dao = new PromotoresDao();
		lista = dao.findByApellido(ape);
	
		return lista;
		
	}
	
	public String agregar(Promotores prom){
		
		String msg = "";
		int id = 0;
		
		if (!prom.getCedula().equals("")){
			PromotoresDao dao = new PromotoresDao();
			id = dao.guardar(prom);
		
			if(id > 0){
				msg = "Se almaceno el promotor con exito";
			}else{
				msg = "Error al crear el promotor";
			}
		
			return msg;
		}else{
			
			msg = "El campo cedula es Vacio";
			return msg;
		}
	}
	
	
public String actualizar(Promotores prom){
		
		String msg = "";
		int id = 0;
		
		if (!prom.getCedula().equals("")){
			PromotoresDao dao = new PromotoresDao();
			id = dao.actualizar(prom);
		
			if(id > 0){
				msg = "Se actualizo el promotor con exito";
			}else{
				msg = "Error al actualizar el promotor";
			}
		
			return msg;
		}else{
			
			msg = "El campo cedula es Vacio";
			return msg;
		}
	}
	
	
	public int correlativo(){
		
		PromotoresDao dao = new  PromotoresDao();
		int id = dao.correlativo();
		dao=null;
		return id;
		
	}
	
	
}
