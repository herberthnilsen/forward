/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.converters;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.jboss.logging.Logger;

import br.com.forward.common.ContatoVO;
import br.com.forward.common.ContatoVO;
import br.com.forward.common.ContatoVO;
import br.com.forward.entity.PessoaContato;
import br.com.forward.interfaces.converter.IConverter;

/**
 * Classe responsável por ...
 *
 * @since 16 de mar de 2016 21:32:25
 * @version x.x
 */
public class ConverterPessoaContato implements IConverter<ContatoVO, PessoaContato> {

	/**
	 * Atributo LOGGER
	 */
	private static final Logger LOGGER = Logger.getLogger(ConverterPessoaContato.class);
	/**
	 * Atributo converterPessoa
	 */
	private final ConverterPessoa converterPessoa = new ConverterPessoa();

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.converter.IConverter#converterVOtoEntity(java.lang.Object)
	 */
	@Override
	public PessoaContato converterVOtoEntity(ContatoVO objetoVO) {
		LOGGER.info("converterVOtoEntity - INICIO");
		final PessoaContato contato = new PessoaContato();

		try {
			BeanUtils.copyProperties(contato, objetoVO);
		} catch (final IllegalAccessException e) {
			LOGGER.info("Erro na conversão " + e.getMessage(), e);
		} catch (final InvocationTargetException e) {
			LOGGER.info("Erro na conversão " + e.getMessage(), e);
		}
		contato.setTipoContato(objetoVO.getTipoContato().getCodigo());

		LOGGER.info("converterVOtoEntity - FIM");
		return contato;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.converter.IConverter#converterEntitytoVO(java.lang.Object)
	 */
	@Override
	public ContatoVO converterEntitytoVO(PessoaContato entidade) {
		LOGGER.info("converterEntitytoVO - INICIO");
		final ContatoVO contatoVO = new ContatoVO();

		try {
			BeanUtils.copyProperties(contatoVO, entidade);
		} catch (final IllegalAccessException e) {
			LOGGER.info("Erro na conversão " + e.getMessage(), e);
		} catch (final InvocationTargetException e) {
			LOGGER.info("Erro na conversão " + e.getMessage(), e);
		}

		LOGGER.info("converterEntitytoVO - FIM");
		return contatoVO;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.converter.IConverter#converterVOtoEntity(java.util.List)
	 */
	@Override
	public List<PessoaContato> converterVOtoEntity(List<ContatoVO> vos) {

		final ArrayList<PessoaContato> contatos = new ArrayList<PessoaContato>();

		for (final ContatoVO contatoVO : vos) {

			contatos.add(this.converterVOtoEntity(contatoVO));

		}

		return contatos;

	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.converter.IConverter#converterEntitytoVO(java.util.List)
	 */
	@Override
	public List<ContatoVO> converterEntitytoVO(List<PessoaContato> entidades) {

		final ArrayList<ContatoVO> listaContatoVO = new ArrayList<ContatoVO>();

		for (final PessoaContato pessoaContato : entidades) {

			listaContatoVO.add(this.converterEntitytoVO(pessoaContato));

		}
		return listaContatoVO;
	}

}
