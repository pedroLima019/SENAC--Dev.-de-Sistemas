
package atividade03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Atividade03 {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       List<Funcionario> funcionarios = new ArrayList<>();
       
       for (int i = 0; i < 10; i++) {
            System.out.println("Informe o tipo de funcionário (1 - Assalariado, 2 - Horista):");
            int tipo = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
        
            System.out.println("Nome:");
            String nome = scanner.nextLine();

            System.out.println("CPF:");
            String cpf = scanner.nextLine();

            System.out.println("Endereço:");
            String endereco = scanner.nextLine();
            
             System.out.println("Telefone:");
            String telefone = scanner.nextLine();

            System.out.println("Setor:");
            String setor = scanner.nextLine();
            
           if (tipo == 1) {
                System.out.println("Salário:");
                double salario = scanner.nextDouble();
                boolean add = funcionarios.add(new FuncionarioAssalariado(nome, cpf, endereco, telefone, setor, salario) {});
            }else if (tipo == 2) {
                System.out.println("Valor da hora:");
                double valorHora = scanner.nextDouble();
                System.out.println("Horas trabalhadas:");
                double horasTrabalhadas = scanner.nextDouble();
                FuncionarioHorista horista = new FuncionarioHorista(nome, cpf, endereco, telefone, setor, valorHora) {};
                horista.setHorasTrabalhadas(horasTrabalhadas);
                funcionarios.add(horista);
            }
    } 
       System.out.println("\nDados dos funcionários:");
        for (Funcionario funcionario : funcionarios) {
            funcionario.mostrarDados();
            System.out.println("Pagamento: " + funcionario.calcularPagamento());
            System.out.println("------------------------------");
        } 
       
         System.out.println("Informe o aumento percentual:");
        double aumentoPercentual = scanner.nextDouble();

        for (Funcionario funcionario : funcionarios) {
            funcionario.aplicarAumento(aumentoPercentual);
        }
        
         System.out.println("\nDados dos funcionários após aumento:");
        for (Funcionario funcionario : funcionarios) {
            funcionario.mostrarDados();
            System.out.println("Novo pagamento: " + funcionario.calcularPagamento());
            System.out.println("------------------------------");
        }
    
    }
}