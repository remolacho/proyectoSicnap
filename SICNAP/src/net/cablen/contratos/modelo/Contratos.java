package net.cablen.contratos.modelo;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import net.cablen.contratos.ws.Abonado;
import net.cablen.contratos.ws.AbonadoByContratoProxy;
import net.cablen.contratos.ws.Sincro;
import net.cablen.contratos.ws.SincronizarContratosProxy;
import net.cablen.helppers.Conexion;
import net.cablen.helppers.Usuario;
import net.cablen.helppers.ValidarCampos;
import net.cablen.promotor.modelo.Promotores;
import net.cablen.promotor.modelo.PromotoresDao;

public class Contratos {
	
    int cantContratos;
    String cedula_promotor;
    String boxy;
    String strContratos;
    long ContratoInicial = 0;
    
    public Contratos(long inicial,int cant,String ced, String boxy){
    	
    	this.cantContratos = cant;
    	this.cedula_promotor = ced;
    	this.boxy = boxy;
    	this.ContratoInicial = inicial;
    	
    }
    
    public Contratos(String boxy,String strContratos){
    	
    	this.strContratos = strContratos;
    	this.boxy = boxy;
    }
    
    public Contratos(){

    }
	
    
    /***********************************************************************************
     * Realiza la asignacion de los contratos a un promotor almacena en dos tablas
     * contratos_promotor he historial_contratos
     * @throws SQLException 
     ***********************************************************************************/  
	public String assignToPromoter(){
		
		String msg ="";
	    long pre_contrato_inicial;
        long pre_contrato_final;
          
		 
	    Promotores promotor;
		ContratosPromotor contPromotor = new ContratosPromotor();
		ContratosPromotorDao daoContrato = new ContratosPromotorDao();
		HistorialContratos historial = new HistorialContratos();
		HistorialContratosDao daoHistorial = new HistorialContratosDao();
		PromotoresDao promotorDao = new PromotoresDao();
		
		pre_contrato_inicial = ContratoInicial;
	    pre_contrato_final = ContratoInicial;
	    promotor = promotorDao.findByCedula(cedula_promotor);
	    	   
	    contPromotor.setPromotores(promotor);

	    contPromotor.setEstatus(0);
	    contPromotor.setFechaRegistro(ValidarCampos.soloFecha());
	    contPromotor.setBoxy(boxy);
	    
	    if(promotor.getEstatus() > 0){
		
	    	long resCont = 0;
		
	    	for(int i=0;i< cantContratos;i++){
			
	    		contPromotor.setCodigoContrato(pre_contrato_final);
			
	    		resCont = daoContrato.guardar(contPromotor);
			
	    		if (resCont < 0){	
	    			msg = "Problemas al ingresar los pre-contratos llamar a sistemas";
	    			return msg;
	    		}
		   
	    		pre_contrato_final ++;
			
	    	}
		
	    	historial.setCantContratos(cantContratos);
	    	historial.setPromotores(promotor);
	    	historial.setFechaAsignado(ValidarCampos.soloFecha());
	    	historial.setContratoInicial(pre_contrato_inicial);
	    	historial.setContratoFinal(pre_contrato_final - 1);
	    	historial.setLoginUser(Usuario.getUser().getLogin());
       
	    	if (daoHistorial.guardar(historial) < 0 ){
        	
	    		msg = "Problemas al ingresar datos en el historial de contratos";
	    		return msg;
        	
	    	}
        
	    	msg = "Se asignaron " + cantContratos + " contratos con exito a promotor";
        
	    	promotor = null;
	    	contPromotor = null;
	    	daoContrato =  null;
	    	historial =  null;
	    	daoHistorial =  null;
	    	promotorDao =  null;
	    	return msg;
	    	
	    }else{
	    		
	    	promotor = null;
	    	contPromotor = null;
	    	daoContrato =  null;
	    	historial =  null;
	    	daoHistorial =  null;
	    	promotorDao =  null;
	    	
			msg = "No se ha encontrado promotor relacionado a ese numero de Cedula";
			return msg;
	    	
	    }
	}
	
	public Promotores cargarPromotor(String cedula){
		
		Promotores promotor;
		PromotoresDao promDao = new PromotoresDao();
		promotor = promDao.findByCedula(cedula);
		promDao = null;
		return promotor;	
	
	}
	
	
	public List<ContratosPromotor> listByProcess(){
		
		
		List<ContratosPromotor> lista=null;
		ContratosPromotorDao contratosDao = new ContratosPromotorDao();
		lista = contratosDao.findByProcess();
		return lista;
		
		
	}
	
	public List<ContratosPromotor> listByPromotor(int cod){

		List<ContratosPromotor> lista=null;
		ContratosPromotorDao contratosDao = new ContratosPromotorDao();
		lista = contratosDao.findByPromotor(cod);	
		return lista;
		
	}
	
   /**********************************************************************************************
   * Sincroniza los contratos que fueron asignados al promotor con respecto  alos que ya fueron procesados 
   * en el boxy
   * llama un servicio web que hace la relacion devolviendo un objeto sincro
   * luego el resultado es enviado a una tabla llamada contratos_promotor para cambiar su estatus en caso de que sea ok 
   * OK == 0 Error SErvidor = -1 Err sin datos = -2 
   ***********************************************************************************************/
	public String  sincronizar()  throws RemoteException{
		
		/*1003740,1003745,1003749*/
		SincronizarContratosProxy sincro = new SincronizarContratosProxy();
		Sincro objSincro = sincro.resultContratos(boxy,strContratos);
		String msg = objSincro.getDesError();
		String result ="";
		String temp = "";
		int registros;
		
		switch (objSincro.getError()) {
			case 0:
				
				temp = objSincro.getCadena();
				result =  temp.substring(0,temp.length()-1);
				ContratosPromotorDao dao = new  ContratosPromotorDao();	
				//System.out.print(result);
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
	
	public List<ContratosPromotor> listContratosByEstatus(int estatus){
		
		List<ContratosPromotor> lista=null;
		ContratosPromotorDao contratosDao = new ContratosPromotorDao();
		lista = contratosDao.findByEstatus(estatus);	
		return lista;
		
		
	} 
	
	public List<ContratosPromotor> listContratosByBoxy(String b){
		List<ContratosPromotor> lista=null;
		ContratosPromotorDao contratosDao = new ContratosPromotorDao();
		lista = contratosDao.findByBoxy(b);	
		return lista;
		
	}
		
	public List<ContratosPromotor> listContratosByFiltro(String strSql){
		List<ContratosPromotor> lista=null;
		ContratosPromotorDao contratosDao = new ContratosPromotorDao();
		lista = contratosDao.findByStr(strSql);	
		return lista;
		
	}
	
	public List<ContratosPromotor> listAll(){
		List<ContratosPromotor> lista=null;
		ContratosPromotorDao contratosDao = new ContratosPromotorDao();
		lista = contratosDao.findAll();	
		return lista;
		
	}
	
	
	public Abonado wsAbonado(String contrato) throws RemoteException{
		
		Abonado abonado = null;
		AbonadoByContratoProxy proxy = new AbonadoByContratoProxy();
		abonado = proxy.resultContrato(contrato);
		return abonado;
		
	}
	
	
}
