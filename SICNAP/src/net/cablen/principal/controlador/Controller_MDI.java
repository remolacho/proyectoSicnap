package net.cablen.principal.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;


import net.cablen.caja.conciliaciones.vista.FiltroReporteConciliacion;
import net.cablen.caja.conciliaciones.vista.ListaConciliaciones;
import net.cablen.caja.estadoDeCuentas.vista.VistaCargarEstados;
import net.cablen.caja.referencias.vista.FiltroReporteRef;
import net.cablen.caja.referencias.vista.ListaReferencias;
import net.cablen.caja.referencias.vista.AsignarReferencias;
import net.cablen.configuraciones.vista.VistaBancos;
import net.cablen.configuraciones.vista.VistaMaquinas;
import net.cablen.configuraciones.vista.VistaOficina;
import net.cablen.configuraciones.vista.VistaUserCaja;
import net.cablen.contratos.vista.AsignarPreContrato;
import net.cablen.contratos.vista.FiltroReportContrato;
import net.cablen.contratos.vista.SincroContratos;
import net.cablen.contratos.vista.VistaContratoAsignad;
import net.cablen.helppers.Conexion;
import net.cablen.permisos.modelo.PermisosDao;
import net.cablen.precintos.vista.FiltroReportPrecinto;
import net.cablen.precintos.vista.VistaAsignarPrecinto;
import net.cablen.precintos.vista.VistaSincroPrecintos;
import net.cablen.principal.vistas.VistaMDI;
import net.cablen.promotor.vistas.ListPromotor;
import net.cablen.promotor.vistas.VistaPromotor;
import net.cablen.recibos.vista.AsignarRecibos;
import net.cablen.recibos.vista.FiltroReporteRecibos;
import net.cablen.recibos.vista.ListaProcRecibos;
import net.cablen.soporte.callCenter.troubleshooting.vista.VistaFiltroTrou;
import net.cablen.soporte.callCenter.troubleshooting.vista.VistaListTroubleshooting;
import net.cablen.soporte.callCenter.troubleshooting.vista.VistaTroubleshooting;
import net.cablen.soporte.cartera.recuperacion.vista.VistaCarteraApertura;


public class Controller_MDI implements ActionListener,WindowListener,MouseListener{
 
	VistaMDI vista;
	AsignarPreContrato vistaAPC;
	ListPromotor listPromotor;
	PermisosDao perDao;
	
	JDesktopPane content;
	
	public Controller_MDI(VistaMDI mdi){
		
		super();
		vista = mdi;
	    content = vista.formMdi;
    	perDao = new PermisosDao();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == this.vista.sIAsigContratos){
			
			if (perDao.Acceso("AsignarPreContrato") == 1){	
				AsignarPreContrato asignarPreContrato = new AsignarPreContrato("AsignarPreContrato");				
				centrarFrm (asignarPreContrato,vista);
				content.add(asignarPreContrato);// Agregamos el frame al escritorio
				
				try {
					asignarPreContrato.setSelected(true);// Decimos que comience Enfocado				
				} 
				catch (PropertyVetoException e1) {}
			}
			
		}

		
		if (e.getSource() == this.vista.sincroContratos){
			if (perDao.Acceso("SincroContratos") == 1){	
				SincroContratos sicroContratos = new SincroContratos("SincroContratos");				
				centrarFrm (sicroContratos,vista);
				content.add(sicroContratos);// Agregamos el frame al escritorio
				try {
					sicroContratos.setSelected(true);// Decimos que comience Enfocado				
				} 
				catch (PropertyVetoException e1) {}
			}
		}
		
		
		if (e.getSource() == this.vista.sIBuscarPromotor){
			if (perDao.Acceso("VistaPromotor") == 1){	
				VistaPromotor vPromotor = new VistaPromotor("VistaPromotor");				
				centrarFrm (vPromotor,vista);
				content.add(vPromotor);// Agregamos el frame al escritorio
				try {
					vPromotor.setSelected(true);// Decimos que comience Enfocado				
				} 
				catch (PropertyVetoException e1) {}
			}
		}
		
