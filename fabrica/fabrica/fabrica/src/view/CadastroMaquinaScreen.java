package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Maquina;
import model.MaquinaDAO;

public class CadastroMaquinaScreen {

    public CadastroMaquinaScreen(JFrame mainFrame) {
        JFrame frame = new JFrame("Cadastro de Máquina");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 20));
        frame.getContentPane().setBackground(new Color(240, 248, 255)); // Azul claro

        JLabel titleLabel = new JLabel("Cadastro de Máquina", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));  
        titleLabel.setForeground(new Color(0, 123, 255));  
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); 

        JLabel numMaquinaLabel = new JLabel("Número da Máquina");
        JTextField numMaquinaField = new JTextField(10);
        JLabel nomeMaquinaLabel = new JLabel("Nome da Máquina");
        JTextField nomeMaquinaField = new JTextField(10);

        JButton cadastrarButton = new JButton("Cadastrar");
        JButton voltarButton = new JButton("Voltar");

        styleButton(cadastrarButton);
        styleButton(voltarButton);

        cadastrarButton.setPreferredSize(new Dimension(250, 50));
        voltarButton.setPreferredSize(new Dimension(250, 50));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(240, 248, 255));  
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50)); 

        panel.add(numMaquinaLabel);
        panel.add(numMaquinaField);
        panel.add(Box.createVerticalStrut(10)); 
        panel.add(nomeMaquinaLabel);
        panel.add(nomeMaquinaField);
        panel.add(Box.createVerticalStrut(20)); 
        panel.add(cadastrarButton);
        panel.add(Box.createVerticalStrut(10)); 
        panel.add(voltarButton);

        frame.add(titleLabel, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Coletando os dados dos campos
                    int numMaquina = Integer.parseInt(numMaquinaField.getText());  // Pode gerar exceção
                    String nomeMaquina = nomeMaquinaField.getText().trim();

                    // Verificando se o nome da máquina não está vazio
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
                    // Exibindo mensagem de erro caso o número da máquina não seja válido
                    JOptionPane.showMessageDialog(frame, "Número da máquina inválido! Por favor, insira um número inteiro.");
                } catch (Exception ex) {
                    // Exibindo qualquer outro erro genérico
                    JOptionPane.showMessageDialog(frame, "Erro ao cadastrar máquina: " + ex.getMessage());
                }
            }
        });

        // Ação do botão "Voltar"
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fechar a tela de cadastro de máquina e voltar para a tela principal (ou de listagem)
                frame.dispose();  // Fecha a janela atual (de cadastro de máquina)
                mainFrame.setVisible(true);  // Exibe a tela principal (passada como parâmetro)
            }
        });
    }

    // Método auxiliar para estilizar os botões
    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(0, 123, 255));  // Cor de fundo azul
        button.setForeground(Color.WHITE);  // Cor do texto branco
        button.setBorder(BorderFactory.createLineBorder(new Color(0, 123, 255), 2));
    }
}
