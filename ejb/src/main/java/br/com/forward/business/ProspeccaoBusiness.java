/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.business;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import br.com.forward.common.ProspeccaoVO;
import br.com.forward.dao.EventoDAO;
import br.com.forward.dao.PessoaDAO;
import br.com.forward.dao.ProspeccaoDAO;
import br.com.forward.interfaces.business.ProspeccaoBusinessLocal;

/**
 * Classe responsável por ...
 *
 * @since 11 de mar de 2016 20:07:57
 * @version x.x
 */
@Stateless
public class ProspeccaoBusiness extends GenericEJB implements ProspeccaoBusinessLocal {

	/**
	 * Atributo LOGGER
	 */
	private static final Logger LOGGER = Logger.getLogger(ProspeccaoBusiness.class);

	/**
	 * Atributo eventoDAO
	 */
	private EventoDAO eventoDAO;

	/**
	 * Atributo pessoaDAO
	 */
	private PessoaDAO pessoaDAO;

	/**
	 * Atributo prospeccaoDAO
	 */
	private ProspeccaoDAO prospeccaoDAO;

	@PostConstruct
	public void init() {
		LOGGER.info("init - INICIO");
		this.pessoaDAO = new PessoaDAO(this.getEntityManager());
		this.eventoDAO = new EventoDAO(this.getEntityManager());
		this.prospeccaoDAO = new ProspeccaoDAO(this.getEntityManager());

		LOGGER.info("init - FIM");
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.business.ProspeccaoBusinessLocal#salvarPropeccao(br.com.forward.common.ProspeccaoVO)
	 */
	@Override
	public void salvarPropeccao(ProspeccaoVO prospeccao) {
		LOGGER.info("salvarPropeccao - INICIO - PARÂMETROS:" + prospeccao);

		LOGGER.info("salvarPropeccao - FIM");

	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.business.ProspeccaoBusinessLocal#excluirPropeccao(br.com.forward.common.ProspeccaoVO)
	 */
	@Override
	public void excluirPropeccao(ProspeccaoVO prospeccao) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.business.ProspeccaoBusinessLocal#consultarProspeccoes()
	 */
	@Override
	public List<ProspeccaoVO> consultarProspeccoes() {
		// TODO Auto-generated method stub
		return null;
	}

}
