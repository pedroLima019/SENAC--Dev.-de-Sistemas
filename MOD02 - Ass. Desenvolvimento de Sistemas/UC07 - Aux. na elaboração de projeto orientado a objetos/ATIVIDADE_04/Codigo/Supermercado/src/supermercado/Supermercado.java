
package supermercado;

public class Supermercado {

    public static void main(String[] args) {
        // TODO code application logic here
        
        ProdutoEntity produto = new ProdutoEntity();
        produto.setId(1);
        produto.setNome("Refrigerante");
        produto.setPreco(10.90);
        
        ProdutoController cp = new ProdutoController();
        
        if (cp.salvarProduto(produto)){
            System.out.println("Produto salvo com sucesso");
        } else {
            System.out.println("Erro ao salvar produto");
        }
        
    }


}
