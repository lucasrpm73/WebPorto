/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.container.model;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "movimentacao")
public class MovimentacaoModel implements Serializable {
  
@Id
@GeneratedValue
    private long idMovimentacao;


@Column(nullable = false, length = 80)
private String movimentacaoTipo;

@Column(nullable = false, length = 80)
private String pessoa;
    

@Column(nullable = false, length = 80)
private Date dataHoraInicio;

@Column(nullable = false, length = 80)
private Date dataHoraFim;
   
    
}
