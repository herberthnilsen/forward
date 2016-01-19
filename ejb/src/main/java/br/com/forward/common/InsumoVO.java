package br.com.forward.common;

import java.io.Serializable;

/**
 * @author Herberth Nilsen
 *
 */

/**
 * @author Herberth Nilsen
 *
 */
/**
 * @author Herberth Nilsen
 *
 */
public class InsumoVO implements Serializable {

	private static final long serialVersionUID = 6000420032319243792L;

	private Integer codigoInsumo;
	private String nomeInsumo;
	private String descricaoInsumo;
	private String numeroSerie;
	private Double valorMercado;
	private Double valorVenda;
	private CategoriaInsumoVO categoriaInsumoVO;
	private UnidadeVO unidadeVO;

	public Integer getCodigoInsumo() {
		return codigoInsumo;
	}

	public void setCodigoInsumo(Integer codigoInsumo) {
		this.codigoInsumo = codigoInsumo;
	}

	public String getNomeInsumo() {
		return nomeInsumo;
	}

	public void setNomeInsumo(String nomeInsumo) {
		this.nomeInsumo = nomeInsumo;
	}

	public String getDescricaoInsumo() {
		return descricaoInsumo;
	}

	public void setDescricaoInsumo(String descricaoInsumo) {
		this.descricaoInsumo = descricaoInsumo;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public Double getValorMercado() {
		return valorMercado;
	}

	public void setValorMercado(Double valorMercado) {
		this.valorMercado = valorMercado;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public CategoriaInsumoVO getCategoriaInsumoVO() {
		return categoriaInsumoVO;
	}

	public void setCategoriaInsumoVO(CategoriaInsumoVO categoriaInsumoVO) {
		this.categoriaInsumoVO = categoriaInsumoVO;
	}

	public UnidadeVO getUnidadeVO() {
		return unidadeVO;
	}

	public void setUnidadeVO(UnidadeVO unidadeVO) {
		this.unidadeVO = unidadeVO;
	}

}
