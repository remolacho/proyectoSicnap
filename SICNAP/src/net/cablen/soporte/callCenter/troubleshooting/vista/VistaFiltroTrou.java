package net.cablen.soporte.callCenter.troubleshooting.vista;

import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import net.cablen.soporte.callCenter.troubleshooting.controlador.Controller_filtro_trou;
import net.cablen.soporte.callCenter.troubleshooting.modelo.Troubleshooting;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class VistaFiltroTrou extends JInternalFrame {

    private ButtonGroup grupo1,grupo2,grupo3;
	private JCheckBox chFecha;
	private JRadioButton rGlobal,rDetallado;
	private JPanel panel_2;
	private JRadioButton rInc;
	private JRadioButton rUser;
	private JRadioButton rAct;
	private JRadioButton rAbo;
	private JPanel panel_3;
	private JRadioButton rTodas;
	private JRadioButton rAbiertas;
	private JRadioButton rCerradas;
	private JButton btmBuscar;
	private JLabel lblNewLabel;
	private JLabel lblHasta;
	private JDateChooser fDesde,fHasta;
	private JTextField txtInc;
	private JTextField txtAbo;
	private JComboBox cmbUser,cmbAct;
	
	private Controller_filtro_trou ctlFiltro = null;
	
	public VistaFiltroTrou(String titulo) {
		
		super(titulo,false, //redimencionar,
				true, //cerrar
				false,//maximizar
				false);//minimizar
		setFrameIcon(new ImageIcon("img/sistema.png"));
		getContentPane().setBackground(Color.WHITE);
		
		
		this.ctlFiltro = new Controller_filtro_trou(this);
		this.setSize(581,463);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Tipo de reporte", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		panel.setBackground(Color.WHITE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Filtro Fecha", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		panel_1.setBackground(Color.WHITE);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Opciones de filtro", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		panel_2.setBackground(Color.WHITE);
		
		rInc = new JRadioButton("Por Incidencia");
		rInc.setForeground(Color.BLACK);
		rInc.setFont(new Font("Tahoma", Font.BOLD, 11));
		rInc.setBackground(Color.WHITE);
		rInc.setBounds(20, 22, 131, 23);
		rInc.addMouseListener(ctlFiltro);
		panel_2.add(rInc);
		
		rUser = new JRadioButton("Por Usuario");
		rUser.setForeground(Color.BLACK);
		rUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		rUser.setBackground(Color.WHITE);
		rUser.setBounds(20, 48, 131, 23);
		rUser.addMouseListener(ctlFiltro);
		panel_2.add(rUser);
		
		rAct = new JRadioButton("Por Actividad");
		rAct.setForeground(Color.BLACK);
		rAct.setFont(new Font("Tahoma", Font.BOLD, 11));
		rAct.setBackground(Color.WHITE);
		rAct.setBounds(20, 74, 131, 23);
		rAct.addMouseListener(ctlFiltro);
		panel_2.add(rAct);
		
		rAbo = new JRadioButton("Por Abonado");
		rAbo.setForeground(Color.BLACK);
		rAbo.setFont(new Font("Tahoma", Font.BOLD, 11));
		rAbo.setBackground(Color.WHITE);
		rAbo.setBounds(20, 101, 131, 23);
		rAbo.addMouseListener(ctlFiltro);
		panel_2.add(rAbo);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Estatus", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		panel_3.setBackground(Color.WHITE);
		
		rTodas = new JRadioButton("Todas");
		rTodas.setSelected(true);
		rTodas.setFont(new Font("Tahoma", Font.BOLD, 11));
		rTodas.setBackground(Color.WHITE);
		rTodas.setBounds(6, 23, 59, 23);
		rTodas.addMouseListener(ctlFiltro);
		panel_3.add(rTodas);
		
		rAbiertas = new JRadioButton("Abiertas");
		rAbiertas.setFont(new Font("Tahoma", Font.BOLD, 11));
		rAbiertas.setBackground(Color.WHITE);
		rAbiertas.setBounds(72, 23, 73, 23);
		rAbiertas.addMouseListener(ctlFiltro);
		panel_3.add(rAbiertas);
		
		btmBuscar = new JButton("Buscar");
		btmBuscar.setBackground(SystemColor.menu);
		btmBuscar.setHorizontalAlignment(SwingConstants.LEFT);
		btmBuscar.setIcon(new ImageIcon("img/buscar.png"));
		btmBuscar.addActionListener(ctlFiltro);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 545, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
						.addComponent(btmBuscar, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btmBuscar)
					.addContainerGap())
		);
		
		rCerradas = new JRadioButton("Cerradas");
		rCerradas.setFont(new Font("Tahoma", Font.BOLD, 11));
		rCerradas.setBackground(Color.WHITE);
		rCerradas.setBounds(147, 23, 85, 23);
		rCerradas.addMouseListener(ctlFiltro);
		panel_3.add(rCerradas);
		panel_1.setLayout(null);
		
		chFecha = new JCheckBox("Hab. Fecha Creacion");
		chFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		chFecha.setBackground(Color.WHITE);
		chFecha.setBounds(16, 20, 148, 23);
		chFecha.addMouseListener(ctlFiltro);
		panel_1.add(chFecha);
		
		lblNewLabel = new JLabel("Desde");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(20, 65, 46, 14);
		panel_1.add(lblNewLabel);
		
		lblHasta = new JLabel("Hasta");
		lblHasta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHasta.setBounds(20, 90, 46, 14);
		panel_1.add(lblHasta);
		
	    fDesde = new JDateChooser();
		fDesde.setBounds(81, 59, 103, 20);
		fDesde.setEnabled(false);
		panel_1.add(fDesde);
		
		fHasta = new JDateChooser();
		fHasta.setBounds(81, 90, 103, 20);
		fHasta.setEnabled(false);
		panel_1.add(fHasta);
		panel.setLayout(null);
		
		rGlobal = new JRadioButton("General");
		rGlobal.setSelected(true);
		rGlobal.setFont(new Font("Tahoma", Font.BOLD, 11));
		rGlobal.setBackground(Color.WHITE);
		rGlobal.setBounds(6, 23, 77, 23);
		rGlobal.addMouseListener(ctlFiltro);
		panel.add(rGlobal);
		
		rDetallado = new JRadioButton("Detallado");
		rDetallado.setFont(new Font("Tahoma", Font.BOLD, 11));
		rDetallado.setBackground(Color.WHITE);
		rDetallado.setBounds(95, 23, 85, 23);
		rDetallado.addMouseListener(ctlFiltro);
		panel.add(rDetallado);
		
		grupo1 = new ButtonGroup();
		grupo1.add(rGlobal);
		grupo1.add(rDetallado);
		
		grupo2 = new ButtonGroup();
		grupo2.add(rTodas);
		grupo2.add(rAbiertas);
		grupo2.add(rCerradas);
		
		grupo3 = new ButtonGroup();
		grupo3.add(rInc);
		grupo3.add(rAct);
		grupo3.add(rAbo);
		grupo3.add(rUser);
		
		txtInc = new JTextField();
		txtInc.setEnabled(false);
		txtInc.setBounds(158, 23, 103, 20);
		panel_2.add(txtInc);
		txtInc.setColumns(10);
		
		txtAbo = new JTextField();
		txtAbo.setEnabled(false);
		txtAbo.setColumns(10);
		txtAbo.setBounds(158, 102, 103, 20);
		panel_2.add(txtAbo);
		
	    cmbUser = new JComboBox();
	    cmbUser.setEnabled(false);
		cmbUser.setBounds(157, 49, 104, 20);
		cmbUser.addMouseListener(ctlFiltro);
		panel_2.add(cmbUser);
		
		cmbAct = new JComboBox();
		cmbAct.setEnabled(false);
		cmbAct.setBounds(157, 75, 242, 20);
		cmbAct.addMouseListener(ctlFiltro);
		panel_2.add(cmbAct);
		
		getContentPane().setLayout(groupLayout);
		this.addInternalFrameListener(ctlFiltro);
		this.setVisible(true);
		

	}

	public JCheckBox getChFecha() {
		return chFecha;
	}

	public void setChFecha(JCheckBox chFecha) {
		this.chFecha = chFecha;
	}

	public JRadioButton getrGlobal() {
		return rGlobal;
	}

	public void setrGlobal(JRadioButton rGlobal) {
		this.rGlobal = rGlobal;
	}

	public JRadioButton getrDetallado() {
		return rDetallado;
	}

	public void setrDetallado(JRadioButton rDetallado) {
		this.rDetallado = rDetallado;
	}

	public JRadioButton getrInc() {
		return rInc;
	}

	public void setrInc(JRadioButton rInc) {
		this.rInc = rInc;
	}

	public JRadioButton getrUser() {
		return rUser;
	}

	public void setrUser(JRadioButton rUser) {
		this.rUser = rUser;
	}

	public JRadioButton getrAct() {
		return rAct;
	}

	public void setrAct(JRadioButton rAct) {
		this.rAct = rAct;
	}

	public JRadioButton getrAbo() {
		return rAbo;
	}

	public void setrAbo(JRadioButton rAbo) {
		this.rAbo = rAbo;
	}

	public JRadioButton getrTodas() {
		return rTodas;
	}

	public void setrTodas(JRadioButton rTodas) {
		this.rTodas = rTodas;
	}

	public JRadioButton getrAbiertas() {
		return rAbiertas;
	}

	public void setrAbiertas(JRadioButton rAbiertas) {
		this.rAbiertas = rAbiertas;
	}

	public JRadioButton getrCerradas() {
		return rCerradas;
	}

	public void setrCerradas(JRadioButton rCerradas) {
		this.rCerradas = rCerradas;
	}

	public JButton getBtmBuscar() {
		return btmBuscar;
	}

	public void setBtmBuscar(JButton btmBuscar) {
		this.btmBuscar = btmBuscar;
	}

	public JDateChooser getfDesde() {
		return fDesde;
	}

	public void setfDesde(JDateChooser fDesde) {
		this.fDesde = fDesde;
	}

	public JDateChooser getfHasta() {
		return fHasta;
	}

	public void setfHasta(JDateChooser fHasta) {
		this.fHasta = fHasta;
	}

	public JTextField getTxtInc() {
		return txtInc;
	}

	public void setTxtInc(JTextField txtInc) {
		this.txtInc = txtInc;
	}

	public JTextField getTxtAbo() {
		return txtAbo;
	}

	public void setTxtAbo(JTextField txtAbo) {
		this.txtAbo = txtAbo;
	}

	public JComboBox getCmbUser() {
		return cmbUser;
	}

	public void setCmbUser(JComboBox cmbUser) {
		this.cmbUser = cmbUser;
	}

	public JComboBox getCmbAct() {
		return cmbAct;
	}

	public void setCmbAct(JComboBox cmbAct) {
		this.cmbAct = cmbAct;
	}
	
	
	
}
