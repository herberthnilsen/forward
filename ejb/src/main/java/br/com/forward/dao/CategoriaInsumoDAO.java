package br.com.forward.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.forward.common.CategoriaInsumoVO;
import br.com.forward.entity.CategoriaInsumo;
import br.com.forward.exception.EntityManagerException;
import br.com.forward.util.Utils;

public class CategoriaInsumoDAO extends GenericEntityManager {
	public static final Logger LOGGER = LogManager.getLogger(CategoriaInsumoDAO.class);

	public CategoriaInsumoDAO(EntityManager entityManager) {
		super(entityManager);
	}

	public List<CategoriaInsumo> getListaCategoriaInsumos() throws EntityManagerException {
		LOGGER.info("CategoriaInsumoDAO.getListaCategoriaInsumos - INICIO -  PARAMETROS");

		Query query = getEntityManager().createNamedQuery("CategoriaInsumo.findAll");

		List<CategoriaInsumo> resultList = (List<CategoriaInsumo>) query.getResultList();

		LOGGER.info("CategoriaInsumoDAO.getListaCategoriaInsumos - FIM");
		return resultList;
	}

	public List<CategoriaInsumo> getListaCategoriaInsumos(CategoriaInsumoVO categoriaInsumo)
			throws EntityManagerException {
		LOGGER.info("CategoriaInsumoDAO.getListaCategoriaInsumos - INICIO -  PARAMETROS");

		Map<String, Object> parametros = new HashMap<String, Object>();

		StringBuilder jpql = new StringBuilder();
		jpql.append("select cat from CategoriaInsumo cat ");
		jpql.append("where 1=1 ");

		if (categoriaInsumo.getCodigoCategoria() != null) {
			jpql.append(" and cat.codigoCategoriaInsumo=:codigoCategoriaInsumo");
			parametros.put("codigoCategoriaInsumo", categoriaInsumo.getCodigoCategoria());
		}
		if (!categoriaInsumo.getDescricaoCategoria().isEmpty()) {
			jpql.append(" and cat.descricaoCategoria like :descricaoCategoria");
			parametros.put("descricaoCategoria", "%"+categoriaInsumo.getDescricaoCategoria());
		}
		if (!categoriaInsumo.getNomeCategoria().isEmpty()) {
			jpql.append(" and cat.nomeCategoria like :nomeCategoria");
			parametros.put("nomeCategoria", "%"+categoriaInsumo.getNomeCategoria());
		}

		Query query = getEntityManager().createQuery(jpql.toString());

		this.preencherParametrosQuery(query, parametros);

		List<CategoriaInsumo> resultList = (List<CategoriaInsumo>) query.getResultList();

		LOGGER.info("CategoriaInsumoDAO.getListaCategoriaInsumos - FIM");
		return resultList;
	}

	public void salvar(CategoriaInsumo categoriaInsumo) throws EntityManagerException {
		LOGGER.info("CategoriaInsumoDAO.salvar - INICIO -  PARAMETROS: " + categoriaInsumo.toString());
		if (!Utils.isObjectNull(categoriaInsumo.getCodigoCategoriaInsumo()).booleanValue()) {
			merge(categoriaInsumo);
		} else {
			persist(categoriaInsumo);
		}

		LOGGER.info("CategoriaInsumoDAO.salvar - FIM");
	}

	public void excluir(CategoriaInsumo categoriaInsumo) throws EntityManagerException {
		LOGGER.info("CategoriaInsumoDAO.excluir - INICIO");

		categoriaInsumo = (CategoriaInsumo) find(CategoriaInsumo.class, categoriaInsumo.getCodigoCategoriaInsumo());

		remove(categoriaInsumo);

		LOGGER.info("CategoriaInsumoDAO.excluir - FIM");
	}
}
