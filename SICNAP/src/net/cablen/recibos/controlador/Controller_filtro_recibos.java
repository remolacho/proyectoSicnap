package net.cablen.recibos.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.List;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import net.cablen.caja.conciliaciones.reportes.DSConciliaciones;
import net.cablen.helppers.Usuario;
import net.cablen.helppers.ValidarCampos;
import net.cablen.permisos.modelo.PermisosDao;
import net.cablen.principal.vistas.ViewReport;
import net.cablen.principal.vistas.VisorMDI;
import net.cablen.principal.vistas.VistaMDI;
import net.cablen.promotor.vistas.ListPromotor;
import net.cablen.recibos.modelo.DetalleRecibos;
import net.cablen.recibos.modelo.Recibo;
import net.cablen.recibos.reporte.DSRecibos;
import net.cablen.recibos.vista.FiltroReporteRecibos;

public class Controller_filtro_recibos implements ActionListener{

	FiltroReporteRecibos vFiltro = null;
	PermisosDao perDao;
	JDesktopPane content;
	
	public Controller_filtro_recibos(FiltroReporteRecibos vista) {
	
		this.vFiltro = vista;
		this.perDao = new PermisosDao();
		this.content = VisorMDI.getFrmMenu().formMdi;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if (e.getSource() == vFiltro.getChFecha()){
			if(vFiltro.getChFecha().isSelected()){
				vFiltro.getTxtDesde().setEnabled(true);
				vFiltro.getTxtHasta().setEnabled(true);
			}else{
				vFiltro.getTxtDesde().setEnabled(false);
				vFiltro.getTxtHasta().setEnabled(false);
			}
		}
		
		if (e.getSource() == vFiltro.getrPromotor()){
				vFiltro.getTxtPromotor().setEnabled(true);
				vFiltro.getBtmEnte().setEnabled(true);
				vFiltro.getTxtRInicial().setEnabled(false);
				vFiltro.getTxtRFinal().setEnabled(false);
				vFiltro.getTxtCajero().setEnabled(false);
				vFiltro.getTxtAbonado().setEnabled(false);
				vFiltro.getTxtRInicial().setText("");
				vFiltro.getTxtRFinal().setText("");
				vFiltro.getTxtCajero().setText("");
				vFiltro.getTxtAbonado().setText("");
		}
		
		if (e.getSource() == vFiltro.getrRecibo()){
			vFiltro.getTxtPromotor().setEnabled(false);
			vFiltro.getBtmEnte().setEnabled(false);
			vFiltro.getTxtRInicial().setEnabled(true);
			vFiltro.getTxtRFinal().setEnabled(true);
			vFiltro.getTxtCajero().setEnabled(false);
			vFiltro.getTxtAbonado().setEnabled(false);
			
			vFiltro.getTxtPromotor().setText("");
			vFiltro.getTxtCajero().setText("");
			vFiltro.getTxtAbonado().setText("");
			
		}
		
		if (e.getSource() == vFiltro.getrUser()){
			vFiltro.getTxtPromotor().setEnabled(false);
			vFiltro.getBtmEnte().setEnabled(false);
			vFiltro.getTxtRInicial().setEnabled(false);
			vFiltro.getTxtRFinal().setEnabled(false);
			vFiltro.getTxtCajero().setEnabled(true);
			vFiltro.getTxtAbonado().setEnabled(false);
			
			vFiltro.getTxtRInicial().setText("");
			vFiltro.getTxtRFinal().setText("");
			vFiltro.getTxtPromotor().setText("");
			vFiltro.getTxtAbonado().setText("");
		}
		
		if (e.getSource() == vFiltro.getrAbonado()){
			vFiltro.getTxtPromotor().setEnabled(false);
			vFiltro.getBtmEnte().setEnabled(false);
			vFiltro.getTxtRInicial().setEnabled(false);
			vFiltro.getTxtRFinal().setEnabled(false);
			vFiltro.getTxtCajero().setEnabled(false);
			vFiltro.getTxtAbonado().setEnabled(true);
			
			vFiltro.getTxtRInicial().setText("");
			vFiltro.getTxtRFinal().setText("");
			vFiltro.getTxtPromotor().setText("");
			vFiltro.getTxtCajero().setText("");
			
		}
		
		if (e.getSource() == vFiltro.getBtmEnte()){
			if (perDao.Acceso("ListPromotor") == 1){
				ListPromotor vistaListPromotor = new ListPromotor("Lista de Promotores",this.vFiltro);				
				centrarFrm (vistaListPromotor,VisorMDI.getFrmMenu());
				content.add(vistaListPromotor);// Agregamos el frame al escritorio
				try {
					vistaListPromotor.setSelected(true);// Decimos que comience Enfocado				
				} 
				catch (PropertyVetoException e1) {}
			}
		}
		
		if (e.getSource() == vFiltro.getBtmReport()){
			
			String querySql ="";
			String path="report/recibos/rtpRecibos.jasper",titulo="Recibos";

			if (vFiltro.getChFecha().isSelected()){
			
				if (vFiltro.getTxtDesde().getDate() != null && vFiltro.getTxtHasta().getDate() != null){
					
					querySql = "WHERE d.fecha_recibo BETWEEN '" +  ValidarCampos.soloFecha(vFiltro.getTxtDesde().getDate()) +
							   "' AND '" +  ValidarCampos.soloFecha(vFiltro.getTxtHasta().getDate())+ "' ";
					
					if (vFiltro.getrPromotor().isSelected()){
						querySql = querySql + "AND r.codigo_promotor=" + vFiltro.getTxtPromotor().getText();
					}
					
					if (vFiltro.getrRecibo().isSelected()){
						if (!vFiltro.getTxtRInicial().getText().equals("") && !vFiltro.getTxtRFinal().getText().equals("")){
							querySql = querySql + "AND d.codigo_recibo >=" + vFiltro.getTxtRInicial().getText() +
									   " AND  d.codigo_recibo <=" + vFiltro.getTxtRFinal().getText();
						}else{
							JOptionPane.showMessageDialog(null, "Debes dar un rango de busqueda");
						}
					}
					
					if (vFiltro.getrUser().isSelected()){
						querySql = querySql + "AND d.user_caja='" + vFiltro.getTxtCajero().getText() + "'";
					}
					
					if (vFiltro.getrAbonado().isSelected()){
						querySql = querySql + "AND d.abonado='" + vFiltro.getTxtAbonado().getText() + "'";
					}
					
				}
				
			}else{
				
				if (vFiltro.getrPromotor().isSelected()){
					querySql = "WHERE r.codigo_promotor=" + vFiltro.getTxtPromotor().getText();
				}
				
				if (vFiltro.getrRecibo().isSelected()){
					if (!vFiltro.getTxtRInicial().getText().equals("") && !vFiltro.getTxtRFinal().getText().equals("")){
						querySql = "WHERE d.codigo_recibo >=" + vFiltro.getTxtRInicial().getText() +
								   " AND  d.codigo_recibo <=" + vFiltro.getTxtRFinal().getText();
					}else{
						JOptionPane.showMessageDialog(null, "Debes dar un rango de busqueda");
					}
				}
				
				if (vFiltro.getrUser().isSelected()){
					querySql = "WHERE d.user_caja='" + vFiltro.getTxtCajero().getText() + "'";
				}
				
				if (vFiltro.getrAbonado().isSelected()){
					querySql = "WHERE d.abonado='" + vFiltro.getTxtAbonado().getText() + "'";
				}
			
			}
			
			
			try {
				Recibo modelo = new Recibo();
				List<DetalleRecibos> detalle = modelo.listDetalleByFiltro(querySql);
				DSRecibos ds = new DSRecibos(detalle);
				ViewReport report = new ViewReport();
				report.visualizar(ds,path,titulo);
				ds = null;
				detalle = null;
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}

	}
	
    public void centrarFrm (JInternalFrame hijo ,VistaMDI padre){		
		 
		 hijo.setLocation(padre.getWidth()/2 - hijo.getWidth()/2 ,
		 padre.getHeight()/2 - hijo.getHeight()/2 - 20); 
		 // CENTRA EL FORMULARIO
		 
	 }

}
