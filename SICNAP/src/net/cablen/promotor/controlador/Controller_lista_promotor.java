package net.cablen.promotor.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;
import java.util.List;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

import net.cablen.contratos.vista.AsignarPreContrato;
import net.cablen.contratos.vista.FiltroReportContrato;
import net.cablen.permisos.modelo.PermisosDao;
import net.cablen.precintos.vista.FiltroReportPrecinto;
import net.cablen.precintos.vista.VistaAsignarPrecinto;
import net.cablen.principal.vistas.VistaMDI;
import net.cablen.promotor.modelo.Promotor;
import net.cablen.promotor.modelo.Promotores;
import net.cablen.promotor.vistas.ListPromotor;
import net.cablen.promotor.vistas.VistaPromotor;
import net.cablen.recibos.vista.AsignarRecibos;
import net.cablen.recibos.vista.FiltroReporteRecibos;
import net.cablen.recibos.vista.ListaProcRecibos;

public class Controller_lista_promotor implements InternalFrameListener,MouseListener,CaretListener,ActionListener{

	private ListPromotor vistaListPromotor;
	private VistaMDI vistaMdi;
	private AsignarPreContrato vistaAsignarPreContrato;
	private JDesktopPane content;
	PermisosDao perDao;
	FiltroReportContrato vfiltroC=null;
	FiltroReportPrecinto vFiltroP = null;
	FiltroReporteRecibos vFiltroR = null;
	VistaAsignarPrecinto vAsigPre = null;
	AsignarRecibos vAsigR = null;
	ListaProcRecibos vListPR=null;
	
	public Controller_lista_promotor(VistaMDI mdi ,ListPromotor vista){
	
		this.vistaListPromotor = vista;
		this.vistaMdi = mdi;
		this.content = vistaMdi.formMdi;
		this.perDao = new PermisosDao();
		
	}

	public Controller_lista_promotor(VistaMDI mdi,ListPromotor vistaP,FiltroReportContrato vista){
		
		this.vfiltroC = vista;
		this.vistaListPromotor = vistaP;
		this.vistaMdi = mdi;
		this.content = vistaMdi.formMdi;
		this.perDao = new PermisosDao();
		
	}
	
	public Controller_lista_promotor(VistaMDI mdi,ListPromotor vistaP,AsignarRecibos vista){
		
		this.vAsigR = vista;
		this.vistaListPromotor = vistaP;
		this.vistaMdi = mdi;
		this.content = vistaMdi.formMdi;
		this.perDao = new PermisosDao();
		
	}
	
	public Controller_lista_promotor(VistaMDI mdi,ListPromotor vistaP,FiltroReportPrecinto vista){
		
		this.vFiltroP = vista;
		this.vistaListPromotor = vistaP;
		this.vistaMdi = mdi;
		this.content = vistaMdi.formMdi;
		this.perDao = new PermisosDao();
		
	}
	
	public Controller_lista_promotor(VistaMDI mdi,ListPromotor vistaP,FiltroReporteRecibos vista){
		
		this.vFiltroR = vista;
		this.vistaListPromotor = vistaP;
		this.vistaMdi = mdi;
		this.content = vistaMdi.formMdi;
		this.perDao = new PermisosDao();
		
	}
	
	public Controller_lista_promotor(VistaMDI mdi,ListPromotor vistaP,ListaProcRecibos vista){
		
		this.vListPR = vista;
		this.vistaListPromotor = vistaP;
		this.vistaMdi = mdi;
		this.content = vistaMdi.formMdi;
		this.perDao = new PermisosDao();
		
	}
	
