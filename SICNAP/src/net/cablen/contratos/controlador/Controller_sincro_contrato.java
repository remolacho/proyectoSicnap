package net.cablen.contratos.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

import net.cablen.contratos.modelo.*;

import net.cablen.contratos.vista.SincroContratos;
import net.cablen.contratos.vista.VistaContratoAsignad;
import net.cablen.helppers.Usuario;
import net.cablen.permisos.modelo.PermisosDao;
import net.cablen.principal.vistas.VisorMDI;
import net.cablen.principal.vistas.VistaMDI;

public class Controller_sincro_contrato  implements ActionListener,KeyListener,InternalFrameListener,CaretListener,MouseListener{

	private SincroContratos vistaSincro;
	PermisosDao perDao;
	JDesktopPane content;
	
	public Controller_sincro_contrato(SincroContratos vista){
		perDao = new PermisosDao();
		vistaSincro = vista;
		content = VisorMDI.getFrmMenu().formMdi;
	}
	

	@Override
	public void internalFrameOpened(InternalFrameEvent arg0) {
		
		List<ContratosPromotor> lista = null;
		Contratos contratos = new Contratos();
		lista = contratos.listByProcess();
		cargarTabla(lista);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()  == this.vistaSincro.getBtnBuscar()){
			
			Contratos contratos = new Contratos();
			List<ContratosPromotor> lista = contratos.listAll();
			this.vistaSincro.getTxtFiltro().setText("");
			cargarTabla(lista);
			
		}
		
		
		if(e.getSource() == this.vistaSincro.getBtmSincro()){
			
			String result= "";
			String strContratos ="";
			
			int filas = vistaSincro.getTablaContratos().getRowCount();
			
			if (filas > 0){
				
				String boxy = (String)vistaSincro.getTablaContratos().getValueAt(0,4);	
				String boxyTmp = "";
				
				for (int i=0;i<filas;i++){
					
					
				    String cerosIzquierda = "";
					String tmpContrato = vistaSincro.getTablaContratos().getValueAt(i,0).toString();	
				    boxyTmp =  vistaSincro.getTablaContratos().getValueAt(i,4).toString();	
				   
				    int tamanoBuffer = 9; //Valor del tamano del campo contrato en el boxy la tabla Abonado
				    int cantCerosIzquierda = tamanoBuffer -  tmpContrato.length();

				    for (int c= 0; c < cantCerosIzquierda; c++ ){
				    	cerosIzquierda = cerosIzquierda + "0";   	
				    }
				    
				    tmpContrato = cerosIzquierda + tmpContrato;
				    
				    if (boxy.equals(boxyTmp)){	
				    	result = result + tmpContrato  + ",";
				    }
				   
				    tmpContrato = "";
				    boxyTmp="";
				    
				}
				
				strContratos = result.substring(0,result.length()-1);
				//System.out.println(strContratos);
				Contratos contrato = new Contratos(boxy,strContratos);
			
				try {
					JOptionPane.showMessageDialog(null,contrato.sincronizar(),"SICNAP",1);
					List<ContratosPromotor> lista = contrato.listByProcess();		
					cargarTabla(lista);	
					contrato = null;
				} catch (RemoteException e1) {
					JOptionPane.showMessageDialog(null,"Error con las cadenas enviadas a sincronizar","SICNAP", 0);	
				}
				
			}else{
				
				JOptionPane.showMessageDialog(null,"No hay registros disponibles","SICNAP",0);
				
			}
		}	
		
	}


	@Override
	public void caretUpdate(CaretEvent e) {
		
		if (e.getSource() == vistaSincro.getTxtFiltro()){
			
			
			Contratos contratos = new Contratos();
			List<ContratosPromotor> lista = null;
			
			if(vistaSincro.getrBoxy().isSelected()==true)
			{
				vistaSincro.getEstatus().setSelected(false);
				lista = contratos.listContratosByBoxy(this.vistaSincro.getTxtFiltro().getText());
				cargarTabla(lista);	
			}else if (vistaSincro.getEstatus().isSelected()==true){
				
				vistaSincro.getrBoxy().setSelected(false);					
				
				try {
					lista = contratos.listContratosByEstatus (Integer.parseInt(this.vistaSincro.getTxtFiltro().getText()));
				} catch (Exception e2) {
					lista = contratos.listByProcess();
				}
				
				cargarTabla(lista);	
				
			}
			
		}
		
	}
	
	private void cargarTabla(List<ContratosPromotor> lista){
		DefaultTableModel modelo = new DefaultTableModel();
		JTable tabla = this.vistaSincro.getTablaContratos();
		Object data [] = new Object[5];
		
		modelo.addColumn("Contrato");
		modelo.addColumn("Cedula");
		modelo.addColumn("Nombre");
		modelo.addColumn("Estatus");
		modelo.addColumn("Boxy");
		
		for (int i=0;i<lista.size();i++){
			
		    data[0] = lista.get(i).getCodigoContrato();
		    data[1] = lista.get(i).getPromotores().getCedula();
		    data[2] = lista.get(i).getPromotores().getNombre();
		    data[3] = lista.get(i).getEstatus();
		    data[4] = lista.get(i).getBoxy();
		    modelo.addRow(data);
	
		}
		
		tabla.setModel(modelo);
		this.vistaSincro.setTablaContratos(tabla);
		
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
	public void keyPressed(KeyEvent e) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
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
		
		if (e.getSource() == vistaSincro.getTablaContratos()){
			
			if (e.getClickCount() == 2){
				if (vistaSincro.getEstatus().isSelected() == true && vistaSincro.getTxtFiltro().getText().equals("1")){
					int indice = vistaSincro.getTablaContratos().getSelectedRow();
					String contrato = vistaSincro.getTablaContratos().getValueAt(indice,0).toString();
					if (perDao.Acceso("VistaContratoAsignad") == 1){
						VistaContratoAsignad vCont = new VistaContratoAsignad("Ficha Abonado por Contrato","");
						vCont.getTxtContrato().setText(contrato);
						centrarFrm (vCont,VisorMDI.getFrmMenu());
						content.add(vCont);// Agregamos el frame al escritorio
						try {
							vCont.setSelected(true);// Decimos que comience Enfocado				
						} 
						catch (PropertyVetoException e1) {}				
					}
				}
			}
			
		}
		
	}
	
    public void centrarFrm (JInternalFrame hijo ,VistaMDI padre){		
		 
		 hijo.setLocation(padre.getWidth()/2 - hijo.getWidth()/2 ,
		 padre.getHeight()/2 - hijo.getHeight()/2 - 20); 
		 // CENTRA EL FORMULARIO
		 
	 }

}
