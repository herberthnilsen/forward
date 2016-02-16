 package br.com.forward.entity;
 
 import java.sql.Timestamp;
 import java.util.List;
 import javax.persistence.Column;
 import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
 import javax.persistence.GenerationType;
 import javax.persistence.Id;
 import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
 import javax.persistence.ManyToOne;
 import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
 
 @Entity
 @Table(name="fwdclt")
 @NamedQuery(name="Cliente.findAll", query="SELECT f FROM Cliente f")
 public class Cliente
   implements EntityInterface
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name="fwdcltcod", unique=true, nullable=false)
   private int codigoCliente;
 
   @Column(nullable=false, name="datcad")
   private Timestamp dataCadastro;
 
   @ManyToOne
   @JoinColumn(name="fwdpescod", nullable=false)
   private Pessoa pessoa;
 
   @ManyToOne
   @JoinColumn(name="codclb", nullable=false)
   private Pessoa colaborador;
 
   @ManyToMany(mappedBy="clientes", fetch=FetchType.LAZY )
   private List<Evento> eventos;
 
   @OneToOne(mappedBy="cliente", fetch=FetchType.LAZY)
   private EventoCliente eventoCliente;
   
   public int getCodigoCliente()
   {
     return this.codigoCliente;
   }
 
   public void setCodigoCliente(int codigoCliente) {
     this.codigoCliente = codigoCliente;
   }
 
   public Timestamp getDataCadastro() {
     return this.dataCadastro;
   }
 
   public void setDataCadastro(Timestamp dataCadastro) {
     this.dataCadastro = dataCadastro;
   }
 
   public Pessoa getPessoa() {
     return this.pessoa;
   }
 
   public void setPessoa(Pessoa pessoa) {
     this.pessoa = pessoa;
   }
 
   public Pessoa getColaborador() {
     return this.colaborador;
   }
 
   public void setColaborador(Pessoa colaborador) {
     this.colaborador = colaborador;
   }
 
   public List<Evento> getEventos() {
     return this.eventos;
   }
 
   public void setEventos(List<Evento> eventos) {
     this.eventos = eventos;
   }
 }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.Cliente
 * JD-Core Version:    0.6.0
 */