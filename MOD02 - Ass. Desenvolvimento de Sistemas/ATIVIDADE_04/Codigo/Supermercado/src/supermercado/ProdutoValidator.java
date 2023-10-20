
package supermercado;

public class ProdutoValidator {
    public boolean validar(ProdutoEntity produto){
        return !produto.getNome().isEmpty();
    }
}
