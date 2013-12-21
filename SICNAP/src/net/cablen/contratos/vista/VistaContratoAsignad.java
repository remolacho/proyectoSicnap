package net.cablen.contratos.vista;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import net.cablen.contratos.controlador.Controller_contrado_asignado;

public class VistaContratoAsignad extends JInternalFrame {
	private JTextField txtContrato;
	private JLabel lblContrato,lblAbonado,lblNombre,lblFecha,lblSector,lblError,lblMensaje;
	private Controller_contrado_asignado ctlCont;
	public VistaContratoAsignad(String titulo, String contrato) {
		super(titulo,false, //redimencionar,
				true, //cerrar
				false,//maximizar
				false);//minimizar
		
		ctlCont = new Controller_contrado_asignado(this);
		setFrameIcon(new ImageIcon("img/sistema.png"));
		getContentPane().setBackground(Color.WHITE);
		this.setSize(new Dimension(611, 307));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		panel.setBackground(Color.WHITE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		panel_1.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Contrato");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(22, 11, 65, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblAbonadodesc = new JLabel("Abonado");
		lblAbonadodesc.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAbonadodesc.setBounds(22, 36, 65, 14);
		panel_1.add(lblAbonadodesc);
		
		JLabel lblNombreApellidoDesc = new JLabel("Nombre Apellido");
		lblNombreApellidoDesc.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombreApellidoDesc.setBounds(22, 61, 107, 14);
		panel_1.add(lblNombreApellidoDesc);
		
		JLabel lblFechaDeAltaDec = new JLabel("Fecha de Alta");
		lblFechaDeAltaDec.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFechaDeAltaDec.setBounds(22, 86, 107, 14);
		panel_1.add(lblFechaDeAltaDec);
		
		JLabel lblSectorDesc = new JLabel("Sector");
		lblSectorDesc.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSectorDesc.setBounds(22, 114, 65, 14);
		panel_1.add(lblSectorDesc);
		
		JLabel lblErrorDesc = new JLabel("Error");
		lblErrorDesc.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblErrorDesc.setBounds(22, 139, 65, 14);
		panel_1.add(lblErrorDesc);
		
		JLabel lblMensajeDesc = new JLabel("Mensaje");
		lblMensajeDesc.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMensajeDesc.setBounds(22, 164, 65, 14);
		panel_1.add(lblMensajeDesc);
		
		lblContrato = new JLabel("________");
		lblContrato.setForeground(Color.GRAY);
		lblContrato.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContrato.setBounds(139, 11, 225, 14);
		panel_1.add(lblContrato);
		
		lblAbonado = new JLabel("________");
		lblAbonado.setForeground(Color.GRAY);
		lblAbonado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAbonado.setBounds(139, 36, 225, 14);
		panel_1.add(lblAbonado);
		
	    lblNombre = new JLabel("________");
		lblNombre.setForeground(Color.GRAY);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setBounds(139, 62, 424, 14);
		panel_1.add(lblNombre);
		
	    lblFecha = new JLabel("________");
		lblFecha.setForeground(Color.GRAY);
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFecha.setBounds(139, 87, 225, 14);
		panel_1.add(lblFecha);
		
	    lblSector = new JLabel("________");
		lblSector.setForeground(Color.GRAY);
		lblSector.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSector.setBounds(139, 114, 225, 14);
		panel_1.add(lblSector);
		
		lblError = new JLabel("________");
		lblError.setForeground(Color.GRAY);
		lblError.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblError.setBounds(139, 140, 225, 14);
		panel_1.add(lblError);
		
		lblMensaje = new JLabel("________");
		lblMensaje.setVerticalAlignment(SwingConstants.TOP);
		lblMensaje.setHorizontalAlignment(SwingConstants.LEFT);
		lblMensaje.setForeground(Color.GRAY);
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMensaje.setBounds(139, 164, 424, 28);
		panel_1.add(lblMensaje);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("N\u00B0 de Contrato");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(20, 11, 110, 14);
		panel.add(lblNewLabel);
		
		txtContrato = new JTextField(contrato);
		txtContrato.setBounds(129, 9, 122, 20);
		panel.add(txtContrato);
		txtContrato.setColumns(10);
		txtContrato.addKeyListener(ctlCont);
		getContentPane().setLayout(groupLayout);
		this.setVisible(true);
		
	}

	public JTextField getTxtContrato() {
		return txtContrato;
	}

	public void setTxtContrato(JTextField txtContrato) {
		this.txtContrato = txtContrato;
	}

	public JLabel getLblContrato() {
		return lblContrato;
	}

	public void setLblContrato(JLabel lblContrato) {
		this.lblContrato = lblContrato;
	}

	public JLabel getLblAbonado() {
		return lblAbonado;
	}

	public void setLblAbonado(JLabel lblAbonado) {
		this.lblAbonado = lblAbonado;
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JLabel getLblFecha() {
		return lblFecha;
	}

	public void setLblFecha(JLabel lblFecha) {
		this.lblFecha = lblFecha;
	}

	public JLabel getLblSector() {
		return lblSector;
	}

	public void setLblSector(JLabel lblSector) {
		this.lblSector = lblSector;
	}

	public JLabel getLblError() {
		return lblError;
	}

	public void setLblError(JLabel lblError) {
		this.lblError = lblError;
	}

	public JLabel getLblMensaje() {
		return lblMensaje;
	}

	public void setLblMensaje(JLabel lblMensaje) {
		this.lblMensaje = lblMensaje;
	}
	
	
	
}
