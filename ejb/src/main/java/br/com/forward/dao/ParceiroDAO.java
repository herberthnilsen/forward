/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.dao;

import java.util.List;

import javax.persistence.EntityManager;

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

		LOGGER.info("listarColaboradores() - INICIO");

		final List<Parceiro> parceiros = (List<Parceiro>) this.getEntityManager().find(Parceiro.class, null);

		LOGGER.info("listarColaboradores() - FIM");
		return parceiros;

	}

}
