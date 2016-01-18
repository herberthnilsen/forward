/*     */ package br.com.forward.entity;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.NamedQuery;
/*     */ import javax.persistence.OneToMany;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
/*     */ 
/*     */ @Entity
/*     */ @Table(name="fwdpes")
/*     */ @NamedQuery(name="Pessoa.findAll", query="SELECT f FROM Pessoa f")
/*     */ public class Pessoa
/*     */   implements EntityInterface
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */ 
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.AUTO)
/*     */   @Column(name="fwdpescod\t", unique=true, nullable=false)
/*     */   private int codigoPessoa;
/*     */ 
/*     */   @Column(name="cpjcpfpes", nullable=false, precision=10)
/*     */   private BigDecimal cnpjCpfPessoa;
/*     */ 
/*     */   @Column(name="datcad", nullable=false)
/*     */   private Timestamp dataCadastro;
/*     */ 
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   @Column(name="dtansc", nullable=true)
/*     */   private Date dataNascimento;
/*     */ 
/*     */   @Column(name="nompes", nullable=false, length=60)
/*     */   private String nomePessoa;
/*     */ 
/*     */   @Column(name="tippes", nullable=false, length=1)
/*     */   private String tipoPessoa;
/*     */ 
/*     */   @OneToMany(mappedBy="pessoa")
/*     */   private List<Colaborador> colaboradores;
/*     */ 
/*     */   @OneToMany(mappedBy="pessoa")
/*     */   private List<Cliente> cliente;
/*     */ 
/*     */   @OneToMany(mappedBy="colaborador")
/*     */   private List<Cliente> colaborador;
/*     */ 
/*     */   @OneToMany(mappedBy="pessoa")
/*     */   private List<EnderecoPessoa> enderecoPessoas;
/*     */ 
/*     */   @OneToMany(mappedBy="pessoa")
/*     */   private List<HistoricoEstoque> historicoEstoques;
/*     */ 
/*     */   @OneToMany(mappedBy="pessoa")
/*     */   private List<Pacote> pacotes;
/*     */ 
/*     */   public int getCodigoPessoa()
/*     */   {
/*  80 */     return this.codigoPessoa;
/*     */   }
/*     */ 
/*     */   public void setCodigoPessoa(int codigoPessoa) {
/*  84 */     this.codigoPessoa = codigoPessoa;
/*     */   }
/*     */ 
/*     */   public BigDecimal getCpjcpfpes() {
/*  88 */     return this.cnpjCpfPessoa;
/*     */   }
/*     */ 
/*     */   public void setCnpjCpfPessoa(BigDecimal cnpjCpfPessoa) {
/*  92 */     this.cnpjCpfPessoa = cnpjCpfPessoa;
/*     */   }
/*     */ 
/*     */   public Timestamp getDatcad() {
/*  96 */     return this.dataCadastro;
/*     */   }
/*     */ 
/*     */   public void setDataCadastro(Timestamp dataCadastro) {
/* 100 */     this.dataCadastro = dataCadastro;
/*     */   }
/*     */ 
/*     */   public Date getDtansc() {
/* 104 */     return this.dataNascimento;
/*     */   }
/*     */ 
/*     */   public void setDataNascimento(Date dataNascimento) {
/* 108 */     this.dataNascimento = dataNascimento;
/*     */   }
/*     */ 
/*     */   public String getNomePessoa() {
/* 112 */     return this.nomePessoa;
/*     */   }
/*     */ 
/*     */   public void setNomePessoa(String nomePessoa) {
/* 116 */     this.nomePessoa = nomePessoa;
/*     */   }
/*     */ 
/*     */   public String getTipoPessoa() {
/* 120 */     return this.tipoPessoa;
/*     */   }
/*     */ 
/*     */   public void setTipoPessoa(String tipoPessoa) {
/* 124 */     this.tipoPessoa = tipoPessoa;
/*     */   }
/*     */ 
/*     */   public List<Colaborador> getListaColaboradores() {
/* 128 */     return this.colaboradores;
/*     */   }
/*     */ 
/*     */   public void setListaColaboradores(List<Colaborador> fwdclbs) {
/* 132 */     this.colaboradores = fwdclbs;
/*     */   }
/*     */ 
/*     */   public Colaborador addListaColaboradores(Colaborador colaborador) {
/* 136 */     getListaColaboradores().add(colaborador);
/* 137 */     colaborador.setPessoa(this);
/*     */ 
/* 139 */     return colaborador;
/*     */   }
/*     */ 
/*     */   public Colaborador removeListaColaboradores(Colaborador colaborador) {
/* 143 */     getListaColaboradores().remove(colaborador);
/* 144 */     colaborador.setPessoa(null);
/*     */ 
/* 146 */     return colaborador;
/*     */   }
/*     */ 
/*     */   public List<Cliente> getListaClientes() {
/* 150 */     return this.cliente;
/*     */   }
/*     */ 
/*     */   public void setListaClientes(List<Cliente> fwdclts1) {
/* 154 */     this.cliente = fwdclts1;
/*     */   }
/*     */ 
/*     */   public Cliente addListaClientes(Cliente cliente) {
/* 158 */     getListaClientes().add(cliente);
/* 159 */     cliente.setPessoa(this);
/*     */ 
/* 161 */     return cliente;
/*     */   }
/*     */ 
/*     */   public Cliente removeListaCliente(Cliente cliente) {
/* 165 */     getListaClientes().remove(cliente);
/* 166 */     cliente.setPessoa(null);
/*     */ 
/* 168 */     return cliente;
/*     */   }
/*     */ 
/*     */   public List<Cliente> getListaColaborador() {
/* 172 */     return this.colaborador;
/*     */   }
/*     */ 
/*     */   public void setListaColaborador(List<Cliente> colaborador) {
/* 176 */     this.colaborador = colaborador;
/*     */   }
/*     */ 
/*     */   public Cliente addListaColaborador(Cliente colaborador) {
/* 180 */     getListaColaborador().add(colaborador);
/* 181 */     colaborador.setColaborador(this);
/*     */ 
/* 183 */     return colaborador;
/*     */   }
/*     */ 
/*     */   public Cliente removeListaColaborador(Cliente colaborador) {
/* 187 */     getListaColaborador().remove(colaborador);
/* 188 */     colaborador.setColaborador(null);
/*     */ 
/* 190 */     return colaborador;
/*     */   }
/*     */ 
/*     */   public List<EnderecoPessoa> getListaEnderecoPessoas() {
/* 194 */     return this.enderecoPessoas;
/*     */   }
/*     */ 
/*     */   public void setListaEnderecoPessoas(List<EnderecoPessoa> enderecoPessoas) {
/* 198 */     this.enderecoPessoas = enderecoPessoas;
/*     */   }
/*     */ 
/*     */   public EnderecoPessoa addListaEnderecoPessoas(EnderecoPessoa enderecoPessoa) {
/* 202 */     getListaEnderecoPessoas().add(enderecoPessoa);
/* 203 */     enderecoPessoa.setPessoa(this);
/*     */ 
/* 205 */     return enderecoPessoa;
/*     */   }
/*     */ 
/*     */   public EnderecoPessoa removeListaEnderecoPessoas(EnderecoPessoa enderecoPessoa) {
/* 209 */     getListaEnderecoPessoas().remove(enderecoPessoa);
/* 210 */     enderecoPessoa.setPessoa(null);
/*     */ 
/* 212 */     return enderecoPessoa;
/*     */   }
/*     */ 
/*     */   public List<HistoricoEstoque> getListaHistoricoEstoque() {
/* 216 */     return this.historicoEstoques;
/*     */   }
/*     */ 
/*     */   public void setListaHistoricoEstoque(List<HistoricoEstoque> historicoEstoques) {
/* 220 */     this.historicoEstoques = historicoEstoques;
/*     */   }
/*     */ 
/*     */   public HistoricoEstoque addListaHistoricoEstoque(HistoricoEstoque historicoEstoque) {
/* 224 */     getListaHistoricoEstoque().add(historicoEstoque);
/* 225 */     historicoEstoque.setPessoa(this);
/*     */ 
/* 227 */     return historicoEstoque;
/*     */   }
/*     */ 
/*     */   public HistoricoEstoque removeListaHistoricoEstoque(HistoricoEstoque historicoEstoque) {
/* 231 */     getListaHistoricoEstoque().remove(historicoEstoque);
/* 232 */     historicoEstoque.setPessoa(null);
/*     */ 
/* 234 */     return historicoEstoque;
/*     */   }
/*     */ 
/*     */   public List<Pacote> getListaPacotes() {
/* 238 */     return this.pacotes;
/*     */   }
/*     */ 
/*     */   public void setListaPacotes(List<Pacote> pacotes) {
/* 242 */     this.pacotes = pacotes;
/*     */   }
/*     */ 
/*     */   public Pacote addListaPacotes(Pacote pacote) {
/* 246 */     getListaPacotes().add(pacote);
/* 247 */     pacote.setPessoa(this);
/*     */ 
/* 249 */     return pacote;
/*     */   }
/*     */ 
/*     */   public Pacote removeListaPacotes(Pacote pacote) {
/* 253 */     getListaPacotes().remove(pacote);
/* 254 */     pacote.setPessoa(null);
/*     */ 
/* 256 */     return pacote;
/*     */   }
/*     */ }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.Pessoa
 * JD-Core Version:    0.6.0
 */