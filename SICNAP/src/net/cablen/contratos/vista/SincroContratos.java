package net.cablen.contratos.vista;

import java.awt.Dimension;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.swing.JButton;

import net.cablen.contratos.controlador.Controller_sincro_contrato;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class SincroContratos extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtFiltro;
	private JTable table;
	private JTable table_1;
	private JTable tablaContratos;
	private JButton btnBuscar,btmSincro;
	private JRadioButton rEstatus;
	private JRadioButton rBoxy;
	private JPanel panel;
	private ButtonGroup grupoRadio;
	
	public SincroContratos(String titulo) {
		
		super(titulo,false, //redimencionar,
		true, //cerrar
		false,//maximizar
		false);//minimizar
		setFrameIcon(new ImageIcon("img/sistema.png"));
		getContentPane().setBackground(UIManager.getColor("List.background"));
		
		Controller_sincro_contrato ctlSincro = new Controller_sincro_contrato(this);
		this.setSize(new Dimension(600, 600));
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lblFiltro = new JLabel("Filtro");
		springLayout.putConstraint(SpringLayout.WEST, lblFiltro, 10, SpringLayout.WEST, getContentPane());
		lblFiltro.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblFiltro);
		
		txtFiltro = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, txtFiltro, -498, SpringLayout.EAST, getContentPane());
		txtFiltro.addCaretListener(ctlSincro);
		springLayout.putConstraint(SpringLayout.WEST, txtFiltro, 6, SpringLayout.EAST, lblFiltro);
		springLayout.putConstraint(SpringLayout.SOUTH, txtFiltro, 0, SpringLayout.SOUTH, lblFiltro);
		getContentPane().add(txtFiltro);
		txtFiltro.setColumns(10);
		
		tablaContratos = new JTable(){
	        public boolean isCellEditable(int rowIndex, int vColIndex) {
	            return false;
	     }}; //return false: Desabilitar edición de celdas.;
	     tablaContratos.addMouseListener(ctlSincro);
		springLayout.putConstraint(SpringLayout.NORTH, tablaContratos, 24, SpringLayout.SOUTH, lblFiltro);
		springLayout.putConstraint(SpringLayout.WEST, tablaContratos, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, tablaContratos, -27, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, tablaContratos, 574, SpringLayout.WEST, getContentPane());
		
		JScrollPane scrollPane = new JScrollPane(tablaContratos);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 94, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -24, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -10, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblFiltro, -21, SpringLayout.NORTH, scrollPane);
		getContentPane().add(scrollPane);
		
	    btnBuscar = new JButton("Todos");
	    btnBuscar.setIcon(new ImageIcon("img/buscar.png"));
	    btnBuscar.setHorizontalAlignment(SwingConstants.LEFT);
	    btnBuscar.setBackground(SystemColor.menu);
	    springLayout.putConstraint(SpringLayout.NORTH, btnBuscar, 0, SpringLayout.NORTH, txtFiltro);
	    springLayout.putConstraint(SpringLayout.WEST, btnBuscar, 16, SpringLayout.EAST, txtFiltro);
	    springLayout.putConstraint(SpringLayout.SOUTH, btnBuscar, -21, SpringLayout.NORTH, scrollPane);
		getContentPane().add(btnBuscar);
		
		btmSincro = new JButton("Sincronizar");
		springLayout.putConstraint(SpringLayout.EAST, btmSincro, 152, SpringLayout.EAST, btnBuscar);
		btmSincro.setIcon(new ImageIcon("img/sincro.png"));
		btmSincro.setHorizontalAlignment(SwingConstants.LEFT);
		btmSincro.setBackground(SystemColor.menu);
		springLayout.putConstraint(SpringLayout.NORTH, btmSincro, 0, SpringLayout.NORTH, txtFiltro);
		springLayout.putConstraint(SpringLayout.WEST, btmSincro, 7, SpringLayout.EAST, btnBuscar);
		springLayout.putConstraint(SpringLayout.SOUTH, btmSincro, 0, SpringLayout.SOUTH, lblFiltro);
		getContentPane().add(btmSincro);
		
		panel = new JPanel();
		panel.setBackground(UIManager.getColor("List.background"));
		springLayout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -11, SpringLayout.NORTH, txtFiltro);
		springLayout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, scrollPane);
		panel.setBorder(new LineBorder(Color.GRAY, 2));
		getContentPane().add(panel);
		
		rEstatus = new JRadioButton("Por Estatus",false);
		rEstatus.setBackground(UIManager.getColor("List.background"));
		rEstatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		springLayout.putConstraint(SpringLayout.NORTH, rEstatus, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, rEstatus, -195, SpringLayout.EAST, getContentPane());
		
		rBoxy = new JRadioButton("Por Boxy",true);
		rBoxy.setBackground(UIManager.getColor("List.background"));
		rBoxy.setFont(new Font("Tahoma", Font.BOLD, 11));
		springLayout.putConstraint(SpringLayout.NORTH, rBoxy, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, rBoxy, -110, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, rBoxy, 78, SpringLayout.EAST, rEstatus);
		
		grupoRadio = new ButtonGroup();
		grupoRadio.add(rEstatus);
		grupoRadio.add(rBoxy);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addComponent(rBoxy)
					.addGap(18)
					.addComponent(rEstatus)
					.addGap(359))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(rBoxy, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(rEstatus, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
		);
		panel.setLayout(gl_panel);
		
		
		btnBuscar.addActionListener(ctlSincro);
		btmSincro.addActionListener(ctlSincro);
		
		this.addInternalFrameListener(ctlSincro);
		this.setVisible(true);
		
	}

	public JTextField getTxtFiltro() {
		return txtFiltro;
	}

	public void setTxtFiltro(JTextField txtCedula) {
		this.txtFiltro = txtCedula;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JTable getTable_1() {
		return table_1;
	}

	public void setTable_1(JTable table_1) {
		this.table_1 = table_1;
	}

	public JTable getTablaContratos() {
		return tablaContratos;
	}

	public void setTablaContratos(JTable tablaContratos) {
		this.tablaContratos = tablaContratos;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JButton getBtmSincro() {
		return btmSincro;
	}

	public void setBtmSincro(JButton btmSincro) {
		this.btmSincro = btmSincro;
	}

	public JRadioButton getEstatus() {
		return rEstatus;
	}

	public void setrEstatus(JRadioButton rEstatus) {
		this.rEstatus = rEstatus;
	}

	public JRadioButton getrBoxy() {
		return rBoxy;
	}

	public void setrBoxy(JRadioButton rBoxy) {
		this.rBoxy = rBoxy;
	}
	
	
	
	
}
