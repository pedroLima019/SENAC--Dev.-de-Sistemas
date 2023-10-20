
package academiaclient;

import java.util.Scanner;

public class AcademiaClient {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Escolha a categoria (1 para corrida , 2 para musculação)");
        int categoria = scanner.nextInt(); 
       
        CategoriaFactory factory = null; 
          if(categoria == 1){
              factory = new ResistenciaFactory();
          }else if ( categoria == 2){
              factory = new VelocidadeFactory();
          }else{
              System.out.println("Categoria inválida.");
          }
          
           Exercicio exercicio = factory.criarExercicio();

           System.out.println("Exercício selecionado:");
           exercicio.realizar();

        scanner.close();
          
    }
    
}
