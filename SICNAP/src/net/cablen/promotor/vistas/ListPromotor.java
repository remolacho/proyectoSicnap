package net.cablen.promotor.vistas;

import java.awt.Dimension;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import net.cablen.contratos.vista.FiltroReportContrato;
import net.cablen.precintos.vista.FiltroReportPrecinto;
import net.cablen.precintos.vista.VistaAsignarPrecinto;
import net.cablen.principal.controlador.Controller_MDI;
import net.cablen.principal.vistas.VisorMDI;
import net.cablen.promotor.controlador.Controller_lista_promotor;
import net.cablen.recibos.vista.AsignarRecibos;
import net.cablen.recibos.vista.FiltroReporteRecibos;
import net.cablen.recibos.vista.ListaProcRecibos;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class ListPromotor extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private Controller_lista_promotor ctlPromotor;
	private JButton button;
	private JTable table;
	private FiltroReportContrato filtro; 
	
	/**
	 * @wbp.parser.constructor
	 */
	public ListPromotor(String titulo, FiltroReportContrato vista) {
		super(titulo,false, //redimencionar,
				true, //cerrar
				false,//maximizar
				false);//minimizar
		ctlPromotor = new Controller_lista_promotor(VisorMDI.getFrmMenu(),this,vista);
		inicializar();
	}
	
	public ListPromotor(String titulo, VistaAsignarPrecinto vista) {
		super(titulo,false, //redimencionar,
				true, //cerrar
				false,//maximizar
				false);//minimizar
		ctlPromotor = new Controller_lista_promotor(VisorMDI.getFrmMenu(),this,vista);
		inicializar();
	}
	
	
	public ListPromotor(String titulo, AsignarRecibos vista) {
		super(titulo,false, //redimencionar,
				true, //cerrar
				false,//maximizar
				false);//minimizar
		ctlPromotor = new Controller_lista_promotor(VisorMDI.getFrmMenu(),this,vista);
		inicializar();
	}
	
	public ListPromotor(String titulo, FiltroReportPrecinto vista) {
		super(titulo,false, //redimencionar,
				true, //cerrar
				false,//maximizar
				false);//minimizar
		ctlPromotor = new Controller_lista_promotor(VisorMDI.getFrmMenu(),this,vista);
		inicializar();
	}
	
	public ListPromotor(String titulo, FiltroReporteRecibos vista) {
		super(titulo,false, //redimencionar,
				true, //cerrar
				false,//maximizar
				false);//minimizar
		ctlPromotor = new Controller_lista_promotor(VisorMDI.getFrmMenu(),this,vista);
		inicializar();
	}
	
	public ListPromotor(String titulo, ListaProcRecibos vista) {
		super(titulo,false, //redimencionar,
				true, //cerrar
				false,//maximizar
				false);//minimizar
		ctlPromotor = new Controller_lista_promotor(VisorMDI.getFrmMenu(),this,vista);
		inicializar();
	}
	
	public ListPromotor(String titulo) {
		
		super(titulo,false, //redimencionar,
		true, //cerrar
		false,//maximizar
		false);//minimizar
		ctlPromotor = new Controller_lista_promotor(VisorMDI.getFrmMenu(),this);
		inicializar();
		
	}
	
	private void inicializar(){
		
		setFrameIcon(new ImageIcon("img/sistema.png"));
		getContentPane().setBackground(UIManager.getColor("List.background"));
		
		this.setSize(new Dimension(600, 600));
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("List.background"));
		panel.setBorder(new LineBorder(Color.GRAY, 2));
		springLayout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 45, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 574, SpringLayout.WEST, getContentPane());
		getContentPane().add(panel);
		
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNombre = new JLabel("Apellido");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNombre, -19, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNombre, 12, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNombre, -1, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNombre, 88, SpringLayout.WEST, panel);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		
		txtNombre.addCaretListener(ctlPromotor);
		
		sl_panel.putConstraint(SpringLayout.WEST, txtNombre, 6, SpringLayout.EAST, lblNombre);
		sl_panel.putConstraint(SpringLayout.SOUTH, txtNombre, 0, SpringLayout.SOUTH, lblNombre);
		sl_panel.putConstraint(SpringLayout.EAST, txtNombre, 220, SpringLayout.EAST, lblNombre);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		table = new JTable(){
	        public boolean isCellEditable(int rowIndex, int vColIndex) {
	            return false;
	     }}; 

		table.addMouseListener(ctlPromotor);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 19, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -24, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, panel);
		
	    button = new JButton("Agregar");
	    sl_panel.putConstraint(SpringLayout.NORTH, button, -27, SpringLayout.SOUTH, lblNombre);
	    sl_panel.putConstraint(SpringLayout.SOUTH, button, 0, SpringLayout.SOUTH, lblNombre);
	    button.setBackground(SystemColor.menu);
	    button.setIcon(new ImageIcon("img/new.png"));
		sl_panel.putConstraint(SpringLayout.EAST, button, 0, SpringLayout.EAST, panel);
		button.setFont(new Font("Sylfaen", Font.BOLD, 14));
		panel.add(button);
		getContentPane().add(scrollPane);
		button.addActionListener(ctlPromotor);
		this.addInternalFrameListener(ctlPromotor);
		this.setVisible(true);
		
	}


	public JTextField getTxtNombre() {
		return txtNombre;
	}


	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}


	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}


	public JButton getButton() {
		return button;
	}


	public void setButton(JButton button) {
		this.button = button;
	}
	
	
	
	
}
