
package atividade03;

import java.util.Scanner;

public class Atividade03 {

    public static void main(String[] args) {
         Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o valor da diária: ");
        double valorDiaria = entrada.nextDouble();
        entrada.nextLine();// pular linha 
        int gratuidades = 0;
        int meiasHospedagens = 0;
        double valorTotal = 0.0;

        while (true) {
            System.out.print("Digite o nome do hóspede (ou 'PARE' para encerrar): ");
            String nomeHospede = entrada.nextLine();

            if (nomeHospede.equalsIgnoreCase("PARE")) {
                break;
            }

            System.out.print("Digite a idade do hóspede: ");
            int idadeHospede = entrada.nextInt();
            entrada.nextLine(); // quebrar linha 

            double valorDiariaAtual = valorDiaria;

            if (idadeHospede < 4) {
                System.out.println(nomeHospede + " possui gratuidade.");
                gratuidades++;
                
            } else if (idadeHospede > 80) {
                System.out.println(nomeHospede + " paga meia.");
                valorDiariaAtual /= 2;
                meiasHospedagens++;
            }

            valorTotal += valorDiariaAtual;
        }

        System.out.println("Quantidade de gratuidades: " + gratuidades);
        System.out.println("Quantidade de meias hospedagens: " + meiasHospedagens);
        System.out.println("Valor total arrecadado: " + valorTotal);
    }
 }
    
