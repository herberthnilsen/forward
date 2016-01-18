/*    */ package br.com.forward.entity;
/*    */ 
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.GenerationType;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.JoinColumn;
/*    */ import javax.persistence.ManyToOne;
/*    */ import javax.persistence.NamedQuery;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ @Entity
/*    */ @Table(name="fwdendpes")
/*    */ @NamedQuery(name="EnderecoPessoa.findAll", query="SELECT f FROM EnderecoPessoa f")
/*    */ public class EnderecoPessoa
/*    */   implements EntityInterface
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */   @Id
/*    */   @GeneratedValue(strategy=GenerationType.AUTO)
/*    */   @Column(name="fwdendpescod", unique=true, nullable=false)
/*    */   private int codigoEnderecoPessoa;
/*    */ 
/*    */   @Column(name="cptend", length=45)
/*    */   private String complementoEndereco;
/*    */ 
/*    */   @Column(nullable=false, name="numend")
/*    */   private int numeroEndereco;
/*    */ 
/*    */   @ManyToOne
/*    */   @JoinColumn(name="fwdlgdcep", nullable=false)
/*    */   private Logradouro logradouro;
/*    */ 
/*    */   @ManyToOne
/*    */   @JoinColumn(name="fwdpescod", nullable=false)
/*    */   private Pessoa pessoa;
/*    */ 
/*    */   public int getCodigoEnderecoPessoa()
/*    */   {
/* 49 */     return this.codigoEnderecoPessoa;
/*    */   }
/*    */ 
/*    */   public void setCodigoEnderecoPessoa(int fwdendpescod) {
/* 53 */     this.codigoEnderecoPessoa = fwdendpescod;
/*    */   }
/*    */ 
/*    */   public String getComplementoEndereco() {
/* 57 */     return this.complementoEndereco;
/*    */   }
/*    */ 
/*    */   public void setComplementoEndereco(String cptend) {
/* 61 */     this.complementoEndereco = cptend;
/*    */   }
/*    */ 
/*    */   public int getNumeroEndereco() {
/* 65 */     return this.numeroEndereco;
/*    */   }
/*    */ 
/*    */   public void setNumeroEndereco(int numend) {
/* 69 */     this.numeroEndereco = numend;
/*    */   }
/*    */ 
/*    */   public Logradouro getLogradouro() {
/* 73 */     return this.logradouro;
/*    */   }
/*    */ 
/*    */   public void setLogradouro(Logradouro logradouro) {
/* 77 */     this.logradouro = logradouro;
/*    */   }
/*    */ 
/*    */   public Pessoa getPessoa() {
/* 81 */     return this.pessoa;
/*    */   }
/*    */ 
/*    */   public void setPessoa(Pessoa pessoa) {
/* 85 */     this.pessoa = pessoa;
/*    */   }
/*    */ }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.EnderecoPessoa
 * JD-Core Version:    0.6.0
 */