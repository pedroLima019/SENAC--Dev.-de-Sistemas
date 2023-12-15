

package com.mycompany.minhaaplicacao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinhaAplicacao {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            criarInterface();
        });
    }

    private static void criarInterface() {
        JFrame frame = new JFrame("Aplicação MVP");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField valorField = new JTextField(10);
        JButton calcularButton = new JButton("Calcular");

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double valorVenda = Double.parseDouble(valorField.getText());

                    if (valorVenda > 500) {
                        double desconto = solicitarDesconto();
                        double valorTotal = calcularValorComDesconto(valorVenda, desconto);
                        exibirResultado(valorTotal);
                    } else {
                        exibirResultado(valorVenda);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Informe um valor válido.");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Valor da Venda: "));
        panel.add(valorField);
        panel.add(calcularButton);

        frame.getContentPane().add(panel);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    private static double solicitarDesconto() {
        String descontoStr = JOptionPane.showInputDialog("Informe o percentual de desconto:");
        try {
            return Double.parseDouble(descontoStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Informe um valor válido para o desconto.");
            return solicitarDesconto();
        }
    }

    private static double calcularValorComDesconto(double valor, double desconto) {
        return valor - (valor * (desconto / 100));
    }

    private static void exibirResultado(double valor) {
        JOptionPane.showMessageDialog(null, "Valor Total: R$ " + valor);
    }
}
