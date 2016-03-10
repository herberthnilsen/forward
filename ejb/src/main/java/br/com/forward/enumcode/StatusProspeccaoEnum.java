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
public enum StatusProspeccaoEnum {

	EM_ANDAMENTO(1, "Em andamento"), CONCLUIDO(2, "Concluído");

	private Integer codigo;

	private String descricao;

	/**
	 * Construtor da classe StatusProspeccaoEnum
	 *
	 * @param codigo
	 * @param descricao
	 */
	private StatusProspeccaoEnum(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public static StatusProspeccaoEnum getEnumByCodigo(Integer codigo) {

		StatusProspeccaoEnum retorno = null;

		for (final StatusProspeccaoEnum status : StatusProspeccaoEnum.values()) {

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
