
package ativadade04;

public class PIS implements Imposto {
    private final String descricao;
    private final double valor;

    public PIS(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    @Override
    public double calcularImposto() {
        // Cálculo específico para o PIS
        return valor * 0.01; // Por exemplo, 1% do valor
    }

    @Override
    public String getDescricao() {
        return descricao;
    }
}
