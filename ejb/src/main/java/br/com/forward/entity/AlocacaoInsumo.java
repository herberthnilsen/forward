 package br.com.forward.entity;
 
 import javax.persistence.Column;
 import javax.persistence.Entity;
 import javax.persistence.GeneratedValue;
 import javax.persistence.GenerationType;
 import javax.persistence.Id;
 import javax.persistence.JoinColumn;
 import javax.persistence.ManyToOne;
 import javax.persistence.NamedQuery;
 import javax.persistence.Table;
 
 @Entity
 @Table(name="fwdalcins")
 @NamedQuery(name="AlocacaoInsumo.findAll", query="SELECT f FROM AlocacaoInsumo f")
 public class AlocacaoInsumo
   implements EntityInterface
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(unique=true, nullable=false)
   private int codigoAlocacaoInsumo;
 
   @ManyToOne
   @JoinColumn(name="fwdevtcod", nullable=false)
   private Evento evento;
 
   @ManyToOne
   @JoinColumn(name="idfwdins", nullable=false)
   private Insumo insumo;
 
   @ManyToOne
   @JoinColumn(name="fwdsttalccod", nullable=false)
   private StatusAlocacao statusAlocacao;
 
   public int getCodigoAlocacaoInsumo()
   {
     return this.codigoAlocacaoInsumo;
   }
 
   public void setCodigoAlocacaoInsumo(int codigoAlocacaoInsumo) {
     this.codigoAlocacaoInsumo = codigoAlocacaoInsumo;
   }
 
   public Evento getEvento() {
     return this.evento;
   }
 
   public void setEvento(Evento evento) {
     this.evento = evento;
   }
 
   public Insumo getInsumo() {
     return this.insumo;
   }
 
   public void setInsumo(Insumo insumo) {
     this.insumo = insumo;
   }
 
   public StatusAlocacao getStatusAlocacao() {
     return this.statusAlocacao;
   }
 
   public void setStatusAlocacao(StatusAlocacao statusAlocacao) {
     this.statusAlocacao = statusAlocacao;
   }
 }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.AlocacaoInsumo
 * JD-Core Version:    0.6.0
 */