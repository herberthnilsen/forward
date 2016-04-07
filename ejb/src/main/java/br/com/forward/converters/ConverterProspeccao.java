/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.converters;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import br.com.forward.common.ProspeccaoVO;
import br.com.forward.entity.Prospeccao;
import br.com.forward.interfaces.converter.IConverter;
import br.com.forward.util.Utils;

/**
 * Classe responsável por ...
 *
 * @since 16 de mar de 2016 21:35:07
 * @version x.x
 */
public class ConverterProspeccao implements IConverter<ProspeccaoVO, Prospeccao> {

	/**
	 * Atributo LOGGER
	 */
	private static final Logger LOGGER = Logger.getLogger(ConverterProspeccao.class);

	// private final ConverterProspeccaoContato converterProspeccaoContato = new ConverterProspeccaoContato();

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.converter.IConverter#converterVOtoEntity(java.lang.Object)
	 */
	@Override
	public Prospeccao converterVOtoEntity(ProspeccaoVO objetoVO) {
		LOGGER.info("converterVOtoEntity - INICIO - Paramentro: prospeccaoVO=" + objetoVO);
		final Prospeccao prospeccao = new Prospeccao();

		try {
			BeanUtils.copyProperties(prospeccao, objetoVO);

			if (Utils.isNotEmpty(objetoVO.getDataPendencia()) && Utils.isNotEmpty(objetoVO.getHoraPendencia())) {

				final Calendar dataPendencia = Calendar.getInstance();
				dataPendencia.setTime(objetoVO.getDataPendencia());
				dataPendencia.setTime(objetoVO.getHoraPendencia());
				prospeccao.setDataPendencia(dataPendencia.getTime());
			}

			prospeccao.getColaborador().setCodigoColaborador(objetoVO.getColaborador().getCodigoPessoa());
			prospeccao.setStatusAtendimento(objetoVO.getStatus().getCodigo());
			prospeccao.setStatusMarketing(objetoVO.getStatusMarketing().getCodigo());

			if (Utils.isEmpty(objetoVO.getDataCadastro())) {

				prospeccao.setDataCadastro(new Date());

			}

		} catch (final IllegalAccessException e) {
			LOGGER.error(e.getMessage());
		} catch (final InvocationTargetException e) {
			LOGGER.error(e.getMessage());
		}
		LOGGER.info("converterVOtoEntity - FIM - Paramentro: prospeccao=" + prospeccao);
		return prospeccao;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.converter.IConverter#converterEntitytoVO(java.lang.Object)
	 */
	@Override
	public ProspeccaoVO converterEntitytoVO(Prospeccao entidade) {
		LOGGER.info("converterVOtoEntity - FIM- Paramentro: prospeccao=");

		final ProspeccaoVO prospeccaoVO = new ProspeccaoVO();

		try {

			BeanUtils.copyProperties(prospeccaoVO, entidade);

		} catch (final IllegalAccessException e) {
			LOGGER.error(e.getMessage());
		} catch (final InvocationTargetException e) {
			LOGGER.error(e.getMessage());
		}

		LOGGER.info("converterVOtoEntity - FIM- Paramentro: prospeccao=" + prospeccaoVO);
		return prospeccaoVO;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.converter.IConverter#converterVOtoEntity(java.util.List)
	 */
	@Override
	public List<Prospeccao> converterVOtoEntity(List<ProspeccaoVO> vos) {
		LOGGER.info("List converterVOtoEntity - INICIO - Parametro: List<ProspeccaoVO>=" + vos);
		final List<Prospeccao> listaProspeccao = new ArrayList<Prospeccao>();

		for (final ProspeccaoVO prospeccaoVO : vos) {

			listaProspeccao.add(this.converterVOtoEntity(prospeccaoVO));

		}
		LOGGER.info("List converterVOtoEntity - FIM- Parametro: List<Prospeccao>=" + listaProspeccao);
		return listaProspeccao;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.converter.IConverter#converterEntitytoVO(java.util.List)
	 */
	@Override
	public List<ProspeccaoVO> converterEntitytoVO(List<Prospeccao> entidades) {
		LOGGER.info("List converterVOtoEntity - INICIO - Parametro: List<Prospeccao>=" + entidades);
		final List<ProspeccaoVO> listaProspeccaoVO = new ArrayList<ProspeccaoVO>();

		for (final Prospeccao prospeccao : entidades) {

			listaProspeccaoVO.add(this.converterEntitytoVO(prospeccao));

		}
		LOGGER.info("List converterVOtoEntity - FIM- Parametro: List<ProspeccaoVO>=" + listaProspeccaoVO);
		return listaProspeccaoVO;
	}

}
