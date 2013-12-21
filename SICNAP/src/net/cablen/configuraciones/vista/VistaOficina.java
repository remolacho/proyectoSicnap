package net.cablen.configuraciones.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import javax.swing.JInternalFrame;

import net.cablen.configuraciones.controlador.Controller_oficina;

public class VistaOficina extends JInternalFrame {

	private JTextField txtID;
	private JTextField txtNombre;
	private JButton btmGuardar;
	private Controller_oficina ctlOficina;
	private JTextField txtPunto;
	/**
	 * Create the frame.
	 */
	public VistaOficina(String titulo) {
		super(titulo,false, //redimencionar,
				true, //cerrar
				false,//maximizar
				false);//minimizar
		
		setFrameIcon(new ImageIcon("img/sistema.png"));
		getContentPane().setBackground(Color.WHITE);
		
		this.setSize(402,165);
		ctlOficina = new Controller_oficina(this);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		panel.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 67, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setBounds(10, 43, 67, 14);
		panel.add(lblNombre);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtID.setEnabled(false);
		txtID.setBounds(97, 9, 86, 20);
		panel.add(txtID);
		txtID.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(97, 40, 259, 20);
		panel.add(txtNombre);
		
		btmGuardar = new JButton("Guardar");
		btmGuardar.setHorizontalAlignment(SwingConstants.LEFT);
		btmGuardar.setIcon(new ImageIcon("img/save.png"));
		btmGuardar.setBackground(SystemColor.menu);
		btmGuardar.setBounds(166, 76, 100, 20);
		btmGuardar.addActionListener(ctlOficina);
		panel.add(btmGuardar);
		
		JLabel lblPunto = new JLabel("Punto");
		lblPunto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPunto.setBounds(10, 78, 67, 14);
		panel.add(lblPunto);
		
		txtPunto = new JTextField();
		txtPunto.setColumns(10);
		txtPunto.setBounds(97, 75, 59, 20);
		panel.add(txtPunto);
		getContentPane().setLayout(groupLayout);
		this.addInternalFrameListener(ctlOficina);
		this.setVisible(true);
	}
	public JTextField getTxtID() {
		return txtID;
	}
	public void setTxtID(JTextField txtID) {
		this.txtID = txtID;
	}
	public JTextField getTxtNombre() {
		return txtNombre;
	}
	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}
	public JButton getBtmGuardar() {
		return btmGuardar;
	}
	public void setBtmGuardar(JButton btmGuardar) {
		this.btmGuardar = btmGuardar;
	}
	public JTextField getTxtPunto() {
		return txtPunto;
	}
	public void setTxtPunto(JTextField txtPunto) {
		this.txtPunto = txtPunto;
	}
	
	
	
}
