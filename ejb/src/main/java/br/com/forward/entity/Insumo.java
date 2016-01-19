 package br.com.forward.entity;
 
 import java.math.BigDecimal;
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
 @Table(name="fwdins")
 @NamedQuery(name="Insumo.findAll", query="SELECT f FROM Insumo f order by f.codigoInsumo")
 public class Insumo
   implements EntityInterface
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name="idfwdins", unique=true, nullable=false)
   private int codigoInsumo;
 
   @Column(name="dscins", length=200)
   private String descricaoInsumo;
 
   @Column(name="dtacad", nullable=false)
   private Timestamp dataCadastro;
 
   @Column(name="nomins", nullable=false, length=45)
   private String nomeInsumo;
 
   @Column(precision=10, name="numsre")
   private BigDecimal numeroSerie;
 
   @Column(precision=9, scale=2, name="vlrmrc")
   private BigDecimal valorMercado;
 
   @Column(precision=9, scale=2, name="vlrvnd")
   private BigDecimal valorVenda;
 
   @OneToMany(mappedBy="insumo")
   private List<AlocacaoInsumo> alocacaoInsumos;
 
   @OneToMany(mappedBy="insumo")
   private List<EstoqueInsumo> estoqueInsumos;
 
   @ManyToOne
   @JoinColumn(name="fwdcatinscod", nullable=false)
   private CategoriaInsumo categoriaInsumo;
 
   @ManyToOne
   @JoinColumn(name="fwdundcod", nullable=false)
   private Unidade unidade;
 
   @OneToMany(mappedBy="insumo")
   private List<InsumoPacote> insumoPacotes;
 
   @OneToMany(mappedBy="insumo")
   private List<SubItemInsumo> subItens;
 
   public int getCodigoInsumo()
   {
     return this.codigoInsumo;
   }
 
   public void setCodigoInsumo(int codigoInsumo) {
     this.codigoInsumo = codigoInsumo;
   }
 
   public String getDescricaoInsumo() {
     return this.descricaoInsumo;
   }
 
   public void setDescricaoInsumo(String descricaoInsumo) {
     this.descricaoInsumo = descricaoInsumo;
   }
 
   public Timestamp getDataCadastro() {
     return this.dataCadastro;
   }
 
   public void setDataCadastro(Timestamp dataCadastro) {
     this.dataCadastro = dataCadastro;
   }
 
   public String getNomeInsumo() {
     return this.nomeInsumo;
   }
 
   public void setNomeInsumo(String nomeInsumo) {
     this.nomeInsumo = nomeInsumo;
   }
 
   public BigDecimal getNumeroSerie() {
     return this.numeroSerie;
   }
 
   public void setNumeroSerie(BigDecimal numeroSerie) {
     this.numeroSerie = numeroSerie;
   }
 
   public BigDecimal getValorMercado() {
     return this.valorMercado;
   }
 
   public void setValorMercado(BigDecimal vlrmrc) {
     this.valorMercado = vlrmrc;
   }
 
   public BigDecimal getValorVenda() {
     return this.valorVenda;
   }
 
   public void setValorVenda(BigDecimal vlrvnd) {
     this.valorVenda = vlrvnd;
   }
 
   public List<AlocacaoInsumo> getListaAlocacaoInsumo() {
     return this.alocacaoInsumos;
   }
 
   public void setListaAlocacaoInsumo(List<AlocacaoInsumo> alocacaoInsumos) {
     this.alocacaoInsumos = alocacaoInsumos;
   }
 
   public AlocacaoInsumo addListaAlocacaoInsumo(AlocacaoInsumo alocacaoInsumo) {
     getListaAlocacaoInsumo().add(alocacaoInsumo);
     alocacaoInsumo.setInsumo(this);
 
     return alocacaoInsumo;
   }
 
   public AlocacaoInsumo removeListaAlocacaoInsumo(AlocacaoInsumo alocacaoInsumo) {
     getListaAlocacaoInsumo().remove(alocacaoInsumo);
     alocacaoInsumo.setInsumo(null);
 
     return alocacaoInsumo;
   }
 
   public List<EstoqueInsumo> getListaEstoqueInsumo() {
     return this.estoqueInsumos;
   }
 
   public void setListaEstoqueInsumo(List<EstoqueInsumo> estoqueInsumos) {
     this.estoqueInsumos = estoqueInsumos;
   }
 
   public EstoqueInsumo addListaEstoqueInsumo(EstoqueInsumo estoqueInsumo) {
     getListaEstoqueInsumo().add(estoqueInsumo);
     estoqueInsumo.setInsumo(this);
 
     return estoqueInsumo;
   }
 
   public EstoqueInsumo removeListaEstoqueInsumo(EstoqueInsumo estoqueInsumo) {
     getListaEstoqueInsumo().remove(estoqueInsumo);
     estoqueInsumo.setInsumo(null);
 
     return estoqueInsumo;
   }
 
   public CategoriaInsumo getCategoriaInsumo() {
     return this.categoriaInsumo;
   }
 
   public void setCategoriaInsumo(CategoriaInsumo categoriaInsumo) {
     this.categoriaInsumo = categoriaInsumo;
   }
 
   public Unidade getUnidade() {
     return this.unidade;
   }
 
   public void setUnidade(Unidade unidade) {
     this.unidade = unidade;
   }
 
   public List<InsumoPacote> getListaInsumoPacote() {
     return this.insumoPacotes;
   }
 
   public void setListaInsumoPacote(List<InsumoPacote> insumoPacotes) {
     this.insumoPacotes = insumoPacotes;
   }
 
   public InsumoPacote addListaInsumoPacote(InsumoPacote insumoPacote) {
     getListaInsumoPacote().add(insumoPacote);
     insumoPacote.setInsumo(this);
 
     return insumoPacote;
   }
 
   public InsumoPacote removeListaInsumoPacote(InsumoPacote insumoPacote) {
     getListaInsumoPacote().remove(insumoPacote);
     insumoPacote.setInsumo(null);
 
     return insumoPacote;
   }
 }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.Insumo
 * JD-Core Version:    0.6.0
 */