package br.com.forward.business;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.jboss.logging.Logger;

import br.com.forward.common.CategoriaInsumoVO;
import br.com.forward.converters.ConverterCategoriaInsumoToCategoriaInsumoVO;
import br.com.forward.dao.CategoriaInsumoDAO;
import br.com.forward.entity.CategoriaInsumo;
import br.com.forward.exception.EntityManagerException;
import br.com.forward.interfaces.business.CategoriaInsumoBusinessLocal;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class CategoriaInsumoBusiness extends GenericBusiness implements CategoriaInsumoBusinessLocal {
	/* 26 */ public static final Logger LOGGER = Logger.getLogger(CategoriaInsumoBusiness.class);
	private CategoriaInsumoDAO categoriaInsumoDAO;

	@PostConstruct
	public void init() {
		this.categoriaInsumoDAO = new CategoriaInsumoDAO(this.entityManager);
	}

	public List<CategoriaInsumoVO> carregarCategoriaInsumo(CategoriaInsumoVO categoriaInsumoVO) {
		LOGGER.info("CategoriaInsumoBusiness.carregarCategoriaInsumo [INICIO]");

		List<CategoriaInsumoVO> listaCategoriaInsumoVO = new ArrayList<CategoriaInsumoVO>();
		try {
			if ((categoriaInsumoVO.getCodigoCategoria() == null) && (categoriaInsumoVO.getNomeCategoria() == null)
					&& (categoriaInsumoVO.getDescricaoCategoria() == null)) {
				ConverterCategoriaInsumoToCategoriaInsumoVO.converterListCategoriaInsumoToListCategoriaInsumoVO(
						this.categoriaInsumoDAO.getListaCategoriaInsumos(), listaCategoriaInsumoVO);
			} else {
				ConverterCategoriaInsumoToCategoriaInsumoVO.converterListCategoriaInsumoToListCategoriaInsumoVO(
						this.categoriaInsumoDAO.getListaCategoriaInsumos(categoriaInsumoVO), listaCategoriaInsumoVO);
			}
		} catch (EntityManagerException e) {
			e.printStackTrace();
		}

		LOGGER.info("CategoriaInsumoBusiness.carregarCategoriaInsumo [FIM] - retorno=" + listaCategoriaInsumoVO);
		return listaCategoriaInsumoVO;
	}

	public void salvar(CategoriaInsumoVO categoriaInsumoVO) {
		CategoriaInsumo categoriaInsumo = new CategoriaInsumo();

		ConverterCategoriaInsumoToCategoriaInsumoVO.converterCategoriaInsumoVoToCategoriaInsumo(categoriaInsumoVO,
				/* 68 */ categoriaInsumo);
		try {
			this.categoriaInsumoDAO.salvar(categoriaInsumo);
		} catch (EntityManagerException e) {
			LOGGER.error("CategoriaInsumoBusiness.salvar - Ocorreu um erro ao salvar", e);
		}
	}

	public void excluir(CategoriaInsumoVO categoriaInsumoVO) {
		CategoriaInsumo categoriaInsumo = new CategoriaInsumo();

		ConverterCategoriaInsumoToCategoriaInsumoVO.converterCategoriaInsumoVoToCategoriaInsumo(categoriaInsumoVO,
				/* 88 */ categoriaInsumo);
		try {
			this.categoriaInsumoDAO.excluir(categoriaInsumo);
		} catch (EntityManagerException e) {
			LOGGER.error("CategoriaInsumoBusiness.salvar - Ocorreu um erro ao excluir", e);
		}
	}
}
