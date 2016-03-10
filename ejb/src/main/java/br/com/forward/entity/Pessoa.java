package br.com.forward.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
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
	private Timestamp dataCadastro;

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
	public Timestamp getDataCadastro() {
		return this.dataCadastro;
	}

	/**
	 * @param dataCadastro o valor a ser atribuído no atributo dataCadastro
	 */
	public void setDataCadastro(Timestamp dataCadastro) {
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

}
