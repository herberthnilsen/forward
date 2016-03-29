package br.com.forward.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the fwdatd database table.
 */
@Entity
@Table(name = "fwdatd")
@NamedQuery(name = "Atendimento.findAll", query = "SELECT a FROM Atendimento a")
public class Atendimento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fwdatdid")
	private Long codigoAtendimento;

	@Column(name = "dscatd")
	private String descricaoAtendimento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dtacadatd")
	private Date dataCadastroAtendimento;

	// bi-directional many-to-one association to Prospeccao
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idfwdppc")
	private Prospeccao prospeccao;

	@Column(name = "fwdtpoatdid")
	private Short tipoAtendimento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fwdclbcod")
	private Colaborador colaborador;

	public Atendimento() {
	}

	public Long getCodigoAtendimento() {
		return this.codigoAtendimento;
	}

	public void setCodigoAtendimento(Long codigoAtendimento) {
		this.codigoAtendimento = codigoAtendimento;
	}

	public String getDescricaoAtendimento() {
		return this.descricaoAtendimento;
	}

	public void setDescricaoAtendimento(String descricaoAtendimento) {
		this.descricaoAtendimento = descricaoAtendimento;
	}

	public Date getDataCadastroAtendimento() {
		return this.dataCadastroAtendimento;
	}

	public void setDataCadastroAtendimento(Date dataCadastroAtendimento) {
		this.dataCadastroAtendimento = dataCadastroAtendimento;
	}

	public Prospeccao getProspeccao() {
		return this.prospeccao;
	}

	public void setProspeccao(Prospeccao prospeccao) {
		this.prospeccao = prospeccao;
	}

	public Short getTipoAtendimento() {
		return this.tipoAtendimento;
	}

	public void setTipoAtendimento(Short tipoAtendimento) {
		this.tipoAtendimento = tipoAtendimento;
	}

	/**
	 * @return o valor do atributo colaborador
	 */
	public Colaborador getColaborador() {
		return this.colaborador;
	}

	/**
	 * @param colaborador o valor a ser atribuído no atributo colaborador
	 */
	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Atendimento [codigoAtendimento=" + this.codigoAtendimento + ", descricaoAtendimento=" + this.descricaoAtendimento
				+ ", dataCadastroAtendimento=" + this.dataCadastroAtendimento + ", prospeccao=" + this.prospeccao
				+ ", tipoAtendimento=" + this.tipoAtendimento + ", colaborador=" + this.colaborador + "]";
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.codigoAtendimento == null) ? 0 : this.codigoAtendimento.hashCode());
		result = prime * result + ((this.colaborador == null) ? 0 : this.colaborador.hashCode());
		result = prime * result + ((this.dataCadastroAtendimento == null) ? 0 : this.dataCadastroAtendimento.hashCode());
		result = prime * result + ((this.descricaoAtendimento == null) ? 0 : this.descricaoAtendimento.hashCode());
		result = prime * result + ((this.prospeccao == null) ? 0 : this.prospeccao.hashCode());
		result = prime * result + ((this.tipoAtendimento == null) ? 0 : this.tipoAtendimento.hashCode());
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
		if (!(obj instanceof Atendimento)) {
			return false;
		}
		final Atendimento other = (Atendimento) obj;
		if (this.codigoAtendimento == null) {
			if (other.codigoAtendimento != null) {
				return false;
			}
		} else if (!this.codigoAtendimento.equals(other.codigoAtendimento)) {
			return false;
		}
		if (this.colaborador == null) {
			if (other.colaborador != null) {
				return false;
			}
		} else if (!this.colaborador.equals(other.colaborador)) {
			return false;
		}
		if (this.dataCadastroAtendimento == null) {
			if (other.dataCadastroAtendimento != null) {
				return false;
			}
		} else if (!this.dataCadastroAtendimento.equals(other.dataCadastroAtendimento)) {
			return false;
		}
		if (this.descricaoAtendimento == null) {
			if (other.descricaoAtendimento != null) {
				return false;
			}
		} else if (!this.descricaoAtendimento.equals(other.descricaoAtendimento)) {
			return false;
		}
		if (this.prospeccao == null) {
			if (other.prospeccao != null) {
				return false;
			}
		} else if (!this.prospeccao.equals(other.prospeccao)) {
			return false;
		}
		if (this.tipoAtendimento == null) {
			if (other.tipoAtendimento != null) {
				return false;
			}
		} else if (!this.tipoAtendimento.equals(other.tipoAtendimento)) {
			return false;
		}
		return true;
	}

}