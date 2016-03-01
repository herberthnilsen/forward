package br.com.forward.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the fwdppc database table.
 * 
 */
@Entity
@Table(name="fwdppc")
@NamedQuery(name="Prospeccao.findAll", query="SELECT p FROM Prospeccao p")
public class Prospeccao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idfwdppc")
	private Long codigoProspeccao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dtacadppc")
	private Date dataCadastro;

	private int fwdclbcod;

	//bi-directional many-to-one association to Atendimento
	@OneToMany(mappedBy="fwdppc")
	private List<Atendimento> fwdatds;

	//bi-directional many-to-one association to ClienteProspeccao
	@OneToMany(mappedBy="fwdppc")
	private List<ClienteProspeccao> fwdcltpccs;

	//bi-directional many-to-one association to Orcamento
	@OneToMany(mappedBy="prospeccao")
	private List<Orcamento> listaOrcamentos;


	//bi-directional many-to-many association to Parceiro
	@ManyToMany(mappedBy="fwdppcs")
	private List<Parceiro> fwdpcrs;

	//bi-directional many-to-one association to Reuniao
	@OneToMany(mappedBy="fwdppc")
	private List<Reuniao> fwdrnos;

	public Prospeccao() {
	}

	public Long getCodigoProspeccao() {
		return this.codigoProspeccao;
	}

	public void setCodigoProspeccao(Long codigoProspeccao) {
		this.codigoProspeccao = codigoProspeccao;
	}

	public Date getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public int getFwdclbcod() {
		return this.fwdclbcod;
	}

	public void setFwdclbcod(int fwdclbcod) {
		this.fwdclbcod = fwdclbcod;
	}

	public List<Atendimento> getFwdatds() {
		return this.fwdatds;
	}

	public void setFwdatds(List<Atendimento> fwdatds) {
		this.fwdatds = fwdatds;
	}

	public Atendimento addFwdatd(Atendimento fwdatd) {
		getFwdatds().add(fwdatd);
		fwdatd.setFwdppc(this);

		return fwdatd;
	}

	public Atendimento removeFwdatd(Atendimento fwdatd) {
		getFwdatds().remove(fwdatd);
		fwdatd.setFwdppc(null);

		return fwdatd;
	}

	public List<ClienteProspeccao> getFwdcltpccs() {
		return this.fwdcltpccs;
	}

	public void setFwdcltpccs(List<ClienteProspeccao> fwdcltpccs) {
		this.fwdcltpccs = fwdcltpccs;
	}

	public ClienteProspeccao addFwdcltpcc(ClienteProspeccao fwdcltpcc) {
		getFwdcltpccs().add(fwdcltpcc);
		fwdcltpcc.setFwdppc(this);

		return fwdcltpcc;
	}

	public ClienteProspeccao removeFwdcltpcc(ClienteProspeccao fwdcltpcc) {
		getFwdcltpccs().remove(fwdcltpcc);
		fwdcltpcc.setFwdppc(null);

		return fwdcltpcc;
	}

	public List<Orcamento> getFwdorcs1() {
		return this.listaOrcamentos;
	}

	public void setFwdorcs1(List<Orcamento> fwdorcs1) {
		this.listaOrcamentos = fwdorcs1;
	}

	public Orcamento addFwdorcs1(Orcamento orcamento) {
		getFwdorcs1().add(orcamento);
		orcamento.setProspeccao(this);

		return orcamento;
	}

	public Orcamento removeFwdorcs1(Orcamento orcamento) {
		getFwdorcs1().remove(orcamento);
		orcamento.setProspeccao(null);

		return orcamento;
	}


	public List<Parceiro> getFwdpcrs() {
		return this.fwdpcrs;
	}

	public void setFwdpcrs(List<Parceiro> fwdpcrs) {
		this.fwdpcrs = fwdpcrs;
	}

	public List<Reuniao> getFwdrnos() {
		return this.fwdrnos;
	}

	public void setFwdrnos(List<Reuniao> fwdrnos) {
		this.fwdrnos = fwdrnos;
	}

	public Reuniao addFwdrno(Reuniao fwdrno) {
		getFwdrnos().add(fwdrno);
		fwdrno.setFwdppc(this);

		return fwdrno;
	}

	public Reuniao removeFwdrno(Reuniao fwdrno) {
		getFwdrnos().remove(fwdrno);
		fwdrno.setFwdppc(null);

		return fwdrno;
	}

}