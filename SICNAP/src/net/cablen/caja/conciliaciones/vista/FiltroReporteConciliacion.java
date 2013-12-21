package net.cablen.caja.conciliaciones.vista;

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

import net.cablen.caja.conciliaciones.controlador.Controller_filtro;

public class FiltroReporteConciliacion extends JInternalFrame {
	
	private JRadioButton rMaquina,rOficina,rUser;
	private JDateChooser txtDesde,txtHasta;
	private JComboBox cmbGenerico;
	private JButton btmReport;
	private JCheckBox chFecha;
	private ButtonGroup grupoRadio;
	private Controller_filtro ctlFiltro;
	private JRadioButton rUSist;
	
	public FiltroReporteConciliacion(String titulo) {
		super(titulo,false, //redimencionar,
				true, //cerrar
				false,//maximizar
				false);//minimizar
		setFrameIcon(new ImageIcon("img/sistema.png"));
		getContentPane().setBackground(Color.WHITE);
		ctlFiltro = new Controller_filtro(this);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBackground(Color.WHITE);
		
		chFecha = new JCheckBox("Por Fecha");
		chFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		chFecha.setBackground(Color.WHITE);
		chFecha.setBounds(6, 7, 97, 23);
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
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btmReport, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addGap(264))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(panel_1, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE))
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btmReport)
					.addGap(20))
		);
		
		rMaquina = new JRadioButton("Por Maquina");
		rMaquina.setFont(new Font("Swis721 Lt BT", Font.BOLD, 11));
		rMaquina.setBackground(Color.WHITE);
		rMaquina.setBounds(6, 33, 109, 23);
		rMaquina.addActionListener(ctlFiltro);
		panel.add(rMaquina);
		
        rOficina = new JRadioButton("Por Oficina");
		rOficina.setFont(new Font("Swis721 Lt BT", Font.BOLD, 11));
		rOficina.setBackground(Color.WHITE);
		rOficina.setBounds(6, 59, 109, 23);
		rOficina.addActionListener(ctlFiltro);
		panel.add(rOficina);
		

		
	    cmbGenerico = new JComboBox();
		cmbGenerico.setBounds(128, 34, 245, 20);
		cmbGenerico.addActionListener(ctlFiltro);
		panel.add(cmbGenerico);
		
		rUser = new JRadioButton("Por User Caja");
		rUser.setFont(new Font("Swis721 Lt BT", Font.BOLD, 11));
		rUser.setBackground(Color.WHITE);
		rUser.setBounds(6, 85, 109, 23);
		rUser.addActionListener(ctlFiltro);
		panel.add(rUser);
		getContentPane().setLayout(groupLayout);
		
		rUSist = new JRadioButton("Por User Sist.");
		rUSist.setFont(new Font("Swis721 Lt BT", Font.BOLD, 11));
		rUSist.setBackground(Color.WHITE);
		rUSist.setBounds(6, 111, 109, 23);
		rUSist.addActionListener(ctlFiltro);
		panel.add(rUSist);
		
		grupoRadio = new ButtonGroup();
		grupoRadio.add(rMaquina);
		grupoRadio.add(rOficina);
		grupoRadio.add(rUser);
		grupoRadio.add(rUSist);

		
		this.setSize(435,336);
		this.setVisible(true);

	}

	public JRadioButton getrMaquina() {
		return rMaquina;
	}

	public void setrMaquina(JRadioButton rMaquina) {
		this.rMaquina = rMaquina;
	}

	public JRadioButton getrOficina() {
		return rOficina;
	}

	public void setrOficina(JRadioButton rOficina) {
		this.rOficina = rOficina;
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

	public JComboBox getCmbGenerico() {
		return cmbGenerico;
	}

	public void setCmbGenerico(JComboBox cmbGenerico) {
		this.cmbGenerico = cmbGenerico;
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

	public JRadioButton getrUSist() {
		return rUSist;
	}

	public void setrUSist(JRadioButton rUSist) {
		this.rUSist = rUSist;
	}

}