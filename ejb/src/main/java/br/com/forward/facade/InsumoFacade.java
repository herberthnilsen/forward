/**
 * 
 */
package br.com.forward.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import br.com.forward.common.InsumoVO;
import br.com.forward.interfaces.business.InsumoBusinessLocal;
import br.com.forward.interfaces.facade.InsumoFacadeLocal;

/**
 * @author Herberth Nilsen
 *
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class InsumoFacade implements InsumoFacadeLocal{

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
	public void salvar(InsumoVO paramInsumoVO) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see br.com.forward.interfaces.facade.InsumoFacadeLocal#excluir(br.com.forward.common.InsumoVO)
	 */
	@Override
	public void excluir(InsumoVO paramInsumoVO) {
		// TODO Auto-generated method stub
		
	}

}
