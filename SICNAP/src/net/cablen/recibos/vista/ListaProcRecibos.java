package net.cablen.recibos.vista;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import net.cablen.recibos.controlador.Controller_lista_recibos;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListaProcRecibos extends JInternalFrame {

	private JRadioButton rEnte,rRecibo;
	private ButtonGroup grupoRadio;
	private JTextField txtEnte;
	private JButton btmEnte;
	private JLabel lblNewLabel_1;
	private JTextField txtRecibo;
	private JButton btmRecibo;
	private Controller_lista_recibos ctlLista;
	private JTable table;
	private JRadioButton rTodos;
	
	public ListaProcRecibos(String titulo) {
		super(titulo,false, //redimencionar,
		true, //cerrar
		false,//maximizar
		false);//minimizar
		this.setFrameIcon(new ImageIcon("img/sistema.png"));
		this.getContentPane().setBackground(UIManager.getColor("List.background"));
		this.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));
		this.ctlLista = new Controller_lista_recibos(this);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		panel.setBackground(Color.WHITE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		panel_1.setBackground(Color.WHITE);
		
		table = new JTable(){
	        public boolean isCellEditable(int rowIndex, int vColIndex) {
	            return false;
	     }};;
	    table.addMouseListener(ctlLista);
	     
		JScrollPane scrollPane = new JScrollPane(table);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ente");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(20, 15, 46, 14);
		panel_1.add(lblNewLabel);
		
		txtEnte = new JTextField();
		txtEnte.setEnabled(false);
		txtEnte.addCaretListener(ctlLista);
		txtEnte.setBounds(83, 12, 86, 20);
		panel_1.add(txtEnte);
		txtEnte.setColumns(10);
		
	    btmEnte = new JButton("Ente");
	    btmEnte.setEnabled(false);
		btmEnte.setBackground(SystemColor.menu);
		btmEnte.setHorizontalAlignment(SwingConstants.LEFT);
		btmEnte.setIcon(new ImageIcon("img/promotor.png"));
		btmEnte.addActionListener(ctlLista);
		btmEnte.setBounds(179, 11, 89, 23);
		panel_1.add(btmEnte);
		
		lblNewLabel_1 = new JLabel("Recibo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(20, 48, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		txtRecibo = new JTextField();
		txtRecibo.setEnabled(false);
		txtRecibo.setBounds(83, 43, 86, 20);
		panel_1.add(txtRecibo);
		txtRecibo.setColumns(10);
		
		btmRecibo = new JButton("Buscar");
		btmRecibo.setBackground(SystemColor.menu);
		btmRecibo.setEnabled(false);
		btmRecibo.setIcon(new ImageIcon("img/buscar.png"));
		btmRecibo.setHorizontalAlignment(SwingConstants.LEFT);
		btmRecibo.setBounds(179, 42, 89, 23);
		btmRecibo.addActionListener(ctlLista);
		panel_1.add(btmRecibo);
		panel.setLayout(null);
		
	    rEnte = new JRadioButton("Por Ente");
	    rEnte.setFont(new Font("Tahoma", Font.BOLD, 11));
	    rEnte.addActionListener(ctlLista);
		rEnte.setBackground(Color.WHITE);
		rEnte.setBounds(6, 7, 72, 23);
		panel.add(rEnte);
		
		rRecibo = new JRadioButton("Por Recibo");
		rRecibo.setFont(new Font("Tahoma", Font.BOLD, 11));
		rRecibo.addActionListener(ctlLista);
		rRecibo.setBackground(Color.WHITE);
		rRecibo.setBounds(85, 7, 94, 23);
		panel.add(rRecibo);
		
		rTodos = new JRadioButton("Todos");
		rTodos.setFont(new Font("Tahoma", Font.BOLD, 11));
		rTodos.setBackground(Color.WHITE);
		rTodos.setBounds(181, 7, 79, 23);
		rTodos.addActionListener(ctlLista);
		panel.add(rTodos);
		
		grupoRadio = new ButtonGroup();
		grupoRadio.add(rEnte);
		grupoRadio.add(rRecibo);
		grupoRadio.add(rTodos); 
		
		this.addInternalFrameListener(ctlLista);
		this.getContentPane().setLayout(groupLayout);
		this.setSize(new Dimension(600, 600));
		this.setVisible(true);
		
		
	}

	public JRadioButton getrEnte() {
		return rEnte;
	}

	public void setrEnte(JRadioButton rEnte) {
		this.rEnte = rEnte;
	}

	public JRadioButton getrRecibo() {
		return rRecibo;
	}

	public void setrRecibo(JRadioButton rRecibo) {
		this.rRecibo = rRecibo;
	}

	public JTextField getTxtEnte() {
		return txtEnte;
	}

	public void setTxtEnte(JTextField txtEnte) {
		this.txtEnte = txtEnte;
	}

	public JButton getBtmEnte() {
		return btmEnte;
	}

	public void setBtmEnte(JButton btmEnte) {
		this.btmEnte = btmEnte;
	}

	public JTextField getTxtRecibo() {
		return txtRecibo;
	}

	public void setTxtRecibo(JTextField txtRecibo) {
		this.txtRecibo = txtRecibo;
	}

	public JButton getBtmRecibo() {
		return btmRecibo;
	}

	public void setBtmRecibo(JButton btmRecibo) {
		this.btmRecibo = btmRecibo;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JRadioButton getrTodos() {
		return rTodos;
	}

	public void setrTodos(JRadioButton rTodos) {
		this.rTodos = rTodos;
	}
	
	
	
}
