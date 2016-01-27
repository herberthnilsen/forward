/**
 * 
 */
package br.com.forward.interfaces.business;

import java.util.List;

import javax.ejb.Local;

import br.com.forward.common.UnidadeVO;
import br.com.forward.exception.InsumoException;
import br.com.forward.exception.UnidadeException;

/**
 * @author Herberth Nilsen
 *
 */
@Local
public interface UnidadeBusinessLocal {

	public List<UnidadeVO> carregarUnidades(UnidadeVO unidadeVO);
	
	public List<UnidadeVO> carregarUnidades();

	public void salvar(UnidadeVO unidadeVO) throws UnidadeException;

	public void excluir(UnidadeVO unidadeVO) throws UnidadeException;
	
}
