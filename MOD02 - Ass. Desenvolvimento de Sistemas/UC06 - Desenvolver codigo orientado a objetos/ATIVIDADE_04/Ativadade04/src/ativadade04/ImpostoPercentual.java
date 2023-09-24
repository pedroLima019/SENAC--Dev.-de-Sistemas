
package ativadade04;

public class ImpostoPercentual {
    private final String descricao;
    private final double valor;
    private final double taxa;
    
      public ImpostoPercentual(String descricao, double valor, double taxa) {
        this.descricao = descricao;
        this.valor = valor;
        this.taxa = taxa;
    }
     
    public double calcularImposto() {
        return valor * taxa / 100;
    }
    
    
    public String getDescricao() {
        return descricao;
    }
}
