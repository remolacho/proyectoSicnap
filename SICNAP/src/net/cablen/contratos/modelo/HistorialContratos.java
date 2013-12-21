package net.cablen.contratos.modelo;

// Generated 04/10/2013 12:36:14 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import net.cablen.promotor.modelo.Promotores;

/**
 * HistorialContratos generated by hbm2java
 */
public class HistorialContratos implements java.io.Serializable {

	private Integer id;
	private Promotores promotores;
	private int cantContratos;
	private String fechaAsignado;
	private long contratoInicial;
	private long contratoFinal;
    private String loginUser;
    
	public HistorialContratos() {
	}

	public HistorialContratos(Promotores promotores, int cantContratos,
			String fechaAsignado, long contratoInicial, long contratoFinal) {
		this.promotores = promotores;
		this.cantContratos = cantContratos;
		this.fechaAsignado = fechaAsignado;
		this.contratoInicial = contratoInicial;
		this.contratoFinal = contratoFinal;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Promotores getPromotores() {
		return this.promotores;
	}

	public void setPromotores(Promotores promotores) {
		this.promotores = promotores;
	}

	public int getCantContratos() {
		return this.cantContratos;
	}

	public void setCantContratos(int cantContratos) {
		this.cantContratos = cantContratos;
	}

	public String getFechaAsignado() {
		return this.fechaAsignado;
	}

	public void setFechaAsignado(String fechaAsignado) {
		this.fechaAsignado = fechaAsignado;
	}

	public long getContratoInicial() {
		return this.contratoInicial;
	}

	public void setContratoInicial(long contratoInicial) {
		this.contratoInicial = contratoInicial;
	}

	public long getContratoFinal() {
		return this.contratoFinal;
	}

	public void setContratoFinal(long contratoFinal) {
		this.contratoFinal = contratoFinal;
	}

	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}
	
	

}