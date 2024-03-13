
package Tarefa.model;


import java.sql.PreparedStatement;
import java.sql.ResultSet; // Importando a classe ResultSet
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class TarefaDAO {
    
    // Método para cadastrar um filme no banco de dados
    public static boolean cadastrar(Tarefa t) {
        try {
            // Conexão com o banco
            ConexaoJDBC conexao = new ConexaoJDBC();
            conexao.conectar();

            // SQL executado
            String sql = "INSERT INTO Tarefas(nome, dataCadastro, prioridade) VALUES(?, ?, ?)";
            PreparedStatement query = conexao.getConexao().prepareStatement(sql);
            query.setString(1, t.getNome());
            query.setString(2,t.getDatacadastro());
            query.setString(3, t.getPrioridade());

            query.executeUpdate(); // Usar executeUpdate() para INSERT, UPDATE, DELETE

            // Fechar recursos
            query.close();
            conexao.desconectar();
            
            return true; // Retorna true se a inserção for bem-sucedida
            
        } catch (SQLException se) {
            // Tratamento de exceção
            System.out.println("ERRO AO CADASTRAR NO BANCO DE DADOS !");
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Tarefa: " + se.getMessage(), "Erro de Banco de Dados", JOptionPane.ERROR_MESSAGE);
            return false; // Retorna false se ocorrer um erro
        }
    }
    
     public static List<Tarefa> listarTodos(){
        List<Tarefa> lista = new ArrayList<>();
        
        try {
            // Conexão com o banco
            ConexaoJDBC conexao = new ConexaoJDBC();
            conexao.conectar();
            
            // SQL executado
            String sql = "SELECT * FROM Tarefas";
            PreparedStatement query = conexao.getConexao().prepareStatement(sql);
            ResultSet rs = query.executeQuery();
            
            // Preenchendo a lista com os dados dos filmes
            while (rs.next()) {
                Tarefa tarefa = new Tarefa();
                tarefa.setId(rs.getInt("id"));
                tarefa.setNome(rs.getString("nome"));
                tarefa.setDatacadastro(rs.getString("dataCadastro"));
                tarefa.setPrioridade(rs.getString("prioridade"));
                lista.add(tarefa);
            }
            
            // Fechar recursos
            rs.close();
            query.close();
            conexao.desconectar();
            
        } catch (SQLException se) {
            // Tratamento de exceção
            System.out.println("ERRO AO LISTAR DO BANCO DE DADOS !");
            JOptionPane.showMessageDialog(null, "Erro ao listar Tarefas: " + se.getMessage(), "Erro de Banco de Dados", JOptionPane.ERROR_MESSAGE);
        }
        
        return lista;
    }
     
     public static boolean excluir (int id ) throws SQLException{
          try {
            // Conexão com o banco
            ConexaoJDBC conexao = new ConexaoJDBC();
            conexao.conectar();
            
            // SQL executado
            String sql = "DELETE FROM agenda WHERE id = ?;  ";
            PreparedStatement query = conexao.getConexao().prepareStatement(sql);
            query.setInt(1 , id);
            
            query.execute(); 
           
            conexao.desconectar();
            return true; 
            
        }catch(SQLException s ){
              System.out.println("ERRO AO DELETAR TAREFA");
              return false;
        }
     }
}
