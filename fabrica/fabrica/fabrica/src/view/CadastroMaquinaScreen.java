package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Maquina;
import model.MaquinaDAO;

public class CadastroMaquinaScreen {

    // Construtor que recebe o JFrame da tela principal
    public CadastroMaquinaScreen(JFrame mainFrame) {
        // Criando a janela para cadastro de máquina (JFrame)
        JFrame frame = new JFrame("Cadastro de Máquina");

        // Definindo a operação padrão para o fechamento da janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Usando BorderLayout para facilitar a centralização dos componentes
        frame.setLayout(new BorderLayout(10, 20));

        // Definindo a cor de fundo da janela
        frame.getContentPane().setBackground(new Color(240, 248, 255)); // Azul claro

        // Título da tela (Cadastro de Máquina)
        JLabel titleLabel = new JLabel("Cadastro de Máquina", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));  // Tamanho maior para o título
        titleLabel.setForeground(new Color(0, 123, 255));  // Azul vibrante
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Espaçamento ao redor do título

        // Criando os componentes da tela (exemplo simples)
        JLabel numMaquinaLabel = new JLabel("Número da Máquina");
        JTextField numMaquinaField = new JTextField(10);
        JLabel nomeMaquinaLabel = new JLabel("Nome da Máquina");
        JTextField nomeMaquinaField = new JTextField(10);

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
        panel.add(numMaquinaLabel);
        panel.add(numMaquinaField);
        panel.add(Box.createVerticalStrut(10));  // Espaçamento entre os campos
        panel.add(nomeMaquinaLabel);
        panel.add(nomeMaquinaField);
        panel.add(Box.createVerticalStrut(20));  // Espaçamento entre os campos
        panel.add(cadastrarButton);
        panel.add(Box.createVerticalStrut(10));  // Espaçamento entre os botões
        panel.add(voltarButton);

        // Adicionando o título e o painel de cadastro à janela
        frame.add(titleLabel, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        // Tamanho da janela de cadastro
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null); // Centraliza a janela

        // Tornar a janela visível
        frame.setVisible(true);

        // Ação do botão "Cadastrar"
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Coletando os dados dos campos
                    int numMaquina = Integer.parseInt(numMaquinaField.getText()); // Pode gerar exceção
                    String nomeMaquina = nomeMaquinaField.getText();

                    if (nomeMaquina.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Por favor, preencha o nome da máquina.");
                        return;
                    }

                    // Criando o objeto Maquina
                    Maquina maquina = new Maquina(numMaquina, nomeMaquina);

                    // Criando uma instância de MaquinaDAO para cadastrar a máquina
                    MaquinaDAO maquinaDAO = new MaquinaDAO();
                    String mensagem = maquinaDAO.cadastrar(maquina);

                    // Exibindo a mensagem de retorno do cadastro
                    JOptionPane.showMessageDialog(frame, mensagem);

                    // Limpar os campos após o cadastro
                    numMaquinaField.setText("");
                    nomeMaquinaField.setText("");
                } catch (NumberFormatException ex) {
                    // Exibindo mensagem de erro se o número da máquina não for válido
                    JOptionPane.showMessageDialog(frame, "O número da máquina deve ser um valor inteiro.");
                }
            }
        });

        // Ação do botão "Voltar"
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fechar a tela de cadastro de máquina
                frame.dispose();
                // Reabrir a tela inicial
                mainFrame.setVisible(true);
            }
        });
    }

    // Método para estilizar os botões
    private void styleButton(JButton button) {
        button.setBackground(new Color(0, 123, 255));  // Azul vibrante
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(new Color(0, 123, 255), 2));  // Borda azul
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));  // Cursor de mão ao passar sobre o botão
        button.setPreferredSize(new Dimension(250, 50));
    }
}
