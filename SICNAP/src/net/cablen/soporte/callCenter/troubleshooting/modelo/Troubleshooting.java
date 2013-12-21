package net.cablen.soporte.callCenter.troubleshooting.modelo;

// Generated 25/11/2013 10:03:33 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import net.cablen.soporte.actividades.modelo.TshActividades;
import net.cablen.soporte.estatus.modelo.TshEstatus;

/**
 * Troubleshooting generated by hbm2java
 */
public class Troubleshooting implements java.io.Serializable {

	private long idCorrelativo;
	private TshActividades tshActividades;
	private TshEstatus tshEstatus;
	private String incidencia;
	private String userSistema;
	private String fechaApertura;
	private String detalleReclamo;
	private String comentarioInicial;
	private String comentarioFinal;
	private String fechaCierre;
	private String abonado;
	private int estatus;
		
	public Troubleshooting() {
	}

	public Troubleshooting(long idCorrelativo, TshActividades tshActividades,
			TshEstatus tshEstatus, String incidencia, String userSistema,
			String fechaApertura, String detalleReclamo,
			String comentarioInicial, String abonado) {
		this.idCorrelativo = idCorrelativo;
		this.tshActividades = tshActividades;
		this.tshEstatus = tshEstatus;
		this.incidencia = incidencia;
		this.userSistema = userSistema;
		this.fechaApertura = fechaApertura;
		this.detalleReclamo = detalleReclamo;
		this.comentarioInicial = comentarioInicial;
		this.abonado = abonado;
	}

	public Troubleshooting(long idCorrelativo, TshActividades tshActividades,
			TshEstatus tshEstatus, String incidencia, String userSistema,
			String fechaApertura, String detalleReclamo,
			String comentarioInicial, String comentarioFinal, String fechaCierre,
			String abonado) {
		this.idCorrelativo = idCorrelativo;
		this.tshActividades = tshActividades;
		this.tshEstatus = tshEstatus;
		this.incidencia = incidencia;
		this.userSistema = userSistema;
		this.fechaApertura = fechaApertura;
		this.detalleReclamo = detalleReclamo;
		this.comentarioInicial = comentarioInicial;
		this.comentarioFinal = comentarioFinal;
		this.fechaCierre = fechaCierre;
		this.abonado = abonado;
	}

	public long getIdCorrelativo() {
		return this.idCorrelativo;
	}

	public void setIdCorrelativo(long idCorrelativo) {
		this.idCorrelativo = idCorrelativo;
	}

	public TshActividades getTshActividades() {
		return this.tshActividades;
	}

	public void setTshActividades(TshActividades tshActividades) {
		this.tshActividades = tshActividades;
	}

	public TshEstatus getTshEstatus() {
		return this.tshEstatus;
	}

	public void setTshEstatus(TshEstatus tshEstatus) {
		this.tshEstatus = tshEstatus;
	}

	public String getIncidencia() {
		return this.incidencia;
	}

	public void setIncidencia(String incidencia) {
		this.incidencia = incidencia;
	}

	public String getUserSistema() {
		return this.userSistema;
	}

	public void setUserSistema(String userSistema) {
		this.userSistema = userSistema;
	}

	public String getFechaApertura() {
		return this.fechaApertura;
	}

	public void setFechaApertura(String fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public String getDetalleReclamo() {
		return this.detalleReclamo;
	}

	public void setDetalleReclamo(String detalleReclamo) {
		this.detalleReclamo = detalleReclamo;
	}

	public String getComentarioInicial() {
		return this.comentarioInicial;
	}

	public void setComentarioInicial(String comentarioInicial) {
		this.comentarioInicial = comentarioInicial;
	}

	public String getComentarioFinal() {
		return this.comentarioFinal;
	}

	public void setComentarioFinal(String comentarioFinal) {
		this.comentarioFinal = comentarioFinal;
	}

	public String getFechaCierre() {
		return this.fechaCierre;
	}

	public void setFechaCierre(String fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public String getAbonado() {
		return this.abonado;
	}

	public void setAbonado(String abonado) {
		this.abonado = abonado;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}
	
	

}
