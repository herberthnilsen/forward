package br.com.forward.insumos.bean;

import br.com.forward.common.CategoriaInsumoVO;
import br.com.forward.interfaces.facade.CategoriaInsumoFacadeLocal;
import br.com.forward.util.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ViewScoped
@Named
public class CategoriaInsumoBean extends BasicBean {
	private static final long serialVersionUID = 10150539659042223L;
	public static final Logger LOGGER = Logger.getLogger("CategoriaInsumoBean.class");

	private List<CategoriaInsumoVO> resultList = new ArrayList();

	private CategoriaInsumoVO categoriaVO = new CategoriaInsumoVO();

	@Inject
	private CategoriaInsumoFacadeLocal categoriaInsumoFacade;

	@PostConstruct
	public void init() {
		LOGGER.info("CategoriaInsumoBean.init - INICIO");

		if (Utils.isEmpty(this.resultList)) {
			pesquisar();
		}

		LOGGER.info("CategoriaInsumoBean.init - FIM");
	}

	public void pesquisar() {
		LOGGER.info("CategoriaInsumoBean.pesquisar - INICIO");
		this.resultList = this.categoriaInsumoFacade.carregarCategoriaInsumos(this.categoriaVO);
		LOGGER.info("CategoriaInsumoBean.pesquisar - FIM");
	}

	public void salvar() {
		LOGGER.info("CategoriaInsumoBean.salvar - INICIO = " + this.categoriaVO);
		this.categoriaInsumoFacade.salvar(this.categoriaVO);
		pesquisar();
		reset();
		hideForm();
		LOGGER.info("CategoriaInsumoBean.salvar - FIM");
	}

	public void excluir() {
		LOGGER.info("CategoriaInsumoBean.excluir - INICIO = " + this.categoriaVO);
		hideForm();
		this.categoriaInsumoFacade.excluir(this.categoriaVO);
		reset();
		pesquisar();
		LOGGER.info("CategoriaInsumoBean.excluir - FIM= " + this.categoriaVO);
	}

	public void showForm() {
		reset();
		super.showForm();
	}

	public void reset() {
		this.categoriaVO = new CategoriaInsumoVO();
	}

	public String ordenarPorNome() {
		return null;
	}

	public void ordernarPorDescricao() {
	}

	public List<CategoriaInsumoVO> getResultList() {
		return this.resultList;
	}

	public void setResultList(List<CategoriaInsumoVO> resultList) {
		this.resultList = resultList;
	}

	public CategoriaInsumoVO getCategoriaVO() {
		return this.categoriaVO;
	}

	public void setCategoriaVO(CategoriaInsumoVO categoriaVO) {
		this.categoriaVO = categoriaVO;
	}
}
