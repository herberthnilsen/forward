/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import br.com.forward.entity.Colaborador;
import br.com.forward.exception.EntityManagerException;

/**
 * Classe responsável por gerenciar acesso aos dados de colaboradores
 *
 * @since 16 de mar de 2016 20:33:26
 * @version x.x
 */
public class ColaboradorDAO extends GenericEntityManager {

	private static final Logger LOGGER = Logger.getLogger(ColaboradorDAO.class);

	/**
	 * Construtor da classe ColaboradorDAO
	 *
	 * @param entityManager
	 */
	public ColaboradorDAO(EntityManager entityManager) {
		super(entityManager);
	}

	/**
	 * Método responsável por Listar os colaboradores cadastrados
	 * 
	 * @since 16 de mar de 2016 20:43:38
	 * @return
	 * @throws EntityManagerException
	 */
	public List<Colaborador> listarColaboradores() throws EntityManagerException {
		LOGGER.info("listarColaboradores() - INICIO");

		final List<Colaborador> colaboradores = (List<Colaborador>) this.getEntityManager().find(Colaborador.class, null);

		LOGGER.info("listarColaboradores() - FIM");
		return colaboradores;
	}

}
