
package main;

public class Venda {

    static String getNomeCliente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private String nomeCliente;
    private String formaPagamento;
    private PacoteViagem pacoteViagem;

    public Venda(String nomeCliente, String formaPagamento, PacoteViagem pacoteViagem) {
        this.nomeCliente = nomeCliente;
        this.formaPagamento = formaPagamento;
        this.pacoteViagem = pacoteViagem;
    }
    
    
    
    public double calcularTotalReais(double cotacaoDolar) {
        double totalDolar = pacoteViagem.calcularTotal(0, 0);
        return totalDolar * cotacaoDolar;
    }

    String getFormaPagamento() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
