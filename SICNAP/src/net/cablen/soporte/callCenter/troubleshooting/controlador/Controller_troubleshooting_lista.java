package net.cablen.soporte.callCenter.troubleshooting.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

import net.cablen.caja.referencias.vista.VistaReferencia;
import net.cablen.helppers.ValidarCampos;
import net.cablen.permisos.modelo.PermisosDao;
import net.cablen.principal.vistas.VisorMDI;
import net.cablen.principal.vistas.VistaMDI;
import net.cablen.soporte.actividades.modelo.TshActividades;
import net.cablen.soporte.callCenter.troubleshooting.modelo.CallCenter;
import net.cablen.soporte.callCenter.troubleshooting.modelo.Troubleshooting;
import net.cablen.soporte.callCenter.troubleshooting.vista.VistaCerrarIncidencia;
import net.cablen.soporte.callCenter.troubleshooting.vista.VistaListTroubleshooting;
import net.cablen.soporte.ws.Abonado;

public class Controller_troubleshooting_lista implements ActionListener,KeyListener,MouseListener,InternalFrameListener{

	VistaListTroubleshooting vList = null;
	
	int  idActividad=0;
	String incidencia ="";
	int limite = 12;
	String likeSql = "";
	PermisosDao perDao = null;
	JDesktopPane content = null;
	 List<Troubleshooting> listaTro = null;
	 
	public Controller_troubleshooting_lista(VistaListTroubleshooting vista) {
		this.vList = vista;
		this.perDao = new PermisosDao();
		this.content = VisorMDI.getFrmMenu().formMdi;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		

	}

	@Override
	public void keyReleased(KeyEvent e) {
	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == this.vList.getTxtInc()){
			if ( this.vList.getTxtInc().getText().length() == limite){
				e.consume();
			}
		}
		
