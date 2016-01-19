 package br.com.forward.exception;
 
 public class EntityManagerException extends Exception
 {
   private static final long serialVersionUID = 1L;
   private String detail;
 
   public EntityManagerException(String message)
   {
     super(message);
   }
 
   public EntityManagerException(String message, Throwable cause) {
     super(message, cause);
   }
 
   public EntityManagerException(String message, String detail) {
     super(message);
     this.detail = detail;
   }
 
   public EntityManagerException(String message, String detail, Throwable cause) {
     super(message, cause);
     this.detail = detail;
   }
 
   public String getDetail() {
     return this.detail;
   }
 }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.exception.EntityManagerException
 * JD-Core Version:    0.6.0
 */