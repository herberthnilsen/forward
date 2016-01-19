/*    */ package br.com.forward.entity;
/*    */ 
/*    */ import java.math.BigInteger;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Embeddable;
/*    */ 
/*    */ @Embeddable
/*    */ public class PacoteEventoPK
/*    */   implements EntityInterface
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */   @Column(name="fwdpctcod", insertable=false, updatable=false, unique=true, nullable=false)
/*    */   private int codigoPacote;
/*    */ 
/*    */   @Column(name="fwdevtcod", insertable=false, updatable=false, unique=true, nullable=false)
/*    */   private BigInteger codigoEvento;
/*    */ 
/*    */   public int getCodigoPacote()
/*    */   {
/* 26 */     return this.codigoPacote;
/*    */   }
/*    */   public void setCodigoPacote(int codigoPacote) {
/* 29 */     this.codigoPacote = codigoPacote;
/*    */   }
/*    */   public BigInteger getCodigoEvento() {
/* 32 */     return this.codigoEvento;
/*    */   }
/*    */   public void setCodigoEvento(BigInteger codigoEvento) {
/* 35 */     this.codigoEvento = codigoEvento;
/*    */   }
/*    */ 
/*    */   public boolean equals(Object other) {
/* 39 */     if (this == other) {
/* 40 */       return true;
/*    */     }
/* 42 */     if (!(other instanceof PacoteEventoPK)) {
/* 43 */       return false;
/*    */     }
/* 45 */     PacoteEventoPK castOther = (PacoteEventoPK)other;
/* 46 */     return 
/* 47 */       (this.codigoPacote == castOther.codigoPacote) && 
/* 48 */       (this.codigoEvento.equals(castOther.codigoEvento));
/*    */   }
/*    */ 
/*    */   public int hashCode() {
/* 52 */     int prime = 31;
/* 53 */     int hash = 17;
/* 54 */     hash = hash * 31 + this.codigoPacote;
/* 55 */     hash = hash * 31 + this.codigoEvento.hashCode();
/*    */ 
/* 57 */     return hash;
/*    */   }
/*    */ }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.PacoteEventoPK
 * JD-Core Version:    0.6.0
 */