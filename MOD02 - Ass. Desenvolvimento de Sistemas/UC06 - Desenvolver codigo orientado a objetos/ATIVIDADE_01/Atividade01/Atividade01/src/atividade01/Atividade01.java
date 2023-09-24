
package atividade01;

import java.util.Scanner;
public class Atividade01 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        int numeroConvidados , cadeirasAdicionais;
        
        System.out.println("Digite o número de convidados do evento:");
         numeroConvidados = entrada.nextInt();
         
         if(numeroConvidados < 0 || numeroConvidados > 350){
             System.out.println("Numero de convidados inválidos");
             
         }else {
             
             if(numeroConvidados <= 150){
                 
                 System.out.println("O auditório Alfa é o mais adequado");
                 cadeirasAdicionais = Math.max(0 , numeroConvidados - 150);
                 System.out.println("Cadeiras adicionais necessárias" + cadeirasAdicionais);
                 
             }else{
                 
                 System.out.println("O auditório Beta é o mais adequado.");
             }
         }
         
    }
    
}
