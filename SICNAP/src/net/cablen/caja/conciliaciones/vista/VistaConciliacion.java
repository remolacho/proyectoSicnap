package net.cablen.caja.conciliaciones.vista;



import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.text.DecimalFormat;

import javax.swing.SwingConstants;

import net.cablen.caja.conciliaciones.controlador.Controller_conciliacion;
import net.cablen.caja.referencias.vista.AsignarReferencias;
import javax.swing.JFormattedTextField;

public class VistaConciliacion extends JInternalFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtFactI,txtFactF,txtNumZ,txtDetalle;
    private JLabel lblConciliacion,lblUserSis,lblMonto,lblDif;
    private JDateChooser fechaCaja;
    private JComboBox cmbUserCaja,cmbFiscal,cmbOficina;
    private JButton btmConciliar;
    private JFormattedTextField txtMontoZ;
    private Controller_conciliacion control = null;
    
	public VistaConciliacion(String titulo, String conciliacion, String user,String recaudo, AsignarReferencias vRef) {
		super(titulo,false, //redimencionar,
				true, //cerrar
				false,//maximizar
				false);//minimizar
		setFrameIcon(new ImageIcon("img/sistema.png"));
		getContentPane().setForeground(new Color(192, 192, 192));
		getContentPane().setBackground(Color.WHITE);
	
		control = new Controller_conciliacion(this,vRef);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Ficha Predeterminada", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel.setBackground(Color.WHITE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ficha Seleccion", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_1.setBackground(Color.WHITE);
		
		JLabel lblFechaCaja = new JLabel("Fecha Caja");
		lblFechaCaja.setForeground(new Color(0, 0, 0));
		lblFechaCaja.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFechaCaja.setBounds(22, 25, 80, 14);
		panel_1.add(lblFechaCaja);
		
		JLabel lblDescUserCaja = new JLabel("User Caja");
		lblDescUserCaja.setForeground(new Color(0, 0, 0));
		lblDescUserCaja.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDescUserCaja.setBounds(242, 25, 59, 14);
		panel_1.add(lblDescUserCaja);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ficha Contextual", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_2.setBackground(Color.WHITE);
		
		btmConciliar = new JButton("Conciliar");
		btmConciliar.setEnabled(false);
		btmConciliar.setHorizontalAlignment(SwingConstants.LEFT);
		btmConciliar.setBackground(SystemColor.menu);
		btmConciliar.setIcon(new ImageIcon("img/save.png"));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btmConciliar, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 451, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btmConciliar)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		
		JLabel lblDescFacturaI = new JLabel("Factura Inicial");
		lblDescFacturaI.setForeground(new Color(0, 0, 0));
		lblDescFacturaI.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDescFacturaI.setBounds(21, 29, 98, 14);
		panel_2.add(lblDescFacturaI);
		
		JLabel lblFacturaF = new JLabel("Factura Final");
		lblFacturaF.setForeground(new Color(0, 0, 0));
		lblFacturaF.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFacturaF.setBounds(231, 29, 83, 14);
		panel_2.add(lblFacturaF);
		
		txtFactI = new JTextField();
		txtFactI.setBounds(112, 27, 98, 20);
		panel_2.add(txtFactI);
		txtFactI.setColumns(10);
		
		txtFactF = new JTextField();
		txtFactF.setBounds(316, 27, 94, 20);
		panel_2.add(txtFactF);
		txtFactF.setColumns(10);
		
		JLabel lblNReporteZ = new JLabel("N\u00B0 Reporte Z");
		lblNReporteZ.setForeground(new Color(0, 0, 0));
		lblNReporteZ.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNReporteZ.setBounds(21, 60, 98, 14);
		panel_2.add(lblNReporteZ);
		
		txtNumZ = new JTextField();
		txtNumZ.setColumns(10);
		txtNumZ.setBounds(112, 58, 98, 20);
		panel_2.add(txtNumZ);
		
		JLabel lblMontoZ = new JLabel("Monto Z");
		lblMontoZ.setForeground(new Color(0, 0, 0));
		lblMontoZ.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMontoZ.setBounds(231, 60, 83, 14);
		panel_2.add(lblMontoZ);
		
		JLabel lblDetalle = new JLabel("Detalle");
		lblDetalle.setForeground(new Color(0, 0, 0));
		lblDetalle.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDetalle.setBounds(21, 123, 98, 14);
		panel_2.add(lblDetalle);
		
		txtDetalle = new JTextField();
		txtDetalle.setColumns(10);
		txtDetalle.setBounds(72, 121, 377, 20);
		panel_2.add(txtDetalle);
		
		JLabel lblDiferencia = new JLabel("Diferencia");
		lblDiferencia.setForeground(new Color(0, 0, 0));
		lblDiferencia.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiferencia.setBounds(21, 90, 83, 14);
		panel_2.add(lblDiferencia);
		
		lblDif = new JLabel("");
		lblDif.setForeground(SystemColor.inactiveCaptionText);
		lblDif.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDif.setBounds(112, 90, 83, 14);
		panel_2.add(lblDif);
		
		txtMontoZ = new JFormattedTextField();
		txtMontoZ.setToolTipText("PULSAR ENTER PARA VALIDAR LOS MONTOS");
		DecimalFormat decimal = new DecimalFormat("###.00"); 
		NumberFormatter formatoMonetario = new NumberFormatter(decimal); 
		formatoMonetario.setFormat(decimal); 
		formatoMonetario.setAllowsInvalid(false); 
		txtMontoZ.setFormatterFactory( new DefaultFormatterFactory(formatoMonetario));
		txtMontoZ.setBounds(316, 58, 94, 20);
		panel_2.add(txtMontoZ);
		
		fechaCaja = new JDateChooser();
		fechaCaja.setDateFormatString("yyyy/MM/dd");
		fechaCaja.setBounds(99, 19, 133, 20);
		panel_1.add(fechaCaja);
		
		cmbUserCaja = new JComboBox();
		cmbUserCaja.setBackground(SystemColor.menu);
		cmbUserCaja.setBounds(305, 21, 134, 20);
		panel_1.add(cmbUserCaja);
		
		JLabel lblDescMa = new JLabel("Maquina Fiscal");
		lblDescMa.setForeground(new Color(0, 0, 0));
		lblDescMa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDescMa.setBounds(21, 54, 68, 14);
		panel_1.add(lblDescMa);
		
	    cmbFiscal = new JComboBox();
	    cmbFiscal.setBackground(SystemColor.menu);
		cmbFiscal.setBounds(99, 52, 136, 20);
		panel_1.add(cmbFiscal);
		
		JLabel lblOficina = new JLabel("Oficina");
		lblOficina.setForeground(Color.BLACK);
		lblOficina.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOficina.setBounds(242, 55, 50, 12);
		panel_1.add(lblOficina);
		
	    cmbOficina = new JComboBox();
	    cmbOficina.setBackground(SystemColor.menu);
		cmbOficina.setBounds(305, 52, 134, 20);
		panel_1.add(cmbOficina);
		panel.setLayout(null);
		
		JLabel lblDescConci = new JLabel("Conciliacion N\u00B0");
		lblDescConci.setForeground(new Color(0, 0, 128));
		lblDescConci.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDescConci.setBounds(22, 25, 111, 14);
		panel.add(lblDescConci);
		
		lblConciliacion = new JLabel(conciliacion);
		lblConciliacion.setForeground(new Color(128, 128, 128));
		lblConciliacion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblConciliacion.setBounds(130, 25, 60, 14);
		panel.add(lblConciliacion);
		
		JLabel lblDescUser = new JLabel("User Sist.");
		lblDescUser.setForeground(new Color(0, 0, 128));
		lblDescUser.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDescUser.setBounds(200, 25, 80, 14);
		panel.add(lblDescUser);
		
		lblUserSis = new JLabel(user);
		lblUserSis.setForeground(new Color(128, 128, 128));
		lblUserSis.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUserSis.setBounds(274, 25, 80, 14);
		panel.add(lblUserSis);
		
		JLabel lblDescMonto = new JLabel("Monto Recaudo");
		lblDescMonto.setForeground(new Color(0, 0, 128));
		lblDescMonto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDescMonto.setBounds(22, 50, 98, 14);
		panel.add(lblDescMonto);
		
		lblMonto = new JLabel(recaudo);
		lblMonto.setForeground(new Color(128, 128, 128));
		lblMonto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMonto.setBounds(130, 51, 68, 14);
		panel.add(lblMonto);
		getContentPane().setLayout(groupLayout);
		
		btmConciliar.addActionListener(control);
		txtMontoZ.addKeyListener(control);
		this.addInternalFrameListener(control);
		this.setSize(495, 446);
		this.setVisible(true);
		
	}

	public JTextField getTxtFactI() {
		return txtFactI;
	}

	public void setTxtFactI(JTextField txtFactI) {
		this.txtFactI = txtFactI;
	}

	public JTextField getTxtFactF() {
		return txtFactF;
	}

	public void setTxtFactF(JTextField txtFactF) {
		this.txtFactF = txtFactF;
	}

	public JTextField getTxtNumZ() {
		return txtNumZ;
	}

	public void setTxtNumZ(JTextField txtNumZ) {
		this.txtNumZ = txtNumZ;
	}

	public JTextField getTxtMontoZ() {
		return txtMontoZ;
	}

	public void setTxtMontoZ(JFormattedTextField txtMontoZ) {
		this.txtMontoZ = txtMontoZ;
	}

	public JTextField getTextField() {
		return txtDetalle;
	}

	public void setTextField(JTextField textField) {
		this.txtDetalle = textField;
	}

	public JLabel getLblConciliacion() {
		return lblConciliacion;
	}

	public void setLblConciliacion(JLabel lblConciliacion) {
		this.lblConciliacion = lblConciliacion;
	}

	public JLabel getLblUserSis() {
		return lblUserSis;
	}

	public void setLblUserSis(JLabel lblUserSis) {
		this.lblUserSis = lblUserSis;
	}

	public JLabel getLblMonto() {
		return lblMonto;
	}

	public void setLblMonto(JLabel lblMonto) {
		this.lblMonto = lblMonto;
	}

	public JDateChooser getFechaCaja() {
		return fechaCaja;
	}

	public void setFechaCaja(JDateChooser fechaCaja) {
		this.fechaCaja = fechaCaja;
	}

	public JComboBox getCmbUserCaja() {
		return cmbUserCaja;
	}

	public void setCmbUserCaja(JComboBox cmbUserCaja) {
		this.cmbUserCaja = cmbUserCaja;
	}

	public JComboBox getCmbFiscal() {
		return cmbFiscal;
	}

	public void setCmbFiscal(JComboBox cmbFiscal) {
		this.cmbFiscal = cmbFiscal;
	}

	public JButton getBtmConciliar() {
		return btmConciliar;
	}

	public void setBtmConciliar(JButton btmConciliar) {
		this.btmConciliar = btmConciliar;
	}

	public JLabel getLblDif() {
		return lblDif;
	}

	public void setLblDif(JLabel lblDif) {
		this.lblDif = lblDif;
	}

	public JTextField getTxtDetalle() {
		return txtDetalle;
	}

	public void setTxtDetalle(JTextField txtDetalle) {
		this.txtDetalle = txtDetalle;
	}

	public JComboBox getCmbOficina() {
		return cmbOficina;
	}

	public void setCmbOficina(JComboBox cmbOficina) {
		this.cmbOficina = cmbOficina;
	}
	
	
	
	
}
