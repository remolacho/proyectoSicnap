package net.cablen.caja.usuarios.modelo;

// Generated 24/10/2013 03:39:33 PM by Hibernate Tools 3.4.0.CR1

/**
 * UsuariosCaja generated by hbm2java
 */
public class UsuariosCaja implements java.io.Serializable {

	private String codigo;
	private String alias;
	private String nombre;

	public UsuariosCaja() {
	}

	public UsuariosCaja(String codigo, String alias, String nombre) {
		this.codigo = codigo;
		this.alias = alias;
		this.nombre = nombre;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
