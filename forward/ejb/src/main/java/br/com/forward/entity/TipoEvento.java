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
/*    */ @Table(name="fwdtipevt")
/*    */ @NamedQuery(name="TipoEvento.findAll", query="SELECT f FROM TipoEvento f")
/*    */ public class TipoEvento
/*    */   implements EntityInterface
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */   @Id
/*    */   @GeneratedValue(strategy=GenerationType.AUTO)
/*    */   @Column(name="fwdtipevtcod", unique=true, nullable=false)
/*    */   private int codigoTipoEvento;
/*    */ 
/*    */   @Column(name="nomtipevt", length=45)
/*    */   private String nomeTipoEvento;
/*    */ 
/*    */   @OneToMany(mappedBy="tipoEvento")
/*    */   private List<Evento> eventos;
/*    */ 
/*    */   public int getCodigoTipoEvento()
/*    */   {
/* 41 */     return this.codigoTipoEvento;
/*    */   }
/*    */ 
/*    */   public void setCodigoTipoEvento(int fwdtipevtcod) {
/* 45 */     this.codigoTipoEvento = fwdtipevtcod;
/*    */   }
/*    */ 
/*    */   public String getNomeTipoEvento() {
/* 49 */     return this.nomeTipoEvento;
/*    */   }
/*    */ 
/*    */   public void setNomeTipoEvento(String nomtipevt) {
/* 53 */     this.nomeTipoEvento = nomtipevt;
/*    */   }
/*    */ 
/*    */   public List<Evento> getListaEventos() {
/* 57 */     return this.eventos;
/*    */   }
/*    */ 
/*    */   public void setListaEventos(List<Evento> eventos) {
/* 61 */     this.eventos = eventos;
/*    */   }
/*    */ 
/*    */   public Evento addListaEventos(Evento evento) {
/* 65 */     getListaEventos().add(evento);
/* 66 */     evento.setTipoEvento(this);
/*    */ 
/* 68 */     return evento;
/*    */   }
/*    */ 
/*    */   public Evento removeListaEventos(Evento evento) {
/* 72 */     getListaEventos().remove(evento);
/* 73 */     evento.setTipoEvento(null);
/*    */ 
/* 75 */     return evento;
/*    */   }
/*    */ }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.TipoEvento
 * JD-Core Version:    0.6.0
 */