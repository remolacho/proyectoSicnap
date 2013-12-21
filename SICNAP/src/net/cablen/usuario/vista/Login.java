package net.cablen.usuario.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

import net.cablen.usuario.controlador.Controller_login;
import java.awt.Toolkit;

public class Login extends JFrame {
	private JTextField txtLogin;
    private JPasswordField txtPass;
	private Controller_login ctlLogin;
	private JButton btmSalir,btmOk;
	
    public Login() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("img/sistema.png"));
    	getContentPane().setBackground(new Color(105, 105, 105));
    	setBackground(new Color(0, 153, 204));
	
	}
	
	public void iniciar(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(320, 200));
		getContentPane().setLayout(null);
	    ctlLogin = new Controller_login(this);
	    
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "SICNAP", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 283, 90);
		panel.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.black);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLogin.setBounds(22, 22, 46, 25);
		panel.add(lblLogin);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setForeground(Color.black);
		lblClave.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblClave.setBounds(22, 60, 66, 14);
		panel.add(lblClave);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(98, 26, 155, 20);
		panel.add(txtLogin);
		txtLogin.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(98, 59, 155, 20);
		panel.add(txtPass);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		panel_1.setBounds(10, 110, 283, 43);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
	    btmOk = new JButton("Aceptar");
		btmOk.setBounds(25, 11,120, 23);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.add(btmOk);
		
		btmSalir = new JButton("Salir");
		btmSalir.setBounds(160, 11, 89, 23);
		panel_1.add(btmSalir);
		this.addWindowListener(ctlLogin);
		btmOk.setIcon(new ImageIcon("img/entrar.png"));
		btmOk.setHorizontalAlignment(SwingConstants.LEFT);
		btmSalir.setIcon(new ImageIcon("img/salir.png"));
		btmSalir.setHorizontalAlignment(SwingConstants.LEFT);
		btmOk.addActionListener(ctlLogin);
		btmOk.setBackground(SystemColor.menu);
		btmSalir.setBackground(SystemColor.menu);
		btmSalir.addActionListener(ctlLogin);
		txtPass.addKeyListener(ctlLogin);
		txtLogin.addKeyListener(ctlLogin);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}

	public JTextField getTxtLogin() {
		return txtLogin;
	}

	public void setTxtLogin(JTextField txtLogin) {
		this.txtLogin = txtLogin;
	}

	public JPasswordField getTxtPass() {
		return txtPass;
	}

	public void setTxtPass(JPasswordField txtPass) {
		this.txtPass = txtPass;
	}

	public JButton getBtmSalir() {
		return btmSalir;
	}

	public void setBtmSalir(JButton btmSalir) {
		this.btmSalir = btmSalir;
	}

	public JButton getBtmOk() {
		return btmOk;
	}

	public void setBtmOk(JButton btmOk) {
		this.btmOk = btmOk;
	}
	
	
	
}
