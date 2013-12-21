package net.cablen.usuario.modelo;

// Generated 13-oct-2013 12:23:31 by Hibernate Tools 3.4.0.CR1

/**
 * Usuarios generated by hbm2java
 */
public class Usuarios implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Privilegios privilegios;
	private String cedula;
	private String nombre;
	private String apellido;
	private String login;
	private String telefono;
	private String clave;
	private int estatus;
	
	public Usuarios() {
	}

	public Usuarios(Privilegios privilegios, String cedula, String nombre,
			String apellido, String login, String telefono, String clave,int estatus) {
		this.privilegios = privilegios;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.login = login;
		this.telefono = telefono;
		this.clave = clave;
		this.estatus = estatus;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Privilegios getPrivilegios() {
		return this.privilegios;
	}

	public void setPrivilegios(Privilegios privilegios) {
		this.privilegios = privilegios;
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

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}
	
	

}
