/**
 * 
 */
package br.com.forward.converters;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.forward.common.UnidadeVO;
import br.com.forward.entity.Unidade;

/**
 * @author Herberth Nilsen
 *
 */
public class ConverterUnidade {
	public static final Logger LOGGER = LogManager.getLogger(ConverterUnidade.class);

	public static void convertVoToEntity(UnidadeVO unidadeVO, Unidade unidade) {
		LOGGER.info(
				"ConverterUnidade.convertVoToEntity - INICIO - PARAMETROS: unidadeVO=" + unidadeVO + ", Unidade=" + unidade);
		try {
			BeanUtils.copyProperties(unidade, unidadeVO);
		} catch (IllegalAccessException | InvocationTargetException e) {

			LOGGER.error("Ocorreu erro na conversão do UnidadeVO para Unidade", e);
		}
		LOGGER.info(
				"ConverterUnidade.convertVoToEntity - INICIO - PARAMETROS: unidadeVO=" + unidadeVO + ", Unidade=" + unidade);
	}

	public static void convertEntityToVO(final Unidade unidade, final UnidadeVO unidadeVO) {
		LOGGER.info(
				"ConverterUnidade.convertVoToEntity - INICIO - PARAMETROS: unidadeVO=" + unidadeVO + ", Unidade=" + unidade);
		try {
			BeanUtils.copyProperties(unidadeVO, unidade);
		} catch (IllegalAccessException | InvocationTargetException e) {

			LOGGER.error("Ocorreu erro na conversão do UnidadeVO para Unidade", e);
		}
		LOGGER.info(
				"ConverterUnidade.convertVoToEntity - INICIO - PARAMETROS: unidadeVO=" + unidadeVO + ", Unidade=" + unidade);
	}

	public static void convertListEntityToListVo(final List<Unidade> listaUnidade, final List<UnidadeVO> listaUnidadeVO){
		
		UnidadeVO unidadeVO = new UnidadeVO();
		for(Unidade unidade : listaUnidade){
			
			ConverterUnidade.convertEntityToVO(unidade, unidadeVO);
			
			listaUnidadeVO.add(unidadeVO);
		}
		
	}
	
	public static void convertListVoToListEntity(final List<UnidadeVO> listaUnidadeVO, final List<Unidade> listaUnidade){
		
		Unidade unidade = new Unidade();
		for(UnidadeVO unidadeVO : listaUnidadeVO){
			
			ConverterUnidade.convertVoToEntity(unidadeVO, unidade);
			
			listaUnidade.add(unidade);
		}
		
	}
	
}