		if (e.getSource() == this.vList.getTxtCedula()){
			if ( this.vList.getTxtCedula().getText().length() == limite - 3){
				e.consume();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == this.vList.getChFecha()){
			if (this.vList.getChFecha().isSelected()){
				this.vList.getfDesde().setEnabled(true);
				this.vList.getfHasta().setEnabled(true);
			}else{
				this.vList.getfDesde().setEnabled(true);
				this.vList.getfDesde().setEnabled(false);
				this.vList.getfHasta().setEnabled(false);
			}
		}
		
		if (e.getSource() == this.vList.getCmbAct()){
			idActividad = Integer.parseInt(this.vList.getCmbAct().getSelectedItem().toString().substring(0,4));
			//System.out.println(idActividad);
		}
		
		if (e.getSource() == this.vList.getBtmBuscar()){
			CallCenter cc = new CallCenter();
			
			if (this.vList.getChFecha().isSelected()){
				 try {//try para valida que no envie fechas vacias
					likeSql = " AND t.fecha_apertura BETWEEN '" +  ValidarCampos.soloFecha(this.vList.getfDesde().getDate()) + 
								  "' AND '" + ValidarCampos.soloFecha(this.vList.getfHasta().getDate()) + "'";
				 } catch (Exception e2) {
					 likeSql = "";
				 }
			}else{
				 likeSql = "";
			}
			
			if (this.vList.getrInc().isSelected()){
				incidencia = this.validarInc(this.vList.getTxtInc().getText());
				if (!incidencia.equals("")){
					likeSql = likeSql +  " AND t.id_correlativo=" + incidencia;
				}
			}
			
			if (this.vList.getrCedula().isSelected()){
				
				Abonado[] listAbo = cc.lista(this.vList.getTxtCedula().getText());
				String listaDeAbo = "";
				
				for (int i = 0; i< listAbo.length; i++){
					listaDeAbo = listaDeAbo + "'" + listAbo[i].getABONUMERO() + "',";
				}
				
				listaDeAbo = listaDeAbo.substring(0,listaDeAbo.length()-1);
				
				if (!listaDeAbo.equals("")){
					likeSql = likeSql +  " AND t.abonado IN (" + listaDeAbo + ")";
				}
				
			}
			
			if (this.vList.getrAct().isSelected()){		
				if(idActividad > 0){
					likeSql = likeSql +  " AND t.id_actividad_tsh=" + idActividad;
				}	
			}
			
						
			
			try {//try para omitir si la lista llega nula
				
				listaTro = cc.findListByOpen(likeSql);
				this.cargarTabla(listaTro);
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
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
		
	   if (e.getSource() == this.vList.getrInc()){	
		   if (this.vList.getrInc().isSelected()){
			   this.vList.getTxtInc().setEnabled(true);
			   this.vList.getTxtCedula().setEnabled(false);
			   this.vList.getCmbAct().setEnabled(false);
			   this.vList.getTxtCedula().setText("");
		   }
	  }
		
	   if (e.getSource() == this.vList.getrCedula()){	
		   if (this.vList.getrCedula().isSelected()){
			   this.vList.getTxtInc().setEnabled(false);
			   this.vList.getTxtCedula().setEnabled(true);
			   this.vList.getCmbAct().setEnabled(false);
			   this.vList.getTxtInc().setText("");
		   }
	  }
	   
	   if (e.getSource() == this.vList.getrAct()){	
		   if (this.vList.getrAct().isSelected()){
			   this.vList.getTxtInc().setEnabled(false);
			   this.vList.getTxtCedula().setEnabled(false);
			   this.vList.getCmbAct().setEnabled(true);
			   this.vList.getTxtCedula().setText("");
			   this.vList.getTxtInc().setText("");
		   }
	  }
	   
	   if(e.getSource() == this.vList.getTable()){
		   if (e.getClickCount() == 2){
			   int indice = vList.getTable().getSelectedRow();
			   if (perDao.Acceso("VistaCerrarIncidencia") == 1){
					VistaCerrarIncidencia vCInc = new VistaCerrarIncidencia("Cerrar Incidencia" , listaTro.get(indice));
					centrarFrm (vCInc, VisorMDI.getFrmMenu());
					content.add(vCInc);// Agregamos el frame al escritorio
					try {
						vCInc.setSelected(true);// Decimos que comience Enfocado	
						this.vList.dispose();
					} 
					catch (PropertyVetoException e1) {}
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
		
		CallCenter cc = new CallCenter();
		
		DefaultComboBoxModel mdlCombo= new DefaultComboBoxModel();
	    this.vList.getCmbAct().setModel(mdlCombo);
	    List<TshActividades> lista =  cc.cargarActividades();
	    int tamano = lista.size();
	    for (int i=0;i< tamano;i++){
	    	  mdlCombo.addElement(lista.get(i).getIdActividad()  + " - " + lista.get(i).getActividad()); 
	    }

	    listaTro = cc.findListByOpen("");
	    this.cargarTabla(listaTro);
		cc = null;
		
	}
	
	private void cargarTabla(List<Troubleshooting> lista){
		
		DefaultTableModel modelo = new DefaultTableModel();
		JTable tabla = this.vList.getTable();
		Object data [] = new Object[5];
		modelo.addColumn("Incidencia");
		modelo.addColumn("Abonado");
		modelo.addColumn("User");
		modelo.addColumn("Fecha Apertura");
		modelo.addColumn("Actividad");
		
		for (int i=0;i<lista.size();i++){
			
		    data[0] = lista.get(i).getIncidencia();
		    data[1] = lista.get(i).getAbonado();
		    data[2] = lista.get(i).getUserSistema();
		    data[3] = lista.get(i).getFechaApertura();
		    data[4] = lista.get(i).getTshActividades().getActividad();
		    modelo.addRow(data);
	          
		}
		
		tabla.setModel(modelo);
		tabla.setModel(modelo);
		this.vList.setTable(tabla);
		
	}
	
	private String validarInc(String inc){
		
		String result = "";
		
		if (!inc.equals("")){
			
			String tmp="";
			tmp = inc.substring(0,1);
			
			if (inc.length() >= 4){
				if (Character.isDigit(tmp.charAt(0)) ){
					result = inc;
				}else{
					if (tmp.charAt(0) == 'i' || tmp.charAt(0) == 'I'){
					
						tmp = "";
						tmp = inc.substring(4);
						
						if (!tmp.equals("")){
							result = tmp;
						}else{
							JOptionPane.showMessageDialog(null, "Debes ingresar una Incidencia valida");
						}
						
					}else{
						JOptionPane.showMessageDialog(null, "Debes ingresar una Incidencia valida");
					}			
				}
			}else{
				JOptionPane.showMessageDialog(null, "Debes ingresar una Incidencia valida");
			}
			
			
		}else{
			JOptionPane.showMessageDialog(null, "Debes ingresar una Incidencia valida");
		}
		
		return result;

	}
	
	
    public void centrarFrm (JInternalFrame hijo ,VistaMDI padre){		
		 
		 hijo.setLocation(padre.getWidth()/2 - hijo.getWidth()/2 ,
		 padre.getHeight()/2 - hijo.getHeight()/2 - 20); 
		 // CENTRA EL FORMULARIO
		 
	 }

}