		if(e.getSource() == this.vista.sIReferencia){
			
			if (perDao.Acceso("AsignarReferencias") == 1){
				AsignarReferencias vref = new AsignarReferencias("AsignarReferencias");
				centrarFrm (vref,vista);
				content.add(vref);// Agregamos el frame al escritorio
				try {
					vref.setSelected(true);// Decimos que comience Enfocado				
				} 
				catch (PropertyVetoException e1) {}				
			}
			
		}
		
		if(e.getSource() == this.vista.sIEstCuenta){
			
			if (perDao.Acceso("VistaCargarEstados") == 1){
				VistaCargarEstados vConciliar = new VistaCargarEstados("VistaCargarEstados");
				centrarFrm (vConciliar,vista);
				content.add(vConciliar);// Agregamos el frame al escritorio
				try {
					vConciliar.setSelected(true);// Decimos que comience Enfocado				
				} 
				catch (PropertyVetoException e1) {}				
			}
			
		}

		if(e.getSource() == this.vista.sIViewRefe){
			
			if (perDao.Acceso("ListaReferencias") == 1){
				ListaReferencias listRef = new ListaReferencias("ListaReferencias");
				centrarFrm (listRef,vista);
				content.add(listRef);// Agregamos el frame al escritorio
				try {
					listRef.setSelected(true);// Decimos que comience Enfocado				
				} 
				catch (PropertyVetoException e1) {}				
			}
			
		}
		
		if(e.getSource() == this.vista.sIviewConcilia){
			
			if (perDao.Acceso("ListaConciliaciones") == 1){
				ListaConciliaciones listConc = new ListaConciliaciones("ListaConciliaciones");
				centrarFrm (listConc,vista);
				content.add(listConc);// Agregamos el frame al escritorio
				try {
					listConc.setSelected(true);// Decimos que comience Enfocado				
				} 
				catch (PropertyVetoException e1) {}				
			}
			
		}
		
		if(e.getSource() == this.vista.sIAbobyCont){
			
			if (perDao.Acceso("VistaContratoAsignad") == 1){
				VistaContratoAsignad vCont = new VistaContratoAsignad("VistaContratoAsignad","");
				centrarFrm (vCont,vista);
				content.add(vCont);// Agregamos el frame al escritorio
				try {
					vCont.setSelected(true);// Decimos que comience Enfocado				
				} 
				catch (PropertyVetoException e1) {}				
			}
			
		}
		
		if(e.getSource() == this.vista.sIReportContratos){
			
			if (perDao.Acceso("FiltroReportContrato") == 1){
				FiltroReportContrato filtro = new FiltroReportContrato("FiltroReportContrato");
				centrarFrm (filtro,vista);
				content.add(filtro);// Agregamos el frame al escritorio
				try {
					filtro.setSelected(true);// Decimos que comience Enfocado				
				} 
				catch (PropertyVetoException e1) {}				
			}
			
		}
		
		if(e.getSource() == this.vista.sIReportConciliaciones){
			
			if (perDao.Acceso("FiltroReporteConciliacion") == 1){
				FiltroReporteConciliacion filtro = new FiltroReporteConciliacion("FiltroReporteConciliacion");
				centrarFrm (filtro,vista);
				content.add(filtro);// Agregamos el frame al escritorio
				try {
					filtro.setSelected(true);// Decimos que comience Enfocado				
				} 
				catch (PropertyVetoException e1) {}				
			}
			
		}
		
		
		if(e.getSource() == this.vista.sIReportReferencia){
			
			if (perDao.Acceso("FiltroReporteRef") == 1){
				FiltroReporteRef filtro = new FiltroReporteRef("FiltroReporteRef");
				centrarFrm (filtro,vista);
				content.add(filtro);// Agregamos el frame al escritorio
				try {
					filtro.setSelected(true);// Decimos que comience Enfocado				
				} 
				catch (PropertyVetoException e1) {}				
			}
			
		}
		
