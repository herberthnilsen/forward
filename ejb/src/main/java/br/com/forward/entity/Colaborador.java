 package br.com.forward.entity;
 
 import java.sql.Timestamp;
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
 @Table(name="fwdclb")
 @NamedQuery(name="Colaborador.findAll", query="SELECT f FROM Colaborador f")
 public class Colaborador
   implements EntityInterface
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @Column(name="fwdclbcod", unique=true, nullable=false)
   @GeneratedValue(strategy=GenerationType.AUTO)
   private Integer codigoColaborador;
 
   @Column(name="datcad", nullable=false)
   private Timestamp dataCadastro;
 
   @Column(name="nomusr", length=15)
   private String nomeUsuario;
 
   @Column(name="snhusr", length=255)
   private String senhaUsuario;
 
   @ManyToOne
   @JoinColumn(name="fwdpescod", nullable=false)
   private Pessoa pessoa;
 
   public Integer getCodigoColaborador()
   {
     return this.codigoColaborador;
   }
 
   public void setCodigoColaborador(Integer codigoColaborador) {
     this.codigoColaborador = codigoColaborador;
   }
 
   public Timestamp getDataCadastro() {
     return this.dataCadastro;
   }
 
   public void setDataCadastro(Timestamp dataCadastro) {
     this.dataCadastro = dataCadastro;
   }
 
   public String getNomeUsuario() {
     return this.nomeUsuario;
   }
 
   public void setNomeUsuario(String nomeUsuario) {
     this.nomeUsuario = nomeUsuario;
   }
 
   public String getSenhaUsuario() {
     return this.senhaUsuario;
   }
 
   public void setSenhaUsuario(String senhaUsuario) {
     this.senhaUsuario = senhaUsuario;
   }
 
   public Pessoa getPessoa() {
     return this.pessoa;
   }
 
   public void setPessoa(Pessoa pessoa) {
     this.pessoa = pessoa;
   }
 }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.Colaborador
 * JD-Core Version:    0.6.0
 */