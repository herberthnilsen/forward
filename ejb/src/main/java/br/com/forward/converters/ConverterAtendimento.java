/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.converters;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import br.com.forward.common.AtendimentoVO;
import br.com.forward.common.AtendimentoVO;
import br.com.forward.entity.Atendimento;
import br.com.forward.entity.Atendimento;
import br.com.forward.enumcode.FormaAtendimentoEnum;
import br.com.forward.interfaces.converter.IConverter;

/**
 * Classe responsável por ...
 *
 * @since 16 de mar de 2016 21:32:25
 * @version x.x
 */
public class ConverterAtendimento implements IConverter<AtendimentoVO, Atendimento> {

	private static final Logger LOGGER = Logger.getLogger(ConverterAtendimento.class);

	private final ConverterColaborador converterColaborador = new ConverterColaborador();
	/**
	 * Atributo converterPessoa
	 */
	private final ConverterPessoa converterPessoa = new ConverterPessoa();

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.converter.IConverter#converterVOtoEntity(java.lang.Object)
	 */
	@Override
	public Atendimento converterVOtoEntity(AtendimentoVO objetoVO) {
		LOGGER.info("converterVOtoEntity - INICIO - Parametros: " + objetoVO);
		final Atendimento atendimento = new Atendimento();

		try {
			BeanUtils.copyProperties(atendimento, objetoVO);
		} catch (IllegalAccessException | InvocationTargetException e) {

			LOGGER.error("Erro ao realizar conversão: " + e.getMessage(), e);

		}

		LOGGER.info("converterVOtoEntity - FIM - Parametros: " + atendimento);
		return atendimento;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.converter.IConverter#converterEntitytoVO(java.lang.Object)
	 */
	@Override
	public AtendimentoVO converterEntitytoVO(Atendimento entidade) {
		LOGGER.info("converterEntitytoVO - INICIO - Parametros: " + entidade);
		final AtendimentoVO atendimentoVO = new AtendimentoVO();
		try {
			BeanUtils.copyProperties(atendimentoVO, entidade);
			atendimentoVO.setFormaAtendimento(FormaAtendimentoEnum.getEnumByCodigo(entidade.getTipoAtendimento()));
			atendimentoVO.setContato(this.converterColaborador.converterEntitytoVO(entidade.getColaborador()));
		} catch (IllegalAccessException | InvocationTargetException e) {
			LOGGER.error("Erro ao realizar a conversão" + e.getMessage(), e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		LOGGER.info("converterEntitytoVO - FIM - Parametros: " + entidade);
		return atendimentoVO;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.converter.IConverter#converterVOtoEntity(java.util.List)
	 */
	@Override
	public List<Atendimento> converterVOtoEntity(List<AtendimentoVO> vos) {

		final ArrayList<Atendimento> atendimentos = new ArrayList<Atendimento>();

		for (final AtendimentoVO atendimentoVO : vos) {

			atendimentos.add(this.converterVOtoEntity(atendimentoVO));

		}

		return atendimentos;

	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.converter.IConverter#converterEntitytoVO(java.util.List)
	 */
	@Override
	public List<AtendimentoVO> converterEntitytoVO(List<Atendimento> entidades) {

		final ArrayList<AtendimentoVO> atendimentosVO = new ArrayList<AtendimentoVO>();

		for (final Atendimento atendimento : entidades) {

			atendimentosVO.add(this.converterEntitytoVO(atendimento));

		}
		return atendimentosVO;
	}

}
