package net.cablen.precintos.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;

import net.cablen.precintos.controlador.Controller_asignar_precinto;
import net.cablen.precintos.controlador.Controller_sincro_precinto;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VistaSincroPrecintos extends JInternalFrame {

	private JRadioButton rEstatus,rBoxy;
	private ButtonGroup grupoRadio;
	private JLabel label;
	private JTextField txtBuscar;
	private JButton btmTodos;
	private JButton btmSincro;
	private JScrollPane scrollPane;
	private JTable table;
	private Controller_sincro_precinto ctlSincro;
	
	public VistaSincroPrecintos(String titulo) {
		super(titulo,false, //redimencionar,
		true, //cerrar
		false,//maximizar
		false);
		setFrameIcon(new ImageIcon("img/sistema.png"));
		getContentPane().setBackground(Color.WHITE);
		ctlSincro = new Controller_sincro_precinto(this);
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.GRAY, 2));
		panel.setBackground(Color.WHITE);
		
        rBoxy = new JRadioButton("Por Boxy", true);
		rBoxy.setFont(new Font("Tahoma", Font.BOLD, 11));
		rBoxy.setBackground(Color.WHITE);
		
	    rEstatus = new JRadioButton("Por Estatus", false);
		rEstatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		rEstatus.setBackground(Color.WHITE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 564, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addComponent(rBoxy)
					.addGap(18)
					.addComponent(rEstatus)
					.addGap(359))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 32, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(rBoxy, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(rEstatus, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
		);
		panel.setLayout(gl_panel);
		
		label = new JLabel("Filtro");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtBuscar = new JTextField();
		txtBuscar.setColumns(10);
		txtBuscar.addCaretListener(ctlSincro);
		btmTodos = new JButton("Todos");
		btmTodos.setIcon(new ImageIcon("img/buscar.png"));
		btmTodos.setHorizontalAlignment(SwingConstants.LEFT);
		btmTodos.addActionListener(ctlSincro);
		btmTodos.setBackground(SystemColor.menu);
		
		btmSincro = new JButton("Sincronizar");
		btmSincro.setIcon(new ImageIcon("img/sincro.png"));
		btmSincro.setHorizontalAlignment(SwingConstants.LEFT);
		btmSincro.addActionListener(ctlSincro);
		btmSincro.setBackground(SystemColor.menu);
		table =  new JTable(){
	        public boolean isCellEditable(int rowIndex, int vColIndex) {
	            return false;
	     }};
		scrollPane = new JScrollPane(table);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(scrollPane, Alignment.LEADING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 499, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(txtBuscar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addGap(16)
							.addComponent(btmTodos, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btmSincro, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtBuscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btmTodos, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(btmSincro, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		this.addInternalFrameListener(ctlSincro);
		grupoRadio = new ButtonGroup();
		grupoRadio.add(rBoxy);
		grupoRadio.add(rEstatus);
		
		getContentPane().setLayout(groupLayout);
		this.setSize(new Dimension(535, 577));
		this.setVisible(true);
	}

	public JRadioButton getrEstatus() {
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

	public JTextField getTxtBuscar() {
		return txtBuscar;
	}

	public void setTxtBuscar(JTextField txtBuscar) {
		this.txtBuscar = txtBuscar;
	}

	public JButton getBtmTodos() {
		return btmTodos;
	}

	public void setBtmTodos(JButton btmTodos) {
		this.btmTodos = btmTodos;
	}

	public JButton getBtmSincro() {
		return btmSincro;
	}

	public void setBtmSincro(JButton btmSincro) {
		this.btmSincro = btmSincro;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	
	
	
	
}
