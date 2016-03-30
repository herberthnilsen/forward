/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import br.com.forward.entity.Parceiro;
import br.com.forward.exception.EntityManagerException;

/**
 * Classe responsável por ...
 *
 * @since 17 de mar de 2016 22:27:30
 * @version x.x
 */
public class ParceiroDAO extends GenericEntityManager {

	private static final Logger LOGGER = Logger.getLogger(ParceiroDAO.class);

	/**
	 * Construtor da classe ParceiroDAO
	 *
	 * @param entityManager
	 */
	public ParceiroDAO(EntityManager entityManager) {
		super(entityManager);
	}

	@SuppressWarnings("unchecked")
	public List<Parceiro> listarParceiros() throws EntityManagerException {

		LOGGER.info("listarParceiros() - INICIO");

		final Query namedQuery = this.getEntityManager().createNamedQuery("Parceiro.findAll");

		final List<Parceiro> parceiros = (List<Parceiro>) namedQuery.getResultList();

		LOGGER.info("listarParceiros() - FIM");
		return parceiros;

	}

}
