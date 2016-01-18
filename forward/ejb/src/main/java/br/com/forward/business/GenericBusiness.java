/*    */ package br.com.forward.business;
/*    */ 
/*    */ import br.com.forward.interfaces.business.GenericBusinessLocal;
/*    */ import java.util.logging.LogManager;
/*    */ import javax.persistence.EntityManager;
/*    */ import javax.persistence.PersistenceContext;
/*    */ 
/*    */ public abstract class GenericBusiness
/*    */   implements GenericBusinessLocal
/*    */ {
/* 18 */   public static final LogManager LOGGER = LogManager.getLogManager();
/*    */ 
/*    */   @PersistenceContext(unitName="pu_forward")
/*    */   protected EntityManager entityManager;
/*    */ 
/* 24 */   protected EntityManager getEntityManager() { return this.entityManager; }
/*    */ 
/*    */   protected void setEntityManager(EntityManager entityManager)
/*    */   {
/* 28 */     this.entityManager = entityManager;
/*    */   }
/*    */ }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.business.GenericBusiness
 * JD-Core Version:    0.6.0
 */