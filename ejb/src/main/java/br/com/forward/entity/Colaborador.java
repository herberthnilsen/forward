package br.com.forward.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "fwdclb")
@NamedQuery(name = "Colaborador.findAll", query = "SELECT f FROM Colaborador f")
public class Colaborador implements EntityInterface {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "fwdclbcod", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigoColaborador;

	@Column(name = "datcad", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;

	@Column(name = "nomusr", length = 15)
	private String nomeUsuario;

	@Column(name = "snhusr", length = 255)
	private String senhaUsuario;

	@ManyToOne
	@JoinColumn(name = "fwdpescod", nullable = false)
	private Pessoa pessoa;

	@OneToMany(mappedBy = "colaborador")
	private List<Reuniao> listaReunioes;

	@OneToMany(mappedBy = "colaborador")
	private List<Atendimento> atendimentos;

	public Integer getCodigoColaborador() {
		return this.codigoColaborador;
	}

	public void setCodigoColaborador(Integer codigoColaborador) {
		this.codigoColaborador = codigoColaborador;
	}

	public Date getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(Timestamp dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getNomeUsuario() {
		return this.nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenhaUsuario() {
		return this.senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	/**
	 * @return the listaReunioes
	 */
	public List<Reuniao> getListaReunioes() {
		return this.listaReunioes;
	}

	/**
	 * @param listaReunioes the listaReunioes to set
	 */
	public void setListaReunioes(List<Reuniao> listaReunioes) {
		this.listaReunioes = listaReunioes;
	}

	/**
	 * @return o valor do atributo atendimentos
	 */
	public List<Atendimento> getAtendimentos() {
		return this.atendimentos;
	}

	/**
	 * @param atendimentos o valor a ser atribuído no atributo atendimentos
	 */
	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.atendimentos == null) ? 0 : this.atendimentos.hashCode());
		result = prime * result + ((this.codigoColaborador == null) ? 0 : this.codigoColaborador.hashCode());
		result = prime * result + ((this.dataCadastro == null) ? 0 : this.dataCadastro.hashCode());
		result = prime * result + ((this.listaReunioes == null) ? 0 : this.listaReunioes.hashCode());
		result = prime * result + ((this.nomeUsuario == null) ? 0 : this.nomeUsuario.hashCode());
		result = prime * result + ((this.pessoa == null) ? 0 : this.pessoa.hashCode());
		result = prime * result + ((this.senhaUsuario == null) ? 0 : this.senhaUsuario.hashCode());
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
		if (!(obj instanceof Colaborador)) {
			return false;
		}
		final Colaborador other = (Colaborador) obj;
		if (this.atendimentos == null) {
			if (other.atendimentos != null) {
				return false;
			}
		} else if (!this.atendimentos.equals(other.atendimentos)) {
			return false;
		}
		if (this.codigoColaborador == null) {
			if (other.codigoColaborador != null) {
				return false;
			}
		} else if (!this.codigoColaborador.equals(other.codigoColaborador)) {
			return false;
		}
		if (this.dataCadastro == null) {
			if (other.dataCadastro != null) {
				return false;
			}
		} else if (!this.dataCadastro.equals(other.dataCadastro)) {
			return false;
		}
		if (this.listaReunioes == null) {
			if (other.listaReunioes != null) {
				return false;
			}
		} else if (!this.listaReunioes.equals(other.listaReunioes)) {
			return false;
		}
		if (this.nomeUsuario == null) {
			if (other.nomeUsuario != null) {
				return false;
			}
		} else if (!this.nomeUsuario.equals(other.nomeUsuario)) {
			return false;
		}
		if (this.pessoa == null) {
			if (other.pessoa != null) {
				return false;
			}
		} else if (!this.pessoa.equals(other.pessoa)) {
			return false;
		}
		if (this.senhaUsuario == null) {
			if (other.senhaUsuario != null) {
				return false;
			}
		} else if (!this.senhaUsuario.equals(other.senhaUsuario)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Colaborador [codigoColaborador=" + this.codigoColaborador + ", dataCadastro=" + this.dataCadastro
				+ ", nomeUsuario=" + this.nomeUsuario + ", senhaUsuario=" + this.senhaUsuario + ", pessoa=" + this.pessoa
				+ ", listaReunioes=" + this.listaReunioes + ", atendimentos=" + this.atendimentos + "]";
	}
}

/*
 * Location: D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\ Qualified Name: br.com.forward.entity.Colaborador
 * JD-Core Version: 0.6.0
 */