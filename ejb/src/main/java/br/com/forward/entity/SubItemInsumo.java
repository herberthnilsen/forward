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

	/**
	 * @return the insumoPai
	 */
	public Insumo getInsumoPai() {
		return insumoPai;
	}

	/**
	 * @param insumoPai the insumoPai to set
	 */
	public void setInsumoPai(Insumo insumoPai) {
		this.insumoPai = insumoPai;
	}

	/**
	 * @return the subItemInsumo
	 */
	public Insumo getSubItemInsumo() {
		return subItemInsumo;
	}

	/**
	 * @param subItemInsumo the subItemInsumo to set
	 */
	public void setSubItemInsumo(Insumo subItemInsumo) {
		this.subItemInsumo = subItemInsumo;
	}
	
}
