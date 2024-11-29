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

        // Layout para o conteúdo da tela
        frame.setLayout(new FlowLayout());

        // Criando os componentes da tela (exemplo simples)
        JLabel numMaquinaLabel = new JLabel("Número da Máquina");
        JTextField numMaquinaField = new JTextField(10);
        JLabel nomeMaquinaLabel = new JLabel("Nome da Máquina");
        JTextField nomeMaquinaField = new JTextField(10);

        // Botão para cadastrar
        JButton cadastrarButton = new JButton("Cadastrar");

        // Botão para voltar à tela principal
        JButton voltarButton = new JButton("Voltar");

        // Adicionando os componentes à tela
        frame.add(numMaquinaLabel);
        frame.add(numMaquinaField);
        frame.add(nomeMaquinaLabel);
        frame.add(nomeMaquinaField);
        frame.add(cadastrarButton);
        frame.add(voltarButton);

        // Tamanho da janela de cadastro
        frame.setSize(300, 200);

        // Tornar a janela visível
        frame.setVisible(true);

        // Ação do botão "Cadastrar"
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Coletando os dados dos campos
                int numMaquina = Integer.parseInt(numMaquinaField.getText());
                String nomeMaquina = nomeMaquinaField.getText();

                // Criando o objeto Maquina
                Maquina maquina = new Maquina(numMaquina, nomeMaquina);

                // Criando uma instância de MaquinaDAO para cadastrar a máquina
                MaquinaDAO maquinaDAO = new MaquinaDAO();
                String mensagem = maquinaDAO.cadastrar(maquina);

                // Exibindo a mensagem de retorno do cadastro
                JOptionPane.showMessageDialog(frame, mensagem);
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
}
