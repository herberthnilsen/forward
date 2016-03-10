/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.common;

import java.io.Serializable;

import br.com.forward.enumcode.TipoServicoParceiroEnum;

/**
 * Classe responsável por ...
 *
 * @since 9 de mar de 2016 21:04:22
 * @version x.x
 */
public class ParceiroVO extends PessoaVO implements Serializable {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo tipoServicoEnum
	 */
	private TipoServicoParceiroEnum tipoServicoEnum;

	/**
	 * @return o valor do atributo tipoServicoEnum
	 */
	public TipoServicoParceiroEnum getTipoServicoEnum() {
		return this.tipoServicoEnum;
	}

	/**
	 * @param tipoServicoEnum o valor a ser atribuído no atributo tipoServicoEnum
	 */
	public void setTipoServicoEnum(TipoServicoParceiroEnum tipoServicoEnum) {
		this.tipoServicoEnum = tipoServicoEnum;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ParceiroVO [tipoServicoEnum=" + this.tipoServicoEnum + ", getCodigoPessoa()=" + this.getCodigoPessoa()
				+ ", getCnpjCpfPessoa()=" + this.getCnpjCpfPessoa() + ", getDataCadastro()=" + this.getDataCadastro()
				+ ", getDataNascimento()=" + this.getDataNascimento() + ", getNomePessoa()=" + this.getNomePessoa()
				+ ", getTipoPessoa()=" + this.getTipoPessoa() + ", toString()=" + super.toString() + ", getClass()="
				+ this.getClass() + "]";
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((this.tipoServicoEnum == null) ? 0 : this.tipoServicoEnum.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof ParceiroVO)) {
			return false;
		}
		final ParceiroVO other = (ParceiroVO) obj;
		if (this.tipoServicoEnum != other.tipoServicoEnum) {
			return false;
		}
		return true;
	}

}
