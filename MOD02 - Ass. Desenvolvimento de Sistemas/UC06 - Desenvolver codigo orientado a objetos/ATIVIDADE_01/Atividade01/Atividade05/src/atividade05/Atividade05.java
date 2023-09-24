
package atividade05;

import java.util.Scanner;

public class Atividade05 {

    public static void main(String[] args) {
           Scanner entrada = new Scanner(System.in);

        boolean[][] quartosOcupados = new boolean[4][3]; // Array para rastrear quartos ocupados

        // Registrar quartos ocupados
        do {
            System.out.print("Informe o número do andar (1 a 4): ");
            int andar = entrada.nextInt();
            System.out.print("Informe o número do quarto (1 a 3): ");
            int quarto = entrada.nextInt();

            quartosOcupados[andar - 1][quarto - 1] = true;

            System.out.print("Deseja informar outra ocupação? (S/N): ");
            String resposta = entrada.next();

            if (resposta.equalsIgnoreCase("N")) {
                break;
            }
        } while (true);

        // Mostrar tabela de quartos
        System.out.println("\nTabela de Quartos Ocupados e Desocupados:");
        for (int i = quartosOcupados.length - 1; i >= 0; i--) {
            for (int j = 0; j < quartosOcupados[i].length; j++) {
                System.out.print("| " + (quartosOcupados[i][j] ? "X" : " ") + " ");
            }
            System.out.println("|");
        }
        System.out.println("+---+---+---+"); // Linha inferior da tabela

   
    }
    
}
