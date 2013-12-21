package net.cablen.caja.referencias.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

import net.cablen.caja.conciliaciones.modelo.Conciliacion;
import net.cablen.caja.conciliaciones.modelo.Conciliaciones;
import net.cablen.caja.conciliaciones.vista.VistaConciliacion;
import net.cablen.caja.referencias.modelo.Referencia;
import net.cablen.caja.referencias.modelo.Referencias;
import net.cablen.caja.referencias.vista.ListaReferencias;
import net.cablen.caja.referencias.vista.VistaReferencia;
import net.cablen.contratos.vista.AsignarPreContrato;
import net.cablen.permisos.modelo.PermisosDao;
import net.cablen.principal.vistas.VisorMDI;
import net.cablen.principal.vistas.VistaMDI;
import net.cablen.promotor.modelo.Promotor;
import net.cablen.promotor.modelo.Promotores;
import net.cablen.soporte.actividades.modelo.TshActividades;

public class Controller_list implements ActionListener,InternalFrameListener,CaretListener{
	
	ListaReferencias listViewRef = null;
	PermisosDao perDao = null;
	JDesktopPane content = null;
	
	public Controller_list(ListaReferencias list) {
	
		 this.listViewRef = list;
		 this.perDao = new PermisosDao();
		 this.content = VisorMDI.getFrmMenu().formMdi;
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == listViewRef.getComboBox()){
			
			int estatus = 0;
			List<Referencias> lista = null;
			
			if (listViewRef.getrAbiertas().isSelected()==true){
				listViewRef.getrCerradas().setSelected(false);
				estatus = 0;
			}else if(listViewRef.getrCerradas().isSelected()==true){
				listViewRef.getrAbiertas().setSelected(false);
				estatus = 1;
			}
			
            
			Conciliacion concilia = new Conciliacion();
			lista = concilia.listaXConciliacion(Integer.parseInt(listViewRef.getComboBox().getSelectedItem().toString()), estatus);
			cargarTabla(lista);
		
		}
	
		if(e.getSource() == listViewRef.getBtmNew()){
			
			if (listViewRef.getrAbiertas().isSelected()){
				Referencia referencia = new Referencia();
				int refErr =  referencia.refErr();
				String concilia="";
				
				try {
					concilia = listViewRef.getComboBox().getSelectedItem().toString();
				} catch (Exception e2) {}
				
				if (refErr > 0 && (!concilia.equals(""))){
					if (perDao.Acceso("VistaReferencia") == 1){
						VistaReferencia vref = new VistaReferencia("Vista Referencia","refErr" + refErr,concilia);
						centrarFrm (vref, VisorMDI.getFrmMenu());
						content.add(vref);// Agregamos el frame al escritorio
						referencia = null;
						try {
							vref.setSelected(true);// Decimos que comience Enfocado				
						} 
						catch (PropertyVetoException e1) {}
					}
				}else{	
					JOptionPane.showMessageDialog(null, "Error al iniciar la referencia");		
				}
			}
		}
		
		
		
		if (e.getSource() == listViewRef.getrAbiertas()){	
			int estatus = 0;
			List<Conciliaciones> lista = null;
			if(listViewRef.getrAbiertas().isSelected()){
				listViewRef.getrCerradas().setSelected(false);
				estatus = 0;
				Conciliacion concilia = new Conciliacion();
				lista = concilia.cargarConciliaciones(estatus);
				
				DefaultComboBoxModel mdlCombo= new DefaultComboBoxModel();
				listViewRef.getComboBox().setModel(mdlCombo);
			    int tamano = lista.size();
			    for (int i=0;i< tamano;i++){
			    	  mdlCombo.addElement(lista.get(i).getIdConciliacion()); 
			    }	
				concilia = null;	
			}
		}else if (e.getSource() == listViewRef.getrCerradas()){	
			int estatus = 0;
			List<Conciliaciones> lista = null;
			if(listViewRef.getrCerradas().isSelected()){
				listViewRef.getrAbiertas().setSelected(false);
				estatus = 1;
				Conciliacion concilia = new Conciliacion();
				lista = concilia.cargarConciliaciones(estatus);
				
				DefaultComboBoxModel mdlCombo= new DefaultComboBoxModel();
				listViewRef.getComboBox().setModel(mdlCombo);
			    int tamano = lista.size();
			    for (int i=0;i< tamano;i++){
			    	  mdlCombo.addElement(lista.get(i).getIdConciliacion()); 
			    }	
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

		int estatus = 0;
		List<Conciliaciones> lista = null;

		if (listViewRef.getrAbiertas().isSelected()==true){
			estatus = 0;
		}
		
		Conciliacion concilia = new Conciliacion();
		lista = concilia.cargarConciliaciones(estatus);
		
		DefaultComboBoxModel mdlCombo= new DefaultComboBoxModel();
		listViewRef.getComboBox().setModel(mdlCombo);
	    int tamano = lista.size();
	    for (int i=0;i< tamano;i++){
	    	  mdlCombo.addElement(lista.get(i).getIdConciliacion()); 
	    }	
		concilia = null;
		
	}
	
	
	@Override
	public void caretUpdate(CaretEvent e) {
		if(e.getSource() == listViewRef.getTxtReferencia()){
			
			List<Referencias> lista = null;
			int estatus = 0;
			
			if (listViewRef.getrAbiertas().isSelected()==true){
				estatus = 0;
			}else{
				estatus = 1;
			}
			
			Referencia refMod = new Referencia();
			lista = refMod.listaPorReferencia(listViewRef.getTxtReferencia().getText(), estatus);
			cargarTabla(lista);
			refMod = null;
			lista = null;
	
		}
		
	}
	
	
	private void cargarTabla(List<Referencias> lista){
		
		float totalCaja = 0;
		DefaultTableModel modelo = new DefaultTableModel();
		JTable tabla = this.listViewRef.getTable();
		Object data [] = new Object[5];
		modelo.addColumn("Referencia");
		modelo.addColumn("Banco");
		modelo.addColumn("Monto");
		modelo.addColumn("Tipo");
		modelo.addColumn("Fecha Bancaria");
		
		for (int i=0;i<lista.size();i++){
			
		    data[0] = lista.get(i).getReferencia();
		    data[1] = lista.get(i).getBanco();
		    data[2] = lista.get(i).getMonto();
		    data[3] = lista.get(i).getTipoDepo();
		    data[4] = lista.get(i).getFechaBancaria();
		    totalCaja +=  lista.get(i).getMonto();
		    modelo.addRow(data);
	          
		}

		tabla.setModel(modelo);
		this.listViewRef.setTable(tabla);
		
	}

    public void centrarFrm (JInternalFrame hijo ,VistaMDI padre){		
		 
		 hijo.setLocation(padre.getWidth()/2 - hijo.getWidth()/2 ,
		 padre.getHeight()/2 - hijo.getHeight()/2 - 20); 
		 // CENTRA EL FORMULARIO
		 
	 }

}
