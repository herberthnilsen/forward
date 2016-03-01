package br.com.forward.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the fwdatd database table.
 * 
 */
@Entity
@Table(name="fwdatd")
@NamedQuery(name="Atendimento.findAll", query="SELECT a FROM Atendimento a")
public class Atendimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="fwdatdid")
	private Long codigoAtendimento;

	@Column(name="dscatd")
	private String descricaoAtendimento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dtacadatd")
	private Date dataCadastroAtendimento;

	//bi-directional many-to-one association to Prospeccao
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idfwdppc")
	private Prospeccao fwdppc;

	//bi-directional many-to-one association to TipoAtendimento
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fwdtpoatdid")
	private TipoAtendimento fwdtpoatd;

	public Atendimento() {
	}

	public Long getCodigoAtendimento() {
		return this.codigoAtendimento;
	}

	public void setCodigoAtendimento(Long codigoAtendimento) {
		this.codigoAtendimento = codigoAtendimento;
	}

	public String getDescricaoAtendimento() {
		return this.descricaoAtendimento;
	}

	public void setDescricaoAtendimento(String descricaoAtendimento) {
		this.descricaoAtendimento = descricaoAtendimento;
	}

	public Date getDataCadastroAtendimento() {
		return this.dataCadastroAtendimento;
	}

	public void setDataCadastroAtendimento(Date dataCadastroAtendimento) {
		this.dataCadastroAtendimento = dataCadastroAtendimento;
	}

	public Prospeccao getFwdppc() {
		return this.fwdppc;
	}

	public void setFwdppc(Prospeccao fwdppc) {
		this.fwdppc = fwdppc;
	}

	public TipoAtendimento getFwdtpoatd() {
		return this.fwdtpoatd;
	}

	public void setFwdtpoatd(TipoAtendimento fwdtpoatd) {
		this.fwdtpoatd = fwdtpoatd;
	}

}