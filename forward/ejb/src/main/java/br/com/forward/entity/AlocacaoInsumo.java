/*    */ package br.com.forward.entity;
/*    */ 
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
/*    */ @Table(name="fwdalcins")
/*    */ @NamedQuery(name="AlocacaoInsumo.findAll", query="SELECT f FROM AlocacaoInsumo f")
/*    */ public class AlocacaoInsumo
/*    */   implements EntityInterface
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */   @Id
/*    */   @GeneratedValue(strategy=GenerationType.AUTO)
/*    */   @Column(unique=true, nullable=false)
/*    */   private int codigoAlocacaoInsumo;
/*    */ 
/*    */   @ManyToOne
/*    */   @JoinColumn(name="fwdevtcod", nullable=false)
/*    */   private Evento evento;
/*    */ 
/*    */   @ManyToOne
/*    */   @JoinColumn(name="idfwdins", nullable=false)
/*    */   private Insumo insumo;
/*    */ 
/*    */   @ManyToOne
/*    */   @JoinColumn(name="fwdsttalccod", nullable=false)
/*    */   private StatusAlocacao statusAlocacao;
/*    */ 
/*    */   public int getCodigoAlocacaoInsumo()
/*    */   {
/* 48 */     return this.codigoAlocacaoInsumo;
/*    */   }
/*    */ 
/*    */   public void setCodigoAlocacaoInsumo(int codigoAlocacaoInsumo) {
/* 52 */     this.codigoAlocacaoInsumo = codigoAlocacaoInsumo;
/*    */   }
/*    */ 
/*    */   public Evento getEvento() {
/* 56 */     return this.evento;
/*    */   }
/*    */ 
/*    */   public void setEvento(Evento evento) {
/* 60 */     this.evento = evento;
/*    */   }
/*    */ 
/*    */   public Insumo getInsumo() {
/* 64 */     return this.insumo;
/*    */   }
/*    */ 
/*    */   public void setInsumo(Insumo insumo) {
/* 68 */     this.insumo = insumo;
/*    */   }
/*    */ 
/*    */   public StatusAlocacao getStatusAlocacao() {
/* 72 */     return this.statusAlocacao;
/*    */   }
/*    */ 
/*    */   public void setStatusAlocacao(StatusAlocacao statusAlocacao) {
/* 76 */     this.statusAlocacao = statusAlocacao;
/*    */   }
/*    */ }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.AlocacaoInsumo
 * JD-Core Version:    0.6.0
 */