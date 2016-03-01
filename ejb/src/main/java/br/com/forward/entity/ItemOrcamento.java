package br.com.forward.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the fwditmorc database table.
 * 
 */
@Entity
@Table(name="fwditmorc")
@NamedQuery(name="ItemOrcamento.findAll", query="SELECT i FROM ItemOrcamento i")
public class ItemOrcamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemOrcamentoPK id;

	@Column(name="vlrftr")
	private Double valorFator;

	//bi-directional many-to-one association to Orcamento
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="orcamentoid", insertable=false, updatable=false)
	private Orcamento orcamento;

	//bi-directional many-to-one association to TipoAplicacao
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tipoAplicacaoid", insertable=false, updatable=false)
	private TipoAplicacao tipoAplicacao;

	public ItemOrcamento() {
	}

	public ItemOrcamentoPK getId() {
		return this.id;
	}

	public void setId(ItemOrcamentoPK id) {
		this.id = id;
	}

	public Double getValorFator() {
		return this.valorFator;
	}

	public void setValorFator(Double valorFator) {
		this.valorFator = valorFator;
	}

	public Orcamento getOrcamento() {
		return this.orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	public TipoAplicacao getTipoAplicacao() {
		return this.tipoAplicacao;
	}

	public void setTipoAplicacao(TipoAplicacao tipoAplicacao) {
		this.tipoAplicacao = tipoAplicacao;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orcamento == null) ? 0 : orcamento.hashCode());
		result = prime * result + ((tipoAplicacao == null) ? 0 : tipoAplicacao.hashCode());
		result = prime * result + ((valorFator == null) ? 0 : valorFator.hashCode());
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
		if (!(obj instanceof ItemOrcamento))
			return false;
		ItemOrcamento other = (ItemOrcamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orcamento == null) {
			if (other.orcamento != null)
				return false;
		} else if (!orcamento.equals(other.orcamento))
			return false;
		if (tipoAplicacao == null) {
			if (other.tipoAplicacao != null)
				return false;
		} else if (!tipoAplicacao.equals(other.tipoAplicacao))
			return false;
		if (valorFator == null) {
			if (other.valorFator != null)
				return false;
		} else if (!valorFator.equals(other.valorFator))
			return false;
		return true;
	}

}