
package Tarefa.main;
import Tarefa.view.ListaTarefas;
import java.sql.SQLException;

public class Principal {
    
    public static void main(String[] args) throws SQLException {
        
        ListaTarefas lt = new ListaTarefas();
        lt.setVisible(true);  
       
    }

}
