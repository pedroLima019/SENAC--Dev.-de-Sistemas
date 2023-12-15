
public class Usuario {
    protected final String nomeDeUsuario;
    protected final String senha;

    // Construtor privado para evitar construção direta e incentivar o uso do Builder
    protected Usuario(UsuarioBuilder builder) {
        this.nomeDeUsuario = builder.nomeDeUsuario;
        this.senha = builder.senha;
    }



    // Métodos getters
    public String getNomeDeUsuario() {
        return nomeDeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    // Classe Builder estática dentro da classe Usuario
    public static class UsuarioBuilder {
        private String nomeDeUsuario;
        private String senha;

        // Construtor obrigatório com os parâmetros necessários
        public UsuarioBuilder(String nomeDeUsuario, String senha) {
            this.nomeDeUsuario = nomeDeUsuario;
            this.senha = senha;
        }

        // Métodos opcionais para configurar outros atributos, se necessário
        public UsuarioBuilder setNomeDeUsuario(String nomeDeUsuario) {
            this.nomeDeUsuario = nomeDeUsuario;
            return this;
        }

        public UsuarioBuilder setSenha(String senha) {
            this.senha = senha;
            return this;
        }

        // Método para criar uma instância de Usuario
        public Usuario build() {
            return new Usuario(this);
        }
    }

    // Métodos adicionais da classe Usuario, se necessário

    void add(Usuario usuario) {
        // Lógica para adicionar usuário, se necessário
    }

    // Método para obter o nome de usuário
    String getUsername() {
        return nomeDeUsuario;
    }
    
    
}



