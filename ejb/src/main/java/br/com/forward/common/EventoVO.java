/**
 * 
 */
package br.com.forward.common;

import java.io.Serializable;
import java.util.Date;

import br.com.forward.enumcode.TipoEventoEnum;

/**
 * @author Herberth Nilsen
 */
public class EventoVO implements Serializable {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo tipoEvento
	 */
	private TipoEventoEnum tipoEvento;

	/**
	 * Atributo dataEvento
	 */
	private Date dataEvento;

	/**
	 * Atributo dataEventoFormatado
	 */
	private Date dataEventoFormatado;

	/**
	 * Atributo codigoEspaco
	 */
	private Integer codigoEspaco;

	/**
	 * Atributo codigoOrcamento
	 */
	private Long codigoOrcamento;

	/**
	 * @return o valor do atributo tipoEvento
	 */
	public TipoEventoEnum getTipoEvento() {
		return this.tipoEvento;
	}

	/**
	 * @param tipoEvento o valor a ser atribuído no atributo tipoEvento
	 */
	public void setTipoEvento(TipoEventoEnum tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	/**
	 * @return o valor do atributo dataEvento
	 */
	public Date getDataEvento() {
		return this.dataEvento;
	}

	/**
	 * @param dataEvento o valor a ser atribuído no atributo dataEvento
	 */
	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	/**
	 * @return o valor do atributo codigoEspaco
	 */
	public Integer getCodigoEspaco() {
		return this.codigoEspaco;
	}

	/**
	 * @param codigoEspaco o valor a ser atribuído no atributo codigoEspaco
	 */
	public void setCodigoEspaco(Integer codigoEspaco) {
		this.codigoEspaco = codigoEspaco;
	}

	/**
	 * @return o valor do atributo codigoOrcamento
	 */
	public Long getCodigoOrcamento() {
		return this.codigoOrcamento;
	}

	/**
	 * @param codigoOrcamento o valor a ser atribuído no atributo codigoOrcamento
	 */
	public void setCodigoOrcamento(Long codigoOrcamento) {
		this.codigoOrcamento = codigoOrcamento;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.codigoEspaco == null) ? 0 : this.codigoEspaco.hashCode());
		result = prime * result + ((this.codigoOrcamento == null) ? 0 : this.codigoOrcamento.hashCode());
		result = prime * result + ((this.dataEvento == null) ? 0 : this.dataEvento.hashCode());
		result = prime * result + ((this.dataEventoFormatado == null) ? 0 : this.dataEventoFormatado.hashCode());
		result = prime * result + ((this.tipoEvento == null) ? 0 : this.tipoEvento.hashCode());
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
		if (!(obj instanceof EventoVO)) {
			return false;
		}
		final EventoVO other = (EventoVO) obj;
		if (this.codigoEspaco == null) {
			if (other.codigoEspaco != null) {
				return false;
			}
		} else if (!this.codigoEspaco.equals(other.codigoEspaco)) {
			return false;
		}
		if (this.codigoOrcamento == null) {
			if (other.codigoOrcamento != null) {
				return false;
			}
		} else if (!this.codigoOrcamento.equals(other.codigoOrcamento)) {
			return false;
		}
		if (this.dataEvento == null) {
			if (other.dataEvento != null) {
				return false;
			}
		} else if (!this.dataEvento.equals(other.dataEvento)) {
			return false;
		}
		if (this.dataEventoFormatado == null) {
			if (other.dataEventoFormatado != null) {
				return false;
			}
		} else if (!this.dataEventoFormatado.equals(other.dataEventoFormatado)) {
			return false;
		}
		if (this.tipoEvento != other.tipoEvento) {
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
		return "EventoVO [tipoEvento=" + this.tipoEvento + ", dataEvento=" + this.dataEvento + ", dataEventoFormatado="
				+ this.dataEventoFormatado + ", codigoEspaco=" + this.codigoEspaco + ", codigoOrcamento=" + this.codigoOrcamento
				+ "]";
	}

	/**
	 * @return o valor do atributo dataEventoFormatado
	 */
	public Date getDataEventoFormatado() {
		return this.dataEventoFormatado;
	}

	/**
	 * @param dataEventoFormatado o valor a ser atribuído no atributo dataEventoFormatado
	 */
	public void setDataEventoFormatado(Date dataEventoFormatado) {
		this.dataEventoFormatado = dataEventoFormatado;
	}

}
