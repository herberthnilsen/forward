/**
 * 
 */
package br.com.forward.interfaces.business;

import java.util.List;

import br.com.forward.common.InsumoVO;
import br.com.forward.exception.InsumoException;

/**
 * @author Herberth Nilsen
 *
 */
public interface InsumoBusinessLocal {
	public List<InsumoVO> carregarInsumos(InsumoVO paramInsumoVO);
	
	public List<InsumoVO> carregarSubItensInsumos(InsumoVO paramInsumoVO);

	public void salvar(InsumoVO paramInsumoVO) throws InsumoException ;

	public void excluir(InsumoVO paramInsumoVO) throws InsumoException ;
}
