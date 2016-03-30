/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.business;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import br.com.forward.common.AtendimentoVO;
import br.com.forward.converters.ConverterAtendimento;
import br.com.forward.dao.AtendimentoDAO;
import br.com.forward.entity.Atendimento;
import br.com.forward.exception.EntityManagerException;
import br.com.forward.interfaces.business.AtendimentoBusinessLocal;

/**
 * Classe responsável por ...
 *
 * @since 11 de mar de 2016 20:07:57
 * @version x.x
 */
@Stateless
public class AtendimentoBusiness extends GenericEJB implements AtendimentoBusinessLocal {

	/**
	 * Atributo LOGGER
	 */
	private static final Logger LOGGER = Logger.getLogger(AtendimentoBusiness.class);

	/**
	 * Atributo atendimentoDAO
	 */
	private AtendimentoDAO atendimentoDAO;

	/**
	 * Atributo converterAtendimento
	 */
	private ConverterAtendimento converterAtendimento;

	@PostConstruct
	public void init() {

		this.atendimentoDAO = new AtendimentoDAO(this.getEntityManager());
		this.converterAtendimento = new ConverterAtendimento();

	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.business.AtendimentoBusinessLocal#salvarAtendimento(br.com.forward.common.AtendimentoVO)
	 */
	@Override
	public void salvarAtendimento(AtendimentoVO atendimentoVO) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.business.AtendimentoBusinessLocal#excluirAtendimento(br.com.forward.common.AtendimentoVO)
	 */
	@Override
	public void excluirAtendimento(AtendimentoVO atendimentoVO) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.business.AtendimentoBusinessLocal#consultarAtendimentos()
	 */
	@Override
	public List<AtendimentoVO> consultarAtendimentos() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.business.AtendimentoBusinessLocal#consultarAtendimentosPorProspeccao()
	 */
	@Override
	public List<AtendimentoVO> consultarAtendimentosPorProspeccao(Long codigoProspeccao) throws EntityManagerException {
		LOGGER.info("consultarAtendimentosPorProspeccao - INICIO - Parâmetros: codigoProspeccao=" + codigoProspeccao);
		final List<Atendimento> listarAtendimentos = this.atendimentoDAO.listarAtendimentosPorProspeccao(codigoProspeccao);

		final List<AtendimentoVO> listaAtendimentoVO = this.converterAtendimento.converterEntitytoVO(listarAtendimentos);

		LOGGER.info("consultarAtendimentosPorProspeccao - FIM - Saída: listaAtendimentoVO =" + listaAtendimentoVO);
		return listaAtendimentoVO;
	}

}
