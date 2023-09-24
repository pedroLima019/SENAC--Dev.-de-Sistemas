
package ativadade04;

public class IPI implements Imposto {
    private final String descricao;
    private final double valor;

    public IPI(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    @Override
    public double calcularImposto() {
        // Cálculo específico para o IPI
        return valor * 0.05; // Por exemplo, 5% do valor
    }

    @Override
    public String getDescricao() {
        return descricao;
    }
}