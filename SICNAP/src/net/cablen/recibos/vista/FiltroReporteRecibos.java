package net.cablen.recibos.vista;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

import net.cablen.recibos.controlador.Controller_filtro_recibos;
import javax.swing.JTextField;

public class FiltroReporteRecibos extends JInternalFrame {
	
	private JRadioButton rPromotor,rRecibo,rUser,rAbonado;
	private JDateChooser txtDesde,txtHasta;
	private JButton btmReport;
	private JCheckBox chFecha;
	private ButtonGroup grupoRadio;
	private Controller_filtro_recibos ctlFiltro;
	private JTextField txtPromotor;
	private JButton btmEnte;
	private JTextField txtRInicial;
	private JTextField txtRFinal;
	private JTextField txtCajero;
	private JTextField txtAbonado;
	
	public FiltroReporteRecibos(String titulo) {
		super(titulo,false, //redimencionar,
				true, //cerrar
				false,//maximizar
				false);//minimizar
		setFrameIcon(new ImageIcon("img/sistema.png"));
		getContentPane().setBackground(Color.WHITE);
		ctlFiltro = new Controller_filtro_recibos(this);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBackground(Color.WHITE);
		
		chFecha = new JCheckBox("Por Fecha de Recibo");
		chFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		chFecha.setBackground(Color.WHITE);
		chFecha.setBounds(6, 7, 151, 23);
		chFecha.addActionListener(ctlFiltro);
		panel.add(chFecha);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Fecha de Asignacion", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel_1.setBackground(Color.WHITE);
		
		JLabel label = new JLabel("Desde");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(10, 29, 54, 14);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Hasta");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(190, 29, 57, 14);
		panel_1.add(label_1);
		
		txtDesde = new JDateChooser();
		txtDesde.setEnabled(false);
		txtDesde.setDateFormatString("yyyy/MM/dd");
		txtDesde.setBounds(62, 29, 103, 20);
		panel_1.add(txtDesde);
		
		txtHasta = new JDateChooser();
		txtHasta.setEnabled(false);
		txtHasta.setDateFormatString("yyyy/MM/dd");
		txtHasta.setBounds(257, 29, 103, 20);
		panel_1.add(txtHasta);
		
	    btmReport = new JButton("Report");
		btmReport.setIcon(new ImageIcon("img/buscar.png"));
		btmReport.setHorizontalAlignment(SwingConstants.LEFT);
		btmReport.setBackground(SystemColor.menu);
		btmReport.addActionListener(ctlFiltro);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btmReport, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 273, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
							.addGap(9))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btmReport)
					.addGap(14))
		);
		
		rPromotor = new JRadioButton("Ente");
		rPromotor.setFont(new Font("Swis721 Lt BT", Font.BOLD, 11));
		rPromotor.setBackground(Color.WHITE);
		rPromotor.setBounds(6, 33, 109, 23);
		rPromotor.addActionListener(ctlFiltro);
		panel.add(rPromotor);
		
        rRecibo = new JRadioButton("Por Recibo");
		rRecibo.setFont(new Font("Swis721 Lt BT", Font.BOLD, 11));
		rRecibo.setBackground(Color.WHITE);
		rRecibo.setBounds(6, 59, 109, 23);
		rRecibo.addActionListener(ctlFiltro);
		panel.add(rRecibo);
		
		rUser = new JRadioButton("Por User Caja");
		rUser.setFont(new Font("Swis721 Lt BT", Font.BOLD, 11));
		rUser.setBackground(Color.WHITE);
		rUser.setBounds(6, 85, 109, 23);
		rUser.addActionListener(ctlFiltro);
		panel.add(rUser);
		getContentPane().setLayout(groupLayout);
		
	    rAbonado = new JRadioButton("Por Abonado");
		rAbonado.setFont(new Font("Swis721 Lt BT", Font.BOLD, 11));
		rAbonado.setBackground(Color.WHITE);
		rAbonado.setBounds(6, 111, 109, 23);
		rAbonado.addActionListener(ctlFiltro);
		panel.add(rAbonado);
		
		grupoRadio = new ButtonGroup();
		grupoRadio.add(rPromotor);
		grupoRadio.add(rRecibo);
		grupoRadio.add(rUser);
		grupoRadio.add(rAbonado);
		
		txtPromotor = new JTextField();
		txtPromotor.setEnabled(false);
		txtPromotor.setBounds(121, 37, 86, 20);
		panel.add(txtPromotor);
		txtPromotor.setColumns(10);
		
		btmEnte = new JButton("Ente");
		btmEnte.setHorizontalAlignment(SwingConstants.LEFT);
		btmEnte.setIcon(new ImageIcon("img/promotor.png"));
		btmEnte.setEnabled(false);
		btmEnte.setBounds(217, 36, 89, 23);
		btmEnte.addActionListener(ctlFiltro);
		panel.add(btmEnte);
		
		txtRInicial = new JTextField();
		txtRInicial.setEnabled(false);
		txtRInicial.setColumns(10);
		txtRInicial.setBounds(121, 62, 86, 20);
		panel.add(txtRInicial);
		
		txtRFinal = new JTextField();
		txtRFinal.setEnabled(false);
		txtRFinal.setColumns(10);
		txtRFinal.setBounds(217, 62, 89, 20);
		panel.add(txtRFinal);
		
		txtCajero = new JTextField();
		txtCajero.setEnabled(false);
		txtCajero.setColumns(10);
		txtCajero.setBounds(121, 86, 86, 20);
		panel.add(txtCajero);
		
		txtAbonado = new JTextField();
		txtAbonado.setEnabled(false);
		txtAbonado.setColumns(10);
		txtAbonado.setBounds(121, 112, 86, 20);
		panel.add(txtAbonado);
		
		
		
		this.setSize(418,299);
		this.setVisible(true);

	}

	public JRadioButton getrPromotor() {
		return rPromotor;
	}

	public void setrPromotor(JRadioButton rPromotor) {
		this.rPromotor = rPromotor;
	}

	public JRadioButton getrRecibo() {
		return rRecibo;
	}

	public void setrRecibo(JRadioButton rRecibo) {
		this.rRecibo = rRecibo;
	}

	public JDateChooser getTxtDesde() {
		return txtDesde;
	}

	public void setTxtDesde(JDateChooser txtDesde) {
		this.txtDesde = txtDesde;
	}

	public JDateChooser getTxtHasta() {
		return txtHasta;
	}

	public void setTxtHasta(JDateChooser txtHasta) {
		this.txtHasta = txtHasta;
	}

	public JButton getBtmReport() {
		return btmReport;
	}

	public void setBtmReport(JButton btmReport) {
		this.btmReport = btmReport;
	}

	public JCheckBox getChFecha() {
		return chFecha;
	}

	public void setChFecha(JCheckBox chFecha) {
		this.chFecha = chFecha;
	}

	public JRadioButton getrUser() {
		return rUser;
	}

	public void setrUser(JRadioButton rUser) {
		this.rUser = rUser;
	}

	public JRadioButton getrAbonado() {
		return rAbonado;
	}

	public void setrAbonado(JRadioButton rAbonado) {
		this.rAbonado = rAbonado;
	}

	public JTextField getTxtPromotor() {
		return txtPromotor;
	}

	public void setTxtPromotor(JTextField txtPromotor) {
		this.txtPromotor = txtPromotor;
	}

	public JButton getBtmEnte() {
		return btmEnte;
	}

	public void setBtmEnte(JButton btmEnte) {
		this.btmEnte = btmEnte;
	}

	public JTextField getTxtRInicial() {
		return txtRInicial;
	}

	public void setTxtRInicial(JTextField txtRInicial) {
		this.txtRInicial = txtRInicial;
	}

	public JTextField getTxtRFinal() {
		return txtRFinal;
	}

	public void setTxtRFinal(JTextField txtRFinal) {
		this.txtRFinal = txtRFinal;
	}

	public JTextField getTxtCajero() {
		return txtCajero;
	}

	public void setTxtCajero(JTextField txtCajero) {
		this.txtCajero = txtCajero;
	}

	public JTextField getTxtAbonado() {
		return txtAbonado;
	}

	public void setTxtAbonado(JTextField txtAbonado) {
		this.txtAbonado = txtAbonado;
	}
	
	
	
}