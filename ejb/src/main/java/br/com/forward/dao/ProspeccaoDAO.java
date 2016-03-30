/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import br.com.forward.entity.Prospeccao;
import br.com.forward.exception.EntityManagerException;

/**
 * Classe responsável por ...
 *
 * @since 17 de mar de 2016 22:27:30
 * @version x.x
 */
public class ProspeccaoDAO extends GenericEntityManager {

	private static final Logger LOGGER = Logger.getLogger(ProspeccaoDAO.class);

	/**
	 * Construtor da classe ProspeccaoDAO
	 *
	 * @param entityManager
	 */
	public ProspeccaoDAO(EntityManager entityManager) {
		super(entityManager);
	}

	@SuppressWarnings("unchecked")
	public List<Prospeccao> listarProspeccaos() throws EntityManagerException {

		LOGGER.info("listarProspeccaos() - INICIO");

		final Query namedQuery = this.getEntityManager().createNamedQuery("Prospeccao.findAll");

		final List<Prospeccao> prospeccaos = (List<Prospeccao>) namedQuery.getResultList();

		LOGGER.info("listarProspeccaos() - FIM");
		return prospeccaos;

	}

	public void salvar(Prospeccao prospeccao) throws EntityManagerException {
		LOGGER.info("salvar - INICIO - PARÂMETROS:" + prospeccao);

		this.merge(prospeccao);

		LOGGER.info("salvar - FIM");
	}

	public void excluir(Prospeccao prospeccao) {
		LOGGER.info("excluir - INICIO - PARÂMETROS:" + prospeccao);
		// TODO implementar excluir quando for necessário excluindo dados de todas as tabelas.
		LOGGER.info("excluir - FIM");
	}

}
