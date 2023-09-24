
package atividade04;

import java.util.Scanner;

public class Atividade04 {


    public static void main(String[] args) {
        
    
    
        Scanner scanner = new Scanner(System.in);

        String[] hospedes = new String[15]; // Array para armazenar os hóspedes
        int totalCadastros = 0; // Contador de cadastros realizados
        OUTER:
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Pesquisar");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    if (totalCadastros >= hospedes.length) {
                        System.out.println("Máximo de cadastros atingido.");
                    } else {
                        System.out.print("Digite o nome do hóspede: ");
                        String nomeHospede = scanner.nextLine();
                        hospedes[totalCadastros] = nomeHospede;
                        totalCadastros++;
                        System.out.println("Hóspede cadastrado com sucesso.");
                    }   break;
                case 2:
                    
                    System.out.print("Digite o nome do hóspede para pesquisar: ");
                    String nomePesquisa = scanner.nextLine();
                    boolean encontrado = false;
                    for (int i = 0; i < totalCadastros; i++) {
                        if (hospedes[i].equals(nomePesquisa)) {
                            System.out.println("Hóspede " + nomePesquisa + " foi encontrado no índice " + i + ".");
                            encontrado = true;
                            break;
                        }
                    }   if (!encontrado) {
                        System.out.println("Hóspede não encontrado.");
                    }   break;
                case 3:
                    
                    System.out.println("Encerrando o programa...");
                    break OUTER;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
                    break;
            }
        }
    }
}

    
