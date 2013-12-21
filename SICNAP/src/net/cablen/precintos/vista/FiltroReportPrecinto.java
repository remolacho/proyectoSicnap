package net.cablen.precintos.vista;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;

import javax.swing.ButtonGroup;
import javax.swing.UIManager;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import net.cablen.precintos.controlador.Controller_filtro;


public class FiltroReportPrecinto extends JInternalFrame {
	
	private JTextField txtPromotor;
    private JCheckBox chFecha,chProve;
    private JDateChooser txtDesde,txtHasta;
    private JButton btmProveedor, btmBuscar;
    private JComboBox cmbEstatus;
    private Controller_filtro ctlFiltro;
 
	public FiltroReportPrecinto(String titulo) {
		super(titulo,false, //redimencionar,
				true, //cerrar
				false,//maximizar
				false);//minimizar
		
		ctlFiltro = new Controller_filtro(this);
		setFrameIcon(new ImageIcon("img/sistema.png"));
		getContentPane().setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Fecha de Asignacion", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel.setBackground(Color.WHITE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_1.setBackground(Color.WHITE);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_2.setBackground(Color.WHITE);
		
		JLabel lblProveedor = new JLabel("Promotor");
		lblProveedor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProveedor.setBounds(10, 11, 91, 14);
		panel_2.add(lblProveedor);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		
		txtPromotor = new JTextField();
		txtPromotor.setEnabled(false);
		txtPromotor.setBounds(93, 9, 86, 20);
		panel_2.add(txtPromotor);
		txtPromotor.setColumns(10);
		
		btmProveedor = new JButton("Entes");
		btmProveedor.setEnabled(false);
		btmProveedor.setBackground(SystemColor.menu);
		btmProveedor.setIcon(new ImageIcon("img/promotor.png"));
		btmProveedor.setHorizontalAlignment(SwingConstants.LEFT);
		btmProveedor.setBounds(189, 8, 120, 23);
		btmProveedor.addActionListener(ctlFiltro);
		panel_2.add(btmProveedor);
		
		JLabel lblEstatus = new JLabel("Estatus");
		lblEstatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEstatus.setBounds(10, 41, 56, 14);
		panel_2.add(lblEstatus);
		
		cmbEstatus = new JComboBox();
		cmbEstatus.setModel(new DefaultComboBoxModel(new String[] {"0", "1"}));
		cmbEstatus.setBounds(93, 39, 42, 20);
		panel_2.add(cmbEstatus);
		
		btmBuscar = new JButton("Report");
		btmBuscar.setIcon(new ImageIcon("img/buscar.png"));
		btmBuscar.setHorizontalAlignment(SwingConstants.LEFT);
		btmBuscar.setBackground(SystemColor.menu);
		btmBuscar.setBounds(189, 38, 120, 23);
		btmBuscar.addActionListener(ctlFiltro);
		panel_2.add(btmBuscar);
		
		chFecha = new JCheckBox("Por Fecha");
		chFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		chFecha.setBackground(Color.WHITE);
		chFecha.setBounds(6, 7, 97, 23);
		chFecha.addActionListener(ctlFiltro);
		panel_1.add(chFecha);
		
		chProve = new JCheckBox("Por Proveedor");
		chProve.setFont(new Font("Tahoma", Font.BOLD, 11));
		chProve.setBackground(Color.WHITE);
		chProve.setBounds(105, 7, 123, 23);
		chProve.addActionListener(ctlFiltro);
		panel_1.add(chProve);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Desde");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 29, 54, 14);
		panel.add(lblNewLabel);
		
		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHasta.setBounds(190, 29, 57, 14);
		panel.add(lblHasta);
		
		txtDesde = new JDateChooser();
		txtDesde.setEnabled(false);
		txtDesde.setDateFormatString("yyyy/MM/dd");
		txtDesde.setBounds(62, 29, 103, 20);
		panel.add(txtDesde);
		
		txtHasta = new JDateChooser();
		txtHasta.setEnabled(false);
		txtHasta.setDateFormatString("yyyy/MM/dd");
		txtHasta.setBounds(257, 29, 103, 20);
		panel.add(txtHasta);
		
		getContentPane().setLayout(groupLayout);
		this.setSize(new Dimension(419, 232));
		this.setVisible(true);
	}

	public JTextField getTxtPromotor() {
		return txtPromotor;
	}

	public void setTxtPromotor(JTextField txtPromotor) {
		this.txtPromotor = txtPromotor;
	}

	public JCheckBox getChFecha() {
		return chFecha;
	}

	public void setChFecha(JCheckBox chFecha) {
		this.chFecha = chFecha;
	}

	public JCheckBox getChProve() {
		return chProve;
	}

	public void setChProve(JCheckBox chProve) {
		this.chProve = chProve;
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

	public JButton getBtmProveedor() {
		return btmProveedor;
	}

	public void setBtmProveedor(JButton btmProveedor) {
		this.btmProveedor = btmProveedor;
	}

	public JButton getBtmBuscar() {
		return btmBuscar;
	}

	public void setBtmBuscar(JButton btmBuscar) {
		this.btmBuscar = btmBuscar;
	}

	public JComboBox getCmbEstatus() {
		return cmbEstatus;
	}

	public void setCmbEstatus(JComboBox cmbEstatus) {
		this.cmbEstatus = cmbEstatus;
	}

}
