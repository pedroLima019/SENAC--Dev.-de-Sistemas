package nutridesktop;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ListaConsultas {

    public static ArrayList<Paciente> lista = new ArrayList<Paciente>();

    public static boolean adicionar(Paciente p) {

        try {
            if (p.getNomeCliente().isBlank()) {

                JOptionPane.showMessageDialog(null, "Preencher o nome corretamente!");

            } else if (p.getCpf().isBlank()) {

                JOptionPane.showMessageDialog(null, "Preencher o CPF corretamente!");

            } else if (p.getTelefone().isBlank()) {

                JOptionPane.showMessageDialog(null, "Preencher o telefone corretamente!");

            } else {
            
            p.setId(lista.size() + 1);
            
            lista.add(p);

            return true;
            }
        } catch (Exception e) {

            System.out.println("Ocorreu um erro ao a lista");

        }
         return false;
    }
    public static ArrayList<Paciente> listar() {
        return lista;
    }

    public static boolean excluir(int id) {
        try {
            if(id < 0 ){
                JOptionPane.showMessageDialog(null, "Selecione um item para excluir:");
            } else {
                lista.remove(id);
                return true;
            }            
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao excluir da lista");
        }
        return false;
    }

}
