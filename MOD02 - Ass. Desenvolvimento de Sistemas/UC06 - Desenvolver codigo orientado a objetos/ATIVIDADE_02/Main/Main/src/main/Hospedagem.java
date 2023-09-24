
package main;

public class Hospedagem {
    private final String descricao;
    private final  double valorDiaria; 

    public Hospedagem(String descricao, double valorDiaria) {
        this.descricao = descricao;
        this.valorDiaria = valorDiaria;
    }
    
      public double calcularTotal(int dias) {
        return valorDiaria * dias;
    }
}
