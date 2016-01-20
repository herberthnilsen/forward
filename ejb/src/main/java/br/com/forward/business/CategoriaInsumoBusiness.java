package br.com.forward.business;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.jboss.logging.Logger;

import br.com.forward.common.CategoriaInsumoVO;
import br.com.forward.converters.ConverterCategoriaInsumo;
import br.com.forward.dao.CategoriaInsumoDAO;
import br.com.forward.entity.CategoriaInsumo;
import br.com.forward.exception.EntityManagerException;
import br.com.forward.interfaces.business.CategoriaInsumoBusinessLocal;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class CategoriaInsumoBusiness extends GenericBusiness implements CategoriaInsumoBusinessLocal {
	 public static final Logger LOGGER = Logger.getLogger(CategoriaInsumoBusiness.class);
	private CategoriaInsumoDAO categoriaInsumoDAO;

	@PostConstruct
	public void init() {
		this.categoriaInsumoDAO = new CategoriaInsumoDAO(this.entityManager);
	}

	public List<CategoriaInsumoVO> carregarCategoriaInsumo(CategoriaInsumoVO categoriaInsumoVO) {
		LOGGER.info("CategoriaInsumoBusiness.carregarCategoriaInsumo [INICIO]");

		List<CategoriaInsumoVO> listaCategoriaInsumoVO = new ArrayList<CategoriaInsumoVO>();
		try {
			if ((categoriaInsumoVO.getCodigoCategoria() == null) && (categoriaInsumoVO.getNomeCategoria().isEmpty())
					&& (categoriaInsumoVO.getDescricaoCategoria().isEmpty())) {
				ConverterCategoriaInsumo.converterListCategoriaInsumoToListCategoriaInsumoVO(
						this.categoriaInsumoDAO.getListaCategoriaInsumos(), listaCategoriaInsumoVO);
			} else {
				ConverterCategoriaInsumo.converterListCategoriaInsumoToListCategoriaInsumoVO(
						this.categoriaInsumoDAO.getListaCategoriaInsumos(categoriaInsumoVO), listaCategoriaInsumoVO);
			}
		} catch (EntityManagerException e) {
			
			LOGGER.error("Ocorreu um erro ao buscar as categorias de insumo", e);
			
		}

		LOGGER.info("CategoriaInsumoBusiness.carregarCategoriaInsumo [FIM] - retorno=" + listaCategoriaInsumoVO);
		return listaCategoriaInsumoVO;
	}

	public void salvar(CategoriaInsumoVO categoriaInsumoVO) {
		CategoriaInsumo categoriaInsumo = new CategoriaInsumo();

		ConverterCategoriaInsumo.converterCategoriaInsumoVoToCategoriaInsumo(categoriaInsumoVO,
				 categoriaInsumo);
		try {
			this.categoriaInsumoDAO.salvar(categoriaInsumo);
		} catch (EntityManagerException e) {
			LOGGER.error("CategoriaInsumoBusiness.salvar - Ocorreu um erro ao salvar", e);
		}
	}

	public void excluir(CategoriaInsumoVO categoriaInsumoVO) {
		CategoriaInsumo categoriaInsumo = new CategoriaInsumo();

		ConverterCategoriaInsumo.converterCategoriaInsumoVoToCategoriaInsumo(categoriaInsumoVO,
				 categoriaInsumo);
		try {
			this.categoriaInsumoDAO.excluir(categoriaInsumo);
		} catch (EntityManagerException e) {
			LOGGER.error("CategoriaInsumoBusiness.salvar - Ocorreu um erro ao excluir", e);
		}
	}
}
