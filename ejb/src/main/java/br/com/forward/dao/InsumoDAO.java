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

	@SuppressWarnings("unchecked")
	public List<Insumo> getListaInsumos(InsumoVO insumoVO) throws EntityManagerException {
		LOGGER.info("InsumoDAO.getListaInsumos - INICIO -  PARAMETROS");

		Map<String, Object> parametros = new HashMap<String, Object>();

		StringBuilder jpql = new StringBuilder();
		jpql.append("select ins "
				+ "from Insumo ins "
//				+ "join insumo.categoriaInsumo cat"
//				+ "join insumo.unidade un"
				);
		jpql.append("where 1=1 ");

		if (!insumoVO.getDescricaoInsumo().isEmpty()) {
			jpql.append(" and ins.descricaoInsumo like :descricao");
			parametros.put("descricao", "%" + insumoVO.getDescricaoInsumo());
		}
		if (!insumoVO.getNomeInsumo().isEmpty()) {
			jpql.append(" and ins.nomeInsumo like :nome");
			parametros.put("nome", "%" + insumoVO.getNomeInsumo());
		}

		if (insumoVO.getCategoriaInsumoVO() != null && insumoVO.getCategoriaInsumoVO().getCodigoCategoria() != null) {

			jpql.append(" and ins.categoriaInsumo.codigoCategoriaInsumo = :codCatIns");
			parametros.put("codCatIns", insumoVO.getCategoriaInsumoVO().getCodigoCategoria());
			
		}
		
		if (insumoVO.getUnidadeVO() != null && insumoVO.getUnidadeVO().getCodigoUnidade() != null) {
			
			jpql.append(" and ins.unidade.codigoUnidade = :codUnidade");
			parametros.put("codUnidade", insumoVO.getUnidadeVO().getCodigoUnidade());
			
		}
		
		if (insumoVO.getNumeroSerie() != null) {
			
			jpql.append(" and ins.numeroSerie = :numeroSerie");
			parametros.put("numeroSerie", insumoVO.getNumeroSerie());
			
		}

		
		//Filtro pelo valor de mercado
		if(insumoVO.getValorMercadoDe() != null && insumoVO.getValorMercadoAte() != null){
			
			jpql.append(" and ins.valorMercado between :valorMercadoDe and :valorMercadoAte");
			parametros.put("valorMercadoDe", insumoVO.getValorMercadoDe());
			parametros.put("valorMercadoAte", insumoVO.getValorMercadoAte());
			
		}
		
		
		//Filtro pelo valor de venda
		if(insumoVO.getValorVendaDe() != null && insumoVO.getValorVendaAte() != null){
			
			jpql.append(" and ins.valorVenda between :valorVendaDe and :valorVendaAte");
			parametros.put("valorVendaDe", insumoVO.getValorVendaDe());
			parametros.put("valorVendaAte", insumoVO.getValorVendaAte());
			
		}
		
		
		
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