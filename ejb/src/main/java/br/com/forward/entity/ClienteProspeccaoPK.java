package br.com.forward.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the fwdcltpcc database table.
 * 
 */
@Embeddable
public class ClienteProspeccaoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int fwdcltcod;

	@Column(insertable=false, updatable=false)
	private String idfwdppc;

	public ClienteProspeccaoPK() {
	}
	public int getFwdcltcod() {
		return this.fwdcltcod;
	}
	public void setFwdcltcod(int fwdcltcod) {
		this.fwdcltcod = fwdcltcod;
	}
	public String getIdfwdppc() {
		return this.idfwdppc;
	}
	public void setIdfwdppc(String idfwdppc) {
		this.idfwdppc = idfwdppc;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ClienteProspeccaoPK)) {
			return false;
		}
		ClienteProspeccaoPK castOther = (ClienteProspeccaoPK)other;
		return 
			(this.fwdcltcod == castOther.fwdcltcod)
			&& this.idfwdppc.equals(castOther.idfwdppc);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.fwdcltcod;
		hash = hash * prime + this.idfwdppc.hashCode();
		
		return hash;
	}
}