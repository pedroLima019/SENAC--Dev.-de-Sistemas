
package ativadade04;

import java.util.Scanner;

public class Ativadade04 {

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       
         System.out.print("Informe a descrição do pagamento: ");
        String descricaoPagamento = scanner.nextLine();
        Pagamento pagamento = new Pagamento(descricaoPagamento);
        
         while (true) {
            System.out.print("Informe o tipo de imposto (PIS/IPI) ou 'pare' para encerrar: ");
            String tipoImposto = scanner.nextLine();

            if (tipoImposto.equalsIgnoreCase("pare")) {
                break;
            }
            System.out.print("Informe a descrição do imposto: ");
            String descricaoImposto = scanner.nextLine();

            System.out.print("Informe o valor do imposto: ");
            double valorImposto = scanner.nextDouble();
            scanner.nextLine(); // Limpar o buffer
            
            if (tipoImposto.equalsIgnoreCase("PIS")) {
                pagamento.adicionarImposto(new PIS(descricaoImposto, valorImposto));
            } else if (tipoImposto.equalsIgnoreCase("IPI")) {
                pagamento.adicionarImposto(new IPI(descricaoImposto, valorImposto));
            }
           System.out.println("\nDetalhes do Pagamento:");
           pagamento.calcularTotalImpostos();
        }
    }
}