	public Controller_lista_promotor(VistaMDI mdi,ListPromotor vistaP,VistaAsignarPrecinto vista){
		
		this.vAsigPre = vista;
		this.vistaListPromotor = vistaP;
		this.vistaMdi = mdi;
		this.content = vistaMdi.formMdi;
		this.perDao = new PermisosDao();
		
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
		
		List<Promotores> lista = null;
		Promotor promotor = new Promotor();
		lista =  promotor.listaPromotores();
		cargarTabla(lista);
		
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
		if(e.getClickCount()==2){		
			
			if (e.getSource() == vistaListPromotor.getTable()){
				
				int i = vistaListPromotor.getTable().getSelectedRow();
					
				if (vfiltroC != null){
					
					String codigo = vistaListPromotor.getTable().getValueAt(i,0).toString();
					vfiltroC.getTxtPromotor().setText(codigo);
					try {
						vfiltroC.setSelected(true);// Decimos que comience Enfocado				
					} 
					catch (PropertyVetoException e1) {}
					this.close(this.vistaListPromotor);
					
				}else if(vFiltroP != null){
					
					String codigo = vistaListPromotor.getTable().getValueAt(i,0).toString();
					vFiltroP.getTxtPromotor().setText(codigo);
					try {
						vFiltroP.setSelected(true);// Decimos que comience Enfocado				
					} 
					catch (PropertyVetoException e1) {}
					this.close(this.vistaListPromotor);
					
				}else if(vFiltroR != null){
					String codigo = vistaListPromotor.getTable().getValueAt(i,0).toString();
					vFiltroR.getTxtPromotor().setText(codigo);
					try {
						vFiltroR.setSelected(true);// Decimos que comience Enfocado				
					} 
					catch (PropertyVetoException e1) {}
					this.close(this.vistaListPromotor);
					
				}else if (vAsigPre != null){
					
					String cedula=(String) vistaListPromotor.getTable().getValueAt(i,1);				
					vAsigPre.getTxtCedula().setText(cedula);
					try {
						vAsigPre.setSelected(true);// Decimos que comience Enfocado				
					} 
					catch (PropertyVetoException e1) {}
					this.close(this.vistaListPromotor);
					
				}else if (vAsigR != null){ 
				
					String cedula=(String) vistaListPromotor.getTable().getValueAt(i,1);				
					vAsigR.getTxtCedula().setText(cedula);
					try {
						vAsigR.setSelected(true);// Decimos que comience Enfocado				
					} 
					catch (PropertyVetoException e1) {}
					this.close(this.vistaListPromotor);
				
				}else if (vListPR != null){ 
				
					String codigo= vistaListPromotor.getTable().getValueAt(i,0).toString();				
					vListPR.getTxtEnte().setText(codigo);
					try {
						vListPR.setSelected(true);// Decimos que comience Enfocado				
					} 
					catch (PropertyVetoException e1) {}
					this.close(this.vistaListPromotor);
					
				}else{
					
					String cedula=(String) vistaListPromotor.getTable().getValueAt(i,1);
					vistaAsignarPreContrato = new AsignarPreContrato("Pre-Contrato");				
					vistaAsignarPreContrato.getTxtCedula().setText(cedula);
					centrarFrm (vistaAsignarPreContrato,vistaMdi);
					content.add(vistaAsignarPreContrato);// Agregamos el frame al escritorio
					try {
						vistaAsignarPreContrato.setSelected(true);// Decimos que comience Enfocado				
					} 
					catch (PropertyVetoException e1) {}
					this.close(this.vistaListPromotor);
					
				}
				
			}
		} 	
		
	}
	
    public void centrarFrm (JInternalFrame hijo ,VistaMDI padre){		
		 
		 hijo.setLocation(padre.getWidth()/2 - hijo.getWidth()/2 ,
		 padre.getHeight()/2 - hijo.getHeight()/2 - 20); 
		 // CENTRA EL FORMULARIO
		 
	 }
    
    private void close(ListPromotor vista){
    	vista.dispose();
    }

	@Override
	public void caretUpdate(CaretEvent e) {
		
		if (e.getSource() == vistaListPromotor.getTxtNombre()){
			
			List<Promotores> lista = null;
			Promotor promotor = new Promotor();		
			lista =  promotor.listaByApellido(vistaListPromotor.getTxtNombre().getText());
			cargarTabla(lista);
				
		}
		
	}
	
	private void cargarTabla(List<Promotores> lista){
		
		DefaultTableModel modelo = new DefaultTableModel();
		JTable tabla = this.vistaListPromotor.getTable();
		Object data [] = new Object[4];
		modelo.addColumn("Codigo");
		modelo.addColumn("Cedula");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		
		for (int i=0;i<lista.size();i++){
			
		    data[0] = lista.get(i).getCodPromotor();
		    data[1] = lista.get(i).getCedula();
		    data[2] = lista.get(i).getNombre();
		    data[3] = lista.get(i).getApellido();
		    
		    modelo.addRow(data);
	
		}
		
		tabla.setModel(modelo);
		this.vistaListPromotor.setTable(tabla);
	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vistaListPromotor.getButton()){
			if(perDao.Acceso("VistaPromotor") == 1){
				VistaPromotor vprom = new VistaPromotor("Promotor");				
				centrarFrm (vprom,vistaMdi);
				content.add(vprom);// Agregamos el frame al escritorio
				try {
					vprom.setSelected(true);// Decimos que comience Enfocado				
				} 
				catch (PropertyVetoException e1) {}
				this.close(this.vistaListPromotor);
			}
		}		
	}
	
}
