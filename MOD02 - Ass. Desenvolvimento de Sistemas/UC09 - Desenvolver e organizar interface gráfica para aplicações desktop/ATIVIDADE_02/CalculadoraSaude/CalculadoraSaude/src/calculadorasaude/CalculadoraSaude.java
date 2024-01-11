
package calculadorasaude;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraSaude {

    public static void main(String[] args) {
       SwingUtilities.invokeLater(() -> {
           JFrame frame = new JFrame("Calculadora de saúde");
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
           JPanel panel = new JPanel();
           JButton imcButton = new JButton("IMC");
           JButton gastoCaloricoButton = new JButton("Gasto Calórico");
           JButton recomendacoesButton = new JButton("Recomendações");
           
           panel.add(imcButton);
           panel.add(gastoCaloricoButton);
           panel.add(recomendacoesButton);
           
           frame.getContentPane().add(panel);
           frame.setSize(300, 150);
           frame.setLocationRelativeTo(null);
           frame.setVisible(true);
           
            imcButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new IMCTela();
                }
            });
            
            gastoCaloricoButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    new GastoCaloricoTela();
                }
            });
            
            recomendacoesButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    new RecomendacoesTela();
                }
            });
       });
    }
    
}
