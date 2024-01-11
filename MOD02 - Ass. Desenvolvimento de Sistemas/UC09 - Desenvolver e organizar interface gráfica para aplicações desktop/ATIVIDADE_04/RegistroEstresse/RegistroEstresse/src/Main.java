import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Main extends JFrame {
    private JTextField txtNome, txtIdade;
    private JCheckBox chkEstresse;
    private JTextArea txtAreaDados;
    private JTable table;

    public Main() {
        initComponents();
    }

    private void initComponents() {
        // Definindo layout
        setLayout(null);

        // Labels
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 10, 80, 20);
        add(lblNome);

        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setBounds(10, 40, 80, 20);
        add(lblIdade);

        // Caixas de texto
        txtNome = new JTextField();
        txtNome.setBounds(100, 10, 150, 20);
        add(txtNome);

        txtIdade = new JTextField();
        txtIdade.setBounds(100, 40, 50, 20);
        add(txtIdade);

        // Checkbox
        chkEstresse = new JCheckBox("Estresse");
        chkEstresse.setBounds(10, 70, 100, 20);
        add(chkEstresse);

        // Botão Salvar
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(10, 100, 80, 30);
        btnSalvar.addActionListener((ActionEvent e) -> {
            salvarDados();
        });
        add(btnSalvar);

        // Área de texto para exibir os dados
        txtAreaDados = new JTextArea();
        txtAreaDados.setBounds(200, 70, 250, 100);
        txtAreaDados.setEditable(false);  // torna a área de texto somente leitura
       
        add(txtAreaDados);

        // Tabela para exibir os dados
        table = new JTable(new DefaultTableModel(new Object[]{"Nome", "Idade", "Estresse"}, 0));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 180, 480, 150);
        add(scrollPane);

        // Configurações da janela
        setTitle("Registro de Estresse");
        setSize(520, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void salvarDados() {
        String nome = txtNome.getText();
        String idadeStr = txtIdade.getText();
        boolean estresse = chkEstresse.isSelected();

        if (nome.isEmpty() || idadeStr.isEmpty()) {
            exibirMensagem("Por favor, preencha todos os campos.");
            return;
        }

        try {
            int idade = Integer.parseInt(idadeStr);
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.addRow(new Object[]{nome, idade, estresse});

            // Atualizar a área de texto com os dados
            atualizarTxtAreaDados();

            // Limpar os campos após salvar
            txtNome.setText("");
            txtIdade.setText("");
            chkEstresse.setSelected(false);

        } catch (NumberFormatException e) {
            exibirMensagem("Por favor, insira uma idade válida.");
        }
    }

    private void atualizarTxtAreaDados() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();
        StringBuilder dados = new StringBuilder();

        for (int i = 0; i < rowCount; i++) {
            String nome = (String) model.getValueAt(i, 0);
            int idade = (int) model.getValueAt(i, 1);
            boolean estresse = (boolean) model.getValueAt(i, 2);

            dados.append("Nome: ").append(nome).append(", Idade: ").append(idade);
            if (estresse) {
                dados.append(", Em estresse");
            }
            dados.append("\n");
        }

        txtAreaDados.setText(dados.toString());
    }

    private void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        new Main();
    }
}

