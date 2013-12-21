package net.cablen.caja.referencias.vista;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.cablen.caja.referencias.controlador.Controller_list;

import java.awt.Color;
import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class ListaReferencias extends JInternalFrame {


	private ButtonGroup grupoRadio;
	private JTable table;
	private JRadioButton rAbiertas,rCerradas;
	private JComboBox comboBox;
	private Controller_list ctrList;
	private JButton btmNew;
	private JLabel lblPorReferencia;
	private JTextField txtReferencia;
	
	public ListaReferencias(String titulo) {
		super(titulo,false, //redimencionar,
				true, //cerrar
				false,//maximizar
				false);//minimizar
		setFrameIcon(new ImageIcon("img/sistema.png"));
		
		getContentPane().setBackground(Color.WHITE);
		ctrList = new Controller_list(this);
		
		this.setSize(667, 586);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Filtrar", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		table = new JTable(){
	        public boolean isCellEditable(int rowIndex, int vColIndex) {
	            return false;
	    }};
		JScrollPane scrollPane = new JScrollPane(table);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 391, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		
		panel.setLayout(null);
		
		rAbiertas = new JRadioButton("Abiertas",true);
		rAbiertas.setBackground(Color.WHITE);
		rAbiertas.setFont(new Font("Tahoma", Font.BOLD, 12));
		rAbiertas.setBounds(20, 24, 85, 23);
		rAbiertas.addActionListener(ctrList);
		panel.add(rAbiertas);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(ctrList);
		comboBox.setBounds(137, 61, 115, 20);
		panel.add(comboBox);
		
		rCerradas = new JRadioButton("Cerradas",false);
		rCerradas.setBackground(Color.WHITE);
		rCerradas.setFont(new Font("Tahoma", Font.BOLD, 12));
		rCerradas.setBounds(107, 24, 86, 23);
		rCerradas.addActionListener(ctrList);
		panel.add(rCerradas);
		
		JLabel lblDescConcilia = new JLabel("Por Conciliacion");
		lblDescConcilia.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDescConcilia.setBounds(20, 63, 106, 14);
		panel.add(lblDescConcilia);
		getContentPane().setLayout(groupLayout);
		
		grupoRadio = new ButtonGroup();
		grupoRadio.add(rAbiertas);
		grupoRadio.add(rCerradas);
		
		btmNew = new JButton("New RefErr");
		btmNew.setIcon(new ImageIcon("img/new.png"));
		btmNew.setBackground(SystemColor.menu);
		btmNew.setHorizontalAlignment(SwingConstants.LEFT);
		btmNew.setBounds(270, 60, 138, 23);
		btmNew.addActionListener(ctrList);
		panel.add(btmNew);
		
		lblPorReferencia = new JLabel("Por Referencia");
		lblPorReferencia.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPorReferencia.setBounds(20, 88, 106, 14);
		panel.add(lblPorReferencia);
		
		txtReferencia = new JTextField();
		txtReferencia.setBounds(137, 86, 115, 20);
		panel.add(txtReferencia);
		txtReferencia.setColumns(10);
		txtReferencia.addCaretListener(ctrList);
		this.addInternalFrameListener(ctrList);
		this.setVisible(true);

	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	
	

	public JTextField getTxtReferencia() {
		return txtReferencia;
	}

	public void setTxtReferencia(JTextField txtReferencia) {
		this.txtReferencia = txtReferencia;
	}

	public JRadioButton getrAbiertas() {
		return rAbiertas;
	}

	public void setrAbiertas(JRadioButton rAbiertas) {
		this.rAbiertas = rAbiertas;
	}

	public JRadioButton getrCerradas() {
		return rCerradas;
	}

	public void setrCerradas(JRadioButton rCerradas) {
		this.rCerradas = rCerradas;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public JButton getBtmNew() {
		return btmNew;
	}

	public void setBtmNew(JButton btmNew) {
		this.btmNew = btmNew;
	}
}
