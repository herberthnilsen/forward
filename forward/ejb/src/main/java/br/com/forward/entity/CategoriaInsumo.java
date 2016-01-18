/*    */ package br.com.forward.entity;
/*    */ 
/*    */ import java.util.List;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.GenerationType;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.NamedQuery;
/*    */ import javax.persistence.OneToMany;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ @Entity
/*    */ @Table(name="fwdcatins")
/*    */ @NamedQuery(name="CategoriaInsumo.findAll", query="SELECT f FROM CategoriaInsumo f")
/*    */ public class CategoriaInsumo
/*    */   implements EntityInterface
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public static final String NQ_FIND_ALL = "CategoriaInsumo.findAll";
/*    */ 
/*    */   @Id
/*    */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*    */   @Column(name="fwdcatinscod", unique=true, nullable=false)
/*    */   private Integer codigoCategoriaInsumo;
/*    */ 
/*    */   @Column(name="dsccat", length=45)
/*    */   private String descricaoCategoria;
/*    */ 
/*    */   @Column(name="nomcat", nullable=false, length=45)
/*    */   private String nomeCategoria;
/*    */ 
/*    */   @OneToMany(mappedBy="categoriaInsumo")
/*    */   private List<Insumo> insumos;
/*    */ 
/*    */   public Integer getCodigoCategoriaInsumo()
/*    */   {
/* 46 */     return this.codigoCategoriaInsumo;
/*    */   }
/*    */ 
/*    */   public void setCodigoCategoriaInsumo(Integer codigoCategoriaInsumo) {
/* 50 */     this.codigoCategoriaInsumo = codigoCategoriaInsumo;
/*    */   }
/*    */ 
/*    */   public String getDescricaoCategoria() {
/* 54 */     return this.descricaoCategoria;
/*    */   }
/*    */ 
/*    */   public void setDescricaoCategoria(String dsccat) {
/* 58 */     this.descricaoCategoria = dsccat;
/*    */   }
/*    */ 
/*    */   public String getNomeCategoria() {
/* 62 */     return this.nomeCategoria;
/*    */   }
/*    */ 
/*    */   public void setNomeCategoria(String nomeCategoria) {
/* 66 */     this.nomeCategoria = nomeCategoria;
/*    */   }
/*    */ 
/*    */   public List<Insumo> getListaInsumos() {
/* 70 */     return this.insumos;
/*    */   }
/*    */ 
/*    */   public void setListaInsumos(List<Insumo> insumos) {
/* 74 */     this.insumos = insumos;
/*    */   }
/*    */ 
/*    */   public Insumo addListaInsumos(Insumo insumo) {
/* 78 */     getListaInsumos().add(insumo);
/* 79 */     insumo.setCategoriaInsumo(this);
/*    */ 
/* 81 */     return insumo;
/*    */   }
/*    */ 
/*    */   public Insumo removeListaInsumos(Insumo insumo) {
/* 85 */     getListaInsumos().remove(insumo);
/* 86 */     insumo.setCategoriaInsumo(null);
/*    */ 
/* 88 */     return insumo;
/*    */   }
/*    */ }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.CategoriaInsumo
 * JD-Core Version:    0.6.0
 */