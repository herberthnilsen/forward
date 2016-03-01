package br.com.forward.entity;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "fwdevt")
@NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e")
public class Evento implements EntityInterface {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="fwdevtcod",unique = true, nullable = false)
	private BigInteger codigoEvento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dataEvento;

	@OneToMany(mappedBy = "evento", fetch=FetchType.LAZY)
	private List<AlocacaoInsumo> alocacaoInsumos;

	@ManyToOne( fetch=FetchType.LAZY)
	@JoinColumn(name = "fwdtipevtcod", nullable = false)
	private TipoEvento tipoEvento;

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "fwdevtclt", joinColumns = {
			@JoinColumn(name = "fwdevtcod", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "fwdcltcod", nullable = false) })
	private List<Cliente> clientes;

	@OneToMany(mappedBy = "evento", fetch=FetchType.LAZY)
	private List<PacoteEvento> pacoteEventos;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fwdespid", nullable=false)
	private Espaco espaco;
	
	@OneToOne(mappedBy="evento", fetch=FetchType.LAZY)
	private EventoCliente eventoCliente;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fwdorcid")
	private Orcamento orcamento;
	
	public BigInteger getCodigoEvento() {
		return this.codigoEvento;
	}

	public void setCodigoEvento(BigInteger codigoEvento) {
		this.codigoEvento = codigoEvento;
	}

	public Date getDataEvento() {
		return this.dataEvento;
	}

	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	public List<AlocacaoInsumo> getListaAlocacaoInsumos() {
		return this.alocacaoInsumos;
	}

	public void setListaAlocacaoInsumo(List<AlocacaoInsumo> listaAlocacaoInsumo) {
		this.alocacaoInsumos = listaAlocacaoInsumo;
	}

	public AlocacaoInsumo addListaAlocacaoInsumo(AlocacaoInsumo alocacaoInsumo) {
		getListaAlocacaoInsumos().add(alocacaoInsumo);
		alocacaoInsumo.setEvento(this);

		return alocacaoInsumo;
	}

	public AlocacaoInsumo removeListaAlocacaoInsumo(AlocacaoInsumo alocacaoInsumo) {
		getListaAlocacaoInsumos().remove(alocacaoInsumo);
		alocacaoInsumo.setEvento(null);

		return alocacaoInsumo;
	}

	public TipoEvento getTipoEvento() {
		return this.tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public List<Cliente> getListaClientes() {
		return this.clientes;
	}

	public void setListaClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<PacoteEvento> getListaPacoteEventos() {
		return this.pacoteEventos;
	}

	public void setListaPacoteEventos(List<PacoteEvento> pacoteEventos) {
		this.pacoteEventos = pacoteEventos;
	}

	public PacoteEvento addListaPacoteEventos(PacoteEvento pacoteEvento) {
		getListaPacoteEventos().add(pacoteEvento);
		pacoteEvento.setEvento(this);

		return pacoteEvento;
	}

	public PacoteEvento removeListaPacoteEventos(PacoteEvento pacoteEvento) {
		getListaPacoteEventos().remove(pacoteEvento);
		pacoteEvento.setEvento(null);

		return pacoteEvento;
	}

	/**
	 * @return the espaco
	 */
	public Espaco getEspaco() {
		return espaco;
	}

	/**
	 * @param espaco the espaco to set
	 */
	public void setEspaco(Espaco espaco) {
		this.espaco = espaco;
	}

	/**
	 * @return the alocacaoInsumos
	 */
	public List<AlocacaoInsumo> getAlocacaoInsumos() {
		return alocacaoInsumos;
	}

	/**
	 * @param alocacaoInsumos the alocacaoInsumos to set
	 */
	public void setAlocacaoInsumos(List<AlocacaoInsumo> alocacaoInsumos) {
		this.alocacaoInsumos = alocacaoInsumos;
	}

	/**
	 * @return the clientes
	 */
	public List<Cliente> getClientes() {
		return clientes;
	}

	/**
	 * @param clientes the clientes to set
	 */
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	/**
	 * @return the pacoteEventos
	 */
	public List<PacoteEvento> getPacoteEventos() {
		return pacoteEventos;
	}

	/**
	 * @param pacoteEventos the pacoteEventos to set
	 */
	public void setPacoteEventos(List<PacoteEvento> pacoteEventos) {
		this.pacoteEventos = pacoteEventos;
	}

	/**
	 * @return the eventoCliente
	 */
	public EventoCliente getEventoCliente() {
		return eventoCliente;
	}

	/**
	 * @param eventoCliente the eventoCliente to set
	 */
	public void setEventoCliente(EventoCliente eventoCliente) {
		this.eventoCliente = eventoCliente;
	}

	/**
	 * @return the orcamento
	 */
	public Orcamento getOrcamento() {
		return orcamento;
	}

	/**
	 * @param orcamento the orcamento to set
	 */
	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alocacaoInsumos == null) ? 0 : alocacaoInsumos.hashCode());
		result = prime * result + ((clientes == null) ? 0 : clientes.hashCode());
		result = prime * result + ((codigoEvento == null) ? 0 : codigoEvento.hashCode());
		result = prime * result + ((dataEvento == null) ? 0 : dataEvento.hashCode());
		result = prime * result + ((espaco == null) ? 0 : espaco.hashCode());
		result = prime * result + ((eventoCliente == null) ? 0 : eventoCliente.hashCode());
		result = prime * result + ((orcamento == null) ? 0 : orcamento.hashCode());
		result = prime * result + ((pacoteEventos == null) ? 0 : pacoteEventos.hashCode());
		result = prime * result + ((tipoEvento == null) ? 0 : tipoEvento.hashCode());
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
		if (!(obj instanceof Evento))
			return false;
		Evento other = (Evento) obj;
		if (alocacaoInsumos == null) {
			if (other.alocacaoInsumos != null)
				return false;
		} else if (!alocacaoInsumos.equals(other.alocacaoInsumos))
			return false;
		if (clientes == null) {
			if (other.clientes != null)
				return false;
		} else if (!clientes.equals(other.clientes))
			return false;
		if (codigoEvento == null) {
			if (other.codigoEvento != null)
				return false;
		} else if (!codigoEvento.equals(other.codigoEvento))
			return false;
		if (dataEvento == null) {
			if (other.dataEvento != null)
				return false;
		} else if (!dataEvento.equals(other.dataEvento))
			return false;
		if (espaco == null) {
			if (other.espaco != null)
				return false;
		} else if (!espaco.equals(other.espaco))
			return false;
		if (eventoCliente == null) {
			if (other.eventoCliente != null)
				return false;
		} else if (!eventoCliente.equals(other.eventoCliente))
			return false;
		if (orcamento == null) {
			if (other.orcamento != null)
				return false;
		} else if (!orcamento.equals(other.orcamento))
			return false;
		if (pacoteEventos == null) {
			if (other.pacoteEventos != null)
				return false;
		} else if (!pacoteEventos.equals(other.pacoteEventos))
			return false;
		if (tipoEvento == null) {
			if (other.tipoEvento != null)
				return false;
		} else if (!tipoEvento.equals(other.tipoEvento))
			return false;
		return true;
	}

}