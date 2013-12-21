package net.cablen.caja.referencias.modelo;

// Generated 18/10/2013 02:46:34 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import net.cablen.caja.conciliaciones.modelo.Conciliaciones;

/**
 * Referencias generated by hbm2java
 */
public class Referencias implements java.io.Serializable {

	private String referencia;
	private Conciliaciones conciliaciones;
	private String banco;
	private String userCaja;
	private float monto;
	private String fechaRegistro;
	private String fechaBancaria;
	private String userSistema;
	private String detalle;
	private int estatus;
	private String tipoDepo;

	public Referencias() {
	}

	public Referencias(String referencia, Conciliaciones conciliaciones,
			String banco, String userCaja, float monto, String fechaRegistro,
			String fechaBancaria, String userSistema, String detalle, int estatus) {
		this.referencia = referencia;
		this.conciliaciones = conciliaciones;
		this.banco = banco;
		this.userCaja = userCaja;
		this.monto = monto;
		this.fechaRegistro = fechaRegistro;
		this.fechaBancaria = fechaBancaria;
		this.userSistema = userSistema;
		this.detalle = detalle;
		this.estatus = estatus;
	}

	public String getReferencia() {
		return this.referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Conciliaciones getConciliaciones() {
		return this.conciliaciones;
	}

	public void setConciliaciones(Conciliaciones conciliaciones) {
		this.conciliaciones = conciliaciones;
	}

	public String getBanco() {
		return this.banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public float getMonto() {
		return this.monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public String getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getFechaBancaria() {
		return this.fechaBancaria;
	}

	public void setFechaBancaria(String fechaBancaria) {
		this.fechaBancaria = fechaBancaria;
	}

	public String getUserSistema() {
		return this.userSistema;
	}

	public void setUserSistema(String userSistema) {
		this.userSistema = userSistema;
	}

	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public int getEstatus() {
		return this.estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	public String getTipoDepo() {
		return tipoDepo;
	}

	public void setTipoDepo(String tipoDepo) {
		this.tipoDepo = tipoDepo;
	}

	public String getUserCaja() {
		return userCaja;
	}

	public void setUserCaja(String userCaja) {
		this.userCaja = userCaja;
	}

	
	
}
