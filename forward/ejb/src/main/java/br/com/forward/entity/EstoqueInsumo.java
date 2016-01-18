/*     */ package br.com.forward.entity;
/*     */ 
/*     */ import java.math.BigDecimal;
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
/*     */ @Table(name="fwdetqins")
/*     */ @NamedQuery(name="EstoqueInsumo.findAll", query="SELECT f FROM EstoqueInsumo f")
/*     */ public class EstoqueInsumo
/*     */   implements EntityInterface
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */ 
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.AUTO)
/*     */   @Column(name="fwdetqinscod", unique=true, nullable=false)
/*     */   private int codigoEstoqueInsumo;
/*     */ 
/*     */   @Column(name="qtdetq", nullable=false, precision=10)
/*     */   private BigDecimal quantidadeEstoque;
/*     */ 
/*     */   @Column(name="qtdmaxetq", nullable=false, precision=10)
/*     */   private BigDecimal quantidadeMaximaEstoque;
/*     */ 
/*     */   @Column(name="qtdminetq", nullable=false, precision=10)
/*     */   private BigDecimal quantidadeMinimaEstoque;
/*     */ 
/*     */   @ManyToOne
/*     */   @JoinColumn(name="idfwdins", nullable=false)
/*     */   private Insumo insumo;
/*     */ 
/*     */   @OneToMany(mappedBy="estoqueInsumo")
/*     */   private List<HistoricoEstoque> historicoEstoques;
/*     */ 
/*     */   public int getCodigoEstoqueInsumo()
/*     */   {
/*  55 */     return this.codigoEstoqueInsumo;
/*     */   }
/*     */ 
/*     */   public void setCodigoEstoqueInsumo(int fwdetqinscod) {
/*  59 */     this.codigoEstoqueInsumo = fwdetqinscod;
/*     */   }
/*     */ 
/*     */   public BigDecimal getQuantidadeEstoque() {
/*  63 */     return this.quantidadeEstoque;
/*     */   }
/*     */ 
/*     */   public void setQuantidadeEstoque(BigDecimal qtdetq) {
/*  67 */     this.quantidadeEstoque = qtdetq;
/*     */   }
/*     */ 
/*     */   public BigDecimal getQuantidadeMaximaEstoque() {
/*  71 */     return this.quantidadeMaximaEstoque;
/*     */   }
/*     */ 
/*     */   public void setQuantidadeMaximaEstoque(BigDecimal qtdmaxetq) {
/*  75 */     this.quantidadeMaximaEstoque = qtdmaxetq;
/*     */   }
/*     */ 
/*     */   public BigDecimal getQuantidadeMinimaEstoque() {
/*  79 */     return this.quantidadeMinimaEstoque;
/*     */   }
/*     */ 
/*     */   public void setQuantidadeMinimaEstoque(BigDecimal qtdminetq) {
/*  83 */     this.quantidadeMinimaEstoque = qtdminetq;
/*     */   }
/*     */ 
/*     */   public Insumo getInsumo() {
/*  87 */     return this.insumo;
/*     */   }
/*     */ 
/*     */   public void setInsumo(Insumo insumo) {
/*  91 */     this.insumo = insumo;
/*     */   }
/*     */ 
/*     */   public List<HistoricoEstoque> getListaHistoricoEstoque() {
/*  95 */     return this.historicoEstoques;
/*     */   }
/*     */ 
/*     */   public void setListaHistoricoEstoque(List<HistoricoEstoque> historicoEstoques) {
/*  99 */     this.historicoEstoques = historicoEstoques;
/*     */   }
/*     */ 
/*     */   public HistoricoEstoque addListaHistoricoEstoque(HistoricoEstoque historicoEstoque) {
/* 103 */     getListaHistoricoEstoque().add(historicoEstoque);
/* 104 */     historicoEstoque.setEstoqueInsumo(this);
/*     */ 
/* 106 */     return historicoEstoque;
/*     */   }
/*     */ 
/*     */   public HistoricoEstoque removeListaHistoricoEstoque(HistoricoEstoque historicoEstoque) {
/* 110 */     getListaHistoricoEstoque().remove(historicoEstoque);
/* 111 */     historicoEstoque.setEstoqueInsumo(null);
/*     */ 
/* 113 */     return historicoEstoque;
/*     */   }
/*     */ }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.EstoqueInsumo
 * JD-Core Version:    0.6.0
 */