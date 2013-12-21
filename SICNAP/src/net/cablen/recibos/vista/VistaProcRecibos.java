package net.cablen.recibos.vista;


import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import java.awt.SystemColor;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

import net.cablen.recibos.controlador.Controller_proc_recibo;
import com.toedter.calendar.JDateChooser;

public class VistaProcRecibos extends JInternalFrame {

	private JLabel lblRecibo,lblFecha;
	private JButton btmProcesar;
	private JTextField txtAbonado;
	private JTextField txtTitular;
	private JTextField txtTelefono;
	private JFormattedTextField txtMonto;
	private JTextField txtCajero;
	private Controller_proc_recibo ctlProc;
	private JDateChooser txtFechaR;
	
	public VistaProcRecibos(String titulo) {
		super(titulo,false, //redimencionar,
		true, //cerrar
		false,//maximizar
		false);//minimizar
		this.setFrameIcon(new ImageIcon("img/sistema.png"));
		this.getContentPane().setBackground(UIManager.getColor("List.background"));
		this.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));
		ctlProc = new Controller_proc_recibo(this);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		panel.setBackground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("img/minilogo.png"));
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFecha.setForeground(new Color(255, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Fecha Proceso");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblNewLabel_2 = new JLabel("Recibo");
		lblNewLabel_2.setForeground(new Color(0, 0, 139));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblN = new JLabel("N\u00B0");
		lblN.setForeground(new Color(255, 0, 0));
		lblN.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblRecibo = new JLabel("____");
		lblRecibo.setForeground(Color.RED);
		lblRecibo.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btmProcesar = new JButton("Guardar");
		btmProcesar.setIcon(new ImageIcon("img/save.png"));
		btmProcesar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btmProcesar.setHorizontalAlignment(SwingConstants.LEFT);
		btmProcesar.setBackground(SystemColor.menu);
		btmProcesar.addActionListener(ctlProc);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
								.addComponent(lblFecha, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblN)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblRecibo, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_2)
						.addComponent(btmProcesar, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblFecha, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblN, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRecibo, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btmProcesar)
					.addGap(34))
		);
		panel.setLayout(null);
		
		JLabel lblAbonado = new JLabel("ABONADO");
		lblAbonado.setForeground(new Color(0, 0, 139));
		lblAbonado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAbonado.setBounds(10, 38, 82, 17);
		panel.add(lblAbonado);
		
		JLabel lblTitular = new JLabel("TITULAR");
		lblTitular.setForeground(new Color(0, 0, 139));
		lblTitular.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitular.setBounds(10, 66, 82, 17);
		panel.add(lblTitular);
		
		JLabel lblTelefono = new JLabel("TELEFONO");
		lblTelefono.setForeground(new Color(0, 0, 139));
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefono.setBounds(10, 94, 82, 17);
		panel.add(lblTelefono);
		
		JLabel lblMontoCancelado = new JLabel("MONTO CANCELADO");
		lblMontoCancelado.setForeground(new Color(0, 0, 139));
		lblMontoCancelado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMontoCancelado.setBounds(10, 122, 147, 17);
		panel.add(lblMontoCancelado);
		
		JLabel lblCodigoCajero = new JLabel("CODIGO CAJERO");
		lblCodigoCajero.setForeground(new Color(0, 0, 139));
		lblCodigoCajero.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCodigoCajero.setBounds(10, 150, 128, 17);
		panel.add(lblCodigoCajero);
		
		txtAbonado = new JTextField();
		txtAbonado.setBounds(177, 38, 99, 20);
		panel.add(txtAbonado);
		txtAbonado.setColumns(10);
		
		txtTitular = new JTextField();
		txtTitular.setBounds(177, 66, 221, 20);
		panel.add(txtTitular);
		txtTitular.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(177, 94, 99, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		
		txtMonto = new JFormattedTextField();
		txtMonto.setToolTipText("PULSAR ENTER PARA VALIDAR LOS MONTOS");
		DecimalFormat decimal = new DecimalFormat("###.00"); 
		NumberFormatter formatoMonetario = new NumberFormatter(decimal); 
		formatoMonetario.setFormat(decimal); 
		formatoMonetario.setAllowsInvalid(false); 
		txtMonto.setFormatterFactory( new DefaultFormatterFactory(formatoMonetario));
		txtMonto.setBounds(177, 122, 99, 20);		
		panel.add(txtMonto);
		txtCajero = new JTextField();
		txtCajero.setBounds(177, 150, 46, 20);
		panel.add(txtCajero);
		txtCajero.setColumns(10);
		
		JLabel lblFechaRecibo = new JLabel("FECHA RECIBO");
		lblFechaRecibo.setForeground(new Color(0, 0, 139));
		lblFechaRecibo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFechaRecibo.setBounds(10, 11, 128, 17);
		panel.add(lblFechaRecibo);
		
	    txtFechaR = new JDateChooser();
		txtFechaR.setBounds(176, 7, 100, 20);
		panel.add(txtFechaR);
		getContentPane().setLayout(groupLayout);
		this.addInternalFrameListener(ctlProc);
		this.setSize(442,422);
		this.setVisible(true);
		
	}

	public JLabel getLblRecibo() {
		return lblRecibo;
	}

	public void setLblRecibo(JLabel lblRecibo) {
		this.lblRecibo = lblRecibo;
	}

	public JLabel getLblFecha() {
		return lblFecha;
	}

	public void setLblFecha(JLabel lblFecha) {
		this.lblFecha = lblFecha;
	}

	public JButton getBtmProcesar() {
		return btmProcesar;
	}

	public void setBtmProcesar(JButton btmProcesar) {
		this.btmProcesar = btmProcesar;
	}

	public JTextField getTxtAbonado() {
		return txtAbonado;
	}

	public void setTxtAbonado(JTextField txtAbonado) {
		this.txtAbonado = txtAbonado;
	}

	public JTextField getTxtTitular() {
		return txtTitular;
	}

	public void setTxtTitular(JTextField txtTitular) {
		this.txtTitular = txtTitular;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public JFormattedTextField getTxtMonto() {
		return txtMonto;
	}

	public void setTxtMonto(JFormattedTextField txtMonto) {
		this.txtMonto = txtMonto;
	}

	public JTextField getTxtCajero() {
		return txtCajero;
	}

	public void setTxtCajero(JTextField txtCajero) {
		this.txtCajero = txtCajero;
	}

	public JDateChooser getTxtFechaR() {
		return txtFechaR;
	}

	public void setTxtFechaR(JDateChooser txtFechaR) {
		this.txtFechaR = txtFechaR;
	}
	
	
	
}
