/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eletronico.model.controller;

import eletronico.model.dao.ProdutoDao;
import eletronico.model.entidade.Produto;
import java.util.List;

/**
 *
 * @author suely
 */
public class ProdutoController {
     public List<Produto> listarProduto (String nome){
        ProdutoDao dao = new ProdutoDao();
        return dao.listarProduto(nome);
    }
    
    public void cadastrarProduto (Produto obj){
         ProdutoDao dao = new  ProdutoDao();
        dao.cadastrarProduto(obj);
    }
    
     public void alterarProduto (Produto obj){
         ProdutoDao dao = new  ProdutoDao();
        dao.alterarProduto(obj);
    }
    
    public Produto BuscarProduto (String id){
         ProdutoDao dao = new  ProdutoDao();
        return dao.BuscarProduto(id);
    }
    
     public void ExcluirProduto(String id){
         ProdutoDao dao = new  ProdutoDao();
        dao.ExcluirProdutos(id);
       } 
}
