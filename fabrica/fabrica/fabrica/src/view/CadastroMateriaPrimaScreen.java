package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.MateriaPrima;
import model.MateriaPrimaDAO;

public class CadastroMateriaPrimaScreen {

    // Construtor que recebe o JFrame da tela principal
    public CadastroMateriaPrimaScreen(JFrame mainFrame) {
        // Criando a janela para cadastro de matéria prima (JFrame)
        JFrame frame = new JFrame("Cadastro de Matéria Prima");

        // Definindo a operação padrão para o fechamento da janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Usando BorderLayout para facilitar a centralização dos componentes
        frame.setLayout(new BorderLayout(10, 20));

        // Definindo a cor de fundo da janela
        frame.getContentPane().setBackground(new Color(240, 248, 255)); // Azul claro

        // Título da tela (Cadastro de Matéria Prima)
        JLabel titleLabel = new JLabel("Cadastro de Matéria Prima", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));  // Tamanho maior para o título
        titleLabel.setForeground(new Color(0, 123, 255));  // Azul vibrante
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Espaçamento ao redor do título

        // Criando os componentes da tela
        JLabel nomeMateriaPrimaLabel = new JLabel("Nome da Matéria Prima");
        JTextField nomeMateriaPrimaField = new JTextField(20);
        JLabel tipoMateriaPrimaLabel = new JLabel("Tipo");
        JTextField tipoMateriaPrimaField = new JTextField(20);
        JLabel quantidadeMateriaPrimaLabel = new JLabel("Quantidade");
        JTextField quantidadeMateriaPrimaField = new JTextField(20);

        // Botão para cadastrar
        JButton cadastrarButton = new JButton("Cadastrar");

        // Botão para voltar à tela principal
        JButton voltarButton = new JButton("Voltar");

        // Estilizando os botões
        styleButton(cadastrarButton);
        styleButton(voltarButton);

        // Definindo o tamanho dos botões
        cadastrarButton.setPreferredSize(new Dimension(250, 50));
        voltarButton.setPreferredSize(new Dimension(250, 50));

        // Painel para os campos de cadastro e os botões
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Layout vertical
        panel.setBackground(new Color(240, 248, 255));  // Mesmo fundo da janela
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50)); // Espaçamento interno

        // Adicionando os componentes ao painel
        panel.add(nomeMateriaPrimaLabel);
        panel.add(nomeMateriaPrimaField);
        panel.add(Box.createVerticalStrut(10));  // Espaçamento entre os campos
        panel.add(tipoMateriaPrimaLabel);
        panel.add(tipoMateriaPrimaField);
        panel.add(Box.createVerticalStrut(10));  // Espaçamento entre os campos
        panel.add(quantidadeMateriaPrimaLabel);
        panel.add(quantidadeMateriaPrimaField);
        panel.add(Box.createVerticalStrut(20));  // Espaçamento entre os campos
        panel.add(cadastrarButton);
        panel.add(Box.createVerticalStrut(10));  // Espaçamento entre os botões
        panel.add(voltarButton);

        // Adicionando o título e o painel de cadastro à janela
        frame.add(titleLabel, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        // Tamanho da janela de cadastro
        frame.setSize(400, 450);
        frame.setLocationRelativeTo(null); // Centraliza a janela

        // Tornar a janela visível
        frame.setVisible(true);

        // Ação do botão "Cadastrar"
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Coletando os dados dos campos
                    String nomeMateriaPrima = nomeMateriaPrimaField.getText().trim();
                    String tipoMateriaPrima = tipoMateriaPrimaField.getText().trim();
                    String quantidadeStr = quantidadeMateriaPrimaField.getText().trim();

                    // Validando se o nome, tipo e quantidade foram preenchidos
                    if (nomeMateriaPrima.isEmpty() || tipoMateriaPrima.isEmpty() || quantidadeStr.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos.");
                        return;
                    }

                    // Verificando se a quantidade é um número válido
                    double quantidadeMateriaPrima;
                    try {
                        quantidadeMateriaPrima = Double.parseDouble(quantidadeStr);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Quantidade inválida. Por favor, insira um número válido.");
                        return;
                    }

                    // Criando o objeto MateriaPrima
                    MateriaPrima materiaPrima = new MateriaPrima(0, nomeMateriaPrima, tipoMateriaPrima, quantidadeMateriaPrima);

                    // Criando uma instância de MateriaPrimaDAO para cadastrar a matéria prima
                    MateriaPrimaDAO materiaPrimaDAO = new MateriaPrimaDAO();
                    String mensagem = materiaPrimaDAO.cadastrar(materiaPrima);

                    // Exibindo a mensagem de sucesso ou erro
                    JOptionPane.showMessageDialog(frame, mensagem);

                    // Limpando os campos após o cadastro
                    nomeMateriaPrimaField.setText("");
                    tipoMateriaPrimaField.setText("");
                    quantidadeMateriaPrimaField.setText("");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Ocorreu um erro: " + ex.getMessage());
                }
            }
        });

        // Ação do botão "Voltar"
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();  // Fecha a janela de cadastro
                mainFrame.setVisible(true);  // Torna a janela principal visível novamente
            }
        });
    }

    // Função para estilizar os botões
    private void styleButton(JButton button) {
        button.setBackground(new Color(0, 123, 255));  // Cor de fundo azul
        button.setForeground(Color.WHITE);  // Cor do texto branca
        button.setFont(new Font("Arial", Font.BOLD, 14));  // Fonte mais forte
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));  // Padding interno
        button.setFocusPainted(false);  // Remove o foco quando o botão é clicado
    }
}
