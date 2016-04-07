/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.business;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import br.com.forward.common.ClienteVO;
import br.com.forward.common.EventoVO;
import br.com.forward.converters.ConverterCliente;
import br.com.forward.converters.ConverterEvento;
import br.com.forward.converters.ConverterPessoa;
import br.com.forward.dao.ClienteDAO;
import br.com.forward.dao.EventoDAO;
import br.com.forward.entity.Cliente;
import br.com.forward.entity.Evento;
import br.com.forward.entity.Pessoa;
import br.com.forward.exception.EntityManagerException;
import br.com.forward.interfaces.business.EventoBusinessLocal;

/**
 * Classe responsável por ...
 *
 * @since 11 de mar de 2016 20:07:57
 * @version x.x
 */
@Stateless
public class EventoBusiness extends GenericEJB implements EventoBusinessLocal {

	/**
	 * Atributo LOGGER
	 */
	private static final Logger LOGGER = Logger.getLogger(EventoBusiness.class);

	/**
	 * Atributo eventoDAO
	 */
	private EventoDAO eventoDAO;

	/**
	 * Atributo converterEvento
	 */
	private ConverterEvento converterEvento;

	/**
	 * Atributo converterPessoa
	 */
	private ConverterPessoa converterPessoa;

	/**
	 * Atributo converterCliente
	 */
	private ConverterCliente converterCliente;

	private ClienteDAO clienteDAO;

	@PostConstruct
	public void init() {
		LOGGER.info("init - INICIO");
		this.eventoDAO = new EventoDAO(this.getEntityManager());

		this.converterEvento = new ConverterEvento();
		this.converterPessoa = new ConverterPessoa();
		this.converterCliente = new ConverterCliente();

		LOGGER.info("init - FIM");
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.business.EventoBusinessLocal#salvarEvento(br.com.forward.common.EventoVO)
	 */
	@Override
	public void salvarEvento(EventoVO eventoVO) {
		LOGGER.info("salvarEvento - INICIO - PARÂMETROS:" + eventoVO);

		try {

			final Evento evento = new Evento();

			ConverterEvento.convertVoToEntity(eventoVO, evento);

			this.eventoDAO.salvar(evento);
			// this.eventoDAO.salvarClienteEvento();

		} catch (final EntityManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		LOGGER.info("salvarEvento - FIM");

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

		// this.pessoaDAO.salvarPessoa(pessoa);
		clienteVO.setCodigoPessoa(pessoa.getCodigoPessoa());

		LOGGER.info("salvarPessoaCliente - FIM");
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.business.EventoBusinessLocal#excluirEvento(br.com.forward.common.EventoVO)
	 */
	@Override
	public void excluirEvento(EventoVO eventoVO) {
		LOGGER.info("excluirEvento - INICIO - PARÂMETROS:" + eventoVO);
		LOGGER.info("excluirEvento - FIM");
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.business.EventoBusinessLocal#consultarProspeccoes()
	 */
	@Override
	public List<EventoVO> consultarProspeccoes() {
		// TODO Auto-generated method stub
		return null;
	}

}
