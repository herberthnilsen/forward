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
public class ClienteVO extends PessoaVO {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private Integer codigoCliente;

	/**
	 * Atributo codigoColaborador
	 */
	private Integer codigoColaborador;

	/**
	 * Atributo dataCadastro
	 */
	private Date dataCadastro;

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

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClienteVO [codigoCliente=" + this.codigoCliente + ", codigoColaborador=" + this.codigoColaborador
				+ ", dataCadastro=" + this.dataCadastro + ", getCodigoPessoa()=" + this.getCodigoPessoa()
				+ ", getCnpjCpfPessoa()=" + this.getCnpjCpfPessoa() + ", getDataNascimento()=" + this.getDataNascimento()
				+ ", getNomePessoa()=" + this.getNomePessoa() + ", getTipoPessoa()=" + this.getTipoPessoa() + ", toString()="
				+ super.toString() + ", getContatos()=" + this.getContatos() + ", getId()=" + this.getId() + ", getClass()="
				+ this.getClass() + "]";
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((this.codigoCliente == null) ? 0 : this.codigoCliente.hashCode());
		result = prime * result + ((this.codigoColaborador == null) ? 0 : this.codigoColaborador.hashCode());
		result = prime * result + ((this.dataCadastro == null) ? 0 : this.dataCadastro.hashCode());
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
		if (!(obj instanceof ClienteVO)) {
			return false;
		}
		final ClienteVO other = (ClienteVO) obj;
		if (this.codigoCliente == null) {
			if (other.codigoCliente != null) {
				return false;
			}
		} else if (!this.codigoCliente.equals(other.codigoCliente)) {
			return false;
		}
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
		return true;
	}

	/**
	 * @return o valor do atributo codigoCliente
	 */
	public Integer getCodigoCliente() {
		return this.codigoCliente;
	}

	/**
	 * @param codigoCliente o valor a ser atribuído no atributo codigoCliente
	 */
	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

}
