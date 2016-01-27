/**
 * 
 */
package br.com.forward.interfaces.facade;

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
public interface UnidadeFacadeLocal {

	/**
	 * Carrega a lista para uma pesquisa
	 * 
	 * @param unidadeVO
	 * @return List<UnidadeVO>
	 */
	public List<UnidadeVO> carregarUnidades(UnidadeVO unidadeVO);
	
	/**
	 * Carrega a lista para um combo
	 * @return List<UnidadeVO>
	 */
	public List<UnidadeVO> carregarUnidades();

	/** Salva uma unidade
	 * @param unidadeVO
	 * @throws UnidadeException
	 */
	public void salvar(UnidadeVO unidadeVO) throws UnidadeException;

	/**
	 * Exclui uma unidade
	 * @param unidadeVO
	 * @throws UnidadeException
	 */
	public void excluir(UnidadeVO unidadeVO) throws UnidadeException;
	
}
