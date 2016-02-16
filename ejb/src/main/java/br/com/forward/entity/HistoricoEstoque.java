 package br.com.forward.entity;
 
 import java.math.BigDecimal;
import java.math.BigInteger;
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
 @Table(name="fwdhstetq")
 @NamedQuery(name="HistoricoEstoque.findAll", query="SELECT f FROM HistoricoEstoque f")
 public class HistoricoEstoque
   implements EntityInterface
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name="fwdhstetqcod", unique=true, nullable=false)
   private BigInteger codigoHistoricoEstoque;
 
   @Column(name="dtahst")
   private Timestamp dataHistorico;
 
   @Column(precision=10, name="qtdant")
   private BigDecimal quantidadeAnterior;
 
   @ManyToOne
   @JoinColumn(name="fwdclbcod", nullable=false)
   private Pessoa pessoa;
 
   @ManyToOne
   @JoinColumn(name="fwdetqinscod", nullable=false)
   private EstoqueInsumo estoqueInsumo;
 
   public BigInteger getCodigoHistoricoEstoque()
   {
     return this.codigoHistoricoEstoque;
   }
 
   public void setCodigoHistoricoEstoque(BigInteger fwdhstetqcod) {
     this.codigoHistoricoEstoque = fwdhstetqcod;
   }
 
   public Timestamp getDataHistorico() {
     return this.dataHistorico;
   }
 
   public void setDataHistorico(Timestamp dtahst) {
     this.dataHistorico = dtahst;
   }
 
   public BigDecimal getQuantidadeAnterior() {
     return this.quantidadeAnterior;
   }
 
   public void setQuantidadeAnterior(BigDecimal qtdant) {
     this.quantidadeAnterior = qtdant;
   }
 
   public Pessoa getPessoa() {
     return this.pessoa;
   }
 
   public void setPessoa(Pessoa pessoa) {
     this.pessoa = pessoa;
   }
 
   public EstoqueInsumo getEstoqueInsumo() {
     return this.estoqueInsumo;
   }
 
   public void setEstoqueInsumo(EstoqueInsumo estoqueInsumo) {
     this.estoqueInsumo = estoqueInsumo;
   }
 }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.HistoricoEstoque
 * JD-Core Version:    0.6.0
 */