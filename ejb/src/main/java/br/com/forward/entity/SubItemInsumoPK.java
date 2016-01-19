/*    */ package br.com.forward.entity;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Embeddable;
/*    */ 
/*    */ @Embeddable
/*    */ public class SubItemInsumoPK
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -3673490431085735991L;
/*    */ 
/*    */   @Column(name="idfwdinspai")
/*    */   private Integer codigoInsumoPai;
/*    */ 
/*    */   @Column(name="subfwdinsid")
/*    */   private Integer codigoSubInsumo;
/*    */ 
/*    */   public Integer getCodigoInsumoPai()
/*    */   {
/* 20 */     return this.codigoInsumoPai;
/*    */   }
/*    */ 
/*    */   public void setCodigoInsumoPai(Integer codigoInsumoPai) {
/* 24 */     this.codigoInsumoPai = codigoInsumoPai;
/*    */   }
/*    */ 
/*    */   public Integer getCodigoSubInsumo() {
/* 28 */     return this.codigoSubInsumo;
/*    */   }
/*    */ 
/*    */   public void setCodigoSubInsumo(Integer codigoSubInsumo) {
/* 32 */     this.codigoSubInsumo = codigoSubInsumo;
/*    */   }
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 37 */     int prime = 31;
/* 38 */     int result = 1;
/* 39 */     result = 31 * result + (this.codigoInsumoPai == null ? 0 : this.codigoInsumoPai.hashCode());
/* 40 */     result = 31 * result + (this.codigoSubInsumo == null ? 0 : this.codigoSubInsumo.hashCode());
/* 41 */     return result;
/*    */   }
/*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 46 */     if (this == obj)
/* 47 */       return true;
/* 48 */     if (obj == null)
/* 49 */       return false;
/* 50 */     if (getClass() != obj.getClass())
/* 51 */       return false;
/* 52 */     SubItemInsumoPK other = (SubItemInsumoPK)obj;
/* 53 */     if (this.codigoInsumoPai == null) {
/* 54 */       if (other.codigoInsumoPai != null)
/* 55 */         return false;
/* 56 */     } else if (!this.codigoInsumoPai.equals(other.codigoInsumoPai))
/* 57 */       return false;
/* 58 */     if (this.codigoSubInsumo == null) {
/* 59 */       if (other.codigoSubInsumo != null)
/* 60 */         return false;
/* 61 */     } else if (!this.codigoSubInsumo.equals(other.codigoSubInsumo))
/* 62 */       return false;
/* 63 */     return true;
/*    */   }
/*    */ }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.SubItemInsumoPK
 * JD-Core Version:    0.6.0
 */