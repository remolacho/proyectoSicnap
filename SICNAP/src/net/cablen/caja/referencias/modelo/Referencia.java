package net.cablen.caja.referencias.modelo;

import java.util.ArrayList;
import java.util.List;

public class Referencia {
	
	public String Agregar(Referencias ref){
		
		int result  = 0;
		String msg = "";
		ReferenciasDao refDao = new ReferenciasDao();
		result = refDao.agregar(ref);
		refDao =null;
		ref = null;
		
		if (result >0){
			msg = "Transaccion exitosa";
		}else{
			msg = "Error al tratar de almaceenar la referencia";
		}
		
		return msg;
	}
	
	public int refErr(){
		
		int errRef = 0;
		ReferenciasDao dao = new ReferenciasDao();
		errRef  = dao.buscarRefErr();
		return errRef;
		
	}
	
	public void updateRefErr(){
		
		ReferenciasDao refDao = new ReferenciasDao();
		refDao.UpdateRefErr();
		refDao =null;
		
	}
	
	public List<Referencias> listaPorReferencia(String ref, int estatus){
		
		List<Referencias> lista = null;
		ReferenciasDao dao = new ReferenciasDao();
		lista = dao.listByReferencian(ref, estatus);
		dao = null;
		return lista;

	}
	
	public List<Referencias> listaReferenciaPorFiltro(String strSql){
	
		List<Referencias> lista = null;
		ReferenciasDao dao = new ReferenciasDao();
		lista = dao.listByFiltro(strSql);
		dao = null;
		return lista;
		
	}
	

}
