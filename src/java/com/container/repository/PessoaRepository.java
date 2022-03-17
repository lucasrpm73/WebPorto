/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.container.repository;

import com.container.util.HibernateConector;
import com.container.model.PessoaModel;
import java.util.List;
import javax.transaction.HeuristicMixedException;
import javax.transaction.RollbackException;


import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Lucas Santos
 */
public class PessoaRepository {
    
    private Session session;
    private Transaction transaction;
    
    
    
    public List<PessoaModel> buscar() throws RollbackException, HeuristicMixedException{
    this.session =   HibernateConector.getSessionFactory().openSession();
    this.transaction = session.beginTransaction();
    
    List<PessoaModel> listaDePessoas = this.session.createQuery("from PessoaModel").list();
    
        
    this.transaction.commit();
    this.session.close();

    return listaDePessoas;
 }
    
   public void  remover(long idPessoa){
    this.session = HibernateConector.getSessionFactory().openSession();
    this.transaction = session.beginTransaction();
    
    this.transaction.commit();
    this.session.close();
   }
   
   
    
}
