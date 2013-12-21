package net.cablen.caja.estadoDeCuentas.vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import net.cablen.caja.estadoDeCuentas.controlador.Controller_estado_bancario;

public class VistaCargarEstados extends JInternalFrame {

	private JButton btmSubir,btmExaminar;
	private JLabel lblPath;
	private Controller_estado_bancario ctlEB;
	
	public VistaCargarEstados(String titulo) {

		super(titulo,false, //redimencionar,
				true, //cerrar
				false,//maximizar
				false);//minimizar
		setFrameIcon(new ImageIcon("img/sistema.png"));
		getContentPane().setBackground(Color.WHITE);
		this.setSize(434, 126);
		
		ctlEB = new Controller_estado_bancario(this);
		
		JLabel lblRuta = new JLabel("Ruta");
		lblRuta.setForeground(SystemColor.desktop);
		lblRuta.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		lblPath = new JLabel("________________________________");
		
		btmExaminar = new JButton("Examinar");
		btmExaminar.setIcon(new ImageIcon("img/buscar.png"));
		btmExaminar.setBackground(SystemColor.menu);
		btmExaminar.setHorizontalAlignment(SwingConstants.LEFT);
		btmExaminar.setFont(new Font("Tahoma", Font.BOLD, 12));
		
	    btmSubir = new JButton("Cargar");
		btmSubir.setEnabled(false);
		btmSubir.setBackground(SystemColor.menu);
		btmSubir.setHorizontalAlignment(SwingConstants.LEFT);
		btmSubir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btmSubir.setIcon(new ImageIcon("img/upload.png"));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(36, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblRuta)
							.addGap(18)
							.addComponent(lblPath, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btmExaminar, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btmSubir, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addGap(87))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRuta)
						.addComponent(lblPath))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btmExaminar)
						.addComponent(btmSubir))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		
		btmExaminar.addActionListener(ctlEB);
		btmSubir.addActionListener(ctlEB);
		
		getContentPane().setLayout(groupLayout);
		this.setVisible(true);

	}

	public JButton getBtmSubir() {
		return btmSubir;
	}

	public void setBtmSubir(JButton btmSubir) {
		this.btmSubir = btmSubir;
	}

	public JButton getBtmExaminar() {
		return btmExaminar;
	}

	public void setBtmExaminar(JButton btmExaminar) {
		this.btmExaminar = btmExaminar;
	}

	public JLabel getLblPath() {
		return lblPath;
	}

	public void setLblPath(JLabel lblPath) {
		this.lblPath = lblPath;
	}
	
	
	
}
