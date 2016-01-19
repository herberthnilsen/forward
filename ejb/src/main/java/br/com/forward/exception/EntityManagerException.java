/*    */ package br.com.forward.exception;
/*    */ 
/*    */ public class EntityManagerException extends Exception
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String detail;
/*    */ 
/*    */   public EntityManagerException(String message)
/*    */   {
/*  9 */     super(message);
/*    */   }
/*    */ 
/*    */   public EntityManagerException(String message, Throwable cause) {
/* 13 */     super(message, cause);
/*    */   }
/*    */ 
/*    */   public EntityManagerException(String message, String detail) {
/* 17 */     super(message);
/* 18 */     this.detail = detail;
/*    */   }
/*    */ 
/*    */   public EntityManagerException(String message, String detail, Throwable cause) {
/* 22 */     super(message, cause);
/* 23 */     this.detail = detail;
/*    */   }
/*    */ 
/*    */   public String getDetail() {
/* 27 */     return this.detail;
/*    */   }
/*    */ }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.exception.EntityManagerException
 * JD-Core Version:    0.6.0
 */