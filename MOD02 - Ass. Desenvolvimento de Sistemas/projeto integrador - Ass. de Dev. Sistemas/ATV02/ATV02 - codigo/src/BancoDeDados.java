
import java.util.List;


public interface BancoDeDados {
    void cadastrarUsuario(Usuario usuario);
    List<Usuario> getUsuarios();
}
