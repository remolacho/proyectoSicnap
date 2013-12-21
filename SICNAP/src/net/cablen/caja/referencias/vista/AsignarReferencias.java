package net.cablen.caja.referencias.vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.cablen.caja.referencias.controlador.Controller_referencias;

public class AsignarReferencias extends JInternalFrame {
	
	private JTextField txtRef,txtDetalle;    
	private JLabel lblConciliacion,lblMonto,lblBanco,lblFecha,lblTotal ;
	private JComboBox cmbTipo;
	private JButton btmAgregar,btmConciliar,btmReset;
	private JTable table;
	private Controller_referencias ctlRef;
	private JLabel lblTotalDet;
	private JTextField txtSerial;
	
    public AsignarReferencias(String titulo) {
		super(titulo,false, //redimencionar,
				true, //cerrar
				false,//maximizar
				false);//minimizar
		setFrameIcon(new ImageIcon("img/sistema.png"));
		
		ctlRef = new Controller_referencias(this);
		getContentPane().setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Procesar Recaudos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel.setBackground(Color.WHITE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_1.setBackground(Color.WHITE);
		table = new JTable(){
	        public boolean isCellEditable(int rowIndex, int vColIndex) {
	            return false;
	    }};
		JScrollPane scrollPane = new JScrollPane(table);
		
		btmConciliar = new JButton("Conciliar");
		btmConciliar.setEnabled(false);
		btmConciliar.setBackground(SystemColor.menu);
		btmConciliar.setIcon(new ImageIcon("img/importar.png"));
		btmConciliar.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblTotal = new JLabel("0.00");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotal.setForeground(new Color(0, 0, 128));
		
		lblTotalDet = new JLabel("Total Recaudado");
		lblTotalDet.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalDet.setForeground(new Color(0, 0, 128));
		lblTotalDet.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(btmConciliar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 331, Short.MAX_VALUE)
							.addComponent(lblTotalDet)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btmConciliar)
						.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTotalDet, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		panel_1.setLayout(null);
		
		JLabel lblDetalle = new JLabel("Detalle");
		lblDetalle.setBounds(10, 13, 61, 14);
		lblDetalle.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_1.add(lblDetalle);
		
		txtDetalle = new JTextField();
		txtDetalle.setBounds(87, 11, 300, 20);
		panel_1.add(txtDetalle);
		txtDetalle.setColumns(10);
		
	    btmAgregar = new JButton("Agregar");
	    btmAgregar.setBounds(397, 11, 113, 21);
	    btmAgregar.setEnabled(false);
	    btmAgregar.setBackground(SystemColor.menu);
		btmAgregar.setIcon(new ImageIcon("img/new.png"));
		btmAgregar.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(btmAgregar);
		
	    btmReset = new JButton("Limpiar");
	    btmReset.setBounds(522, 52, 99, 23);
	    btmReset.setBackground(SystemColor.menu);
		btmReset.setIcon(new ImageIcon("C:\\Users\\administrator\\Documents\\wsProject\\SICNAP\\img\\clear.png"));
		btmReset.setHorizontalAlignment(SwingConstants.LEFT);
		btmReset.addActionListener(ctlRef);
		panel_1.add(btmReset);
		panel.setLayout(null);
		
		JLabel lblDesConciliacion = new JLabel("Conciliacion N\u00B0");
		lblDesConciliacion.setForeground(new Color(0, 0, 128));
		lblDesConciliacion.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 14));
		lblDesConciliacion.setBounds(10, 28, 110, 14);
		panel.add(lblDesConciliacion);
		
		lblConciliacion = new JLabel("---");
		lblConciliacion.setForeground(new Color(0, 0, 128));
		lblConciliacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConciliacion.setBounds(130, 30, 93, 12);
		panel.add(lblConciliacion);
		
		JLabel lblRef = new JLabel("Referencia");
		lblRef.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRef.setBounds(10, 89, 64, 14);
		panel.add(lblRef);
		
		txtRef = new JTextField();
		txtRef.setForeground(new Color(0, 0, 128));
		txtRef.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtRef.setBounds(113, 86, 119, 20);
		panel.add(txtRef);
		txtRef.setColumns(10);
		
		JLabel lblDBanco = new JLabel("Banco");
		lblDBanco.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDBanco.setBounds(225, 117, 45, 14);
		panel.add(lblDBanco);
		
		lblBanco = new JLabel("--");
		lblBanco.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBanco.setBounds(280, 117, 147, 14);
		panel.add(lblBanco);
		
		JLabel lblDFecha = new JLabel("Fecha");
		lblDFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDFecha.setBounds(442, 117, 45, 14);
		panel.add(lblDFecha);
		
		lblFecha = new JLabel("--");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFecha.setBounds(497, 117, 101, 14);
		panel.add(lblFecha);
		
		JLabel lblDMonto = new JLabel("Monto");
		lblDMonto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDMonto.setBounds(10, 117, 45, 14);
		panel.add(lblDMonto);
		
		lblMonto = new JLabel("0.00");
		lblMonto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMonto.setBounds(114, 117, 85, 14);
		panel.add(lblMonto);
		
		JLabel label = new JLabel("Tipo Referencia");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(7, 55, 96, 14);
		panel.add(label);
		
	    cmbTipo = new JComboBox();
	    cmbTipo.setModel(new DefaultComboBoxModel(new String[] {"Lote", "Deposito", "Punto"}));
		cmbTipo.setBounds(113, 53, 92, 20);
		cmbTipo.addActionListener(ctlRef);
		panel.add(cmbTipo);
		
		txtSerial = new JTextField();
		txtSerial.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtSerial.setForeground(new Color(0, 0, 128));
		txtSerial.setEnabled(false);
		txtSerial.setBounds(215, 53, 52, 20);
		panel.add(txtSerial);
		txtSerial.setColumns(10);
		getContentPane().setLayout(groupLayout);
		
		this.btmAgregar.addActionListener(ctlRef);
		this.btmConciliar.addActionListener(ctlRef);
		this.txtRef.addKeyListener(ctlRef);
		this.addInternalFrameListener(ctlRef);
		
		this.setSize(667, 586);
		this.setVisible(true);
	}

	public JTextField getTxtRef() {
		return txtRef;
	}

	public void setTxtRef(JTextField txtRef) {
		this.txtRef = txtRef;
	}

	public JTextField getTxtDetalle() {
		return txtDetalle;
	}

	public void setTxtDetalle(JTextField txtDetalle) {
		this.txtDetalle = txtDetalle;
	}

	public JLabel getLblConciliacion() {
		return lblConciliacion;
	}

	public void setLblConciliacion(JLabel lblConciliacion) {
		this.lblConciliacion = lblConciliacion;
	}

	public JLabel getLblMonto() {
		return lblMonto;
	}

	public void setLblMonto(JLabel lblMonto) {
		this.lblMonto = lblMonto;
	}

	public JLabel getLblBanco() {
		return lblBanco;
	}

	public void setLblBanco(JLabel lblBanco) {
		this.lblBanco = lblBanco;
	}

	public JLabel getLblFecha() {
		return lblFecha;
	}

	public void setLblFecha(JLabel lblFecha) {
		this.lblFecha = lblFecha;
	}

	public JComboBox getCmbTipo() {
		return cmbTipo;
	}

	public void setCmbTipo(JComboBox cmbTipo) {
		this.cmbTipo = cmbTipo;
	}

	public JButton getBtmAgregar() {
		return btmAgregar;
	}

	public void setBtmAgregar(JButton btmAgregar) {
		this.btmAgregar = btmAgregar;
	}

	public JButton getBtmConciliar() {
		return btmConciliar;
	}

	public void setBtmConciliar(JButton btmConciliar) {
		this.btmConciliar = btmConciliar;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JLabel getLblTotal() {
		return lblTotal;
	}

	public void setLblTotal(JLabel lblTotal) {
		this.lblTotal = lblTotal;
	}

	public JButton getBtmReset() {
		return btmReset;
	}

	public void setBtmReset(JButton btmReset) {
		this.btmReset = btmReset;
	}

	public JTextField getTxtSerial() {
		return txtSerial;
	}

	public void setTxtSerial(JTextField txtSerial) {
		this.txtSerial = txtSerial;
	}
	
	

}
