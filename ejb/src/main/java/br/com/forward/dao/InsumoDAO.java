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

import br.com.forward.common.InsumoVO;
import br.com.forward.entity.Insumo;
import br.com.forward.exception.EntityManagerException;
import br.com.forward.util.Utils;

/**
 * @author Herberth Nilsen
 *
 */
public class InsumoDAO extends GenericEntityManager {

	public static final Logger LOGGER = LogManager.getLogger(InsumoDAO.class);

	/**
	 * @param entityManager
	 */
	public InsumoDAO(EntityManager entityManager) {
		super(entityManager);
	}

	public List<Insumo> getListaInsumos() throws EntityManagerException {
		LOGGER.info("InsumoDAO.getListaInsumos - INICIO -  PARAMETROS");

		Query query = getEntityManager().createNamedQuery("Insumo.findAll");

		List<Insumo> resultList = (List<Insumo>) query.getResultList();

		LOGGER.info("InsumoDAO.getListaInsumos - FIM");
		return resultList;
	}

	public List<Insumo> getListaInsumos(InsumoVO insumo) throws EntityManagerException {
		LOGGER.info("InsumoDAO.getListaInsumos - INICIO -  PARAMETROS");

		Map<String, Object> parametros = new HashMap<String, Object>();

		StringBuilder jpql = new StringBuilder();
		jpql.append("select ins from Insumo ins ");
		jpql.append("where 1=1 ");

		if (insumo.getCodigoInsumo() != null) {
			jpql.append(" and ins.codigoInsumo=:codigoInsumo");
			parametros.put("codigoInsumo", insumo.getCodigoInsumo());
		}
		if (!insumo.getDescricaoInsumo().isEmpty()) {
			jpql.append(" and ins.descricao like :descricao");
			parametros.put("descricao", "%" + insumo.getDescricaoInsumo());
		}
		if (!insumo.getNomeInsumo().isEmpty()) {
			jpql.append(" and ins.nome like :nome");
			parametros.put("nome", "%" + insumo.getNomeInsumo());
		}
		// TODO veirifcar todos os campos que são preenchidos para efetuar a
		// busca
		Query query = getEntityManager().createQuery(jpql.toString());

		this.preencherParametrosQuery(query, parametros);

		List<Insumo> resultList = (List<Insumo>) query.getResultList();

		LOGGER.info("InsumoDAO.getListaInsumos - FIM");
		return resultList;
	}

	public void salvar(Insumo Insumo) throws EntityManagerException {
		LOGGER.info("InsumoDAO.salvar - INICIO -  PARAMETROS: " + Insumo.toString());
		if (!Utils.isObjectNull(Insumo.getCodigoInsumo()).booleanValue()) {
			merge(Insumo);
		} else {
			persist(Insumo);
		}

		LOGGER.info("InsumoDAO.salvar - FIM");
	}

	public void excluir(Insumo Insumo) throws EntityManagerException {
		LOGGER.info("InsumoDAO.excluir - INICIO");

		Insumo = (Insumo) find(Insumo.class, Insumo.getCodigoInsumo());

		remove(Insumo);

		LOGGER.info("InsumoDAO.excluir - FIM");
	}
}