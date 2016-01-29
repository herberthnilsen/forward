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

import br.com.forward.common.UnidadeVO;
import br.com.forward.exception.UnidadeException;
import br.com.forward.interfaces.business.UnidadeBusinessLocal;
import br.com.forward.interfaces.facade.UnidadeFacadeLocal;

/**
 * @author Herberth Nilsen
 *
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class UnidadeFacade implements UnidadeFacadeLocal{

	private static Logger LOGGER = Logger.getLogger(UnidadeFacade.class);
	
	@EJB
	private UnidadeBusinessLocal unidadeBusinessLocal;

	@Override
	public List<UnidadeVO> carregarUnidades(UnidadeVO paramUnidadeVO) {
		LOGGER.info("UnidadeFacade.carregarUnidades - INICIO = " + paramUnidadeVO);
		
		this.unidadeBusinessLocal.carregarUnidades(paramUnidadeVO);
		LOGGER.info("UnidadeFacade.carregarUnidades - FIM = " + paramUnidadeVO);
		return null;
	}

	@Override
	public List<UnidadeVO> carregarUnidades() {
		LOGGER.info("UnidadeFacade.carregarUnidades - INICIO");
		
		return this.unidadeBusinessLocal.carregarUnidades();
	}

	/* (non-Javadoc)
	 * @see br.com.forward.interfaces.facade.UnidadeFacadeLocal#salvar(br.com.forward.common.UnidadeVO)
	 */
	@Override
	public void salvar(UnidadeVO unidadeVO)throws UnidadeException {
		LOGGER.info("UnidadeFacade.salvar - INICIO = " + unidadeVO);
		this.unidadeBusinessLocal.salvar(unidadeVO);
		LOGGER.info("UnidadeFacade.salvar - FIM = " + unidadeVO);
		
	}

	/* (non-Javadoc)
	 * @see br.com.forward.interfaces.facade.UnidadeFacadeLocal#excluir(br.com.forward.common.UnidadeVO)
	 */
	@Override
	public void excluir(UnidadeVO paramUnidadeVO) {
		// TODO Auto-generated method stub
		
	}

}
