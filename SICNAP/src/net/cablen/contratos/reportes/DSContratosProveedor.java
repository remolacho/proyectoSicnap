package net.cablen.contratos.reportes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.IOException;
import java.util.List;

import net.cablen.contratos.modelo.ContratosPromotor;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class DSContratosProveedor  implements JRDataSource{

	private List<ContratosPromotor> listaContratos = null;
	private int index;
	
	public DSContratosProveedor(List<ContratosPromotor> lista) {
		 this.index = -1;
		 this.listaContratos = lista;
	}
	
	@Override
	public Object getFieldValue(JRField jrField) throws JRException {
		
		Object valor = null;  
		String logoTipo = "img/logoEmpresarial1.png";
		InputStream is = null;
			
		switch (jrField.getName()){
		
			case "promotor":
				valor = listaContratos.get(index).getPromotores().getNombre() + 
				        " " +listaContratos.get(index).getPromotores().getApellido();
				break;
			case "codigo_contrato":
				valor =listaContratos.get(index).getCodigoContrato();
				break;
			case "fecha_registro":
				valor =listaContratos.get(index).getFechaRegistro();
				break;				
			case "boxy":
				valor =listaContratos.get(index).getBoxy();
				break;				
			case "estatus":
				String estatus ="";
				
				if (listaContratos.get(index).getEstatus() == 0){
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
		return ++index < listaContratos.size();
	}
	
}
