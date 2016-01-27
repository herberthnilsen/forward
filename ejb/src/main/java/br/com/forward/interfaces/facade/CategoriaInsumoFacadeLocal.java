package br.com.forward.interfaces.facade;

import br.com.forward.common.CategoriaInsumoVO;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CategoriaInsumoFacadeLocal
{
  public  List<CategoriaInsumoVO> carregarCategoriaInsumos(CategoriaInsumoVO paramCategoriaInsumoVO);
  
  public  List<CategoriaInsumoVO> carregarCategoriaInsumos();

  public void salvar(CategoriaInsumoVO paramCategoriaInsumoVO);

  public void excluir(CategoriaInsumoVO paramCategoriaInsumoVO);
}

