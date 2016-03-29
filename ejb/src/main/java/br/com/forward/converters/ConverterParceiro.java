/*
 * © 2016 Porto Seguro S.A. - Copyright - Todos os direitos reservados.
 */
package br.com.forward.converters;

import java.util.ArrayList;
import java.util.List;

import br.com.forward.common.ParceiroVO;
import br.com.forward.common.ParceiroVO;
import br.com.forward.common.ParceiroVO;
import br.com.forward.entity.Parceiro;
import br.com.forward.entity.Parceiro;
import br.com.forward.enumcode.TipoServicoParceiroEnum;
import br.com.forward.interfaces.converter.IConverter;

/**
 * Classe responsável por ...
 *
 * @since 16 de mar de 2016 21:32:25
 * @version x.x
 */
public class ConverterParceiro implements IConverter<ParceiroVO, Parceiro> {

	/**
	 * Atributo converterPessoa
	 */
	private final ConverterPessoa converterPessoa = new ConverterPessoa();

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.converter.IConverter#converterVOtoEntity(java.lang.Object)
	 */
	@Override
	public Parceiro converterVOtoEntity(ParceiroVO objetoVO) {

		final Parceiro parceiro = new Parceiro();
		parceiro.setPessoa(this.converterPessoa.converterVOtoEntity(objetoVO));

		return parceiro;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.converter.IConverter#converterEntitytoVO(java.lang.Object)
	 */
	@Override
	public ParceiroVO converterEntitytoVO(Parceiro entidade) {
		final ParceiroVO parceiroVO = (ParceiroVO) this.converterPessoa.converterEntitytoVO(entidade.getPessoa());

		parceiroVO.setTipoServicoEnum(
				TipoServicoParceiroEnum.getEnumByCodigo(entidade.getTipoServicoParceiro().getCodigoTipoServicoParceiro()));

		return parceiroVO;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.converter.IConverter#converterVOtoEntity(java.util.List)
	 */
	@Override
	public List<Parceiro> converterVOtoEntity(List<ParceiroVO> vos) {

		final ArrayList<Parceiro> parceiros = new ArrayList<Parceiro>();

		for (final ParceiroVO parceiroVO : vos) {

			parceiros.add(this.converterVOtoEntity(parceiroVO));

		}

		return parceiros;

	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.interfaces.converter.IConverter#converterEntitytoVO(java.util.List)
	 */
	@Override
	public List<ParceiroVO> converterEntitytoVO(List<Parceiro> entidades) {

		final ArrayList<ParceiroVO> listaParceiroVO = new ArrayList<ParceiroVO>();

		for (final Parceiro colaborador : entidades) {

			listaParceiroVO.add(this.converterEntitytoVO(colaborador));

		}
		return listaParceiroVO;
	}

}
