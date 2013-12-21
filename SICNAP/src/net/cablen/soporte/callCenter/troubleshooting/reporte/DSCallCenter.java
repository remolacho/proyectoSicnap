package net.cablen.soporte.callCenter.troubleshooting.reporte;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.IOException;
import java.util.List;

import net.cablen.contratos.modelo.ContratosPromotor;
import net.cablen.precintos.modelo.PrecintosPromotor;
import net.cablen.soporte.callCenter.troubleshooting.modelo.Troubleshooting;
import net.cablen.soporte.ws.Abonado;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class DSCallCenter  implements JRDataSource{

	private List<Troubleshooting> listaIncidencias = null;
	private int index;
	private String orderBy;
	
	public DSCallCenter(List<Troubleshooting> lista ,String order) {
		 this.index = -1;
		 this.listaIncidencias = lista;
		 this.orderBy = order;
	}
	
	@Override
	public Object getFieldValue(JRField jrField) throws JRException {
		
		Object valor = null;  
		String logoTipo = "img/logoEmpresarial1.png";
		InputStream is = null;
			
		switch (jrField.getName()){
		
			case "incidencia":
				valor = listaIncidencias.get(index).getIncidencia();
				break;
			case "abonado":		
				valor = listaIncidencias.get(index).getAbonado();
				break;
			case "user_sistema":
				valor = listaIncidencias.get(index).getUserSistema();
				break;
			case "fecha_apertura":
				valor = listaIncidencias.get(index).getFechaApertura();
				break;	
			case "fecha_cierre":
				valor = listaIncidencias.get(index).getFechaCierre();
				break;	
			case "Actividad":
				valor = listaIncidencias.get(index).getTshActividades().getActividad();
				break;				
			case "Estatus":		
				valor = listaIncidencias.get(index).getTshEstatus().getDescripcion();
				break;
			case "detalle_reclamo":		
				valor = listaIncidencias.get(index).getDetalleReclamo();
				break;
			case "comentario_inicial":		
				valor = listaIncidencias.get(index).getComentarioInicial();
				break;
			case "comentario_final":		
				valor = listaIncidencias.get(index).getComentarioFinal();
				break;
			case "order":	
				switch (orderBy) {
					case "incidencia":
						valor = listaIncidencias.get(index).getIncidencia();
						break;
					case "user":
						valor = listaIncidencias.get(index).getUserSistema();
						break;
					case "act":
						valor = listaIncidencias.get(index).getTshActividades().getActividad();
						break;
					case "abo":
						valor = listaIncidencias.get(index).getAbonado();
						break;
					default:
						valor = "";
						break;
				}				
				break;
			case "logo":
				try {
					is = new FileInputStream(logoTipo);
					valor = is;
					//is.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
		}
	
		return valor;
		
	}

	@Override
	public boolean next() throws JRException {
		return ++index < listaIncidencias.size();
	}
	
}
