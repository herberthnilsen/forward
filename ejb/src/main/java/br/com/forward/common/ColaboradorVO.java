/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.common;

import java.util.Date;

/**
 * Classe responsável por ...
 *
 * @since 14 de mar de 2016 21:57:27
 * @version x.x
 */
public class ColaboradorVO extends PessoaVO {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo codigoColaborador
	 */
	private Integer codigoColaborador;

	/**
	 * Atributo dataCadastro
	 */
	private Date dataCadastro;

	/**
	 * Atributo nomeUsuario
	 */
	private String nomeUsuario;

	/**
	 * Atributo senhaUsuario
	 */
	private String senhaUsuario;

	/**
	 * @return o valor do atributo codigoColaborador
	 */
	public Integer getCodigoColaborador() {
		return this.codigoColaborador;
	}

	/**
	 * @param codigoColaborador o valor a ser atribuído no atributo codigoColaborador
	 */
	public void setCodigoColaborador(Integer codigoColaborador) {
		this.codigoColaborador = codigoColaborador;
	}

	/**
	 * @return o valor do atributo dataCadastro
	 */
	@Override
	public Date getDataCadastro() {
		return this.dataCadastro;
	}

	/**
	 * @param dataCadastro o valor a ser atribuído no atributo dataCadastro
	 */
	@Override
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	/**
	 * @return o valor do atributo nomeUsuario
	 */
	public String getNomeUsuario() {
		return this.nomeUsuario;
	}

	/**
	 * @param nomeUsuario o valor a ser atribuído no atributo nomeUsuario
	 */
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	/**
	 * @return o valor do atributo senhaUsuario
	 */
	public String getSenhaUsuario() {
		return this.senhaUsuario;
	}

	/**
	 * @param senhaUsuario o valor a ser atribuído no atributo senhaUsuario
	 */
	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ColaboradorVO [codigoColaborador=" + this.codigoColaborador + ", dataCadastro=" + this.dataCadastro
				+ ", nomeUsuario=" + this.nomeUsuario + ", senhaUsuario=" + this.senhaUsuario + ", getCodigoPessoa()="
				+ this.getCodigoPessoa() + ", getCnpjCpfPessoa()=" + this.getCnpjCpfPessoa() + ", getDataNascimento()="
				+ this.getDataNascimento() + ", getNomePessoa()=" + this.getNomePessoa() + ", getTipoPessoa()="
				+ this.getTipoPessoa() + ", hashCode()=" + this.hashCode() + ", toString()=" + super.toString() + ", getId()="
				+ this.getId() + ", getClass()=" + this.getClass() + "]";
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((this.codigoColaborador == null) ? 0 : this.codigoColaborador.hashCode());
		result = prime * result + ((this.dataCadastro == null) ? 0 : this.dataCadastro.hashCode());
		result = prime * result + ((this.nomeUsuario == null) ? 0 : this.nomeUsuario.hashCode());
		result = prime * result + ((this.senhaUsuario == null) ? 0 : this.senhaUsuario.hashCode());
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
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof ColaboradorVO)) {
			return false;
		}
		final ColaboradorVO other = (ColaboradorVO) obj;
		if (this.codigoColaborador == null) {
			if (other.codigoColaborador != null) {
				return false;
			}
		} else if (!this.codigoColaborador.equals(other.codigoColaborador)) {
			return false;
		}
		if (this.dataCadastro == null) {
			if (other.dataCadastro != null) {
				return false;
			}
		} else if (!this.dataCadastro.equals(other.dataCadastro)) {
			return false;
		}
		if (this.nomeUsuario == null) {
			if (other.nomeUsuario != null) {
				return false;
			}
		} else if (!this.nomeUsuario.equals(other.nomeUsuario)) {
			return false;
		}
		if (this.senhaUsuario == null) {
			if (other.senhaUsuario != null) {
				return false;
			}
		} else if (!this.senhaUsuario.equals(other.senhaUsuario)) {
			return false;
		}
		return true;
	}

}
