/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.apache.log4j.Logger;

import br.com.forward.common.AtendimentoVO;
import br.com.forward.common.ColaboradorVO;
import br.com.forward.common.ParceiroVO;
import br.com.forward.common.ProspeccaoVO;
import br.com.forward.exception.EntityManagerException;
import br.com.forward.exception.ProspeccaoException;
import br.com.forward.interfaces.business.AtendimentoBusinessLocal;
import br.com.forward.interfaces.business.ColaboradorBusinessLocal;
import br.com.forward.interfaces.business.ParceiroBusinessLocal;
import br.com.forward.interfaces.business.ProspeccaoBusinessLocal;
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

	/**
	 * Atributo LOGGER
	 */
	private static final Logger LOGGER = Logger.getLogger(ProspeccaoFacade.class);

	/**
	 * Atributo colaboradorBusinessLocal
	 */
	@EJB
	private ColaboradorBusinessLocal colaboradorBusinessLocal;

	/**
	 * Atributo parceiroBusinessLocal
	 */
	@EJB
	private ParceiroBusinessLocal parceiroBusinessLocal;

	/**
	 * Atributo atendimentoBusinessLocal
	 */
	@EJB
	private AtendimentoBusinessLocal atendimentoBusinessLocal;

	/**
	 * Atributo prospeccaoBusinessLocal
	 */
	@EJB
	private ProspeccaoBusinessLocal prospeccaoBusinessLocal;

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.facade.ProspeccaoFacadeLocal#salvarPropeccao(br.com.forward.common.ProspeccaoVO)
	 */
	@Override
	public void salvarPropeccao(ProspeccaoVO prospeccao) throws ProspeccaoException {
		LOGGER.info("salvarPropeccao - INICIO - PARÂMETROS:" + prospeccao);

		this.prospeccaoBusinessLocal.salvarPropeccao(prospeccao);
		LOGGER.info("salvarPropeccao - FIM");
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

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.facade.ProspeccaoFacadeLocal#carregarAtendimentosPorProspeccao(java.lang.Long)
	 */
	@Override
	public List<AtendimentoVO> carregarAtendimentosPorProspeccao(Long codigoProspeccao) throws EntityManagerException {
		LOGGER.info("carregarAtendimentosPorProspeccao - INICIO");

		final List<AtendimentoVO> listaAtendimentoVO = this.atendimentoBusinessLocal
				.consultarAtendimentosPorProspeccao(codigoProspeccao);

		LOGGER.info("carregarAtendimentosPorProspeccao - FIM");
		return listaAtendimentoVO;
	}

}
