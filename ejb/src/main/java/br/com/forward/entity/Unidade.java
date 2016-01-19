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
 @Table(name="fwdund")
 @NamedQuery(name="Unidade.findAll", query="SELECT f FROM Unidade f")
 public class Unidade
   implements EntityInterface
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name="fwdundcod", unique=true, nullable=false)
   private int codigoUnidade;
 
   @Column(name="nomund", length=45)
   private String nomeUnidade;
 
   @Column(name="sglund", length=3)
   private String siglaUnidade;
 
   @OneToMany(mappedBy="unidade")
   private List<Insumo> insumos;
 
   public int getCodigoUnidade()
   {
     return this.codigoUnidade;
   }
 
   public void setCodigoUnidade(int fwdundcod) {
     this.codigoUnidade = fwdundcod;
   }
 
   public String getNomeUnidade() {
     return this.nomeUnidade;
   }
 
   public void setNomeUnidade(String nomund) {
     this.nomeUnidade = nomund;
   }
 
   public String getSiglaUnidade() {
     return this.siglaUnidade;
   }
 
   public void setSiglaUnidade(String sglund) {
     this.siglaUnidade = sglund;
   }
 
   public List<Insumo> getListaInsumos() {
     return this.insumos;
   }
 
   public void setListaInsumos(List<Insumo> insumos) {
     this.insumos = insumos;
   }
 
   public Insumo addListaInsumos(Insumo insumo) {
     getListaInsumos().add(insumo);
     insumo.setUnidade(this);
 
     return insumo;
   }
 
   public Insumo removeListaInsumos(Insumo insumo) {
     getListaInsumos().remove(insumo);
     insumo.setUnidade(null);
 
     return insumo;
   }
 }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.Unidade
 * JD-Core Version:    0.6.0
 */