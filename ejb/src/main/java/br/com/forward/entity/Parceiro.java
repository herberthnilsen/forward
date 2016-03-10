package br.com.forward.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the fwdpcr database table.
 */
@Entity
@Table(name = "fwdpcr")
@NamedQuery(name = "Parceiro.findAll", query = "SELECT p FROM Parceiro p")
public class Parceiro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fwdpcrid")
	private Integer codigoParceiro;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fwdpescod")
	private Pessoa pessoa;

	// bi-directional many-to-one association to TipoServicoParceiro
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fwdtposrvpcrid")
	private TipoServicoParceiro tipoServicoParceiro;

	// bi-directional many-to-many association to Prospeccao
	@ManyToMany
	@JoinTable(name = "fwdpcridcpcc", joinColumns = { @JoinColumn(name = "fwdpcrid") }, inverseJoinColumns = {
			@JoinColumn(name = "idfwdppc") })
	private List<Prospeccao> prospeccao;

	public Parceiro() {
	}

	public Integer getCodigoParceiro() {
		return this.codigoParceiro;
	}

	public void setCodigoParceiro(Integer codigoParceiro) {
		this.codigoParceiro = codigoParceiro;
	}

	public Pessoa getCodigoPessoa() {
		return this.pessoa;
	}

	public void setCodigoPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public TipoServicoParceiro getFwdtposrvpcr() {
		return this.tipoServicoParceiro;
	}

	public void setFwdtposrvpcr(TipoServicoParceiro fwdtposrvpcr) {
		this.tipoServicoParceiro = fwdtposrvpcr;
	}

	public List<Prospeccao> getFwdppcs() {
		return this.prospeccao;
	}

	public void setFwdppcs(List<Prospeccao> fwdppcs) {
		this.prospeccao = fwdppcs;
	}

}