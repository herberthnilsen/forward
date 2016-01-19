 package br.com.forward.entity;
 
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
 @Table(name="fwdlgd")
 @NamedQuery(name="Logradouro.findAll", query="SELECT f FROM Logradouro f")
 public class Logradouro
   implements EntityInterface
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name="fwdlgdcod", nullable=false)
   private Integer codigoLogradouro;
 
   @Column(name="fwdlgdcep", unique=true, nullable=false)
   private int cep;
 
   @Column(nullable=false, length=45)
   private String nomeLogradouro;
 
   @OneToMany(mappedBy="logradouro")
   private List<EnderecoPessoa> enderecoPessoas;
 
   @ManyToOne
   @JoinColumn(name="fwdcddcod", nullable=false)
   private Cidade cidade;
 
   @ManyToOne
   @JoinColumn(name="fwdtiplgdcod", nullable=false)
   private TipoLogradouro tipoLogradouro;
 
   public int getCep()
   {
     return this.cep;
   }
 
   public void setCep(int fwdlgdcep) {
     this.cep = fwdlgdcep;
   }
 
   public String getNomeLogradouro() {
     return this.nomeLogradouro;
   }
 
   public void setNomeLogradouro(String nomlgd) {
     this.nomeLogradouro = nomlgd;
   }
 
   public List<EnderecoPessoa> getListaEnderecoPessoa() {
     return this.enderecoPessoas;
   }
 
   public void setListaEnderecoPessoa(List<EnderecoPessoa> enderecoPessoas) {
     this.enderecoPessoas = enderecoPessoas;
   }
 
   public EnderecoPessoa addListaEnderecoPessoa(EnderecoPessoa enderecoPessoa) {
     getListaEnderecoPessoa().add(enderecoPessoa);
     enderecoPessoa.setLogradouro(this);
 
     return enderecoPessoa;
   }
 
   public EnderecoPessoa removeListaEnderecoPessoa(EnderecoPessoa enderecoPessoa) {
     getListaEnderecoPessoa().remove(enderecoPessoa);
     enderecoPessoa.setLogradouro(null);
 
     return enderecoPessoa;
   }
 
   public Cidade getCidade() {
     return this.cidade;
   }
 
   public void setCidade(Cidade cidade) {
     this.cidade = cidade;
   }
 
   public TipoLogradouro getTipoLogradouro() {
     return this.tipoLogradouro;
   }
 
   public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
     this.tipoLogradouro = tipoLogradouro;
   }
 }

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.entity.Logradouro
 * JD-Core Version:    0.6.0
 */