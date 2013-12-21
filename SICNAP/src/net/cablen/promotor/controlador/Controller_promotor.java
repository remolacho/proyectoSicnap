package net.cablen.promotor.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

import net.cablen.contratos.vista.AsignarPreContrato;
import net.cablen.promotor.modelo.Promotor;
import net.cablen.promotor.modelo.Promotores;
import net.cablen.promotor.vistas.VistaPromotor;

public class Controller_promotor implements ActionListener,CaretListener,MouseListener,InternalFrameListener,KeyListener {

	private VistaPromotor vistaPromotor; 
	
	public Controller_promotor(VistaPromotor vista){
		
		this.vistaPromotor = vista;
		
	}
	
	

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		if (e.getSource() == vistaPromotor.getTxtCed()){
			
			int limite = 10;
			int k = (int) e.getKeyChar(); 
			
			if (k >= 97 && k <= 122 || k >= 65 && k <= 90) { 

				e.consume();
				JOptionPane.showMessageDialog(null, "No puede ingresar Letras!!!", "Error Datos", JOptionPane.ERROR_MESSAGE);
			
			}
			
			if (vistaPromotor.getTxtCed().getText().length() == limite){
				
				 e.consume();
				
			}
			
		}
		
		if (e.getSource() == vistaPromotor.getTxtTF()){
			
			int limite = 11;
			int k = (int) e.getKeyChar(); 
			
			if (k >= 97 && k <= 122 || k >= 65 && k <= 90) { 

				e.consume();
				JOptionPane.showMessageDialog(null, "No puede ingresar Letras!!!", "Error Datos", JOptionPane.ERROR_MESSAGE);
			}
			
			if (vistaPromotor.getTxtTF().getText().length() == limite){
				
				 e.consume();
				
			}
			
		}
		
		if (e.getSource() == vistaPromotor.getTxtTM()){
			
			int limite = 11;
			int k = (int) e.getKeyChar(); 
			
			if (k >= 97 && k <= 122 || k >= 65 && k <= 90) { 

				e.consume();
				JOptionPane.showMessageDialog(null, "No puede ingresar Letras!!!", "Error Datos", JOptionPane.ERROR_MESSAGE);
			}
			
			if (vistaPromotor.getTxtTM().getText().length() == limite){
				
				 e.consume();
				
			}
			
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
		if(e.getClickCount()==2){		
			if (e.getSource() == vistaPromotor.getTable()){
				int indice = vistaPromotor.getTable().getSelectedRow();
				int codigo = (Integer) vistaPromotor.getTable().getValueAt(indice,0);
				Promotor promotorM = new Promotor();
				Promotores promotor = promotorM.findById(codigo);				
				vistaPromotor.getTxtCod().setText(Integer.toString(promotor.getCodPromotor()));
				vistaPromotor.getTxtCed().setText(promotor.getCedula());
				vistaPromotor.getTxtNom().setText(promotor.getNombre());
				vistaPromotor.getTxtApe().setText(promotor.getApellido());
				vistaPromotor.getTxtTF().setText(promotor.getTelefonoFijo());
				vistaPromotor.getTxtTM().setText(promotor.getTelefonoMovil());
				promotorM=null;
				promotor=null;
			} 
		}
	}

	@Override
	public void caretUpdate(CaretEvent e) {
		
		if (e.getSource() == vistaPromotor.getTxtFiltro()){
			
        	Promotor promotorM  = new Promotor();
        	List<Promotores> lista = null;
        	lista = promotorM.listaByApellido(vistaPromotor.getTxtFiltro().getText());
        	cargarTabla(lista);
        	promotorM = null;
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == vistaPromotor.getBtmAgregar()){
	        	
	        	String msg = "";		
	        	Promotor promotorM  =new Promotor();
	        	Promotores promotor = new Promotores();
	        	List<Promotores> lista = null;
			
	        	promotor.setCodPromotor(Integer.parseInt(vistaPromotor.getTxtCod().getText()));
	        	promotor.setCedula(vistaPromotor.getTxtCed().getText());
	        	promotor.setNombre(vistaPromotor.getTxtNom().getText());
	        	promotor.setApellido(vistaPromotor.getTxtApe().getText());
	        	promotor.setTelefonoFijo(vistaPromotor.getTxtTF().getText());
	        	promotor.setTelefonoMovil(vistaPromotor.getTxtTM().getText());
	        	promotor.setEstatus(1);
			
	        	msg = promotorM.agregar(promotor);
	        	JOptionPane.showMessageDialog(null,msg,"SICNAPP",1);
			
			
	        	lista =  promotorM.listaPromotores();
	        	cargarTabla(lista);
	        	nuevo();
	        	promotor = null;
	        	promotorM = null;

		}
		
		if (e.getSource() == vistaPromotor.getBtmNuevo()){
			
			nuevo();
			
		}
		
		
		if(e.getSource() == vistaPromotor.getBtmMod()){
        	
        	String msg = "";		
        	Promotor promotorM  =new Promotor();
        	Promotores promotor = new Promotores();
        	List<Promotores> lista = null;
		
        	promotor.setCodPromotor(Integer.parseInt(vistaPromotor.getTxtCod().getText()));
        	promotor.setCedula(vistaPromotor.getTxtCed().getText());
        	promotor.setNombre(vistaPromotor.getTxtNom().getText());
        	promotor.setApellido(vistaPromotor.getTxtApe().getText());
        	promotor.setTelefonoFijo(vistaPromotor.getTxtTF().getText());
        	promotor.setTelefonoMovil(vistaPromotor.getTxtTM().getText());
        	promotor.setEstatus(1);
		
        	msg = promotorM.actualizar(promotor);
        	JOptionPane.showMessageDialog(null,msg,"SICNAPP",1);
		
		
        	lista =  promotorM.listaPromotores();
        	cargarTabla(lista);
        	nuevo();
        	promotor = null;
        	promotorM = null;

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

		List<Promotores> lista = null;
		Promotor promotor = new Promotor();
		lista =  promotor.listaPromotores();
		vistaPromotor.getTxtCod().setText(Integer.toString(promotor.correlativo()));
		cargarTabla(lista);
		
	}
	
	
private void cargarTabla(List<Promotores> lista){
		
		DefaultTableModel modelo = new DefaultTableModel();
		JTable tabla = this.vistaPromotor.getTable();
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
		this.vistaPromotor.setTable(tabla);
	
		
	}


	private void nuevo(){
	
		Promotor promotor = new Promotor();
		vistaPromotor.getTxtCod().setText(Integer.toString(promotor.correlativo()));
		vistaPromotor.getTxtCed().setText("");
		vistaPromotor.getTxtNom().setText("");
		vistaPromotor.getTxtApe().setText("");
		vistaPromotor.getTxtTF().setText("");
		vistaPromotor.getTxtTM().setText("");
		promotor = null;
		
	}


}
