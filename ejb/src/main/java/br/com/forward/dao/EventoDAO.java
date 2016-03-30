/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import br.com.forward.entity.Evento;
import br.com.forward.exception.EntityManagerException;

/**
 * Classe responsável por ...
 *
 * @since 17 de mar de 2016 22:27:30
 * @version x.x
 */
public class EventoDAO extends GenericEntityManager {

	private static final Logger LOGGER = Logger.getLogger(EventoDAO.class);

	/**
	 * Construtor da classe EventoDAO
	 *
	 * @param entityManager
	 */
	public EventoDAO(EntityManager entityManager) {
		super(entityManager);
	}

	@SuppressWarnings("unchecked")
	public List<Evento> listarEventos() throws EntityManagerException {

		LOGGER.info("listarEventos() - INICIO");

		final Query namedQuery = this.getEntityManager().createNamedQuery("Evento.findAll");

		final List<Evento> eventos = (List<Evento>) namedQuery.getResultList();

		LOGGER.info("listarEventos() - FIM");
		return eventos;

	}

}
