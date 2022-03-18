/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.container.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Lucas Santos
 */
@Entity
@Table(name = "tipoMovi")
public class tipoMovi implements Serializable {
    @Id
    @GeneratedValue
    private long idTipoMovi;
    
    @Column(nullable = false, length = 80, name = "nome")
    private String tipoMovi;

    public long getIdTipoMovi() {
        return idTipoMovi;
    }

    public void setIdTipoMovi(long idTipoMovi) {
        this.idTipoMovi = idTipoMovi;
    }

    public String getTipoMovi() {
        return tipoMovi;
    }

    public void setTipoMovi(String tipoMovi) {
        this.tipoMovi = tipoMovi;
    }
    
}
