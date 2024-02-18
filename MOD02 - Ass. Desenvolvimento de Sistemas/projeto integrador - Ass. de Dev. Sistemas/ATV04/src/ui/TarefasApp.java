package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;

public class TarefasApp extends JFrame {
    private final GerenciadorTarefas gerenciador;
    private final JTextArea tarefasTextArea;

    public TarefasApp() {
        gerenciador = new GerenciadorTarefas();
        setTitle("Gerenciador de Tarefas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        tarefasTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(tarefasTextArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton adicionarButton = new JButton("Adicionar Tarefa");
        adicionarButton.addActionListener((ActionEvent e) -> {
            adicionarTarefa();
        });
        panel.add(adicionarButton, BorderLayout.SOUTH);

        add(panel);
    }

    private void adicionarTarefa() {
        String descricao = JOptionPane.showInputDialog("Descrição da Tarefa:");
        TipoTarefa tipo = (TipoTarefa) JOptionPane.showInputDialog(null, "Selecione o Tipo:", "Tipo de Tarefa",
                JOptionPane.QUESTION_MESSAGE, null, TipoTarefa.values(), TipoTarefa.values()[0]);
        String prazo = JOptionPane.showInputDialog("Prazo:");
        int prioridade = Integer.parseInt(JOptionPane.showInputDialog("Prioridade (1-5):"));

        Tarefa novaTarefa = new Tarefa(descricao, tipo, prazo, prioridade);
        gerenciador.adicionarTarefa(novaTarefa);
        atualizarListaTarefas();
    }

    private void atualizarListaTarefas() {
        StringBuilder sb = new StringBuilder();
        for (Tarefa tarefa : gerenciador.getTarefas()) {
            sb.append(tarefa.toString()).append("\n");
        }
        tarefasTextArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TarefasApp app = new TarefasApp();
                app.setVisible(true);
            }
        });
    }
}

