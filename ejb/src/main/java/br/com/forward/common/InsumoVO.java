package br.com.forward.common;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Herberth Nilsen
 *
 */
public class InsumoVO extends AbstractVO implements Serializable {

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
	
	private List<InsumoVO> subitens;

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

	/**
	 * @return the subitens
	 */
	public List<InsumoVO> getSubitens() {
		return subitens;
	}

	/**
	 * @param subitens the subitens to set
	 */
	public void setSubitens(List<InsumoVO> subitens) {
		this.subitens = subitens;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "InsumoVO [codigoInsumo=" + codigoInsumo + ", descricaoInsumo=" + descricaoInsumo + ", dataCadastro="
				+ dataCadastro + ", nomeInsumo=" + nomeInsumo + ", numeroSerie=" + numeroSerie + ", valorMercado="
				+ valorMercado + ", valorMercadoDe=" + valorMercadoDe + ", valorMercadoAte=" + valorMercadoAte
				+ ", valorVenda=" + valorVenda + ", valorVendaDe=" + valorVendaDe + ", valorVendaAte=" + valorVendaAte
				+ ", categoriaInsumoVO=" + categoriaInsumoVO + ", unidadeVO=" + unidadeVO + ", subitens=" + subitens
				+ "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((categoriaInsumoVO == null) ? 0 : categoriaInsumoVO.hashCode());
		result = prime * result + ((codigoInsumo == null) ? 0 : codigoInsumo.hashCode());
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((descricaoInsumo == null) ? 0 : descricaoInsumo.hashCode());
		result = prime * result + ((nomeInsumo == null) ? 0 : nomeInsumo.hashCode());
		result = prime * result + ((numeroSerie == null) ? 0 : numeroSerie.hashCode());
		result = prime * result + ((subitens == null) ? 0 : subitens.hashCode());
		result = prime * result + ((unidadeVO == null) ? 0 : unidadeVO.hashCode());
		result = prime * result + ((valorMercado == null) ? 0 : valorMercado.hashCode());
		result = prime * result + ((valorMercadoAte == null) ? 0 : valorMercadoAte.hashCode());
		result = prime * result + ((valorMercadoDe == null) ? 0 : valorMercadoDe.hashCode());
		result = prime * result + ((valorVenda == null) ? 0 : valorVenda.hashCode());
		result = prime * result + ((valorVendaAte == null) ? 0 : valorVendaAte.hashCode());
		result = prime * result + ((valorVendaDe == null) ? 0 : valorVendaDe.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof InsumoVO))
			return false;
		InsumoVO other = (InsumoVO) obj;
		if (categoriaInsumoVO == null) {
			if (other.categoriaInsumoVO != null)
				return false;
		} else if (!categoriaInsumoVO.equals(other.categoriaInsumoVO))
			return false;
		if (codigoInsumo == null) {
			if (other.codigoInsumo != null)
				return false;
		} else if (!codigoInsumo.equals(other.codigoInsumo))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (descricaoInsumo == null) {
			if (other.descricaoInsumo != null)
				return false;
		} else if (!descricaoInsumo.equals(other.descricaoInsumo))
			return false;
		if (nomeInsumo == null) {
			if (other.nomeInsumo != null)
				return false;
		} else if (!nomeInsumo.equals(other.nomeInsumo))
			return false;
		if (numeroSerie == null) {
			if (other.numeroSerie != null)
				return false;
		} else if (!numeroSerie.equals(other.numeroSerie))
			return false;
		if (subitens == null) {
			if (other.subitens != null)
				return false;
		} else if (!subitens.equals(other.subitens))
			return false;
		if (unidadeVO == null) {
			if (other.unidadeVO != null)
				return false;
		} else if (!unidadeVO.equals(other.unidadeVO))
			return false;
		if (valorMercado == null) {
			if (other.valorMercado != null)
				return false;
		} else if (!valorMercado.equals(other.valorMercado))
			return false;
		if (valorMercadoAte == null) {
			if (other.valorMercadoAte != null)
				return false;
		} else if (!valorMercadoAte.equals(other.valorMercadoAte))
			return false;
		if (valorMercadoDe == null) {
			if (other.valorMercadoDe != null)
				return false;
		} else if (!valorMercadoDe.equals(other.valorMercadoDe))
			return false;
		if (valorVenda == null) {
			if (other.valorVenda != null)
				return false;
		} else if (!valorVenda.equals(other.valorVenda))
			return false;
		if (valorVendaAte == null) {
			if (other.valorVendaAte != null)
				return false;
		} else if (!valorVendaAte.equals(other.valorVendaAte))
			return false;
		if (valorVendaDe == null) {
			if (other.valorVendaDe != null)
				return false;
		} else if (!valorVendaDe.equals(other.valorVendaDe))
			return false;
		return true;
	}

}
