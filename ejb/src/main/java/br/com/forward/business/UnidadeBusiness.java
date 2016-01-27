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

import br.com.forward.common.UnidadeVO;
import br.com.forward.converters.ConverterUnidade;
import br.com.forward.dao.UnidadeDAO;
import br.com.forward.entity.Unidade;
import br.com.forward.exception.EntityManagerException;
import br.com.forward.exception.UnidadeException;
import br.com.forward.interfaces.business.UnidadeBusinessLocal;

/**
 * @author Herberth Nilsen
 *
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class UnidadeBusiness extends GenericBusiness implements UnidadeBusinessLocal {
	public static final Logger LOGGER = Logger.getLogger(UnidadeBusiness.class);

	private UnidadeDAO unidadeDAO;

	@PostConstruct
	public void init() {

		this.unidadeDAO = new UnidadeDAO(this.entityManager);

	}

	@Override
	public List<UnidadeVO> carregarUnidades(UnidadeVO unidadeVO) {
		LOGGER.info("UnidadeBusiness.carregarUnidades - INICIO = " + unidadeVO);
		ArrayList<UnidadeVO> unidades = new ArrayList<UnidadeVO>();

		try {

			ConverterUnidade.convertListEntityToListVo(this.unidadeDAO.getListaUnidades(unidadeVO), unidades);

		} catch (EntityManagerException e) {

			LOGGER.error("Ocorreu um erro ao buscar as categorias de insumo", e);

		}
		LOGGER.info("UnidadeBusiness.carregarUnidades - FIM" );
		return unidades;
	}
	
	@Override
	public List<UnidadeVO> carregarUnidades() {
		LOGGER.info("UnidadeBusiness.carregarUnidades - INICIO");
		ArrayList<UnidadeVO> unidades = new ArrayList<UnidadeVO>();
		
		try {
			
			ConverterUnidade.convertListEntityToListVo(this.unidadeDAO.getListaUnidades(), unidades);
			
		} catch (EntityManagerException e) {
			
			LOGGER.error("Ocorreu um erro ao buscar as categorias de insumo", e);
			
		}
		LOGGER.info("UnidadeBusiness.carregarUnidades - FIM");
		return unidades;
	}

	@Override
	public void salvar(UnidadeVO unidadeVO) throws UnidadeException{
		LOGGER.info("UnidadeBusiness.salvar - INICIO = " + unidadeVO);

		Unidade unidade = new Unidade();

		// Convertendo VO em Entidade
		ConverterUnidade.convertVoToEntity(unidadeVO, unidade);

		try {
			this.unidadeDAO.salvar(unidade);
		} catch (EntityManagerException e) {
			String msg = new String("Ocorreu um erro ao persistir o insumo");
			LOGGER.error(msg, e);
			throw new UnidadeException(msg, e);
		}
		LOGGER.info("UnidadeBusiness.salvar - FIM = " + unidadeVO);
	}

	@Override
	public void excluir(UnidadeVO unidadeVO) throws UnidadeException {
		// TODO Auto-generated method stub

	}

}
