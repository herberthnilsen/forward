/*    */ package br.com.forward.entity;
/*    */ 
/*    */ import java.sql.Timestamp;
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
/*    */ @Table(name="fwdclb")
/*    */ @NamedQuery(name="Colaborador.findAll", query="SELECT f FROM Colaborador f")
/*    */ public class Colaborador
/*    */   implements EntityInterface
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */   @Id
/*    */   @Column(name="fwdclbcod", unique=true, nullable=false)
/*    */   @GeneratedValue(strategy=GenerationType.AUTO)
/*    */   private Integer codigoColaborador;
/*    */ 
/*    */   @Column(name="datcad", nullable=false)
/*    */   private Timestamp dataCadastro;
/*    */ 
/*    */   @Column(name="nomusr", length=15)
/*    */   private String nomeUsuario;
/*    */ 
/*    */   @Column(name="snhusr", length=255)
/*    */   private String senhaUsuario;
/*    */ 
/*    */   @ManyToOne
/*    */   @JoinColumn(name="fwdpescod", nullable=false)
/*    */   private Pessoa pessoa;
/*    */ 
/*    */   public Integer getCodigoColaborador()
/*    */   {
/* 49 */     return this.codigoColaborador;
/*    */   }
/*    */ 
/*    */   public void setCodigoColaborador(Integer codigoColaborador) {
/* 53 */     this.codigoColaborador = codigoColaborador;
/*    */   }
/*    */ 
/*    */   public Timestamp getDataCadastro() {
/* 57 */     return this.dataCadastro;
/*    */   }
/*    */ 
/*    */   public void setDataCadastro(Timestamp dataCadastro) {
/* 61 */     this.dataCadastro = dataCadastro;
/*    */   }
/*    */ 
/*    */   public String getNomeUsuario() {
/* 65 */     return this.nomeUsuario;
/*    */   }
/*    */ 
/*    */   public void setNomeUsuario(String nomeUsuario) {
/* 69 */     this.nomeUsuario = nomeUsuario;
/*    */   }
/*    */ 
/*    */   public String getSenhaUsuario() {
/* 73 */     return this.senhaUsuario;
/*    */   }
/*    */ 
/*    */   public void setSenhaUsuario(String senhaUsuario) {
/* 77 */     this.senhaUsuario = senhaUsuario;
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
 * Qualified Name:     br.com.forward.entity.Colaborador
 * JD-Core Version:    0.6.0
 */