import java.util.ArrayList;
import java.util.List;

public class BancoDeDadosImpl implements BancoDeDados {
    private final List<Usuario> usuarios;
    
    
       public BancoDeDadosImpl() {
        this.usuarios = new ArrayList<>();
    }
    @Override 
    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado: " + usuario.getUsername());
    } 
    @Override
    public List<Usuario> getUsuarios() {
        return new ArrayList<>(usuarios);
    }
}
