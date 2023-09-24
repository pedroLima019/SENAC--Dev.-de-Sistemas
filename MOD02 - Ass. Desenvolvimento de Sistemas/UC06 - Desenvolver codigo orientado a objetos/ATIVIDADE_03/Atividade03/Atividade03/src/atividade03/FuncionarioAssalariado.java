
package atividade03;

public abstract class FuncionarioAssalariado extends Funcionario{
    private double salario;
    
     public FuncionarioAssalariado(String nome, String cpf, String endereco, String telefone, String setor, double salario) {
        super(nome, cpf, endereco, telefone, setor);
        this.salario = salario;
    }
     
    @Override
    public double calcularPagamento() {
        return salario;
    }
    
     @Override
    public void aplicarAumento(double percentual) {
        salario += salario * (percentual / 100);
    }
}
