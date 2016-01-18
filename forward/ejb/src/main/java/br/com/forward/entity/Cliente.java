/*    */ package br.com.forward.entity;
/*    */ 
/*    */ import java.sql.Timestamp;
/*    */ import java.util.List;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.GenerationType;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.JoinColumn;
/*    */ import javax.persistence.ManyToMany;
/*    */ import javax.persistence.ManyToOne;
/*    */ import javax.persistence.NamedQuery;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ @Entity
/*    */ @Table(name="fwdclt")
/*    */ @NamedQuery(name="Cliente.findAll", query="SELECT f FROM Cliente f")
/*    */ public class Cliente
/*    */   implements EntityInterface
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */   @Id
/*    */   @GeneratedValue(strategy=GenerationType.AUTO)
/*    */   @Column(name="fwdcltcod", unique=true, nullable=false)
/*    */   private int codigoCliente;
/*    */ 
/*    */   @Column(nullable=false, name="datcad")
/*    */   private Timestamp dataCadastro;
/*    */ 
/*    */   @ManyToOne
/*    */   @JoinColumn(name="fwdpescod", nullable=false)
/*    */   private Pessoa pessoa;
/*    */ 
/*    */   @ManyToOne
/*    */   @JoinColumn(name="codclb", nullable=false)
/*    */   private Pessoa colaborador;
/*    */ 
/*    */   @ManyToMany(mappedBy="clientes")
/*    */   private List<Evento> eventos;
/*    */ 
/*    */   public int getCodigoCliente()
/*    */   {
/* 53 */     return this.codigoCliente;
/*    */   }
/*    */ 
/*    */   public void setCodigoCliente(int codigoCliente) {
/* 57 */     this.codigoCliente = codigoCliente;
/*    */   }
/*    */ 
/*    */   public Timestamp getDataCadastro() {
/* 61 */     return this.dataCadastro;
/*    */   }
/*    */ 
/*    */   public void setDataCadastro(Timestamp dataCadastro) {
/* 65 */     this.dataCadastro = dataCadastro;
/*    */   }
/*    */ 
/*    */   public Pessoa getPessoa() {
/* 69 */     return this.pessoa;
/*    */   }
/*    */ 
/*    */   public void setPessoa(Pessoa pessoa) {
/* 73 */     this.pessoa = pessoa;
/*    */   }
/*    */ 
/*    */   public Pessoa getColaborador() {
/* 77 */     return this.colaborador;
/*    */   }
/*    */ 
/*    */   public void setColaborador(Pessoa colaborador) {
/* 81 */     this.colaborador = colaborador;
/*    */   }
/*    */ 
/*    */   public List<Evento> getEventos() {
/* 85 */     return this.eventos;
/*    */   }
/*    */ 
/*    */   public void setEventos(List<Evento> eventos) {
/* 89 */     this.eventos = eventos;
/*    */   }
/*    */ }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.Cliente
 * JD-Core Version:    0.6.0
 */