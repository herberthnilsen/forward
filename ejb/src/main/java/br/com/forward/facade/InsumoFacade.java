/**
 * 
 */
package br.com.forward.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.apache.log4j.Logger;

import br.com.forward.common.InsumoVO;
import br.com.forward.exception.InsumoException;
import br.com.forward.interfaces.business.InsumoBusinessLocal;
import br.com.forward.interfaces.facade.InsumoFacadeLocal;

/**
 * @author Herberth Nilsen
 *
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class InsumoFacade implements InsumoFacadeLocal {

	private static Logger LOGGER = Logger.getLogger(InsumoFacade.class);

	@EJB
	private InsumoBusinessLocal insumoBusinessLocal;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.forward.interfaces.facade.InsumoFacadeLocal#carregarInsumos(br.com
	 * .forward.common.InsumoVO)
	 */
	@Override
	public List<InsumoVO> carregarInsumos(InsumoVO paramInsumoVO) {
		LOGGER.info("InsumoFacade.carregarSubItensInsumos - INICIO = " + paramInsumoVO);

		List<InsumoVO> listaInsumos = this.insumoBusinessLocal.carregarInsumos(paramInsumoVO);

		LOGGER.info("InsumoFacade.carregarSubItensInsumos - INICIO = " + paramInsumoVO);

		return listaInsumos;

	}

	public void carregarSubItensInsumos(InsumoVO insumoVO) {
		LOGGER.info("InsumoFacade.carregarSubItensInsumos - INICIO = " + insumoVO);

		this.insumoBusinessLocal.carregarSubItensInsumos(insumoVO);

		LOGGER.info("InsumoFacade.carregarSubItensInsumos - FIM = " + insumoVO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.forward.interfaces.facade.InsumoFacadeLocal#salvar(br.com.forward.
	 * common.InsumoVO)
	 */
	@Override
	public void salvar(InsumoVO insumoVO) throws InsumoException {
		LOGGER.info("InsumoFacade.salvar - INICIO = " + insumoVO);
		this.insumoBusinessLocal.salvar(insumoVO);
		LOGGER.info("InsumoFacade.salvar - FIM = " + insumoVO);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.forward.interfaces.facade.InsumoFacadeLocal#excluir(br.com.forward
	 * .common.InsumoVO)
	 */
	@Override
	public void excluir(InsumoVO insumoVO) throws InsumoException {
		LOGGER.info("InsumoFacade.excluir - INICIO = " + insumoVO);
		this.insumoBusinessLocal.excluir(insumoVO);
		LOGGER.info("InsumoFacade.excluir - FIM = " + insumoVO);
	}

}
