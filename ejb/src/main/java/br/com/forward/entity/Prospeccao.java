package br.com.forward.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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

	@ManyToOne
	@JoinColumn(name = "fwdclbcod")
	private Colaborador colaborador;

	// bi-directional many-to-one association to Atendimento
	@OneToMany(mappedBy = "prospeccao")
	private List<Atendimento> listaAtendimentos;

	// bi-directional many-to-one association to ClienteProspeccao
	@OneToMany(mappedBy = "fwdppc")
	private List<ClienteProspeccao> clienteProspeccao;

	// bi-directional many-to-one association to Orcamento
	@OneToMany(mappedBy = "prospeccao")
	private List<Orcamento> listaOrcamentos;

	// bi-directional many-to-many association to Parceiro
	@ManyToMany(mappedBy = "prospeccao")
	private List<Parceiro> parceiros;

	// bi-directional many-to-one association to Reuniao
	@OneToMany(mappedBy = "fwdppc")
	private List<Reuniao> listaReuniao;

	@Column(name = "fwdsttmktid")
	private Integer statusMarketing;

	@Column(name = "fwdsttatdid")
	private Integer statusAtendimento;

	@ManyToOne
	@JoinColumn(name = "fwdpcrid")
	private Parceiro parceiro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datpen")
	private Date dataPendencia;

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

	public Colaborador getColaborador() {
		return this.colaborador;
	}

	public void setColaborador(Colaborador fwdclbcod) {
		this.colaborador = fwdclbcod;
	}

	public List<Atendimento> getListaAtendimentos() {
		return this.listaAtendimentos;
	}

	public void setListaAtendimentos(List<Atendimento> fwdatds) {
		this.listaAtendimentos = fwdatds;
	}

	public Atendimento addFwdatd(Atendimento fwdatd) {
		this.getListaAtendimentos().add(fwdatd);
		fwdatd.setProspeccao(this);

		return fwdatd;
	}

	public Atendimento removeFwdatd(Atendimento fwdatd) {
		this.getListaAtendimentos().remove(fwdatd);
		fwdatd.setProspeccao(null);

		return fwdatd;
	}

	public List<ClienteProspeccao> getClienteProspeccao() {
		return this.clienteProspeccao;
	}

	public void setClienteProspeccao(List<ClienteProspeccao> fwdcltpccs) {
		this.clienteProspeccao = fwdcltpccs;
	}

	public ClienteProspeccao addFwdcltpcc(ClienteProspeccao fwdcltpcc) {
		this.getClienteProspeccao().add(fwdcltpcc);
		fwdcltpcc.setFwdppc(this);

		return fwdcltpcc;
	}

	public ClienteProspeccao removeFwdcltpcc(ClienteProspeccao fwdcltpcc) {
		this.getClienteProspeccao().remove(fwdcltpcc);
		fwdcltpcc.setFwdppc(null);

		return fwdcltpcc;
	}

	public Orcamento addListaOrcamentos(Orcamento orcamento) {
		this.getListaOrcamentos().add(orcamento);
		orcamento.setProspeccao(this);

		return orcamento;
	}

	public Orcamento removeListaOrcamentos(Orcamento orcamento) {
		this.getListaOrcamentos().remove(orcamento);
		orcamento.setProspeccao(null);

		return orcamento;
	}

	public List<Reuniao> getListaReuniao() {
		return this.listaReuniao;
	}

	public void setListaReuniao(List<Reuniao> fwdrnos) {
		this.listaReuniao = fwdrnos;
	}

	public Reuniao addFwdrno(Reuniao fwdrno) {
		this.getListaReuniao().add(fwdrno);
		fwdrno.setFwdppc(this);

		return fwdrno;
	}

	public Reuniao removeFwdrno(Reuniao fwdrno) {
		this.getListaReuniao().remove(fwdrno);
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
		result = prime * result + ((this.clienteProspeccao == null) ? 0 : this.clienteProspeccao.hashCode());
		result = prime * result + ((this.codigoProspeccao == null) ? 0 : this.codigoProspeccao.hashCode());
		result = prime * result + ((this.colaborador == null) ? 0 : this.colaborador.hashCode());
		result = prime * result + ((this.dataCadastro == null) ? 0 : this.dataCadastro.hashCode());
		result = prime * result + ((this.dataPendencia == null) ? 0 : this.dataPendencia.hashCode());
		result = prime * result + ((this.listaAtendimentos == null) ? 0 : this.listaAtendimentos.hashCode());
		result = prime * result + ((this.listaOrcamentos == null) ? 0 : this.listaOrcamentos.hashCode());
		result = prime * result + ((this.listaReuniao == null) ? 0 : this.listaReuniao.hashCode());
		result = prime * result + ((this.parceiro == null) ? 0 : this.parceiro.hashCode());
		result = prime * result + ((this.parceiros == null) ? 0 : this.parceiros.hashCode());
		result = prime * result + ((this.statusAtendimento == null) ? 0 : this.statusAtendimento.hashCode());
		result = prime * result + ((this.statusMarketing == null) ? 0 : this.statusMarketing.hashCode());
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
		if (this.clienteProspeccao == null) {
			if (other.clienteProspeccao != null) {
				return false;
			}
		} else if (!this.clienteProspeccao.equals(other.clienteProspeccao)) {
			return false;
		}
		if (this.codigoProspeccao == null) {
			if (other.codigoProspeccao != null) {
				return false;
			}
		} else if (!this.codigoProspeccao.equals(other.codigoProspeccao)) {
			return false;
		}
		if (this.colaborador == null) {
			if (other.colaborador != null) {
				return false;
			}
		} else if (!this.colaborador.equals(other.colaborador)) {
			return false;
		}
		if (this.dataCadastro == null) {
			if (other.dataCadastro != null) {
				return false;
			}
		} else if (!this.dataCadastro.equals(other.dataCadastro)) {
			return false;
		}
		if (this.dataPendencia == null) {
			if (other.dataPendencia != null) {
				return false;
			}
		} else if (!this.dataPendencia.equals(other.dataPendencia)) {
			return false;
		}
		if (this.listaAtendimentos == null) {
			if (other.listaAtendimentos != null) {
				return false;
			}
		} else if (!this.listaAtendimentos.equals(other.listaAtendimentos)) {
			return false;
		}
		if (this.listaOrcamentos == null) {
			if (other.listaOrcamentos != null) {
				return false;
			}
		} else if (!this.listaOrcamentos.equals(other.listaOrcamentos)) {
			return false;
		}
		if (this.listaReuniao == null) {
			if (other.listaReuniao != null) {
				return false;
			}
		} else if (!this.listaReuniao.equals(other.listaReuniao)) {
			return false;
		}
		if (this.parceiro == null) {
			if (other.parceiro != null) {
				return false;
			}
		} else if (!this.parceiro.equals(other.parceiro)) {
			return false;
		}
		if (this.parceiros == null) {
			if (other.parceiros != null) {
				return false;
			}
		} else if (!this.parceiros.equals(other.parceiros)) {
			return false;
		}
		if (this.statusAtendimento == null) {
			if (other.statusAtendimento != null) {
				return false;
			}
		} else if (!this.statusAtendimento.equals(other.statusAtendimento)) {
			return false;
		}
		if (this.statusMarketing == null) {
			if (other.statusMarketing != null) {
				return false;
			}
		} else if (!this.statusMarketing.equals(other.statusMarketing)) {
			return false;
		}
		return true;
	}

	/**
	 * @return o valor do atributo statusMarketing
	 */
	public Integer getStatusMarketing() {
		return this.statusMarketing;
	}

	/**
	 * @param statusMarketing o valor a ser atribuído no atributo statusMarketing
	 */
	public void setStatusMarketing(Integer statusMarketing) {
		this.statusMarketing = statusMarketing;
	}

	/**
	 * @return o valor do atributo statusAtendimento
	 */
	public Integer getStatusAtendimento() {
		return this.statusAtendimento;
	}

	/**
	 * @param statusAtendimento o valor a ser atribuído no atributo statusAtendimento
	 */
	public void setStatusAtendimento(Integer statusAtendimento) {
		this.statusAtendimento = statusAtendimento;
	}

	/**
	 * @return o valor do atributo parceiro
	 */
	public Parceiro getParceiro() {
		return this.parceiro;
	}

	/**
	 * @param parceiro o valor a ser atribuído no atributo parceiro
	 */
	public void setParceiro(Parceiro parceiro) {
		this.parceiro = parceiro;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Prospeccao [codigoProspeccao=" + this.codigoProspeccao + ", dataCadastro=" + this.dataCadastro + ", colaborador="
				+ this.colaborador + ", listaAtendimentos=" + this.listaAtendimentos + ", clienteProspeccao="
				+ this.clienteProspeccao + ", listaOrcamentos=" + this.listaOrcamentos + ", parceiros=" + this.parceiros
				+ ", listaReuniao=" + this.listaReuniao + ", statusMarketing=" + this.statusMarketing + ", statusAtendimento="
				+ this.statusAtendimento + ", parceiro=" + this.parceiro + ", dataPendencia=" + this.dataPendencia + "]";
	}

	/**
	 * @return o valor do atributo dataPendencia
	 */
	public Date getDataPendencia() {
		return this.dataPendencia;
	}

	/**
	 * @param dataPendencia o valor a ser atribuído no atributo dataPendencia
	 */
	public void setDataPendencia(Date dataPendencia) {
		this.dataPendencia = dataPendencia;
	}

}