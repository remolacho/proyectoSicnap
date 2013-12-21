package net.cablen.precintos.reportes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.IOException;
import java.util.List;

import net.cablen.contratos.modelo.ContratosPromotor;
import net.cablen.precintos.modelo.PrecintosPromotor;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class DSPrecintosEnte  implements JRDataSource{

	private List<PrecintosPromotor> listaPrecintos = null;
	private int index;
	
	public DSPrecintosEnte(List<PrecintosPromotor> lista) {
		 this.index = -1;
		 this.listaPrecintos = lista;
	}
	
	@Override
	public Object getFieldValue(JRField jrField) throws JRException {
		
		Object valor = null;  
		String logoTipo = "img/logoEmpresarial1.png";
		InputStream is = null;
			
		switch (jrField.getName()){
		
			case "promotor":
				valor = listaPrecintos.get(index).getPromotores().getNombre() + 
				        " " +listaPrecintos.get(index).getPromotores().getApellido();
				break;
			case "precinto":
				valor =listaPrecintos.get(index).getPrecinto();
				break;
			case "fecha_registro":
				valor =listaPrecintos.get(index).getFechaRegistro();
				break;				
			case "boxy":
				valor =listaPrecintos.get(index).getBoxy();
				break;				
			case "estatus":
				String estatus ="";
				
				if (listaPrecintos.get(index).getEstatus() == 0){
					estatus = "PPB";
				}else{
					estatus = "PEB";
				}
				
				valor = estatus;
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
		return ++index < listaPrecintos.size();
	}
	
}
