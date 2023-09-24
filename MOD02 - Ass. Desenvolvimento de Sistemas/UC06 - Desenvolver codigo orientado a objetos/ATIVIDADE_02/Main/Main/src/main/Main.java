
package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // cria objeto transporte
        try (Scanner entrada = new Scanner(System.in)) {
            
            // cria objeto transporte
            System.out.println("Informe o tipo de transporte: ");
            String tipoTransporte = entrada.nextLine();
            
            System.out.println("Informe o valor do transporte em doláres: ");
            double valorTransporte = entrada.nextDouble();
            entrada.nextLine();
            
            Transporte transporte = new Transporte(tipoTransporte, valorTransporte);
            
            System.out.println("Informe a descrição da hospedagem:");
            String descricaoHospedagem = entrada.nextLine();
            
            System.out.println("Informe o valor da diária da hospedagem em dólares:");
            double valorDiaria = entrada.nextDouble();
            entrada.nextLine();
            
            Hospedagem hospedagem = new Hospedagem(descricaoHospedagem, valorDiaria);
            
            System.out.println("Informe o destino da viagem:");
            String destino = entrada.nextLine();
            
            System.out.println("Informe a quantidade de dias da viagem:");
            int quantidadeDias = entrada.nextInt();
            entrada.nextLine();
            
            PacoteViagem pacoteViagem = new PacoteViagem(transporte, hospedagem, destino, quantidadeDias);
            
            System.out.println("Informe a margem de lucro desejada (%):");
            double margemLucro = entrada.nextDouble();
            
            System.out.println("Informe o valor das taxas adicionais em dólares:");
            double taxasAdicionais = entrada.nextDouble();
            
            double totalPacote = pacoteViagem.calcularTotal(margemLucro, taxasAdicionais);
            System.out.println("O valor total do pacote em dólares é: " + totalPacote);
            
            System.out.println("Informe o nome do cliente:");
            String nomeCliente = entrada.next();
            entrada.nextLine();
            
            System.out.println("Informe a forma de pagamento:");
            String formaPagamento = entrada.nextLine();
            
            System.out.println("Informe a cotação do dólar:");
            double cotacaoDolar = entrada.nextDouble();
            
            Venda venda = new Venda(nomeCliente, formaPagamento, pacoteViagem);
            double totalReais = venda.calcularTotalReais(cotacaoDolar);
            
            // Mostrando informações da venda
            System.out.println("Informações da Venda:");
            System.out.println("Cliente: " + Venda.getNomeCliente());
            System.out.println("Forma de Pagamento: " + venda.getFormaPagamento());
            System.out.println("Valor Total em Dólar: " + totalPacote);
            System.out.println("Valor Total em Reais: " + totalReais);
        }

    }
    
}
