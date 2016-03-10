/**
 * 
 */
package br.com.forward.enumcode;

/**
 * @author Herberth Nilsen
 *
 */
public enum TipoServicoParceiroEnum {

	CASAMENTO(1, "Casamento");
	
	private Integer codigo;
	
	private String descricao;
	
	TipoServicoParceiroEnum(Integer codigo, String descricao) {
	
		this.codigo = codigo;
		this.descricao = descricao;
	
	}
	
	
	
	public static TipoServicoParceiroEnum getEnumByCodigo(Integer codigo){
		
		TipoServicoParceiroEnum retorno = null;
		
		for(TipoServicoParceiroEnum eventoEnum : TipoServicoParceiroEnum.values()){
			
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
