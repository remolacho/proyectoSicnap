package net.cablen.caja.referencias.reportes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import net.cablen.caja.referencias.modelo.Referencias;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class DSReferencias  implements JRDataSource{

	private List<Referencias> listaRef = null;
	private int index;
	
	public DSReferencias(List<Referencias> lista) {
		 this.index = -1;
		 this.listaRef = lista;
	}
	
	@Override
	public Object getFieldValue(JRField jrField) throws JRException {
		
		Object valor = null;  
	    String logoTipo = "img/logoEmpresarial1.png";
	    InputStream is = null;
		
	    switch (jrField.getName()){
		
			case "banco":
				valor = listaRef.get(index).getBanco();
				break;
			case "referencia":
				valor =listaRef.get(index).getReferencia();
				break;
			case "user_caja":
				valor =listaRef.get(index).getUserCaja();
				break;
			case "user_sistema":
				valor =listaRef.get(index).getUserSistema();
				break;	
			case "fecha":
				valor =listaRef.get(index).getFechaBancaria();
				break;				
			case "tipo":
				valor = listaRef.get(index).getTipoDepo();
				break;
			case "monto":
				valor = listaRef.get(index).getMonto();
				break;
			case "id_conciliacion":
				valor = listaRef.get(index).getConciliaciones().getIdConciliacion();
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
		return ++index < listaRef.size();
	}
	
}
