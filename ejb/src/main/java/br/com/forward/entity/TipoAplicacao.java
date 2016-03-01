package br.com.forward.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the fwdtipapl database table.
 * 
 */
@Entity
@Table(name="fwdtipapl")
@NamedQuery(name="TipoAplicacao.findAll", query="SELECT t FROM TipoAplicacao t")
public class TipoAplicacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="fwdtipaplid")
	private Short codigoTipoAplicacao;

	@Column(name="dsctipapl")
	private String descricaoTipoAplicacao;

	@Column(name="slgtipapl")
	private String siglaTipoAplicacao;

	//bi-directional many-to-one association to ItemOrcamento
	@OneToMany(mappedBy="tipoAplicacao")
	private List<ItemOrcamento> itemOrcamento;

	public TipoAplicacao() {
	}

	public Short getCodigoTipoAplicacao() {
		return this.codigoTipoAplicacao;
	}

	public void setCodigoTipoAplicacao(Short codigoTipoAplicacao) {
		this.codigoTipoAplicacao = codigoTipoAplicacao;
	}

	public String getDescricaoTipoAplicacao() {
		return this.descricaoTipoAplicacao;
	}

	public void setDescricaoTipoAplicacao(String descricaoTipoAplicacao) {
		this.descricaoTipoAplicacao = descricaoTipoAplicacao;
	}

	public String getSiglaTipoAplicacao() {
		return this.siglaTipoAplicacao;
	}

	public void setSiglaTipoAplicacao(String siglaTipoAplicacao) {
		this.siglaTipoAplicacao = siglaTipoAplicacao;
	}

	public List<ItemOrcamento> getItemOrcamento() {
		return this.itemOrcamento;
	}

	public void setItemOrcamento(List<ItemOrcamento> listaItensOrcamento) {
		this.itemOrcamento = listaItensOrcamento;
	}

	public ItemOrcamento addFwditmorc(ItemOrcamento itemOrcamento) {
		getItemOrcamento().add(itemOrcamento);
		itemOrcamento.setTipoAplicacao(this);

		return itemOrcamento;
	}

	public ItemOrcamento removeFwditmorc(ItemOrcamento itemOrcamento) {
		getItemOrcamento().remove(itemOrcamento);
		itemOrcamento.setTipoAplicacao(null);

		return itemOrcamento;
	}

}