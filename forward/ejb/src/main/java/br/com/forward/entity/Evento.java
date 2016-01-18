/*     */ package br.com.forward.entity;
/*     */ 
/*     */ import java.math.BigInteger;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.JoinTable;
/*     */ import javax.persistence.ManyToMany;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.NamedQuery;
/*     */ import javax.persistence.OneToMany;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
/*     */ 
/*     */ @Entity
/*     */ @Table(name="fwdevt")
/*     */ @NamedQuery(name="Evento.findAll", query="SELECT f FROM Evento f")
/*     */ public class Evento
/*     */   implements EntityInterface
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */ 
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.AUTO)
/*     */   @Column(unique=true, nullable=false)
/*     */   private BigInteger codigoEvento;
/*     */ 
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   @Column(nullable=false)
/*     */   private Date dataEvento;
/*     */ 
/*     */   @OneToMany(mappedBy="evento")
/*     */   private List<AlocacaoInsumo> alocacaoInsumos;
/*     */ 
/*     */   @ManyToOne
/*     */   @JoinColumn(name="fwdtipevtcod", nullable=false)
/*     */   private TipoEvento tipoEvento;
/*     */ 
/*     */   @ManyToMany
/*     */   @JoinTable(name="fwdevtclt", joinColumns={@JoinColumn(name="codigoEvento", nullable=false)}, inverseJoinColumns={@JoinColumn(name="fwdcltcod", nullable=false)})
/*     */   private List<Cliente> clientes;
/*     */ 
/*     */   @OneToMany(mappedBy="evento")
/*     */   private List<PacoteEvento> pacoteEventos;
/*     */ 
/*     */   public BigInteger getCodigoEvento()
/*     */   {
/*  72 */     return this.codigoEvento;
/*     */   }
/*     */ 
/*     */   public void setCodigoEvento(BigInteger codigoEvento) {
/*  76 */     this.codigoEvento = codigoEvento;
/*     */   }
/*     */ 
/*     */   public Date getDataEvento() {
/*  80 */     return this.dataEvento;
/*     */   }
/*     */ 
/*     */   public void setDataEvento(Date dataEvento) {
/*  84 */     this.dataEvento = dataEvento;
/*     */   }
/*     */ 
/*     */   public List<AlocacaoInsumo> getListaAlocacaoInsumos() {
/*  88 */     return this.alocacaoInsumos;
/*     */   }
/*     */ 
/*     */   public void setListaAlocacaoInsumo(List<AlocacaoInsumo> listaAlocacaoInsumo) {
/*  92 */     this.alocacaoInsumos = listaAlocacaoInsumo;
/*     */   }
/*     */ 
/*     */   public AlocacaoInsumo addListaAlocacaoInsumo(AlocacaoInsumo alocacaoInsumo) {
/*  96 */     getListaAlocacaoInsumos().add(alocacaoInsumo);
/*  97 */     alocacaoInsumo.setEvento(this);
/*     */ 
/*  99 */     return alocacaoInsumo;
/*     */   }
/*     */ 
/*     */   public AlocacaoInsumo removeListaAlocacaoInsumo(AlocacaoInsumo alocacaoInsumo) {
/* 103 */     getListaAlocacaoInsumos().remove(alocacaoInsumo);
/* 104 */     alocacaoInsumo.setEvento(null);
/*     */ 
/* 106 */     return alocacaoInsumo;
/*     */   }
/*     */ 
/*     */   public TipoEvento getTipoEvento() {
/* 110 */     return this.tipoEvento;
/*     */   }
/*     */ 
/*     */   public void setTipoEvento(TipoEvento tipoEvento) {
/* 114 */     this.tipoEvento = tipoEvento;
/*     */   }
/*     */ 
/*     */   public List<Cliente> getListaClientes() {
/* 118 */     return this.clientes;
/*     */   }
/*     */ 
/*     */   public void setListaClientes(List<Cliente> clientes) {
/* 122 */     this.clientes = clientes;
/*     */   }
/*     */ 
/*     */   public List<PacoteEvento> getListaPacoteEventos() {
/* 126 */     return this.pacoteEventos;
/*     */   }
/*     */ 
/*     */   public void setListaPacoteEventos(List<PacoteEvento> pacoteEventos) {
/* 130 */     this.pacoteEventos = pacoteEventos;
/*     */   }
/*     */ 
/*     */   public PacoteEvento addListaPacoteEventos(PacoteEvento pacoteEvento) {
/* 134 */     getListaPacoteEventos().add(pacoteEvento);
/* 135 */     pacoteEvento.setEvento(this);
/*     */ 
/* 137 */     return pacoteEvento;
/*     */   }
/*     */ 
/*     */   public PacoteEvento removeListaPacoteEventos(PacoteEvento pacoteEvento) {
/* 141 */     getListaPacoteEventos().remove(pacoteEvento);
/* 142 */     pacoteEvento.setEvento(null);
/*     */ 
/* 144 */     return pacoteEvento;
/*     */   }
/*     */ }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.Evento
 * JD-Core Version:    0.6.0
 */