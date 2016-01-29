/**
 * 
 */
package br.com.forward.converters;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.forward.common.InsumoVO;
import br.com.forward.entity.CategoriaInsumo;
import br.com.forward.entity.Insumo;
import br.com.forward.entity.Unidade;

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

			// Setando a data atual como data de cadastro
			if (insumo.getDataCadastro() != null) {
				insumo.setDataCadastro(new Date());
			}

			// Verifica se a entidade não tem o código e se o VO tem o código,
			// se válido, atribui o código à entidade
			if (insumo.getCodigoInsumo() == null && insumoVO.getCodigoInsumo() != null) {

				insumo.setCodigoInsumo(insumoVO.getCodigoInsumo());
			}

			// Criando CategoriaInsumo e Unidade para atribuir ao Insumo
			CategoriaInsumo categoriaInsumo = new CategoriaInsumo();
			Unidade unidade = new Unidade();
			categoriaInsumo.setCodigoCategoriaInsumo(insumoVO.getCategoriaInsumoVO().getCodigoCategoria());
			unidade.setCodigoUnidade(insumoVO.getUnidadeVO().getCodigoUnidade());
			insumo.setCategoriaInsumo(categoriaInsumo);
			insumo.setUnidade(unidade);

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

			ConverterCategoriaInsumo.converterCategoriaInsumoToCategoriaInsumoVO(insumo.getCategoriaInsumo(),
					insumoVO.getCategoriaInsumoVO());
			ConverterUnidade.convertEntityToVO(insumo.getUnidade(), insumoVO.getUnidadeVO());

		} catch (IllegalAccessException | InvocationTargetException e) {

			LOGGER.error("Ocorreu erro na conversão do InsumoVO para Insumo", e);
		}
		LOGGER.info(
				"ConverterInsumo.convertVoToEntity - INICIO - PARAMETROS: insumoVO=" + insumoVO + ", Insumo=" + insumo);
	}

	public static void convertListEntityToListVo(final List<Insumo> listaInsumo, final List<InsumoVO> listaInsumoVO) {

		for (Insumo insumo : listaInsumo) {
			InsumoVO insumoVO = new InsumoVO();

			ConverterInsumo.convertEntityToVO(insumo, insumoVO);

			listaInsumoVO.add(insumoVO);
		}

	}

	public static void convertListVoToListEntity(final List<InsumoVO> listaInsumoVO, final List<Insumo> listaInsumo) {

		Insumo insumo = new Insumo();
		for (InsumoVO insumoVO : listaInsumoVO) {

			ConverterInsumo.convertVoToEntity(insumoVO, insumo);

			listaInsumo.add(insumo);
		}

	}

}
