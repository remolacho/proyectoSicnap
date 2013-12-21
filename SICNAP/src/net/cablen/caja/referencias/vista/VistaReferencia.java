package net.cablen.caja.referencias.vista;

import javax.swing.JInternalFrame;

import net.cablen.caja.referencias.controlador.Controller_referencia;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class VistaReferencia extends JInternalFrame {

	private Controller_referencia ctlRef;
	private JTextField txtBanco;
	private JFormattedTextField txtMonto;
	private JLabel lblRef,lblConcilia;
	private JTextField txtDetalle;
	private JButton btmAgregar;
	private JComboBox cmbUser,cmbTipo;
	private JDateChooser txtFecha;
	
	public VistaReferencia(String titulo,String referencia,String conciliacion) {
		super(titulo,false, //redimencionar,
				true, //cerrar
				false,//maximizar
				false);//minimizar
		setFrameIcon(new ImageIcon("img/sistema.png"));
		getContentPane().setBackground(Color.WHITE);
		
		this.setSize(493, 267);
		
		ctlRef = new Controller_referencia(this);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.inactiveCaptionText, SystemColor.inactiveCaption, SystemColor.window, SystemColor.windowBorder));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 454, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(44, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Referencia");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(33, 26, 81, 20);
		panel.add(lblNewLabel);
		
		lblRef = new JLabel(referencia);
		lblRef.setForeground(Color.RED);
		lblRef.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRef.setBounds(124, 26, 81, 20);
		panel.add(lblRef);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(33, 132, 57, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblBanco = new JLabel("Banco");
		lblBanco.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBanco.setBounds(31, 57, 51, 14);
		panel.add(lblBanco);
		
		txtBanco = new JTextField();
		txtBanco.setBounds(124, 55, 108, 20);
		panel.add(txtBanco);
		txtBanco.setColumns(10);
		
		JLabel lblUsercaja = new JLabel("User Caja");
		lblUsercaja.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsercaja.setBounds(33, 82, 65, 14);
		panel.add(lblUsercaja);
		
		cmbUser = new JComboBox();
		cmbUser.setBounds(124, 80, 81, 20);
		panel.add(cmbUser);
		
		JLabel lblMonto = new JLabel("Monto");
		lblMonto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMonto.setBounds(33, 107, 65, 14);
		panel.add(lblMonto);
		
		txtFecha = new JDateChooser();
		txtFecha.setDateFormatString("yyyy/MM/dd");
		txtFecha.setBounds(124, 130, 133, 20);
		panel.add(txtFecha);
		
		
		txtMonto = new JFormattedTextField();
		txtMonto.setToolTipText("PULSAR ENTER PARA VALIDAR LOS MONTOS");
		DecimalFormat decimal = new DecimalFormat("###.00"); 
		NumberFormatter formatoMonetario = new NumberFormatter(decimal); 
		formatoMonetario.setFormat(decimal); 
		formatoMonetario.setAllowsInvalid(false); 
		txtMonto.setFormatterFactory( new DefaultFormatterFactory(formatoMonetario));
		txtMonto.setBounds(124, 105, 94, 20);
		panel.add(txtMonto);
		
		JLabel lblConciliacion = new JLabel("Conciliacion");
		lblConciliacion.setForeground(Color.BLUE);
		lblConciliacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConciliacion.setBounds(272, 26, 81, 20);
		panel.add(lblConciliacion);
		
		lblConcilia = new JLabel(conciliacion);
		lblConcilia.setForeground(Color.BLUE);
		lblConcilia.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConcilia.setBounds(363, 26, 81, 20);
		panel.add(lblConcilia);
		
		JLabel lblDetalle = new JLabel("Detalle");
		lblDetalle.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDetalle.setBounds(33, 157, 57, 14);
		panel.add(lblDetalle);
		
		txtDetalle = new JTextField();
		txtDetalle.setColumns(10);
		txtDetalle.setBounds(124, 155, 320, 20);
		panel.add(txtDetalle);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipo.setBounds(33, 182, 57, 14);
		panel.add(lblTipo);
		
		cmbTipo = new JComboBox();
		cmbTipo.setModel(new DefaultComboBoxModel(new String[] {"Error Boxy", "Error RptZ", "Error Cajero", "Error Banco", "Desc.Bancario", "Punto Compartido"}));
		cmbTipo.setBounds(124, 180, 122, 20);
		panel.add(cmbTipo);
		
		btmAgregar = new JButton("Agregar");
		btmAgregar.setIcon(new ImageIcon("img/save.png"));
		btmAgregar.setHorizontalAlignment(SwingConstants.LEFT);
		btmAgregar.setBackground(SystemColor.menu);
		btmAgregar.setBounds(256, 179, 116, 23);
		btmAgregar.addActionListener(ctlRef);
		panel.add(btmAgregar);
		getContentPane().setLayout(groupLayout);
		this.addInternalFrameListener(ctlRef);
		this.setVisible(true);
		
	}

	public JTextField getTxtBanco() {
		return txtBanco;
	}

	public void setTxtBanco(JTextField txtBanco) {
		this.txtBanco = txtBanco;
	}

	public JFormattedTextField getTxtMonto() {
		return txtMonto;
	}

	public void setTxtMonto(JFormattedTextField txtMonto) {
		this.txtMonto = txtMonto;
	}

	public JLabel getLblRef() {
		return lblRef;
	}

	public void setLblRef(JLabel lblRef) {
		this.lblRef = lblRef;
	}

	public JLabel getLblConcilia() {
		return lblConcilia;
	}

	public void setLblConcilia(JLabel lblConcilia) {
		this.lblConcilia = lblConcilia;
	}

	public JTextField getTxtDetalle() {
		return txtDetalle;
	}

	public void setTxtDetalle(JTextField txtDetalle) {
		this.txtDetalle = txtDetalle;
	}

	public JButton getBtmAgregar() {
		return btmAgregar;
	}

	public void setBtmAgregar(JButton btmAgregar) {
		this.btmAgregar = btmAgregar;
	}

	public JComboBox getCmbUser() {
		return cmbUser;
	}

	public void setCmbUser(JComboBox cmbUser) {
		this.cmbUser = cmbUser;
	}

	public JComboBox getCmbTipo() {
		return cmbTipo;
	}

	public void setCmbTipo(JComboBox cmbTipo) {
		this.cmbTipo = cmbTipo;
	}

	public JDateChooser getTxtFecha() {
		return txtFecha;
	}

	public void setTxtFecha(JDateChooser txtFecha) {
		this.txtFecha = txtFecha;
	}
	
	
	
}
