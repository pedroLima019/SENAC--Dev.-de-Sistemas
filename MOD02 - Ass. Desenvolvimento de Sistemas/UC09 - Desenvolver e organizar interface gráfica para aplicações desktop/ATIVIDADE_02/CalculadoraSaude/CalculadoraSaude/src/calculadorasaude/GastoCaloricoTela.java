
package calculadorasaude;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GastoCaloricoTela extends JFrame {
    private final JRadioButton homemRadioButton;
    private final JRadioButton mulherRadioButton;
    private final JTextField pesoField;
    private final JTextField alturaField;
    private final JTextField idadeField;
    private final JComboBox<String> atividadeComboBox;
    private final JLabel gastoBasalLabel;
    private final JLabel gastoTotalLabel;

    public GastoCaloricoTela() {
        setTitle("Cálculo de Gasto Calórico");
        setSize(300, 250);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        homemRadioButton = new JRadioButton("Homem");
        mulherRadioButton = new JRadioButton("Mulher");
        ButtonGroup sexoGroup = new ButtonGroup();
        sexoGroup.add(homemRadioButton);
        sexoGroup.add(mulherRadioButton);

        JLabel pesoLabel = new JLabel("Peso (kg)");
        pesoField = new JTextField(10);
        JLabel alturaLabel = new JLabel("Altura (cm)");
        alturaField = new JTextField(10);
        JLabel idadeLabel = new JLabel("Idade");
        idadeField = new JTextField(10);

        JLabel atividadeLabel = new JLabel("Nível de Atividade");
        String[] niveisAtividade = {"Sedentário", "Leve", "Moderado", "Ativo", "Extremamente Ativo"};
        atividadeComboBox = new JComboBox<>(niveisAtividade);

        JButton calcularButton = new JButton("Calcular");
        gastoBasalLabel = new JLabel("Gasto Basal: ");
        gastoTotalLabel = new JLabel("Gasto Total: ");

        panel.add(homemRadioButton);
        panel.add(mulherRadioButton);
        panel.add(pesoLabel);
        panel.add(pesoField);
        panel.add(alturaLabel);
        panel.add(alturaField);
        panel.add(idadeLabel);
        panel.add(idadeField);
        panel.add(atividadeLabel);
        panel.add(atividadeComboBox);
        panel.add(calcularButton);
        panel.add(gastoBasalLabel);
        panel.add(gastoTotalLabel);

        add(panel);

        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularGastoCalorico();
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void calcularGastoCalorico() {
        try {
            double peso = Double.parseDouble(pesoField.getText());
            double altura = Double.parseDouble(alturaField.getText());
            int idade = Integer.parseInt(idadeField.getText());

            double calBasal;
            if (homemRadioButton.isSelected()) {
                calBasal = 66 + (13.8 * peso) + (5 * altura) - (6.8 * idade);
            } else {
                calBasal = 655 + (9.6 * peso) + (1.9 * altura) - (4.7 * idade);
            }
            gastoBasalLabel.setText("Gasto Basal: " + calBasal);

            double calTotal;
            String nivelAtividade = (String) atividadeComboBox.getSelectedItem();
            switch (nivelAtividade) {
                case "Sedentário":
                    calTotal = calBasal * 1.2;
                    break;
                case "Leve":
                    calTotal = calBasal * 1.375;
                    break;
                case "Moderado":
                    calTotal = calBasal * 1.55;
                    break;
                case "Ativo":
                    calTotal = calBasal * 1.725;
                    break;
                case "Extremamente Ativo":
                    calTotal = calBasal * 1.9;
                    break;
                default:
                    calTotal = 0;
            }
            gastoTotalLabel.setText("Gasto Total: " + calTotal);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Informe valores válidos para peso, altura e idade.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}

