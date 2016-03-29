/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import br.com.forward.common.ColaboradorVO;
import br.com.forward.common.ParceiroVO;
import br.com.forward.common.ProspeccaoVO;
import br.com.forward.exception.EntityManagerException;
import br.com.forward.interfaces.business.ColaboradorBusinessLocal;
import br.com.forward.interfaces.business.ParceiroBusinessLocal;
import br.com.forward.interfaces.facade.ProspeccaoFacadeLocal;

/**
 * Classe responsável por ...
 *
 * @since 11 de mar de 2016 20:03:54
 * @version x.x
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ProspeccaoFacade implements ProspeccaoFacadeLocal {

	@EJB
	private ColaboradorBusinessLocal colaboradorBusinessLocal;

	@EJB
	private ParceiroBusinessLocal parceiroBusinessLocal;

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.facade.ProspeccaoFacadeLocal#salvarPropeccao(br.com.forward.common.ProspeccaoVO)
	 */
	@Override
	public void salvarPropeccao(ProspeccaoVO prospeccao) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.facade.ProspeccaoFacadeLocal#carregarColaboradores()
	 */
	@Override
	public List<ColaboradorVO> carregarColaboradores() throws EntityManagerException {

		final List<ColaboradorVO> colaboradores = this.colaboradorBusinessLocal.listarColaboradores();
		return colaboradores;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.facade.ProspeccaoFacadeLocal#carregarParceiros()
	 */
	@Override
	public List<ParceiroVO> carregarParceiros() throws EntityManagerException {

		final List<ParceiroVO> listarParceiros = this.parceiroBusinessLocal.listarParceiros();

		return listarParceiros;

	}

}
