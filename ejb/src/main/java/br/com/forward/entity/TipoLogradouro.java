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
 @Table(name="fwdtiplgd")
 @NamedQuery(name="TipoLogradouro.findAll", query="SELECT f FROM TipoLogradouro f")
 public class TipoLogradouro
   implements EntityInterface
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name="fwdtiplgdcod", unique=true, nullable=false)
   private int codigoTipoLogradouro;
 
   @Column(name="nomtiplgd", nullable=false, length=45)
   private String nomeTipoLogradouro;
 
   @Column(name="sgltiplgd", length=5)
   private String siglaTipoLogradouro;
 
   @OneToMany(mappedBy="tipoLogradouro")
   private List<Logradouro> logradouros;
 
   public int getCodigoTipoLogradouro()
   {
     return this.codigoTipoLogradouro;
   }
 
   public void setCodigoTipoLogradouro(int fwdtiplgdcod) {
     this.codigoTipoLogradouro = fwdtiplgdcod;
   }
 
   public String getNomeTipoLogradouro() {
     return this.nomeTipoLogradouro;
   }
 
   public void setNomeTipoLogradouro(String nomtiplgd) {
     this.nomeTipoLogradouro = nomtiplgd;
   }
 
   public String getSiglaTipoLogradouro() {
     return this.siglaTipoLogradouro;
   }
 
   public void setSiglaTipoLogradouro(String sgltiplgd) {
     this.siglaTipoLogradouro = sgltiplgd;
   }
 
   public List<Logradouro> getListaLogradouro() {
     return this.logradouros;
   }
 
   public void setListaLogradouro(List<Logradouro> logradouros) {
     this.logradouros = logradouros;
   }
 
   public Logradouro addListaLogradouro(Logradouro logradouro) {
     getListaLogradouro().add(logradouro);
     logradouro.setTipoLogradouro(this);
 
     return logradouro;
   }
 
   public Logradouro removeListaLogradouro(Logradouro logradouro) {
     getListaLogradouro().remove(logradouro);
     logradouro.setTipoLogradouro(null);
 
     return logradouro;
   }
 }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.TipoLogradouro
 * JD-Core Version:    0.6.0
 */