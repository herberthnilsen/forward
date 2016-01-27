/**
 * 
 */
package br.com.forward.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.forward.common.UnidadeVO;
import br.com.forward.entity.Unidade;
import br.com.forward.exception.EntityManagerException;
import br.com.forward.util.Utils;

/**
 * @author Herberth Nilsen
 *
 */
public class UnidadeDAO extends GenericEntityManager {

	public static final Logger LOGGER = LogManager.getLogger(UnidadeDAO.class);

	/**
	 * @param entityManager
	 */
	public UnidadeDAO(EntityManager entityManager) {
		super(entityManager);
	}

	public List<Unidade> getListaUnidades() throws EntityManagerException {
		LOGGER.info("UnidadeDAO.getListaUnidades - INICIO -  PARAMETROS");

		Query query = getEntityManager().createNamedQuery("Unidade.findAll");

		List<Unidade> resultList = (List<Unidade>) query.getResultList();

		LOGGER.info("UnidadeDAO.getListaUnidades - FIM");
		return resultList;
	}

	public List<Unidade> getListaUnidades(UnidadeVO unidade) throws EntityManagerException {
		LOGGER.info("UnidadeDAO.getListaUnidades - INICIO -  PARAMETROS");

		Map<String, Object> parametros = new HashMap<String, Object>();

		StringBuilder jpql = new StringBuilder();
		jpql.append("select ins from Unidade ins ");
		jpql.append("where 1=1 ");

		if (unidade.getCodigoUnidade() != null) {
			jpql.append(" and ins.codigoUnidade=:codigoUnidade");
			parametros.put("codigoUnidade", unidade.getCodigoUnidade());
		}
		if (!unidade.getNomeUnidade().isEmpty()) {
			jpql.append(" and ins.descricao like :descricao");
			parametros.put("descricao", "%" + unidade.getNomeUnidade());
		}
		if (!unidade.getNomeUnidade().isEmpty()) {
			jpql.append(" and ins.nome like :nome");
			parametros.put("nome", "%" + unidade.getNomeUnidade());
		}
		// TODO veirifcar todos os campos que são preenchidos para efetuar a
		// busca
		Query query = getEntityManager().createQuery(jpql.toString());

		this.preencherParametrosQuery(query, parametros);

		List<Unidade> resultList = (List<Unidade>) query.getResultList();

		LOGGER.info("UnidadeDAO.getListaUnidades - FIM");
		return resultList;
	}

	public void salvar(Unidade Unidade) throws EntityManagerException {
		LOGGER.info("UnidadeDAO.salvar - INICIO -  PARAMETROS: " + Unidade.toString());
		if (!Utils.isObjectNull(Unidade.getCodigoUnidade()).booleanValue()) {
			merge(Unidade);
		} else {
			persist(Unidade);
		}

		LOGGER.info("UnidadeDAO.salvar - FIM");
	}

	public void excluir(Unidade Unidade) throws EntityManagerException {
		LOGGER.info("UnidadeDAO.excluir - INICIO");

		Unidade = (Unidade) find(Unidade.class, Unidade.getCodigoUnidade());

		remove(Unidade);

		LOGGER.info("UnidadeDAO.excluir - FIM");
	}
}