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

	EMAIL(1, "E-mail"), TELEFONE(2, "Telefone"), FEIRA(3, "Feira"), VISITA(4, "Visita");

	private Integer codigo;

	private String descricao;

	/**
	 * Construtor da classe StatusProspeccaoEnum
	 *
	 * @param codigo
	 * @param descricao
	 */
	private FormaAtendimentoEnum(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public static FormaAtendimentoEnum getEnumByCodigo(Integer codigo) {

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
	public Integer getCodigo() {
		return this.codigo;
	}

	/**
	 * @param codigo o valor a ser atribuído no atributo codigo
	 */
	public void setCodigo(Integer codigo) {
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
