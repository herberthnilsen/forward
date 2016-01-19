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
/*    */ @Table(name="fwdund")
/*    */ @NamedQuery(name="Unidade.findAll", query="SELECT f FROM Unidade f")
/*    */ public class Unidade
/*    */   implements EntityInterface
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */   @Id
/*    */   @GeneratedValue(strategy=GenerationType.AUTO)
/*    */   @Column(name="fwdundcod", unique=true, nullable=false)
/*    */   private int codigoUnidade;
/*    */ 
/*    */   @Column(name="nomund", length=45)
/*    */   private String nomeUnidade;
/*    */ 
/*    */   @Column(name="sglund", length=3)
/*    */   private String siglaUnidade;
/*    */ 
/*    */   @OneToMany(mappedBy="unidade")
/*    */   private List<Insumo> insumos;
/*    */ 
/*    */   public int getCodigoUnidade()
/*    */   {
/* 44 */     return this.codigoUnidade;
/*    */   }
/*    */ 
/*    */   public void setCodigoUnidade(int fwdundcod) {
/* 48 */     this.codigoUnidade = fwdundcod;
/*    */   }
/*    */ 
/*    */   public String getNomeUnidade() {
/* 52 */     return this.nomeUnidade;
/*    */   }
/*    */ 
/*    */   public void setNomeUnidade(String nomund) {
/* 56 */     this.nomeUnidade = nomund;
/*    */   }
/*    */ 
/*    */   public String getSiglaUnidade() {
/* 60 */     return this.siglaUnidade;
/*    */   }
/*    */ 
/*    */   public void setSiglaUnidade(String sglund) {
/* 64 */     this.siglaUnidade = sglund;
/*    */   }
/*    */ 
/*    */   public List<Insumo> getListaInsumos() {
/* 68 */     return this.insumos;
/*    */   }
/*    */ 
/*    */   public void setListaInsumos(List<Insumo> insumos) {
/* 72 */     this.insumos = insumos;
/*    */   }
/*    */ 
/*    */   public Insumo addListaInsumos(Insumo insumo) {
/* 76 */     getListaInsumos().add(insumo);
/* 77 */     insumo.setUnidade(this);
/*    */ 
/* 79 */     return insumo;
/*    */   }
/*    */ 
/*    */   public Insumo removeListaInsumos(Insumo insumo) {
/* 83 */     getListaInsumos().remove(insumo);
/* 84 */     insumo.setUnidade(null);
/*    */ 
/* 86 */     return insumo;
/*    */   }
/*    */ }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.Unidade
 * JD-Core Version:    0.6.0
 */