		if(e.getSource() == this.vista.sIBancos){
			
			if (perDao.Acceso("VistaBancos") == 1){
				VistaBancos vBanco = new VistaBancos("VistaBancos");
				centrarFrm (vBanco,vista);
				content.add(vBanco);// Agregamos el frame al escritorio
				try {
					vBanco.setSelected(true);// Decimos que comience Enfocado				
				} 
				catch (PropertyVetoException e1) {}				
			}
			
		}
		
		if(e.getSource() == this.vista.sIImpF){
			
			if (perDao.Acceso("VistaMaquinas") == 1){
				VistaMaquinas vMaq = new VistaMaquinas("VistaMaquinas");
				centrarFrm (vMaq,vista);
				content.add(vMaq);// Agregamos el frame al escritorio
				try {
					vMaq.setSelected(true);// Decimos que comience Enfocado				
				} 
				catch (PropertyVetoException e1) {}				
			}
			
		}
		
		if(e.getSource() == this.vista.sICajero){
			
			if (perDao.Acceso("VistaUserCaja") == 1){
				VistaUserCaja vCajero = new VistaUserCaja("VistaUserCaja");
				centrarFrm (vCajero,vista);
				content.add(vCajero);// Agregamos el frame al escritorio
				try {
					vCajero.setSelected(true);// Decimos que comience Enfocado				
				} 
				catch (PropertyVetoException e1) {}				
			}
			
		}
		
		if(e.getSource() == this.vista.sIOficina){
			
			if (perDao.Acceso("VistaOficina") == 1){
				VistaOficina vOfic = new VistaOficina("VistaOficina");
				centrarFrm (vOfic,vista);
				content.add(vOfic);// Agregamos el frame al escritorio
				try {
					vOfic.setSelected(true);// Decimos que comience Enfocado				
				} 
				catch (PropertyVetoException e1) {}				
			}
			
		}
		
		if(e.getSource() == this.vista.sIAsigPrecinto){
			
			if (perDao.Acceso("VistaAsignarPrecinto") == 1){
				VistaAsignarPrecinto vAP = new VistaAsignarPrecinto("VistaAsignarPrecinto");
				centrarFrm (vAP,vista);
				content.add(vAP);// Agregamos el frame al escritorio
				try {
					vAP.setSelected(true);// Decimos que comience Enfocado				
				} 
				catch (PropertyVetoException e1) {}				
			}
			
		}
		
		if(e.getSource() == this.vista.sIProcPrecinto){
			
			if (perDao.Acceso("VistaSincroPrecintos") == 1){
				VistaSincroPrecintos vSP = new VistaSincroPrecintos("VistaSincroPrecintos");
				centrarFrm (vSP,vista);
				content.add(vSP);// Agregamos el frame al escritorio
				try {
					vSP.setSelected(true);// Decimos que comience Enfocado				
				} 
				catch (PropertyVetoException e1) {}				
			}
			
		}
		
		if(e.getSource() == this.vista.sIReportPrecinto){
			
			if (perDao.Acceso("FiltroReportPrecinto") == 1){
				FiltroReportPrecinto vFiltro = new FiltroReportPrecinto("FiltroReportPrecinto");
				centrarFrm (vFiltro,vista);
				content.add(vFiltro);// Agregamos el frame al escritorio
				try {
					vFiltro.setSelected(true);// Decimos que comience Enfocado				
				} 
				catch (PropertyVetoException e1) {}				
			}
			
		}
		
