/*    */ package br.com.forward.common;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class CategoriaInsumoVO
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 4697695075879918148L;
/*    */   private Integer codigoCategoriaInsumo;
/* 14 */   private String nomeCategoria = new String();
/*    */ 
/* 16 */   private String descricaoCategoria = new String();
/*    */ 
/*    */   public Integer getCodigoCategoria() {
/* 19 */     return this.codigoCategoriaInsumo;
/*    */   }
/*    */ 
/*    */   public void setCodigoCategoria(Integer codigoCategoria) {
/* 23 */     this.codigoCategoriaInsumo = codigoCategoria;
/*    */   }
/*    */ 
/*    */   public String getNomeCategoria()
/*    */   {
/* 28 */     return this.nomeCategoria;
/*    */   }
/*    */ 
/*    */   public void setNomeCategoria(String nomeCategoria) {
/* 32 */     this.nomeCategoria = nomeCategoria;
/*    */   }
/*    */ 
/*    */   public String getDescricaoCategoria() {
/* 36 */     return this.descricaoCategoria;
/*    */   }
/*    */ 
/*    */   public void setDescricaoCategoria(String descricaoCategoria) {
/* 40 */     this.descricaoCategoria = descricaoCategoria;
/*    */   }
/*    */ }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.common.CategoriaInsumoVO
 * JD-Core Version:    0.6.0
 */