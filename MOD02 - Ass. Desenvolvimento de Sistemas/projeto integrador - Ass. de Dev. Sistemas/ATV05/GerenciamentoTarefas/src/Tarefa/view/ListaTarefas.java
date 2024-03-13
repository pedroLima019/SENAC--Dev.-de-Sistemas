
package Tarefa.view;


import Tarefa.model.Tarefa;
import Tarefa.model.TarefaDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListaTarefas extends javax.swing.JFrame {

    public ListaTarefas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ListaTarefas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        addTarefa = new javax.swing.JButton();
        Btn_Excluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela_Tarefas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Lista de Tarefas");

        addTarefa.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        addTarefa.setText("Adicionar Tarefa");
        addTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTarefaActionPerformed(evt);
            }
        });

        Btn_Excluir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Btn_Excluir.setText("Excluir");
        Btn_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ExcluirActionPerformed(evt);
            }
        });

        DefaultTableModel tabela = montarTabela(TarefaDAO.listarTodos());
        Tabela_Tarefas.setModel(tabela);
        jScrollPane1.setViewportView(Tabela_Tarefas);

        javax.swing.GroupLayout ListaTarefasLayout = new javax.swing.GroupLayout(ListaTarefas);
        ListaTarefas.setLayout(ListaTarefasLayout);
        ListaTarefasLayout.setHorizontalGroup(
            ListaTarefasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListaTarefasLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(ListaTarefasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ListaTarefasLayout.createSequentialGroup()
                        .addComponent(addTarefa)
                        .addGap(18, 18, 18)
                        .addComponent(Btn_Excluir))
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ListaTarefasLayout.setVerticalGroup(
            ListaTarefasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListaTarefasLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ListaTarefasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTarefa)
                    .addComponent(Btn_Excluir))
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ListaTarefas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ListaTarefas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTarefaActionPerformed
      
        CadastroTarefa tela = new CadastroTarefa();
        tela.setVisible(true);
    }//GEN-LAST:event_addTarefaActionPerformed

    private void Btn_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ExcluirActionPerformed
   int selectedRow = Tabela_Tarefas.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Por favor, selecione um filme para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int id = Integer.parseInt(Tabela_Tarefas.getValueAt(selectedRow, 0).toString());

    int resposta = JOptionPane.showConfirmDialog(null, "DESEJA EXCLUIR REALMENTE ESSE REGISTRO ? ");
    if (resposta == JOptionPane.YES_OPTION) {
        try {
            boolean excluiu = TarefaDAO.excluir(id);
            if (excluiu) {
                DefaultTableModel model = (DefaultTableModel) Tabela_Tarefas.getModel();
                model.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao excluir o filme.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tarefa.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao excluir registro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_Btn_ExcluirActionPerformed

    private DefaultTableModel montarTabela(List<Tarefa> lista) {
    String[] colunas = {"ID", "Nome", "Data Cadastro", "Prioriade"};
    DefaultTableModel tabela = new DefaultTableModel();
    tabela.setColumnIdentifiers(colunas);

    for (int i = 0; i < lista.size(); i++) {
        Tarefa t = lista.get(i);
        String[] linha = {
            Integer.toHexString(t.getId()), // Adicionando o ID
            t.getNome(),
            t.getDatacadastro(),
            t.getPrioridade()
        };

        tabela.addRow(linha);
    }
    return tabela; // Corrigindo para retornar a tabela, não null
}
    
    private void preencherTabela() {
   
    List<Tarefa> tarefa = TarefaDAO.listarTodos();


    DefaultTableModel model = (DefaultTableModel) Tabela_Tarefas.getModel(); // Corrigindo a referência ao JTable
    for (Tarefa t : tarefa) {
        model.addRow(new Object[]{t.getId(), t.getNome(), t.getDatacadastro(), t.getPrioridade()});
    }
}
    public static void main(String args[]) {
   
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaTarefas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Excluir;
    private javax.swing.JPanel ListaTarefas;
    private javax.swing.JTable Tabela_Tarefas;
    private javax.swing.JButton addTarefa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
