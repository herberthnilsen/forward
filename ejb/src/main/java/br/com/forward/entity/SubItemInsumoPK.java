package br.com.forward.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SubItemInsumoPK implements Serializable {
	private static final long serialVersionUID = -3673490431085735991L;

	@Column(name = "idfwdinspai", insertable = false, updatable = false, unique = true, nullable = false)
	private Integer codigoInsumoPai;

	@Column(name = "subfwdinsid", insertable = false, updatable = false, unique = true, nullable = false)
	private Integer codigoSubInsumo;

	public Integer getCodigoInsumoPai() {
		return this.codigoInsumoPai;
	}

	public void setCodigoInsumoPai(Integer codigoInsumoPai) {
		this.codigoInsumoPai = codigoInsumoPai;
	}

	public Integer getCodigoSubInsumo() {
		return this.codigoSubInsumo;
	}

	public void setCodigoSubInsumo(Integer codigoSubInsumo) {
		this.codigoSubInsumo = codigoSubInsumo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoInsumoPai == null) ? 0 : codigoInsumoPai.hashCode());
		result = prime * result + ((codigoSubInsumo == null) ? 0 : codigoSubInsumo.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof SubItemInsumoPK))
			return false;
		SubItemInsumoPK other = (SubItemInsumoPK) obj;
		if (codigoInsumoPai == null) {
			if (other.codigoInsumoPai != null)
				return false;
		} else if (!codigoInsumoPai.equals(other.codigoInsumoPai))
			return false;
		if (codigoSubInsumo == null) {
			if (other.codigoSubInsumo != null)
				return false;
		} else if (!codigoSubInsumo.equals(other.codigoSubInsumo))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SubItemInsumoPK [codigoInsumoPai=" + codigoInsumoPai + ", codigoSubInsumo=" + codigoSubInsumo + "]";
	}

}
