
package ativadade04;

public class ImpostoFixo implements Imposto{
    private final String descricao;
    private final double valor;

    public ImpostoFixo(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    @Override
    public double calcularImposto() {
        return valor;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }
}
