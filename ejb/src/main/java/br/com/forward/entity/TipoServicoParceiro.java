package br.com.forward.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the fwdtposrvpcr database table.
 */
@Entity
@Table(name = "fwdtposrvpcr")
@NamedQuery(name = "TipoServicoParceiro.findAll", query = "SELECT t FROM TipoServicoParceiro t")
public class TipoServicoParceiro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fwdtposrvpcrid")
	private Integer codigoTipoServicoParceiro;

	@Column(name = "dsctposrvpcr")
	private String descricaoTipoServicoParceiro;

	// bi-directional many-to-one association to Parceiro
	@OneToMany(mappedBy = "tipoServicoParceiro")
	private List<Parceiro> listaParceiros;

	public TipoServicoParceiro() {
	}

	public Integer getCodigoTipoServicoParceiro() {
		return this.codigoTipoServicoParceiro;
	}

	public void setCodigoTipoServicoParceiro(Integer codigoTipoServicoParceiro) {
		this.codigoTipoServicoParceiro = codigoTipoServicoParceiro;
	}

	public String getDescricaoTipoServicoParceiro() {
		return this.descricaoTipoServicoParceiro;
	}

	public void setDescricaoTipoServicoParceiro(String descricaoTipoServicoParceiro) {
		this.descricaoTipoServicoParceiro = descricaoTipoServicoParceiro;
	}

	public List<Parceiro> getListaParceiros() {
		return this.listaParceiros;
	}

	public void setListaParceiros(List<Parceiro> listaParceiros) {
		this.listaParceiros = listaParceiros;
	}

	public Parceiro addParceiro(Parceiro parceiro) {
		this.getListaParceiros().add(parceiro);
		parceiro.setTipoServicoParceiro(this);

		return parceiro;
	}

	public Parceiro removeParceiro(Parceiro parceiro) {
		this.getListaParceiros().remove(parceiro);
		parceiro.setTipoServicoParceiro(null);

		return parceiro;
	}

}