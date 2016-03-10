package br.com.forward.bean;

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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flagShowForm == null) ? 0 : flagShowForm.hashCode());
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
		if (!(obj instanceof BasicBean))
			return false;
		BasicBean other = (BasicBean) obj;
		if (flagShowForm == null) {
			if (other.flagShowForm != null)
				return false;
		} else if (!flagShowForm.equals(other.flagShowForm))
			return false;
		return true;
	}

}