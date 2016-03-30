/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.interfaces.business;

import java.util.List;

import javax.ejb.Local;

import br.com.forward.common.AtendimentoVO;
import br.com.forward.exception.EntityManagerException;

/**
 * Classe responsável por ...
 *
 * @since 11 de mar de 2016 19:52:31
 * @version x.x
 */
@Local
public interface AtendimentoBusinessLocal {

	/**
	 * Método responsável por consultar atendimentos
	 *
	 * @since 14 de mar de 2016 21:56:19
	 * @return
	 */
	public List<AtendimentoVO> consultarAtendimentos();

	/**
	 * Método responsável por consultar os atendimentos de uma prospecção
	 *
	 * @since 29 de mar de 2016 20:52:35
	 * @return
	 * @throws EntityManagerException
	 */
	public List<AtendimentoVO> consultarAtendimentosPorProspeccao(Long codigoProspeccao) throws EntityManagerException;

	/**
	 * Método responsável por salvar um atendimento
	 *
	 * @since 14 de mar de 2016 21:55:25
	 * @param atendimento
	 */
	public void salvarAtendimento(AtendimentoVO atendimentoVO);

	/**
	 * Método responsável por um atendimento
	 *
	 * @since 14 de mar de 2016 21:55:26
	 * @param atendimento
	 */
	public void excluirAtendimento(AtendimentoVO atendimentoVO);

}
