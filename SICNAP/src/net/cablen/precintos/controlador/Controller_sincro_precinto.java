package net.cablen.precintos.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

import net.cablen.contratos.modelo.Contratos;
import net.cablen.contratos.modelo.ContratosPromotor;
import net.cablen.precintos.modelo.Precinto;
import net.cablen.precintos.modelo.PrecintosPromotor;
import net.cablen.precintos.vista.VistaSincroPrecintos;

public class Controller_sincro_precinto implements  ActionListener,KeyListener,InternalFrameListener,CaretListener,MouseListener{

	VistaSincroPrecintos vSincro;
	
	public Controller_sincro_precinto(VistaSincroPrecintos vista) {
		this.vSincro = vista;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void caretUpdate(CaretEvent e) {
		
		if (e.getSource() == vSincro.getTxtBuscar()){
			
			
			Precinto precinto = new Precinto();
			List<PrecintosPromotor> lista = null;
			
			if(vSincro.getrBoxy().isSelected()==true)
			{
				vSincro.getrEstatus().setSelected(false);
				lista = precinto.listPrecintosByBoxy(this.vSincro.getTxtBuscar().getText());
				cargarTabla(lista);	
			}else if (vSincro.getrEstatus().isSelected()==true){
				
				vSincro.getrBoxy().setSelected(false);					
				
				try {
					lista = precinto.listPrecintosByEstatus (Integer.parseInt(this.vSincro.getTxtBuscar().getText()));
				} catch (Exception e2) {
					lista = precinto.listByProcess();
				}
				
				cargarTabla(lista);	
				
			}
			
		}
		
		
	
		
		
	}

	@Override
	public void internalFrameActivated(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameClosed(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameClosing(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameIconified(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameOpened(InternalFrameEvent arg0) {
		List<PrecintosPromotor> lista = null;
		Precinto precinto = new Precinto();
		lista = precinto.listByProcess();
		cargarTabla(lista);
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()  == this.vSincro.getBtmTodos()){
			
			Precinto precinto = new Precinto();
			List<PrecintosPromotor> lista = precinto.listAll();
			this.vSincro.getTxtBuscar().setText("");
			cargarTabla(lista);
			
		}
		
		
	if(e.getSource() == this.vSincro.getBtmSincro()){
			
			String result= "";
			String strPrecintos ="";
			
			int filas = vSincro.getTable().getRowCount();

			if (filas > 0){
				
				String boxy = (String)vSincro.getTable().getValueAt(0,4);	
				String boxyTmp = "";
				
				for (int i=0;i<filas;i++){
					
					String tmpContrato = vSincro.getTable().getValueAt(i,0).toString();	
				    boxyTmp =  vSincro.getTable().getValueAt(i,4).toString();	

				    if (boxy.equals(boxyTmp)){	
				    	result =  result + "'" + tmpContrato  + "',";
				    }
				   
				    tmpContrato = "";
				    boxyTmp="";
				    
				}
				
				strPrecintos = result.substring(0,result.length()-1);
				//System.out.println(strPrecintos);
				Precinto precinto = new Precinto(boxy,strPrecintos);
			
				try {
					JOptionPane.showMessageDialog(null,precinto.sincronizar(),"SICNAP",1);
					List<PrecintosPromotor> lista = precinto.listByProcess();		
					cargarTabla(lista);	
					precinto = null;
				} catch (RemoteException e1) {
					JOptionPane.showMessageDialog(null,"Error con las cadenas enviadas a sincronizar","SICNAP", 0);	
				}
				
			}else{
				
				JOptionPane.showMessageDialog(null,"No hay registros disponibles","SICNAP",0);
				
			}
		}
		
	}
	
	private void cargarTabla(List<PrecintosPromotor> lista){
		DefaultTableModel modelo = new DefaultTableModel();
		JTable tabla = this.vSincro.getTable();
		Object data [] = new Object[5];
		
		modelo.addColumn("Precinto");
		modelo.addColumn("Cedula");
		modelo.addColumn("Ente");
		modelo.addColumn("Estatus");
		modelo.addColumn("Boxy");
		
		for (int i=0;i<lista.size();i++){
			
		    data[0] = lista.get(i).getPrecinto();
		    data[1] = lista.get(i).getPromotores().getCedula();
		    data[2] = lista.get(i).getPromotores().getNombre() + " " + lista.get(i).getPromotores().getApellido();
		    data[3] = lista.get(i).getEstatus();
		    data[4] = lista.get(i).getBoxy();
		    modelo.addRow(data);
	
		}
		
		tabla.setModel(modelo);
		this.vSincro.setTable(tabla);
		
	}

}
