package net.cablen.soporte.cartera.recuperacion.vista;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;

import net.cablen.soporte.cartera.recuperacion.controlador.Controller_cartera_apertura;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import com.toedter.calendar.JDateChooser;

public class VistaCarteraApertura extends JInternalFrame {
	private JTextField txtCedula;
	private JTable table;
	private Controller_cartera_apertura ctlCart;
	private JTextField txtAbonado;
	private JTextField txtNombre;
	private JTextField txtReferencia;
	private JTextField txtDomi;
	private JTextField txtCiudad;
	private JTextField txtCalle;
	private JTextField txtTelefono;
	private JTextField txtPoste;
	private JTextField txtSaldo;
	private JLabel lblInc,lblCorrelativo,lblFecha;
	private JTextField txtDescripcion;
	private JButton btmGuardar;
	private JCheckBox chFecha;
	private JTextArea txtComentario;
	private JDateChooser txtFecha;
	private JComboBox cmbAct;
	
	public VistaCarteraApertura(String titulo) {
		super(titulo,false, //redimencionar,
				true, //cerrar
				false,//maximizar
				false);//minimizar
		setFrameIcon(new ImageIcon("img/sistema.png"));
		getContentPane().setBackground(Color.WHITE);
		this.ctlCart = new Controller_cartera_apertura(this);
		this.setSize(930,652);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Buscar Abonado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		panel.setBackground(Color.WHITE);
		
		JLabel label = new JLabel("C.I");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(10, 30, 33, 14);
		panel.add(label);
		
		txtCedula = new JTextField();
		txtCedula.setToolTipText("PULSAR ENTER");
		txtCedula.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtCedula.setColumns(10);
		txtCedula.setBounds(53, 28, 86, 20);
		txtCedula.addKeyListener(ctlCart);
		panel.add(txtCedula);
		
	    lblFecha = new JLabel("");
		lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFecha.setForeground(new Color(0, 0, 128));
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFecha.setBounds(476, 22, 388, 33);
		panel.add(lblFecha);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(281, 11, 151, 55);
		label_2.setIcon(new ImageIcon("img/minilogo.png"));
		panel.add(label_2);
		table = new JTable(){
	        public boolean isCellEditable(int rowIndex, int vColIndex) {
	            return false;
	    }};
	    table.addMouseListener(ctlCart);
		JScrollPane scrollPane = new JScrollPane(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		panel_1.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 894, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(null);
		
		JLabel label_3 = new JLabel("Incidencia");
		label_3.setForeground(new Color(0, 0, 128));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(10, 11, 74, 14);
		panel_1.add(label_3);
		
		lblInc = new JLabel("_________");
		lblInc.setForeground(Color.RED);
		lblInc.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblInc.setBounds(94, 12, 104, 14);
		panel_1.add(lblInc);
		
		JLabel label_5 = new JLabel("Abonado");
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(10, 40, 74, 20);
		panel_1.add(label_5);
		
		txtAbonado = new JTextField();
		txtAbonado.setForeground(Color.BLACK);
		txtAbonado.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtAbonado.setEditable(false);
		txtAbonado.setColumns(10);
		txtAbonado.setBounds(94, 40, 104, 20);
		panel_1.add(txtAbonado);
		
		JLabel label_6 = new JLabel("Nombre");
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_6.setBounds(10, 66, 59, 24);
		panel_1.add(label_6);
		
		txtNombre = new JTextField();
		txtNombre.setForeground(Color.BLACK);
		txtNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(94, 68, 355, 20);
		panel_1.add(txtNombre);
		
		JLabel label_7 = new JLabel("Referencia");
		label_7.setForeground(Color.BLACK);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_7.setBounds(10, 101, 74, 19);
		panel_1.add(label_7);
		
		txtReferencia = new JTextField();
		txtReferencia.setForeground(Color.BLACK);
		txtReferencia.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtReferencia.setEditable(false);
		txtReferencia.setColumns(10);
		txtReferencia.setBounds(94, 97, 355, 20);
		panel_1.add(txtReferencia);
		
		JLabel label_8 = new JLabel("Domicilio");
		label_8.setForeground(Color.BLACK);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_8.setBounds(10, 133, 74, 19);
		panel_1.add(label_8);
		
		txtDomi = new JTextField();
		txtDomi.setForeground(Color.BLACK);
		txtDomi.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtDomi.setEditable(false);
		txtDomi.setColumns(10);
		txtDomi.setBounds(94, 131, 355, 20);
		panel_1.add(txtDomi);
		
		JLabel label_9 = new JLabel("Ciudad");
		label_9.setForeground(Color.BLACK);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_9.setBounds(471, 12, 74, 19);
		panel_1.add(label_9);
		
		txtCiudad = new JTextField();
		txtCiudad.setForeground(Color.BLACK);
		txtCiudad.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCiudad.setEditable(false);
		txtCiudad.setColumns(10);
		txtCiudad.setBounds(545, 11, 295, 20);
		panel_1.add(txtCiudad);
		
		JLabel label_10 = new JLabel("Calle");
		label_10.setForeground(Color.BLACK);
		label_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10.setBounds(471, 41, 59, 19);
		panel_1.add(label_10);
		
		txtCalle = new JTextField();
		txtCalle.setForeground(Color.BLACK);
		txtCalle.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCalle.setEditable(false);
		txtCalle.setColumns(10);
		txtCalle.setBounds(545, 40, 295, 20);
		panel_1.add(txtCalle);
		
		JLabel label_11 = new JLabel("Telefono");
		label_11.setForeground(Color.BLACK);
		label_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_11.setBounds(471, 67, 67, 14);
		panel_1.add(label_11);
		
		txtTelefono = new JTextField();
		txtTelefono.setForeground(Color.BLACK);
		txtTelefono.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtTelefono.setEditable(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(545, 66, 116, 20);
		panel_1.add(txtTelefono);
		
		JLabel label_12 = new JLabel("Poste");
		label_12.setForeground(Color.BLACK);
		label_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_12.setBounds(471, 99, 43, 14);
		panel_1.add(label_12);
		
		txtPoste = new JTextField();
		txtPoste.setForeground(Color.BLACK);
		txtPoste.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtPoste.setEditable(false);
		txtPoste.setColumns(10);
		txtPoste.setBounds(545, 96, 67, 20);
		panel_1.add(txtPoste);
		
		JLabel label_13 = new JLabel("Saldo");
		label_13.setForeground(Color.BLACK);
		label_13.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_13.setBounds(471, 135, 43, 14);
		panel_1.add(label_13);
		
		txtSaldo = new JTextField();
		txtSaldo.setForeground(Color.BLACK);
		txtSaldo.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtSaldo.setEditable(false);
		txtSaldo.setColumns(10);
		txtSaldo.setBounds(545, 132, 67, 20);
		panel_1.add(txtSaldo);
		
	    lblCorrelativo = new JLabel("");
	    lblCorrelativo.setVisible(false);
		lblCorrelativo.setBounds(208, 13, 46, 14);
		panel_1.add(lblCorrelativo);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Troubleshooting", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 163, 874, 202);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_4 = new JLabel("Actividad");
		label_4.setBounds(10, 23, 74, 19);
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_2.add(label_4);
		
		cmbAct = new JComboBox();
		cmbAct.setBounds(94, 23, 295, 20);
		cmbAct.addActionListener(ctlCart);
		panel_2.add(cmbAct);
		
		JLabel label_14 = new JLabel("Descripcion");
		label_14.setBounds(10, 81, 74, 19);
		label_14.setForeground(Color.BLACK);
		label_14.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_2.add(label_14);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(94, 81, 543, 20);
		txtDescripcion.setColumns(10);
		panel_2.add(txtDescripcion);
		
		JLabel label_15 = new JLabel("Comentario");
		label_15.setBounds(10, 116, 74, 19);
		label_15.setForeground(Color.BLACK);
		label_15.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_2.add(label_15);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(94, 112, 770, 79);
		panel_2.add(scrollPane_1);
		
	    txtComentario = new JTextArea();
		txtComentario.setRows(4);
		txtComentario.setColumns(50);
		txtComentario.setBackground(SystemColor.inactiveCaptionBorder);
		txtComentario.addKeyListener(ctlCart);
		txtComentario.setLineWrap(true); 
		scrollPane_1.setColumnHeaderView(txtComentario);
		
		chFecha = new JCheckBox("Fecha Compromiso");
		chFecha.setBounds(6, 52, 78, 23);
		chFecha.setBackground(Color.WHITE);
		chFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		chFecha.addMouseListener(ctlCart);
		panel_2.add(chFecha);
		
	    txtFecha = new JDateChooser();
		txtFecha.setBounds(94, 54, 110, 20);
		txtFecha.setEnabled(false);
		panel_2.add(txtFecha);
		
		btmGuardar = new JButton("Generear Incidencia");
		btmGuardar.setIcon(new ImageIcon("img/save.png"));
		btmGuardar.setHorizontalAlignment(SwingConstants.LEFT);
		btmGuardar.setBounds(10, 370, 188, 23);
		btmGuardar.addActionListener(ctlCart);
		panel_1.add(btmGuardar);
		
		this.addInternalFrameListener(ctlCart);
		getContentPane().setLayout(groupLayout);
		this.setVisible(true);

	}

	public JTextField getTxtCedula() {
		return txtCedula;
	}

	public void setTxtCedula(JTextField txtCedula) {
		this.txtCedula = txtCedula;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JTextField getTxtAbonado() {
		return txtAbonado;
	}

	public void setTxtAbonado(JTextField txtAbonado) {
		this.txtAbonado = txtAbonado;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtReferencia() {
		return txtReferencia;
	}

	public void setTxtReferencia(JTextField txtReferencia) {
		this.txtReferencia = txtReferencia;
	}

	public JTextField getTxtDomi() {
		return txtDomi;
	}

	public void setTxtDomi(JTextField txtDomi) {
		this.txtDomi = txtDomi;
	}

	public JTextField getTxtCiudad() {
		return txtCiudad;
	}

	public void setTxtCiudad(JTextField txtCiudad) {
		this.txtCiudad = txtCiudad;
	}

	public JTextField getTxtCalle() {
		return txtCalle;
	}

	public void setTxtCalle(JTextField txtCalle) {
		this.txtCalle = txtCalle;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public JTextField getTxtPoste() {
		return txtPoste;
	}

	public void setTxtPoste(JTextField txtPoste) {
		this.txtPoste = txtPoste;
	}

	public JTextField getTxtSaldo() {
		return txtSaldo;
	}

	public void setTxtSaldo(JTextField txtSaldo) {
		this.txtSaldo = txtSaldo;
	}

	public JLabel getLblInc() {
		return lblInc;
	}

	public void setLblInc(JLabel lblInc) {
		this.lblInc = lblInc;
	}

	public JLabel getLblCorrelativo() {
		return lblCorrelativo;
	}

	public void setLblCorrelativo(JLabel lblCorrelativo) {
		this.lblCorrelativo = lblCorrelativo;
	}

	public JTextField getTxtDescripcion() {
		return txtDescripcion;
	}

	public void setTxtDescripcion(JTextField txtDescripcion) {
		this.txtDescripcion = txtDescripcion;
	}

	public JButton getBtmGuardar() {
		return btmGuardar;
	}

	public void setBtmGuardar(JButton btmGuardar) {
		this.btmGuardar = btmGuardar;
	}

	public JTextArea getTxtComentario() {
		return txtComentario;
	}

	public void setTxtComentario(JTextArea txtComentario) {
		this.txtComentario = txtComentario;
	}

	public JCheckBox getChFecha() {
		return chFecha;
	}

	public void setChFecha(JCheckBox chFecha) {
		this.chFecha = chFecha;
	}

	public JComboBox getCmbAct() {
		return cmbAct;
	}

	public void setCmbAct(JComboBox cmbAct) {
		this.cmbAct = cmbAct;
	}

	public JLabel getLblFecha() {
		return lblFecha;
	}

	public void setLblFecha(JLabel lblFecha) {
		this.lblFecha = lblFecha;
	}

	public JDateChooser getTxtFecha() {
		return txtFecha;
	}

	public void setTxtFecha(JDateChooser txtFecha) {
		this.txtFecha = txtFecha;
	}
	
	
	
}
