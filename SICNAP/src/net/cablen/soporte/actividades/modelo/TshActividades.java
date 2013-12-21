package net.cablen.soporte.actividades.modelo;

// Generated 25/11/2013 10:03:33 AM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * TshActividades generated by hbm2java
 */
public class TshActividades implements java.io.Serializable {

	private int idActividad;
	private String actividad;
	private int estatus;
	private String categoria;
	private Set troubleshootings = new HashSet(0);
	private Set carteras = new HashSet(0);

	public TshActividades() {
	}

	public TshActividades(int idActividad, String actividad, int estatus) {
		this.idActividad = idActividad;
		this.actividad = actividad;
		this.estatus = estatus;
	}

	public TshActividades(int idActividad, String actividad, int estatus,
			Set troubleshootings, Set carteras) {
		this.idActividad = idActividad;
		this.actividad = actividad;
		this.estatus = estatus;
		this.troubleshootings = troubleshootings;
		this.carteras = carteras;
	}

	public int getIdActividad() {
		return this.idActividad;
	}

	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
	}

	public String getActividad() {
		return this.actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public int getEstatus() {
		return this.estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	public Set getTroubleshootings() {
		return this.troubleshootings;
	}

	public void setTroubleshootings(Set troubleshootings) {
		this.troubleshootings = troubleshootings;
	}

	public Set getCarteras() {
		return this.carteras;
	}

	public void setCarteras(Set carteras) {
		this.carteras = carteras;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	

}