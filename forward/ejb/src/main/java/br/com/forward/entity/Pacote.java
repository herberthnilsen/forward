/*     */ package br.com.forward.entity;
/*     */ 
/*     */ import java.sql.Timestamp;
/*     */ import java.util.List;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.NamedQuery;
/*     */ import javax.persistence.OneToMany;
/*     */ import javax.persistence.Table;
/*     */ 
/*     */ @Entity
/*     */ @Table(name="fwdpct")
/*     */ @NamedQuery(name="Pacote.findAll", query="SELECT f FROM Pacote f")
/*     */ public class Pacote
/*     */   implements EntityInterface
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */ 
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.AUTO)
/*     */   @Column(name="fwdpctcod", unique=true, nullable=false)
/*     */   private int codigoPacote;
/*     */ 
/*     */   @Column(name="datcad", nullable=false)
/*     */   private Timestamp dataCadastro;
/*     */ 
/*     */   @Column(name="nompct", nullable=false, length=150)
/*     */   private String nomePacote;
/*     */ 
/*     */   @OneToMany(mappedBy="insumo")
/*     */   private List<InsumoPacote> insumoPacotes;
/*     */ 
/*     */   @ManyToOne
/*     */   @JoinColumn(name="fwdclbcod", nullable=false)
/*     */   private Pessoa pessoa;
/*     */ 
/*     */   @OneToMany(mappedBy="pacote")
/*     */   private List<PacoteEvento> pacoteEventos;
/*     */ 
/*     */   public int getCodigoPacote()
/*     */   {
/*  56 */     return this.codigoPacote;
/*     */   }
/*     */ 
/*     */   public void setCodigoPacote(int codigoPacote) {
/*  60 */     this.codigoPacote = codigoPacote;
/*     */   }
/*     */ 
/*     */   public Timestamp getDataCadastro() {
/*  64 */     return this.dataCadastro;
/*     */   }
/*     */ 
/*     */   public void setDataCadastro(Timestamp datcad) {
/*  68 */     this.dataCadastro = datcad;
/*     */   }
/*     */ 
/*     */   public String getNomePacote() {
/*  72 */     return this.nomePacote;
/*     */   }
/*     */ 
/*     */   public void setNomePacote(String nomePacote) {
/*  76 */     this.nomePacote = nomePacote;
/*     */   }
/*     */ 
/*     */   public List<InsumoPacote> getInsumoPacotes() {
/*  80 */     return this.insumoPacotes;
/*     */   }
/*     */ 
/*     */   public void setInsumoPacotes(List<InsumoPacote> insumoPacotes) {
/*  84 */     this.insumoPacotes = insumoPacotes;
/*     */   }
/*     */ 
/*     */   public InsumoPacote addInsumoPacotes(InsumoPacote insumoPacote) {
/*  88 */     getInsumoPacotes().add(insumoPacote);
/*  89 */     insumoPacote.setPacote(this);
/*     */ 
/*  91 */     return insumoPacote;
/*     */   }
/*     */ 
/*     */   public InsumoPacote removeInsumoPacotes(InsumoPacote insumoPacote) {
/*  95 */     getInsumoPacotes().remove(insumoPacote);
/*  96 */     insumoPacote.setPacote(null);
/*     */ 
/*  98 */     return insumoPacote;
/*     */   }
/*     */ 
/*     */   public Pessoa getPessoa() {
/* 102 */     return this.pessoa;
/*     */   }
/*     */ 
/*     */   public void setPessoa(Pessoa pessoa) {
/* 106 */     this.pessoa = pessoa;
/*     */   }
/*     */ 
/*     */   public List<PacoteEvento> getPacoteEventos() {
/* 110 */     return this.pacoteEventos;
/*     */   }
/*     */ 
/*     */   public void setPacoteEventos(List<PacoteEvento> pacoteEventos) {
/* 114 */     this.pacoteEventos = pacoteEventos;
/*     */   }
/*     */ 
/*     */   public PacoteEvento addPacoteEventos(PacoteEvento pacoteEvento) {
/* 118 */     getPacoteEventos().add(pacoteEvento);
/* 119 */     pacoteEvento.setPacote(this);
/*     */ 
/* 121 */     return pacoteEvento;
/*     */   }
/*     */ 
/*     */   public PacoteEvento removePacoteEventos(PacoteEvento pacoteEvento) {
/* 125 */     getPacoteEventos().remove(pacoteEvento);
/* 126 */     pacoteEvento.setPacote(null);
/*     */ 
/* 128 */     return pacoteEvento;
/*     */   }
/*     */ }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.Pacote
 * JD-Core Version:    0.6.0
 */