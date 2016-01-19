 package br.com.forward.entity;
 
 import java.math.BigDecimal;
 import javax.persistence.Column;
 import javax.persistence.EmbeddedId;
 import javax.persistence.Entity;
 import javax.persistence.JoinColumn;
 import javax.persistence.ManyToOne;
 import javax.persistence.NamedQuery;
 import javax.persistence.Table;
 
 @Entity
 @Table(name="fwdpctevt")
 @NamedQuery(name="PacoteEvento.findAll", query="SELECT f FROM PacoteEvento f")
 public class PacoteEvento
   implements EntityInterface
 {
   private static final long serialVersionUID = 1L;
 
   @EmbeddedId
   private PacoteEventoPK id;
 
   @Column(name="vlrngd", nullable=false, precision=10, scale=2)
   private BigDecimal valorNegociado;
 
   @ManyToOne
   @JoinColumn(name="fwdevtcod", nullable=false, insertable=false, updatable=false)
   private Evento evento;
 
   @ManyToOne
   @JoinColumn(name="fwdpctcod", nullable=false, insertable=false, updatable=false)
   private Pacote pacote;
 
   public PacoteEventoPK getId()
   {
     return this.id;
   }
 
   public void setId(PacoteEventoPK id) {
     this.id = id;
   }
 
   public BigDecimal getValorNegociado() {
     return this.valorNegociado;
   }
 
   public void setValorNegociado(BigDecimal vlwncd) {
     this.valorNegociado = vlwncd;
   }
 
   public Evento getEvento() {
     return this.evento;
   }
 
   public void setEvento(Evento evento) {
     this.evento = evento;
   }
 
   public Pacote getPacote() {
     return this.pacote;
   }
 
   public void setPacote(Pacote pacote) {
     this.pacote = pacote;
   }
 }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.PacoteEvento
 * JD-Core Version:    0.6.0
 */