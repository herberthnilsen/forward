package br.com.forward.common;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoriaInsumoVO implements Serializable {
	private static final long serialVersionUID = 4697695075879918148L;
	private Integer codigoCategoria;
	private String nomeCategoria = new String();

	private String descricaoCategoria = new String();

	public Integer getCodigoCategoria() {
		return this.codigoCategoria;
	}

	public void setCodigoCategoria(Integer codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public String getNomeCategoria() {
		return this.nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getDescricaoCategoria() {
		return this.descricaoCategoria;
	}

	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CategoriaInsumoVO [codigoCategoria=" + codigoCategoria + ", nomeCategoria=" + nomeCategoria
				+ ", descricaoCategoria=" + descricaoCategoria + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoCategoria == null) ? 0 : codigoCategoria.hashCode());
		result = prime * result + ((descricaoCategoria == null) ? 0 : descricaoCategoria.hashCode());
		result = prime * result + ((nomeCategoria == null) ? 0 : nomeCategoria.hashCode());
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
		if (!(obj instanceof CategoriaInsumoVO))
			return false;
		CategoriaInsumoVO other = (CategoriaInsumoVO) obj;
		if (codigoCategoria == null) {
			if (other.codigoCategoria != null)
				return false;
		} else if (!codigoCategoria.equals(other.codigoCategoria))
			return false;
		if (descricaoCategoria == null) {
			if (other.descricaoCategoria != null)
				return false;
		} else if (!descricaoCategoria.equals(other.descricaoCategoria))
			return false;
		if (nomeCategoria == null) {
			if (other.nomeCategoria != null)
				return false;
		} else if (!nomeCategoria.equals(other.nomeCategoria))
			return false;
		return true;
	}
	
	
}

