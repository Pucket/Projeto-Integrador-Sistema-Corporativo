/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eletronico.model.controller;

import eletronico.model.dao.CategoriaDao;
import eletronico.model.entidade.Categoria;
import java.util.List;

/**
 *
 * @author suely
 */
public class CategoriaController {
    public List<Categoria> listar (String nome){
        CategoriaDao dao = new CategoriaDao();
        return dao.listar(nome);
    }
    
    public void cadastrarCategoria (Categoria obj){
        CategoriaDao dao = new CategoriaDao();
        dao.cadastrarCategoria(obj);
    }
    
     public void alterarCategoria (Categoria obj){
        CategoriaDao dao = new CategoriaDao();
        dao.alterarCategoria(obj);
    }
    
    public Categoria Buscar (String id){
        CategoriaDao dao = new CategoriaDao();
        return dao.Buscar(id);
    }
    
     public void Excluir(String id){
        CategoriaDao dao = new CategoriaDao();
        dao.Excluir(id);
       } 
    
}
