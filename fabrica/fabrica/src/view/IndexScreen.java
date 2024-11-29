package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IndexScreen {

    public static void main(String[] args) {
        // Criando a janela principal (JFrame)
        JFrame frame = new JFrame("Tela Inicial");

        // Definindo a operação padrão para o fechamento da janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Definindo o layout para o conteúdo da tela
        frame.setLayout(new FlowLayout());

        // Criando os botões
        JButton cadastroMaquinaButton = new JButton("Cadastro de Máquina");
        JButton cadastroMateriaPrimaButton = new JButton("Cadastro de Matéria Prima");
        JButton cadastroOrdemProducaoButton = new JButton("Cadastro de Ordem de Produção");

        // Definindo o tamanho dos botões
        cadastroMaquinaButton.setPreferredSize(new Dimension(200, 50));
        cadastroMateriaPrimaButton.setPreferredSize(new Dimension(200, 50));
        cadastroOrdemProducaoButton.setPreferredSize(new Dimension(200, 50));

        // Adicionando os botões na janela
        frame.add(cadastroMaquinaButton);
        frame.add(cadastroMateriaPrimaButton);
        frame.add(cadastroOrdemProducaoButton);

        // Definindo o tamanho da janela
        frame.setSize(400, 400);

        // Tornando a janela visível
        frame.setVisible(true);

        // Ação do botão "Cadastro de Máquina"
        cadastroMaquinaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fechar a tela principal e abrir a tela de Cadastro de Máquina
                frame.dispose();  // Fechar a tela principal
                new CadastroMaquinaScreen(frame);  // Passando a tela principal (IndexScreen)
            }
        });

        // Ação do botão "Cadastro de Matéria Prima"
        cadastroMateriaPrimaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fechar a tela principal e abrir a tela de Cadastro de Matéria Prima
                frame.dispose();  // Fechar a tela principal
                // new CadastroMateriaPrimaScreen(frame);  // Passando a tela principal (IndexScreen)
            }
        });

        // Ação do botão "Cadastro de Ordem de Produção"
        cadastroOrdemProducaoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fechar a tela principal e abrir a tela de Cadastro de Ordem de Produção
                frame.dispose();  // Fechar a tela principal
                // new CadastroOrdemProducaoScreen(frame);  // Passando a tela principal (IndexScreen)
            }
        });
    }
}
