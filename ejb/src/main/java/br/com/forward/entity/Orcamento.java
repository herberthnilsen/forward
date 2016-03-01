package br.com.forward.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the Orcamento database table.
 * 
 */
@Entity
@Table(name="Orcamento")
@NamedQuery(name="Orcamento.findAll", query="SELECT o FROM Orcamento o")
public class Orcamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Orcamentoid")
	private Long codigoOrcamento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dtaorc")
	private Date dataOrcamento;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Colaborador", nullable=false)
	private Colaborador colaborador;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="representanteComercial", nullable=false)
	private Colaborador representanteComercial;

	@Column(name="qtdpar")
	private short quantidadeParcela;

	@Column(name="vlrajs")
	private BigDecimal valorAjuste;

	@Column(name="vlrpcgdst")
	private short valorDesconto;

	@Column(name="vlrttlorc")
	private BigDecimal valorTotalOrcamento;

	@OneToMany(mappedBy="orcamento")
	private List<Evento> listaEventos;
	
	//bi-directional many-to-one association to ItemOrcamento
	@OneToMany(mappedBy="orcamento")
	private List<ItemOrcamento> listaItensOrcamento;

	//bi-directional many-to-one association to Prospeccao
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idProspeccao")
	private Prospeccao prospeccao;

	@Column(name="fwdorcsttid")
	private Integer codigoSituacao;
	
	public Orcamento() {
	}

	public Long getCodigoOrcamento() {
		return this.codigoOrcamento;
	}

	public void setCodigoOrcamento(Long codigoOrcamento) {
		this.codigoOrcamento = codigoOrcamento;
	}

	public Date getDataOrcamento() {
		return this.dataOrcamento;
	}

	public void setDataOrcamento(Date dataOrcamento) {
		this.dataOrcamento = dataOrcamento;
	}

	public Colaborador getColaborador() {
		return this.colaborador;
	}

	public void setColaborador(Colaborador Colaborador) {
		this.colaborador = Colaborador;
	}

	public Colaborador getColaboradorcom() {
		return this.representanteComercial;
	}

	public void setColaboradorcom(Colaborador Colaboradorcom) {
		this.representanteComercial = Colaboradorcom;
	}

	public short getQuantidadeParcela() {
		return this.quantidadeParcela;
	}

	public void setQuantidadeParcela(short quantidadeParcela) {
		this.quantidadeParcela = quantidadeParcela;
	}

	public BigDecimal getValorAjuste() {
		return this.valorAjuste;
	}

	public void setValorAjuste(BigDecimal valorAjuste) {
		this.valorAjuste = valorAjuste;
	}

	public short getValorDesconto() {
		return this.valorDesconto;
	}

	public void setValorDesconto(short valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorTotalOrcamento() {
		return this.valorTotalOrcamento;
	}

	public void setValorTotalOrcamento(BigDecimal valorTotalOrcamento) {
		this.valorTotalOrcamento = valorTotalOrcamento;
	}

	public List<ItemOrcamento> getListaItensOrcamento() {
		return this.listaItensOrcamento;
	}

	public void setListaItensOrcamento(List<ItemOrcamento> ListaItensOrcamento) {
		this.listaItensOrcamento = ListaItensOrcamento;
	}

	public ItemOrcamento addItemOrcamento(ItemOrcamento itemOrcamento) {
		getListaItensOrcamento().add(itemOrcamento);
		itemOrcamento.setOrcamento(this);

		return itemOrcamento;
	}

	public ItemOrcamento removeItemOrcamento(ItemOrcamento itemOrcamento) {
		getListaItensOrcamento().remove(itemOrcamento);
		itemOrcamento.setOrcamento(null);

		return itemOrcamento;
	}

	public Prospeccao getProspeccao() {
		return this.prospeccao;
	}

	public void setProspeccao(Prospeccao Prospeccao) {
		this.prospeccao = Prospeccao;
	}

	/**
	 * @return the representanteComercial
	 */
	public Colaborador getRepresentanteComercial() {
		return representanteComercial;
	}

	/**
	 * @param representanteComercial the representanteComercial to set
	 */
	public void setRepresentanteComercial(Colaborador representanteComercial) {
		this.representanteComercial = representanteComercial;
	}

	/**
	 * @return the listaEventos
	 */
	public List<Evento> getListaEventos() {
		return listaEventos;
	}

	/**
	 * @param listaEventos the listaEventos to set
	 */
	public void setListaEventos(List<Evento> listaEventos) {
		this.listaEventos = listaEventos;
	}

	/**
	 * @return the codigoSituacao
	 */
	public Integer getCodigoSituacao() {
		return codigoSituacao;
	}

	/**
	 * @param codigoSituacao the codigoSituacao to set
	 */
	public void setCodigoSituacao(Integer codigoSituacao) {
		this.codigoSituacao = codigoSituacao;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoOrcamento == null) ? 0 : codigoOrcamento.hashCode());
		result = prime * result + ((codigoSituacao == null) ? 0 : codigoSituacao.hashCode());
		result = prime * result + ((colaborador == null) ? 0 : colaborador.hashCode());
		result = prime * result + ((dataOrcamento == null) ? 0 : dataOrcamento.hashCode());
		result = prime * result + ((listaEventos == null) ? 0 : listaEventos.hashCode());
		result = prime * result + ((listaItensOrcamento == null) ? 0 : listaItensOrcamento.hashCode());
		result = prime * result + ((prospeccao == null) ? 0 : prospeccao.hashCode());
		result = prime * result + quantidadeParcela;
		result = prime * result + ((representanteComercial == null) ? 0 : representanteComercial.hashCode());
		result = prime * result + ((valorAjuste == null) ? 0 : valorAjuste.hashCode());
		result = prime * result + valorDesconto;
		result = prime * result + ((valorTotalOrcamento == null) ? 0 : valorTotalOrcamento.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Orcamento))
			return false;
		Orcamento other = (Orcamento) obj;
		if (codigoOrcamento == null) {
			if (other.codigoOrcamento != null)
				return false;
		} else if (!codigoOrcamento.equals(other.codigoOrcamento))
			return false;
		if (codigoSituacao == null) {
			if (other.codigoSituacao != null)
				return false;
		} else if (!codigoSituacao.equals(other.codigoSituacao))
			return false;
		if (colaborador == null) {
			if (other.colaborador != null)
				return false;
		} else if (!colaborador.equals(other.colaborador))
			return false;
		if (dataOrcamento == null) {
			if (other.dataOrcamento != null)
				return false;
		} else if (!dataOrcamento.equals(other.dataOrcamento))
			return false;
		if (listaEventos == null) {
			if (other.listaEventos != null)
				return false;
		} else if (!listaEventos.equals(other.listaEventos))
			return false;
		if (listaItensOrcamento == null) {
			if (other.listaItensOrcamento != null)
				return false;
		} else if (!listaItensOrcamento.equals(other.listaItensOrcamento))
			return false;
		if (prospeccao == null) {
			if (other.prospeccao != null)
				return false;
		} else if (!prospeccao.equals(other.prospeccao))
			return false;
		if (quantidadeParcela != other.quantidadeParcela)
			return false;
		if (representanteComercial == null) {
			if (other.representanteComercial != null)
				return false;
		} else if (!representanteComercial.equals(other.representanteComercial))
			return false;
		if (valorAjuste == null) {
			if (other.valorAjuste != null)
				return false;
		} else if (!valorAjuste.equals(other.valorAjuste))
			return false;
		if (valorDesconto != other.valorDesconto)
			return false;
		if (valorTotalOrcamento == null) {
			if (other.valorTotalOrcamento != null)
				return false;
		} else if (!valorTotalOrcamento.equals(other.valorTotalOrcamento))
			return false;
		return true;
	}

}