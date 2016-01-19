/**
 * 
 */
package br.com.forward.interfaces.business;

import java.util.List;

import br.com.forward.common.InsumoVO;

/**
 * @author Herberth Nilsen
 *
 */
public interface InsumoBusinessLocal {
	public List<InsumoVO> carregarInsumos(InsumoVO paramInsumoVO);

	public void salvar(InsumoVO paramInsumoVO);

	public void excluir(InsumoVO paramInsumoVO);
}
