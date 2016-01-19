package br.com.forward.interfaces.facade;

import br.com.forward.common.CategoriaInsumoVO;
import java.util.List;
import javax.ejb.Local;

@Local
public abstract interface CategoriaInsumoFacadeLocal
{
  public abstract List<CategoriaInsumoVO> carregarCategoriaInsumos(CategoriaInsumoVO paramCategoriaInsumoVO);

  public abstract void salvar(CategoriaInsumoVO paramCategoriaInsumoVO);

  public abstract void excluir(CategoriaInsumoVO paramCategoriaInsumoVO);
}

/* Location:           D:\Projetos\Showtime\bkpforward-ear.ear - Copia\forward-ejb.jar\
 * Qualified Name:     br.com.forward.interfaces.facade.CategoriaInsumoFacadeLocal
 * JD-Core Version:    0.6.0
 */