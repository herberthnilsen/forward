package br.com.forward.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the fwdtpoatd database table.
 * 
 */
@Entity
@Table(name="fwdtpoatd")
@NamedQuery(name="TipoAtendimento.findAll", query="SELECT t FROM TipoAtendimento t")
public class TipoAtendimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="fwdtpoatdid")
	private Integer codigoTipoAtendimento;

	@Column(name="dsctipoatd")
	private String descricaoTipoAtendimento;

	//bi-directional many-to-one association to Atendimento
	@OneToMany(mappedBy="fwdtpoatd")
	private List<Atendimento> atendimento;

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

	public List<Atendimento> getFwdatds() {
		return this.atendimento;
	}

	public void setFwdatds(List<Atendimento> atendimento) {
		this.atendimento = atendimento;
	}

	public Atendimento addFwdatd(Atendimento fwdatd) {
		getFwdatds().add(fwdatd);
		fwdatd.setFwdtpoatd(this);

		return fwdatd;
	}

	public Atendimento removeFwdatd(Atendimento fwdatd) {
		getFwdatds().remove(fwdatd);
		fwdatd.setFwdtpoatd(null);

		return fwdatd;
	}

}