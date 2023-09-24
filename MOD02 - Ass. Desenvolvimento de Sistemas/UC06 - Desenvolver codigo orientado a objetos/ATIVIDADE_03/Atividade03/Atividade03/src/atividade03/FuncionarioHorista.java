
package atividade03;

public abstract class FuncionarioHorista  extends Funcionario {
        private double horasTrabalhadas;
        private double valorHora;
        
         public FuncionarioHorista(String nome, String cpf, String endereco, String telefone, String setor, double valorHora) {
        super(nome, cpf, endereco, telefone, setor);
        this.valorHora = valorHora;
    }
         
     public void setHorasTrabalhadas(double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }
    
     
    
    @Override
    public double calcularPagamento() {
        return horasTrabalhadas * valorHora;
    }

    @Override
    public void aplicarAumento(double percentual) {
        valorHora += valorHora * (percentual / 100);
    }
     
}
