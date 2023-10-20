
package academiaclient;

public class VelocidadeFactory implements CategoriaFactory {
    @Override
    public Exercicio criarExercicio() {
        return new Musculacao(); // Exercício de musculação de velocidade
    }
}
