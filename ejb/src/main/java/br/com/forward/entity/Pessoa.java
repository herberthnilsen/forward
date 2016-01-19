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
 import javax.persistence.Table;
 import javax.persistence.Temporal;
 import javax.persistence.TemporalType;
 
 @Entity
 @Table(name="fwdpes")
 @NamedQuery(name="Pessoa.findAll", query="SELECT f FROM Pessoa f")
 public class Pessoa
   implements EntityInterface
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name="fwdpescod\t", unique=true, nullable=false)
   private int codigoPessoa;
 
   @Column(name="cpjcpfpes", nullable=false, precision=10)
   private BigDecimal cnpjCpfPessoa;
 
   @Column(name="datcad", nullable=false)
   private Timestamp dataCadastro;
 
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name="dtansc", nullable=true)
   private Date dataNascimento;
 
   @Column(name="nompes", nullable=false, length=60)
   private String nomePessoa;
 
   @Column(name="tippes", nullable=false, length=1)
   private String tipoPessoa;
 
   @OneToMany(mappedBy="pessoa")
   private List<Colaborador> colaboradores;
 
   @OneToMany(mappedBy="pessoa")
   private List<Cliente> cliente;
 
   @OneToMany(mappedBy="colaborador")
   private List<Cliente> colaborador;
 
   @OneToMany(mappedBy="pessoa")
   private List<EnderecoPessoa> enderecoPessoas;
 
   @OneToMany(mappedBy="pessoa")
   private List<HistoricoEstoque> historicoEstoques;
 
   @OneToMany(mappedBy="pessoa")
   private List<Pacote> pacotes;
 
   public int getCodigoPessoa()
   {
     return this.codigoPessoa;
   }
 
   public void setCodigoPessoa(int codigoPessoa) {
     this.codigoPessoa = codigoPessoa;
   }
 
   public BigDecimal getCpjcpfpes() {
     return this.cnpjCpfPessoa;
   }
 
   public void setCnpjCpfPessoa(BigDecimal cnpjCpfPessoa) {
     this.cnpjCpfPessoa = cnpjCpfPessoa;
   }
 
   public Timestamp getDatcad() {
     return this.dataCadastro;
   }
 
   public void setDataCadastro(Timestamp dataCadastro) {
     this.dataCadastro = dataCadastro;
   }
 
   public Date getDtansc() {
     return this.dataNascimento;
   }
 
   public void setDataNascimento(Date dataNascimento) {
     this.dataNascimento = dataNascimento;
   }
 
   public String getNomePessoa() {
     return this.nomePessoa;
   }
 
   public void setNomePessoa(String nomePessoa) {
     this.nomePessoa = nomePessoa;
   }
 
   public String getTipoPessoa() {
     return this.tipoPessoa;
   }
 
   public void setTipoPessoa(String tipoPessoa) {
     this.tipoPessoa = tipoPessoa;
   }
 
   public List<Colaborador> getListaColaboradores() {
     return this.colaboradores;
   }
 
   public void setListaColaboradores(List<Colaborador> fwdclbs) {
     this.colaboradores = fwdclbs;
   }
 
   public Colaborador addListaColaboradores(Colaborador colaborador) {
     getListaColaboradores().add(colaborador);
     colaborador.setPessoa(this);
 
     return colaborador;
   }
 
   public Colaborador removeListaColaboradores(Colaborador colaborador) {
     getListaColaboradores().remove(colaborador);
     colaborador.setPessoa(null);
 
     return colaborador;
   }
 
   public List<Cliente> getListaClientes() {
     return this.cliente;
   }
 
   public void setListaClientes(List<Cliente> fwdclts1) {
     this.cliente = fwdclts1;
   }
 
   public Cliente addListaClientes(Cliente cliente) {
     getListaClientes().add(cliente);
     cliente.setPessoa(this);
 
     return cliente;
   }
 
   public Cliente removeListaCliente(Cliente cliente) {
     getListaClientes().remove(cliente);
     cliente.setPessoa(null);
 
     return cliente;
   }
 
   public List<Cliente> getListaColaborador() {
     return this.colaborador;
   }
 
   public void setListaColaborador(List<Cliente> colaborador) {
     this.colaborador = colaborador;
   }
 
   public Cliente addListaColaborador(Cliente colaborador) {
     getListaColaborador().add(colaborador);
     colaborador.setColaborador(this);
 
     return colaborador;
   }
 
   public Cliente removeListaColaborador(Cliente colaborador) {
     getListaColaborador().remove(colaborador);
     colaborador.setColaborador(null);
 
     return colaborador;
   }
 
   public List<EnderecoPessoa> getListaEnderecoPessoas() {
     return this.enderecoPessoas;
   }
 
   public void setListaEnderecoPessoas(List<EnderecoPessoa> enderecoPessoas) {
     this.enderecoPessoas = enderecoPessoas;
   }
 
   public EnderecoPessoa addListaEnderecoPessoas(EnderecoPessoa enderecoPessoa) {
     getListaEnderecoPessoas().add(enderecoPessoa);
     enderecoPessoa.setPessoa(this);
 
     return enderecoPessoa;
   }
 
   public EnderecoPessoa removeListaEnderecoPessoas(EnderecoPessoa enderecoPessoa) {
     getListaEnderecoPessoas().remove(enderecoPessoa);
     enderecoPessoa.setPessoa(null);
 
     return enderecoPessoa;
   }
 
   public List<HistoricoEstoque> getListaHistoricoEstoque() {
     return this.historicoEstoques;
   }
 
   public void setListaHistoricoEstoque(List<HistoricoEstoque> historicoEstoques) {
     this.historicoEstoques = historicoEstoques;
   }
 
   public HistoricoEstoque addListaHistoricoEstoque(HistoricoEstoque historicoEstoque) {
     getListaHistoricoEstoque().add(historicoEstoque);
     historicoEstoque.setPessoa(this);
 
     return historicoEstoque;
   }
 
   public HistoricoEstoque removeListaHistoricoEstoque(HistoricoEstoque historicoEstoque) {
     getListaHistoricoEstoque().remove(historicoEstoque);
     historicoEstoque.setPessoa(null);
 
     return historicoEstoque;
   }
 
   public List<Pacote> getListaPacotes() {
     return this.pacotes;
   }
 
   public void setListaPacotes(List<Pacote> pacotes) {
     this.pacotes = pacotes;
   }
 
   public Pacote addListaPacotes(Pacote pacote) {
     getListaPacotes().add(pacote);
     pacote.setPessoa(this);
 
     return pacote;
   }
 
   public Pacote removeListaPacotes(Pacote pacote) {
     getListaPacotes().remove(pacote);
     pacote.setPessoa(null);
 
     return pacote;
   }
 }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.Pessoa
 * JD-Core Version:    0.6.0
 */