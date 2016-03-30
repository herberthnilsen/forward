/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.business;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.apache.log4j.Logger;

import br.com.forward.common.ParceiroVO;
import br.com.forward.converters.ConverterParceiro;
import br.com.forward.dao.ParceiroDAO;
import br.com.forward.entity.Parceiro;
import br.com.forward.exception.EntityManagerException;
import br.com.forward.interfaces.business.ParceiroBusinessLocal;

/**
 * Classe responsável por ...
 *
 * @since 16 de mar de 2016 20:18:58
 * @version x.x
 */
@Stateless
public class ParceiroBusiness extends GenericEJB implements ParceiroBusinessLocal {

	private static final Logger LOGGER = Logger.getLogger(ParceiroBusiness.class);

	/**
	 * Atributo parceiroDAO
	 */
	private ParceiroDAO parceiroDAO;

	/**
	 * Atributo converterParceiro
	 */
	private ConverterParceiro converterParceiro;

	@PostConstruct
	public void init() {
		LOGGER.info("init() - INICIO");

		this.parceiroDAO = new ParceiroDAO(this.entityManager);
		this.converterParceiro = new ConverterParceiro();

		LOGGER.info("init() - FIM");

	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.business.ParceiroBusinessLocal#listarParceiros()
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ParceiroVO> listarParceiros() throws EntityManagerException {
		LOGGER.info("listarParceiros() - INICIO");

		final List<Parceiro> listaParceiros = this.parceiroDAO.listarParceiros();

		final List<ParceiroVO> listaParceiroVO = this.converterParceiro.converterEntitytoVO(listaParceiros);

		LOGGER.info("listarParceiros() - FIM");
		return listaParceiroVO;
	}

}
