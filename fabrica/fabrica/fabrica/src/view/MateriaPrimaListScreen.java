package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.MateriaPrimaDAO;
import model.MateriaPrimaTableModel;

public class MateriaPrimaListScreen {

    // Construtor para a tela de listagem
    public MateriaPrimaListScreen(JFrame mainFrame) {
        // Criando a janela de listagem
        JFrame frame = new JFrame("Lista de Matérias-Primas");

        // Definindo a operação de fechamento
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Usando BorderLayout para centralizar os componentes
        frame.setLayout(new BorderLayout(10, 20));

        // Definindo a cor de fundo da janela
        frame.getContentPane().setBackground(new Color(240, 248, 255));

        // Título da tela
        JLabel titleLabel = new JLabel("Lista de Matérias-Primas", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0, 123, 255));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // Tabela para listar as matérias-primas
        JTable table = new JTable();
        table.setModel(new MateriaPrimaTableModel());

        // Configuração da tabela
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500, 300));

        // Botão para incluir uma nova matéria-prima
        JButton incluirButton = new JButton("Incluir");

        // Botão para excluir uma matéria-prima selecionada
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
                // Redireciona para a tela de cadastro
                new CadastroMateriaPrimaScreen(frame);
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
                    // Recupera o código da matéria-prima selecionada
                    int codigoMateriaPrima = (int) table.getValueAt(selectedRow, 0);  // O código está na primeira coluna

                    // Criando o objeto MateriaPrimaDAO
                    MateriaPrimaDAO materiaPrimaDAO = new MateriaPrimaDAO();
                    String mensagem = materiaPrimaDAO.excluir(codigoMateriaPrima);

                    // Exibe a mensagem de retorno
                    JOptionPane.showMessageDialog(frame, mensagem);

                    // Atualiza a tabela após exclusão
                    ((MateriaPrimaTableModel) table.getModel()).atualizarTabela();
                } else {
                    JOptionPane.showMessageDialog(frame, "Por favor, selecione uma matéria-prima para excluir.");
                }
            }
        });

        // Ação do botão "Voltar" - para voltar à tela principal
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fecha a tela atual de listagem
                frame.dispose();
                // Reabre a tela principal (IndexScreen)
                mainFrame.setVisible(true);
            }
        });
    }

    // Método para estilizar os botões
    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setBackground(new Color(0, 123, 255));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
    }
}
