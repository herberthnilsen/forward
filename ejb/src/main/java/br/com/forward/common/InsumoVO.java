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

	private BigDecimal valorMercado;
	private BigDecimal valorMercadoDe;
	private BigDecimal valorMercadoAte;

	private BigDecimal valorVenda;
	private BigDecimal valorVendaDe;
	private BigDecimal valorVendaAte;

	private CategoriaInsumoVO categoriaInsumoVO;
	private UnidadeVO unidadeVO;

	public InsumoVO() {

		this.categoriaInsumoVO = new CategoriaInsumoVO();
		this.unidadeVO = new UnidadeVO();
	}

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

	public BigDecimal  getValorMercado() {
		return valorMercado;
	}

	public void setValorMercado(BigDecimal  valorMercado) {
		this.valorMercado = valorMercado;
	}

	public BigDecimal  getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(BigDecimal  valorVenda) {
		this.valorVenda = valorVenda;
	}

	public BigDecimal  getValorMercadoDe() {
		return valorMercadoDe;
	}

	public void setValorMercadoDe(BigDecimal  valorMercadoDe) {
		this.valorMercadoDe = valorMercadoDe;
	}

	public BigDecimal  getValorMercadoAte() {
		return valorMercadoAte;
	}

	public void setValorMercadoAte(BigDecimal  valorMercadoAte) {
		this.valorMercadoAte = valorMercadoAte;
	}

	public BigDecimal getValorVendaDe() {
		return valorVendaDe;
	}

	public void setValorVendaDe(BigDecimal  valorVendaDe) {
		this.valorVendaDe = valorVendaDe;
	}

	public BigDecimal getValorVendaAte() {
		return valorVendaAte;
	}

	public void setValorVendaAte(BigDecimal valorVendaAte) {
		this.valorVendaAte = valorVendaAte;
	}

	/**
	 * @return the categoriaInsumoVO
	 */
	public CategoriaInsumoVO getCategoriaInsumoVO() {
		return categoriaInsumoVO;
	}

	/**
	 * @param categoriaInsumoVO
	 *            the categoriaInsumoVO to set
	 */
	public void setCategoriaInsumoVO(CategoriaInsumoVO categoriaInsumoVO) {
		this.categoriaInsumoVO = categoriaInsumoVO;
	}

	/**
	 * @return the unidadeVO
	 */
	public UnidadeVO getUnidadeVO() {
		return unidadeVO;
	}

	/**
	 * @param unidadeVO
	 *            the unidadeVO to set
	 */
	public void setUnidadeVO(UnidadeVO unidadeVO) {
		this.unidadeVO = unidadeVO;
	}

}
