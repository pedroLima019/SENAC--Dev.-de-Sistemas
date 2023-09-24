
package atividade03;

public abstract class Funcionario {
    private final String nome; 
    private final String cpf;
    private final String endereco;
    private final String telefone;
    private final String setor; 
    
       public Funcionario(String nome, String cpf, String endereco, String telefone, String setor) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.setor = setor;
    }
       
    public abstract double calcularPagamento();
    public abstract void aplicarAumento(double percentual);
    
      public void mostrarDados() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Endereço: " + endereco);
        System.out.println("Telefone: " + telefone);
        System.out.println("Setor: " + setor);
    }
} 
 
