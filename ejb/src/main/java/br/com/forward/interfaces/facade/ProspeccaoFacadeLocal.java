/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.interfaces.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.forward.common.AtendimentoVO;
import br.com.forward.common.ColaboradorVO;
import br.com.forward.common.ParceiroVO;
import br.com.forward.common.ProspeccaoVO;
import br.com.forward.exception.EntityManagerException;
import br.com.forward.exception.ProspeccaoException;

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
	 * @throws ProspeccaoException
	 */
	public void salvarPropeccao(ProspeccaoVO prospeccao) throws ProspeccaoException;

	/**
	 * Método responsável por carregar lista de Colaboradores
	 *
	 * @since 11 de mar de 2016 20:25:03
	 * @return
	 * @throws EntityManagerException
	 */
	List<ColaboradorVO> carregarColaboradores() throws EntityManagerException;

	/**
	 * Método responsável por carregar lista de parceiros
	 * 
	 * @return
	 * @throws EntityManagerException
	 * @since 11 de mar de 2016 20:22:15
	 */
	List<ParceiroVO> carregarParceiros() throws EntityManagerException;

	/**
	 * Método responsável por listar os atendimentos da prospecção
	 *
	 * @since 29 de mar de 2016 21:11:43
	 * @param codigoProspeccao
	 * @return
	 * @throws EntityManagerException
	 */
	List<AtendimentoVO> carregarAtendimentosPorProspeccao(Long codigoProspeccao) throws EntityManagerException;

}
