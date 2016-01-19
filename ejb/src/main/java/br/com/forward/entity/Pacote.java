 package br.com.forward.entity;
 
 import java.sql.Timestamp;
 import java.util.List;
 import javax.persistence.Column;
 import javax.persistence.Entity;
 import javax.persistence.GeneratedValue;
 import javax.persistence.GenerationType;
 import javax.persistence.Id;
 import javax.persistence.JoinColumn;
 import javax.persistence.ManyToOne;
 import javax.persistence.NamedQuery;
 import javax.persistence.OneToMany;
 import javax.persistence.Table;
 
 @Entity
 @Table(name="fwdpct")
 @NamedQuery(name="Pacote.findAll", query="SELECT f FROM Pacote f")
 public class Pacote
   implements EntityInterface
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name="fwdpctcod", unique=true, nullable=false)
   private int codigoPacote;
 
   @Column(name="datcad", nullable=false)
   private Timestamp dataCadastro;
 
   @Column(name="nompct", nullable=false, length=150)
   private String nomePacote;
 
   @OneToMany(mappedBy="insumo")
   private List<InsumoPacote> insumoPacotes;
 
   @ManyToOne
   @JoinColumn(name="fwdclbcod", nullable=false)
   private Pessoa pessoa;
 
   @OneToMany(mappedBy="pacote")
   private List<PacoteEvento> pacoteEventos;
 
   public int getCodigoPacote()
   {
     return this.codigoPacote;
   }
 
   public void setCodigoPacote(int codigoPacote) {
     this.codigoPacote = codigoPacote;
   }
 
   public Timestamp getDataCadastro() {
     return this.dataCadastro;
   }
 
   public void setDataCadastro(Timestamp datcad) {
     this.dataCadastro = datcad;
   }
 
   public String getNomePacote() {
     return this.nomePacote;
   }
 
   public void setNomePacote(String nomePacote) {
     this.nomePacote = nomePacote;
   }
 
   public List<InsumoPacote> getInsumoPacotes() {
     return this.insumoPacotes;
   }
 
   public void setInsumoPacotes(List<InsumoPacote> insumoPacotes) {
     this.insumoPacotes = insumoPacotes;
   }
 
   public InsumoPacote addInsumoPacotes(InsumoPacote insumoPacote) {
     getInsumoPacotes().add(insumoPacote);
     insumoPacote.setPacote(this);
 
     return insumoPacote;
   }
 
   public InsumoPacote removeInsumoPacotes(InsumoPacote insumoPacote) {
     getInsumoPacotes().remove(insumoPacote);
     insumoPacote.setPacote(null);
 
     return insumoPacote;
   }
 
   public Pessoa getPessoa() {
     return this.pessoa;
   }
 
   public void setPessoa(Pessoa pessoa) {
     this.pessoa = pessoa;
   }
 
   public List<PacoteEvento> getPacoteEventos() {
     return this.pacoteEventos;
   }
 
   public void setPacoteEventos(List<PacoteEvento> pacoteEventos) {
     this.pacoteEventos = pacoteEventos;
   }
 
   public PacoteEvento addPacoteEventos(PacoteEvento pacoteEvento) {
     getPacoteEventos().add(pacoteEvento);
     pacoteEvento.setPacote(this);
 
     return pacoteEvento;
   }
 
   public PacoteEvento removePacoteEventos(PacoteEvento pacoteEvento) {
     getPacoteEventos().remove(pacoteEvento);
     pacoteEvento.setPacote(null);
 
     return pacoteEvento;
   }
 }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.Pacote
 * JD-Core Version:    0.6.0
 */