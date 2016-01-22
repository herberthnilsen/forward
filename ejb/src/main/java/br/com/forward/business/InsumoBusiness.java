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
import br.com.forward.dao.InsumoDAO;
import br.com.forward.entity.Insumo;
import br.com.forward.enumcode.ExceptionEnum;
import br.com.forward.exception.EntityManagerException;
import br.com.forward.exception.InsumoException;
import br.com.forward.interfaces.business.InsumoBusinessLocal;

/**
 * @author Herberth Nilsen
 *
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class InsumoBusiness extends GenericBusiness implements InsumoBusinessLocal {
	public static final Logger LOGGER = Logger.getLogger(InsumoBusiness.class);
	
	private InsumoDAO insumoDAO;
	
	@PostConstruct
	public void init(){
		
		this.insumoDAO = new InsumoDAO(this.entityManager);
		
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
			
			ConverterInsumo.convertListEntityToListVo(this.insumoDAO.getListaInsumos(), insumos);
			
		} catch (EntityManagerException e) {

			LOGGER.error("Ocorreu um erro ao buscar as categorias de insumo", e);
			
		}
		return insumos;
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
		LOGGER.info("InsumoBean.salvar - INICIO = " + insumoVO);
		
		Insumo insumo = new Insumo();
		
		//Convertendo VO em Entidade
		ConverterInsumo.convertVoToEntity(insumoVO, insumo);
		
		try {
			this.insumoDAO.salvar(insumo);
		} catch (EntityManagerException e) {
			String msg = new String("Ocorreu um erro ao persistir o insumo");
			LOGGER.error(msg, e);
			throw new InsumoException(msg, e);
		}
		LOGGER.info("InsumoBean.salvar - FIM = " + insumoVO);
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
