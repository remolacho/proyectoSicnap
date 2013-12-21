package net.cablen.caja.referencias.controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JTable;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

import net.cablen.caja.conciliaciones.modelo.Conciliaciones;
import net.cablen.caja.referencias.vista.AsignarReferencias;
import net.cablen.caja.referencias.vista.VistaSerialesRef;
import net.cablen.oficinas.modelo.Oficinas;
import net.cablen.oficinas.modelo.OficinasDao;

public class Controller_seriales_ref implements CaretListener,MouseListener,InternalFrameListener{
	
	AsignarReferencias vRef = null;
	VistaSerialesRef   vSeriales = null;
	
	public Controller_seriales_ref(AsignarReferencias vR, VistaSerialesRef vS) {
	
		this.vRef = vR;
		this.vSeriales = vS;
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (e.getSource() == vSeriales.getTable()){
			if (e.getClickCount() == 2){
				int indice = vSeriales.getTable().getSelectedRow();
				String serial = vSeriales.getTable().getValueAt(indice,2).toString();
				vRef.getTxtSerial().setText(serial);
				vSeriales.dispose();
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

	@Override
	public void caretUpdate(CaretEvent e) {
	
		if(e.getSource() == vSeriales.getTxtOficina()){
			OficinasDao dao = new OficinasDao();
			List<Oficinas>lista = dao.listaByFiltro(vSeriales.getTxtOficina().getText());
			cargarTabla(lista);
			lista = null;
			dao=null;
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
	
		OficinasDao dao = new OficinasDao();
		List<Oficinas>lista = dao.lista();
		cargarTabla(lista);
		lista = null;
		dao=null;
		
	}
	
private void cargarTabla(List<Oficinas> lista){
		
		DefaultTableModel modelo = new DefaultTableModel();
		JTable tabla = this.vSeriales.getTable();
		Object data [] = new Object[3];
		modelo.addColumn("ID");
		modelo.addColumn("OFICINA");
		modelo.addColumn("SERIAL");
		
		for (int i=0;i<lista.size();i++){
			
		    data[0] = lista.get(i).getIdOficina();
		    data[1] = lista.get(i).getOficina();
		    data[2] = lista.get(i).getPunto();
		    modelo.addRow(data);
	          
		}

		tabla.setModel(modelo);
		this.vSeriales.setTable(tabla);
		
	}

}
