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
/*    */ @Table(name="fwdest")
/*    */ @NamedQuery(name="Estado.findAll", query="SELECT f FROM Estado f")
/*    */ public class Estado
/*    */   implements EntityInterface
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */   @Id
/*    */   @GeneratedValue(strategy=GenerationType.AUTO)
/*    */   @Column(name="fwdestcod", unique=true, nullable=false)
/*    */   private int codigoEstado;
/*    */ 
/*    */   @Column(name="nomest", nullable=false, length=45)
/*    */   private String nomeEstado;
/*    */ 
/*    */   @Column(name="sglest", nullable=false, length=2)
/*    */   private String siglaEstado;
/*    */ 
/*    */   @OneToMany(mappedBy="estado")
/*    */   private List<Cidade> cidades;
/*    */ 
/*    */   public int getCodigoEstado()
/*    */   {
/* 44 */     return this.codigoEstado;
/*    */   }
/*    */ 
/*    */   public void setCodigoEstado(int fwdestcod) {
/* 48 */     this.codigoEstado = fwdestcod;
/*    */   }
/*    */ 
/*    */   public String getNomeEstado() {
/* 52 */     return this.nomeEstado;
/*    */   }
/*    */ 
/*    */   public void setNomeEstado(String nomest) {
/* 56 */     this.nomeEstado = nomest;
/*    */   }
/*    */ 
/*    */   public String getSiglaEstado() {
/* 60 */     return this.siglaEstado;
/*    */   }
/*    */ 
/*    */   public void setSiglaEstado(String sglest) {
/* 64 */     this.siglaEstado = sglest;
/*    */   }
/*    */ 
/*    */   public List<Cidade> getListaCidades() {
/* 68 */     return this.cidades;
/*    */   }
/*    */ 
/*    */   public void setListaCidades(List<Cidade> cidades) {
/* 72 */     this.cidades = cidades;
/*    */   }
/*    */ 
/*    */   public Cidade addListaCidades(Cidade cidade) {
/* 76 */     getListaCidades().add(cidade);
/* 77 */     cidade.setEstado(this);
/*    */ 
/* 79 */     return cidade;
/*    */   }
/*    */ 
/*    */   public Cidade removeListaCidades(Cidade cidade) {
/* 83 */     getListaCidades().remove(cidade);
/* 84 */     cidade.setEstado(null);
/*    */ 
/* 86 */     return cidade;
/*    */   }
/*    */ }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.Estado
 * JD-Core Version:    0.6.0
 */