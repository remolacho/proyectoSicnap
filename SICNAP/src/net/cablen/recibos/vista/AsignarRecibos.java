package net.cablen.recibos.vista;

import java.awt.Dimension;

import javax.swing.JInternalFrame;

import net.cablen.recibos.controlador.Controller_asig_recibos;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class AsignarRecibos extends JInternalFrame {

	private JLabel lblPreContrato,lblCantidad;
	private JTextField txtReciboI;
	private JTextField txtReciboF;
    private JButton btmCargar;
    private JButton btmGenerar;
    private JTable tabla;
    private JScrollPane scrollPane;
    private Controller_asig_recibos ctlVista;
    private JPanel panel;
    private JTextField txtCedula;
    private JButton btmPromotor;
    private JLabel lblFieldNombre;
    private JLabel lblFieldApellido;
    
	public AsignarRecibos(String titulo) {
		super(titulo,false, //redimencionar,
		true, //cerrar
		false,//maximizar
		false);//minimizar
		setFrameIcon(new ImageIcon("img/sistema.png"));
		getContentPane().setBackground(UIManager.getColor("List.background"));
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));
		ctlVista  = new Controller_asig_recibos(this);
		this.setSize(new Dimension(600, 600));
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
	    lblPreContrato = new JLabel("Recibo Inicial");
	    springLayout.putConstraint(SpringLayout.WEST, lblPreContrato, 21, SpringLayout.WEST, getContentPane());
		lblPreContrato.setFont(new Font("Tahoma", Font.BOLD, 12));
		getContentPane().add(lblPreContrato);
		
        txtReciboI = new JTextField("0");
        springLayout.putConstraint(SpringLayout.NORTH, txtReciboI, -3, SpringLayout.NORTH, lblPreContrato);
        springLayout.putConstraint(SpringLayout.WEST, txtReciboI, 23, SpringLayout.EAST, lblPreContrato);
	    txtReciboI.setForeground(Color.BLUE);
	    txtReciboI.setFont(new Font("Tahoma", Font.BOLD, 12));
		getContentPane().add(txtReciboI);
		
		lblCantidad = new JLabel("Recibo Final");
		springLayout.putConstraint(SpringLayout.WEST, lblCantidad, 269, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtReciboI, -27, SpringLayout.WEST, lblCantidad);
		springLayout.putConstraint(SpringLayout.NORTH, lblCantidad, 0, SpringLayout.NORTH, lblPreContrato);
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		getContentPane().add(lblCantidad);

		
		txtReciboF = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtReciboF, -3, SpringLayout.NORTH, lblPreContrato);
		springLayout.putConstraint(SpringLayout.WEST, txtReciboF, 23, SpringLayout.EAST, lblCantidad);
		springLayout.putConstraint(SpringLayout.EAST, txtReciboF, -109, SpringLayout.EAST, getContentPane());
		txtReciboF.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtReciboF.setForeground(Color.BLUE);
		txtReciboF.setText("0");
		getContentPane().add(txtReciboF);
		txtReciboF.setColumns(10);
		
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
		springLayout.putConstraint(SpringLayout.NORTH, panel, 34, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, lblPreContrato);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -6, SpringLayout.NORTH, txtReciboI);
		springLayout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, scrollPane);
		panel.setBackground(UIManager.getColor("List.background"));
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel);
		
		JLabel label = new JLabel("Cedula");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtCedula = new JTextField();
		txtCedula.addCaretListener(ctlVista);
		txtCedula.setColumns(10);
		
		 btmPromotor = new JButton("Ente");
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
					.addGap(242))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtCedula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
					.addGap(36))
		);
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

	public JTextField getTxtReciboI() {
		return txtReciboI;
	}

	public void setTxtReciboI(JTextField txtContrato) {
		this.txtReciboI = txtContrato;
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

	public JTextField getTxtReciboF() {
		return txtReciboF;
	}

	public void setTxtReciboF(JTextField txt) {
		this.txtReciboF = txt;
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
