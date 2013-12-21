package net.cablen.soporte.callCenter.troubleshooting.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import net.cablen.helppers.ValidarCampos;
import net.cablen.principal.vistas.ViewReport;
import net.cablen.soporte.actividades.modelo.TshActividades;
import net.cablen.soporte.callCenter.troubleshooting.modelo.CallCenter;
import net.cablen.soporte.callCenter.troubleshooting.modelo.Troubleshooting;
import net.cablen.soporte.callCenter.troubleshooting.reporte.DSCallCenter;
import net.cablen.soporte.callCenter.troubleshooting.vista.VistaFiltroTrou;
import net.cablen.usuario.modelo.Usuarios;
import net.cablen.usuario.modelo.UsuariosDao;

public class Controller_filtro_trou implements ActionListener,MouseListener,InternalFrameListener {
	
	VistaFiltroTrou vFiltro = null;
	
	public Controller_filtro_trou(VistaFiltroTrou vista) {
		// TODO Auto-generated constructor stub
		this.vFiltro = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.vFiltro.getBtmBuscar()){
			String path="",titulo="";
			String sqlLike  ="";
			String orderBy ="";
			String tipoOrden = "";
			
			if (this.vFiltro.getChFecha().isSelected()){
			
				try {
					sqlLike = " AND t.fecha_apertura BETWEEN '" + ValidarCampos.soloFecha(this.vFiltro.getfDesde().getDate()) + 
							  "' AND '" + ValidarCampos.soloFecha(this.vFiltro.getfHasta().getDate()) + "'";
				} catch (Exception e2) {
					sqlLike = "";
				}

			}else{
				sqlLike = "";
			}
			
					
			if (this.vFiltro.getrTodas().isSelected()){
				sqlLike  = sqlLike + "";
			}
			
			if (this.vFiltro.getrAbiertas().isSelected()){
				sqlLike  = sqlLike + " AND t.id_estatus_tsh <= 1001";
			}
			
			if (this.vFiltro.getrCerradas().isSelected()){
				sqlLike  = sqlLike + " AND t.id_estatus_tsh > 1001";
			}
			
			
			if (this.vFiltro.getrInc().isSelected()){
				sqlLike  = sqlLike + " AND t.incidencia ='" + this.vFiltro.getTxtInc().getText() + "'";
				orderBy =  "ORDER BY t.incidencia";
				tipoOrden = "incidencia";
			}
			
			if (this.vFiltro.getrUser().isSelected()){
				sqlLike  = sqlLike + " AND t.user_sistema ='" + this.vFiltro.getCmbUser().getSelectedItem().toString() + "'";
				orderBy =  "ORDER BY t.user_sistema";
				tipoOrden = "user";
			}
			
			if (this.vFiltro.getrAct().isSelected()){
				sqlLike  = sqlLike + " AND t.id_actividad_tsh =" + this.vFiltro.getCmbAct().getSelectedItem().toString().substring(0,4) ;
				orderBy =  "ORDER BY t.id_actividad_tsh";
				tipoOrden = "act";
			}
			
			if (this.vFiltro.getrAbo().isSelected()){
				sqlLike  = sqlLike + " AND t.abonado ='" + this.vFiltro.getTxtAbo().getText()  + "'";
				orderBy =  "ORDER BY t.abonado";
				tipoOrden = "abo";
			} 
					
			if (this.vFiltro.getrGlobal().isSelected()){
				 path="report/callCenter/rtpCCGeneral.jasper";
				 titulo="Control de Incidencias General";
				 orderBy ="";
			}else{
				
				 path="report/callCenter/rtpCCDetallado.jasper";
				 titulo="Control de Incidencias Detallado";
			}
			
			sqlLike = sqlLike + " " + orderBy;
			
			CallCenter cc = new CallCenter();
			List<Troubleshooting> lista = null;
			lista = cc.listByFilter(sqlLike);
			
			DSCallCenter ds = new DSCallCenter(lista,tipoOrden);
			ViewReport report = new ViewReport();
			
			report.visualizar(ds,path,titulo);
			ds = null;
			lista = null;
			cc = null;
			
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		
		if (e.getSource() ==  this.vFiltro.getChFecha()){
			if (this.vFiltro.getChFecha().isSelected()){
				this.vFiltro.getfDesde().setEnabled(true);
				this.vFiltro.getfHasta().setEnabled(true);
			}else{
				this.vFiltro.getfDesde().setEnabled(false);
				this.vFiltro.getfHasta().setEnabled(false);
			}
		}
		
		if (e.getSource() ==  this.vFiltro.getrInc()){
			if ( this.vFiltro.getrInc().isSelected()){
				this.vFiltro.getTxtInc().setEnabled(true);
				this.vFiltro.getCmbUser().setEnabled(false);
				this.vFiltro.getCmbAct().setEnabled(false);
				this.vFiltro.getTxtAbo().setEnabled(false);
			}
		}
		
		if (e.getSource() ==  this.vFiltro.getrUser()){
			if ( this.vFiltro.getrUser().isSelected()){
				this.vFiltro.getTxtInc().setEnabled(false);
				this.vFiltro.getCmbUser().setEnabled(true);
				this.vFiltro.getCmbAct().setEnabled(false);
				this.vFiltro.getTxtAbo().setEnabled(false);
			}
		}
		
		if (e.getSource() ==  this.vFiltro.getrAct()){
			if (this.vFiltro.getrAct().isSelected()){
				this.vFiltro.getTxtInc().setEnabled(false);
				this.vFiltro.getCmbUser().setEnabled(false);
				this.vFiltro.getCmbAct().setEnabled(true);
				this.vFiltro.getTxtAbo().setEnabled(false);
			}
		}
		
		if (e.getSource() ==  this.vFiltro.getrAbo()){
			if ( this.vFiltro.getrAbo().isSelected()){
				this.vFiltro.getTxtInc().setEnabled(false);
				this.vFiltro.getCmbUser().setEnabled(false);
				this.vFiltro.getCmbAct().setEnabled(false);
				this.vFiltro.getTxtAbo().setEnabled(true);
			}
		}
		
	}

	@Override
	public void internalFrameActivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameClosed(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameClosing(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameIconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameOpened(InternalFrameEvent e) {
        
		List<TshActividades> listaAct = null;
        List<Usuarios> listUser = null;
		CallCenter cc = new CallCenter();
		UsuariosDao user = new UsuariosDao();
		listaAct = cc.cargarActividades();
		listUser = user.lista();
		
		DefaultComboBoxModel modelAct= new DefaultComboBoxModel();
		this.vFiltro.getCmbAct().setModel(modelAct);
	    int tamano = listaAct.size();
	    for (int i=0;i< tamano;i++){
	    	  modelAct.addElement(listaAct.get(i).getIdActividad()  + " - " + listaAct.get(i).getActividad()); 
	    }
		
		DefaultComboBoxModel modelU= new DefaultComboBoxModel();
		this.vFiltro.getCmbUser().setModel(modelU);
	    tamano = listUser.size();
	    for (int i=0;i< tamano;i++){
	    	  modelU.addElement(listUser.get(i).getLogin()); 
	    }
	    
	    listaAct = null;
	    listUser = null;
		user =null;
		cc= null;
		
	}
	
	

}
