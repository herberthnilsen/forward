/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.business;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import br.com.forward.common.ClienteVO;
import br.com.forward.common.ProspeccaoVO;
import br.com.forward.converters.ConverterCliente;
import br.com.forward.converters.ConverterEvento;
import br.com.forward.converters.ConverterPessoa;
import br.com.forward.converters.ConverterProspeccao;
import br.com.forward.dao.ClienteDAO;
import br.com.forward.dao.EventoDAO;
import br.com.forward.dao.PessoaDAO;
import br.com.forward.dao.ProspeccaoDAO;
import br.com.forward.entity.Cliente;
import br.com.forward.entity.Pessoa;
import br.com.forward.entity.Prospeccao;
import br.com.forward.exception.EntityManagerException;
import br.com.forward.interfaces.business.ProspeccaoBusinessLocal;
import br.com.forward.util.Utils;

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

	/**
	 * Atributo clienteDAO
	 */
	private ClienteDAO clienteDAO;

	/**
	 * Atributo converterEvento
	 */
	private ConverterEvento converterEvento;

	/**
	 * Atributo converterPessoa
	 */
	private ConverterPessoa converterPessoa;

	/**
	 * Atributo converterProspeccao
	 */
	private ConverterProspeccao converterProspeccao;

	/**
	 * Atributo converterCliente
	 */
	private ConverterCliente converterCliente;

	@PostConstruct
	public void init() {
		LOGGER.info("init - INICIO");
		this.pessoaDAO = new PessoaDAO(this.getEntityManager());
		this.eventoDAO = new EventoDAO(this.getEntityManager());
		this.prospeccaoDAO = new ProspeccaoDAO(this.getEntityManager());
		this.clienteDAO = new ClienteDAO(this.getEntityManager());

		this.converterEvento = new ConverterEvento();
		this.converterPessoa = new ConverterPessoa();
		this.converterProspeccao = new ConverterProspeccao();
		this.converterCliente = new ConverterCliente();

		LOGGER.info("init - FIM");
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.business.ProspeccaoBusinessLocal#salvarPropeccao(br.com.forward.common.ProspeccaoVO)
	 */
	@Override
	public void salvarPropeccao(ProspeccaoVO prospeccaoVO) {
		LOGGER.info("salvarPropeccao - INICIO - PARÂMETROS:" + prospeccaoVO);

		final Prospeccao prospeccao = this.converterProspeccao.converterVOtoEntity(prospeccaoVO);

		try {
			final ArrayList<Integer> codigosCliente = new ArrayList<Integer>();

			if (Utils.isNotEmpty(prospeccaoVO.getNoiva().getNomePessoa())) {
				codigosCliente.add(this.salvarCliente(prospeccaoVO.getNoiva()));
			}

			if (Utils.isNotEmpty(prospeccaoVO.getNoivo().getNomePessoa())) {
				codigosCliente.add(this.salvarCliente(prospeccaoVO.getNoivo()));
			}

			this.prospeccaoDAO.salvar(prospeccao);

			// this.prospeccaoDAO.salvarClienteProspeccao();

		} catch (final EntityManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		LOGGER.info("salvarPropeccao - FIM");

	}

	private Integer salvarCliente(ClienteVO clienteVO) throws EntityManagerException {
		LOGGER.info("salvarCliente - INICIO - PARÂMETROS:" + clienteVO);

		this.salvarPessoaCliente(clienteVO);
		final Cliente cliente = this.converterCliente.converterVOtoEntity(clienteVO);
		this.clienteDAO.salvarCliente(cliente);

		LOGGER.info("salvarCliente - FIM ");
		return cliente.getCodigoCliente();
	}

	private void salvarPessoaCliente(ClienteVO clienteVO) throws EntityManagerException {
		LOGGER.info("salvarPessoaCliente - INICIO - PARÂMETROS:" + clienteVO);

		final Pessoa pessoa = this.converterPessoa.converterVOtoEntity(clienteVO);

		this.pessoaDAO.salvarPessoa(pessoa);
		clienteVO.setCodigoPessoa(pessoa.getCodigoPessoa());

		LOGGER.info("salvarPessoaCliente - FIM");
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.business.ProspeccaoBusinessLocal#excluirPropeccao(br.com.forward.common.ProspeccaoVO)
	 */
	@Override
	public void excluirPropeccao(ProspeccaoVO prospeccaoVO) {
		LOGGER.info("excluirPropeccao - INICIO - PARÂMETROS:" + prospeccaoVO);
		LOGGER.info("excluirPropeccao - FIM");
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
