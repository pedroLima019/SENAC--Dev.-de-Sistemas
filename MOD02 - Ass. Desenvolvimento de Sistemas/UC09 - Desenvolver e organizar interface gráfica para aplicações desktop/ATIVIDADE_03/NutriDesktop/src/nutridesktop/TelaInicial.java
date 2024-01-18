package nutridesktop;

import java.awt.event.WindowAdapter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Maria Alice
 */
public class TelaInicial extends javax.swing.JFrame {

    ListaConsultas lc = new ListaConsultas();

    /**
     * Creates new form TelaInicial
     */
    public TelaInicial() {
        initComponents();

        ListaConsultas lc;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsultas = new javax.swing.JTable();
        btnNovaConsulta = new javax.swing.JButton();
        btnExcluirConsulta = new javax.swing.JButton();
        btnFinalizarConsulta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel1.setText("Boas vindas ao sistema de agendamento");

        tblConsultas.setModel(montarTabela());
        jScrollPane1.setViewportView(tblConsultas);

        btnNovaConsulta.setText("Nova Consulta");
        btnNovaConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaConsultaActionPerformed(evt);
            }
        });

        btnExcluirConsulta.setText("Excluir Consulta");
        btnExcluirConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirConsultaActionPerformed(evt);
            }
        });

        btnFinalizarConsulta.setText("Finalizar Consulta");
        btnFinalizarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarConsultaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(91, 91, 91))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNovaConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnExcluirConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnFinalizarConsulta)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovaConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluirConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinalizarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirConsultaActionPerformed
        int linhaSelecionada = getPosicao();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar uma consulta!");
        } else {

            ListaConsultas.excluir(linhaSelecionada);
            this.refresh();
           
        }

    }//GEN-LAST:event_btnExcluirConsultaActionPerformed
    public void refresh() {
        
        tblConsultas.setModel(montarTabela());

        jScrollPane1.setViewportView(tblConsultas);

    }
    private void btnFinalizarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarConsultaActionPerformed
        int linhaSelecionada = getPosicao();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar uma consulta!");
        } else {

            TelaDetalhesConsulta tDC = new TelaDetalhesConsulta(linhaSelecionada);
            tDC.setLocationRelativeTo(null);
            tDC.setVisible(true);
        
           
        }
        
    }//GEN-LAST:event_btnFinalizarConsultaActionPerformed

    private void btnNovaConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaConsultaActionPerformed
        TelaCadastroConsulta tlCadastro = new TelaCadastroConsulta(this);
        tlCadastro.setVisible(true);

        
    }//GEN-LAST:event_btnNovaConsultaActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    private DefaultTableModel montarTabela() {
        String[] colunas = {"ID", "Paciente", "CPF", "Telefone", "Já é paciente?", "Consulta Realizada?"};

        //Criamos a tabela "na mão"
        DefaultTableModel tabela = new DefaultTableModel(colunas, 0);

        //Pegar os dados da lista de produtos
        ArrayList<Paciente> lista = ListaConsultas.listar();

        //FOR para MONTAR A LINHA na tabela
        for (int i = 0; i < lista.size(); i++) {
            Paciente p = lista.get(i);
            String[] linha = {
                Integer.toString(p.getId()),
                p.getNomeCliente(),
                p.getCpf(),
                p.getTelefone(),
                p.getPaciente(),
                p.getVerificacao()
            };
            tabela.addRow(linha); //Não esquecer de adicionar a linha na tabela!
        }

        return tabela;
    }

    private int getPosicao() {

        int posicao = tblConsultas.getSelectedRow();

        return posicao;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluirConsulta;
    private javax.swing.JButton btnFinalizarConsulta;
    private javax.swing.JButton btnNovaConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblConsultas;
    // End of variables declaration//GEN-END:variables

}
