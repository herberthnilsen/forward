/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.business;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.apache.log4j.Logger;

import br.com.forward.common.ColaboradorVO;
import br.com.forward.converters.ConverterColaborador;
import br.com.forward.dao.PessoaDAO;
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

	private static final Logger LOGGER = Logger.getLogger(ColaboradorBusiness.class);
	/**
	 * Atributo pessoaDAO
	 */
	private PessoaDAO pessoaDAO;
	/**
	 * Atributo converterColaborador
	 */
	private final ConverterColaborador converterColaborador = new ConverterColaborador();

	@PostConstruct
	public void init() {

		this.pessoaDAO = new PessoaDAO(this.entityManager);

	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.business.ColaboradorBusinessLocal#listarColaboradores()
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ColaboradorVO> listarColaboradores() throws EntityManagerException {
		LOGGER.info("listarColaboradores - INICIO");
		final List<Colaborador> colaboradores = this.pessoaDAO.listarColaboradores();

		final List<ColaboradorVO> colaboradoresVO = this.converterColaborador.converterEntitytoVO(colaboradores);

		LOGGER.info("listarColaboradores - FIM");
		return colaboradoresVO;
	}

}
