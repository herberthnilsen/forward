/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.common;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.forward.enumcode.FormaAtendimentoEnum;
import br.com.forward.util.Constants;

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

	/**
	 * Atributo codigoAtendimento
	 */
	private Long codigoAtendimento;
	/**
	 * Atributo contato
	 */
	private PessoaVO contato;

	/**
	 * Atributo formaAtendimento
	 */
	private FormaAtendimentoEnum formaAtendimento;

	/**
	 * Atributo dataCadastroAtendimento
	 */
	private Date dataCadastroAtendimento;

	/**
	 * Atributo descricaoAtendimento
	 */
	private String descricaoAtendimento;

	/**
	 * Atributo descricaoResumida
	 */
	private String descricaoResumida;

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
		result = prime * result + ((this.codigoAtendimento == null) ? 0 : this.codigoAtendimento.hashCode());
		result = prime * result + ((this.contato == null) ? 0 : this.contato.hashCode());
		result = prime * result + ((this.dataCadastroAtendimento == null) ? 0 : this.dataCadastroAtendimento.hashCode());
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
		if (this.codigoAtendimento == null) {
			if (other.codigoAtendimento != null) {
				return false;
			}
		} else if (!this.codigoAtendimento.equals(other.codigoAtendimento)) {
			return false;
		}
		if (this.contato == null) {
			if (other.contato != null) {
				return false;
			}
		} else if (!this.contato.equals(other.contato)) {
			return false;
		}
		if (this.dataCadastroAtendimento == null) {
			if (other.dataCadastroAtendimento != null) {
				return false;
			}
		} else if (!this.dataCadastroAtendimento.equals(other.dataCadastroAtendimento)) {
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
		return "AtendimentoVO [codigoAtendimento=" + this.codigoAtendimento + ", contato=" + this.contato + ", formaAtendimento="
				+ this.formaAtendimento + ", dataCadastroAtendimento=" + this.dataCadastroAtendimento + ", descricaoAtendimento="
				+ this.descricaoAtendimento + ", getClass()=" + this.getClass() + ", toString()=" + super.toString() + "]";
	}

	/**
	 * @return o valor do atributo dataCadastroAtendimento
	 */
	public Date getDataCadastroAtendimento() {
		return this.dataCadastroAtendimento;
	}

	public String getDataCadastroAtendimentoFormatado() {
		final SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_FORMAT_DATE_TIME);
		return sdf.format(this.dataCadastroAtendimento);
	}

	/**
	 * @param dataCadastroAtendimento o valor a ser atribuído no atributo dataCadastroAtendimento
	 */
	public void setDataCadastroAtendimento(Date dataCadastroAtendimento) {
		this.dataCadastroAtendimento = dataCadastroAtendimento;
	}

	/**
	 * @return o valor do atributo codigoAtendimento
	 */
	public Long getCodigoAtendimento() {
		return this.codigoAtendimento;
	}

	/**
	 * @param codigoAtendimento o valor a ser atribuído no atributo codigoAtendimento
	 */
	public void setCodigoAtendimento(Long codigoAtendimento) {
		this.codigoAtendimento = codigoAtendimento;
	}

	/**
	 * @return o valor do atributo descricaoResumida
	 */
	public String getDescricaoResumida() {
		return this.descricaoResumida;
	}

	/**
	 * @param descricaoResumida o valor a ser atribuído no atributo descricaoResumida
	 */
	public void setDescricaoResumida(String descricaoResumida) {
		this.descricaoResumida = descricaoResumida;
	}

}
