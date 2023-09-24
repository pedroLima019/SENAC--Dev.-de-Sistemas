
package atividade02;

import java.util.Scanner;

public class Atividade02 {
    
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        
        String nomeHospedeA ,nomeHospedeB;
        int idadeHospedeA , idadeHospedeB;
        double descontoHospedeA = 0.0 , descontoHospedeB = 0.0; 
        
        // Informações do primeiro hóspede
        System.out.println("Digite o nome do primeiro hóspede: ");
         nomeHospedeA = entrada.nextLine(); 
         
        System.out.println("Digite a idade do primeiro hospede: ");
         idadeHospedeA = entrada.nextInt();
         
         
        //informações do segundo hóspede
         entrada.nextLine();// pular linha 
        System.out.println("Digite o nome do segundo hóspede: ");
         nomeHospedeB = entrada.nextLine(); 
         
        System.out.println("Digite a idade do segundo hóspede: ");
        idadeHospedeB = entrada .nextInt(); 
              
         if( idadeHospedeA < idadeHospedeB){
             
             System.out.println(nomeHospedeB + " Hospede ficara no quarto B ");
             System.out.println(nomeHospedeA + " Hospede ficara no quarto A ");
             
         }else{
           System.out.println(nomeHospedeA + " ficará no quarto B.");
           System.out.println(nomeHospedeB + " ficará no quarto A.");
        }
        
         //verificar desconto 
        if (idadeHospedeA >= 60) {
            descontoHospedeA = 0.4;
        }

        if (idadeHospedeB >= 60) {
            descontoHospedeB = 0.4;
        }
         
         //exibir desconto , se houver
          if (descontoHospedeA > 0) {
            System.out.println(nomeHospedeA + " tem um desconto de 40%.");
        }

        if (descontoHospedeB > 0) {
            System.out.println(nomeHospedeB + " tem um desconto de 40%.");
        }
    }
}

