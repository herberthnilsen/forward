/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.converters;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import br.com.forward.common.ClienteVO;
import br.com.forward.entity.Cliente;
import br.com.forward.interfaces.converter.IConverter;
import br.com.forward.util.Utils;

/**
 * Classe responsável por ...
 *
 * @since 16 de mar de 2016 21:35:07
 * @version x.x
 */
public class ConverterCliente implements IConverter<ClienteVO, Cliente> {

	/**
	 * Atributo LOGGER
	 */
	private static final Logger LOGGER = Logger.getLogger(ConverterCliente.class);

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.converter.IConverter#converterVOtoEntity(java.lang.Object)
	 */
	@Override
	public Cliente converterVOtoEntity(ClienteVO objetoVO) {
		LOGGER.info("converterVOtoEntity - INICIO - Paramentro: clienteVO=" + objetoVO);
		final Cliente cliente = new Cliente();

		try {
			BeanUtils.copyProperties(cliente, objetoVO);

			// TODO colcoar usuário da sessão
			cliente.getColaborador().setCodigoPessoa(1);

			if (!Utils.isNotEmpty(cliente.getDataCadastro())) {
				cliente.setDataCadastro(new Timestamp(Calendar.getInstance().getTime().getTime()));
			}

		} catch (final IllegalAccessException e) {
			LOGGER.error(e.getMessage());
		} catch (final InvocationTargetException e) {
			LOGGER.error(e.getMessage());
		}
		LOGGER.info("converterVOtoEntity - FIM - Paramentro: cliente=" + cliente);
		return cliente;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.converter.IConverter#converterEntitytoVO(java.lang.Object)
	 */
	@Override
	public ClienteVO converterEntitytoVO(Cliente entidade) {
		LOGGER.info("converterVOtoEntity - FIM- Paramentro: cliente=");

		final ClienteVO clienteVO = new ClienteVO();

		try {
			BeanUtils.copyProperties(clienteVO, entidade);
			// clienteVO.setContatos(this.converterCliente.converterEntitytoVO(entidade.getClientes()));
		} catch (final IllegalAccessException e) {
			LOGGER.error(e.getMessage());
		} catch (final InvocationTargetException e) {
			LOGGER.error(e.getMessage());
		}

		LOGGER.info("converterVOtoEntity - FIM- Paramentro: cliente=" + clienteVO);
		return clienteVO;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.converter.IConverter#converterVOtoEntity(java.util.List)
	 */
	@Override
	public List<Cliente> converterVOtoEntity(List<ClienteVO> vos) {
		LOGGER.info("List converterVOtoEntity - INICIO - Parametro: List<ClienteVO>=" + vos);
		final List<Cliente> listaCliente = new ArrayList<Cliente>();

		for (final ClienteVO clienteVO : vos) {

			listaCliente.add(this.converterVOtoEntity(clienteVO));

		}
		LOGGER.info("List converterVOtoEntity - FIM- Parametro: List<Cliente>=" + listaCliente);
		return listaCliente;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.converter.IConverter#converterEntitytoVO(java.util.List)
	 */
	@Override
	public List<ClienteVO> converterEntitytoVO(List<Cliente> entidades) {
		LOGGER.info("List converterVOtoEntity - INICIO - Parametro: List<Cliente>=" + entidades);
		final List<ClienteVO> listaClienteVO = new ArrayList<ClienteVO>();

		for (final Cliente cliente : entidades) {

			listaClienteVO.add(this.converterEntitytoVO(cliente));

		}
		LOGGER.info("List converterVOtoEntity - FIM- Parametro: List<ClienteVO>=" + listaClienteVO);
		return listaClienteVO;
	}

}
