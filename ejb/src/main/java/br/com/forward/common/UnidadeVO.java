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

}
