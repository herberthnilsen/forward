/*    */ package br.com.forward.entity;
/*    */ 
/*    */ import java.math.BigDecimal;
/*    */ import java.sql.Timestamp;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.GenerationType;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.JoinColumn;
/*    */ import javax.persistence.ManyToOne;
/*    */ import javax.persistence.NamedQuery;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ @Entity
/*    */ @Table(name="fwdhstetq")
/*    */ @NamedQuery(name="HistoricoEstoque.findAll", query="SELECT f FROM HistoricoEstoque f")
/*    */ public class HistoricoEstoque
/*    */   implements EntityInterface
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */   @Id
/*    */   @GeneratedValue(strategy=GenerationType.AUTO)
/*    */   @Column(name="fwdhstetqcod", unique=true, nullable=false)
/*    */   private String codigoHistoricoEstoque;
/*    */ 
/*    */   @Column(name="dtahst")
/*    */   private Timestamp dataHistorico;
/*    */ 
/*    */   @Column(precision=10, name="qtdant")
/*    */   private BigDecimal quantidadeAnterior;
/*    */ 
/*    */   @ManyToOne
/*    */   @JoinColumn(name="fwdclbcod", nullable=false)
/*    */   private Pessoa pessoa;
/*    */ 
/*    */   @ManyToOne
/*    */   @JoinColumn(name="fwdetqinscod", nullable=false)
/*    */   private EstoqueInsumo estoqueInsumo;
/*    */ 
/*    */   public String getCodigoHistoricoEstoque()
/*    */   {
/* 52 */     return this.codigoHistoricoEstoque;
/*    */   }
/*    */ 
/*    */   public void setCodigoHistoricoEstoque(String fwdhstetqcod) {
/* 56 */     this.codigoHistoricoEstoque = fwdhstetqcod;
/*    */   }
/*    */ 
/*    */   public Timestamp getDataHistorico() {
/* 60 */     return this.dataHistorico;
/*    */   }
/*    */ 
/*    */   public void setDataHistorico(Timestamp dtahst) {
/* 64 */     this.dataHistorico = dtahst;
/*    */   }
/*    */ 
/*    */   public BigDecimal getQuantidadeAnterior() {
/* 68 */     return this.quantidadeAnterior;
/*    */   }
/*    */ 
/*    */   public void setQuantidadeAnterior(BigDecimal qtdant) {
/* 72 */     this.quantidadeAnterior = qtdant;
/*    */   }
/*    */ 
/*    */   public Pessoa getPessoa() {
/* 76 */     return this.pessoa;
/*    */   }
/*    */ 
/*    */   public void setPessoa(Pessoa pessoa) {
/* 80 */     this.pessoa = pessoa;
/*    */   }
/*    */ 
/*    */   public EstoqueInsumo getEstoqueInsumo() {
/* 84 */     return this.estoqueInsumo;
/*    */   }
/*    */ 
/*    */   public void setEstoqueInsumo(EstoqueInsumo estoqueInsumo) {
/* 88 */     this.estoqueInsumo = estoqueInsumo;
/*    */   }
/*    */ }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.HistoricoEstoque
 * JD-Core Version:    0.6.0
 */