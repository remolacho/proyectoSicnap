package net.cablen.caja.referencias.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import net.cablen.caja.conciliaciones.modelo.Conciliacion;
import net.cablen.caja.conciliaciones.modelo.Conciliaciones;
import net.cablen.caja.referencias.modelo.Referencia;
import net.cablen.caja.referencias.modelo.Referencias;
import net.cablen.caja.referencias.reportes.DSReferencias;
import net.cablen.caja.referencias.vista.FiltroReporteRef;
import net.cablen.helppers.Usuario;
import net.cablen.helppers.ValidarCampos;
import net.cablen.principal.vistas.ViewReport;

public class Controller_filtro implements ActionListener{

	FiltroReporteRef filtro = null;
	private String strSql;
	private List<Conciliaciones> listaConciliaciones;
	
	public Controller_filtro(FiltroReporteRef filtro) {
	
		this.filtro = filtro;
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == filtro.getChFecha()){
			if (filtro.getChFecha().isSelected()){
				filtro.getTxtDesde().setEnabled(true);
				filtro.getTxtHasta().setEnabled(true);
			}else{
				filtro.getTxtDesde().setEnabled(false);
				filtro.getTxtHasta().setEnabled(false);
			}
		}
		
		if (e.getSource() == filtro.getrMaquina()){
			Conciliacion objC = new Conciliacion();
			filtro.getCmbGenerico().setModel(new DefaultComboBoxModel(objC.cargarMaquinasFiscales()));
			objC = null;
		}
		
		if (e.getSource() == filtro.getrBanco()){
			Conciliacion objC = new Conciliacion();
			filtro.getCmbGenerico().setModel(new DefaultComboBoxModel(objC.cargarBancos()));
			objC = null;
		}
		
		if (e.getSource() == filtro.getrOficina()){
			Conciliacion objC = new Conciliacion();
			filtro.getCmbGenerico().setModel(new DefaultComboBoxModel(objC.cargarOficinas()));
			objC = null;
		}
		
		if (e.getSource() == filtro.getrUser ()){
			Conciliacion objC = new Conciliacion();
			filtro.getCmbGenerico().setModel(new DefaultComboBoxModel(objC.cargarUserCaja()));
			objC = null;
		}
		
		if (e.getSource() == filtro.getrTipo()){
			Conciliacion objC = new Conciliacion();
			filtro.getCmbGenerico().setModel(new DefaultComboBoxModel(objC.cargarTipoDepo()));
			objC = null;
		}
		
		if (e.getSource() == filtro.getrUserSis()){
			Conciliacion objC = new Conciliacion();
			filtro.getCmbGenerico().setModel(new DefaultComboBoxModel(objC.cargarUserSist()));
			objC = null;
		}
		
		//0 es maquina 1 oficina
		if (e.getSource() == filtro.getCmbGenerico()){
		
			listaConciliaciones=null;
			
			if(filtro.getrMaquina().isSelected()){
				Conciliacion dao = new Conciliacion();
				//System.err.println(filtro.getCmbGenerico().getSelectedItem().toString());
				listaConciliaciones = dao.lista(0, filtro.getCmbGenerico().getSelectedItem().toString());
				dao =null;
			}
			
			
			if(filtro.getrOficina().isSelected()){
				Conciliacion dao = new Conciliacion();
				listaConciliaciones = dao.lista(1, filtro.getCmbGenerico().getSelectedItem().toString());
				dao =null;
			}
			
		}
		
