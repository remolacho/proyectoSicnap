package net.cablen.caja.conciliaciones.reportes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import net.cablen.caja.conciliaciones.modelo.Conciliaciones;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class DSConciliaciones  implements JRDataSource{

	private List<Conciliaciones> listConc = null;
	private int index;
	
	public DSConciliaciones(List<Conciliaciones> lista) {
		 this.index = -1;
		 this.listConc = lista;
	}
	
	@Override
	public Object getFieldValue(JRField jrField) throws JRException {
		
		Object valor = null;  
	    String logoTipo = "img/logoEmpresarial1.png";
		InputStream is = null;
		
		switch (jrField.getName()){
		
			case "user":
				valor = listConc.get(index).getUserCaja();
				break;
			case "user_sistema":
				valor =listConc.get(index).getUserSistema();
				break;	
			case "oficina":
				valor =listConc.get(index).getOficina();
				break;
			case "fecha":
				valor =listConc.get(index).getFechaCaja();
				break;				
			case "rtpz":
				valor =listConc.get(index).getReporteZ();
				break;				
			case "factI":
				valor = listConc.get(index).getFacturaInicial();
				break;
			case "factF":
				valor = listConc.get(index).getFacturaFinal();
				break;
			case "maquina":
				valor = listConc.get(index).getMaquinaFiscal();
				break;
			case "montoZ":
				valor = listConc.get(index).getMontoZ();
				break;
			case "monto":
				valor = listConc.get(index).getMontoFinal();
				break;
			case "dif":
				valor = listConc.get(index).getDifeMonto();
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
			case "id":
				valor = listConc.get(index).getIdConciliacion();
				break;
			
		}
	
		return valor;
		
	}

	@Override
	public boolean next() throws JRException {
		try {
			return ++index < listConc.size();
		} catch (Exception e) {
			//System.out.println(e.toString());
			return false;
		}
		
	}
	
}
