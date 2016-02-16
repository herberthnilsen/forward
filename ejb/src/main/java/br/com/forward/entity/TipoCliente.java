/**
 * 
 */
package br.com.forward.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Herberth Nilsen
 *
 */
@Entity
@Table(name="fwdtpoclt")
public class TipoCliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7739007312520867665L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="fwdtpocltid", nullable=false)
	private Short codigoTipoCliente;
	
	@Column(name="dsctpoclt", length=45, nullable=false)
	private String descricaoTipoCliente;

	/**
	 * @return the codigoTipoCliente
	 */
	public Short getCodigoTipoCliente() {
		return codigoTipoCliente;
	}

	/**
	 * @param codigoTipoCliente the codigoTipoCliente to set
	 */
	public void setCodigoTipoCliente(Short codigoTipoCliente) {
		this.codigoTipoCliente = codigoTipoCliente;
	}

	/**
	 * @return the descricaoTipoCliente
	 */
	public String getDescricaoTipoCliente() {
		return descricaoTipoCliente;
	}

	/**
	 * @param descricaoTipoCliente the descricaoTipoCliente to set
	 */
	public void setDescricaoTipoCliente(String descricaoTipoCliente) {
		this.descricaoTipoCliente = descricaoTipoCliente;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoTipoCliente == null) ? 0 : codigoTipoCliente.hashCode());
		result = prime * result + ((descricaoTipoCliente == null) ? 0 : descricaoTipoCliente.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TipoCliente))
			return false;
		TipoCliente other = (TipoCliente) obj;
		if (codigoTipoCliente == null) {
			if (other.codigoTipoCliente != null)
				return false;
		} else if (!codigoTipoCliente.equals(other.codigoTipoCliente))
			return false;
		if (descricaoTipoCliente == null) {
			if (other.descricaoTipoCliente != null)
				return false;
		} else if (!descricaoTipoCliente.equals(other.descricaoTipoCliente))
			return false;
		return true;
	}
	
}
