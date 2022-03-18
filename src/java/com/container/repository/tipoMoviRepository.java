/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.container.repository;
import com.container.model.tipoMovi;
import com.container.util.HibernateConector;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Lucas Santos
 */
public class tipoMoviRepository {
    private Session session;
    private Transaction transaction;

    public List<tipoMovi> buscar(){
        this.session = HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        List<tipoMovi> listaDeTiposMovi = this.session.createQuery("from tipoMovi").list();
        
        this.transaction.commit();
        this.session.close();
        return listaDeTiposMovi;
    }

    public void salvar(tipoMovi tipoMovi) {
         this.session = HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        this.session.saveOrUpdate(tipoMovi);
        
        this.transaction.commit();
        this.session.close();
    }

    public void remover(long idTipoMovi) {
        this.session = HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        tipoMovi tipoMovi = (tipoMovi) this.session.get(tipoMovi.class, idTipoMovi);
        this.session.delete(tipoMovi);
        
        this.transaction.commit();
        this.session.close();
    }
    
    
     public List<tipoMovi> buscarTodos(){
        this.session = HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        List<tipoMovi> listaDeArea = this.session.createQuery("from tipoMovi").list();
        
        this.transaction.commit();
        this.session.close();
        return listaDeArea;
    }
    

    public tipoMovi buscarPorId(long idTipoMovi) {
          this.session = HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        tipoMovi movimentacao = (tipoMovi) this.session.get(tipoMovi.class, idTipoMovi);
        Hibernate.initialize(movimentacao.getIdTipoMovi());
        
        this.transaction.commit();
        this.session.close();
        return movimentacao;
    }
    
}
