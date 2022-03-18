/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.container.controller;

import com.container.model.MovimentacaoModel;
import com.container.model.PessoaModel;
import com.container.model.tipoMovi;
import com.container.repository.MovimentacaoRepository;
import com.container.repository.PessoaRepository;
import com.container.repository.tipoMoviRepository;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.transaction.HeuristicMixedException;
import javax.transaction.RollbackException;

/**
 *
 * @author Lucas Santos
 */

@ManagedBean
@ViewScoped
public class MovimentacaoController {
    
    private MovimentacaoModel movimentacaoModel;
    private MovimentacaoRepository movimentacaoRepository;
    private tipoMoviRepository tipoMoviRepository;
    private PessoaRepository pessoaRepository;
    private PessoaModel pessoaModel;
    private String pessoa;
    private List<MovimentacaoModel> listaDeMovimentacao;
    
    public MovimentacaoController() {
        this.movimentacaoModel = new MovimentacaoModel();
        this.movimentacaoRepository = new MovimentacaoRepository();
        this.tipoMoviRepository = new tipoMoviRepository();
        this.pessoaRepository = new PessoaRepository();
        this.listaDeMovimentacao = new ArrayList<>();
    }
    
    
    
    public String salvar(){
    this.movimentacaoRepository.salvar(this.movimentacaoModel);
    return "/view/container/buscarContainer.xhtml";
    }
    
    public String salvarEdicao(){
    this.movimentacaoRepository.salvar(this.movimentacaoModel);
    return "/view/movimentacao/buscarMovimentacao.xhtml?faces-redirect=true";
    }
    
    public void remover(long idMovimentacao){
    this.movimentacaoRepository.remover(idMovimentacao);
    }
    
    public String editar(long idMovimentacao){
    return "editarMovimentacao.xhtml?faces-redirect=true&idMovimentacaor=" + idMovimentacao;
    }
    public void buscarMovimentacao() {
        this.movimentacaoModel = this.movimentacaoRepository.buscarPorId(this.movimentacaoModel.getIdMovimentacao());
    }
    public void getMovimentacao() {
        this.movimentacaoModel = this.movimentacaoRepository.buscarPorId(this.movimentacaoModel.getIdMovimentacao());
    }

    
     public List<SelectItem> getTiposMovis() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        List<tipoMovi> listaDeTipo = this.tipoMoviRepository.buscar();
        for (tipoMovi tipo : listaDeTipo) {
            itens.add(new SelectItem(tipo.getTipoMovi(), tipo.getTipoMovi()));
        }
        return itens;
    }
     
     public void setPessoas(String pessoa) {
         this.pessoa = pessoa;
    }
     public List<SelectItem> getPessoas() throws RollbackException, HeuristicMixedException {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        List<PessoaModel> listaDePessoas = this.pessoaRepository.buscar();
        for (PessoaModel pessoa : listaDePessoas) {
            itens.add(new SelectItem(pessoa.getPessoaNome()));
        }
        return itens;
    }
          

     
    public List<SelectItem> getMovimentacoes() throws RollbackException, HeuristicMixedException {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        List<MovimentacaoModel> listaDeMovimentacoes = this.movimentacaoRepository.buscarTodos();
        for (MovimentacaoModel movimentacao : listaDeMovimentacoes) {
            itens.add(new SelectItem(movimentacao.getIdMovimentacao(), movimentacao.getMovimentacaoTipo()));
        }
        return itens;
    }
    
    public void buscarTodosMovimentacoes() throws RollbackException, HeuristicMixedException {
        this.listaDeMovimentacao = this.movimentacaoRepository.buscarTodos();
        
    }
    public void buscarPorCliente() {
        this.listaDeMovimentacao = this.movimentacaoRepository.buscarOrdenarCliente();
        
    }

    public MovimentacaoModel getMovimentacaoModel() {
        return movimentacaoModel;
    }

    public void setMovimentacaoModel(MovimentacaoModel movimentacaoModel) {
        this.movimentacaoModel = movimentacaoModel;
    }

    public MovimentacaoRepository getMovimentacaoRepository() {
        return movimentacaoRepository;
    }

    public void setMovimentacaoRepository(MovimentacaoRepository movimentacaoRepository) {
        this.movimentacaoRepository = movimentacaoRepository;
    }

    public List<MovimentacaoModel> getListaDeMovimentacao() {
        return listaDeMovimentacao;
    }

    public void setListaDeMovimentacao(List<MovimentacaoModel> listaDeMovimentacao) {
        this.listaDeMovimentacao = listaDeMovimentacao;
    }
}
