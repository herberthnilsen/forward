/**
 * 
 */
package br.com.forward.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import br.com.forward.common.InsumoVO;
import br.com.forward.interfaces.business.InsumoBusinessLocal;

/**
 * @author Herberth Nilsen
 *
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class InsumoBusiness implements InsumoBusinessLocal {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.forward.interfaces.business.InsumoBusinessLocal#carregarInsumos(br
	 * .com.forward.common.InsumoVO)
	 */
	@Override
	public List<InsumoVO> carregarInsumos(InsumoVO paramInsumoVO) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.forward.interfaces.business.InsumoBusinessLocal#salvar(br.com.
	 * forward.common.InsumoVO)
	 */
	@Override
	public void salvar(InsumoVO paramInsumoVO) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.forward.interfaces.business.InsumoBusinessLocal#excluir(br.com.
	 * forward.common.InsumoVO)
	 */
	@Override
	public void excluir(InsumoVO paramInsumoVO) {
		// TODO Auto-generated method stub

	}

}
