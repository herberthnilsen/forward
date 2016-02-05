/**
 * 
 */
package br.com.forward.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.forward.entity.Insumo;
import br.com.forward.entity.SubItemInsumo;
import br.com.forward.exception.EntityManagerException;

/**
 * @author Herberth Nilsen
 *
 */
public class SubItemInsumoDAO extends GenericEntityManager {

	public static final Logger LOGGER = LogManager.getLogger(SubItemInsumoDAO.class);

	/**
	 * @param entityManager
	 */
	public SubItemInsumoDAO(EntityManager entityManager) {
		super(entityManager);
	}

	@SuppressWarnings("unchecked")
	public List<SubItemInsumo> getListaSubItemInsumoByInsumo(Insumo insumo){
		LOGGER.info("SubItemInsumoDAO.getListaSubItemInsumo - INICIO -  PARAMETROS");

		Map<String, Object> parametros = new HashMap<String, Object>();

		StringBuilder jpql = new StringBuilder();
		jpql.append("select subIns from SubItemInsumo subIns ");
		jpql.append("where 1=1 ");

		if (!insumo.getDescricaoInsumo().isEmpty()) {
			jpql.append(" and subIns.subItemPK.codigoInsumoPai = :codigoInsumo");
			parametros.put("codigoInsumo", insumo.getCodigoInsumo());
		}


		List<SubItemInsumo> resultList = new ArrayList<SubItemInsumo>();
		
		try {
			Query query = getEntityManager().createQuery(jpql.toString());
			
			this.preencherParametrosQuery(query, parametros);
			
			resultList = (List<SubItemInsumo>) query.getResultList();
		} catch (EntityManagerException e) {
			LOGGER.info("SubItemInsumoDAO.getListaSubItemInsumo - Não há registros para a query executada.");
			
		}

		LOGGER.info("SubItemInsumoDAO.getListaSubItemInsumo - FIM");
		return resultList;
	}

	public void salvar(SubItemInsumo subItemInsumo) throws EntityManagerException {
		LOGGER.info("SubItemInsumoDAO.salvar - INICIO -  PARAMETROS: " + subItemInsumo.toString());

		persist(subItemInsumo);

		LOGGER.info("SubItemInsumoDAO.salvar - FIM");
	}

	public void excluir(SubItemInsumo subItemInsumo) throws EntityManagerException {
		LOGGER.info("SubItemInsumoDAO.excluir - INICIO");

		subItemInsumo = (SubItemInsumo) find(SubItemInsumo.class, subItemInsumo.getSubItemPK());

		remove(subItemInsumo);

		LOGGER.info("SubItemInsumoDAO.excluir - FIM");
	}
}