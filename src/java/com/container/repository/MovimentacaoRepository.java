/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.container.repository;

import com.container.model.ContainerModel;
import com.container.model.MovimentacaoModel;
import com.container.util.HibernateConector;
import java.util.List;
import javax.transaction.HeuristicMixedException;
import javax.transaction.RollbackException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Lucas Santos
 */
public class MovimentacaoRepository {
    
    private Session session;
    private Transaction transaction;
    
    
    
    
    public void salvar(MovimentacaoModel movimentacao){
        this.session =   HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();  
        
        this.session.saveOrUpdate(movimentacao);
        
        this.transaction.commit();
        this.session.close();

        
    }
    
    public List<MovimentacaoModel> buscarTodos() throws RollbackException, HeuristicMixedException{
        this.session =   HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();

        List<MovimentacaoModel> listaDeContainers = this.session.createQuery("from MovimentacaoModel").list();


        this.transaction.commit();
        this.session.close();

        return listaDeContainers;
 }
    
    public MovimentacaoModel buscarPorId(long idMovimentacao){
        this.session =   HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        MovimentacaoModel movimentacao;
        
        movimentacao = (MovimentacaoModel) this.session.get(MovimentacaoModel.class, idMovimentacao);
    
        this.transaction.commit();
        this.session.close();
        
        return movimentacao;
    }
    
    
   public void  remover(long idMovimentacao){
        this.session = HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();

        this.transaction.commit();
        this.session.close();
    }
   
   
   public List<MovimentacaoModel> buscarOrdenarCliente(){
       this.session = HibernateConector.getSessionFactory().openSession();
       this.transaction = session.beginTransaction();
       
       
       String nome = null;
       
       if(nome != null){
       
           Query query = session.createQuery("from MovimentacaoModel Where pessoa = :pessoa");
           query.setParameter("pessoa", nome);
           
           List<MovimentacaoModel> listaDeMovimentacao = query.list();
           
            this.transaction.commit();
            this.session.close();
       
       return listaDeMovimentacao;
       }else{  
           Query query = session.createQuery("from MovimentacaoModel order by pessoa");
          List<MovimentacaoModel> listaDeMovimentacao = query.list();
       
       return listaDeMovimentacao;
       
       }
   
   
   }
   
   
    
}
