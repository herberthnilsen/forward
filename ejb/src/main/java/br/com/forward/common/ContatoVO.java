/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.common;

import java.io.Serializable;

import br.com.forward.enumcode.TipoContatoEnum;

/**
 * Classe responsável por ...
 *
 * @since 1 de abr de 2016 20:33:22
 * @version x.x
 */
public class ContatoVO implements Serializable {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo codigoContatoPessoa
	 */
	private Long codigoContatoPessoa;

	/**
	 * Atributo tipoContato
	 */
	private TipoContatoEnum tipoContato;

	/**
	 * Atributo descricaoContato
	 */
	private String descricaoContato;

	/**
	 * @return o valor do atributo tipoContato
	 */
	public TipoContatoEnum getTipoContato() {
		return this.tipoContato;
	}

	/**
	 * @param tipoContato o valor a ser atribuído no atributo tipoContato
	 */
	public void setTipoContato(TipoContatoEnum tipoContato) {
		this.tipoContato = tipoContato;
	}

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

}
