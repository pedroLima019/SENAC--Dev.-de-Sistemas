
package model;

public class Tarefa {
    private final String descricao;
    private final TipoTarefa tipo;
    private final String prazo;
    private final int prioridade;

    public Tarefa(String descricao, TipoTarefa tipo, String prazo, int prioridade) {
        this.descricao = descricao;
        this.tipo = tipo;
        this.prazo = prazo;
        this.prioridade = prioridade;
    }

    public String getDescricao() {
        return descricao;
    }

    public TipoTarefa getTipo() {
        return tipo;
    }

    public String getPrazo() {
        return prazo;
    }

    public int getPrioridade() {
        return prioridade;
    }

    @Override
    public String toString() {
        return "Descrição: " + descricao + ", Tipo: " + tipo + ", Prazo: " + prazo + ", Prioridade: " + prioridade;
    }
}

