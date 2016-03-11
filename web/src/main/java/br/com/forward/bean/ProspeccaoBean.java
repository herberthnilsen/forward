/**
 * 
 */
package br.com.forward.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.forward.common.AtendimentoVO;
import br.com.forward.common.ParceiroVO;
import br.com.forward.common.PessoaVO;
import br.com.forward.common.ProspeccaoVO;
import br.com.forward.enumcode.FormaAtendimentoEnum;
import br.com.forward.enumcode.StatusMarketingEnum;
import br.com.forward.enumcode.StatusProspeccaoEnum;
import br.com.forward.enumcode.TipoEventoEnum;
import br.com.forward.interfaces.facade.ProspeccaoFacadeLocal;

/**
 * @author Herberth Nilsen
 */
@ViewScoped
@Named
public class ProspeccaoBean extends BasicBean {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo prospeccaoVO
	 */
	private ProspeccaoVO prospeccaoVO;

	/**
	 * Atributo atendimentoVO
	 */
	private AtendimentoVO atendimentoVO;

	/**
	 * Atributo listaProspeccoes
	 */
	private List<ProspeccaoVO> listaProspeccoes;

	/**
	 * Atributo listaAtendimentos
	 */
	private List<AtendimentoVO> listaAtendimentos;

	/**
	 * Atributo listaStatusMarketing
	 */
	private StatusMarketingEnum[] listaStatusMarketing = StatusMarketingEnum.values();
	/**
	 * Atributo listaStatusProspeccao
	 */
	private StatusProspeccaoEnum[] listaStatusProspeccao = StatusProspeccaoEnum.values();

	/**
	 * Atributo listaTipoEvento
	 */
	private TipoEventoEnum[] listaTipoEvento = TipoEventoEnum.values();

	/**
	 * Atributo listaFormaAtendimento
	 */
	private FormaAtendimentoEnum[] listaFormaAtendimento = FormaAtendimentoEnum.values();

	/**
	 * Atributo listaParceiro
	 */
	private List<ParceiroVO> listaParceiro;

	/**
	 * Atributo listaColaboradores
	 */
	private List<PessoaVO> listaColaboradores;

	@EJB
	private ProspeccaoFacadeLocal prospeccaoFacade;

