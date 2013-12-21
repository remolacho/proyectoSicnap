package net.cablen.soporte.callCenter.troubleshooting.vista;



import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import net.cablen.soporte.callCenter.troubleshooting.controlador.Controller_troubleshooting;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class VistaTroubleshooting extends JInternalFrame {
	private JTextField txtCedula;
	private Controller_troubleshooting ctlTrou = null;
	private JTable table;
	private JTextField txtAbonado;
	private JTextField txtNombre;
	private JTextField txtSaldo;
	private JTextField txtPoste;
	private JTextField txtReferencia;
	private JTextField txtDomicilio;
	private JTextField txtCalle;
	private JTextField txtCiduad;
	private JTextField txtTelefono;
	private JTextField txtDetalle;
	private JTextArea txtComentario;
	private JLabel txtIncidencia,lblCorrelativo,lblFecha ;
	private JComboBox cmbActividad;
	private JButton btmSave;
	private JPanel panel,panel_1;
	private JLabel label;
	
	public VistaTroubleshooting(String titulo) {
		super(titulo,false, //redimencionar,
				true, //cerrar
				false,//maximizar
				false);//minimizar
		
		this.ctlTrou = new Controller_troubleshooting(this);
		this.setFrameIcon(new ImageIcon("img/sistema.png"));
		this.getContentPane().setBackground(UIManager.getColor("List.background"));
		
	    panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Buscar Abonado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		panel.setBackground(Color.WHITE);
		table = new JTable(){
	        public boolean isCellEditable(int rowIndex, int vColIndex) {
	            return false;
	    }};
	    table.addMouseListener(ctlTrou);
		JScrollPane scrollPane = new JScrollPane(table);
		
	    panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		panel_1.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 894, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
					.addGap(16))
		);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Incidencia");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(23, 37, 74, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblAbonado = new JLabel("Abonado");
		lblAbonado.setForeground(new Color(0, 0, 0));
		lblAbonado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAbonado.setBounds(23, 66, 74, 20);
		panel_1.add(lblAbonado);
		
		txtAbonado = new JTextField();
		txtAbonado.setEditable(false);
		txtAbonado.setForeground(SystemColor.desktop);
		txtAbonado.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtAbonado.setColumns(10);
		txtAbonado.setBounds(107, 66, 104, 20);
		panel_1.add(txtAbonado);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setBounds(23, 92, 59, 24);
		panel_1.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setForeground(SystemColor.desktop);
		txtNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtNombre.setColumns(10);
		txtNombre.setBounds(107, 94, 355, 20);
		panel_1.add(txtNombre);
		
		JLabel lblSaldo = new JLabel("Saldo");
		lblSaldo.setForeground(Color.BLACK);
		lblSaldo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSaldo.setBounds(484, 161, 43, 14);
		panel_1.add(lblSaldo);
		
		txtSaldo = new JTextField();
		txtSaldo.setEditable(false);
		txtSaldo.setForeground(SystemColor.desktop);
		txtSaldo.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtSaldo.setColumns(10);
		txtSaldo.setBounds(558, 158, 67, 20);
		panel_1.add(txtSaldo);
		
		JLabel lblPoste = new JLabel("Poste");
		lblPoste.setForeground(Color.BLACK);
		lblPoste.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPoste.setBounds(484, 125, 43, 14);
		panel_1.add(lblPoste);
		
		txtPoste = new JTextField();
		txtPoste.setEditable(false);
		txtPoste.setForeground(SystemColor.desktop);
		txtPoste.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtPoste.setColumns(10);
		txtPoste.setBounds(558, 122, 67, 20);
		panel_1.add(txtPoste);
		
		JLabel lblReferencia = new JLabel("Referencia");
		lblReferencia.setForeground(Color.BLACK);
		lblReferencia.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblReferencia.setBounds(23, 127, 74, 19);
		panel_1.add(lblReferencia);
		
		txtReferencia = new JTextField();
		txtReferencia.setEditable(false);
		txtReferencia.setForeground(SystemColor.desktop);
		txtReferencia.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtReferencia.setColumns(10);
		txtReferencia.setBounds(107, 123, 355, 20);
		panel_1.add(txtReferencia);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setForeground(Color.BLACK);
		lblDomicilio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDomicilio.setBounds(23, 159, 74, 19);
		panel_1.add(lblDomicilio);
		
		txtDomicilio = new JTextField();
		txtDomicilio.setEditable(false);
		txtDomicilio.setForeground(SystemColor.desktop);
		txtDomicilio.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtDomicilio.setColumns(10);
		txtDomicilio.setBounds(107, 157, 355, 20);
		panel_1.add(txtDomicilio);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setForeground(Color.BLACK);
		lblCalle.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCalle.setBounds(484, 67, 59, 19);
		panel_1.add(lblCalle);
		
		txtCalle = new JTextField();
		txtCalle.setEditable(false);
		txtCalle.setForeground(SystemColor.desktop);
		txtCalle.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCalle.setColumns(10);
		txtCalle.setBounds(558, 66, 295, 20);
		panel_1.add(txtCalle);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setForeground(Color.BLACK);
		lblCiudad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCiudad.setBounds(484, 38, 74, 19);
		panel_1.add(lblCiudad);
		
		txtCiduad = new JTextField();
		txtCiduad.setEditable(false);
		txtCiduad.setForeground(SystemColor.desktop);
		txtCiduad.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCiduad.setColumns(10);
		txtCiduad.setBounds(558, 37, 295, 20);
		panel_1.add(txtCiduad);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(Color.BLACK);
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefono.setBounds(484, 93, 67, 14);
		panel_1.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setForeground(SystemColor.desktop);
		txtTelefono.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(558, 92, 116, 20);
		panel_1.add(txtTelefono);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Troubleshooting", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		panel_2.setBounds(23, 191, 857, 179);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblActividad = new JLabel("Actividad");
		lblActividad.setForeground(Color.BLACK);
		lblActividad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblActividad.setBounds(10, 27, 74, 19);
		panel_2.add(lblActividad);
		
	    cmbActividad = new JComboBox();
		cmbActividad.setBounds(94, 27, 295, 20);
		cmbActividad.addActionListener(ctlTrou);
		panel_2.add(cmbActividad);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setForeground(Color.BLACK);
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDescripcion.setBounds(10, 57, 74, 19);
		panel_2.add(lblDescripcion);
		
		txtDetalle = new JTextField();
		txtDetalle.setBounds(94, 58, 486, 20);
		panel_2.add(txtDetalle);
		txtDetalle.setColumns(10);
		
		JLabel lblComentario = new JLabel("Comentario");
		lblComentario.setForeground(Color.BLACK);
		lblComentario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblComentario.setBounds(10, 87, 74, 19);
		panel_2.add(lblComentario);
		
		txtComentario = new JTextArea();
		txtComentario.setRows(5);
		txtComentario.setColumns(50);
		txtComentario.setBackground(SystemColor.inactiveCaptionBorder);
		txtComentario.addKeyListener(ctlTrou);
		txtComentario.setLineWrap(true); 
		// Para que el partido se haga respetando las palabras. Sólo se parte la 
		// línea en los espacios entre palabras. 
		//txtComentario.setWrapStyleWord(true); 
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setColumnHeaderView(txtComentario);
		scrollPane_1.setBounds(94, 89, 753, 79);
		
		panel_2.add(scrollPane_1);
		
		btmSave = new JButton("Generear Incidencia");
		btmSave.setIcon(new ImageIcon("img/save.png"));
		btmSave.setHorizontalAlignment(SwingConstants.LEFT);
		btmSave.setBounds(23, 373, 188, 23);
		btmSave.addActionListener(ctlTrou);
		panel_1.add(btmSave);
		
		txtIncidencia = new JLabel("_________");
		txtIncidencia.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtIncidencia.setForeground(new Color(255, 0, 0));
		txtIncidencia.setBounds(107, 38, 104, 14);
		panel_1.add(txtIncidencia);
		
	    lblCorrelativo = new JLabel("");
		lblCorrelativo.setBounds(221, 38, 46, 14);
		lblCorrelativo.setVisible(false);
		panel_1.add(lblCorrelativo);

		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C.I");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 30, 33, 14);
		panel.add(lblNewLabel);
		
		txtCedula = new JTextField();
		txtCedula.setToolTipText("PULSAR ENTER");
		txtCedula.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtCedula.setBounds(53, 28, 86, 20);
		txtCedula.addKeyListener(ctlTrou);
		txtCedula.setColumns(10);
		panel.add(txtCedula);
		
	    lblFecha = new JLabel("");
	    lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFecha.setForeground(new Color(0, 0, 128));
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFecha.setBounds(476, 22, 388, 33);
		panel.add(lblFecha);
		
		label = new JLabel("");
		label.setBounds(281, 11, 151, 55);
		label.setIcon(new ImageIcon("img/minilogo.png"));
		panel.add(label);
		getContentPane().setLayout(groupLayout);
		this.addInternalFrameListener(ctlTrou);
		this.setSize(930,652);
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

	public JLabel getTxtIncidencia() {
		return txtIncidencia;
	}

	public void setTxtIncidencia(JLabel txtIncidencia) {
		this.txtIncidencia = txtIncidencia;
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

	public JTextField getTxtSaldo() {
		return txtSaldo;
	}

	public void setTxtSaldo(JTextField txtSaldo) {
		this.txtSaldo = txtSaldo;
	}

	public JTextField getTxtPoste() {
		return txtPoste;
	}

	public void setTxtPoste(JTextField txtPoste) {
		this.txtPoste = txtPoste;
	}

	public JTextField getTxtReferencia() {
		return txtReferencia;
	}

	public void setTxtReferencia(JTextField txtReferencia) {
		this.txtReferencia = txtReferencia;
	}

	public JTextField getTxtDomicilio() {
		return txtDomicilio;
	}

	public void setTxtDomicilio(JTextField txtDomicilio) {
		this.txtDomicilio = txtDomicilio;
	}

	public JTextField getTxtCalle() {
		return txtCalle;
	}

	public void setTxtCalle(JTextField txtCalle) {
		this.txtCalle = txtCalle;
	}

	public JTextField getTxtCiduad() {
		return txtCiduad;
	}

	public void setTxtCiduad(JTextField txtCiduad) {
		this.txtCiduad = txtCiduad;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public JTextField getTxtDetalle() {
		return txtDetalle;
	}

	public void setTxtDetalle(JTextField txtDetalle) {
		this.txtDetalle = txtDetalle;
	}

	public JTextArea getTxtComentario() {
		return txtComentario;
	}

	public void setTxtComentario(JTextArea txtComentario) {
		this.txtComentario = txtComentario;
	}

	public JLabel getLblCorrelativo() {
		return lblCorrelativo;
	}

	public void setLblCorrelativo(JLabel lblCorrelativo) {
		this.lblCorrelativo = lblCorrelativo;
	}

	public JComboBox getCmbActividad() {
		return cmbActividad;
	}

	public void setCmbActividad(JComboBox cmbActividad) {
		this.cmbActividad = cmbActividad;
	}

	public JLabel getLblFecha() {
		return lblFecha;
	}

	public void setLblFecha(JLabel lblFecha) {
		this.lblFecha = lblFecha;
	}

	public JButton getBtmSave() {
		return btmSave;
	}

	public void setBtmSave(JButton btmSave) {
		this.btmSave = btmSave;
	}
}
