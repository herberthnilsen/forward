/*    */ package br.com.forward.entity;
/*    */ 
/*    */ import java.util.List;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.GenerationType;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.NamedQuery;
/*    */ import javax.persistence.OneToMany;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ @Entity
/*    */ @Table(name="fwdsttalc")
/*    */ @NamedQuery(name="StatusAlocacao.findAll", query="SELECT f FROM StatusAlocacao f")
/*    */ public class StatusAlocacao
/*    */   implements EntityInterface
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */   @Id
/*    */   @GeneratedValue(strategy=GenerationType.AUTO)
/*    */   @Column(name="fwdsttalccod", unique=true, nullable=false)
/*    */   private int codigoStatusAlocacao;
/*    */ 
/*    */   @Column(name="nomstt", nullable=false, length=45)
/*    */   private String nomeStatus;
/*    */ 
/*    */   @OneToMany(mappedBy="statusAlocacao")
/*    */   private List<AlocacaoInsumo> alocacaoInsumos;
/*    */ 
/*    */   public int getCodigoStatusAlocacao()
/*    */   {
/* 41 */     return this.codigoStatusAlocacao;
/*    */   }
/*    */ 
/*    */   public void setCodigoStatusAlocacao(int fwdsttalccod) {
/* 45 */     this.codigoStatusAlocacao = fwdsttalccod;
/*    */   }
/*    */ 
/*    */   public String getNomeStatus() {
/* 49 */     return this.nomeStatus;
/*    */   }
/*    */ 
/*    */   public void setNomeStatus(String nomstt) {
/* 53 */     this.nomeStatus = nomstt;
/*    */   }
/*    */ 
/*    */   public List<AlocacaoInsumo> getListaAlocacaoInsumo() {
/* 57 */     return this.alocacaoInsumos;
/*    */   }
/*    */ 
/*    */   public void setListaAlocacaoInsumo(List<AlocacaoInsumo> alocacaoInsumos) {
/* 61 */     this.alocacaoInsumos = alocacaoInsumos;
/*    */   }
/*    */ 
/*    */   public AlocacaoInsumo addListaAlocacaoInsumo(AlocacaoInsumo alocacaoInsumo) {
/* 65 */     getListaAlocacaoInsumo().add(alocacaoInsumo);
/* 66 */     alocacaoInsumo.setStatusAlocacao(this);
/*    */ 
/* 68 */     return alocacaoInsumo;
/*    */   }
/*    */ 
/*    */   public AlocacaoInsumo removeListaAlocacaoInsumo(AlocacaoInsumo alocacaoInsumo) {
/* 72 */     getListaAlocacaoInsumo().remove(alocacaoInsumo);
/* 73 */     alocacaoInsumo.setStatusAlocacao(null);
/*    */ 
/* 75 */     return alocacaoInsumo;
/*    */   }
/*    */ }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.StatusAlocacao
 * JD-Core Version:    0.6.0
 */