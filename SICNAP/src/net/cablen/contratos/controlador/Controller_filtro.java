package net.cablen.contratos.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;
import java.util.List;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

import net.cablen.contratos.modelo.Contratos;
import net.cablen.contratos.modelo.ContratosPromotor;
import net.cablen.contratos.reportes.DSContratosProveedor;
import net.cablen.contratos.vista.FiltroReportContrato;
import net.cablen.helppers.Usuario;
import net.cablen.helppers.ValidarCampos;
import net.cablen.permisos.modelo.PermisosDao;
import net.cablen.principal.vistas.ViewReport;
import net.cablen.principal.vistas.VisorMDI;
import net.cablen.principal.vistas.VistaMDI;
import net.cablen.promotor.vistas.ListPromotor;
import net.cablen.promotor.vistas.VistaPromotor;

public class Controller_filtro implements ActionListener,MouseListener{

	private JDesktopPane content;
	PermisosDao perDao;
	FiltroReportContrato vfiltro;
	private int  fecha =  0,promotor = 0;
	
	public Controller_filtro(FiltroReportContrato vista) {
		this.content = VisorMDI.getFrmMenu().formMdi;
		this.perDao = new PermisosDao();
		this.vfiltro = vista;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == vfiltro.getChFecha()){
			if (vfiltro.getChFecha().isSelected()){	
				vfiltro.getTxtDesde().setEnabled(true);
				vfiltro.getTxtHasta().setEnabled(true);
				fecha = 1;
			}else{
				vfiltro.getTxtDesde().setEnabled(false);
				vfiltro.getTxtHasta().setEnabled(false);
				fecha = 0;
			}
		}
		
		if (e.getSource() == vfiltro.getChProve()){
			if (vfiltro.getChProve().isSelected()){
				vfiltro.getTxtPromotor().setEnabled(true);
				vfiltro.getBtmProveedor().setEnabled(true);
				promotor = 1;
			}else{
				vfiltro.getTxtPromotor().setEnabled(false);
				vfiltro.getBtmProveedor().setEnabled(false);
				promotor = 0;
			}
		}
		
		if (e.getSource() == vfiltro.getBtmProveedor()){
				ListPromotor vProm = new ListPromotor("Promotor",this.vfiltro);				
				centrarFrm (vProm,VisorMDI.getFrmMenu());
				content.add(vProm);// Agregamos el frame al escritorio
				try {
					vProm.setSelected(true);// Decimos que comience Enfocado				
				} 
				catch (PropertyVetoException e1) {}
		}
		
		if (e.getSource() ==  vfiltro.getBtmBuscar()){
			
			String path = "report/contratos/rContratosAC.jasper";
			String titulo = "Contratos por promotor";
			String strSql = "";
			String estatus = vfiltro.getCmbEstatus().getSelectedItem().toString();
			
			strSql = estatus;
			
			if (fecha == 1 && promotor == 1){
				
				strSql = strSql + " AND fecha_registro BETWEEN '" + ValidarCampos.soloFecha(vfiltro.getTxtDesde().getDate()) +
                        "' AND '" + ValidarCampos.soloFecha(vfiltro.getTxtHasta().getDate()) + 
                        "' AND codigo_promotor=" + vfiltro.getTxtPromotor().getText();
				
			}else if(fecha == 1 && promotor == 0){
				
				strSql = strSql + " AND fecha_registro BETWEEN '" + ValidarCampos.soloFecha(vfiltro.getTxtDesde().getDate()) +
                        "' AND '" +  ValidarCampos.soloFecha(vfiltro.getTxtHasta().getDate()) + "'";
				
			}else if (fecha == 0 && promotor == 1){
			
				strSql = strSql + " AND codigo_promotor=" + vfiltro.getTxtPromotor().getText();
		
			}
			
			Contratos modelo = new Contratos();
			List<ContratosPromotor> lista = modelo.listContratosByFiltro(strSql);
			DSContratosProveedor ds = new DSContratosProveedor(lista);
			ViewReport report = new ViewReport();
			report.visualizar(ds,path,titulo);
			ds = null;
			modelo = null;
			lista = null;
			
		}
		
	}
	
    public void centrarFrm (JInternalFrame hijo ,VistaMDI padre){		
		 
		 hijo.setLocation(padre.getWidth()/2 - hijo.getWidth()/2 ,
		 padre.getHeight()/2 - hijo.getHeight()/2 - 20); 
		 // CENTRA EL FORMULARIO
		 
	 }

}
