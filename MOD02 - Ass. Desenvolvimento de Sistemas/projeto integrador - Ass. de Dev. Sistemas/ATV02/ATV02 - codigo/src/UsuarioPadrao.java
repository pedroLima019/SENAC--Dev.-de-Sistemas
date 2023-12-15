
public class UsuarioPadrao extends Usuario {
    
  
  public UsuarioPadrao(String nomeDeUsuario, String senha) {
        super(new Usuario.UsuarioBuilder(nomeDeUsuario, senha));
    }

     @Override
    public String getUsername() {
        return nomeDeUsuario;
    }
    
     @Override
    public String getSenha() {
        return senha;
    }
}
