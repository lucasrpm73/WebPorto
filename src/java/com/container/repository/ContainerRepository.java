/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.container.repository;

import com.container.model.ContainerModel;
import com.container.util.HibernateConector;
import java.util.List;
import javax.transaction.HeuristicMixedException;
import javax.transaction.RollbackException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Lucas Santos
 */
public class ContainerRepository {
    
    private Session session;
    private Transaction transaction;
    
    
    
    
    public void salvar(ContainerModel container){
        this.session =   HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();  
        
        this.session.saveOrUpdate(container);
        
        this.transaction.commit();
        this.session.close();

        
    }
    
    public List<ContainerModel> buscarTodos() throws RollbackException, HeuristicMixedException{
        this.session =   HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();

        List<ContainerModel> listaDeContainers = this.session.createQuery("from ContainerModel").list();


        this.transaction.commit();
        this.session.close();

        return listaDeContainers;
 }
    
    public ContainerModel buscarPorId(long idContainer){
        this.session =   HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        ContainerModel container;
        
        container = (ContainerModel) this.session.get(ContainerModel.class, idContainer);
    
        this.transaction.commit();
        this.session.close();
        
        return container;
    }
    
    
    
   public void  remover(long idContainer){
        this.session = HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        ContainerModel container =(ContainerModel) this.session.get(ContainerModel.class, idContainer);
        this.session.delete(container);
        this.transaction.commit();
        this.session.close();
    }
   
   
   
}