		if (e.getSource() == filtro.getBtmReport()){
		    
			List<Referencias> listaReferencias = null;
			String path="report/referencias/rtpReferencia.jasper",titulo="Referencias Bancarias";
			Referencia ref = new Referencia();
			String inStr = "";
			strSql = "";
			
		    if (filtro.getChFecha().isSelected()){
		    	strSql = "AND fecha_bancaria  BETWEEN '" + ValidarCampos.soloFecha(filtro.getTxtDesde().getDate()) +
                        "' AND '" +  ValidarCampos.soloFecha(filtro.getTxtHasta().getDate()) + "'";		    	
			}else{
				strSql="";
			}
		     
		    
		    if (filtro.getrMaquina().isSelected()){
		    	
		    		
		    		try {
		    			int tamano = listaConciliaciones.size();
		    			for(int i=0;i< tamano;i++){
			    			inStr = inStr + listaConciliaciones.get(i).getIdConciliacion() + ",";
			    		}
			    	
			    		inStr = inStr.substring(0, inStr.length() -1);
			    	
			    		if (!strSql.equals("")){
			    			strSql = strSql + " AND id_conciliacion IN(" + inStr + ")";
			    		}else{
			    			strSql = " AND id_conciliacion IN(" + inStr + ")";
			    		}
			    	
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "No hay registros en esta maquina");
					}
		    	
		    	}
		    
		    	if (filtro.getrOficina().isSelected()){
		    	
		    		
		    		try {
		    			int tamano = listaConciliaciones.size();
		    			for(int i=0;i< tamano;i++){
		    				inStr = inStr + listaConciliaciones.get(i).getIdConciliacion() + ",";
			    		}
			    	    
			    		inStr = inStr.substring(0, inStr.length() -1);
			    	
			    		if (!strSql.equals("")){
			    			strSql = strSql + " AND id_conciliacion IN(" + inStr + ")";
			    		}else{
			    			strSql = " AND id_conciliacion IN(" + inStr + ")";
			    		}
			    	
		    		} catch (Exception e2) {
		    			JOptionPane.showMessageDialog(null, "No hay registros en esta maquina");
					}
		    	
		    	}
		    
		    	if (filtro.getrUser().isSelected()){
		    	   	
		    		try {

			    		if (!strSql.equals("")){
			    			strSql = strSql + " AND user_caja='" + filtro.getCmbGenerico().getSelectedItem().toString() + "'";
			    		}else{
			    			strSql = " AND user_caja='" + filtro.getCmbGenerico().getSelectedItem().toString() + "'";
			    		}
			    	   
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "No hay registros en esta maquina");
					}
		    	
		    	}
		    
		    	if (filtro.getrBanco().isSelected()){
	    	   	
		    		try {

		    			if (!strSql.equals("")){
		    				strSql = strSql + " AND banco='" + filtro.getCmbGenerico().getSelectedItem().toString() + "'";
		    			}else{
		    				strSql = " AND banco='" + filtro.getCmbGenerico().getSelectedItem().toString() + "'";
		    			}
		    	
		    		} catch (Exception e2) {
		    			JOptionPane.showMessageDialog(null, "No hay registros en esta maquina");
		    		}
	    	
		    	}
		    	
		    	if (filtro.getrTipo().isSelected()){
		    	   	
		    		try {

		    			if (!strSql.equals("")){
		    				strSql = strSql + " AND tipo_depo='" + filtro.getCmbGenerico().getSelectedItem().toString() + "'";
		    			}else{
		    				strSql = " AND tipo_depo='" + filtro.getCmbGenerico().getSelectedItem().toString() + "'";
		    			}
		    	
		    		} catch (Exception e2) {
		    			JOptionPane.showMessageDialog(null, "No hay registros en esta maquina");
		    		}
	    	
		    	}
		    	
		    	if (filtro.getrUserSis().isSelected()){
		    	   	
		    		try {

		    			if (!strSql.equals("")){
		    				strSql = strSql + " AND user_sistema='" + filtro.getCmbGenerico().getSelectedItem().toString() + "'";
		    			}else{
		    				strSql = " AND user_sistema='" + filtro.getCmbGenerico().getSelectedItem().toString() + "'";
		    			}
		    	
		    		} catch (Exception e2) {
		    			JOptionPane.showMessageDialog(null, "No hay registros en esta maquina");
		    		}
	    	
		    	}
		    	
		    	
				listaReferencias = ref.listaReferenciaPorFiltro(strSql);
				DSReferencias ds = new DSReferencias(listaReferencias);
				ViewReport report = new ViewReport();
				report.visualizar(ds,path,titulo);
				ds = null;
				ref = null;
				listaReferencias = null;
			}

	}

}
