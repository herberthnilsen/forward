package br.com.forward.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the fwdorcstt database table.
 * 
 */
@Entity
@Table(name="fwdorcstt")
@NamedQuery(name="OrcamentoSituacao.findAll", query="SELECT o FROM OrcamentoSituacao o")
public class OrcamentoSituacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="fwdorcsttid")
	private Integer codigoOrcamentoSituacao;

	@Column(name="dscstt")
	private String descricaoSituacao;

	public OrcamentoSituacao() {
	}

	public Integer getCodigoOrcamentoSituacao() {
		return this.codigoOrcamentoSituacao;
	}

	public void setCodigoOrcamentoSituacao(Integer codigoOrcamentoSituacao) {
		this.codigoOrcamentoSituacao = codigoOrcamentoSituacao;
	}

	public String getDescricaoSituacao() {
		return this.descricaoSituacao;
	}

	public void setDescricaoSituacao(String descricaoSituacao) {
		this.descricaoSituacao = descricaoSituacao;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoOrcamentoSituacao == null) ? 0 : codigoOrcamentoSituacao.hashCode());
		result = prime * result + ((descricaoSituacao == null) ? 0 : descricaoSituacao.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof OrcamentoSituacao))
			return false;
		OrcamentoSituacao other = (OrcamentoSituacao) obj;
		if (codigoOrcamentoSituacao == null) {
			if (other.codigoOrcamentoSituacao != null)
				return false;
		} else if (!codigoOrcamentoSituacao.equals(other.codigoOrcamentoSituacao))
			return false;
		if (descricaoSituacao == null) {
			if (other.descricaoSituacao != null)
				return false;
		} else if (!descricaoSituacao.equals(other.descricaoSituacao))
			return false;
		return true;
	}
	

}