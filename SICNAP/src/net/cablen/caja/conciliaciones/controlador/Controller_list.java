package net.cablen.caja.conciliaciones.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

import net.cablen.caja.conciliaciones.modelo.Conciliacion;
import net.cablen.caja.conciliaciones.modelo.Conciliaciones;
import net.cablen.caja.conciliaciones.vista.ListaConciliaciones;
import net.cablen.caja.conciliaciones.vista.VistaConciliacion;
import net.cablen.caja.referencias.modelo.Referencias;
import net.cablen.caja.referencias.vista.AsignarReferencias;
import net.cablen.caja.referencias.vista.ListaReferencias;
import net.cablen.caja.referencias.vista.VistaReferencia;
import net.cablen.helppers.Usuario;
import net.cablen.permisos.modelo.PermisosDao;
import net.cablen.principal.vistas.VisorMDI;
import net.cablen.principal.vistas.VistaMDI;

public class Controller_list implements ActionListener,InternalFrameListener,MouseListener{
	
	ListaConciliaciones listViewCon = null;
	PermisosDao perDao = null;
	JDesktopPane content = null;
	AsignarReferencias vRef = null; //se crea nulo para re usar la vista conciliacion
	
	public Controller_list(ListaConciliaciones list) {
	
		 this.listViewCon = list;
		 this.perDao = new PermisosDao();
		 this.content = VisorMDI.getFrmMenu().formMdi;
	
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
		
		if (listViewCon.getrAbiertas().isSelected()==true){
			estatus = 0;
		}
		
		List<Conciliaciones> lista = null;
		Conciliacion concilia = new Conciliacion();
		lista = concilia.lista(estatus);
		cargarTabla(lista);
		concilia = null;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int estatus = 0;
		
		if (e.getSource() == listViewCon.getrAbiertas()){
			estatus = 0;
			List<Conciliaciones> lista = null;
			Conciliacion concilia = new Conciliacion();
			lista = concilia.lista(estatus);
			cargarTabla(lista);
			concilia = null;	
		}else if (e.getSource() == listViewCon.getrCerradas()){
			estatus = 1;
			List<Conciliaciones> lista = null;
			Conciliacion concilia = new Conciliacion();
			lista = concilia.lista(estatus);
			cargarTabla(lista);
			concilia = null;
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (listViewCon.getrCerradas().isSelected()){
			if (e.getClickCount() == 2){
				if (e.getSource() == listViewCon.getTable()){
					int indice = listViewCon.getTable().getSelectedRow();
					int codigo = (Integer) listViewCon.getTable().getValueAt(indice,0);
					String recaudo = listViewCon.getTable().getValueAt(indice,2).toString();
					VistaConciliacion vCon = new VistaConciliacion("Vista Referencia",Integer.toString(codigo),Usuario.getUser().getLogin(),recaudo,vRef);
					centrarFrm (vCon, VisorMDI.getFrmMenu());
					content.add(vCon);// Agregamos el frame al escritorio
					try {
						vCon.setSelected(true);// Decimos que comience Enfocado				
					} 
					catch (PropertyVetoException e1) {}
				}
			}
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
	
	
	
private void cargarTabla(List<Conciliaciones> lista){
		
		DefaultTableModel modelo = new DefaultTableModel();
		JTable tabla = this.listViewCon.getTable();
		Object data [] = new Object[5];
		modelo.addColumn("Conciliacion");
		modelo.addColumn("User Sistema");
		modelo.addColumn("Total");
		modelo.addColumn("Monto Z");
		modelo.addColumn("Fecha Registro");
		
		for (int i=0;i<lista.size();i++){
			
		    data[0] = lista.get(i).getIdConciliacion();
		    data[1] = lista.get(i).getUserSistema();
		    data[2] = lista.get(i).getMontoFinal();
		    data[3] = lista.get(i).getMontoZ();
		    data[4] = lista.get(i).getFechaRegistro();
		    modelo.addRow(data);
	          
		}

		tabla.setModel(modelo);
		this.listViewCon.setTable(tabla);
		
	}
	
    public void centrarFrm (JInternalFrame hijo ,VistaMDI padre){		
		 
		 hijo.setLocation(padre.getWidth()/2 - hijo.getWidth()/2 ,
		 padre.getHeight()/2 - hijo.getHeight()/2 - 20); 
		 // CENTRA EL FORMULARIO
		 
	 }

}
