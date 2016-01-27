package br.com.forward.interfaces.business;

import br.com.forward.common.CategoriaInsumoVO;
import java.util.List;
import javax.ejb.Local;

@Local
public abstract interface CategoriaInsumoBusinessLocal
{
  public abstract List<CategoriaInsumoVO> carregarCategoriaInsumo(CategoriaInsumoVO paramCategoriaInsumoVO);
  
  public abstract List<CategoriaInsumoVO> carregarCategoriaInsumo();

  public abstract void salvar(CategoriaInsumoVO paramCategoriaInsumoVO);

  public abstract void excluir(CategoriaInsumoVO paramCategoriaInsumoVO);
}

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.interfaces.business.CategoriaInsumoBusinessLocal
 * JD-Core Version:    0.6.0
 */