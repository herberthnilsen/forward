/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.business;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import br.com.forward.common.ColaboradorVO;
import br.com.forward.dao.ColaboradorDAO;
import br.com.forward.entity.Colaborador;
import br.com.forward.exception.EntityManagerException;
import br.com.forward.interfaces.business.ColaboradorBusinessLocal;

/**
 * Classe responsável por ...
 *
 * @since 16 de mar de 2016 20:18:58
 * @version x.x
 */
@Stateless
public class ColaboradorBusiness extends GenericEJB implements ColaboradorBusinessLocal {

	private ColaboradorDAO colaboradorDAO;

	@PostConstruct
	public void init() {

		this.colaboradorDAO = new ColaboradorDAO(this.entityManager);

	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.business.ColaboradorBusinessLocal#listarColaboradores()
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ColaboradorVO> listarColaboradores() throws EntityManagerException {

		final List<Colaborador> colaboradores = this.colaboradorDAO.listarColaboradores();

		return null;
	}

}
