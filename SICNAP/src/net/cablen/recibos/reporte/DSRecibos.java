package net.cablen.recibos.reporte;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import net.cablen.caja.conciliaciones.modelo.Conciliaciones;
import net.cablen.recibos.modelo.DetalleRecibos;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class DSRecibos  implements JRDataSource{

	private List<DetalleRecibos> listDetalle = null;
	private int index;
	
	public DSRecibos(List<DetalleRecibos> lista) {
		 this.index = -1;
		 this.listDetalle = lista;
	}
	
	@Override
	public Object getFieldValue(JRField jrField) throws JRException {
		
		Object valor = null;  
	    String logoTipo = "img/logoEmpresarial1.png";
		InputStream is = null;
		
		switch (jrField.getName()){
		
			case "user_caja":
				valor = listDetalle.get(index).getUserCaja();
				break;
			case "codigo_recibo":
				valor =listDetalle.get(index).getRecibosPromotor().getCodigoRecibo();
				break;
			case "abonado":
				valor =listDetalle.get(index).getAbonado();
				break;				
			case "titular":
				valor =listDetalle.get(index).getTitular();
				break;				
			case "fecha_recibo":
				valor = listDetalle.get(index).getFechaRecibo();
				break;
			case "user_sistema":
				valor = listDetalle.get(index).getUserSistema();
				break;
			case "promotor":
				valor = listDetalle.get(index).getRecibosPromotor().getPromotor().getNombre() + " "  +
			            listDetalle.get(index).getRecibosPromotor().getPromotor().getApellido();
				break;
			case "monto":
				valor = listDetalle.get(index).getMonto();
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
		try {
			return ++index < listDetalle.size();
		} catch (Exception e) {
			//System.out.println(e.toString());
			return false;
		}
		
	}
	
}
