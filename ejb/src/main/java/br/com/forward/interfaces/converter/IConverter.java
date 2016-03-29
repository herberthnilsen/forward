package br.com.forward.interfaces.converter;

import java.util.List;

/**
 * The Interface IConverter.
 *
 * @param <V> Tipo do VO
 * @param <E> Tipo da Entidade
 */
public interface IConverter<V, E> {

	/**
	 * Converter VO para Entidade.
	 *
	 * @param objetoVO the objeto vo
	 * @return the e
	 */
	E converterVOtoEntity(final V objetoVO);

	/**
	 * Converter Entidade para VO.
	 *
	 * @param entidade the entidade
	 * @return the v
	 */
	V converterEntitytoVO(final E entidade);

	/**
	 * Converter lista de VO para lista de Entidade.
	 *
	 * @param vos the vos
	 * @return the List
	 */
	List<E> converterVOtoEntity(final List<V> vos);

	/**
	 * Converter lista de Entidade para lista de VO.
	 *
	 * @param entidades the entidades
	 * @return the List
	 */
	List<V> converterEntitytoVO(final List<E> entidades);

}