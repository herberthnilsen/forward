/**
 * 
 */
package br.com.forward.enumcode;

/**
 * @author Herberth Nilsen
 */
public enum TipoContatoEnum {

	EMAIL(1, "E-mail"), TELEFONE(2, "Telefone"), CELULAR(3, "Celular"),;

	private Integer codigo;

	private String descricao;

	TipoContatoEnum(Integer codigo, String descricao) {

		this.codigo = codigo;
		this.descricao = descricao;

	}

	public static TipoContatoEnum getEnumByCodigo(Integer codigo) {

		TipoContatoEnum retorno = null;

		for (final TipoContatoEnum eventoEnum : TipoContatoEnum.values()) {

			if (eventoEnum.getCodigo().equals(codigo)) {
				retorno = eventoEnum;
				break;
			}

		}
		return retorno;
	}

	/**
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return this.codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
