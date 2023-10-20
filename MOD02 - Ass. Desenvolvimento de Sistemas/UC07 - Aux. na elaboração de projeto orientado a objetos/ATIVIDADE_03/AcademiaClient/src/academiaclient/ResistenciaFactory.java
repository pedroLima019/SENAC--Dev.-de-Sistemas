
package academiaclient;

 class ResistenciaFactory implements CategoriaFactory {
     
     @Override
     public Exercicio criarExercicio() {
        return new Corrida(); 
    }
}
