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
/*    */ @Table(name="fwdinspct")
/*    */ @NamedQuery(name="InsumoPacote.findAll", query="SELECT f FROM InsumoPacote f")
/*    */ public class InsumoPacote
/*    */   implements EntityInterface
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */   @Id
/*    */   @GeneratedValue(strategy=GenerationType.AUTO)
/*    */   @Column(name="fwdinspctcod", unique=true, nullable=false)
/*    */   private int codigoInsumoPacote;
/*    */ 
/*    */   @ManyToOne
/*    */   @JoinColumn(name="idfwdins", nullable=false)
/*    */   private Insumo insumo;
/*    */ 
/*    */   @ManyToOne
/*    */   @JoinColumn(name="fwdpctcod", nullable=false)
/*    */   private Pacote pacote;
/*    */ 
/*    */   public int getCodigoInsumoPacote()
/*    */   {
/* 43 */     return this.codigoInsumoPacote;
/*    */   }
/*    */ 
/*    */   public void setCodigoInsumoPacote(int fwdinspctcod) {
/* 47 */     this.codigoInsumoPacote = fwdinspctcod;
/*    */   }
/*    */ 
/*    */   public Insumo getInsumo() {
/* 51 */     return this.insumo;
/*    */   }
/*    */ 
/*    */   public void setInsumo(Insumo insumo) {
/* 55 */     this.insumo = insumo;
/*    */   }
/*    */ 
/*    */   public Pacote getPacote() {
/* 59 */     return this.pacote;
/*    */   }
/*    */ 
/*    */   public void setPacote(Pacote pacote) {
/* 63 */     this.pacote = pacote;
/*    */   }
/*    */ }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.InsumoPacote
 * JD-Core Version:    0.6.0
 */