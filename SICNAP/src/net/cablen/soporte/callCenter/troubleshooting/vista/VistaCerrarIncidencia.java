package net.cablen.soporte.callCenter.troubleshooting.vista;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.cablen.soporte.callCenter.troubleshooting.controlador.Controller_troubleshooting_cerrar;
import net.cablen.soporte.callCenter.troubleshooting.modelo.Troubleshooting;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class VistaCerrarIncidencia extends JInternalFrame {
	private JTextField txtInc;
	Controller_troubleshooting_cerrar ctlCerrar= null;
	private JLabel lblEstatusAct,lblFecha ;
	private JLabel lblUserSistema;
	private JLabel lblUser;
	private JLabel lblFechaApertura;
	private JLabel lblFechaAper;
	private JLabel lblActividad;
	private JLabel lblAct;
	private JLabel lblDetalle1;
	private JLabel lblDetalle;
	private JLabel lblComentario;
	private JTextArea txtComentarioI,txtComentarioF;
	private JPanel panel_2;
	private JLabel lblAbonado;
	private JTextField txtAbonado;
	private JLabel label_1;
	private JPanel panel_3;
	private JLabel lblCierre;
	private JLabel lblComentarioFinal;
	private JButton bmtProc;
	private JComboBox cmbEstatus;
	
	public VistaCerrarIncidencia(String titulo, Troubleshooting trou) {
		
		super(titulo,false, //redimencionar,
				true, //cerrar
				false,//maximizar
				false);//minimizar
		
		this.ctlCerrar = new Controller_troubleshooting_cerrar(this,trou);
		this.setFrameIcon(new ImageIcon("img/sistema.png"));
		this.getContentPane().setBackground(UIManager.getColor("List.background"));
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		panel.setBackground(Color.WHITE);
		
		JLabel lblIncidencia = new JLabel("Incidencia");
		lblIncidencia.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIncidencia.setBounds(10, 30, 76, 14);
		panel.add(lblIncidencia);
		
		txtInc = new JTextField();
		txtInc.setText(trou.getIncidencia());
		txtInc.setEnabled(false);
		txtInc.setToolTipText("PULSAR ENTER");
		txtInc.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtInc.setColumns(10);
		txtInc.setBounds(96, 28, 82, 20);
		panel.add(txtInc);
		
	    lblFecha = new JLabel("");
		lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFecha.setForeground(new Color(0, 0, 128));
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFecha.setBounds(484, 30, 196, 14);
		panel.add(lblFecha);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Datos Incidencia", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		panel_1.setBackground(Color.WHITE);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Asignada a:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		panel_2.setBackground(Color.WHITE);
		
		lblAbonado = new JLabel("Abonado");
		lblAbonado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAbonado.setBounds(10, 30, 76, 14);
		panel_2.add(lblAbonado);
		
		txtAbonado = new JTextField();
		txtAbonado.setEnabled(false);
		txtAbonado.setToolTipText("PULSAR ENTER");
		txtAbonado.setText((String) null);
		txtAbonado.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtAbonado.setColumns(10);
		txtAbonado.setBounds(96, 28, 98, 20);
		panel_2.add(txtAbonado);
		
		label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setForeground(new Color(0, 0, 128));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(484, 30, 196, 14);
		panel_2.add(label_1);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Procesar Incidencia", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		panel_3.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 690, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 690, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_3.setLayout(null);
		
		lblCierre = new JLabel("Est de Cierre");
		lblCierre.setForeground(new Color(0, 0, 128));
		lblCierre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCierre.setBounds(10, 33, 86, 14);
		panel_3.add(lblCierre);
		
		lblComentarioFinal = new JLabel("Detalle Final");
		lblComentarioFinal.setForeground(new Color(0, 0, 128));
		lblComentarioFinal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblComentarioFinal.setBounds(10, 58, 86, 14);
		panel_3.add(lblComentarioFinal);
		
	    cmbEstatus = new JComboBox();
		cmbEstatus.setBounds(106, 31, 207, 20);
		panel_3.add(cmbEstatus);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(106, 58, 576, 60);
		panel_3.add(scrollPane_1);
		
	    txtComentarioF = new JTextArea();
		txtComentarioF.setRows(3);
		txtComentarioF.setColumns(50);
		txtComentarioF.setLineWrap(true); 
		scrollPane_1.setColumnHeaderView(txtComentarioF);
		
	    bmtProc = new JButton("Cerrar Incidencia");
		bmtProc.setIcon(new ImageIcon("img/save.png"));
		bmtProc.setHorizontalAlignment(SwingConstants.LEFT);
		bmtProc.setBounds(7, 129, 154, 23);
		bmtProc.addActionListener(ctlCerrar);
		panel_3.add(bmtProc);
		panel_1.setLayout(null);
		
		lblUserSistema = new JLabel("User Sistema");
		lblUserSistema.setForeground(new Color(0, 0, 128));
		lblUserSistema.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUserSistema.setBounds(10, 32, 94, 14);
		panel_1.add(lblUserSistema);
		
		lblUser = new JLabel("___________");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUser.setBounds(106, 32, 68, 14);
		panel_1.add(lblUser);
		
		lblFechaApertura = new JLabel("Fecha Apertura");
		lblFechaApertura.setForeground(new Color(0, 0, 128));
		lblFechaApertura.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFechaApertura.setBounds(184, 32, 94, 14);
		panel_1.add(lblFechaApertura);
		
		lblFechaAper = new JLabel("___________");
		lblFechaAper.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFechaAper.setBounds(288, 32, 94, 14);
		panel_1.add(lblFechaAper);
		
		lblActividad = new JLabel("Actividad");
		lblActividad.setForeground(new Color(0, 0, 128));
		lblActividad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblActividad.setBounds(392, 32, 68, 14);
		panel_1.add(lblActividad);
		
		lblAct = new JLabel("___________");
		lblAct.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAct.setBounds(459, 32, 221, 14);
		panel_1.add(lblAct);
		
		lblDetalle1 = new JLabel("Detalle");
		lblDetalle1.setForeground(new Color(0, 0, 128));
		lblDetalle1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDetalle1.setBounds(10, 70, 86, 14);
		panel_1.add(lblDetalle1);
		
		lblDetalle = new JLabel("___________");
		lblDetalle.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDetalle.setBounds(104, 70, 578, 14);
		panel_1.add(lblDetalle);
		
		lblComentario = new JLabel("Comentario");
		lblComentario.setForeground(new Color(0, 0, 128));
		lblComentario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblComentario.setBounds(10, 109, 86, 14);
		panel_1.add(lblComentario);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(106, 105, 4, 22);
		panel_1.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(102, 109, 578, 54);
		panel_1.add(scrollPane);
		
		txtComentarioI = new JTextArea();
		txtComentarioI.setColumns(50);
		txtComentarioI.setRows(3);
		txtComentarioI.setEditable(false);
		txtComentarioI.setLineWrap(true); 
		scrollPane.setColumnHeaderView(txtComentarioI);
		
	    lblEstatusAct = new JLabel("Estatus");
		lblEstatusAct.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEstatusAct.setBounds(213, 30, 143, 14);
		panel.add(lblEstatusAct);
		getContentPane().setLayout(groupLayout);
		this.addInternalFrameListener(ctlCerrar);
		this.setSize(732, 542);
		this.setVisible(true);

	}

	public JTextField getTxtInc() {
		return txtInc;
	}

	public void setTxtInc(JTextField txtInc) {
		this.txtInc = txtInc;
	}

	public JLabel getLblEstatusAct() {
		return lblEstatusAct;
	}

	public void setLblEstatusAct(JLabel lblEstatusAct) {
		this.lblEstatusAct = lblEstatusAct;
	}

	public JLabel getLblFecha() {
		return lblFecha;
	}

	public void setLblFecha(JLabel lblFecha) {
		this.lblFecha = lblFecha;
	}

	public JLabel getLblUser() {
		return lblUser;
	}

	public void setLblUser(JLabel lblUser) {
		this.lblUser = lblUser;
	}

	public JLabel getLblFechaApertura() {
		return lblFechaApertura;
	}

	public void setLblFechaApertura(JLabel lblFechaApertura) {
		this.lblFechaApertura = lblFechaApertura;
	}

	public JLabel getLblFechaAper() {
		return lblFechaAper;
	}

	public void setLblFechaAper(JLabel lblFechaAper) {
		this.lblFechaAper = lblFechaAper;
	}

	public JLabel getLblActividad() {
		return lblAct;
	}

	public void setLblActividad(JLabel lblAct) {
		this.lblAct = lblAct;
	}

	public JLabel getLblDetalle() {
		return lblDetalle;
	}

	public void setLblDetalle(JLabel lblDetalle) {
		this.lblDetalle = lblDetalle;
	}

	public JTextArea getTxtComentarioI() {
		return txtComentarioI;
	}

	public void setTxtComentarioI(JTextArea txtComentarioI) {
		this.txtComentarioI = txtComentarioI;
	}

	public JTextField getTxtAbonado() {
		return txtAbonado;
	}

	public void setTxtAbonado(JTextField txtAbonado) {
		this.txtAbonado = txtAbonado;
	}

	public JTextArea getTxtComentarioF() {
		return txtComentarioF;
	}

	public void setTxtComentarioF(JTextArea txtComentarioF) {
		this.txtComentarioF = txtComentarioF;
	}

	public JButton getBmtProc() {
		return bmtProc;
	}

	public void setBmtProc(JButton bmtProc) {
		this.bmtProc = bmtProc;
	}

	public JComboBox getCmbEstatus() {
		return cmbEstatus;
	}

	public void setCmbEstatus(JComboBox cmbEstatus) {
		this.cmbEstatus = cmbEstatus;
	}
	
	
	
	
}
