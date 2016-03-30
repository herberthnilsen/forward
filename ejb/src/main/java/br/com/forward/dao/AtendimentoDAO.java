/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import br.com.forward.entity.Atendimento;
import br.com.forward.exception.EntityManagerException;

/**
 * Classe responsável por ...
 *
 * @since 17 de mar de 2016 22:27:30
 * @version x.x
 */
public class AtendimentoDAO extends GenericEntityManager {

	private static final Logger LOGGER = Logger.getLogger(AtendimentoDAO.class);

	/**
	 * Construtor da classe AtendimentoDAO
	 *
	 * @param entityManager
	 */
	public AtendimentoDAO(EntityManager entityManager) {
		super(entityManager);
	}

	@SuppressWarnings("unchecked")
	public List<Atendimento> listarAtendimentos() throws EntityManagerException {

		LOGGER.info("listarColaboradores() - INICIO");

		final Query namedQuery = this.getEntityManager().createNamedQuery("Atendimento.findAll");

		final List<Atendimento> atendimentos = (List<Atendimento>) namedQuery.getResultList();

		LOGGER.info("listarColaboradores() - FIM");
		return atendimentos;

	}

	public List<Atendimento> listarAtendimentosPorProspeccao(Long codigoProspeccao) throws EntityManagerException {

		LOGGER.info("listarAtendimentosPorProspeccao() - INICIO");

		final StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT atendimento ").append("FROM Atendimento atendimento ").append("Join fetch atendimento.colaborador ")
				.append(" WHERE atendimento.prospeccao.codigoProspeccao = :codigoProspeccao");

		final Query query = this.getEntityManager().createQuery(jpql.toString());

		final Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("codigoProspeccao", codigoProspeccao);

		this.preencherParametrosQuery(query, parametros);

		final List<Atendimento> atendimentos = (List<Atendimento>) query.getResultList();

		LOGGER.info("listarAtendimentosPorProspeccao() - FIM");
		return atendimentos;

	}

}
