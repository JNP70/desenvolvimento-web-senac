package com.github.braully.dws;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class SolicitacaoContato {

    @Id
    @GeneratedValue        
    Integer id;
    
    @Basic
    String nome;
    @Basic
    String email;
    @Basic
    String duvida;

    @Override
    public String toString() {
        return "SolicitacaoContato{" + "nome=" + nome + ", email=" + email + ", duvida=" + duvida + '}';
    }

}
