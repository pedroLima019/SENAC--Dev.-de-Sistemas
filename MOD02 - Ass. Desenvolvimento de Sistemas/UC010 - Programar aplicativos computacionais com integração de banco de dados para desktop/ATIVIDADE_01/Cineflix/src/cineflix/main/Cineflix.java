
package cineflix.main;

import cineflix.model.Filme;
import cineflix.model.FilmeDAO;
import java.sql.SQLException;

public class Cineflix {
    
    public static void main(String[] args) throws SQLException {
       Filme f = new Filme("Velozes e furiozos", "2000-02-10 ", "drama");
       
       FilmeDAO.cadastrar(f);
    }
    
}
