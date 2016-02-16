package br.com.forward.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Espaco
 *
 */
@Entity
@Table(name="fwdesp")
@NamedQuery(name = "Espaco.findAll", query = "SELECT e FROM Espaco e")
public class Espaco implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="fwdespid", nullable=false)
	private Integer codigoEspaco;
	
	@Column(name="nomesp", nullable=false, length=100)
	private String nomeEspaco;
   
	@Column(name="numtelesp", length=10, nullable=false)
	private BigInteger numeroTelefone;
	
	@Column(name="numcelesp", nullable=true, length=11)
	private BigInteger numeroCelular;
	
	@Column(name="nomrspesp")
	private String nomeResponsavelEspaco;
	
	@Column(name="dscemlesp", nullable=false, length=150)
	private String emailEspaco;
	
	@OneToOne(mappedBy="espaco")
	private Evento evento;
	
	@OneToOne
	@JoinColumn(name="fwdlgdcod", nullable=false)
	private Logradouro logradouro;

	/**
	 * @return the codigoEspaco
	 */
	public Integer getCodigoEspaco() {
		return codigoEspaco;
	}

	/**
	 * @param codigoEspaco the codigoEspaco to set
	 */
	public void setCodigoEspaco(Integer codigoEspaco) {
		this.codigoEspaco = codigoEspaco;
	}

	/**
	 * @return the nomeEspaco
	 */
	public String getNomeEspaco() {
		return nomeEspaco;
	}

	/**
	 * @param nomeEspaco the nomeEspaco to set
	 */
	public void setNomeEspaco(String nomeEspaco) {
		this.nomeEspaco = nomeEspaco;
	}

	/**
	 * @return the numeroTelefone
	 */
	public BigInteger getNumeroTelefone() {
		return numeroTelefone;
	}

	/**
	 * @param numeroTelefone the numeroTelefone to set
	 */
	public void setNumeroTelefone(BigInteger numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	/**
	 * @return the numeroCelular
	 */
	public BigInteger getNumeroCelular() {
		return numeroCelular;
	}

	/**
	 * @param numeroCelular the numeroCelular to set
	 */
	public void setNumeroCelular(BigInteger numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	/**
	 * @return the nomeResponsavelEspaco
	 */
	public String getNomeResponsavelEspaco() {
		return nomeResponsavelEspaco;
	}

	/**
	 * @param nomeResponsavelEspaco the nomeResponsavelEspaco to set
	 */
	public void setNomeResponsavelEspaco(String nomeResponsavelEspaco) {
		this.nomeResponsavelEspaco = nomeResponsavelEspaco;
	}

	/**
	 * @return the emailEspaco
	 */
	public String getEmailEspaco() {
		return emailEspaco;
	}

	/**
	 * @param emailEspaco the emailEspaco to set
	 */
	public void setEmailEspaco(String emailEspaco) {
		this.emailEspaco = emailEspaco;
	}

	/**
	 * @return the logradouro
	 */
	public Logradouro getLogradouro() {
		return logradouro;
	}

	/**
	 * @param logradouro the logradouro to set
	 */
	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}
	
}
