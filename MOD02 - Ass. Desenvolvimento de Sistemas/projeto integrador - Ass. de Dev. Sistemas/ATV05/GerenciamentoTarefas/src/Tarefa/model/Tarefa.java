
package Tarefa.model;

import java.util.Date;

public class Tarefa{
    private int id; 
    private String nome;
    private String dataCadastro;
    private String prioridade;

    public Tarefa() {
        
    }

    public Tarefa(int id ,String nome, String dataCadastro, String prioridade) {
        this.id = id; 
        this.nome = nome;
        this.dataCadastro = dataCadastro;
        this.prioridade = prioridade;
    }
    
    public int getId(){
        return id; 
    }
    
    public void setId(int id){
        this.id = id; 
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDatacadastro() {
        return dataCadastro;
    }

    public void setDatacadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public static String converterParaSQL(String dataAntiga) {
        String[] partesData = dataAntiga.split("/");
        String dataNova = partesData[2] + "-" + partesData[1] + "-" + partesData[0];
        return dataNova;
    }

    public static String converterParaJava(String dataAntiga) {
        String[] partesData = dataAntiga.split("-");
        String dataNova = partesData[2] + "/" + partesData[1] + "/" + partesData[0];
        return dataNova;
    }

    void setPrioriade(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
