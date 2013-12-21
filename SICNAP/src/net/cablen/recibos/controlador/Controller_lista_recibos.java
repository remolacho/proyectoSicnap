package net.cablen.recibos.controlador;

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

import net.cablen.caja.conciliaciones.vista.VistaConciliacion;
import net.cablen.helppers.Usuario;
import net.cablen.permisos.modelo.PermisosDao;
import net.cablen.principal.vistas.VisorMDI;
import net.cablen.principal.vistas.VistaMDI;
import net.cablen.promotor.modelo.Promotores;
import net.cablen.promotor.vistas.ListPromotor;
import net.cablen.recibos.modelo.Recibo;
import net.cablen.recibos.modelo.RecibosPromotor;
import net.cablen.recibos.vista.ListaProcRecibos;
import net.cablen.recibos.vista.VistaProcRecibos;

public class Controller_lista_recibos implements ActionListener,CaretListener,InternalFrameListener,MouseListener{

	ListaProcRecibos vLista = null;
	private VistaMDI vistaMdi;
	private JDesktopPane content;
	private PermisosDao perDao;
	private Promotores promotor;

	public Controller_lista_recibos(ListaProcRecibos vista) {
	
		this.vLista = vista;
		this.vistaMdi = VisorMDI.getFrmMenu();
		this.content = vistaMdi.formMdi;
		this.perDao = new PermisosDao();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == vLista.getrEnte()){
			vLista.getBtmEnte().setEnabled(true);
			vLista.getBtmRecibo().setEnabled(false);
			vLista.getTxtRecibo().setText("");
			vLista.getTxtRecibo().setEnabled(false);
		}
		
		if (e.getSource() == vLista.getrRecibo()){
			vLista.getBtmRecibo().setEnabled(true);
			vLista.getBtmEnte().setEnabled(false);
			vLista.getTxtRecibo().setEnabled(true);
			vLista.getTxtEnte().setText("");
		}
		
		if (e.getSource() == vLista.getrTodos()){
			
			vLista.getBtmRecibo().setEnabled(false);
			vLista.getBtmEnte().setEnabled(false);
			vLista.getTxtRecibo().setEnabled(false);
			vLista.getTxtRecibo().setText("");
			vLista.getTxtEnte().setText("");
			
			List<RecibosPromotor> lista=null;
			Recibo recibo = new Recibo();
			lista = recibo.listByEstatus(0);
			cargarTabla(lista);
			recibo = null;
			
		}
		
		if (e.getSource() == vLista.getBtmRecibo()){
			List<RecibosPromotor> recibos;
			Recibo modelo = new Recibo();
			
			try {
				recibos = modelo.listByRecibo(Long.parseLong(vLista.getTxtRecibo().getText()), 0);
				cargarTabla(recibos);
			} catch (Exception e2) {
				// TODO: handle exception
			}

			modelo = null;
			recibos = null;
			
		}
		
		if (e.getSource() == vLista.getBtmEnte()){
			if(perDao.Acceso("ListPromotor") == 1){
				ListPromotor listaPro = new ListPromotor("Lista de Entes",vLista);
				centrarFrm (listaPro,vistaMdi);
				content.add(listaPro);// Agregamos el frame al escritorio
				try {
					listaPro.setSelected(true);// Decimos que comience Enfocado				
				} 
				catch (PropertyVetoException e1) {}
				//vPrecintos.dispose();			
			}
		}
		
	}

	@Override
	public void caretUpdate(CaretEvent e) {
		
		if(e.getSource() == vLista.getTxtEnte()){
			List<RecibosPromotor> lista = null;
			Recibo recibo = new Recibo();
			try {
				lista = recibo.listByPromotor(Integer.parseInt(vLista.getTxtEnte().getText()), 0);
				cargarTabla(lista);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			recibo = null;
			lista = null;
			
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
		
		List<RecibosPromotor> lista=null;
		Recibo recibo = new Recibo();
		
		try {
			lista = recibo.listByEstatus(0);
			cargarTabla(lista);
		} catch (Exception e2) {
			// TODO: handle exception
		}
		

		recibo = null;
	
	}
	
	private void cargarTabla(List<RecibosPromotor> lista){
		DefaultTableModel modelo = new DefaultTableModel();
		JTable tabla = this.vLista.getTable();
		Object data [] = new Object[4];
		
		modelo.addColumn("N° Recibo");
		modelo.addColumn("Cedula");
		modelo.addColumn("Ente");
		modelo.addColumn("Estatus");
		
		for (int i=0;i<lista.size();i++){
			
		    data[0] = lista.get(i).getCodigoRecibo();
		    data[1] = lista.get(i).getPromotor().getCedula();
		    data[2] = lista.get(i).getPromotor().getNombre() + " " + lista.get(i).getPromotor().getApellido();
		    data[3] = lista.get(i).getEstatus();
		    modelo.addRow(data);
	
		}
		
		tabla.setModel(modelo);
		this.vLista.setTable(tabla);
		
	}
	
    public void centrarFrm (JInternalFrame hijo ,VistaMDI padre){		
		 
		 hijo.setLocation(padre.getWidth()/2 - hijo.getWidth()/2 ,
		 padre.getHeight()/2 - hijo.getHeight()/2 - 20); 
		 // CENTRA EL FORMULARIO
		 
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2){
			if (e.getSource() == vLista.getTable()){
				int indice =  vLista.getTable().getSelectedRow();
				long codigo = (long) vLista.getTable().getValueAt(indice,0);
				VistaProcRecibos vProc = new VistaProcRecibos("Procesar Recibo");
				vProc.getLblRecibo().setText(Long.toString(codigo));
				centrarFrm (vProc, VisorMDI.getFrmMenu());
				content.add(vProc);// Agregamos el frame al escritorio
				try {
					vProc.setSelected(true);// Decimos que comience Enfocado				
				} 
				catch (PropertyVetoException e1) {}
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
		
	}

}
