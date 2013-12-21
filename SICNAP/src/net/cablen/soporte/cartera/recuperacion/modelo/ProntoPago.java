package net.cablen.soporte.cartera.recuperacion.modelo;

import java.rmi.RemoteException;
import java.util.List;

import net.cablen.helppers.Usuario;
import net.cablen.soporte.actividades.modelo.TshActividades;
import net.cablen.soporte.actividades.modelo.TshActividadesDao;
import net.cablen.soporte.estatus.modelo.TshEstatus;
import net.cablen.soporte.estatus.modelo.TshEstatusDao;
import net.cablen.soporte.ws.Abonado;
import net.cablen.soporte.ws.ServicioAboProxy;

public class ProntoPago {

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
	
	public List<TshActividades> cargarActividades(){
		List<TshActividades> actv = null;
		TshActividadesDao dao = new TshActividadesDao();
		actv = dao.listaActividadesCA();
		return actv;
	}
	
	public List<TshEstatus> findListEstatus(){
		List<TshEstatus> lista = null;
		TshEstatusDao dao = new TshEstatusDao();
		lista = dao.listaEstatusCA();
		return lista;
	}
	
	public String iniciarTicket(){
		String  ticket = "";
		CarteraDao carDao = new CarteraDao();
		
		long result = carDao.findByUserSystem(Usuario.getUser().getLogin());
	
		if (result > 0){
			ticket = "TIC-" + result;
		}else {
			ticket = "TIC-" + carDao.crearTicket();
		}
		carDao = null;
		return ticket;
	}
	
	
	public String asignarTicket(Cartera car){
		
		String msg ="";
		long result = 0; 
		
		CarteraDao objDao = new CarteraDao();
		result = objDao.asignarTicket(car); 
		
		if (result > 0){
			msg = "OK Se asigno el ticket N° " + car.getTicketCart() + " con exito al abonado numero " + car.getAbonado();
		}else{
			msg = "Problemas al almacenar el ticket  N° " + car.getTicketCart() + " al abonado numero " + car.getAbonado();
		}
		
		objDao = null;
		return msg;
		
	}
}
