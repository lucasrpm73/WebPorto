/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.container.repository;

import com.container.model.TipoMovi;
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
public class TipoMoviRepository {
    
    private Session session;
    private Transaction transaction;
    
    
    
    
    public void salvar(TipoMovi tipoMovi){
        this.session =   HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();  
        
        this.session.saveOrUpdate(tipoMovi);
        
        this.transaction.commit();
        this.session.close();

        
    }
    
    public List<TipoMovi> buscarTodos() throws RollbackException, HeuristicMixedException{
        this.session =   HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();

        List<TipoMovi> listaDeContainers = this.session.createQuery("from TipoMovi").list();


        this.transaction.commit();
        this.session.close();

        return listaDeContainers;
 }
    
    public TipoMovi buscarPorId(long idTipoMovi){
        this.session =   HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        TipoMovi tipoMovi;
        
        tipoMovi = (TipoMovi) this.session.get(TipoMovi.class, idTipoMovi);
    
        this.transaction.commit();
        this.session.close();
        
        return tipoMovi;
    }
    
    
    
   public void  remover(long idTipoMovi){
        this.session = HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();

        this.transaction.commit();
        this.session.close();
    }
   
   public List<TipoMovi> buscar(){
        this.session = HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        List<TipoMovi> listaDeTiposMovi = this.session.createQuery("from TipoMovi").list();
        
        this.transaction.commit();
        this.session.close();
        return listaDeTiposMovi;
    }
}
