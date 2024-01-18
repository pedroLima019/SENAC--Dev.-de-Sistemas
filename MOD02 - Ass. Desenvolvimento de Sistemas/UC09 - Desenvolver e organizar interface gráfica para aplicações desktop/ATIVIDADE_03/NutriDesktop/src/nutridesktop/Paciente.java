
package nutridesktop;


public class Paciente {
    
    private int id;
    private String nomeCliente;
    private String cpf; 
    private String telefone;
    private String paciente;
    private String verificacao;

    public Paciente(int id, String nomeCliente, String cpf, String telefone, String paciente,String verificacao) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.cpf = cpf;
        this.telefone = telefone;
        this.paciente = paciente;
        this.verificacao = verificacao;
    }

    public Paciente() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public void setVerificacao(String verificacao) {
        this.verificacao = verificacao;
    }

    public String getPaciente() {
        return paciente;
    }

    public String getVerificacao() {
        return verificacao;
    }
    
    
    
}
