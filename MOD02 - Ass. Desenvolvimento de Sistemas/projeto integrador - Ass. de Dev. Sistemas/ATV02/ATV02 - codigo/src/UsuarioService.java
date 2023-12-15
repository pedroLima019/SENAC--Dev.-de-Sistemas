
import java.util.List;


public class UsuarioService {
    private final BancoDeDados bancoDeDados;
    
     public UsuarioService(BancoDeDados bancoDeDados) {
        this.bancoDeDados = bancoDeDados;
    }
     
        public void cadastrarUsuario(Usuario usuario) {
        bancoDeDados.cadastrarUsuario(usuario);
        
    }
        
         public List<Usuario> listarUsuarios() {
        return bancoDeDados.getUsuarios();
    }
}
