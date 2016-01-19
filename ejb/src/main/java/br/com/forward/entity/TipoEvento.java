 package br.com.forward.entity;
 
 import java.util.List;
 import javax.persistence.Column;
 import javax.persistence.Entity;
 import javax.persistence.GeneratedValue;
 import javax.persistence.GenerationType;
 import javax.persistence.Id;
 import javax.persistence.NamedQuery;
 import javax.persistence.OneToMany;
 import javax.persistence.Table;
 
 @Entity
 @Table(name="fwdtipevt")
 @NamedQuery(name="TipoEvento.findAll", query="SELECT f FROM TipoEvento f")
 public class TipoEvento
   implements EntityInterface
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name="fwdtipevtcod", unique=true, nullable=false)
   private int codigoTipoEvento;
 
   @Column(name="nomtipevt", length=45)
   private String nomeTipoEvento;
 
   @OneToMany(mappedBy="tipoEvento")
   private List<Evento> eventos;
 
   public int getCodigoTipoEvento()
   {
     return this.codigoTipoEvento;
   }
 
   public void setCodigoTipoEvento(int fwdtipevtcod) {
     this.codigoTipoEvento = fwdtipevtcod;
   }
 
   public String getNomeTipoEvento() {
     return this.nomeTipoEvento;
   }
 
   public void setNomeTipoEvento(String nomtipevt) {
     this.nomeTipoEvento = nomtipevt;
   }
 
   public List<Evento> getListaEventos() {
     return this.eventos;
   }
 
   public void setListaEventos(List<Evento> eventos) {
     this.eventos = eventos;
   }
 
   public Evento addListaEventos(Evento evento) {
     getListaEventos().add(evento);
     evento.setTipoEvento(this);
 
     return evento;
   }
 
   public Evento removeListaEventos(Evento evento) {
     getListaEventos().remove(evento);
     evento.setTipoEvento(null);
 
     return evento;
   }
 }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.TipoEvento
 * JD-Core Version:    0.6.0
 */