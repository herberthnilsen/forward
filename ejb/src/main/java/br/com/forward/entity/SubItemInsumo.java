package br.com.forward.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fwdsubitm")
public class SubItemInsumo {

	@EmbeddedId
	private SubItemInsumoPK subItemPK;

	@ManyToOne
	@JoinColumn(name = "idfwdinspai", insertable = false, updatable = false, unique = true, nullable = false)
	private Insumo insumoPai;

	@ManyToOne
	@JoinColumn(name = "subfwdinsid", insertable = false, updatable = false, unique = true, nullable = false)
	private Insumo subItemInsumo;

	public SubItemInsumoPK getSubItemPK() {
		return this.subItemPK;
	}

	public void setSubItemPK(SubItemInsumoPK subItemPK) {
		this.subItemPK = subItemPK;
	}
}
