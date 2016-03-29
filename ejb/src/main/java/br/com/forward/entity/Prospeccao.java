package br.com.forward.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the fwdppc database table.
 */
@Entity
@Table(name = "fwdppc")
@NamedQuery(name = "Prospeccao.findAll", query = "SELECT p FROM Prospeccao p")
public class Prospeccao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idfwdppc")
	private Long codigoProspeccao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dtacadppc")
	private Date dataCadastro;

	private int fwdclbcod;

	// bi-directional many-to-one association to Atendimento
	@OneToMany(mappedBy = "prospeccao")
	private List<Atendimento> fwdatds;

	// bi-directional many-to-one association to ClienteProspeccao
	@OneToMany(mappedBy = "fwdppc")
	private List<ClienteProspeccao> fwdcltpccs;

	// bi-directional many-to-one association to Orcamento
	@OneToMany(mappedBy = "prospeccao")
	private List<Orcamento> listaOrcamentos;

	// bi-directional many-to-many association to Parceiro
	@ManyToMany(mappedBy = "prospeccao")
	private List<Parceiro> parceiros;

	// bi-directional many-to-one association to Reuniao
	@OneToMany(mappedBy = "fwdppc")
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
		this.getFwdatds().add(fwdatd);
		fwdatd.setProspeccao(this);

		return fwdatd;
	}

	public Atendimento removeFwdatd(Atendimento fwdatd) {
		this.getFwdatds().remove(fwdatd);
		fwdatd.setProspeccao(null);

		return fwdatd;
	}

	public List<ClienteProspeccao> getFwdcltpccs() {
		return this.fwdcltpccs;
	}

	public void setFwdcltpccs(List<ClienteProspeccao> fwdcltpccs) {
		this.fwdcltpccs = fwdcltpccs;
	}

	public ClienteProspeccao addFwdcltpcc(ClienteProspeccao fwdcltpcc) {
		this.getFwdcltpccs().add(fwdcltpcc);
		fwdcltpcc.setFwdppc(this);

		return fwdcltpcc;
	}

	public ClienteProspeccao removeFwdcltpcc(ClienteProspeccao fwdcltpcc) {
		this.getFwdcltpccs().remove(fwdcltpcc);
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
		this.getFwdorcs1().add(orcamento);
		orcamento.setProspeccao(this);

		return orcamento;
	}

	public Orcamento removeFwdorcs1(Orcamento orcamento) {
		this.getFwdorcs1().remove(orcamento);
		orcamento.setProspeccao(null);

		return orcamento;
	}

	public List<Reuniao> getFwdrnos() {
		return this.fwdrnos;
	}

	public void setFwdrnos(List<Reuniao> fwdrnos) {
		this.fwdrnos = fwdrnos;
	}

	public Reuniao addFwdrno(Reuniao fwdrno) {
		this.getFwdrnos().add(fwdrno);
		fwdrno.setFwdppc(this);

		return fwdrno;
	}

	public Reuniao removeFwdrno(Reuniao fwdrno) {
		this.getFwdrnos().remove(fwdrno);
		fwdrno.setFwdppc(null);

		return fwdrno;
	}

	/**
	 * @return o valor do atributo listaOrcamentos
	 */
	public List<Orcamento> getListaOrcamentos() {
		return this.listaOrcamentos;
	}

	/**
	 * @param listaOrcamentos o valor a ser atribuído no atributo listaOrcamentos
	 */
	public void setListaOrcamentos(List<Orcamento> listaOrcamentos) {
		this.listaOrcamentos = listaOrcamentos;
	}

	/**
	 * @return o valor do atributo parceiros
	 */
	public List<Parceiro> getParceiros() {
		return this.parceiros;
	}

	/**
	 * @param parceiros o valor a ser atribuído no atributo parceiros
	 */
	public void setParceiros(List<Parceiro> parceiros) {
		this.parceiros = parceiros;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.codigoProspeccao == null) ? 0 : this.codigoProspeccao.hashCode());
		result = prime * result + ((this.dataCadastro == null) ? 0 : this.dataCadastro.hashCode());
		result = prime * result + ((this.fwdatds == null) ? 0 : this.fwdatds.hashCode());
		result = prime * result + this.fwdclbcod;
		result = prime * result + ((this.fwdcltpccs == null) ? 0 : this.fwdcltpccs.hashCode());
		result = prime * result + ((this.fwdrnos == null) ? 0 : this.fwdrnos.hashCode());
		result = prime * result + ((this.listaOrcamentos == null) ? 0 : this.listaOrcamentos.hashCode());
		result = prime * result + ((this.parceiros == null) ? 0 : this.parceiros.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Prospeccao)) {
			return false;
		}
		final Prospeccao other = (Prospeccao) obj;
		if (this.codigoProspeccao == null) {
			if (other.codigoProspeccao != null) {
				return false;
			}
		} else if (!this.codigoProspeccao.equals(other.codigoProspeccao)) {
			return false;
		}
		if (this.dataCadastro == null) {
			if (other.dataCadastro != null) {
				return false;
			}
		} else if (!this.dataCadastro.equals(other.dataCadastro)) {
			return false;
		}
		if (this.fwdatds == null) {
			if (other.fwdatds != null) {
				return false;
			}
		} else if (!this.fwdatds.equals(other.fwdatds)) {
			return false;
		}
		if (this.fwdclbcod != other.fwdclbcod) {
			return false;
		}
		if (this.fwdcltpccs == null) {
			if (other.fwdcltpccs != null) {
				return false;
			}
		} else if (!this.fwdcltpccs.equals(other.fwdcltpccs)) {
			return false;
		}
		if (this.fwdrnos == null) {
			if (other.fwdrnos != null) {
				return false;
			}
		} else if (!this.fwdrnos.equals(other.fwdrnos)) {
			return false;
		}
		if (this.listaOrcamentos == null) {
			if (other.listaOrcamentos != null) {
				return false;
			}
		} else if (!this.listaOrcamentos.equals(other.listaOrcamentos)) {
			return false;
		}
		if (this.parceiros == null) {
			if (other.parceiros != null) {
				return false;
			}
		} else if (!this.parceiros.equals(other.parceiros)) {
			return false;
		}
		return true;
	}

}