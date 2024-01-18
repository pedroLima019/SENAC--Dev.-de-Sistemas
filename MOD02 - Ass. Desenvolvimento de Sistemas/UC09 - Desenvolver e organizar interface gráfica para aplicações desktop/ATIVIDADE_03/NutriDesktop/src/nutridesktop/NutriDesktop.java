
package nutridesktop;

import java.awt.FlowLayout;
import javax.swing.JFrame;


public class NutriDesktop {

    public static void main(String[] args) {
        
       TelaInicial tlInicial = new TelaInicial();
       tlInicial.setVisible(true);
       
       tlInicial.setTitle("NutriSoft");
       tlInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       tlInicial.setLayout(new FlowLayout());
        
    }
    
}
