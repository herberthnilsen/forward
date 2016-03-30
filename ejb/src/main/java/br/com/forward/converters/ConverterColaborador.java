/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.converters;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import br.com.forward.common.ColaboradorVO;
import br.com.forward.common.PessoaVO;
import br.com.forward.entity.Colaborador;
import br.com.forward.interfaces.converter.IConverter;

/**
 * Classe responsável por ...
 *
 * @since 16 de mar de 2016 21:32:25
 * @version x.x
 */
public class ConverterColaborador implements IConverter<ColaboradorVO, Colaborador> {

	/**
	 * Atributo LOGGER
	 */
	private static final Logger LOGGER = Logger.getLogger(ConverterColaborador.class);

	/**
	 * Atributo converterPessoa
	 */
	private final ConverterPessoa converterPessoa = new ConverterPessoa();

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.converter.IConverter#converterVOtoEntity(java.lang.Object)
	 */
	@Override
	public Colaborador converterVOtoEntity(ColaboradorVO objetoVO) {

		final Colaborador colaborador = new Colaborador();
		colaborador.setPessoa(this.converterPessoa.converterVOtoEntity(objetoVO));

		return colaborador;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.converter.IConverter#converterEntitytoVO(java.lang.Object)
	 */
	@Override
	public ColaboradorVO converterEntitytoVO(Colaborador entidade) {

		final ColaboradorVO colaboradorVO = new ColaboradorVO();
		final PessoaVO pessoaVO = this.converterPessoa.converterEntitytoVO(entidade.getPessoa());

		try {
			BeanUtils.copyProperties(colaboradorVO, pessoaVO);
			BeanUtils.copyProperties(colaboradorVO, entidade);
		} catch (IllegalAccessException | InvocationTargetException e) {
			LOGGER.info("Erro na conversão do ColaboradorVO " + e.getMessage(), e);

		}

		return colaboradorVO;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.converter.IConverter#converterVOtoEntity(java.util.List)
	 */
	@Override
	public List<Colaborador> converterVOtoEntity(List<ColaboradorVO> vos) {

		final ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>();

		for (final ColaboradorVO colaboradorVO : vos) {

			colaboradores.add(this.converterVOtoEntity(colaboradorVO));

		}

		return colaboradores;

	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.converter.IConverter#converterEntitytoVO(java.util.List)
	 */
	@Override
	public List<ColaboradorVO> converterEntitytoVO(List<Colaborador> entidades) {

		final ArrayList<ColaboradorVO> colaboradoresVO = new ArrayList<ColaboradorVO>();

		for (final Colaborador colaborador : entidades) {

			colaboradoresVO.add(this.converterEntitytoVO(colaborador));

		}
		return colaboradoresVO;
	}

}
