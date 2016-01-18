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
/*    */ @Table(name="fwdtiplgd")
/*    */ @NamedQuery(name="TipoLogradouro.findAll", query="SELECT f FROM TipoLogradouro f")
/*    */ public class TipoLogradouro
/*    */   implements EntityInterface
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */   @Id
/*    */   @GeneratedValue(strategy=GenerationType.AUTO)
/*    */   @Column(name="fwdtiplgdcod", unique=true, nullable=false)
/*    */   private int codigoTipoLogradouro;
/*    */ 
/*    */   @Column(name="nomtiplgd", nullable=false, length=45)
/*    */   private String nomeTipoLogradouro;
/*    */ 
/*    */   @Column(name="sgltiplgd", length=5)
/*    */   private String siglaTipoLogradouro;
/*    */ 
/*    */   @OneToMany(mappedBy="tipoLogradouro")
/*    */   private List<Logradouro> logradouros;
/*    */ 
/*    */   public int getCodigoTipoLogradouro()
/*    */   {
/* 44 */     return this.codigoTipoLogradouro;
/*    */   }
/*    */ 
/*    */   public void setCodigoTipoLogradouro(int fwdtiplgdcod) {
/* 48 */     this.codigoTipoLogradouro = fwdtiplgdcod;
/*    */   }
/*    */ 
/*    */   public String getNomeTipoLogradouro() {
/* 52 */     return this.nomeTipoLogradouro;
/*    */   }
/*    */ 
/*    */   public void setNomeTipoLogradouro(String nomtiplgd) {
/* 56 */     this.nomeTipoLogradouro = nomtiplgd;
/*    */   }
/*    */ 
/*    */   public String getSiglaTipoLogradouro() {
/* 60 */     return this.siglaTipoLogradouro;
/*    */   }
/*    */ 
/*    */   public void setSiglaTipoLogradouro(String sgltiplgd) {
/* 64 */     this.siglaTipoLogradouro = sgltiplgd;
/*    */   }
/*    */ 
/*    */   public List<Logradouro> getListaLogradouro() {
/* 68 */     return this.logradouros;
/*    */   }
/*    */ 
/*    */   public void setListaLogradouro(List<Logradouro> logradouros) {
/* 72 */     this.logradouros = logradouros;
/*    */   }
/*    */ 
/*    */   public Logradouro addListaLogradouro(Logradouro logradouro) {
/* 76 */     getListaLogradouro().add(logradouro);
/* 77 */     logradouro.setTipoLogradouro(this);
/*    */ 
/* 79 */     return logradouro;
/*    */   }
/*    */ 
/*    */   public Logradouro removeListaLogradouro(Logradouro logradouro) {
/* 83 */     getListaLogradouro().remove(logradouro);
/* 84 */     logradouro.setTipoLogradouro(null);
/*    */ 
/* 86 */     return logradouro;
/*    */   }
/*    */ }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.TipoLogradouro
 * JD-Core Version:    0.6.0
 */