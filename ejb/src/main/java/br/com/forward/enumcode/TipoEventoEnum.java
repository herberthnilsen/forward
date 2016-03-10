/**
 * 
 */
package br.com.forward.enumcode;

/**
 * @author Herberth Nilsen
 *
 */
public enum TipoEventoEnum {

	CASAMENTO(1, "Casamento");
	
	private Integer codigo;
	
	private String descricao;
	
	TipoEventoEnum(Integer codigo, String descricao) {
	
		this.codigo = codigo;
		this.descricao = descricao;
	
	}
	
	
	
	public static TipoEventoEnum getEnumByCodigo(Integer codigo){
		
		TipoEventoEnum retorno = null;
		
		for(TipoEventoEnum eventoEnum : TipoEventoEnum.values()){
			
			if(eventoEnum.getCodigo().equals(codigo)){
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
		return codigo;
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
		return descricao;
	}



	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
