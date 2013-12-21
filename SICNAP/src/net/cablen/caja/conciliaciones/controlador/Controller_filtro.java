package net.cablen.caja.conciliaciones.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import net.cablen.caja.conciliaciones.modelo.Conciliacion;
import net.cablen.caja.conciliaciones.modelo.Conciliaciones;
import net.cablen.caja.conciliaciones.reportes.DSConciliaciones;
import net.cablen.caja.conciliaciones.vista.FiltroReporteConciliacion;
import net.cablen.caja.referencias.reportes.DSReferencias;
import net.cablen.helppers.Usuario;
import net.cablen.helppers.ValidarCampos;
import net.cablen.principal.vistas.ViewReport;

public class Controller_filtro implements ActionListener{
	
		FiltroReporteConciliacion filtro;
		private String strSql;
		private String valor ="";
		private List<Conciliaciones> listConciliaciones;
		
		public Controller_filtro(FiltroReporteConciliacion vista) {
			// TODO Auto-generated constructor stub
			this.filtro = vista;
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
			
			if (e.getSource() == filtro.getrUSist()){
				Conciliacion objC = new Conciliacion();
				filtro.getCmbGenerico().setModel(new DefaultComboBoxModel(objC.cargarUserSist()));
				objC = null;
			}
			
			
			if (e.getSource() == filtro.getCmbGenerico()){

				if(filtro.getrMaquina().isSelected()){
					valor =  filtro.getCmbGenerico().getSelectedItem().toString();
				}
				
				
				if(filtro.getrOficina().isSelected()){
					valor =  filtro.getCmbGenerico().getSelectedItem().toString();
				}
				
				if(filtro.getrUser().isSelected()){
					valor =  filtro.getCmbGenerico().getSelectedItem().toString();
				}
				
				if(filtro.getrUSist().isSelected()){
					valor =  filtro.getCmbGenerico().getSelectedItem().toString();
				}
				
				
			}
			
			//0 es maquina 1 oficina 2 user 3 sistema
			if (e.getSource() == filtro.getBtmReport()){
				
				String path="report/referencias/rtpConciliacion.jasper",titulo="Conciliaciones";
				String strSql = "";
				
				if (!filtro.getChFecha().isSelected()){
				
					listConciliaciones=null;
					
					if(filtro.getrMaquina().isSelected()){
						Conciliacion dao = new Conciliacion();
						//System.err.println(filtro.getCmbGenerico().getSelectedItem().toString());
						listConciliaciones = dao.lista(0, filtro.getCmbGenerico().getSelectedItem().toString());
						dao =null;
					}
								
					if(filtro.getrOficina().isSelected()){
						Conciliacion dao = new Conciliacion();
						listConciliaciones = dao.lista(1, filtro.getCmbGenerico().getSelectedItem().toString());
						dao =null;
					}
					
					if(filtro.getrUser().isSelected()){
						Conciliacion dao = new Conciliacion();
						listConciliaciones = dao.lista(2, filtro.getCmbGenerico().getSelectedItem().toString());
						dao =null;
					}
					
					if(filtro.getrUSist().isSelected()){
						Conciliacion dao = new Conciliacion();
						listConciliaciones = dao.lista(3, filtro.getCmbGenerico().getSelectedItem().toString());
						dao =null;
					}
					
				}else{
					
					strSql = " WHERE fecha_caja BETWEEN '" + ValidarCampos.soloFecha(filtro.getTxtDesde().getDate()) +
                             "' AND '" +  ValidarCampos.soloFecha(filtro.getTxtHasta().getDate()) + "'";
					
					if(filtro.getrMaquina().isSelected()){
						strSql = strSql + " AND maquina_fiscal='" + valor  + "' AND estatus=1";
					}
								
					if(filtro.getrOficina().isSelected()){
						strSql = strSql + " AND oficina='" + valor + "' AND estatus=1";
					}
					
					if(filtro.getrUser().isSelected()){
						strSql = strSql + " AND user_caja='" + valor + "' AND estatus=1";
					}
					
					if(filtro.getrUSist().isSelected()){
						strSql = strSql + " AND user_sistema='" + valor + "' AND estatus=1";
					}
					
					Conciliacion dao = new Conciliacion();
					listConciliaciones = dao.listaPorFiltro(strSql);
					dao = null;
					
				}
				
				DSConciliaciones ds = new DSConciliaciones(listConciliaciones);
				ViewReport report = new ViewReport();
				report.visualizar(ds,path,titulo);
				ds = null;
				listConciliaciones = null;
			
			}
			
			

		}
}
