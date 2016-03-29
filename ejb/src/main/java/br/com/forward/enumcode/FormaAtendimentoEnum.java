/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.enumcode;

/**
 * Classe responsável por ...
 *
 * @since 9 de mar de 2016 20:48:31
 * @version x.x
 */
public enum FormaAtendimentoEnum {

	EMAIL(new Short("1"), "E-mail"),
	TELEFONE(new Short("2"), "Telefone"),
	FEIRA(new Short("3"), "Feira"),
	VISITA(new Short("4"), "Visita");

	private Short codigo;

	private String descricao;

	/**
	 * Construtor da classe StatusProspeccaoEnum
	 *
	 * @param codigo
	 * @param descricao
	 */
	private FormaAtendimentoEnum(Short codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public static FormaAtendimentoEnum getEnumByCodigo(Short codigo) {

		FormaAtendimentoEnum retorno = null;

		for (final FormaAtendimentoEnum status : FormaAtendimentoEnum.values()) {

			if (status.codigo.equals(codigo)) {

				retorno = status;
				break;
			}

		}

		return retorno;

	}

	/**
	 * @return o valor do atributo codigo
	 */
	public Short getCodigo() {
		return this.codigo;
	}

	/**
	 * @param codigo o valor a ser atribuído no atributo codigo
	 */
	public void setCodigo(Short codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return o valor do atributo descricao
	 */
	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * @param descricao o valor a ser atribuído no atributo descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
