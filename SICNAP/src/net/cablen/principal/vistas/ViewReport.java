package net.cablen.principal.vistas;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ViewReport {

	private JasperReport reporte;
	
	public void visualizar(JRDataSource ds,String path, String titulo){
		
		try {
			
			reporte = (JasperReport) JRLoader.loadObject(path);
			JasperPrint jasperPrint =JasperFillManager.fillReport(reporte, null,ds);
			
			JasperViewer view = new JasperViewer(jasperPrint,false);
			view.setTitle(titulo);
			view.setVisible(true);
			
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}
	
}
