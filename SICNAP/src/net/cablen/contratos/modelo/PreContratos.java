package net.cablen.contratos.modelo;

// Generated 04/10/2013 12:36:14 PM by Hibernate Tools 3.4.0.CR1

/**
 * PreContratos generated by hbm2java
 */
public class PreContratos implements java.io.Serializable {

	private Integer idPreContrato;
	private long contrato;

	public PreContratos() {
	}

	public PreContratos(long contrato) {
		this.contrato = contrato;
	}

	public Integer getIdPreContrato() {
		return this.idPreContrato;
	}

	public void setIdPreContrato(Integer idPreContrato) {
		this.idPreContrato = idPreContrato;
	}

	public long getContrato() {
		return this.contrato;
	}

	public void setContrato(long contrato) {
		this.contrato = contrato;
	}

}