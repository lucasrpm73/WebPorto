/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.container.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Lucas Santos
 */

@Entity
@Table(name = "container")
@PrimaryKeyJoinColumn(name = "idPessoa")
public class ContainerModel extends PessoaModel implements Serializable {
    
    
@Column(nullable = false, length = 80)
private String containerNumero;

@Column(nullable = false, length = 80)
private String containerTipo;
    

@Column(nullable = false, length = 80)
private String containerStatus;

@Column(nullable = false, length = 80)
private String containerCategoria;

    public String getContainerNumero() {
        return containerNumero;
    }

    public void setContainerNumero(String containerNumero) {
        this.containerNumero = containerNumero;
    }

    public String getContainerTipo() {
        return containerTipo;
    }

    public void setContainerTipo(String containerTipo) {
        this.containerTipo = containerTipo;
    }

    public String getContainerStatus() {
        return containerStatus;
    }

    public void setContainerStatus(String containerStatus) {
        this.containerStatus = containerStatus;
    }

    public String getContainerCategoria() {
        return containerCategoria;
    }

    public void setContainerCategoria(String containerCategoria) {
        this.containerCategoria = containerCategoria;
    }
    
    
    
    
    
    
}
