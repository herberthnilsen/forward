package br.com.forward.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the fwdrno database table.
 * 
 */
@Entity
@Table(name="fwdrno")
@NamedQuery(name="Reuniao.findAll", query="SELECT r FROM Reuniao r")
public class Reuniao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="fwdrnoid")
	private Long codigoReuniao;

	@Column(name="dscastrno")
	private String descricaoAssuntoReuniao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dtacadrno")
	private Date dataCadastroReuniao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dtahrarno")
	private Date dataHoraReuniao;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fwdclbcod")
	private Colaborador colaborador;

	//bi-directional many-to-one association to Prospeccao
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idfwdppc")
	private Prospeccao fwdppc;

	public Reuniao() {
	}

	public Long getCodigoReuniao() {
		return this.codigoReuniao;
	}

	public void setCodigoReuniao(Long codigoReuniao) {
		this.codigoReuniao = codigoReuniao;
	}

	public String getDescricaoAssuntoReuniao() {
		return this.descricaoAssuntoReuniao;
	}

	public void setDescricaoAssuntoReuniao(String descricaoAssuntoReuniao) {
		this.descricaoAssuntoReuniao = descricaoAssuntoReuniao;
	}

	public Date getDataCadastroReuniao() {
		return this.dataCadastroReuniao;
	}

	public void setDataCadastroReuniao(Date dataCadastroReuniao) {
		this.dataCadastroReuniao = dataCadastroReuniao;
	}

	public Date getDataHoraReuniao() {
		return this.dataHoraReuniao;
	}

	public void setDataHoraReuniao(Date dataHoraReuniao) {
		this.dataHoraReuniao = dataHoraReuniao;
	}

	public Colaborador getColaborador() {
		return this.colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public Prospeccao getFwdppc() {
		return this.fwdppc;
	}

	public void setFwdppc(Prospeccao fwdppc) {
		this.fwdppc = fwdppc;
	}

}