package br.com.forward.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.*;

/**
 * The primary key class for the fwditmorc database table.
 * 
 */
@Embeddable
public class ItemOrcamentoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private BigInteger codigoOrcamento;

	@Column(insertable=false, updatable=false)
	private BigInteger codigoInsumo;

	public ItemOrcamentoPK() {
	}
	public BigInteger getFwdorcid() {
		return this.codigoOrcamento;
	}
	public void setFwdorcid(BigInteger fwdorcid) {
		this.codigoOrcamento = fwdorcid;
	}
	public BigInteger getIdfwdins() {
		return this.codigoInsumo;
	}
	public void setIdfwdins(BigInteger idfwdins) {
		this.codigoInsumo = idfwdins;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoInsumo == null) ? 0 : codigoInsumo.hashCode());
		result = prime * result + ((codigoOrcamento == null) ? 0 : codigoOrcamento.hashCode());
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
		if (!(obj instanceof ItemOrcamentoPK))
			return false;
		ItemOrcamentoPK other = (ItemOrcamentoPK) obj;
		if (codigoInsumo == null) {
			if (other.codigoInsumo != null)
				return false;
		} else if (!codigoInsumo.equals(other.codigoInsumo))
			return false;
		if (codigoOrcamento == null) {
			if (other.codigoOrcamento != null)
				return false;
		} else if (!codigoOrcamento.equals(other.codigoOrcamento))
			return false;
		return true;
	}

}