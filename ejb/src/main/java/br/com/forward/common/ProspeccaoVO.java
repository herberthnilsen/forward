/**
 * 
 */
package br.com.forward.common;

import java.io.Serializable;
import java.util.Date;

import br.com.forward.enumcode.StatusMarketingEnum;
import br.com.forward.enumcode.StatusProspeccaoEnum;

/**
 * @author Herberth Nilsen
 */
public class ProspeccaoVO implements Serializable {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo eventoVO
	 */
	private EventoVO eventoVO;

	/**
	 * Atributo colaborador
	 */
	private PessoaVO colaborador;

	/**
	 * Atributo status
	 */
	private StatusProspeccaoEnum status;

	/**
	 * Atributo statusMarketing
	 */
	private StatusMarketingEnum statusMarketing;

	/**
	 * Atributo dataPendencia
	 */
	private Date dataPendencia;

	/**
	 * Atributo horaPendencia
	 */
	private Date horaPendencia;

	/**
	 * Atributo parceiroIndicado
	 */
	private ParceiroVO parceiroIndicado;

	/**
	 * Atributo noiva
	 */
	private PessoaVO noiva;

	/**
	 * Atributo noivo
	 */
	private PessoaVO noivo;

	/**
	 * Construtor da classe ProspeccaoVO
	 */
	public ProspeccaoVO() {
		this.colaborador = new PessoaVO();
		this.eventoVO = new EventoVO();
		this.noiva = new PessoaVO();
		this.noivo = new PessoaVO();
		this.parceiroIndicado = new ParceiroVO();
	}

	/**
	 * @return o valor do atributo colaborador
	 */
	public PessoaVO getColaborador() {
		return this.colaborador;
	}

	/**
	 * @param colaborador o valor a ser atribuído no atributo colaborador
	 */
	public void setColaborador(PessoaVO colaborador) {
		this.colaborador = colaborador;
	}

	/**
	 * @return o valor do atributo status
	 */
	public StatusProspeccaoEnum getStatus() {
		return this.status;
	}

	/**
	 * @param status o valor a ser atribuído no atributo status
	 */
	public void setStatus(StatusProspeccaoEnum status) {
		this.status = status;
	}

	/**
	 * @return o valor do atributo statusMarketing
	 */
	public StatusMarketingEnum getStatusMarketing() {
		return this.statusMarketing;
	}

	/**
	 * @param statusMarketing o valor a ser atribuído no atributo statusMarketing
	 */
	public void setStatusMarketing(StatusMarketingEnum statusMarketing) {
		this.statusMarketing = statusMarketing;
	}

	/**
	 * @return o valor do atributo dataPendencia
	 */
	public Date getDataPendencia() {
		return this.dataPendencia;
	}

	/**
	 * @param dataPendencia o valor a ser atribuído no atributo dataPendencia
	 */
	public void setDataPendencia(Date dataPendencia) {
		this.dataPendencia = dataPendencia;
	}

	/**
	 * @return o valor do atributo horaPendencia
	 */
	public Date getHoraPendencia() {
		return this.horaPendencia;
	}

	/**
	 * @param horaPendencia o valor a ser atribuído no atributo horaPendencia
	 */
	public void setHoraPendencia(Date horaPendencia) {
		this.horaPendencia = horaPendencia;
	}

	/**
	 * @return o valor do atributo parceiroIndicado
	 */
	public ParceiroVO getParceiroIndicado() {
		return this.parceiroIndicado;
	}

	/**
	 * @param parceiroIndicado o valor a ser atribuído no atributo parceiroIndicado
	 */
	public void setParceiroIndicado(ParceiroVO parceiroIndicado) {
		this.parceiroIndicado = parceiroIndicado;
	}

	/**
	 * @return o valor do atributo noiva
	 */
	public PessoaVO getNoiva() {
		return this.noiva;
	}

	/**
	 * @param noiva o valor a ser atribuído no atributo noiva
	 */
	public void setNoiva(PessoaVO noiva) {
		this.noiva = noiva;
	}

	/**
	 * @return o valor do atributo noivo
	 */
	public PessoaVO getNoivo() {
		return this.noivo;
	}

	/**
	 * @param noivo o valor a ser atribuído no atributo noivo
	 */
	public void setNoivo(PessoaVO noivo) {
		this.noivo = noivo;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.colaborador == null) ? 0 : this.colaborador.hashCode());
		result = prime * result + ((this.dataPendencia == null) ? 0 : this.dataPendencia.hashCode());
		result = prime * result + ((this.eventoVO == null) ? 0 : this.eventoVO.hashCode());
		result = prime * result + ((this.horaPendencia == null) ? 0 : this.horaPendencia.hashCode());
		result = prime * result + ((this.noiva == null) ? 0 : this.noiva.hashCode());
		result = prime * result + ((this.noivo == null) ? 0 : this.noivo.hashCode());
		result = prime * result + ((this.parceiroIndicado == null) ? 0 : this.parceiroIndicado.hashCode());
		result = prime * result + ((this.status == null) ? 0 : this.status.hashCode());
		result = prime * result + ((this.statusMarketing == null) ? 0 : this.statusMarketing.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ProspeccaoVO)) {
			return false;
		}
		final ProspeccaoVO other = (ProspeccaoVO) obj;
		if (this.colaborador == null) {
			if (other.colaborador != null) {
				return false;
			}
		} else if (!this.colaborador.equals(other.colaborador)) {
			return false;
		}
		if (this.dataPendencia == null) {
			if (other.dataPendencia != null) {
				return false;
			}
		} else if (!this.dataPendencia.equals(other.dataPendencia)) {
			return false;
		}
		if (this.eventoVO == null) {
			if (other.eventoVO != null) {
				return false;
			}
		} else if (!this.eventoVO.equals(other.eventoVO)) {
			return false;
		}
		if (this.horaPendencia == null) {
			if (other.horaPendencia != null) {
				return false;
			}
		} else if (!this.horaPendencia.equals(other.horaPendencia)) {
			return false;
		}
		if (this.noiva == null) {
			if (other.noiva != null) {
				return false;
			}
		} else if (!this.noiva.equals(other.noiva)) {
			return false;
		}
		if (this.noivo == null) {
			if (other.noivo != null) {
				return false;
			}
		} else if (!this.noivo.equals(other.noivo)) {
			return false;
		}
		if (this.parceiroIndicado == null) {
			if (other.parceiroIndicado != null) {
				return false;
			}
		} else if (!this.parceiroIndicado.equals(other.parceiroIndicado)) {
			return false;
		}
		if (this.status != other.status) {
			return false;
		}
		if (this.statusMarketing != other.statusMarketing) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProspeccaoVO [eventoVO=" + this.eventoVO + ", colaborador=" + this.colaborador + ", status=" + this.status
				+ ", statusMarketing=" + this.statusMarketing + ", dataPendencia=" + this.dataPendencia + ", horaPendencia="
				+ this.horaPendencia + ", parceiroIndicado=" + this.parceiroIndicado + ", noiva=" + this.noiva + ", noivo="
				+ this.noivo + "]";
	}

	/**
	 * @return o valor do atributo eventoVO
	 */
	public EventoVO getEventoVO() {
		return this.eventoVO;
	}

	/**
	 * @param eventoVO o valor a ser atribuído no atributo eventoVO
	 */
	public void setEventoVO(EventoVO eventoVO) {
		this.eventoVO = eventoVO;
	}

}
