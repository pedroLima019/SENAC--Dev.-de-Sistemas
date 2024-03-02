
package cineflix.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
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
}
