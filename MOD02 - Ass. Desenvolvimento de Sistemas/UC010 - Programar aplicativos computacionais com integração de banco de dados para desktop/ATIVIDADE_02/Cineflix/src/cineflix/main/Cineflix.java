
package cineflix.main;

import cineflix.model.Filme;
import cineflix.model.FilmeDAO;
import cineflix.view.CadastroFilme;
import cineflix.view.ListaFilmes;
import java.sql.SQLException;

public class Cineflix {
    
    public static void main(String[] args) throws SQLException {
        
        ListaFilmes lf = new ListaFilmes();
        lf.setVisible(true);  
       
    }
    
    
}
