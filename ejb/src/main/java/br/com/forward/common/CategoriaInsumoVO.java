package br.com.forward.common;

import java.io.Serializable;

public class CategoriaInsumoVO implements Serializable {
	private static final long serialVersionUID = 4697695075879918148L;
	private Integer codigoCategoriaInsumo;
	private String nomeCategoria = new String();

	private String descricaoCategoria = new String();

	public Integer getCodigoCategoria() {
		return this.codigoCategoriaInsumo;
	}

	public void setCodigoCategoria(Integer codigoCategoria) {
		this.codigoCategoriaInsumo = codigoCategoria;
	}

	public String getNomeCategoria() {
		return this.nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getDescricaoCategoria() {
		return this.descricaoCategoria;
	}

	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}
}

/*
 * Location: D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name: br.com.forward.common.CategoriaInsumoVO JD-Core Version:
 * 0.6.0
 */