
package cineflix.view;

import cineflix.main.Cineflix;
import cineflix.model.Filme;
import cineflix.model.FilmeDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListaFilmes extends javax.swing.JFrame {

    private static int getSelectedRow() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static Object getValueAt(int selectedRow, int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ListaFilmes() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ListaDeFilme = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        addFilme = new javax.swing.JButton();
        Btn_Excluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela_Filmes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Lista de Filmes ");

        addFilme.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        addFilme.setText("Adicionar Filme");
        addFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFilmeActionPerformed(evt);
            }
        });

        Btn_Excluir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Btn_Excluir.setText("Excluir");
        Btn_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ExcluirActionPerformed(evt);
            }
        });

        DefaultTableModel tabela = montarTabela(FilmeDAO.listarTodos());
        Tabela_Filmes.setModel(tabela);
        jScrollPane1.setViewportView(Tabela_Filmes);

        javax.swing.GroupLayout ListaDeFilmeLayout = new javax.swing.GroupLayout(ListaDeFilme);
        ListaDeFilme.setLayout(ListaDeFilmeLayout);
        ListaDeFilmeLayout.setHorizontalGroup(
            ListaDeFilmeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListaDeFilmeLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(ListaDeFilmeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ListaDeFilmeLayout.createSequentialGroup()
                        .addComponent(addFilme)
                        .addGap(18, 18, 18)
                        .addComponent(Btn_Excluir))
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ListaDeFilmeLayout.setVerticalGroup(
            ListaDeFilmeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListaDeFilmeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ListaDeFilmeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addFilme)
                    .addComponent(Btn_Excluir))
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ListaDeFilme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ListaDeFilme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFilmeActionPerformed
      
        CadastroFilme tela = new CadastroFilme();
        tela.setVisible(true);
    }//GEN-LAST:event_addFilmeActionPerformed

    private void Btn_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ExcluirActionPerformed
   int selectedRow = Tabela_Filmes.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Por favor, selecione um filme para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int id = Integer.parseInt(Tabela_Filmes.getValueAt(selectedRow, 0).toString());

    int resposta = JOptionPane.showConfirmDialog(null, "DESEJA EXCLUIR REALMENTE ESSE REGISTRO ? ");
    if (resposta == JOptionPane.YES_OPTION) {
        try {
            boolean excluiu = FilmeDAO.excluir(id);
            if (excluiu) {
                DefaultTableModel model = (DefaultTableModel) Tabela_Filmes.getModel();
                model.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao excluir o filme.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cineflix.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao excluir registro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_Btn_ExcluirActionPerformed

    private DefaultTableModel montarTabela(List<Filme> lista) {
    String[] colunas = {"ID", "Filme", "Data Lançamento", "Categoria"};
    DefaultTableModel tabela = new DefaultTableModel();
    tabela.setColumnIdentifiers(colunas);

    for (int i = 0; i < lista.size(); i++) {
        Filme f = lista.get(i);
        String[] linha = {
            String.valueOf(f.getId()), // Adicionando o ID
            f.getNome(),
            f.getDataLancamento(),
            f.getCategoria()
        };

        tabela.addRow(linha);
    }
    return tabela; // Corrigindo para retornar a tabela, não null
}
    
    
    
    private void preencherTabela() {
    // Obter a lista de filmes do banco de dados
    List<Filme> filmes = FilmeDAO.listarTodos();

    // Preencher o DefaultTableModel com os dados dos filmes
    DefaultTableModel model = (DefaultTableModel) Tabela_Filmes.getModel(); // Corrigindo a referência ao JTable
    for (Filme filme : filmes) {
        model.addRow(new Object[]{filme.getId(), filme.getNome(), filme.getDataLancamento(), filme.getCategoria()});
    }
}
    public static void main(String args[]) {
   
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaFilmes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Excluir;
    private javax.swing.JPanel ListaDeFilme;
    private javax.swing.JTable Tabela_Filmes;
    private javax.swing.JButton addFilme;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
