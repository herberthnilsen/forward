package br.com.forward.interfaces.business;

import java.util.List;

import br.com.forward.common.ParceiroVO;
import br.com.forward.exception.EntityManagerException;

/**
 * Classe responsável por ...
 *
 * @since 14 de mar de 2016 21:56:52
 * @version x.x
 */
public interface ParceiroBusinessLocal {

	/**
	 * Método responsável por listas as prospecções cadastradas
	 *
	 * @since 5 de abr de 2016 10:11:06
	 * @return
	 * @throws EntityManagerException
	 */
	public List<ParceiroVO> listarParceiros() throws EntityManagerException;

}
