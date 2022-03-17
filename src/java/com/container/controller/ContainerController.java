/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.container.controller;

import com.container.model.ContainerModel;
import com.container.repository.ContainerRepository;
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
public class ContainerController {
    
    private ContainerModel containerModel;
    private ContainerRepository containerRepository;
    private List<ContainerModel> listaDeContainer;
    
    
  public ContainerController(){
      this.containerModel = new ContainerModel();
      this.containerRepository = new ContainerRepository();
      this.listaDeContainer = new ArrayList<>();
  }
    public String salvar(){
    this.containerRepository.salvar(this.containerModel);
    return "/view/container/buscarContainer.xhtml";
    }
    
    public String salvarEdicao(){
    this.containerRepository.salvar(this.containerModel);
    return "/view/container/buscarContainer.xhtml?faces-redirect=true";
    }
    
    public void remover(long idContainer){
    this.containerRepository.remover(idContainer);
    }
    
    public String editar(long idContainer){
    return "editarContainer.xhtml?faces-redirect=true&idContainer=" + idContainer;
    }
    
    public void buscarContainer() {
        this.containerModel = this.containerRepository.buscarPorId(this.containerModel.getIdPessoa());
    }
    public void getContainer() {
        this.containerModel = this.containerRepository.buscarPorId(this.containerModel.getIdPessoa());
    } 
    
   public List<SelectItem> getContainers() throws RollbackException, HeuristicMixedException{
       ArrayList<SelectItem> itens = new ArrayList<>();
       List<ContainerModel> listaDeContainers = this.containerRepository.buscarTodos();
       for(ContainerModel  container : listaDeContainers){
           itens.add(new SelectItem(container.getIdPessoa(), container.getPessoaNome()));
      }
   return itens;
   }
   
   public void buscarTodosContainers() throws RollbackException, HeuristicMixedException{
   this.listaDeContainer = this.containerRepository.buscarTodos();
   }

    public ContainerModel getContainerModel() {
        return containerModel;
    }

    public void setContainerModel(ContainerModel containerModel) {
        this.containerModel = containerModel;
    }

    public ContainerRepository getContainerRepository() {
        return containerRepository;
    }

    public void setContainerRepository(ContainerRepository containerRepository) {
        this.containerRepository = containerRepository;
    }

    public List<ContainerModel> getListaDeContainer() {
        return listaDeContainer;
    }

    public void setListaDeContainer(List<ContainerModel> listaDeContainer) {
        this.listaDeContainer = listaDeContainer;
    }
   
   
   
}
