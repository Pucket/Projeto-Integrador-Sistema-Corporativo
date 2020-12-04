/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eletronico;

/**
 *
 * @author suely
 */
public class ComboItem {
    
    private String id;
    
    private String nome;

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ComboItem(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    
    
}
