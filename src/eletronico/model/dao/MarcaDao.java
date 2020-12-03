/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eletronico.model.dao;

import eletronico.model.entidade.Marca;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author suely
 */
public class MarcaDao {
    public List<Marca> listar(String nome){
        List<Marca> lista = new ArrayList<Marca>();
        
        try{
            Class
           .forName("com.mysql.jdbc.Driver");
            Connection con = 
              DriverManager
                .getConnection
                ("jdbc:mysql://localhost:3306/produtos_eletronicos", 
                 "root", "");
            String sql = "select * "
                + "from marca "
                + "where nome like ? "    
                + "order by nome";
            
            PreparedStatement ps = 
                con.prepareStatement(sql);
            ps.setString(1, 
                   "%" + nome +
                   "%");
            ResultSet rs = ps.executeQuery();
            
            Marca m = null;
            while(rs.next()){
                m = new Marca();
                m.setCodMarca(rs.getInt("codMarca"));
                m.setNome(rs.getString("nome"));

                lista.add(m);
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
     
      public List<Marca> listarMarca(String nome){
        List<Marca> lista = new ArrayList<Marca>();
        
        try{
            Class
           .forName("com.mysql.jdbc.Driver");
            Connection con = 
              DriverManager
                .getConnection
                ("jdbc:mysql://localhost:3306/produtos_eletronicos", 
                 "root", "");
            String sql = "select * "
                + "from marca "
                + "where nome like ? "    
                + "order by nome";
            
            PreparedStatement ps = 
                con.prepareStatement(sql);
            ps.setString(1, 
                   "%" + nome +
                   "%");
            ResultSet rs = ps.executeQuery();
            
            Marca m = null;
            while(rs.next()){
                m = new Marca();
                m.setCodMarca(rs.getInt("codMarca"));
                m.setNome(rs.getString("nome"));

                lista.add(m);
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
      
    public void cadastrarMarca(Marca obj){
         
         try {
             
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/produtos_eletronicos" , "root" , "");
        
        String sql  = "insert into marca " + "(nome) values" + "(?)";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, obj.getNome());
        ps.execute();
        ps.close();
             
         } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
        e.printStackTrace();
         }  
     }
     
    
     
     public void alterarMarca(Marca obj){
         try {
         Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/produtos_eletronicos" , "root" , "");
        
        String sql = "update marca " + "set nome = ? "
                   + " where codMarca = ? ";
           
           PreparedStatement ps = con.prepareStatement(sql);
           
            ps.setString(1, obj.getNome());
            ps.setInt(2, obj.getCodMarca());
            
            ps.execute();
            
             
         } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
        e.printStackTrace();
         }
     }
     
     public Marca Buscar(String id){
          Marca m = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/produtos_eletronicos" , "root" , "");
            
            String sql = "select * " + "from marca " + "where codMarca = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            
            if(rs.next()){
                m = new Marca();
                m.setCodMarca(rs.getInt("codMarca"));
                m.setNome(rs.getString("nome"));
                
            }  
        } catch (Exception e){
            e.printStackTrace ();
        }
          return m;
     }
   
     public void Excluir(String id){
        
          try{
              Class.forName("com.mysql.jdbc.Driver");
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/produtos_eletronicos" , "root" , "");
              String sql = "delete from marca " + "where codMarca = ?";
              PreparedStatement ps = con.prepareStatement(sql);
              ps.setString(1, id);
              ps.execute();
              
              
          } catch(Exception e) {
              e.printStackTrace(); 
          }
          
          
     }
     
     
    
    
}
