/**
 * 
 */
package br.com.forward.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

/**
 * @author Herberth Nilsen
 *
 */
@Embeddable
public class EventoClientePK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5035328957375021139L;

	@Column(name="fwdevtcod", nullable=false, length=12)
	private BigInteger codigoEvento;
	
	@Column(name="fwdcltcod", nullable=false, length=11)
	private Integer codigoCliente;

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoCliente == null) ? 0 : codigoCliente.hashCode());
		result = prime * result + ((codigoEvento == null) ? 0 : codigoEvento.hashCode());
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
		if (!(obj instanceof EventoClientePK))
			return false;
		EventoClientePK other = (EventoClientePK) obj;
		if (codigoCliente == null) {
			if (other.codigoCliente != null)
				return false;
		} else if (!codigoCliente.equals(other.codigoCliente))
			return false;
		if (codigoEvento == null) {
			if (other.codigoEvento != null)
				return false;
		} else if (!codigoEvento.equals(other.codigoEvento))
			return false;
		return true;
	}
	
	/**
	 * @return the codigoEvento
	 */
	public BigInteger getCodigoEvento() {
		return codigoEvento;
	}
	
	/**
	 * @param codigoEvento the codigoEvento to set
	 */
	public void setCodigoEvento(BigInteger codigoEvento) {
		this.codigoEvento = codigoEvento;
	}
	
	/**
	 * @return the codigoCliente
	 */
	public Integer getCodigoCliente() {
		return codigoCliente;
	}
	
	/**
	 * @param codigoCliente the codigoCliente to set
	 */
	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
}

