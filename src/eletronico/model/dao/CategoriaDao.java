/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eletronico.model.dao;

import eletronico.model.entidade.Categoria;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author luani
 */
public class CategoriaDao {
    public List<Categoria> listar(String nome){
        List<Categoria> lista = new ArrayList<Categoria>();
        
        try{
            Class
           .forName("com.mysql.jdbc.Driver");
            Connection con = 
              DriverManager
                .getConnection
                ("jdbc:mysql://localhost:3306/produtos_eletronicos", 
                 "root", "");
            String sql = "select * "
                + "from categoria "
                + "where nome like ? "    
                + "order by nome";
            
            PreparedStatement ps = 
                con.prepareStatement(sql);
            ps.setString(1, 
                   "%" + nome +
                   "%");
            ResultSet rs = ps.executeQuery();
            
            Categoria c = null;
            while(rs.next()){
                c = new Categoria();
                c.setCodCategoria(rs.getInt("codCategoria"));
                c.setNome(rs.getString("nome"));

                lista.add(c);
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
    
public void cadastrarCategoria(Categoria obj){
        
    try {
             
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/produtos_eletronicos" , "root" , "");
        
        String sql  = "insert into categoria " + "(nome) values" + "(?)";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, obj.getNome());
        ps.execute();
        ps.close();
             
         } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
        e.printStackTrace();
         }
    }
    
public void alterarCategoria(Categoria obj){
         try {
         Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/produtos_eletronicos" , "root" , "");
        
        String sql = "update categoria " + "set nome = ? "
                   + " where codCategoria = ? ";
           
           PreparedStatement ps = con.prepareStatement(sql);
           
            ps.setString(1, obj.getNome());
            ps.setInt(2, obj.getCodCategoria());
            
            ps.execute();
            
             
         } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
        e.printStackTrace();
         }
    }



public Categoria Buscar(String id){
          Categoria c = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/produtos_eletronicos" , "root" , "");
            
            String sql = "select * " + "from categoria " + "where codCategoria = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            
            if(rs.next()){
                c = new Categoria();
                c.setCodCategoria(rs.getInt("codCategoria"));
                c.setNome(rs.getString("nome"));
                
            }  
        } catch (Exception e){
            e.printStackTrace ();
        }
          return c;
     }
    

public void Excluir(String id){
        
        try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/produtos_eletronicos" , "root" , "");
              
           String sql = "delete from categoria " + "where codCategoria = ?";
              
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1, id);
           
           ps.execute();
              
              
            } catch(Exception e) {
              e.printStackTrace(); 
          }
          
          
     }

}
