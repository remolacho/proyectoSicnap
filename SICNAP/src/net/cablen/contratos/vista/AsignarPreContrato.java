package net.cablen.contratos.vista;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import net.cablen.contratos.controlador.Controller_asignar_pre_contrato;
import net.cablen.principal.controlador.Controller_MDI;
import net.cablen.principal.vistas.VisorMDI;

import javax.swing.ButtonGroup;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class AsignarPreContrato extends JInternalFrame {

	private JLabel lblPreContrato,lblCantidad;
	private JTextField txtContrato;
	private JTextField txtCantidad;
    private ButtonGroup grupoRadio;
    private JButton btmCargar;
    private JButton btmGenerar;
    private JTable tabla;
    private JScrollPane scrollPane;
    private Controller_asignar_pre_contrato ctlVista;
    private JPanel panel;
    private JTextField txtCedula;
    private JButton btmPromotor;
    private JRadioButton rCCS,rInt;
    private JLabel lblFieldNombre;
    private JLabel lblFieldApellido;
    
	public AsignarPreContrato(String titulo) {
		super(titulo,false, //redimencionar,
		true, //cerrar
		false,//maximizar
		false);//minimizar
		setFrameIcon(new ImageIcon("img/sistema.png"));
		getContentPane().setBackground(UIManager.getColor("List.background"));
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));
		ctlVista  = new Controller_asignar_pre_contrato(VisorMDI.getFrmMenu(),this);
		this.setSize(new Dimension(600, 600));
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
	    lblPreContrato = new JLabel("Pre-Contrato Inicia");
	    springLayout.putConstraint(SpringLayout.WEST, lblPreContrato, 21, SpringLayout.WEST, getContentPane());
		lblPreContrato.setFont(new Font("Tahoma", Font.BOLD, 12));
		getContentPane().add(lblPreContrato);
		
        txtContrato = new JTextField("0");
        springLayout.putConstraint(SpringLayout.NORTH, txtContrato, -3, SpringLayout.NORTH, lblPreContrato);
        springLayout.putConstraint(SpringLayout.WEST, txtContrato, 23, SpringLayout.EAST, lblPreContrato);
	    txtContrato.setForeground(Color.BLUE);
	    txtContrato.setFont(new Font("Tahoma", Font.BOLD, 12));
		getContentPane().add(txtContrato);
		
		lblCantidad = new JLabel("Pre-Contrato Fin");
		springLayout.putConstraint(SpringLayout.WEST, lblCantidad, 269, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtContrato, -27, SpringLayout.WEST, lblCantidad);
		springLayout.putConstraint(SpringLayout.NORTH, lblCantidad, 0, SpringLayout.NORTH, lblPreContrato);
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		getContentPane().add(lblCantidad);

		
		txtCantidad = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtCantidad, -3, SpringLayout.NORTH, lblPreContrato);
		springLayout.putConstraint(SpringLayout.WEST, txtCantidad, 23, SpringLayout.EAST, lblCantidad);
		springLayout.putConstraint(SpringLayout.EAST, txtCantidad, -109, SpringLayout.EAST, getContentPane());
		txtCantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCantidad.setForeground(Color.BLUE);
		txtCantidad.setText("0");
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		grupoRadio = new ButtonGroup();
		
		btmCargar = new JButton("Cargar");
		btmCargar.setIcon(new ImageIcon("img/upload.png"));
		btmCargar.setBackground(SystemColor.menu);
		btmCargar.setHorizontalAlignment(SwingConstants.LEFT);
		springLayout.putConstraint(SpringLayout.NORTH, btmCargar, 161, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblPreContrato, -8, SpringLayout.NORTH, btmCargar);
		springLayout.putConstraint(SpringLayout.WEST, btmCargar, 21, SpringLayout.WEST, getContentPane());
		getContentPane().add(btmCargar);
		
		btmGenerar = new JButton("Generar");
		springLayout.putConstraint(SpringLayout.EAST, btmGenerar, 108, SpringLayout.EAST, btmCargar);
		btmGenerar.setIcon(new ImageIcon("img/save.png"));
		btmGenerar.setBackground(SystemColor.menu);
		btmGenerar.setHorizontalAlignment(SwingConstants.LEFT);
		springLayout.putConstraint(SpringLayout.NORTH, btmGenerar, 0, SpringLayout.NORTH, btmCargar);
		springLayout.putConstraint(SpringLayout.WEST, btmGenerar, 6, SpringLayout.EAST, btmCargar);
		btmGenerar.setEnabled(false);
		getContentPane().add(btmGenerar);
		
		tabla = new JTable(){
	        public boolean isCellEditable(int rowIndex, int vColIndex) {
	            return false;
	     }};
		springLayout.putConstraint(SpringLayout.SOUTH, tabla, -571, SpringLayout.SOUTH, getContentPane());
		
	    springLayout.putConstraint(SpringLayout.NORTH, tabla, 0, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, tabla, 21, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, tabla, 559, SpringLayout.WEST, getContentPane());
		getContentPane().add(tabla);
		
		scrollPane = new JScrollPane(tabla);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 6, SpringLayout.SOUTH, btmCargar);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 21, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -26, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -23, SpringLayout.EAST, getContentPane());
		getContentPane().add(scrollPane);
		
		panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, lblPreContrato);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -6, SpringLayout.NORTH, lblPreContrato);
		springLayout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, scrollPane);
		panel.setBackground(UIManager.getColor("List.background"));
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel);
		
		rCCS = new JRadioButton("CCS", true);
		rCCS.setFont(new Font("Tahoma", Font.BOLD, 12));
		rCCS.setBackground(UIManager.getColor("List.background"));
		
		rInt = new JRadioButton("INT", false);
		rInt.setFont(new Font("Tahoma", Font.BOLD, 12));
		rInt.setBackground(UIManager.getColor("List.background"));
		
		JLabel label = new JLabel("Cedula");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtCedula = new JTextField();
		txtCedula.addCaretListener(ctlVista);
		txtCedula.setColumns(10);
		
		 btmPromotor = new JButton("Promotor");
		 btmPromotor.setIcon(new ImageIcon("img/promotor.png"));
		 btmPromotor.setHorizontalAlignment(SwingConstants.LEFT);
		 btmPromotor.setBackground(SystemColor.menu);
		
		JLabel label_1 = new JLabel("Nombre");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel label_3 = new JLabel("Apellido");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		lblFieldNombre = new JLabel("_");
		lblFieldNombre.setForeground(Color.GRAY);
		lblFieldNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblFieldApellido = new JLabel("_");
		lblFieldApellido.setForeground(Color.GRAY);
		lblFieldApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(rCCS, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(rInt, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
							.addGap(21)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFieldApellido, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(txtCedula, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btmPromotor))
								.addComponent(lblFieldNombre, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
							.addGap(242))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(2)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
							.addComponent(txtCedula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(btmPromotor, 0, 0, Short.MAX_VALUE)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(12)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFieldApellido)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(11)
							.addComponent(lblFieldNombre)))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(rCCS)
						.addComponent(rInt))
					.addContainerGap())
		);
		grupoRadio.add(rCCS);
		grupoRadio.add(rInt);
		panel.setLayout(gl_panel);
		btmCargar.addActionListener(ctlVista);
		btmGenerar.addActionListener(ctlVista);
		btmPromotor.addActionListener(ctlVista);
		this.setVisible(true);
	}

	public JLabel getLblPreContrato() {
		return lblPreContrato;
	}

	public void setLblPreContrato(JLabel lblPreContrato) {
		this.lblPreContrato = lblPreContrato;
	}

	public JTextField getTxtContrato() {
		return txtContrato;
	}

	public void setTxtContrato(JTextField txtContrato) {
		this.txtContrato = txtContrato;
	}

	public JLabel getLblCantidad() {
		return lblCantidad;
	}

	public void setLblCantidad(JLabel lblCantidad) {
		this.lblCantidad = lblCantidad;
	}


	public JLabel getLblFieldNombre() {
		return lblFieldNombre;
	}

	public void setLblFieldNombre(JLabel lblFieldNombre) {
		this.lblFieldNombre = lblFieldNombre;
	}

	public JLabel getLblFieldApellido() {
		return lblFieldApellido;
	}

	public void setLblFieldApellido(JLabel lblFieldApellido) {
		this.lblFieldApellido = lblFieldApellido;
	}

	public JTextField getTxtCedula() {
		return txtCedula;
	}

	public void setTxtCedula(JTextField txtCedula) {
		this.txtCedula = txtCedula;
	}

	public JTextField getTxtCantidad() {
		return txtCantidad;
	}

	public void setTxtCantidad(JTextField txtCantidad) {
		this.txtCantidad = txtCantidad;
	}

	public JRadioButton getrCCS() {
		return rCCS;
	}

	public void setrCCS(JRadioButton rCCS) {
		this.rCCS = rCCS;
	}

	public JRadioButton getrInt() {
		return rInt;
	}

	public void setrInt(JRadioButton rInt) {
		this.rInt = rInt;
	}

	public JButton getBtmPromotor() {
		return btmPromotor;
	}

	public void setBtmPromotor(JButton btmPromotor) {
		this.btmPromotor = btmPromotor;
	}

	public JButton getBtmCargar() {
		return btmCargar;
	}

	public void setBtmCargar(JButton btmCargar) {
		this.btmCargar = btmCargar;
	}

	public JButton getBtmGenerar() {
		return btmGenerar;
	}

	public void setBtmGenerar(JButton btmGenerar) {
		this.btmGenerar = btmGenerar;
	}

	public JTable getTabla() {
		return tabla;
	}

	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}
}
