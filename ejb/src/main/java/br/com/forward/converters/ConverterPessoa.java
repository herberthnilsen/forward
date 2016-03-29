/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.converters;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import br.com.forward.common.PessoaVO;
import br.com.forward.entity.Pessoa;
import br.com.forward.interfaces.converter.IConverter;

/**
 * Classe responsável por ...
 *
 * @since 16 de mar de 2016 21:35:07
 * @version x.x
 */
public class ConverterPessoa implements IConverter<PessoaVO, Pessoa> {

	/**
	 * Atributo LOGGER
	 */
	private static final Logger LOGGER = Logger.getLogger(ConverterPessoa.class);

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.converter.IConverter#converterVOtoEntity(java.lang.Object)
	 */
	@Override
	public Pessoa converterVOtoEntity(PessoaVO objetoVO) {
		LOGGER.info("converterVOtoEntity - INICIO - Paramentro: pessoaVO=" + objetoVO);
		final Pessoa pessoa = new Pessoa();

		try {
			BeanUtils.copyProperties(pessoa, objetoVO);
		} catch (final IllegalAccessException e) {
			LOGGER.error(e.getMessage());
		} catch (final InvocationTargetException e) {
			LOGGER.error(e.getMessage());
		}
		LOGGER.info("converterVOtoEntity - FIM - Paramentro: pessoa=" + pessoa);
		return pessoa;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.converter.IConverter#converterEntitytoVO(java.lang.Object)
	 */
	@Override
	public PessoaVO converterEntitytoVO(Pessoa entidade) {
		LOGGER.info("converterVOtoEntity - FIM- Paramentro: pessoa=" + entidade);

		final PessoaVO pessoaVO = new PessoaVO();

		try {
			BeanUtils.copyProperties(pessoaVO, entidade);
		} catch (final IllegalAccessException e) {
			LOGGER.error(e.getMessage());
		} catch (final InvocationTargetException e) {
			LOGGER.error(e.getMessage());
		}

		LOGGER.info("converterVOtoEntity - FIM- Paramentro: pessoa=" + pessoaVO);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.converter.IConverter#converterVOtoEntity(java.util.List)
	 */
	@Override
	public List<Pessoa> converterVOtoEntity(List<PessoaVO> vos) {
		LOGGER.info("List converterVOtoEntity - INICIO - Parametro: List<PessoaVO>=" + vos);
		final List<Pessoa> listaPessoa = new ArrayList<Pessoa>();

		for (final PessoaVO pessoaVO : vos) {

			listaPessoa.add(this.converterVOtoEntity(pessoaVO));

		}
		LOGGER.info("List converterVOtoEntity - FIM- Parametro: List<Pessoa>=" + listaPessoa);
		return listaPessoa;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.converter.IConverter#converterEntitytoVO(java.util.List)
	 */
	@Override
	public List<PessoaVO> converterEntitytoVO(List<Pessoa> entidades) {
		LOGGER.info("List converterVOtoEntity - INICIO - Parametro: List<Pessoa>=" + entidades);
		final List<PessoaVO> listaPessoaVO = new ArrayList<PessoaVO>();

		for (final Pessoa pessoa : entidades) {

			listaPessoaVO.add(this.converterEntitytoVO(pessoa));

		}
		LOGGER.info("List converterVOtoEntity - FIM- Parametro: List<PessoaVO>=" + listaPessoaVO);
		return listaPessoaVO;
	}

}
