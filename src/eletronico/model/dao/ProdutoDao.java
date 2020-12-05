
package eletronico.model.dao;

import eletronico.model.entidade.Categoria;
import eletronico.model.entidade.Marca;
import eletronico.model.entidade.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ProdutoDao {
    public List<Produto> listarProduto(String nome){
        List<Produto> lista = new ArrayList<Produto>();
        
        try{
            Class
           .forName("com.mysql.jdbc.Driver");
            Connection con = 
              DriverManager
                .getConnection
                ("jdbc:mysql://localhost:3306/produtos_eletronicos", 
                 "root", "");
            String sql = " SELECT p.*, c.nome as nomeCategoria, m.nome as nomeMarca " + 
                            " FROM produtos p " +
                            " left join categoria c on p.cod_categoria = c.codCategoria " +
                            " left join marca m on p.cod_marca = m.codMarca " +
                            "where p.nome like ? "   + 
                            "order by p.nome";
            
            PreparedStatement ps = 
                con.prepareStatement(sql);
            ps.setString(1, 
                   "%" + nome +
                   "%");
            ResultSet rs = ps.executeQuery();
            
            
            
            Produto p = null;
            while(rs.next()){
                p = new Produto();
                p.setCodProduto(rs.getInt("codProduto"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidade(rs.getInt("quantidade"));
                
                Categoria c = new Categoria();

                c.setCodCategoria(rs.getInt("cod_categoria"));
                c.setNome(rs.getString("nomeCategoria"));

                p.setCategoria(c);
              
                Marca m = new Marca();
                
                m.setCodMarca(rs.getInt("cod_marca"));
                m.setNome(rs.getString("nomeMarca"));
                
                p.setMarca(m);

                lista.add(p);
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
    
     public void cadastrarProduto(Produto obj){
         
         try {
             
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/produtos_eletronicos" , "root" , "");
        
        String sql  = "insert into produtos " + "(nome, preco, quantidade, cod_categoria, cod_marca)  values" + "(?)";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, obj.getNome());
        ps.setDouble(2, obj.getPreco());
        ps.setInt(3, obj.getQuantidade());
        ps.setInt(4, obj.getCategoria().getCodCategoria());
        ps.setInt(5, obj.getMarca().getCodMarca());
        ps.execute();
        ps.close();
             
         } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
        e.printStackTrace();
         }  
     }
     
      public void alterarProduto(Produto obj){
         try {
         Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/produtos_eletronicos" , "root" , "");
        
        String sql = "update produtos " + "set nome = ? , preco = ? , quantidade = ? , cod_categoria = ? , cod_marca = ? "
                   + " where codProduto = ? ";
           
           PreparedStatement ps = con.prepareStatement(sql);
           
            ps.setString(1, obj.getNome());
            ps.setDouble(2, obj.getPreco());
            ps.setInt(3, obj.getQuantidade());
            ps.setInt(4, obj.getCategoria().getCodCategoria());
            ps.setInt(5, obj.getMarca().getCodMarca());
            ps.setInt(6, obj.getCodProduto());
            
            ps.execute();
            
             
         } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
        e.printStackTrace();
         }
     }
      
     public Produto BuscarProduto(String id){
          Produto p = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/produtos_eletronicos" , "root" , "");
            
            String sql = " SELECT p.*, c.nome as nomeCategoria, m.nome as nomeMarca " + 
                            " FROM produtos p " +
                            " left join categoria c on p.cod_categoria = c.codCategoria " +
                            " left join marca m on p.cod_marca = m.codMarca " +
                             "where codProduto = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            
            if(rs.next()){
                p = new Produto();
                p.setCodProduto(rs.getInt("codProduto"));
                p.setNome(rs.getString("nome"));
                 p.setPreco(rs.getDouble("preco"));
                p.setQuantidade(rs.getInt("quantidade"));
                
                Categoria c = new Categoria();

                c.setCodCategoria(rs.getInt("cod_categoria"));
                c.setNome(rs.getString("nomeCategoria"));

                p.setCategoria(c);
              
                Marca m = new Marca();
                
                m.setCodMarca(rs.getInt("cod_marca"));
                m.setNome(rs.getString("nomeMarca"));
                
                p.setMarca(m);
                
                
            }  
        } catch (Exception e){
            e.printStackTrace ();
        }
          return p;
     }  
     
     public void ExcluirProdutos(String id){
        
          try{
              Class.forName("com.mysql.jdbc.Driver");
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/produtos_eletronicos" , "root" , "");
              String sql = "delete from produtos " + "where codProduto = ?";
              PreparedStatement ps = con.prepareStatement(sql);
              ps.setString(1, id);
              ps.execute();
              
              
          } catch(Exception e) {
              e.printStackTrace(); 
          }
          
          
     }
}
