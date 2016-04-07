/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import br.com.forward.entity.Colaborador;
import br.com.forward.entity.Pessoa;
import br.com.forward.exception.EntityManagerException;

/**
 * Classe responsável por gerenciar acesso aos dados de colaboradores
 *
 * @since 16 de mar de 2016 20:33:26
 * @version x.x
 */
public class PessoaDAO extends GenericEntityManager {

	private static final Logger LOGGER = Logger.getLogger(PessoaDAO.class);

	/**
	 * Construtor da classe PessoaDAO
	 *
	 * @param entityManager
	 */
	public PessoaDAO(EntityManager entityManager) {
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

		final Query namedQuery = this.getEntityManager().createNamedQuery("Colaborador.findAll");

		final List<Colaborador> colaboradores = (List<Colaborador>) namedQuery.getResultList();
		LOGGER.info("listarColaboradores() - FIM");
		return colaboradores;
	}

	/**
	 * Método responsável por salvar a pessoa
	 *
	 * @since 5 de abr de 2016 21:06:30
	 * @param pessoa
	 * @throws EntityManagerException
	 */
	public void salvarPessoa(Pessoa pessoa) throws EntityManagerException {
		LOGGER.info("salvarCliente - INICIO - PARÂMETROS:" + pessoa);

		this.getEntityManager().persist(pessoa);

		LOGGER.info("salvarCliente - FIM");

	}

}
