/*    */ package br.com.forward.bean;
/*    */ 
/*    */ import br.com.forward.common.CategoriaInsumoVO;
/*    */ import java.util.List;
/*    */ import javax.annotation.PostConstruct;
/*    */ 
/*    */ public class CategoriaInsumosBean
/*    */ {
/*    */   private List<CategoriaInsumoVO> resultList;
/*    */ 
/*    */   public List<CategoriaInsumoVO> getResultList()
/*    */   {
/* 14 */     return this.resultList;
/*    */   }
/*    */ 
/*    */   @PostConstruct
/*    */   public void init() {
/* 20 */     pesquisar();
/*    */   }
/*    */ 
/*    */   public void pesquisar()
/*    */   {
/*    */   }
/*    */ 
/*    */   public void setResultList(List<CategoriaInsumoVO> resultList)
/*    */   {
/* 32 */     this.resultList = resultList;
/*    */   }
/*    */ }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-web.war\WEB-INF\classes\
 * Qualified Name:     br.com.forward.bean.CategoriaInsumosBean
 * JD-Core Version:    0.6.0
 */