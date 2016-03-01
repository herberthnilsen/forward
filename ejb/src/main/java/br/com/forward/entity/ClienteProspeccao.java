package br.com.forward.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the fwdcltpcc database table.
 * 
 */
@Entity
@Table(name="fwdcltpcc")
@NamedQuery(name="ClienteProspeccao.findAll", query="SELECT c FROM ClienteProspeccao c")
public class ClienteProspeccao implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ClienteProspeccaoPK id;

	//bi-directional many-to-one association to Prospeccao
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idfwdppc", insertable=false, updatable=false)
	private Prospeccao fwdppc;

	public ClienteProspeccao() {
	}

	public ClienteProspeccaoPK getId() {
		return this.id;
	}

	public void setId(ClienteProspeccaoPK id) {
		this.id = id;
	}

	public Prospeccao getFwdppc() {
		return this.fwdppc;
	}

	public void setFwdppc(Prospeccao fwdppc) {
		this.fwdppc = fwdppc;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fwdppc == null) ? 0 : fwdppc.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (!(obj instanceof ClienteProspeccao))
			return false;
		ClienteProspeccao other = (ClienteProspeccao) obj;
		if (fwdppc == null) {
			if (other.fwdppc != null)
				return false;
		} else if (!fwdppc.equals(other.fwdppc))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}