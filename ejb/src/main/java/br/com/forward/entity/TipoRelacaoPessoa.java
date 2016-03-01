package br.com.forward.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the fwdtporelpes database table.
 * 
 */
@Entity
@Table(name="fwdtporelpes")
@NamedQuery(name="TipoRelacaoPessoa.findAll", query="SELECT t FROM TipoRelacaoPessoa t")
public class TipoRelacaoPessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="fwdtporelpesid")
	private Integer codigoTipoRelacaoPessoa;

	@Column(name="dsctporelpes")
	private String descricaoRelacaoPessoa;

	public TipoRelacaoPessoa() {
	}

	public Integer getCodigoTipoRelacaoPessoa() {
		return this.codigoTipoRelacaoPessoa;
	}

	public void setCodigoTipoRelacaoPessoa(Integer codigoTipoRelacaoPessoa) {
		this.codigoTipoRelacaoPessoa = codigoTipoRelacaoPessoa;
	}

	public String getDescricaoRelacaoPessoa() {
		return this.descricaoRelacaoPessoa;
	}

	public void setDescricaoRelacaoPessoa(String descricaoRelacaoPessoa) {
		this.descricaoRelacaoPessoa = descricaoRelacaoPessoa;
	}

}