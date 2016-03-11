package br.com.forward.interfaces.business;

import java.util.List;

import javax.ejb.Local;

import br.com.forward.common.CategoriaInsumoVO;

@Local
public abstract interface CategoriaInsumoBusinessLocal {

	public abstract List<CategoriaInsumoVO> carregarCategoriaInsumo(CategoriaInsumoVO paramCategoriaInsumoVO);

	public abstract List<CategoriaInsumoVO> carregarCategoriaInsumo();

	public abstract void salvar(CategoriaInsumoVO paramCategoriaInsumoVO);

	public abstract void excluir(CategoriaInsumoVO paramCategoriaInsumoVO);
}
