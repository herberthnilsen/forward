 package br.com.forward.entity;
 
 import java.math.BigDecimal;
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
 @Table(name="fwdetqins")
 @NamedQuery(name="EstoqueInsumo.findAll", query="SELECT f FROM EstoqueInsumo f")
 public class EstoqueInsumo
   implements EntityInterface
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name="fwdetqinscod", unique=true, nullable=false)
   private int codigoEstoqueInsumo;
 
   @Column(name="qtdetq", nullable=false, precision=10)
   private BigDecimal quantidadeEstoque;
 
   @Column(name="qtdmaxetq", nullable=false, precision=10)
   private BigDecimal quantidadeMaximaEstoque;
 
   @Column(name="qtdminetq", nullable=false, precision=10)
   private BigDecimal quantidadeMinimaEstoque;
 
   @ManyToOne
   @JoinColumn(name="idfwdins", nullable=false)
   private Insumo insumo;
 
   @OneToMany(mappedBy="estoqueInsumo")
   private List<HistoricoEstoque> historicoEstoques;
 
   public int getCodigoEstoqueInsumo()
   {
     return this.codigoEstoqueInsumo;
   }
 
   public void setCodigoEstoqueInsumo(int fwdetqinscod) {
     this.codigoEstoqueInsumo = fwdetqinscod;
   }
 
   public BigDecimal getQuantidadeEstoque() {
     return this.quantidadeEstoque;
   }
 
   public void setQuantidadeEstoque(BigDecimal qtdetq) {
     this.quantidadeEstoque = qtdetq;
   }
 
   public BigDecimal getQuantidadeMaximaEstoque() {
     return this.quantidadeMaximaEstoque;
   }
 
   public void setQuantidadeMaximaEstoque(BigDecimal qtdmaxetq) {
     this.quantidadeMaximaEstoque = qtdmaxetq;
   }
 
   public BigDecimal getQuantidadeMinimaEstoque() {
     return this.quantidadeMinimaEstoque;
   }
 
   public void setQuantidadeMinimaEstoque(BigDecimal qtdminetq) {
     this.quantidadeMinimaEstoque = qtdminetq;
   }
 
   public Insumo getInsumo() {
     return this.insumo;
   }
 
   public void setInsumo(Insumo insumo) {
     this.insumo = insumo;
   }
 
   public List<HistoricoEstoque> getListaHistoricoEstoque() {
     return this.historicoEstoques;
   }
 
   public void setListaHistoricoEstoque(List<HistoricoEstoque> historicoEstoques) {
     this.historicoEstoques = historicoEstoques;
   }
 
   public HistoricoEstoque addListaHistoricoEstoque(HistoricoEstoque historicoEstoque) {
     getListaHistoricoEstoque().add(historicoEstoque);
     historicoEstoque.setEstoqueInsumo(this);
 
     return historicoEstoque;
   }
 
   public HistoricoEstoque removeListaHistoricoEstoque(HistoricoEstoque historicoEstoque) {
     getListaHistoricoEstoque().remove(historicoEstoque);
     historicoEstoque.setEstoqueInsumo(null);
 
     return historicoEstoque;
   }
 }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.EstoqueInsumo
 * JD-Core Version:    0.6.0
 */