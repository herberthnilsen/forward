/**
 * 
 */
package br.com.forward.converters;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.forward.common.InsumoVO;
import br.com.forward.entity.Insumo;
import br.com.forward.entity.SubItemInsumo;
import br.com.forward.entity.SubItemInsumoPK;

/**
 * @author Herberth Nilsen
 *
 */
public class ConverterSubItemInsumo {
	public static final Logger LOGGER = LogManager.getLogger(ConverterSubItemInsumo.class);

	public static void convertVoToEntity(InsumoVO insumoVO, InsumoVO subItemInsumoVO, SubItemInsumo subItemInsumo) {
		LOGGER.info("ConverterSubItemInsumo.convertVoToEntity - INICIO - PARAMETROS: insumoVO=" + insumoVO
				+ ", SubItemInsumo=" + subItemInsumo);

		SubItemInsumoPK subItemInsumoPK = new SubItemInsumoPK();
		subItemInsumoPK.setCodigoInsumoPai(insumoVO.getCodigoInsumo());
		subItemInsumoPK.setCodigoSubInsumo(subItemInsumoVO.getCodigoInsumo());

		subItemInsumo.setSubItemPK(subItemInsumoPK);

		LOGGER.info("ConverterSubItemInsumo.convertVoToEntity - INICIO - PARAMETROS: insumoVO=" + insumoVO
				+ ", SubItemInsumo=" + subItemInsumo);
	}

	public static void convertEntityToVO(final Insumo subItemInsumo, final InsumoVO insumoVO) {
		LOGGER.info("ConverterSubItemInsumo.convertVoToEntity - INICIO - PARAMETROS: insumoVO=" + insumoVO
				+ ", SubItemInsumo=" + subItemInsumo);

		if (insumoVO.getSubitens() == null) {

			insumoVO.setSubitens(new ArrayList<InsumoVO>());
		}

		InsumoVO subItemInsumoVO = new InsumoVO();

		ConverterInsumo.convertEntityToVO(subItemInsumo, subItemInsumoVO);
		
		insumoVO.getSubitens().add(subItemInsumoVO);

		LOGGER.info("ConverterSubItemInsumo.convertVoToEntity - INICIO - PARAMETROS: insumoVO=" + insumoVO
				+ ", SubItemInsumo=" + subItemInsumo);
	}

	public static void convertListEntityToListVo(final List<SubItemInsumo> listaSubItemInsumo, InsumoVO insumoVO) {

		if (!listaSubItemInsumo.isEmpty()) {
			for (SubItemInsumo subItemInsumo : listaSubItemInsumo) {

				ConverterSubItemInsumo.convertEntityToVO(subItemInsumo.getSubItemInsumo(), insumoVO);

			}

		}
	}

	public static void convertListVoToListEntity(final InsumoVO insumoVO,
			final List<SubItemInsumo> listaSubItemInsumo) {

		if(insumoVO.getSubitens() != null){
			
			for (InsumoVO subItemInsumoVO : insumoVO.getSubitens()) {
				SubItemInsumo subItemInsumo = new SubItemInsumo();
				ConverterSubItemInsumo.convertVoToEntity(insumoVO, subItemInsumoVO, subItemInsumo);

				listaSubItemInsumo.add(subItemInsumo);
			}
		}

	}

}
