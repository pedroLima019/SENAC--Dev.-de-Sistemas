
package cineflix.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet; // Importando a classe ResultSet
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FilmeDAO {
    
    // Método para cadastrar um filme no banco de dados
    public static boolean cadastrar(Filme f) {
        try {
            // Conexão com o banco
            ConexaoJDBC conexao = new ConexaoJDBC();
            conexao.conectar();

            // SQL executado
            String sql = "INSERT INTO filmes(nome, dataLancamento, categoria) VALUES(?, ?, ?)";
            PreparedStatement query = conexao.getConexao().prepareStatement(sql);
            query.setString(1, f.getNome());
            query.setString(2, f.getDataLancamento());
            query.setString(3, f.getCategoria());

            query.executeUpdate(); // Usar executeUpdate() para INSERT, UPDATE, DELETE

            // Fechar recursos
            query.close();
            conexao.desconectar();
            
            return true; // Retorna true se a inserção for bem-sucedida
            
        } catch (SQLException se) {
            // Tratamento de exceção
            System.out.println("ERRO AO CADASTRAR NO BANCO DE DADOS !");
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar filme: " + se.getMessage(), "Erro de Banco de Dados", JOptionPane.ERROR_MESSAGE);
            return false; // Retorna false se ocorrer um erro
        }
    }
    
     public static List<Filme> listarTodos(){
        List<Filme> lista = new ArrayList<>();
        
        try {
            // Conexão com o banco
            ConexaoJDBC conexao = new ConexaoJDBC();
            conexao.conectar();
            
            // SQL executado
            String sql = "SELECT * FROM filmes";
            PreparedStatement query = conexao.getConexao().prepareStatement(sql);
            ResultSet rs = query.executeQuery();
            
            // Preenchendo a lista com os dados dos filmes
            while (rs.next()) {
                Filme filme = new Filme();
                filme.setId(rs.getInt("id"));
                filme.setNome(rs.getString("nome"));
                filme.setDataLancamento(rs.getString("dataLancamento"));
                filme.setCategoria(rs.getString("categoria"));
                lista.add(filme);
            }
            
            // Fechar recursos
            rs.close();
            query.close();
            conexao.desconectar();
            
        } catch (SQLException se) {
            // Tratamento de exceção
            System.out.println("ERRO AO LISTAR DO BANCO DE DADOS !");
            JOptionPane.showMessageDialog(null, "Erro ao listar filmes: " + se.getMessage(), "Erro de Banco de Dados", JOptionPane.ERROR_MESSAGE);
        }
        
        return lista;
    }
     
     public static boolean excluir (int id ) throws SQLException{
          try {
            // Conexão com o banco
            ConexaoJDBC conexao = new ConexaoJDBC();
            conexao.conectar();
            
            // SQL executado
            String sql = "DELETE FROM filmes WHERE id = ?;  ";
            PreparedStatement query = conexao.getConexao().prepareStatement(sql);
            query.setInt(1 , id);
            
            query.execute(); 
           
            conexao.desconectar();
            return true; 
            
        }catch(SQLException s ){
              System.out.println("ERRO AO DELETAR FILME");
              return false;
        }
     }
}
