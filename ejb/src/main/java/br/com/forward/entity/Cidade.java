/*    */ package br.com.forward.entity;
/*    */ 
/*    */ import java.util.List;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.GenerationType;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.JoinColumn;
/*    */ import javax.persistence.ManyToOne;
/*    */ import javax.persistence.NamedQuery;
/*    */ import javax.persistence.OneToMany;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ @Entity
/*    */ @Table(name="fwdcdd")
/*    */ @NamedQuery(name="Cidade.findAll", query="SELECT f FROM Cidade f")
/*    */ public class Cidade
/*    */   implements EntityInterface
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */   @Id
/*    */   @GeneratedValue(strategy=GenerationType.AUTO)
/*    */   @Column(name="fwdcddcod", unique=true, nullable=false)
/*    */   private int codigoCidade;
/*    */ 
/*    */   @Column(name="nomcdd", nullable=false, length=80)
/*    */   private String nomeCidade;
/*    */ 
/*    */   @ManyToOne
/*    */   @JoinColumn(name="fwdestcod", nullable=false)
/*    */   private Estado estado;
/*    */ 
/*    */   @OneToMany(mappedBy="cidade")
/*    */   private List<Logradouro> logradouros;
/*    */ 
/*    */   public int getCodigoCidade()
/*    */   {
/* 48 */     return this.codigoCidade;
/*    */   }
/*    */ 
/*    */   public void setCodigoCidade(int fwdcddcod) {
/* 52 */     this.codigoCidade = fwdcddcod;
/*    */   }
/*    */ 
/*    */   public String getNomeCidade() {
/* 56 */     return this.nomeCidade;
/*    */   }
/*    */ 
/*    */   public void setNomeCidade(String nomcdd) {
/* 60 */     this.nomeCidade = nomcdd;
/*    */   }
/*    */ 
/*    */   public Estado getEstado() {
/* 64 */     return this.estado;
/*    */   }
/*    */ 
/*    */   public void setEstado(Estado estado) {
/* 68 */     this.estado = estado;
/*    */   }
/*    */ 
/*    */   public List<Logradouro> getListaLogradouro() {
/* 72 */     return this.logradouros;
/*    */   }
/*    */ 
/*    */   public void setListaLogradouro(List<Logradouro> logradouros) {
/* 76 */     this.logradouros = logradouros;
/*    */   }
/*    */ 
/*    */   public Logradouro addListaLogradouro(Logradouro logradouro) {
/* 80 */     getListaLogradouro().add(logradouro);
/* 81 */     logradouro.setCidade(this);
/*    */ 
/* 83 */     return logradouro;
/*    */   }
/*    */ 
/*    */   public Logradouro removeListaLogradouro(Logradouro logradouro) {
/* 87 */     getListaLogradouro().remove(logradouro);
/* 88 */     logradouro.setCidade(null);
/*    */ 
/* 90 */     return logradouro;
/*    */   }
/*    */ }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.Cidade
 * JD-Core Version:    0.6.0
 */