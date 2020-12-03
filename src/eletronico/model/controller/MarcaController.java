/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eletronico.model.controller;

import eletronico.model.dao.MarcaDao;
import eletronico.model.entidade.Marca;
import java.util.List;

/**
 *
 * @author edson
 */
public class MarcaController {
    
    public List<Marca> listar (String nome){
        MarcaDao dao = new MarcaDao();
        return dao.listar(nome);
    }
    
    public void cadastrarMarca (Marca obj){
        MarcaDao dao = new MarcaDao();
        dao.cadastrarMarca(obj);
    }
    
     public void alterarMarca (Marca obj){
        MarcaDao dao = new MarcaDao();
        dao.alterarMarca(obj);
    }
    
    public Marca Buscar (String id){
        MarcaDao dao = new MarcaDao();
        return dao.Buscar(id);
    }
    
     public void Excluir(String id){
        MarcaDao dao = new MarcaDao();
        dao.Excluir(id);
       } 
}
