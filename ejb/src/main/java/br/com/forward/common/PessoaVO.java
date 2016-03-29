/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.common;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Classe responsável por ...
 *
 * @since 9 de mar de 2016 20:31:05
 * @version x.x
 */
public class PessoaVO extends AbstractVO {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo codigoPessoa
	 */
	private int codigoPessoa;

	/**
	 * Atributo cnpjCpfPessoa
	 */
	private BigDecimal cnpjCpfPessoa;

	/**
	 * Atributo dataCadastro
	 */
	private Timestamp dataCadastro;

	/**
	 * Atributo dataNascimento
	 */
	private Date dataNascimento;

	/**
	 * Atributo nomePessoa
	 */
	private String nomePessoa;

	/**
	 * Atributo tipoPessoa
	 */
	private String tipoPessoa;

	/**
	 * @return o valor do atributo codigoPessoa
	 */
	public int getCodigoPessoa() {
		return this.codigoPessoa;
	}

	/**
	 * @param codigoPessoa o valor a ser atribuído no atributo codigoPessoa
	 */
	public void setCodigoPessoa(int codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}

	/**
	 * @return o valor do atributo cnpjCpfPessoa
	 */
	public BigDecimal getCnpjCpfPessoa() {
		return this.cnpjCpfPessoa;
	}

	/**
	 * @param cnpjCpfPessoa o valor a ser atribuído no atributo cnpjCpfPessoa
	 */
	public void setCnpjCpfPessoa(BigDecimal cnpjCpfPessoa) {
		this.cnpjCpfPessoa = cnpjCpfPessoa;
	}

	/**
	 * @return o valor do atributo dataCadastro
	 */
	public Timestamp getDataCadastro() {
		return this.dataCadastro;
	}

	/**
	 * @param dataCadastro o valor a ser atribuído no atributo dataCadastro
	 */
	public void setDataCadastro(Timestamp dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	/**
	 * @return o valor do atributo dataNascimento
	 */
	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	/**
	 * @param dataNascimento o valor a ser atribuído no atributo dataNascimento
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * @return o valor do atributo nomePessoa
	 */
	public String getNomePessoa() {
		return this.nomePessoa;
	}

	/**
	 * @param nomePessoa o valor a ser atribuído no atributo nomePessoa
	 */
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	/**
	 * @return o valor do atributo tipoPessoa
	 */
	public String getTipoPessoa() {
		return this.tipoPessoa;
	}

	/**
	 * @param tipoPessoa o valor a ser atribuído no atributo tipoPessoa
	 */
	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.cnpjCpfPessoa == null) ? 0 : this.cnpjCpfPessoa.hashCode());
		result = prime * result + this.codigoPessoa;
		result = prime * result + ((this.dataCadastro == null) ? 0 : this.dataCadastro.hashCode());
		result = prime * result + ((this.dataNascimento == null) ? 0 : this.dataNascimento.hashCode());
		result = prime * result + ((this.nomePessoa == null) ? 0 : this.nomePessoa.hashCode());
		result = prime * result + ((this.tipoPessoa == null) ? 0 : this.tipoPessoa.hashCode());
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
		if (!(obj instanceof PessoaVO)) {
			return false;
		}
		final PessoaVO other = (PessoaVO) obj;
		if (this.cnpjCpfPessoa == null) {
			if (other.cnpjCpfPessoa != null) {
				return false;
			}
		} else if (!this.cnpjCpfPessoa.equals(other.cnpjCpfPessoa)) {
			return false;
		}
		if (this.codigoPessoa != other.codigoPessoa) {
			return false;
		}
		if (this.dataCadastro == null) {
			if (other.dataCadastro != null) {
				return false;
			}
		} else if (!this.dataCadastro.equals(other.dataCadastro)) {
			return false;
		}
		if (this.dataNascimento == null) {
			if (other.dataNascimento != null) {
				return false;
			}
		} else if (!this.dataNascimento.equals(other.dataNascimento)) {
			return false;
		}
		if (this.nomePessoa == null) {
			if (other.nomePessoa != null) {
				return false;
			}
		} else if (!this.nomePessoa.equals(other.nomePessoa)) {
			return false;
		}
		if (this.tipoPessoa == null) {
			if (other.tipoPessoa != null) {
				return false;
			}
		} else if (!this.tipoPessoa.equals(other.tipoPessoa)) {
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
		return "PessoaVO [codigoPessoa=" + this.codigoPessoa + ", cnpjCpfPessoa=" + this.cnpjCpfPessoa + ", dataCadastro="
				+ this.dataCadastro + ", dataNascimento=" + this.dataNascimento + ", nomePessoa=" + this.nomePessoa
				+ ", tipoPessoa=" + this.tipoPessoa + "]";
	}

}
