/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.interfaces.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.forward.common.ParceiroVO;
import br.com.forward.common.PessoaVO;
import br.com.forward.common.ProspeccaoVO;

/**
 * Classe responsável por ...
 *
 * @since 11 de mar de 2016 19:52:31
 * @version x.x
 */
@Local
public interface ProspeccaoFacadeLocal {

	/**
	 * Método responsável por salvar uma prospecção
	 *
	 * @since 11 de mar de 2016 20:22:55
	 * @param prospeccao
	 */
	public void salvarPropeccao(ProspeccaoVO prospeccao);

	/**
	 * Método responsável por carregar lista de Colaboradores
	 *
	 * @since 11 de mar de 2016 20:25:03
	 * @return
	 */
	List<PessoaVO> carregarColaboradores();

	/**
	 * Método responsável por carregar lista de parceiros
	 * 
	 * @return
	 * @since 11 de mar de 2016 20:22:15
	 */
	List<ParceiroVO> carregarParceiros();

}
