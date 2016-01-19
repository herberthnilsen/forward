package br.com.forward.facade;

import br.com.forward.common.CategoriaInsumoVO;
import br.com.forward.interfaces.business.CategoriaInsumoBusinessLocal;
import br.com.forward.interfaces.facade.CategoriaInsumoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class CategoriaInsumoFacade implements CategoriaInsumoFacadeLocal {
	public static final Logger LOGGER = LogManager.getLogger(CategoriaInsumoFacade.class);

	@EJB
	private CategoriaInsumoBusinessLocal categoriaInsumoBusiness;

	public List<CategoriaInsumoVO> carregarCategoriaInsumos(CategoriaInsumoVO categoriaInsumoVO) {
		LOGGER.info("CategoriaInsumoBusiness.carregarCategoriaInsumo [INICIO]");

		List<CategoriaInsumoVO> carregarCategoriaInsumo = this.categoriaInsumoBusiness.carregarCategoriaInsumo(categoriaInsumoVO);

		LOGGER.info("CategoriaInsumoBusiness.carregarCategoriaInsumo [FIM]");
		return carregarCategoriaInsumo;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salvar(CategoriaInsumoVO categoriaVO) {
		this.categoriaInsumoBusiness.salvar(categoriaVO);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void excluir(CategoriaInsumoVO categoriaVO) {
		this.categoriaInsumoBusiness.excluir(categoriaVO);
	}
}
