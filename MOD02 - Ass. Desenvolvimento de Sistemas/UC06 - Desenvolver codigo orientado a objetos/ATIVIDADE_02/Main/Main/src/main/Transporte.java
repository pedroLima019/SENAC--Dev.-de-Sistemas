
package main;

public class Transporte {
    private final String tipo;
    private final double valor; 

    public Transporte(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }
    
    public double getValor(){
        return valor;
    }
}
