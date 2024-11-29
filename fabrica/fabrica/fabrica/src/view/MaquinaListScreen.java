package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.MaquinaDAO;
import model.Maquina;
import model.MaquinaTableModel;
import java.util.List;

public class MaquinaListScreen {

    // Construtor para a tela de listagem de máquinas
    public MaquinaListScreen(JFrame mainFrame) {
        // Criando a janela de listagem
        JFrame frame = new JFrame("Lista de Máquinas");

        // Definindo a operação de fechamento
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Usando BorderLayout para centralizar os componentes
        frame.setLayout(new BorderLayout(10, 20));

        // Definindo a cor de fundo da janela
        frame.getContentPane().setBackground(new Color(240, 248, 255));

        // Título da tela
        JLabel titleLabel = new JLabel("Lista de Máquinas", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0, 123, 255));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // Criando a instância de MaquinaDAO e obtendo a lista de máquinas
        MaquinaDAO maquinaDAO = new MaquinaDAO();
        List<Maquina> maquinas = maquinaDAO.listarMaquinas();

        // Tabela para listar as máquinas
        JTable table = new JTable();
        table.setModel(new MaquinaTableModel(maquinas)); // Definindo o modelo da tabela com a lista de máquinas

        // Configuração da tabela
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500, 300));

        // Botão para incluir uma nova máquina
        JButton incluirButton = new JButton("Incluir");

        // Botão para excluir uma máquina selecionada
        JButton excluirButton = new JButton("Excluir");

        // Botão para voltar para a tela principal
        JButton voltarButton = new JButton("Voltar");

        // Estilizando os botões
        styleButton(incluirButton);
        styleButton(excluirButton);
        styleButton(voltarButton);

        // Painel para os botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS)); // Alinha os botões verticalmente
        buttonPanel.setBackground(new Color(240, 248, 255));

        // Adicionando os botões ao painel com espaçamento
        buttonPanel.add(incluirButton);
        buttonPanel.add(Box.createVerticalStrut(10)); // Espaçamento entre os botões
        buttonPanel.add(excluirButton);
        buttonPanel.add(Box.createVerticalStrut(10)); // Espaçamento entre os botões
        buttonPanel.add(voltarButton);

        // Adicionando o título, a tabela e os botões à janela
        frame.add(titleLabel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.EAST); // Move os botões para a direita da tela

        // Tamanho da janela de listagem
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null); // Centraliza a janela

        // Tornar a janela visível
        frame.setVisible(true);

        // Ação do botão "Incluir"
        incluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Redireciona para a tela de cadastro de máquina
                new CadastroMaquinaScreen(frame);
                frame.dispose();  // Fecha a janela atual
            }
        });

        // Ação do botão "Excluir"
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verificando qual linha foi selecionada
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    // Recupera o número da máquina selecionada
                    int numeroMaquina = (int) table.getValueAt(selectedRow, 0);  // O número da máquina está na primeira coluna

                    // Criando o objeto MaquinaDAO
                    MaquinaDAO maquinaDAO = new MaquinaDAO();
                    String mensagem = maquinaDAO.excluir(numeroMaquina);

                    // Exibe a mensagem de retorno
                    JOptionPane.showMessageDialog(frame, mensagem);

                    // Atualiza a tabela após exclusão
                    List<Maquina> maquinasAtualizadas = maquinaDAO.listarMaquinas();  // Obtendo as máquinas atualizadas
                    ((MaquinaTableModel) table.getModel()).setMaquinas(maquinasAtualizadas);
                } else {
                    JOptionPane.showMessageDialog(frame, "Por favor, selecione uma máquina para excluir.");
                }
            }
        });

        // Ação do botão "Voltar"
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Volta para a tela principal
                mainFrame.setVisible(true);
                frame.dispose();  // Fecha a janela atual
            }
        });
    }

    // Método para estilizar os botões
    private void styleButton(JButton button) {
        button.setPreferredSize(new Dimension(200, 40));
        button.setBackground(new Color(0, 123, 255));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 14));
    }
}
