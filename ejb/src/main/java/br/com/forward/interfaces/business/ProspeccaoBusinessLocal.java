/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.interfaces.business;

import java.util.List;

import javax.ejb.Local;

import br.com.forward.common.ProspeccaoVO;

/**
 * Classe responsável por ...
 *
 * @since 11 de mar de 2016 19:52:31
 * @version x.x
 */
@Local
public interface ProspeccaoBusinessLocal {

	/**
	 * Método responsável por consultar prospecções
	 *
	 * @since 14 de mar de 2016 21:56:19
	 * @return
	 */
	public List<ProspeccaoVO> consultarProspeccoes();

	/**
	 * Método responsável por salvar uma prospeccção
	 *
	 * @since 14 de mar de 2016 21:55:25
	 * @param prospeccao
	 */
	public void salvarPropeccao(ProspeccaoVO prospeccao);

	/**
	 * Método responsável por ...
	 *
	 * @since 14 de mar de 2016 21:55:26
	 * @param prospeccao
	 */
	public void excluirPropeccao(ProspeccaoVO prospeccao);

}
