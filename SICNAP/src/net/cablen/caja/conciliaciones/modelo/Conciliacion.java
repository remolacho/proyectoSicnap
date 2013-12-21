package net.cablen.caja.conciliaciones.modelo;

import java.sql.Ref;
import java.util.ArrayList;
import java.util.List;

import net.cablen.bancos.modelo.BancosDao;
import net.cablen.caja.estadoDeCuentas.modelo.EstadosCuenta;
import net.cablen.caja.estadoDeCuentas.modelo.EstadosCuentaDao;
import net.cablen.caja.maquinaFiscal.modelo.MaquinasFiscales;
import net.cablen.caja.maquinaFiscal.modelo.MaquinasFiscalesDao;
import net.cablen.caja.referencias.modelo.Referencias;
import net.cablen.caja.referencias.modelo.ReferenciasDao;
import net.cablen.caja.usuarios.modelo.UsuariosCajaDao;
import net.cablen.helppers.Usuario;
import net.cablen.oficinas.modelo.OficinasDao;
import net.cablen.usuario.modelo.UsuariosDao;

public class Conciliacion {

	/*
	 * Esta funcion se encarga de validar si hay alguna conciliacion por cerrar en ese usuario
	 * si no exite alguna le asigna una nueva.
	 * */
	
	public int asignarConciliacion(){
		
		int num_conciliacion=0;
		ConciliacionesDao objDao = new ConciliacionesDao();
		num_conciliacion = objDao.findByUserSystem(Usuario.getUser().getLogin());
	
		if (num_conciliacion == 0){//no existe un contenedor de conciliaciones abierto para ese usuario y lo crea
			num_conciliacion = objDao.crearConciliacion();
			if (num_conciliacion > 0){//significa que ha sido creado con exito
				return num_conciliacion;
			}else{		
				return num_conciliacion;			
			}	
		}else{
			return num_conciliacion;
		}

	}
	
    public String[]  cargarUserCaja(){
		
		UsuariosCajaDao objDao = new UsuariosCajaDao();
		
		String[] lista  = new String[objDao.lista().size()];

		for (int i=0; i < lista.length; i++){
			lista[i] = objDao.lista().get(i).getCodigo();
		}
		
		return lista;
		
	}
    
    public String[]  cargarMaquinasFiscales(){
		
		MaquinasFiscalesDao objDao = new MaquinasFiscalesDao();
		
		String[] lista  = new String[objDao.lista().size()];

		for (int i=0; i < lista.length; i++){
			lista[i] = objDao.lista().get(i).getSerial();
		}
		
		return lista;
		
	}
    
    public String[]  cargarOficinas(){
		
  		OficinasDao objDao = new OficinasDao();
  		
  		String[] lista  = new String[objDao.lista().size()];

  		for (int i=0; i < lista.length; i++){
  			lista[i] = objDao.lista().get(i).getOficina();
  		}
  		
  		return lista;
  		
  	}
    
    public String[]  cargarBancos(){
		
  		BancosDao objDao = new BancosDao();
  		
  		String[] lista  = new String[objDao.lista().size()];

  		for (int i=0; i < lista.length; i++){
  			lista[i] = objDao.lista().get(i).getCodigo();
  		}
  		
  		return lista;
  		
  	}
    
    
    public String[]  cargarTipoDepo(){
		
  		OficinasDao objDao = new OficinasDao();

  		String[] lista  = new String[]{"Lote","Deposito","Punto","Error Boxy","Error RptZ",
  				                       "Error Cajero","Error Banco","Desc.Bancario"};
  		return lista;
  		
  	}
    
    public String[]  cargarUserSist(){
		
  		UsuariosDao objDao = new UsuariosDao();
  		
  		String[] lista  = new String[objDao.lista().size()];

  		for (int i=0; i < lista.length; i++){
  			lista[i] = objDao.lista().get(i).getLogin();
  		}
  		
  		return lista;
  		
  	}
    
    
    public List<Referencias> listaXConciliacion(int id,int estatus){
    	
		List<Referencias> lista = null;
		lista = new ReferenciasDao().listByCociliacion(id,estatus);
		return lista;
    	
    }
    
    
    /*
     * Asigna la referencia a la conciliacion abierta por el usuario en session
    */
    public String agregarReferencia(Referencias ref){
    	
    	String msg  ="";
    	int result = 0;
    	
    	ReferenciasDao objDao = new ReferenciasDao();
    	EstadosCuentaDao objDaoEst = new EstadosCuentaDao();
    	
    	result = objDao.agregar(ref);
    	objDao = null;
    	
    	if (result > 0 ){
    		result = objDaoEst.updateEstatus(ref.getReferencia());
    		if (result > 0 ){
    			msg = "";
    		}else{
    			msg = "Problemas al cambiar estatus en estado de cuentas para esta referencia";
    		}
    	}else{   		
    		msg = "Problemas al asignar la referencia";	
    	}
    	
    	ref = null;
    	return msg;
    	
    }
    
    /*
     * Se encarga de cerrar la conciliacion asignada al user de sistema si todas las reglas estan en orden 
    */
    
    public String CerrarConciliacion(Conciliaciones conciliacion){
    	
    	ReferenciasDao objRefDao = new ReferenciasDao();
    	ConciliacionesDao objConDao = new ConciliacionesDao();
    	int result = 0;
    	String msg = "";
    	
    	result = objRefDao.updateUserEstatus(conciliacion.getUserCaja(), conciliacion.getIdConciliacion());
    	
    	if (result > 0){
    		
    		result = objConDao.update(conciliacion);
    		
    		if (result > 0){
    			
    			msg = "";
    			
    		}else{
    			
    			msg = "Error al cerrar la conciliacion llamar a sistemas 2";
    			
    		}
    		
    	}else{
			
			msg = "Error cerrar las referencias llamar a sistemas 1";
			
		}
    	
    	objConDao=null;
    	objRefDao=null;
    	return msg;
    	
    }
    
    public List<Conciliaciones>  cargarConciliaciones(int estatus){
		
  		ConciliacionesDao objDao = new ConciliacionesDao();
  		
  		List<Conciliaciones> lista  =  objDao.listByEstatus(estatus);

  		return lista;
  		
  	}
    
    public List<Conciliaciones> lista(int estatus){
    	
    	List<Conciliaciones> lista = null;
    	ConciliacionesDao dao = new ConciliacionesDao();
    	lista = dao.listByEstatus(estatus);
    	dao = null;
    	return lista;
    	
    }
    
    public List<Conciliaciones> listaPorFiltro(String strSql){
    	
    	List<Conciliaciones> lista = null;
    	ConciliacionesDao dao = new ConciliacionesDao();
    	lista = dao.listByFiltro(strSql);
    	dao = null;
    	return lista;
    	
    }
    
    public List<Conciliaciones> lista(int tipo,String valor){
    	
    	List<Conciliaciones> lista = null;
    	ConciliacionesDao dao = new ConciliacionesDao();
   
    	switch (tipo) {
			case 0:
				lista = dao.listByMaquina(valor);
				break;
			case 1:
				lista = dao.listByOficina(valor);
				break;
			case 2:
				lista = dao.listByUser(valor);
				break;
			case 3:
				lista = dao.listByUserSis(valor);
				break;
			default:
				lista = null;
				break;
		}
    	
    	dao = null;
    	return lista;
    	
    }
    
	
}
