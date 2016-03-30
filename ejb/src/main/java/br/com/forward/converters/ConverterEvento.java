/**
 * 
 */
package br.com.forward.converters;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.forward.common.EventoVO;
import br.com.forward.entity.Espaco;
import br.com.forward.entity.Evento;
import br.com.forward.entity.Orcamento;
import br.com.forward.entity.TipoEvento;
import br.com.forward.enumcode.TipoEventoEnum;

/**
 * @author Herberth Nilsen
 */
public class ConverterEvento {

	public static final Logger LOGGER = LogManager.getLogger(ConverterEvento.class);

	public static void convertVoToEntity(EventoVO eventoVO, Evento evento) {
		LOGGER.info("ConverterEvento.convertVoToEntity - INICIO - PARAMETROS: eventoVO=" + eventoVO + ", Evento=" + evento);
		try {
			BeanUtils.copyProperties(evento, eventoVO);

			final TipoEvento tipoEvento = new TipoEvento();
			tipoEvento.setCodigoTipoEvento(eventoVO.getTipoEvento().getCodigo());
			evento.setTipoEvento(tipoEvento);

			final Espaco espaco = new Espaco();
			espaco.setCodigoEspaco(eventoVO.getCodigoEspaco());
			evento.setEspaco(espaco);

			final Orcamento orcamento = new Orcamento();
			orcamento.setCodigoOrcamento(eventoVO.getCodigoOrcamento());
			evento.setOrcamento(orcamento);

		} catch (IllegalAccessException | InvocationTargetException e) {

			LOGGER.error("Ocorreu erro na conversão do EventoVO para Evento", e);
		}
		LOGGER.info("ConverterEvento.convertVoToEntity - INICIO - PARAMETROS: eventoVO=" + eventoVO + ", Evento=" + evento);
	}

	public static void convertEntityToVO(final Evento evento, final EventoVO eventoVO) {
		LOGGER.info("ConverterEvento.convertVoToEntity - INICIO - PARAMETROS: eventoVO=" + eventoVO + ", Evento=" + evento);
		try {
			BeanUtils.copyProperties(eventoVO, evento);

			eventoVO.setCodigoEspaco(evento.getEspaco().getCodigoEspaco());
			eventoVO.setCodigoOrcamento(evento.getOrcamento().getCodigoOrcamento());
			eventoVO.setTipoEvento(TipoEventoEnum.getEnumByCodigo(evento.getTipoEvento().getCodigoTipoEvento()));
		} catch (IllegalAccessException | InvocationTargetException e) {

			LOGGER.error("Ocorreu erro na conversão do EventoVO para Evento", e);
		}
		LOGGER.info("ConverterEvento.convertVoToEntity - INICIO - PARAMETROS: eventoVO=" + eventoVO + ", Evento=" + evento);
	}

	public static void convertListEntityToListVo(final List<Evento> listaEvento, final List<EventoVO> listaEventoVO) {

		final EventoVO eventoVO = new EventoVO();
		for (final Evento evento : listaEvento) {

			ConverterEvento.convertEntityToVO(evento, eventoVO);

			listaEventoVO.add(eventoVO);
		}

	}

	public static void convertListVoToListEntity(final List<EventoVO> listaEventoVO, final List<Evento> listaEvento) {

		final Evento evento = new Evento();
		for (final EventoVO eventoVO : listaEventoVO) {

			ConverterEvento.convertVoToEntity(eventoVO, evento);

			listaEvento.add(evento);
		}

	}

}
