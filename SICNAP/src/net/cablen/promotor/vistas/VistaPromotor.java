package net.cablen.promotor.vistas;

import java.awt.Dimension;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTable;

import net.cablen.promotor.controlador.Controller_promotor;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class VistaPromotor extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCod;
	private JTextField txtNom;
	private JTextField txtTF;
	private JTextField txtCed;
	private JTextField txtApe;
	private JTextField txtTM;
	private JTextField txtFiltro;
	private JTable table;
	private JButton btmNuevo,btmMod,btmAgregar;
	private Controller_promotor ctlPromotor;
	
	public VistaPromotor(String titulo) {
		super(titulo,false, //redimencionar,
		true, //cerrar
		false,//maximizar
		true);
		setFrameIcon(new ImageIcon("img/sistema.png"));
		getContentPane().setBackground(Color.WHITE);
		this.setSize(new Dimension(600, 600));
	    ctlPromotor = new Controller_promotor(this);
	    
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del Promotor", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		table = new JTable(){
	        public boolean isCellEditable(int rowIndex, int vColIndex) {
	            return false;
	     }};
		table.setBackground(SystemColor.inactiveCaptionBorder);
	    table.addMouseListener(ctlPromotor);
		JScrollPane scrollPane = new JScrollPane(table);
		JLabel lblBuscar = new JLabel("Filtro Por Apellido");
		lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtFiltro = new JTextField();
		txtFiltro.addCaretListener(ctlPromotor);
		txtFiltro.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(lblBuscar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtFiltro, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblBuscar)
						.addComponent(txtFiltro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		
		//scrollPane.setColumnHeaderView(table);
		panel.setLayout(null);
		
		JLabel lblCod = new JLabel("Codigo");
		lblCod.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCod.setBounds(11, 25, 55, 14);
		panel.add(lblCod);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(10, 49, 56, 14);
		panel.add(lblNombre);
		
		JLabel lblTelF = new JLabel("Telf. Fijo");
		lblTelF.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelF.setBounds(10, 74, 76, 14);
		panel.add(lblTelF);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCedula.setBounds(228, 26, 80, 14);
		panel.add(lblCedula);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellido.setBounds(228, 51, 80, 14);
		panel.add(lblApellido);
		
		JLabel lblTelM = new JLabel("Telf. Movil");
		lblTelM.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelM.setBounds(228, 76, 80, 14);
		panel.add(lblTelM);
		
		txtCod = new JTextField();
		txtCod.setEnabled(false);
		txtCod.setBounds(96, 23, 49, 20);
		panel.add(txtCod);
		txtCod.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setBounds(96, 48, 122, 20);
		panel.add(txtNom);
		txtNom.setColumns(10);
		
		txtTF = new JTextField();
		txtTF.setBounds(96, 73, 122, 20);
		panel.add(txtTF);
		txtTF.setColumns(10);
		txtTF.addKeyListener(ctlPromotor);
		
		txtCed = new JTextField();
		txtCed.setBounds(307, 25, 86, 20);
		panel.add(txtCed);
		txtCed.setColumns(10);
		txtCed.addKeyListener(ctlPromotor);
		
		txtApe = new JTextField();
		txtApe.setBounds(307, 50, 122, 20);
		panel.add(txtApe);
		txtApe.setColumns(10);
		
		txtTM = new JTextField();
		txtTM.setBounds(307, 75, 122, 20);
		panel.add(txtTM);
		txtTM.setColumns(10);
		txtTM.addKeyListener(ctlPromotor);
		
		btmNuevo = new JButton("Nuevo");
		btmNuevo.setBackground(SystemColor.menu);
		btmNuevo.setIcon(new ImageIcon("img/new.png"));
		btmNuevo.setHorizontalAlignment(SwingConstants.LEFT);
		btmNuevo.addActionListener(ctlPromotor);
		btmNuevo.setBounds(439, 21, 115, 23);
		panel.add(btmNuevo);
		
	    btmMod = new JButton("Modificar");
	    btmMod.setBackground(SystemColor.menu);
	    btmMod.setIcon(new ImageIcon("img/upd.png"));
	    btmMod.setHorizontalAlignment(SwingConstants.LEFT);
	    btmMod.addActionListener(ctlPromotor);
		btmMod.setBounds(439, 71, 116, 23);
		panel.add(btmMod);
		
	    btmAgregar = new JButton("Agregar");
	    btmAgregar.setBackground(SystemColor.menu);
	    btmAgregar.setIcon(new ImageIcon("img/save.png"));
	    btmAgregar.setHorizontalAlignment(SwingConstants.LEFT);
		btmAgregar.setBounds(439, 47, 115, 23);
		btmAgregar.addActionListener(ctlPromotor);
		panel.add(btmAgregar);
		getContentPane().setLayout(groupLayout);
		this.addInternalFrameListener(ctlPromotor);
		this.setVisible(true);
	}

	public JTextField getTxtCod() {
		return txtCod;
	}

	public void setTxtCod(JTextField txtCod) {
		this.txtCod = txtCod;
	}

	public JTextField getTxtNom() {
		return txtNom;
	}

	public void setTxtNom(JTextField txtNom) {
		this.txtNom = txtNom;
	}

	public JTextField getTxtTF() {
		return txtTF;
	}

	public void setTxtTF(JTextField txtTF) {
		this.txtTF = txtTF;
	}

	public JTextField getTxtCed() {
		return txtCed;
	}

	public void setTxtCed(JTextField txtCed) {
		this.txtCed = txtCed;
	}

	public JTextField getTxtApe() {
		return txtApe;
	}

	public void setTxtApe(JTextField txtApe) {
		this.txtApe = txtApe;
	}

	public JTextField getTxtTM() {
		return txtTM;
	}

	public void setTxtTM(JTextField txtTM) {
		this.txtTM = txtTM;
	}

	public JTextField getTxtFiltro() {
		return txtFiltro;
	}

	public void setTxtFiltro(JTextField txtFiltro) {
		this.txtFiltro = txtFiltro;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JButton getBtmNuevo() {
		return btmNuevo;
	}

	public void setBtmNuevo(JButton btmNuevo) {
		this.btmNuevo = btmNuevo;
	}

	public JButton getBtmAgregar() {
		return btmAgregar;
	}

	public void setBtmAgregar(JButton btmAgregar) {
		this.btmAgregar = btmAgregar;
	}

	public JButton getBtmMod() {
		return btmMod;
	}

	public void setBtmMod(JButton btmMod) {
		this.btmMod = btmMod;
	}
}
