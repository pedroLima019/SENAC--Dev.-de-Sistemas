
package ativadade04;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Pagamento {
    private final String descricao;
    private final List<Imposto> impostos;

    public Pagamento(String descricao) {
        this.descricao = descricao;
        this.impostos = new ArrayList<>();
    }

    public void adicionarImposto(Imposto imposto) {
        impostos.add(imposto);
    }

    public void calcularTotalImpostos() {
        double total = 0;
        for (Imposto imposto : impostos) {
            double valorImposto = imposto.calcularImposto();
            total += valorImposto;
            System.out.println("Imposto: " + imposto.getDescricao() + ", Valor: " + valorImposto);
        }
        System.out.println("Total de Impostos: " + total);
    }
}

