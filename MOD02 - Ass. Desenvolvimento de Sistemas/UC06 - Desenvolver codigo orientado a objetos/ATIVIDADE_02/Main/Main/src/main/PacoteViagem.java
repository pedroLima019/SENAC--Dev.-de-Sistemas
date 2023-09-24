
package main;

public class PacoteViagem {
    private final  Transporte transporte;
    private final  Hospedagem hospedagem;
    private final  String destino;
    private final  int quantidadeDias;

    public PacoteViagem(Transporte transporte, Hospedagem hospedagem, String destino, int quantidadeDias) {
        this.transporte = transporte;
        this.hospedagem = hospedagem;
        this.destino = destino;
        this.quantidadeDias = quantidadeDias;
    }
   
      public double calcularTotal(double margemLucro, double taxasAdicionais) {
        double totalHospedagem = hospedagem.calcularTotal(quantidadeDias);
        double totalPacote = transporte.getValor() + totalHospedagem + taxasAdicionais;
        return totalPacote + (totalPacote * margemLucro / 100);
    }
  
}