	@PostConstruct
	public void init() {

		this.atendimentoVO = new AtendimentoVO();
		this.listaAtendimentos = new ArrayList<AtendimentoVO>();
		this.listaColaboradores = new ArrayList<PessoaVO>();

		this.listaParceiro = new ArrayList<ParceiroVO>();
		this.listaProspeccoes = new ArrayList<ProspeccaoVO>();
		this.prospeccaoVO = new ProspeccaoVO();

	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.bean.BasicBean#pesquisar()
	 */
	@Override
	public void pesquisar() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.bean.BasicBean#reset()
	 */
	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.bean.BasicBean#salvar()
	 */
	@Override
	public void salvar() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * @see br.com.forward.bean.BasicBean#excluir()
	 */
	@Override
	public void excluir() {
		// TODO Auto-generated method stub

	}

	private void carregarParceiros() {

		this.listaParceiro = this.prospeccaoFacade.carregarParceiros();
	}

	private void carregarColaboradores() {

		this.listaColaboradores = this.prospeccaoFacade.carregarColaboradores();

	}

	/**
	 * @return o valor do atributo prospeccaoVO
	 */
	public ProspeccaoVO getProspeccaoVO() {
		return this.prospeccaoVO;
	}

	/**
	 * @param prospeccaoVO o valor a ser atribuído no atributo prospeccaoVO
	 */
	public void setProspeccaoVO(ProspeccaoVO prospeccaoVO) {
		this.prospeccaoVO = prospeccaoVO;
	}

	/**
	 * @return o valor do atributo atendimentoVO
	 */
	public AtendimentoVO getAtendimentoVO() {
		return this.atendimentoVO;
	}

	/**
	 * @param atendimentoVO o valor a ser atribuído no atributo atendimentoVO
	 */
	public void setAtendimentoVO(AtendimentoVO atendimentoVO) {
		this.atendimentoVO = atendimentoVO;
	}

	/**
	 * @return o valor do atributo listaProspeccoes
	 */
	public List<ProspeccaoVO> getListaProspeccoes() {
		return this.listaProspeccoes;
	}

	/**
	 * @param listaProspeccoes o valor a ser atribuído no atributo listaProspeccoes
	 */
	public void setListaProspeccoes(List<ProspeccaoVO> listaProspeccoes) {
		this.listaProspeccoes = listaProspeccoes;
	}

	/**
	 * @return o valor do atributo listaAtendimentos
	 */
	public List<AtendimentoVO> getListaAtendimentos() {
		return this.listaAtendimentos;
	}

	/**
	 * @param listaAtendimentos o valor a ser atribuído no atributo listaAtendimentos
	 */
	public void setListaAtendimentos(List<AtendimentoVO> listaAtendimentos) {
		this.listaAtendimentos = listaAtendimentos;
	}

	/**
	 * @return o valor do atributo listaStatusMarketing
	 */
	public StatusMarketingEnum[] getListaStatusMarketing() {
		return this.listaStatusMarketing;
	}

	/**
	 * @param listaStatusMarketing o valor a ser atribuído no atributo listaStatusMarketing
	 */
	public void setListaStatusMarketing(StatusMarketingEnum[] listaStatusMarketing) {
		this.listaStatusMarketing = listaStatusMarketing;
	}

	/**
	 * @return o valor do atributo listaStatusProspeccao
	 */
	public StatusProspeccaoEnum[] getListaStatusProspeccao() {
		return this.listaStatusProspeccao;
	}

	/**
	 * @param listaStatusProspeccao o valor a ser atribuído no atributo listaStatusProspeccao
	 */
	public void setListaStatusProspeccao(StatusProspeccaoEnum[] listaStatusProspeccao) {
		this.listaStatusProspeccao = listaStatusProspeccao;
	}

	/**
	 * @return o valor do atributo listaTipoEvento
	 */
	public TipoEventoEnum[] getListaTipoEvento() {
		return this.listaTipoEvento;
	}

	/**
	 * @param listaTipoEvento o valor a ser atribuído no atributo listaTipoEvento
	 */
	public void setListaTipoEvento(TipoEventoEnum[] listaTipoEvento) {
		this.listaTipoEvento = listaTipoEvento;
	}

	/**
	 * @return o valor do atributo listaFormaAtendimento
	 */
	public FormaAtendimentoEnum[] getListaFormaAtendimento() {
		return this.listaFormaAtendimento;
	}

	/**
	 * @param listaFormaAtendimento o valor a ser atribuído no atributo listaFormaAtendimento
	 */
	public void setListaFormaAtendimento(FormaAtendimentoEnum[] listaFormaAtendimento) {
		this.listaFormaAtendimento = listaFormaAtendimento;
	}

	/**
	 * @return o valor do atributo listaParceiro
	 */
	public List<ParceiroVO> getListaParceiro() {
		return this.listaParceiro;
	}

	/**
	 * @param listaParceiro o valor a ser atribuído no atributo listaParceiro
	 */
	public void setListaParceiro(List<ParceiroVO> listaParceiro) {
		this.listaParceiro = listaParceiro;
	}

	/**
	 * @return o valor do atributo listaColaboradores
	 */
	public List<PessoaVO> getListaColaboradores() {
		return this.listaColaboradores;
	}

	/**
	 * @param listaColaboradores o valor a ser atribuído no atributo listaColaboradores
	 */
	public void setListaColaboradores(List<PessoaVO> listaColaboradores) {
		this.listaColaboradores = listaColaboradores;
	}

}
