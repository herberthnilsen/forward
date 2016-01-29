package br.com.forward.insumos.bean;

import java.io.Serializable;

public abstract class BasicBean implements Serializable {
	private static final long serialVersionUID = 1L;
	protected String flagShowForm = Boolean.FALSE.toString();

	public void toogleForm() {
		if (this.flagShowForm.equals(Boolean.TRUE.toString())) {
			this.flagShowForm = Boolean.FALSE.toString();
		} else {
			this.flagShowForm = Boolean.TRUE.toString();
		}
	}

	public void showForm() {
		this.flagShowForm = Boolean.TRUE.toString();
	}

	public void hideForm() {
		this.flagShowForm = Boolean.FALSE.toString();
		this.reset();
	}

	public String getFlagShowForm() {
		return this.flagShowForm;
	}

	public void setFlagShowForm(Boolean flagShowForm) {
		this.flagShowForm = flagShowForm.toString();
	}

	public abstract void pesquisar();

	public abstract void reset();

	public abstract void salvar();

	public abstract void excluir();
}