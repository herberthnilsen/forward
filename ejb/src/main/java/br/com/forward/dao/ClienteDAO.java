/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import br.com.forward.entity.Cliente;
import br.com.forward.entity.Cliente;
import br.com.forward.exception.EntityManagerException;

/**
 * Classe responsável por gerenciar acesso aos dados de clientees
 *
 * @since 16 de mar de 2016 20:33:26
 * @version x.x
 */
public class ClienteDAO extends GenericEntityManager {

	private static final Logger LOGGER = Logger.getLogger(ClienteDAO.class);

	/**
	 * Construtor da classe ClienteDAO
	 *
	 * @param entityManager
	 */
	public ClienteDAO(EntityManager entityManager) {
		super(entityManager);
	}

	/**
	 * Método responsável por Listar os clientees cadastrados
	 * 
	 * @since 16 de mar de 2016 20:43:38
	 * @return
	 * @throws EntityManagerException
	 */
	public List<Cliente> listarClientees() throws EntityManagerException {
		LOGGER.info("listarClientees() - INICIO");

		final Query namedQuery = this.getEntityManager().createNamedQuery("Cliente.findAll");

		final List<Cliente> clientes = (List<Cliente>) namedQuery.getResultList();
		LOGGER.info("listarClientees() - FIM");
		return clientes;
	}

	/**
	 * Método responsável por salvar a cliente
	 *
	 * @since 5 de abr de 2016 21:06:30
	 * @param cliente
	 * @throws EntityManagerException
	 */
	public void salvarCliente(Cliente cliente) throws EntityManagerException {
		LOGGER.info("salvarCliente - INICIO - PARÂMETROS:" + cliente);

		this.getEntityManager().persist(cliente);

		LOGGER.info("salvarCliente - FIM");

	}

}
