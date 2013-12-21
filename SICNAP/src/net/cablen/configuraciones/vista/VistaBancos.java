package net.cablen.configuraciones.vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import net.cablen.configuraciones.controlador.Controller_banco;
import javax.swing.border.TitledBorder;

public class VistaBancos extends JInternalFrame {
	private JTextField txtID;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JButton btmGuardar;
	private Controller_banco ctlBanco;
	/**
	 * Create the frame.
	 */
	public VistaBancos(String titulo) {
		super(titulo,false, //redimencionar,
				true, //cerrar
				false,//maximizar
				false);//minimizar
		setFrameIcon(new ImageIcon("img/sistema.png"));
		getContentPane().setBackground(Color.WHITE);
		
		this.setSize(402,198);
		ctlBanco = new Controller_banco(this);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		panel.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 67, 14);
		panel.add(lblNewLabel);
		
		JLabel lblCodigo = new JLabel("4 ult. cuanta");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCodigo.setBounds(10, 46, 86, 14);
		panel.add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Banco");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setBounds(10, 82, 67, 14);
		panel.add(lblNombre);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtID.setEnabled(false);
		txtID.setBounds(97, 9, 86, 20);
		panel.add(txtID);
		txtID.setColumns(10);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(97, 44, 115, 20);
		panel.add(txtCodigo);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(97, 80, 247, 20);
		panel.add(txtNombre);
		
		btmGuardar = new JButton("Guardar");
		btmGuardar.setHorizontalAlignment(SwingConstants.LEFT);
		btmGuardar.setIcon(new ImageIcon("img/save.png"));
		btmGuardar.setBackground(SystemColor.menu);
		btmGuardar.setBounds(244, 113, 100, 23);
		btmGuardar.addActionListener(ctlBanco);
		panel.add(btmGuardar);
		getContentPane().setLayout(groupLayout);
		this.addInternalFrameListener(ctlBanco);
		this.setVisible(true);
	}
	public JTextField getTxtID() {
		return txtID;
	}
	public void setTxtID(JTextField txtID) {
		this.txtID = txtID;
	}
	public JTextField getTxtCodigo() {
		return txtCodigo;
	}
	public void setTxtCodigo(JTextField txtCodigo) {
		this.txtCodigo = txtCodigo;
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
	
	
	
}
