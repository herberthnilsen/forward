/**
 * 
 */
package br.com.forward.business;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.jboss.logging.Logger;

import br.com.forward.common.InsumoVO;
import br.com.forward.converters.ConverterInsumo;
import br.com.forward.converters.ConverterSubItemInsumo;
import br.com.forward.dao.InsumoDAO;
import br.com.forward.dao.SubItemInsumoDAO;
import br.com.forward.entity.Insumo;
import br.com.forward.entity.SubItemInsumo;
import br.com.forward.exception.EntityManagerException;
import br.com.forward.exception.InsumoException;
import br.com.forward.interfaces.business.InsumoBusinessLocal;

/**
 * @author Herberth Nilsen
 *
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class InsumoBusiness extends GenericBusiness implements InsumoBusinessLocal {
	public static final Logger LOGGER = Logger.getLogger(InsumoBusiness.class);

	private InsumoDAO insumoDAO;
	private SubItemInsumoDAO subItemInsumoDAO;

	@PostConstruct
	public void init() {

		this.insumoDAO = new InsumoDAO(this.entityManager);
		this.subItemInsumoDAO = new SubItemInsumoDAO(this.entityManager);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.forward.interfaces.business.InsumoBusinessLocal#carregarInsumos(br
	 * .com.forward.common.InsumoVO)
	 */
	@Override
	public List<InsumoVO> carregarInsumos(InsumoVO paramInsumoVO) {

		ArrayList<InsumoVO> insumos = new ArrayList<InsumoVO>();

		try {
			if (paramInsumoVO.getNomeInsumo() != null || paramInsumoVO.getDescricaoInsumo() != null
					|| paramInsumoVO.getNumeroSerie() != null || paramInsumoVO.getUnidadeVO().getCodigoUnidade() != null
					|| (paramInsumoVO.getValorMercadoDe() != null && paramInsumoVO.getValorMercadoAte() != null)
					|| (paramInsumoVO.getValorVendaDe() != null && paramInsumoVO.getValorVendaAte() != null)) {

				ConverterInsumo.convertListEntityToListVo(this.insumoDAO.getListaInsumos(paramInsumoVO), insumos);
			} else {

				ConverterInsumo.convertListEntityToListVo(this.insumoDAO.getListaInsumos(), insumos);
			}

		} catch (EntityManagerException e) {

			LOGGER.error("Ocorreu um erro ao buscar as categorias de insumo", e);

		}
		return insumos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.forward.interfaces.business.InsumoBusinessLocal#
	 * carregarSubItensInsumos(br.com.forward.common.InsumoVO)
	 */
	public List<InsumoVO> carregarSubItensInsumos(InsumoVO insumoVO) {
		LOGGER.info("InsumoBusiness.salvar - INICIO = " + insumoVO);

		Insumo insumo = new Insumo();
		ConverterInsumo.convertVoToEntity(insumoVO, insumo);
		
		List<SubItemInsumo> listaSubItemInsumoByInsumo = this.subItemInsumoDAO.getListaSubItemInsumoByInsumo(insumo);
		List<InsumoVO> listaInsumoVO = new ArrayList<InsumoVO>(); 
		
		ConverterSubItemInsumo.convertListEntityToListVo(listaSubItemInsumoByInsumo, insumoVO);

		LOGGER.info("InsumoBusiness.salvar - INICIO = " + insumoVO);
		return listaInsumoVO;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.forward.interfaces.business.InsumoBusinessLocal#salvar(br.com.
	 * forward.common.InsumoVO)
	 */
	@Override
	public void salvar(InsumoVO insumoVO) throws InsumoException {
		LOGGER.info("InsumoBusiness.salvar - INICIO = " + insumoVO);

		Insumo insumo = new Insumo();

		// Convertendo VO em Entidade
		ConverterInsumo.convertVoToEntity(insumoVO, insumo);

		try {
			this.insumoDAO.salvar(insumo);
		} catch (EntityManagerException e) {
			String msg = new String("Ocorreu um erro ao persistir o insumo");
			LOGGER.error(msg, e);
			throw new InsumoException(msg, e);
		}
		LOGGER.info("InsumoBusiness.salvar - FIM = " + insumoVO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.forward.interfaces.business.InsumoBusinessLocal#excluir(br.com.
	 * forward.common.InsumoVO)
	 */
	@Override
	public void excluir(InsumoVO paramInsumoVO) throws InsumoException {
		// TODO Auto-generated method stub

	}

}
