package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Produto;
import model.ProdutoDAO;

public class CadastroProdutoScreen {

    public CadastroProdutoScreen(JFrame mainFrame) {
        // Criando a janela para o cadastro de produto
        JFrame frame = new JFrame("Cadastro de Produto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Definindo a cor de fundo e as fontes
        frame.getContentPane().setBackground(new Color(240, 248, 255)); // Azul claro
        Font font = new Font("Arial", Font.BOLD, 16);

        // Criando os campos de entrada
        JLabel codigoProdutoLabel = new JLabel("Código do Produto");
        JTextField codigoProdutoField = new JTextField(10);
        JLabel nomeProdutoLabel = new JLabel("Nome do Produto");
        JTextField nomeProdutoField = new JTextField(20);
        JLabel tipoProdutoLabel = new JLabel("Tipo do Produto");
        JTextField tipoProdutoField = new JTextField(20);

        // Estilizando os campos
        codigoProdutoLabel.setFont(font);
        nomeProdutoLabel.setFont(font);
        tipoProdutoLabel.setFont(font);
        codigoProdutoField.setFont(font);
        nomeProdutoField.setFont(font);
        tipoProdutoField.setFont(font);

        // Criando os botões
        JButton cadastrarButton = new JButton("Cadastrar");
        JButton voltarButton = new JButton("Voltar");

        // Estilizando os botões
        styleButton(cadastrarButton);
        styleButton(voltarButton);

        // Adicionando os componentes ao frame
        frame.add(codigoProdutoLabel);
        frame.add(codigoProdutoField);
        frame.add(nomeProdutoLabel);
        frame.add(nomeProdutoField);
        frame.add(tipoProdutoLabel);
        frame.add(tipoProdutoField);
        frame.add(cadastrarButton);
        frame.add(voltarButton);

        // Definindo o tamanho da janela
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null); // Centralizando a janela
        frame.setVisible(true);

        // Ação do botão "Cadastrar"
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int codigoProduto = Integer.parseInt(codigoProdutoField.getText());
                    String nomeProduto = nomeProdutoField.getText();
                    String tipoProduto = tipoProdutoField.getText();

                    if (nomeProduto.isEmpty() || tipoProduto.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos.");
                        return;
                    }

                    Produto produto = new Produto(codigoProduto, nomeProduto, tipoProduto);
                    ProdutoDAO produtoDAO = new ProdutoDAO();
                    String mensagem = produtoDAO.cadastrar(produto);

                    JOptionPane.showMessageDialog(frame, mensagem);
                    // Limpando os campos
                    codigoProdutoField.setText("");
                    nomeProdutoField.setText("");
                    tipoProdutoField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "O código do produto deve ser um valor inteiro.");
                }
            }
        });

        // Ação do botão "Voltar"
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();  // Fechar a janela de cadastro
                mainFrame.setVisible(true);  // Reabrir a tela principal
            }
        });
    }

    // Método para estilizar os botões
    private static void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 16)); // Fonte para os botões
        button.setBackground(new Color(0, 123, 255)); // Cor de fundo azul vibrante
        button.setForeground(Color.WHITE); // Texto branco
        button.setPreferredSize(new Dimension(250, 50)); // Tamanho fixo para os botões
    }
}
