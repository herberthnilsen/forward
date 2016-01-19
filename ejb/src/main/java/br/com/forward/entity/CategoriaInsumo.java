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
@Table(name = "fwdcatins")
@NamedQuery(name = "CategoriaInsumo.findAll", query = "SELECT f FROM CategoriaInsumo f order by f.codigoCategoriaInsumo")
public class CategoriaInsumo implements EntityInterface {
	private static final long serialVersionUID = 1L;
	public static final String NQ_FIND_ALL = "CategoriaInsumo.findAll";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fwdcatinscod", unique = true, nullable = false)
	private Integer codigoCategoriaInsumo;

	@Column(name = "dsccat", length = 45)
	private String descricaoCategoria;

	@Column(name = "nomcat", nullable = false, length = 45)
	private String nomeCategoria;

	@OneToMany(mappedBy = "categoriaInsumo")
	private List<Insumo> insumos;

	public Integer getCodigoCategoriaInsumo() {
		return this.codigoCategoriaInsumo;
	}

	public void setCodigoCategoriaInsumo(Integer codigoCategoriaInsumo) {
		this.codigoCategoriaInsumo = codigoCategoriaInsumo;
	}

	public String getDescricaoCategoria() {
		return this.descricaoCategoria;
	}

	public void setDescricaoCategoria(String dsccat) {
		this.descricaoCategoria = dsccat;
	}

	public String getNomeCategoria() {
		return this.nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public List<Insumo> getListaInsumos() {
		return this.insumos;
	}

	public void setListaInsumos(List<Insumo> insumos) {
		this.insumos = insumos;
	}

	public Insumo addListaInsumos(Insumo insumo) {
		getListaInsumos().add(insumo);
		insumo.setCategoriaInsumo(this);

		return insumo;
	}

	public Insumo removeListaInsumos(Insumo insumo) {
		getListaInsumos().remove(insumo);
		insumo.setCategoriaInsumo(null);

		return insumo;
	}
}
