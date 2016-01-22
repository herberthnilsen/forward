package br.com.forward.common;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Herberth Nilsen
 *
 */
public class InsumoVO implements Serializable {

	private static final long serialVersionUID = 6000420032319243792L;

	private Integer codigoInsumo;

	private String descricaoInsumo;

	private Date dataCadastro;

	private String nomeInsumo;

	private BigDecimal numeroSerie;

	private Double valorMercado;

	private Double valorVenda;

	private Integer codigoCategoriaInsumo;
	private Integer codigoUnidade;
	
	public Integer getCodigoInsumo() {
		return codigoInsumo;
	}
	public void setCodigoInsumo(Integer codigoInsumo) {
		this.codigoInsumo = codigoInsumo;
	}
	public String getDescricaoInsumo() {
		return descricaoInsumo;
	}
	public void setDescricaoInsumo(String descricaoInsumo) {
		this.descricaoInsumo = descricaoInsumo;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getNomeInsumo() {
		return nomeInsumo;
	}
	public void setNomeInsumo(String nomeInsumo) {
		this.nomeInsumo = nomeInsumo;
	}
	public BigDecimal getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(BigDecimal numeroSerie) {
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
	public Integer getCodigoCategoriaInsumo() {
		return codigoCategoriaInsumo;
	}
	public void setCodigoCategoriaInsumo(Integer categoriaInsumoVO) {
		this.codigoCategoriaInsumo = categoriaInsumoVO;
	}
	public Integer getCodigoUnidade() {
		return codigoUnidade;
	}
	public void setCodigoUnidade(Integer codigoUnidade) {
		this.codigoUnidade = codigoUnidade;
	}

}
