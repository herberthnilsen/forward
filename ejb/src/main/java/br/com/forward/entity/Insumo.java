/*     */ package br.com.forward.entity;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.List;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.NamedQuery;
/*     */ import javax.persistence.OneToMany;
/*     */ import javax.persistence.Table;
/*     */ 
/*     */ @Entity
/*     */ @Table(name="fwdins")
/*     */ @NamedQuery(name="Insumo.findAll", query="SELECT f FROM Insumo f")
/*     */ public class Insumo
/*     */   implements EntityInterface
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */ 
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.AUTO)
/*     */   @Column(name="idfwdins", unique=true, nullable=false)
/*     */   private int codigoInsumo;
/*     */ 
/*     */   @Column(name="dscins", length=200)
/*     */   private String descricaoInsumo;
/*     */ 
/*     */   @Column(name="dtacad", nullable=false)
/*     */   private Timestamp dataCadastro;
/*     */ 
/*     */   @Column(name="nomins", nullable=false, length=45)
/*     */   private String nomeInsumo;
/*     */ 
/*     */   @Column(precision=10, name="numsre")
/*     */   private BigDecimal numeroSerie;
/*     */ 
/*     */   @Column(precision=9, scale=2, name="vlrmrc")
/*     */   private BigDecimal valorMercado;
/*     */ 
/*     */   @Column(precision=9, scale=2, name="vlrvnd")
/*     */   private BigDecimal valorVenda;
/*     */ 
/*     */   @OneToMany(mappedBy="insumo")
/*     */   private List<AlocacaoInsumo> alocacaoInsumos;
/*     */ 
/*     */   @OneToMany(mappedBy="insumo")
/*     */   private List<EstoqueInsumo> estoqueInsumos;
/*     */ 
/*     */   @ManyToOne
/*     */   @JoinColumn(name="fwdcatinscod", nullable=false)
/*     */   private CategoriaInsumo categoriaInsumo;
/*     */ 
/*     */   @ManyToOne
/*     */   @JoinColumn(name="fwdundcod", nullable=false)
/*     */   private Unidade unidade;
/*     */ 
/*     */   @OneToMany(mappedBy="insumo")
/*     */   private List<InsumoPacote> insumoPacotes;
/*     */ 
/*     */   @OneToMany(mappedBy="insumo")
/*     */   private List<SubItemInsumo> subItens;
/*     */ 
/*     */   public int getCodigoInsumo()
/*     */   {
/*  81 */     return this.codigoInsumo;
/*     */   }
/*     */ 
/*     */   public void setCodigoInsumo(int codigoInsumo) {
/*  85 */     this.codigoInsumo = codigoInsumo;
/*     */   }
/*     */ 
/*     */   public String getDescricaoInsumo() {
/*  89 */     return this.descricaoInsumo;
/*     */   }
/*     */ 
/*     */   public void setDescricaoInsumo(String descricaoInsumo) {
/*  93 */     this.descricaoInsumo = descricaoInsumo;
/*     */   }
/*     */ 
/*     */   public Timestamp getDataCadastro() {
/*  97 */     return this.dataCadastro;
/*     */   }
/*     */ 
/*     */   public void setDataCadastro(Timestamp dataCadastro) {
/* 101 */     this.dataCadastro = dataCadastro;
/*     */   }
/*     */ 
/*     */   public String getNomeInsumo() {
/* 105 */     return this.nomeInsumo;
/*     */   }
/*     */ 
/*     */   public void setNomeInsumo(String nomeInsumo) {
/* 109 */     this.nomeInsumo = nomeInsumo;
/*     */   }
/*     */ 
/*     */   public BigDecimal getNumeroSerie() {
/* 113 */     return this.numeroSerie;
/*     */   }
/*     */ 
/*     */   public void setNumeroSerie(BigDecimal numeroSerie) {
/* 117 */     this.numeroSerie = numeroSerie;
/*     */   }
/*     */ 
/*     */   public BigDecimal getValorMercado() {
/* 121 */     return this.valorMercado;
/*     */   }
/*     */ 
/*     */   public void setValorMercado(BigDecimal vlrmrc) {
/* 125 */     this.valorMercado = vlrmrc;
/*     */   }
/*     */ 
/*     */   public BigDecimal getValorVenda() {
/* 129 */     return this.valorVenda;
/*     */   }
/*     */ 
/*     */   public void setValorVenda(BigDecimal vlrvnd) {
/* 133 */     this.valorVenda = vlrvnd;
/*     */   }
/*     */ 
/*     */   public List<AlocacaoInsumo> getListaAlocacaoInsumo() {
/* 137 */     return this.alocacaoInsumos;
/*     */   }
/*     */ 
/*     */   public void setListaAlocacaoInsumo(List<AlocacaoInsumo> alocacaoInsumos) {
/* 141 */     this.alocacaoInsumos = alocacaoInsumos;
/*     */   }
/*     */ 
/*     */   public AlocacaoInsumo addListaAlocacaoInsumo(AlocacaoInsumo alocacaoInsumo) {
/* 145 */     getListaAlocacaoInsumo().add(alocacaoInsumo);
/* 146 */     alocacaoInsumo.setInsumo(this);
/*     */ 
/* 148 */     return alocacaoInsumo;
/*     */   }
/*     */ 
/*     */   public AlocacaoInsumo removeListaAlocacaoInsumo(AlocacaoInsumo alocacaoInsumo) {
/* 152 */     getListaAlocacaoInsumo().remove(alocacaoInsumo);
/* 153 */     alocacaoInsumo.setInsumo(null);
/*     */ 
/* 155 */     return alocacaoInsumo;
/*     */   }
/*     */ 
/*     */   public List<EstoqueInsumo> getListaEstoqueInsumo() {
/* 159 */     return this.estoqueInsumos;
/*     */   }
/*     */ 
/*     */   public void setListaEstoqueInsumo(List<EstoqueInsumo> estoqueInsumos) {
/* 163 */     this.estoqueInsumos = estoqueInsumos;
/*     */   }
/*     */ 
/*     */   public EstoqueInsumo addListaEstoqueInsumo(EstoqueInsumo estoqueInsumo) {
/* 167 */     getListaEstoqueInsumo().add(estoqueInsumo);
/* 168 */     estoqueInsumo.setInsumo(this);
/*     */ 
/* 170 */     return estoqueInsumo;
/*     */   }
/*     */ 
/*     */   public EstoqueInsumo removeListaEstoqueInsumo(EstoqueInsumo estoqueInsumo) {
/* 174 */     getListaEstoqueInsumo().remove(estoqueInsumo);
/* 175 */     estoqueInsumo.setInsumo(null);
/*     */ 
/* 177 */     return estoqueInsumo;
/*     */   }
/*     */ 
/*     */   public CategoriaInsumo getCategoriaInsumo() {
/* 181 */     return this.categoriaInsumo;
/*     */   }
/*     */ 
/*     */   public void setCategoriaInsumo(CategoriaInsumo categoriaInsumo) {
/* 185 */     this.categoriaInsumo = categoriaInsumo;
/*     */   }
/*     */ 
/*     */   public Unidade getUnidade() {
/* 189 */     return this.unidade;
/*     */   }
/*     */ 
/*     */   public void setUnidade(Unidade unidade) {
/* 193 */     this.unidade = unidade;
/*     */   }
/*     */ 
/*     */   public List<InsumoPacote> getListaInsumoPacote() {
/* 197 */     return this.insumoPacotes;
/*     */   }
/*     */ 
/*     */   public void setListaInsumoPacote(List<InsumoPacote> insumoPacotes) {
/* 201 */     this.insumoPacotes = insumoPacotes;
/*     */   }
/*     */ 
/*     */   public InsumoPacote addListaInsumoPacote(InsumoPacote insumoPacote) {
/* 205 */     getListaInsumoPacote().add(insumoPacote);
/* 206 */     insumoPacote.setInsumo(this);
/*     */ 
/* 208 */     return insumoPacote;
/*     */   }
/*     */ 
/*     */   public InsumoPacote removeListaInsumoPacote(InsumoPacote insumoPacote) {
/* 212 */     getListaInsumoPacote().remove(insumoPacote);
/* 213 */     insumoPacote.setInsumo(null);
/*     */ 
/* 215 */     return insumoPacote;
/*     */   }
/*     */ }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.Insumo
 * JD-Core Version:    0.6.0
 */