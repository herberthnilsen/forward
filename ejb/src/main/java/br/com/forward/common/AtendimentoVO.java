/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.common;

import java.io.Serializable;

import br.com.forward.enumcode.FormaAtendimentoEnum;

/**
 * Classe responsável por ...
 *
 * @since 9 de mar de 2016 21:48:58
 * @version x.x
 */
public class AtendimentoVO implements Serializable {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private PessoaVO contato;

	private FormaAtendimentoEnum formaAtendimento;

	private String descricaoAtendimento;

	/**
	 * @return o valor do atributo contato
	 */
	public PessoaVO getContato() {
		return this.contato;
	}

	/**
	 * @param contato o valor a ser atribuído no atributo contato
	 */
	public void setContato(PessoaVO contato) {
		this.contato = contato;
	}

	/**
	 * @return o valor do atributo formaAtendimento
	 */
	public FormaAtendimentoEnum getFormaAtendimento() {
		return this.formaAtendimento;
	}

	/**
	 * @param formaAtendimento o valor a ser atribuído no atributo formaAtendimento
	 */
	public void setFormaAtendimento(FormaAtendimentoEnum formaAtendimento) {
		this.formaAtendimento = formaAtendimento;
	}

	/**
	 * @return o valor do atributo descricaoAtendimento
	 */
	public String getDescricaoAtendimento() {
		return this.descricaoAtendimento;
	}

	/**
	 * @param descricaoAtendimento o valor a ser atribuído no atributo descricaoAtendimento
	 */
	public void setDescricaoAtendimento(String descricaoAtendimento) {
		this.descricaoAtendimento = descricaoAtendimento;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.contato == null) ? 0 : this.contato.hashCode());
		result = prime * result + ((this.descricaoAtendimento == null) ? 0 : this.descricaoAtendimento.hashCode());
		result = prime * result + ((this.formaAtendimento == null) ? 0 : this.formaAtendimento.hashCode());
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
		if (!(obj instanceof AtendimentoVO)) {
			return false;
		}
		final AtendimentoVO other = (AtendimentoVO) obj;
		if (this.contato == null) {
			if (other.contato != null) {
				return false;
			}
		} else if (!this.contato.equals(other.contato)) {
			return false;
		}
		if (this.descricaoAtendimento == null) {
			if (other.descricaoAtendimento != null) {
				return false;
			}
		} else if (!this.descricaoAtendimento.equals(other.descricaoAtendimento)) {
			return false;
		}
		if (this.formaAtendimento != other.formaAtendimento) {
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
		return "AtendimentoVO [contato=" + this.contato + ", formaAtendimento=" + this.formaAtendimento
				+ ", descricaoAtendimento=" + this.descricaoAtendimento + "]";
	}

}
