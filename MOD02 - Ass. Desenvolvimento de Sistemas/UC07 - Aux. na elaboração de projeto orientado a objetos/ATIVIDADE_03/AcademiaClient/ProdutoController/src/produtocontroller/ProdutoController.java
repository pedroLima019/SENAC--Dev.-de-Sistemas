
package produtocontroller;

import Supermercado.ProdutoEntity;

public class ProdutoController {
    private final ValidadorProduto validadorProduto;
    private final ProdutoRepository produtoRepository;
    private final MensagemService mensagemService;

    public ProdutoController() {
        this.validadorProduto = new ValidadorProduto();
        this.produtoRepository = new ProdutoRepository();
        this.mensagemService = new MensagemService();
    }

    public boolean salvarProduto(ProdutoEntity produto) {
        if (validadorProduto.validar(produto)) {
            if (produtoRepository.salvar(produto)) {
                mensagemService.enviarMensagem();
                return true;
            }
        }
        return false;
    }
}

