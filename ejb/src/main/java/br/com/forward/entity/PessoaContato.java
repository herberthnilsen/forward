package br.com.forward.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: PessoaContato
 */
@Entity
@Table(name = "fwdpesctt")
public class PessoaContato implements EntityInterface {

	private static final long serialVersionUID = 1L;

	/**
	 * Atributo codigoContatoPessoa
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fwdpescttid", nullable = false)
	private Long codigoContatoPessoa;

	@Column(name = "codtipctt", nullable = false)
	private Integer tipoContato;

	@Column(name = "dscctt", nullable = false, length = 80)
	private String descricaoContato;

	@ManyToOne
	@JoinColumn(name = "fwdpescod")
	private Pessoa pessoa;

	/**
	 * @return o valor do atributo codigoContatoPessoa
	 */
	public Long getCodigoContatoPessoa() {
		return this.codigoContatoPessoa;
	}

	/**
	 * @param codigoContatoPessoa o valor a ser atribuído no atributo codigoContatoPessoa
	 */
	public void setCodigoContatoPessoa(Long codigoContatoPessoa) {
		this.codigoContatoPessoa = codigoContatoPessoa;
	}

	/**
	 * @return o valor do atributo tipoContato
	 */
	public Integer getTipoContato() {
		return this.tipoContato;
	}

	/**
	 * @param tipoContato o valor a ser atribuído no atributo tipoContato
	 */
	public void setTipoContato(Integer tipoContato) {
		this.tipoContato = tipoContato;
	}

	/**
	 * @return o valor do atributo descricaoContato
	 */
	public String getDescricaoContato() {
		return this.descricaoContato;
	}

	/**
	 * @param descricaoContato o valor a ser atribuído no atributo descricaoContato
	 */
	public void setDescricaoContato(String descricaoContato) {
		this.descricaoContato = descricaoContato;
	}

	/**
	 * @return o valor do atributo pessoa
	 */
	public Pessoa getPessoa() {
		return this.pessoa;
	}

	/**
	 * @param pessoa o valor a ser atribuído no atributo pessoa
	 */
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.codigoContatoPessoa == null) ? 0 : this.codigoContatoPessoa.hashCode());
		result = prime * result + ((this.descricaoContato == null) ? 0 : this.descricaoContato.hashCode());
		result = prime * result + ((this.pessoa == null) ? 0 : this.pessoa.hashCode());
		result = prime * result + ((this.tipoContato == null) ? 0 : this.tipoContato.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PessoaContato)) {
			return false;
		}
		final PessoaContato other = (PessoaContato) obj;
		if (this.codigoContatoPessoa == null) {
			if (other.codigoContatoPessoa != null) {
				return false;
			}
		} else if (!this.codigoContatoPessoa.equals(other.codigoContatoPessoa)) {
			return false;
		}
		if (this.descricaoContato == null) {
			if (other.descricaoContato != null) {
				return false;
			}
		} else if (!this.descricaoContato.equals(other.descricaoContato)) {
			return false;
		}
		if (this.pessoa == null) {
			if (other.pessoa != null) {
				return false;
			}
		} else if (!this.pessoa.equals(other.pessoa)) {
			return false;
		}
		if (this.tipoContato == null) {
			if (other.tipoContato != null) {
				return false;
			}
		} else if (!this.tipoContato.equals(other.tipoContato)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PessoaContato [codigoContatoPessoa=" + this.codigoContatoPessoa + ", tipoContato=" + this.tipoContato
				+ ", descricaoContato=" + this.descricaoContato + ", pessoa=" + this.pessoa + "]";
	}

}
