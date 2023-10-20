
package produtocontroller;

import Supermercado.ProdutoEntity;

public class ProdutoRepository {
      public boolean salvar(ProdutoEntity produto) {
        // Lógica para salvar no banco de dados
        return true; // ou false em caso de falha
    }

    boolean salvar(Supermercado.ProdutoEntity produto) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
