/**
 * 
 */
package br.com.forward.converters;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.forward.common.InsumoVO;
import br.com.forward.entity.Insumo;

/**
 * @author Herberth Nilsen
 *
 */
public class ConverterInsumo {
	public static final Logger LOGGER = LogManager.getLogger(ConverterInsumo.class);

	public static void convertVoToEntity(InsumoVO insumoVO, Insumo insumo) {
		LOGGER.info(
				"ConverterInsumo.convertVoToEntity - INICIO - PARAMETROS: insumoVO=" + insumoVO + ", Insumo=" + insumo);
		try {
			BeanUtils.copyProperties(insumo, insumoVO);
		} catch (IllegalAccessException | InvocationTargetException e) {

			LOGGER.error("Ocorreu erro na conversão do InsumoVO para Insumo", e);
		}
		LOGGER.info(
				"ConverterInsumo.convertVoToEntity - INICIO - PARAMETROS: insumoVO=" + insumoVO + ", Insumo=" + insumo);
	}

	public static void convertEntityToVO(final Insumo insumo, final InsumoVO insumoVO) {
		LOGGER.info(
				"ConverterInsumo.convertVoToEntity - INICIO - PARAMETROS: insumoVO=" + insumoVO + ", Insumo=" + insumo);
		try {
			BeanUtils.copyProperties(insumoVO, insumo);
		} catch (IllegalAccessException | InvocationTargetException e) {

			LOGGER.error("Ocorreu erro na conversão do InsumoVO para Insumo", e);
		}
		LOGGER.info(
				"ConverterInsumo.convertVoToEntity - INICIO - PARAMETROS: insumoVO=" + insumoVO + ", Insumo=" + insumo);
	}

	public static void convertListEntityToListVo(final List<Insumo> listaInsumo, final List<InsumoVO> listaInsumoVO){
		
		InsumoVO insumoVO = new InsumoVO();
		for(Insumo insumo : listaInsumo){
			
			ConverterInsumo.convertEntityToVO(insumo, insumoVO);
			
			listaInsumoVO.add(insumoVO);
		}
		
	}
	
	public static void convertListVoToListEntity(final List<InsumoVO> listaInsumoVO, final List<Insumo> listaInsumo){
		
		Insumo insumo = new Insumo();
		for(InsumoVO insumoVO : listaInsumoVO){
			
			ConverterInsumo.convertVoToEntity(insumoVO, insumo);
			
			listaInsumo.add(insumo);
		}
		
	}
	
}
