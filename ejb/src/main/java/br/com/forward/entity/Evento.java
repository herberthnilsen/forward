 package br.com.forward.entity;
 
 import java.math.BigInteger;
 import java.util.Date;
 import java.util.List;
 import javax.persistence.Column;
 import javax.persistence.Entity;
 import javax.persistence.GeneratedValue;
 import javax.persistence.GenerationType;
 import javax.persistence.Id;
 import javax.persistence.JoinColumn;
 import javax.persistence.JoinTable;
 import javax.persistence.ManyToMany;
 import javax.persistence.ManyToOne;
 import javax.persistence.NamedQuery;
 import javax.persistence.OneToMany;
 import javax.persistence.Table;
 import javax.persistence.Temporal;
 import javax.persistence.TemporalType;
 
 @Entity
 @Table(name="fwdevt")
 @NamedQuery(name="Evento.findAll", query="SELECT f FROM Evento f")
 public class Evento
   implements EntityInterface
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(unique=true, nullable=false)
   private BigInteger codigoEvento;
 
   @Temporal(TemporalType.TIMESTAMP)
   @Column(nullable=false)
   private Date dataEvento;
 
   @OneToMany(mappedBy="evento")
   private List<AlocacaoInsumo> alocacaoInsumos;
 
   @ManyToOne
   @JoinColumn(name="fwdtipevtcod", nullable=false)
   private TipoEvento tipoEvento;
 
   @ManyToMany
   @JoinTable(name="fwdevtclt", joinColumns={@JoinColumn(name="codigoEvento", nullable=false)}, inverseJoinColumns={@JoinColumn(name="fwdcltcod", nullable=false)})
   private List<Cliente> clientes;
 
   @OneToMany(mappedBy="evento")
   private List<PacoteEvento> pacoteEventos;
 
   public BigInteger getCodigoEvento()
   {
     return this.codigoEvento;
   }
 
   public void setCodigoEvento(BigInteger codigoEvento) {
     this.codigoEvento = codigoEvento;
   }
 
   public Date getDataEvento() {
     return this.dataEvento;
   }
 
   public void setDataEvento(Date dataEvento) {
     this.dataEvento = dataEvento;
   }
 
   public List<AlocacaoInsumo> getListaAlocacaoInsumos() {
     return this.alocacaoInsumos;
   }
 
   public void setListaAlocacaoInsumo(List<AlocacaoInsumo> listaAlocacaoInsumo) {
     this.alocacaoInsumos = listaAlocacaoInsumo;
   }
 
   public AlocacaoInsumo addListaAlocacaoInsumo(AlocacaoInsumo alocacaoInsumo) {
     getListaAlocacaoInsumos().add(alocacaoInsumo);
     alocacaoInsumo.setEvento(this);
 
     return alocacaoInsumo;
   }
 
   public AlocacaoInsumo removeListaAlocacaoInsumo(AlocacaoInsumo alocacaoInsumo) {
     getListaAlocacaoInsumos().remove(alocacaoInsumo);
     alocacaoInsumo.setEvento(null);
 
     return alocacaoInsumo;
   }
 
   public TipoEvento getTipoEvento() {
     return this.tipoEvento;
   }
 
   public void setTipoEvento(TipoEvento tipoEvento) {
     this.tipoEvento = tipoEvento;
   }
 
   public List<Cliente> getListaClientes() {
     return this.clientes;
   }
 
   public void setListaClientes(List<Cliente> clientes) {
     this.clientes = clientes;
   }
 
   public List<PacoteEvento> getListaPacoteEventos() {
     return this.pacoteEventos;
   }
 
   public void setListaPacoteEventos(List<PacoteEvento> pacoteEventos) {
     this.pacoteEventos = pacoteEventos;
   }
 
   public PacoteEvento addListaPacoteEventos(PacoteEvento pacoteEvento) {
     getListaPacoteEventos().add(pacoteEvento);
     pacoteEvento.setEvento(this);
 
     return pacoteEvento;
   }
 
   public PacoteEvento removeListaPacoteEventos(PacoteEvento pacoteEvento) {
     getListaPacoteEventos().remove(pacoteEvento);
     pacoteEvento.setEvento(null);
 
     return pacoteEvento;
   }
 }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.Evento
 * JD-Core Version:    0.6.0
 */