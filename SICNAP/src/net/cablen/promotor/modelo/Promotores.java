package net.cablen.promotor.modelo;

// Generated 04/10/2013 12:36:14 PM by Hibernate Tools 3.4.0.CR1

/**
 * Promotores generated by hbm2java
 */
public class Promotores implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codPromotor;
	private String cedula;
	private String nombre;
	private String apellido;
	private String telefonoFijo;
	private String telefonoMovil;
	private int estatus;

	public Promotores() {
	}

	public Promotores(int codPromotor, String cedula, String nombre,
			String apellido, int estatus) {
		this.codPromotor = codPromotor;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.estatus = estatus;
	}

	public Promotores(int codPromotor, String cedula, String nombre,
			String apellido, String telefonoFijo, String telefonoMovil,
			int estatus) {
		this.codPromotor = codPromotor;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefonoFijo = telefonoFijo;
		this.telefonoMovil = telefonoMovil;
		this.estatus = estatus;
	}

	public int getCodPromotor() {
		return this.codPromotor;
	}

	public void setCodPromotor(int codPromotor) {
		this.codPromotor = codPromotor;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefonoFijo() {
		return this.telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public String getTelefonoMovil() {
		return this.telefonoMovil;
	}

	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	public int getEstatus() {
		return this.estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

}