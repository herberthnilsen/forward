package br.com.forward.converters;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.forward.common.CategoriaInsumoVO;
import br.com.forward.entity.CategoriaInsumo;
import br.com.forward.util.Utils;

public class ConverterCategoriaInsumoToCategoriaInsumoVO {
	public static final Logger logger = LogManager.getLogger(ConverterCategoriaInsumoToCategoriaInsumoVO.class);

	public static void converterListCategoriaInsumoToListCategoriaInsumoVO(List<CategoriaInsumo> listaCategoriaInsumo,
			List<CategoriaInsumoVO> listaCategoriaInsumoVO) {
		logger.info(
				"ConverterCategoriaInsumoToCategoriaInsumoVO.converterListCategoriaInsumoToListCategoriaInsumoVO [INICIO] - parametros: ListaCategoriaInsumo="
						+ listaCategoriaInsumo + ", ListaCategoriaInsumoVO=" + listaCategoriaInsumoVO);

		if (Utils.isCollectionNotNullAndNotEmpty(listaCategoriaInsumo).booleanValue()) {
			for (CategoriaInsumo categoriaInsumo : listaCategoriaInsumo) {
				CategoriaInsumoVO categoriaInsumoVO = new CategoriaInsumoVO();

				converterCategoriaInsumoToCategoriaInsumoVO(categoriaInsumo, categoriaInsumoVO);

				listaCategoriaInsumoVO.add(categoriaInsumoVO);
			}
		}
		logger.info(
				"ConverterCategoriaInsumoToCategoriaInsumoVO.converterListCategoriaInsumoToListCategoriaInsumoVO [FIM] - parametros: ListaCategoriaInsumo="
						+ listaCategoriaInsumo + ", ListaCategoriaInsumoVO=" + listaCategoriaInsumoVO);
	}

	public static void converterCategoriaInsumoToCategoriaInsumoVO(CategoriaInsumo categoriaInsumo,
			CategoriaInsumoVO categoriaInsumoVO) {
		categoriaInsumoVO.setCodigoCategoria(categoriaInsumo.getCodigoCategoriaInsumo());
		categoriaInsumoVO.setNomeCategoria(categoriaInsumo.getNomeCategoria());
		categoriaInsumoVO.setDescricaoCategoria(categoriaInsumo.getDescricaoCategoria());
	}

	public static void converterCategoriaInsumoVoToCategoriaInsumo(CategoriaInsumoVO categoriaInsumoVO,
			CategoriaInsumo categoriaInsumo) {
		categoriaInsumo.setCodigoCategoriaInsumo(categoriaInsumoVO.getCodigoCategoria());
		categoriaInsumo.setNomeCategoria(categoriaInsumoVO.getNomeCategoria());
		categoriaInsumo.setDescricaoCategoria(categoriaInsumoVO.getDescricaoCategoria());
	}
}
