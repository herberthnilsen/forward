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
public class InsumoFacade implements InsumoFacadeLocal{

	private static Logger LOGGER = Logger.getLogger(InsumoFacade.class);
	
	@EJB
	private InsumoBusinessLocal insumoBusinessLocal;
	
	/* (non-Javadoc)
	 * @see br.com.forward.interfaces.facade.InsumoFacadeLocal#carregarInsumos(br.com.forward.common.InsumoVO)
	 */
	@Override
	public List<InsumoVO> carregarInsumos(InsumoVO paramInsumoVO) {

		this.insumoBusinessLocal.carregarInsumos(paramInsumoVO);
		return null;
	}

	/* (non-Javadoc)
	 * @see br.com.forward.interfaces.facade.InsumoFacadeLocal#salvar(br.com.forward.common.InsumoVO)
	 */
	@Override
	public void salvar(InsumoVO insumoVO)throws InsumoException {
		LOGGER.info("InsumoBean.salvar - INICIO = " + insumoVO);
		this.insumoBusinessLocal.salvar(insumoVO);
		LOGGER.info("InsumoBean.salvar - FIM = " + insumoVO);
		
	}

	/* (non-Javadoc)
	 * @see br.com.forward.interfaces.facade.InsumoFacadeLocal#excluir(br.com.forward.common.InsumoVO)
	 */
	@Override
	public void excluir(InsumoVO paramInsumoVO) {
		// TODO Auto-generated method stub
		
	}

}
