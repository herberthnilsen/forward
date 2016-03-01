package br.com.forward.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the fwdpcr database table.
 * 
 */
@Entity
@Table(name="fwdpcr")
@NamedQuery(name="Parceiro.findAll", query="SELECT p FROM Parceiro p")
public class Parceiro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="fwdpcrid")
	private Integer codigoParceiro;

	private int fwdpescod;

	//bi-directional many-to-one association to TipoServicoParceiro
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fwdtposrvpcrid")
	private TipoServicoParceiro fwdtposrvpcr;

	//bi-directional many-to-many association to Prospeccao
	@ManyToMany
	@JoinTable(
		name="fwdpcridcpcc"
		, joinColumns={
			@JoinColumn(name="fwdpcrid")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idfwdppc")
			}
		)
	private List<Prospeccao> fwdppcs;

	public Parceiro() {
	}

	public Integer getCodigoParceiro() {
		return this.codigoParceiro;
	}

	public void setCodigoParceiro(Integer codigoParceiro) {
		this.codigoParceiro = codigoParceiro;
	}

	public int getFwdpescod() {
		return this.fwdpescod;
	}

	public void setFwdpescod(int fwdpescod) {
		this.fwdpescod = fwdpescod;
	}

	public TipoServicoParceiro getFwdtposrvpcr() {
		return this.fwdtposrvpcr;
	}

	public void setFwdtposrvpcr(TipoServicoParceiro fwdtposrvpcr) {
		this.fwdtposrvpcr = fwdtposrvpcr;
	}

	public List<Prospeccao> getFwdppcs() {
		return this.fwdppcs;
	}

	public void setFwdppcs(List<Prospeccao> fwdppcs) {
		this.fwdppcs = fwdppcs;
	}

}