package br.com.forward.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "fwdpes")
@NamedQuery(name = "Pessoa.findAll", query = "SELECT f FROM Pessoa f")
public class Pessoa implements EntityInterface {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fwdpescod\t", unique = true, nullable = false)
	private int codigoPessoa;

	@Column(name = "cpjcpfpes", nullable = false, precision = 10)
	private BigDecimal cnpjCpfPessoa;

	@Column(name = "datcad", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dtansc", nullable = true)
	private Date dataNascimento;

	@Column(name = "nompes", nullable = false, length = 60)
	private String nomePessoa;

	@Column(name = "tippes", nullable = false, length = 1)
	private String tipoPessoa;

	@OneToMany(mappedBy = "pessoa")
	private List<Colaborador> colaboradores;

	@OneToMany(mappedBy = "pessoa")
	private List<Cliente> cliente;

	@OneToMany(mappedBy = "colaborador")
	private List<Cliente> colaborador;

	@OneToMany(mappedBy = "pessoa")
	private List<EnderecoPessoa> enderecoPessoas;

	@OneToMany(mappedBy = "pessoa")
	private List<HistoricoEstoque> historicoEstoques;

	@OneToMany(mappedBy = "pessoa")
	private List<Pacote> pacotes;

	@OneToOne(mappedBy = "pessoa")
	private Parceiro parceiro;

	@OneToMany(mappedBy = "pessoa")
	private List<PessoaContato> pessoaContatos;

	/**
	 * @return o valor do atributo codigoPessoa
	 */
	public int getCodigoPessoa() {
		return this.codigoPessoa;
	}

	/**
	 * @param codigoPessoa o valor a ser atribuído no atributo codigoPessoa
	 */
	public void setCodigoPessoa(int codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}

	/**
	 * @return o valor do atributo cnpjCpfPessoa
	 */
	public BigDecimal getCnpjCpfPessoa() {
		return this.cnpjCpfPessoa;
	}

	/**
	 * @param cnpjCpfPessoa o valor a ser atribuído no atributo cnpjCpfPessoa
	 */
	public void setCnpjCpfPessoa(BigDecimal cnpjCpfPessoa) {
		this.cnpjCpfPessoa = cnpjCpfPessoa;
	}

	/**
	 * @return o valor do atributo dataCadastro
	 */
	public Date getDataCadastro() {
		return this.dataCadastro;
	}

	/**
	 * @param dataCadastro o valor a ser atribuído no atributo dataCadastro
	 */
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	/**
	 * @return o valor do atributo dataNascimento
	 */
	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	/**
	 * @param dataNascimento o valor a ser atribuído no atributo dataNascimento
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * @return o valor do atributo nomePessoa
	 */
	public String getNomePessoa() {
		return this.nomePessoa;
	}

	/**
	 * @param nomePessoa o valor a ser atribuído no atributo nomePessoa
	 */
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	/**
	 * @return o valor do atributo tipoPessoa
	 */
	public String getTipoPessoa() {
		return this.tipoPessoa;
	}

	/**
	 * @param tipoPessoa o valor a ser atribuído no atributo tipoPessoa
	 */
	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	/**
	 * @return o valor do atributo colaboradores
	 */
	public List<Colaborador> getColaboradores() {
		return this.colaboradores;
	}

	/**
	 * @param colaboradores o valor a ser atribuído no atributo colaboradores
	 */
	public void setColaboradores(List<Colaborador> colaboradores) {
		this.colaboradores = colaboradores;
	}

	/**
	 * @return o valor do atributo cliente
	 */
	public List<Cliente> getCliente() {
		return this.cliente;
	}

	/**
	 * @param cliente o valor a ser atribuído no atributo cliente
	 */
	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return o valor do atributo colaborador
	 */
	public List<Cliente> getColaborador() {
		return this.colaborador;
	}

	/**
	 * @param colaborador o valor a ser atribuído no atributo colaborador
	 */
	public void setColaborador(List<Cliente> colaborador) {
		this.colaborador = colaborador;
	}

	/**
	 * @return o valor do atributo enderecoPessoas
	 */
	public List<EnderecoPessoa> getEnderecoPessoas() {
		return this.enderecoPessoas;
	}

	/**
	 * @param enderecoPessoas o valor a ser atribuído no atributo enderecoPessoas
	 */
	public void setEnderecoPessoas(List<EnderecoPessoa> enderecoPessoas) {
		this.enderecoPessoas = enderecoPessoas;
	}

	/**
	 * @return o valor do atributo historicoEstoques
	 */
	public List<HistoricoEstoque> getHistoricoEstoques() {
		return this.historicoEstoques;
	}

	/**
	 * @param historicoEstoques o valor a ser atribuído no atributo historicoEstoques
	 */
	public void setHistoricoEstoques(List<HistoricoEstoque> historicoEstoques) {
		this.historicoEstoques = historicoEstoques;
	}

	/**
	 * @return o valor do atributo pacotes
	 */
	public List<Pacote> getPacotes() {
		return this.pacotes;
	}

	/**
	 * @param pacotes o valor a ser atribuído no atributo pacotes
	 */
	public void setPacotes(List<Pacote> pacotes) {
		this.pacotes = pacotes;
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

	/**
	 * @return o valor do atributo pessoaContatos
	 */
	public List<PessoaContato> getPessoaContatos() {
		return this.pessoaContatos;
	}

	/**
	 * @param pessoaContatos o valor a ser atribuído no atributo pessoaContatos
	 */
	public void setPessoaContatos(List<PessoaContato> pessoaContatos) {
		this.pessoaContatos = pessoaContatos;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pessoa [codigoPessoa=" + this.codigoPessoa + ", cnpjCpfPessoa=" + this.cnpjCpfPessoa + ", dataCadastro="
				+ this.dataCadastro + ", dataNascimento=" + this.dataNascimento + ", nomePessoa=" + this.nomePessoa
				+ ", tipoPessoa=" + this.tipoPessoa + ", colaboradores=" + this.colaboradores + ", cliente=" + this.cliente
				+ ", colaborador=" + this.colaborador + ", enderecoPessoas=" + this.enderecoPessoas + ", historicoEstoques="
				+ this.historicoEstoques + ", pacotes=" + this.pacotes + ", parceiro=" + this.parceiro + ", pessoaContatos="
				+ this.pessoaContatos + "]";
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.cliente == null) ? 0 : this.cliente.hashCode());
		result = prime * result + ((this.cnpjCpfPessoa == null) ? 0 : this.cnpjCpfPessoa.hashCode());
		result = prime * result + this.codigoPessoa;
		result = prime * result + ((this.colaborador == null) ? 0 : this.colaborador.hashCode());
		result = prime * result + ((this.colaboradores == null) ? 0 : this.colaboradores.hashCode());
		result = prime * result + ((this.dataCadastro == null) ? 0 : this.dataCadastro.hashCode());
		result = prime * result + ((this.dataNascimento == null) ? 0 : this.dataNascimento.hashCode());
		result = prime * result + ((this.enderecoPessoas == null) ? 0 : this.enderecoPessoas.hashCode());
		result = prime * result + ((this.historicoEstoques == null) ? 0 : this.historicoEstoques.hashCode());
		result = prime * result + ((this.nomePessoa == null) ? 0 : this.nomePessoa.hashCode());
		result = prime * result + ((this.pacotes == null) ? 0 : this.pacotes.hashCode());
		result = prime * result + ((this.parceiro == null) ? 0 : this.parceiro.hashCode());
		result = prime * result + ((this.pessoaContatos == null) ? 0 : this.pessoaContatos.hashCode());
		result = prime * result + ((this.tipoPessoa == null) ? 0 : this.tipoPessoa.hashCode());
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
		if (!(obj instanceof Pessoa)) {
			return false;
		}
		final Pessoa other = (Pessoa) obj;
		if (this.cliente == null) {
			if (other.cliente != null) {
				return false;
			}
		} else if (!this.cliente.equals(other.cliente)) {
			return false;
		}
		if (this.cnpjCpfPessoa == null) {
			if (other.cnpjCpfPessoa != null) {
				return false;
			}
		} else if (!this.cnpjCpfPessoa.equals(other.cnpjCpfPessoa)) {
			return false;
		}
		if (this.codigoPessoa != other.codigoPessoa) {
			return false;
		}
		if (this.colaborador == null) {
			if (other.colaborador != null) {
				return false;
			}
		} else if (!this.colaborador.equals(other.colaborador)) {
			return false;
		}
		if (this.colaboradores == null) {
			if (other.colaboradores != null) {
				return false;
			}
		} else if (!this.colaboradores.equals(other.colaboradores)) {
			return false;
		}
		if (this.dataCadastro == null) {
			if (other.dataCadastro != null) {
				return false;
			}
		} else if (!this.dataCadastro.equals(other.dataCadastro)) {
			return false;
		}
		if (this.dataNascimento == null) {
			if (other.dataNascimento != null) {
				return false;
			}
		} else if (!this.dataNascimento.equals(other.dataNascimento)) {
			return false;
		}
		if (this.enderecoPessoas == null) {
			if (other.enderecoPessoas != null) {
				return false;
			}
		} else if (!this.enderecoPessoas.equals(other.enderecoPessoas)) {
			return false;
		}
		if (this.historicoEstoques == null) {
			if (other.historicoEstoques != null) {
				return false;
			}
		} else if (!this.historicoEstoques.equals(other.historicoEstoques)) {
			return false;
		}
		if (this.nomePessoa == null) {
			if (other.nomePessoa != null) {
				return false;
			}
		} else if (!this.nomePessoa.equals(other.nomePessoa)) {
			return false;
		}
		if (this.pacotes == null) {
			if (other.pacotes != null) {
				return false;
			}
		} else if (!this.pacotes.equals(other.pacotes)) {
			return false;
		}
		if (this.parceiro == null) {
			if (other.parceiro != null) {
				return false;
			}
		} else if (!this.parceiro.equals(other.parceiro)) {
			return false;
		}
		if (this.pessoaContatos == null) {
			if (other.pessoaContatos != null) {
				return false;
			}
		} else if (!this.pessoaContatos.equals(other.pessoaContatos)) {
			return false;
		}
		if (this.tipoPessoa == null) {
			if (other.tipoPessoa != null) {
				return false;
			}
		} else if (!this.tipoPessoa.equals(other.tipoPessoa)) {
			return false;
		}
		return true;
	}

}
