package br.com.forward.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the fwdtposrvpcr database table.
 * 
 */
@Entity
@Table(name="fwdtposrvpcr")
@NamedQuery(name="TipoServicoParceiro.findAll", query="SELECT t FROM TipoServicoParceiro t")
public class TipoServicoParceiro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="fwdtposrvpcrid")
	private Integer codigoTipoServicoParceiro;

	@Column(name="dsctposrvpcr")
	private String descricaoTipoServicoParceiro;

	//bi-directional many-to-one association to Parceiro
	@OneToMany(mappedBy="fwdtposrvpcr")
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
		getListaParceiros().add(parceiro);
		parceiro.setFwdtposrvpcr(this);

		return parceiro;
	}

	public Parceiro removeParceiro(Parceiro parceiro) {
		getListaParceiros().remove(parceiro);
		parceiro.setFwdtposrvpcr(null);

		return parceiro;
	}

}