package br.com.forward.insumos.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.apache.log4j.Logger;

import br.com.forward.common.CategoriaInsumoVO;
import br.com.forward.common.InsumoVO;
import br.com.forward.common.UnidadeVO;
import br.com.forward.exception.InsumoException;
import br.com.forward.interfaces.facade.CategoriaInsumoFacadeLocal;
import br.com.forward.interfaces.facade.InsumoFacadeLocal;
import br.com.forward.interfaces.facade.UnidadeFacadeLocal;

@ViewScoped
@Named
public class InsumoBean extends BasicBean {

	private static final long serialVersionUID = 5575143542410735935L;
	public static final Logger LOGGER = Logger.getLogger("InsumoBean.class");

	private InsumoVO insumoVO = new InsumoVO();

	private List<CategoriaInsumoVO> listaCategoriaInsumo;
	
	private List<InsumoVO> resultList = new ArrayList<InsumoVO>();
	
	private List<UnidadeVO> listaUnidades;

	@EJB
	private InsumoFacadeLocal insumoFacadeLocal;
	
	@EJB
	private CategoriaInsumoFacadeLocal categoriaLocal;
	
	@EJB
	private UnidadeFacadeLocal unidadeLocal;

	@PostConstruct
	public void init() {
		LOGGER.info("InsumoBean.init - INICIO");

		this.pesquisar();
		LOGGER.info("InsumoBean.init - FIM");
	}

	public List<CategoriaInsumoVO> getListaCategoriaInsumo() {
		
		if(this.listaCategoriaInsumo == null || this.listaCategoriaInsumo.isEmpty()){
			
			this.listaCategoriaInsumo = this.categoriaLocal.carregarCategoriaInsumos();
			
		}
		
		return this.listaCategoriaInsumo;
	}

	public void setListaCategoriaInsumo(List<CategoriaInsumoVO> listaCategoriaInsumo) {
		this.listaCategoriaInsumo = listaCategoriaInsumo;
	}

	public List<UnidadeVO> getListaUnidades() {
		if(this.listaUnidades == null){
			
			this.listaUnidades = this.unidadeLocal.carregarUnidades();
			
		}
		
		return this.listaUnidades;
	}

	public void setListaUnidades(List<UnidadeVO> listaUnidades) {
		this.listaUnidades = listaUnidades;
	}

	public InsumoVO getInsumoVO() {
		return insumoVO;
	}

	public void setInsumoVO(InsumoVO insumoVO) {
		this.insumoVO = insumoVO;
		// teste
	}

	public List<InsumoVO> getResultList() {
		return resultList;
	}

	public void setResultList(List<InsumoVO> resultList) {
		this.resultList = resultList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.forward.insumos.bean.BasicBean#pesquisar()
	 */
	@Override
	public void pesquisar() {
		LOGGER.info("InsumoBean.pesquisar - INICIO = " + this.insumoVO);
		
		this.resultList = this.insumoFacadeLocal.carregarInsumos(this.insumoVO);
		
		LOGGER.info("InsumoBean.pesquisar - FIM = " + this.insumoVO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.forward.insumos.bean.BasicBean#salvar()
	 */
	@Override
	public void salvar() {
		LOGGER.info("InsumoBean.salvar - INICIO = " + this.insumoVO);
		try {
			this.insumoFacadeLocal.salvar(this.insumoVO);
			this.reset();
			this.pesquisar();
			this.hideForm();
		} catch (InsumoException e) {

			//TODO Gerar mensagem no Modal
		}
		
		
		LOGGER.info("InsumoBean.salvar - FIM = " + this.insumoVO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.forward.insumos.bean.BasicBean#excluir()
	 */
	@Override
	public void excluir() {
		LOGGER.info("InsumoBean.excluir - INICIO = " + this.insumoVO);

		LOGGER.info("InsumoBean.excluir - FIM = " + this.insumoVO);
	}

	/* (non-Javadoc)
	 * @see br.com.forward.insumos.bean.BasicBean#reset()
	 */
	@Override
	public void reset() {
		LOGGER.info("InsumoBean.reset - INICIO = " + this.insumoVO);

		this.insumoVO = new InsumoVO();

		LOGGER.info("InsumoBean.reset - FIM");
		
	}

}
