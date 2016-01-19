/**
 * 
 */
package br.com.forward.interfaces.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.forward.common.InsumoVO;

/**
 * @author Herberth Nilsen
 *
 */
@Local
public interface InsumoFacadeLocal {

	public List<InsumoVO> carregarInsumos(InsumoVO paramInsumoVO);

	public void salvar(InsumoVO paramInsumoVO);

	public void excluir(InsumoVO paramInsumoVO);
}
