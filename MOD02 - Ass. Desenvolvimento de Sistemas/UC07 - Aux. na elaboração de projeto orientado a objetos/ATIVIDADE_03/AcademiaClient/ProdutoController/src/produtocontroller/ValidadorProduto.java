
package produtocontroller;

public class ValidadorProduto {
     public boolean validar(ProdutoEntity produto) {
        return !produto.getNome().isEmpty();
    }

    boolean validar(Supermercado.ProdutoEntity produto) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
