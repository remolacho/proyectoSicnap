package net.cablen.soporte.callCenter.troubleshooting.modelo;

import java.rmi.RemoteException;
import java.util.List;

import net.cablen.helppers.Usuario;
import net.cablen.soporte.actividades.modelo.TshActividades;
import net.cablen.soporte.actividades.modelo.TshActividadesDao;
import net.cablen.soporte.estatus.modelo.TshEstatus;
import net.cablen.soporte.estatus.modelo.TshEstatusDao;
import net.cablen.soporte.ws.Abonado;
import net.cablen.soporte.ws.ServicioAboProxy;

public class CallCenter {
	
	public Abonado[] lista (String ci){
		
		Abonado[] lista = null;
		
		try {
			ServicioAboProxy proxy = new ServicioAboProxy();
			lista = proxy.resultLista(ci);
			proxy=null;
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return lista;
		
	}
	
	public String IniciarIncidencia(){
		String  incidencia = "";
		TroubleshootingDao trou = new TroubleshootingDao();
		
		long result = trou.findByUserSystem(Usuario.getUser().getLogin());
	
		if (result > 0){
			incidencia = "INC-" + result;
		}else {
			incidencia = "INC-" + trou.crearIncidencia();
		}
		
		return incidencia;
	}
	
	public String asignarIncidencia(Troubleshooting trou){
		
		String msg ="";
		long result = 0; 
		
		TroubleshootingDao objDao = new TroubleshootingDao();
		result = objDao.asignarIncidencia(trou); 
		
		if (result > 0){
			msg = "OK Se asigno la incidencia N° " + trou.getIncidencia() + " con exito al abonado numero " + trou.getAbonado();
		}else{
			msg = "Problemas al almacenar la incidencia  N° " + trou.getIncidencia() + " al abonado numero " + trou.getAbonado();
		}
		
		objDao = null;
		return msg;
		
	}
	
	public List<TshActividades> cargarActividades(){
		List<TshActividades> actv = null;
		TshActividadesDao dao = new TshActividadesDao();
		actv = dao.listaActividadesCC();
		return actv;
	}
	
	public List<Troubleshooting> findListByOpen(String strSql){
		List<Troubleshooting> lista = null;
		TroubleshootingDao dao = new TroubleshootingDao();
		lista = dao.findIncAbiertas(strSql);
		return lista;
	}
	
	public List<TshEstatus> findListEstatus(){
		List<TshEstatus> lista = null;
		TshEstatusDao dao = new TshEstatusDao();
		lista = dao.listaEstatusCC();
		return lista;
	}
	
	public String cerrarInc (Troubleshooting obj){
		String msg = "";
		
		TroubleshootingDao dao = new TroubleshootingDao();
		
		if (dao.cerrarIncidencia(obj) > 0) {
			msg ="";
		}else{
			msg = "Problemas al cerrar la Incidencia comunicarce con sistemas";
		}
		
		return msg;
	
	}
	
	public List<Troubleshooting> listByFilter(String strSql){
		List<Troubleshooting> lista = null;
		TroubleshootingDao tdao = new TroubleshootingDao();
		lista = tdao.findFilter(strSql);
		return lista;
	}
	
}
