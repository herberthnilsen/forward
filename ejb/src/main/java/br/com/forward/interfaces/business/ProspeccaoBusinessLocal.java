/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.interfaces.business;

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

	public void salvarPropeccao(ProspeccaoVO prospeccao);

	public void excluirPropeccao(ProspeccaoVO prospeccao);

}
