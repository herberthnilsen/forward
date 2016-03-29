package br.com.forward.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the fwdtpoatd database table.
 */
@Entity
@Table(name = "fwdtpoatd")
@NamedQuery(name = "TipoAtendimento.findAll", query = "SELECT t FROM TipoAtendimento t")
public class TipoAtendimento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fwdtpoatdid")
	private Integer codigoTipoAtendimento;

	@Column(name = "dsctipoatd")
	private String descricaoTipoAtendimento;

	public TipoAtendimento() {
	}

	public Integer getCodigoTipoAtendimento() {
		return this.codigoTipoAtendimento;
	}

	public void setCodigoTipoAtendimento(Integer codigoTipoAtendimento) {
		this.codigoTipoAtendimento = codigoTipoAtendimento;
	}

	public String getDescricaoTipoAtendimento() {
		return this.descricaoTipoAtendimento;
	}

	public void setDescricaoTipoAtendimento(String descricaoTipoAtendimento) {
		this.descricaoTipoAtendimento = descricaoTipoAtendimento;
	}

}