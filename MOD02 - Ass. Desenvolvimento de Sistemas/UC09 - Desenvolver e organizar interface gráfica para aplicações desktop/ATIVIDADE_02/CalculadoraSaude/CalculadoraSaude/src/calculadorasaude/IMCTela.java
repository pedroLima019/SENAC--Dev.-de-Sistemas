
package calculadorasaude;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IMCTela extends JFrame {
    private final JTextField alturaField;
    private final JTextField pesoField;
    private final JLabel resultadoLabel;
    private final JLabel interpretacaoLabel;

    public IMCTela() {
        setTitle("Cálculo de IMC");
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel alturaLabel = new JLabel("Altura (m)");
        alturaField = new JTextField(10);
        JLabel pesoLabel = new JLabel("Peso (kg)");
        pesoField = new JTextField(10);
        JButton calcularButton = new JButton("Calcular");
        resultadoLabel = new JLabel("Resultado: ");
        interpretacaoLabel = new JLabel("Interpretação: ");

        panel.add(alturaLabel);
        panel.add(alturaField);
        panel.add(pesoLabel);
        panel.add(pesoField);
        panel.add(calcularButton);
        panel.add(resultadoLabel);
        panel.add(interpretacaoLabel);

        add(panel);

        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularIMC();
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void calcularIMC() {
        try {
            double altura = Double.parseDouble(alturaField.getText());
            double peso = Double.parseDouble(pesoField.getText());

            double imc = peso / (altura * altura);
            resultadoLabel.setText("Resultado: " + imc);

            String interpretacao = interpretarIMC(imc);
            interpretacaoLabel.setText("Interpretação: " + interpretacao);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Informe valores válidos para altura e peso.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String interpretarIMC(double imc) {
        if (imc < 18.5) return "Magreza";
        else if (imc < 25) return "Normal";
        else if (imc < 30) return "Sobrepeso";
        else if (imc < 40) return "Obesidade";
        else return "Obesidade grave";
    }
}



