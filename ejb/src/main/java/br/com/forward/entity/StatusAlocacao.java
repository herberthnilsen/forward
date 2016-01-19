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
 @Table(name="fwdsttalc")
 @NamedQuery(name="StatusAlocacao.findAll", query="SELECT f FROM StatusAlocacao f")
 public class StatusAlocacao
   implements EntityInterface
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name="fwdsttalccod", unique=true, nullable=false)
   private int codigoStatusAlocacao;
 
   @Column(name="nomstt", nullable=false, length=45)
   private String nomeStatus;
 
   @OneToMany(mappedBy="statusAlocacao")
   private List<AlocacaoInsumo> alocacaoInsumos;
 
   public int getCodigoStatusAlocacao()
   {
     return this.codigoStatusAlocacao;
   }
 
   public void setCodigoStatusAlocacao(int fwdsttalccod) {
     this.codigoStatusAlocacao = fwdsttalccod;
   }
 
   public String getNomeStatus() {
     return this.nomeStatus;
   }
 
   public void setNomeStatus(String nomstt) {
     this.nomeStatus = nomstt;
   }
 
   public List<AlocacaoInsumo> getListaAlocacaoInsumo() {
     return this.alocacaoInsumos;
   }
 
   public void setListaAlocacaoInsumo(List<AlocacaoInsumo> alocacaoInsumos) {
     this.alocacaoInsumos = alocacaoInsumos;
   }
 
   public AlocacaoInsumo addListaAlocacaoInsumo(AlocacaoInsumo alocacaoInsumo) {
     getListaAlocacaoInsumo().add(alocacaoInsumo);
     alocacaoInsumo.setStatusAlocacao(this);
 
     return alocacaoInsumo;
   }
 
   public AlocacaoInsumo removeListaAlocacaoInsumo(AlocacaoInsumo alocacaoInsumo) {
     getListaAlocacaoInsumo().remove(alocacaoInsumo);
     alocacaoInsumo.setStatusAlocacao(null);
 
     return alocacaoInsumo;
   }
 }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.StatusAlocacao
 * JD-Core Version:    0.6.0
 */