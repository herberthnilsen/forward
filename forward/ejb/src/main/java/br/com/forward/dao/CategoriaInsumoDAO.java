/*    */ package br.com.forward.dao;
/*    */ 
/*    */ import br.com.forward.common.CategoriaInsumoVO;
/*    */ import br.com.forward.entity.CategoriaInsumo;
/*    */ import br.com.forward.exception.EntityManagerException;
/*    */ import br.com.forward.util.Utils;
/*    */ import java.util.List;
/*    */ import javax.persistence.EntityManager;
/*    */ import javax.persistence.Query;
/*    */ import org.apache.log4j.LogManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class CategoriaInsumoDAO extends GenericEntityManager
/*    */ {
/* 20 */   public static final Logger LOGGER = LogManager.getLogger(CategoriaInsumoDAO.class);
/*    */ 
/*    */   public CategoriaInsumoDAO(EntityManager entityManager) {
/* 23 */     super(entityManager);
/*    */   }
/*    */ 
/*    */   public List<CategoriaInsumo> getListaCategoriaInsumos() throws EntityManagerException
/*    */   {
/* 28 */     LOGGER.info("CategoriaInsumoDAO.getListaCategoriaInsumos - INICIO -  PARAMETROS");
/*    */ 
/* 30 */     Query query = getEntityManager().createNamedQuery("CategoriaInsumo.findAll");
/*    */ 
/* 32 */     List resultList = query.getResultList();
/*    */ 
/* 34 */     LOGGER.info("CategoriaInsumoDAO.getListaCategoriaInsumos - FIM");
/* 35 */     return resultList;
/*    */   }
/*    */ 
/*    */   public List<CategoriaInsumo> getListaCategoriaInsumos(CategoriaInsumoVO categoriaInsumo) throws EntityManagerException
/*    */   {
/* 40 */     LOGGER.info("CategoriaInsumoDAO.getListaCategoriaInsumos - INICIO -  PARAMETROS");
/*    */ 
/* 42 */     Query query = getEntityManager().createNamedQuery("CategoriaInsumo.findAll");
/*    */ 
/* 44 */     List resultList = query.getResultList();
/*    */ 
/* 46 */     LOGGER.info("CategoriaInsumoDAO.getListaCategoriaInsumos - FIM");
/* 47 */     return resultList;
/*    */   }
/*    */ 
/*    */   public void salvar(CategoriaInsumo categoriaInsumo) throws EntityManagerException
/*    */   {
/* 52 */     LOGGER.info("CategoriaInsumoDAO.salvar - INICIO -  PARAMETROS: " + categoriaInsumo.toString());
/* 53 */     if (!Utils.isObjectNull(categoriaInsumo.getCodigoCategoriaInsumo()).booleanValue())
/*    */     {
/* 55 */       merge(categoriaInsumo);
/*    */     }
/*    */     else
/*    */     {
/* 59 */       persist(categoriaInsumo);
/*    */     }
/*    */ 
/* 63 */     LOGGER.info("CategoriaInsumoDAO.salvar - FIM");
/*    */   }
/*    */ 
/*    */   public void excluir(CategoriaInsumo categoriaInsumo) throws EntityManagerException {
/* 67 */     LOGGER.info("CategoriaInsumoDAO.excluir - INICIO");
/*    */ 
/* 69 */     categoriaInsumo = (CategoriaInsumo)find(CategoriaInsumo.class, categoriaInsumo.getCodigoCategoriaInsumo());
/*    */ 
/* 71 */     remove(categoriaInsumo);
/*    */ 
/* 73 */     LOGGER.info("CategoriaInsumoDAO.excluir - FIM");
/*    */   }
/*    */ }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.dao.CategoriaInsumoDAO
 * JD-Core Version:    0.6.0
 */