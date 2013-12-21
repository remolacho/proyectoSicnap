package net.cablen.soporte.callCenter.troubleshooting.vista;


import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.UIManager;

import net.cablen.soporte.callCenter.troubleshooting.controlador.Controller_troubleshooting_lista;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JButton;

public class VistaListTroubleshooting extends JInternalFrame {

	Controller_troubleshooting_lista ctlList = null;
	private JCheckBox chFecha;
	private JTextField txtInc;
	private JTextField txtCedula;
	private JTable table;
	private JDateChooser fDesde,fHasta;
	private JRadioButton rInc,rAct,rCedula;
	private JComboBox cmbAct;
	private ButtonGroup grupoRadio;
	private JButton btmBuscar;
	
	public VistaListTroubleshooting(String titulo) {
		
		super(titulo,false, //redimencionar,
				true, //cerrar
				false,//maximizar
				false);//minimizar
		
		this.ctlList = new Controller_troubleshooting_lista(this);
		this.setFrameIcon(new ImageIcon("img/sistema.png"));
		this.getContentPane().setBackground(UIManager.getColor("List.background"));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Filtro", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		panel.setBackground(Color.WHITE);
		table = new JTable(){
	        public boolean isCellEditable(int rowIndex, int vColIndex) {
	            return false;
	    }};
	    table.addMouseListener(ctlList);
		JScrollPane scrollPane = new JScrollPane(table);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 564, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 566, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		panel.setLayout(null);
		
	    chFecha = new JCheckBox("Por Fecha");
		chFecha.setBackground(Color.WHITE);
		chFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		chFecha.setForeground(new Color(0, 0, 128));
		chFecha.setBounds(21, 19, 97, 23);
		chFecha.addActionListener(ctlList);
		panel.add(chFecha);
		
	    fDesde = new JDateChooser();
		fDesde.setBounds(66, 49, 105, 20);
		fDesde.setEnabled(false);
		panel.add(fDesde);
		
	    fHasta = new JDateChooser();
		fHasta.setBounds(66, 78, 105, 20);
		fHasta.setEnabled(false);
		panel.add(fHasta);
		
		JLabel lblNewLabel = new JLabel("Desde");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(21, 53, 35, 14);
		panel.add(lblNewLabel);
		
		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setForeground(new Color(0, 0, 128));
		lblHasta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHasta.setBounds(21, 84, 40, 14);
		panel.add(lblHasta);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Opciones", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(194, 19, 362, 109);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
	    rInc = new JRadioButton("Por Incidencia");
		rInc.setBackground(Color.WHITE);
		rInc.setForeground(new Color(0, 0, 128));
		rInc.setFont(new Font("Tahoma", Font.BOLD, 11));
		rInc.setBounds(18, 24, 109, 23);
		rInc.addMouseListener(ctlList);
		panel_1.add(rInc);
		
        rAct = new JRadioButton("Por Actividad");
		rAct.setForeground(new Color(0, 0, 128));
		rAct.setFont(new Font("Tahoma", Font.BOLD, 11));
		rAct.setBackground(Color.WHITE);
		rAct.setBounds(18, 79, 109, 23);
		rAct.addMouseListener(ctlList);
		panel_1.add(rAct);
		
        rCedula = new JRadioButton("Por Cedula");
		rCedula.setForeground(new Color(0, 0, 128));
		rCedula.setFont(new Font("Tahoma", Font.BOLD, 11));
		rCedula.setBackground(Color.WHITE);
		rCedula.setBounds(18, 50, 109, 23);
		rCedula.addMouseListener(ctlList);
		panel_1.add(rCedula);
		
		grupoRadio = new ButtonGroup();
		grupoRadio.add(rInc);
		grupoRadio.add(rCedula);
		grupoRadio.add(rAct);
		
		txtInc = new JTextField();
		txtInc.setEnabled(false);
		txtInc.setBounds(133, 25, 97, 20);
		txtInc.addKeyListener(ctlList);
		panel_1.add(txtInc);
		txtInc.setColumns(10);
		
		txtCedula = new JTextField();
		txtCedula.setEnabled(false);
		txtCedula.setColumns(10);
		txtCedula.setBounds(133, 51, 97, 20);
		txtCedula.addKeyListener(ctlList);
		panel_1.add(txtCedula);
		
	    cmbAct = new JComboBox();
	    cmbAct.setEnabled(false);
		cmbAct.setBounds(133, 80, 219, 20);
		cmbAct.addActionListener(ctlList);
		panel_1.add(cmbAct);
		
	    btmBuscar = new JButton("Buscar");
	    btmBuscar.setBackground(SystemColor.menu);
		btmBuscar.setIcon(new ImageIcon("img/buscar.png"));
		btmBuscar.setBounds(21, 109, 150, 23);
		btmBuscar.addActionListener(ctlList);
		panel.add(btmBuscar);
		getContentPane().setLayout(groupLayout);
		this.addInternalFrameListener(ctlList);
		this.setSize(600,600);
		this.setVisible(true);
		
	}

	public JCheckBox getChFecha() {
		return chFecha;
	}

	public void setChFecha(JCheckBox chFecha) {
		this.chFecha = chFecha;
	}

	public JTextField getTxtInc() {
		return txtInc;
	}

	public void setTxtInc(JTextField txtInc) {
		this.txtInc = txtInc;
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

	public JRadioButton getrInc() {
		return rInc;
	}

	public void setrInc(JRadioButton rInc) {
		this.rInc = rInc;
	}

	public JRadioButton getrAct() {
		return rAct;
	}

	public void setrAct(JRadioButton rAct) {
		this.rAct = rAct;
	}

	public JRadioButton getrCedula() {
		return rCedula;
	}

	public void setrCedula(JRadioButton rCedula) {
		this.rCedula = rCedula;
	}

	public JComboBox getCmbAct() {
		return cmbAct;
	}

	public void setCmbAct(JComboBox cmbAct) {
		this.cmbAct = cmbAct;
	}

	public JButton getBtmBuscar() {
		return btmBuscar;
	}

	public void setBtmBuscar(JButton btmBuscar) {
		this.btmBuscar = btmBuscar;
	}
	
	
}
