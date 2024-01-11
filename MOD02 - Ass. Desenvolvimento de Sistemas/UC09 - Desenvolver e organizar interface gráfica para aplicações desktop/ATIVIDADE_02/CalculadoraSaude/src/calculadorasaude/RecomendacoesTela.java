
package calculadorasaude;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecomendacoesTela extends JFrame {
    private final JTextField caloriasField;
    private final JLabel carboidratosLabel;
    private final JLabel proteinasLabel;
    private final JLabel gorduraLabel;

    public RecomendacoesTela() {
        setTitle("Recomendações");
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel caloriasLabel = new JLabel("Calorias diárias (kcal)");
        caloriasField = new JTextField(10);
        JButton calcularButton = new JButton("Calcular");

        carboidratosLabel = new JLabel("Carboidratos: ");
        proteinasLabel = new JLabel("Proteínas: ");
        gorduraLabel = new JLabel("Gordura: ");

        panel.add(caloriasLabel);
        panel.add(caloriasField);
        panel.add(calcularButton);
        panel.add(carboidratosLabel);
        panel.add(proteinasLabel);
        panel.add(gorduraLabel);

        add(panel);

        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularRecomendacoes();
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void calcularRecomendacoes() {
        try {
            double calorias = Double.parseDouble(caloriasField.getText());

            double carboidratos = calorias * 0.5 / 4;
            double proteinas = calorias * 0.25 / 4;
            double gordura = calorias * 0.25 / 9;

            carboidratosLabel.setText("Carboidratos: " + carboidratos + "g");
            proteinasLabel.setText("Proteínas: " + proteinas + "g");
            gorduraLabel.setText("Gordura: " + gordura + "g");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Informe um valor válido para calorias.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}

