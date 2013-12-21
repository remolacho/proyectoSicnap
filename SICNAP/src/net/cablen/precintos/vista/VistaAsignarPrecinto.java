package net.cablen.precintos.vista;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

import net.cablen.precintos.controlador.Controller_asignar_precinto;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VistaAsignarPrecinto extends JInternalFrame {


    private ButtonGroup grupoRadio;
	private  JRadioButton rCCS,rInt;
	private JTextField txtCedula;
	private JButton btmPromotor;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JPanel panel_1;
	
	private Controller_asignar_precinto ctlPre;
	private JLabel lblPrecintoInicial;
	private JTextField txtInicial;
	private JLabel lblPrecintoFinal;
	private JTextField txtFinal;
	private JButton btmCargar;
	private JButton btmGenerar;
	private JComboBox cmbFinal;
	private JTable table;
	private JComboBox cmbColor;
	private JLabel lblColor;
	private JLabel lblLetra;
	
	public VistaAsignarPrecinto(String titulo) {
		super(titulo,false, //redimencionar,
		true, //cerrar
		false,//maximizar
		false);//minimizar
		setFrameIcon(new ImageIcon("img/sistema.png"));
		getContentPane().setBackground(Color.WHITE);
		
		ctlPre = new Controller_asignar_precinto(this);
		this.setSize(new Dimension(602, 648));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		table =  new JTable(){
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
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 564, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 564, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		panel_1.setLayout(null);
		
		lblPrecintoInicial = new JLabel("Precinto Inicial");
		lblPrecintoInicial.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrecintoInicial.setBounds(10, 42, 117, 15);
		panel_1.add(lblPrecintoInicial);
		
		txtInicial = new JTextField("0");
		txtInicial.setForeground(Color.BLUE);
		txtInicial.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtInicial.setBounds(110, 39, 81, 21);
		panel_1.add(txtInicial);
		
		lblPrecintoFinal = new JLabel("Precinto Final");
		lblPrecintoFinal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrecintoFinal.setBounds(221, 42, 102, 15);
		panel_1.add(lblPrecintoFinal);
		
		txtFinal = new JTextField();
		txtFinal.setText("0");
		txtFinal.setForeground(Color.BLUE);
		txtFinal.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtFinal.setColumns(10);
		txtFinal.setBounds(322, 39, 81, 21);
		panel_1.add(txtFinal);
		
		btmCargar = new JButton("Cargar");
		btmCargar.setIcon(new ImageIcon("img/upload.png"));
		btmCargar.setHorizontalAlignment(SwingConstants.LEFT);
		btmCargar.setBackground(SystemColor.menu);
		btmCargar.setBounds(10, 71, 90, 23);
		btmCargar.addActionListener(ctlPre);
		panel_1.add(btmCargar);
		
		btmGenerar = new JButton("Generar");
		btmGenerar.setIcon(new ImageIcon("img/new.png"));
		btmGenerar.setHorizontalAlignment(SwingConstants.LEFT);
		btmGenerar.setEnabled(false);
		btmGenerar.setBackground(SystemColor.menu);
		btmGenerar.addActionListener(ctlPre);
		btmGenerar.setBounds(110, 71, 102, 23);
		panel_1.add(btmGenerar);
		
	    cmbFinal = new JComboBox();
		cmbFinal.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "\u00D1", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"}));
		cmbFinal.setBounds(56, 11, 44, 20);
		panel_1.add(cmbFinal);
		
		cmbColor = new JComboBox();
		cmbColor.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "\u00D1", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"}));
		cmbColor.setBounds(147, 11, 44, 20);
		panel_1.add(cmbColor);
		
		lblColor = new JLabel("Color");
		lblColor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblColor.setBounds(110, 16, 71, 15);
		panel_1.add(lblColor);
		
		lblLetra = new JLabel("Letra");
		lblLetra.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLetra.setBounds(10, 13, 90, 15);
		panel_1.add(lblLetra);
		panel.setLayout(null);
		
		rCCS = new JRadioButton("CCS");
		rCCS.setSelected(true);
		rCCS.setFont(new Font("Tahoma", Font.BOLD, 11));
		rCCS.setBackground(Color.WHITE);
		rCCS.setBounds(15, 95, 50, 23);
		panel.add(rCCS);
		
		rInt = new JRadioButton("INT");
		rInt.setFont(new Font("Tahoma", Font.BOLD, 11));
		rInt.setBackground(Color.WHITE);
		rInt.setBounds(69, 95, 50, 23);
		panel.add(rInt);
		grupoRadio = new ButtonGroup();
		grupoRadio.add(rCCS);
		grupoRadio.add(rInt);
		
		txtCedula = new JTextField();
		txtCedula.setColumns(10);
		txtCedula.setBounds(77, 11, 97, 20);
		txtCedula.addCaretListener(ctlPre);
		panel.add(txtCedula);
		
		btmPromotor = new JButton("Entes");
		btmPromotor.setIcon(new ImageIcon("img/promotor.png"));
		btmPromotor.setHorizontalAlignment(SwingConstants.LEFT);
		btmPromotor.setBackground(SystemColor.menu);
		btmPromotor.setBounds(180, 12, 97, 19);
		btmPromotor.addActionListener(ctlPre);
		panel.add(btmPromotor);
		
		label = new JLabel("Nombre");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(18, 47, 47, 15);
		panel.add(label);
		
		label_1 = new JLabel("Apellido");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(16, 73, 49, 15);
		panel.add(label_1);
		
		label_2 = new JLabel("Cedula");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(16, 11, 41, 15);
		panel.add(label_2);
		
		lblNombre = new JLabel("_");
		lblNombre.setForeground(Color.GRAY);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(77, 45, 200, 17);
		panel.add(lblNombre);
		
		lblApellido = new JLabel("_");
		lblApellido.setForeground(Color.GRAY);
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellido.setBounds(77, 71, 200, 17);
		panel.add(lblApellido);
		getContentPane().setLayout(groupLayout);
		this.setVisible(true);

	}

	public JRadioButton getrCCS() {
		return rCCS;
	}

	public void setrCCS(JRadioButton rCCS) {
		this.rCCS = rCCS;
	}

	public JRadioButton getrInt() {
		return rInt;
	}

	public void setrInt(JRadioButton rInt) {
		this.rInt = rInt;
	}

	public JTextField getTxtCedula() {
		return txtCedula;
	}

	public void setTxtCedula(JTextField txtCedula) {
		this.txtCedula = txtCedula;
	}

	public JButton getBtmPromotor() {
		return btmPromotor;
	}

	public void setBtmPromotor(JButton btmPromotor) {
		this.btmPromotor = btmPromotor;
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JLabel getLblApellido() {
		return lblApellido;
	}

	public void setLblApellido(JLabel lblApellido) {
		this.lblApellido = lblApellido;
	}

	public JTextField getTxtInicial() {
		return txtInicial;
	}

	public void setTxtInicial(JTextField txtInicial) {
		this.txtInicial = txtInicial;
	}

	public JTextField getTxtFinal() {
		return txtFinal;
	}

	public void setTxtFinal(JTextField txtFinal) {
		this.txtFinal = txtFinal;
	}

	public JButton getBtmCargar() {
		return btmCargar;
	}

	public void setBtmCargar(JButton btmCargar) {
		this.btmCargar = btmCargar;
	}

	public JButton getBtmGenerar() {
		return btmGenerar;
	}

	public void setBtmGenerar(JButton btmGenerar) {
		this.btmGenerar = btmGenerar;
	}

	public JComboBox getCmbFinal() {
		return cmbFinal;
	}

	public void setCmbFinal(JComboBox cmbFinal) {
		this.cmbFinal = cmbFinal;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JComboBox getCmbColor() {
		return cmbColor;
	}

	public void setCmbColor(JComboBox cmbColor) {
		this.cmbColor = cmbColor;
	}
	
	
}
