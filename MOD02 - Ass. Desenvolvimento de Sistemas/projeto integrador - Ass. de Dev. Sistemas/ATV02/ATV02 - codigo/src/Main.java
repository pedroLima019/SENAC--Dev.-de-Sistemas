
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
         // Criação do banco de dados
        BancoDeDados bancoDeDados = (BancoDeDados) new BancoDeDadosImpl();
        
        // Criação do serviço de usuário
        UsuarioService usuarioService = new UsuarioService(bancoDeDados);
        
        // Cria um novo usuário e cadastra no banco de dados usando o serviço
        Usuario novoUsuario = new UsuarioPadrao("joao123", "senha123");
        usuarioService.cadastrarUsuario(novoUsuario);
        
         // Listar usuários
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        System.out.println("Usuários cadastrados: " + usuarios);
    }
}