		if(e.getSource() == this.vista.sIRecibo){
			
			if (perDao.Acceso("AsignarRecibos") == 1){
				AsignarRecibos vAsigR = new AsignarRecibos("AsignarRecibos");
				centrarFrm (vAsigR,vista);
				content.add(vAsigR);// Agregamos el frame al escritorio
				try {
					vAsigR.setSelected(true);// Decimos que comience Enfocado				
				} 
				catch (PropertyVetoException e1) {}				
			}
			
		}
		
		if(e.getSource() == this.vista.sIProcRecibo){
			
			if (perDao.Acceso("ListaProcRecibos") == 1){
				ListaProcRecibos vProcR = new ListaProcRecibos("ListaProcRecibos");
				centrarFrm (vProcR,vista);
				content.add(vProcR);// Agregamos el frame al escritorio
				try {
					vProcR.setSelected(true);// Decimos que comience Enfocado				
				} 
				catch (PropertyVetoException e1) {}				
			}
			
		}
		
		if(e.getSource() == this.vista.sIReportRecibo){
			
			if (perDao.Acceso("FiltroReporteRecibos") == 1){
				FiltroReporteRecibos vFiltro= new FiltroReporteRecibos("FiltroReporteRecibos");
				centrarFrm (vFiltro,vista);
				content.add(vFiltro);// Agregamos el frame al escritorio
				try {
					vFiltro.setSelected(true);// Decimos que comience Enfocado				
				} 
				catch (PropertyVetoException e1) {}				
			}
			
		}
		
		if(e.getSource() == this.vista.sITroubleshooting){
			
			if (perDao.Acceso("VistaTroubleshooting") == 1){
				VistaTroubleshooting vTrou= new VistaTroubleshooting("VistaTroubleshooting");
				centrarFrm (vTrou,vista);
				content.add(vTrou);// Agregamos el frame al escritorio
				try {
					vTrou.setSelected(true);// Decimos que comience Enfocado				
				} 
				catch (PropertyVetoException e1) {}				
			}
			
		}
		
		if(e.getSource() == this.vista.sIListCC){
			
			if (perDao.Acceso("VistaListTroubleshooting") == 1){
				VistaListTroubleshooting vTrou= new VistaListTroubleshooting("VistaListTroubleshooting");
				centrarFrm (vTrou,vista);
				content.add(vTrou);// Agregamos el frame al escritorio
				try {
					vTrou.setSelected(true);// Decimos que comience Enfocado				
				} 
				catch (PropertyVetoException e1) {}				
			}
			
		}
		
		if(e.getSource() == this.vista.sIreportCallCenter){
			
			if (perDao.Acceso("VistaFiltroTrou") == 1){
				VistaFiltroTrou vTrou= new VistaFiltroTrou("VistaFiltroTrou");
				centrarFrm (vTrou,vista);
				content.add(vTrou);// Agregamos el frame al escritorio
				try {
					vTrou.setSelected(true);// Decimos que comience Enfocado				
				} 
				catch (PropertyVetoException e1) {}				
			}
			
		}
		
		if(e.getSource() == this.vista.sICartera){
			
			if (perDao.Acceso("VistaCarteraApertura") == 1){
				VistaCarteraApertura vCart= new VistaCarteraApertura("VistaCarteraApertura");
				centrarFrm (vCart,vista);
				content.add(vCart);// Agregamos el frame al escritorio
				try {
					vCart.setSelected(true);// Decimos que comience Enfocado				
				} 
				catch (PropertyVetoException e1) {}				
			}
			
		}
		
	}
	
    public void centrarFrm (JInternalFrame hijo ,VistaMDI padre){		
		 
		 hijo.setLocation(padre.getWidth()/2 - hijo.getWidth()/2 ,
		 padre.getHeight()/2 - hijo.getHeight()/2 - 20); 
		 // CENTRA EL FORMULARIO
		 
	 }

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		Conexion.desconectar();
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == this.vista.getmISalir()){
			vista.dispose();
		}
		
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
		// TODO Auto-generated method stub
		
	}

}
