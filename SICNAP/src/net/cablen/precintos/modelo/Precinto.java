package net.cablen.precintos.modelo;

import java.rmi.RemoteException;
import java.util.List;
import net.cablen.contratos.modelo.ContratosPromotor;
import net.cablen.contratos.modelo.ContratosPromotorDao;
import net.cablen.helppers.Usuario;
import net.cablen.helppers.ValidarCampos;
import net.cablen.precintos.ws.Sincro;
import net.cablen.precintos.ws.SincronizarPrecintosProxy;
import net.cablen.promotor.modelo.Promotores;

public class Precinto {

	private String  boxy ="";
	private String[] arrayPrecintos;
	private Promotores promotor;
	private String strCadena;
	
	public Precinto(String box,String[] array,Promotores promo) {
		// TODO Auto-generated constructor stub
		this.boxy = box;
		this.arrayPrecintos = array;
		this.promotor = promo;
		
	}
	
	public Precinto(String box,String str) {
		// TODO Auto-generated constructor stub
		this.boxy = box;
		this.strCadena = str;
		
	}
	
	public Precinto() {
		super();
	}
	
	
	public String asigPrecintos(){
		int cantidad = arrayPrecintos.length;
		int result = 0;
		String msg ="";
		PrecintosPromotorDao dao = new PrecintosPromotorDao();
		
		for (int i=0;i< cantidad;i++){
			PrecintosPromotor precinto = new PrecintosPromotor();
			precinto.setPrecinto(arrayPrecintos[i]);
			precinto.setFechaRegistro(ValidarCampos.soloFecha());
			precinto.setEstatus(0);
			precinto.setBoxy(boxy);
			precinto.setPromotores(promotor);
			result = dao.guardar(precinto);
			precinto = null;
			
			if (result < 0){
				msg = "Se almacenaron pero con problemas llamar a sistemas";
			}
			
		}
		
		dao = null;
		
		return msg;
		
	}
	
	public List<PrecintosPromotor> listByProcess(){
		List<PrecintosPromotor> lista=null;
		PrecintosPromotorDao dao = new PrecintosPromotorDao();
		lista = dao.findByProcess();
		dao = null;
		return lista;
	}
	
	public  List<PrecintosPromotor> listAll(){
		List<PrecintosPromotor> lista=null;
		PrecintosPromotorDao dao = new PrecintosPromotorDao();
		lista = dao.findAll();
		dao = null;
		return lista;
	}
	
	public  List<PrecintosPromotor> listPrecintosByBoxy(String boxy){
		List<PrecintosPromotor> lista=null;
		PrecintosPromotorDao dao = new PrecintosPromotorDao();
		lista = dao.findByBoxy(boxy);
		dao = null;
		return lista;
	}
	
	public  List<PrecintosPromotor> listPrecintosByEstatus(int estatus){
		List<PrecintosPromotor> lista=null;
		PrecintosPromotorDao dao = new PrecintosPromotorDao();
		lista = dao.findByEstatus(estatus);
		dao = null;
		return lista;
	}
	
	  /**********************************************************************************************
	   * Sincroniza los contratos que fueron asignados al promotor con respecto  alos que ya fueron procesados 
	   * en el boxy
	   * llama un servicio web que hace la relacion devolviendo un objeto sincro
	   * luego el resultado es enviado a una tabla llamada precintos_promotor para cambiar su estatus en caso de que sea ok 
	   * OK == 0 Error SErvidor = -1 Err sin datos = -2 
	   ***********************************************************************************************/
		public String  sincronizar()  throws RemoteException{
			
			/*1003740,1003745,1003749*/
			SincronizarPrecintosProxy sincro = new SincronizarPrecintosProxy();
			Sincro objSincro = sincro.resultPrecintos(boxy,strCadena);
			String msg = objSincro.getDesError();
			String result ="";
			String temp = "";
			int registros;
			
			switch (objSincro.getError()) {
				case 0:
					
					temp = objSincro.getCadena();
					result =  temp.substring(0,temp.length()-1);
					//System.out.println(result);
					PrecintosPromotorDao dao = new  PrecintosPromotorDao();	
					//System.out.println(result);
					registros = dao.actualizarEstatus(result);
					
					if (registros > 0){
						
						msg = msg + " cantidad de registros " + registros + " Sincronizados";
						
					}else{
						
						msg = "Error al intentar cambiar estatus a nivel de BD";
						
					}
					
					return msg;
				case -1:
					return msg;
				case -2:
					return msg;
				default:
					return msg;
			}

		}
		
		public List<PrecintosPromotor> listPrecintoByFiltro(String strSql){
			List<PrecintosPromotor> lista=null;
			PrecintosPromotorDao dao = new PrecintosPromotorDao();
			lista = dao.findByStr(strSql);	
			return lista;
			
		}
	
}
