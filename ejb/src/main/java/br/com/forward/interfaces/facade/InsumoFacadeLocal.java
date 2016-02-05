/**
 * 
 */
package br.com.forward.interfaces.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.forward.common.InsumoVO;
import br.com.forward.exception.InsumoException;

/**
 * @author Herberth Nilsen
 *
 */
@Local
public interface InsumoFacadeLocal {

	public List<InsumoVO> carregarInsumos(InsumoVO paramInsumoVO);
	
	public List<InsumoVO> carregarSubItensInsumos(InsumoVO paramInsumoVO);

	public void salvar(InsumoVO paramInsumoVO) throws InsumoException;

	public void excluir(InsumoVO paramInsumoVO) throws InsumoException;
}
