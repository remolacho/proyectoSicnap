package net.cablen.caja.conciliaciones.vista;

import javax.swing.ButtonGroup;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;


import net.cablen.caja.conciliaciones.controlador.Controller_list;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

public class ListaConciliaciones extends JInternalFrame {


	private ButtonGroup grupoRadio;
	private JTable table;
	private JRadioButton rAbiertas,rCerradas;
	private Controller_list ctrList;
	
	public ListaConciliaciones(String titulo) {
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
	    table.addMouseListener(ctrList);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.getViewport().setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		
		panel.setLayout(null);
		
		rAbiertas = new JRadioButton("Abiertas",true);
		rAbiertas.setBackground(Color.WHITE);
		rAbiertas.setFont(new Font("Tahoma", Font.BOLD, 12));
		rAbiertas.setBounds(20, 24, 85, 23);
		rAbiertas.addActionListener(ctrList);
		panel.add(rAbiertas);
		
		rCerradas = new JRadioButton("Cerradas",false);
		rCerradas.setBackground(Color.WHITE);
		rCerradas.setFont(new Font("Tahoma", Font.BOLD, 12));
		rCerradas.setBounds(107, 24, 86, 23);
		rCerradas.addActionListener(ctrList);
		panel.add(rCerradas);
		getContentPane().setLayout(groupLayout);
		
		grupoRadio = new ButtonGroup();
		grupoRadio.add(rAbiertas);
		grupoRadio.add(rCerradas);
		
		this.addInternalFrameListener(ctrList);
		this.setVisible(true);

	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
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

	
	
}
