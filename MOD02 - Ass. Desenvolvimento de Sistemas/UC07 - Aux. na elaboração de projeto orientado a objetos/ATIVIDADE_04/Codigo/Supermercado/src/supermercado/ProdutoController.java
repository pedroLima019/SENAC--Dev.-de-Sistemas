
package supermercado;

public class ProdutoController {
    private final ProdutoValidator valida;

    public ProdutoController() {
        this.valida = new ProdutoValidator();
    }

    public boolean salvarProduto(ProdutoEntity produto) {
        if (valida.validar(produto)) {
            // Salvar no banco de dados...
            enviarMensagem();
            return true;
        } else {
            return false;
        }
    }

    public void enviarMensagem() {
        // Enviar mensagem...
    }
}