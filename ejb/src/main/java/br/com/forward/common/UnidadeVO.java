package br.com.forward.common;

import java.io.Serializable;

/**
 * @author Herberth Nilsen
 *
 */
public class UnidadeVO implements Serializable {

	private static final long serialVersionUID = -999598864845217390L;

	private Integer codigoUnidade;
	private String nomeUnidade;
	private String siglaUnidade;

	/**
	 * @return
	 */
	public Integer getCodigoUnidade() {
		return codigoUnidade;
	}

	/**
	 * @param codigoUnidade
	 */
	public void setCodigoUnidade(Integer codigoUnidade) {
		this.codigoUnidade = codigoUnidade;
	}

	/**
	 * @return
	 */
	public String getSiglaUnidade() {
		return siglaUnidade;
	}

	/**
	 * @param siglaUnidade
	 */
	public void setSiglaUnidade(String siglaUnidade) {
		this.siglaUnidade = siglaUnidade;
	}

	/**
	 * @return
	 */
	public String getNomeUnidade() {
		return nomeUnidade;
	}

	/**
	 * @param nomeUnidade
	 */
	public void setNomeUnidade(String nomeUnidade) {
		this.nomeUnidade = nomeUnidade;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoUnidade == null) ? 0 : codigoUnidade.hashCode());
		result = prime * result + ((nomeUnidade == null) ? 0 : nomeUnidade.hashCode());
		result = prime * result + ((siglaUnidade == null) ? 0 : siglaUnidade.hashCode());
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
		if (!(obj instanceof UnidadeVO))
			return false;
		UnidadeVO other = (UnidadeVO) obj;
		if (codigoUnidade == null) {
			if (other.codigoUnidade != null)
				return false;
		} else if (!codigoUnidade.equals(other.codigoUnidade))
			return false;
		if (nomeUnidade == null) {
			if (other.nomeUnidade != null)
				return false;
		} else if (!nomeUnidade.equals(other.nomeUnidade))
			return false;
		if (siglaUnidade == null) {
			if (other.siglaUnidade != null)
				return false;
		} else if (!siglaUnidade.equals(other.siglaUnidade))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UnidadeVO [codigoUnidade=" + codigoUnidade + ", nomeUnidade=" + nomeUnidade + ", siglaUnidade="
				+ siglaUnidade + "]";
	}

}
