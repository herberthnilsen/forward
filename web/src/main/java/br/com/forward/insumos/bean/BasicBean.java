/*    */ package br.com.forward.insumos.bean;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class BasicBean
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 11 */   protected String flagShowForm = Boolean.FALSE.toString();
/*    */ 
/*    */   public void toogleForm()
/*    */   {
/* 16 */     if (this.flagShowForm.equals(Boolean.TRUE.toString()))
/*    */     {
/* 18 */       this.flagShowForm = Boolean.FALSE.toString();
/*    */     }
/*    */     else
/*    */     {
/* 22 */       this.flagShowForm = Boolean.TRUE.toString();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void showForm()
/*    */   {
/* 30 */     this.flagShowForm = Boolean.TRUE.toString();
/*    */   }
/*    */ 
/*    */   public void hideForm()
/*    */   {
/* 36 */     this.flagShowForm = Boolean.FALSE.toString();
/*    */   }
/*    */ 
/*    */   public String getFlagShowForm()
/*    */   {
/* 41 */     return this.flagShowForm;
/*    */   }
/*    */ 
/*    */   public void setFlagShowForm(Boolean flagShowForm) {
/* 45 */     this.flagShowForm = flagShowForm.toString();
/*    */   }
/*    */ }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-web.war\WEB-INF\classes\
 * Qualified Name:     br.com.forward.insumos.bean.BasicBean
 * JD-Core Version:    0.6.0
 */