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
            frame.setLayout(new BorderLayout(10, 20)); // Usando BorderLayout para facilitar a centralização

            // Definindo a cor de fundo da janela
            frame.getContentPane().setBackground(new Color(240, 248, 255)); // Azul claro

            // Título da tela (Fábrica)
            JLabel titleLabel = new JLabel("Fábrica", JLabel.CENTER);
            titleLabel.setFont(new Font("Arial", Font.BOLD, 24));  // Tamanho maior para o título
            titleLabel.setForeground(new Color(0, 123, 255));  // Azul vibrante
            titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Espaçamento ao redor do título

            // Criando os botões
            JButton cadastroMaquinaButton = new JButton("Cadastro de Máquina");
            JButton cadastroMateriaPrimaButton = new JButton("Cadastro de Matéria Prima");
            JButton cadastroOrdemProducaoButton = new JButton("Cadastro de Ordem de Produção");
            JButton cadastroProdutoButton = new JButton("Cadastro de Produto");

            // Estilizando os botões
            styleButton(cadastroMaquinaButton);
            styleButton(cadastroMateriaPrimaButton);
            styleButton(cadastroOrdemProducaoButton);
            styleButton(cadastroProdutoButton);

            // Definindo o tamanho dos botões
            cadastroMaquinaButton.setPreferredSize(new Dimension(250, 50));
            cadastroMateriaPrimaButton.setPreferredSize(new Dimension(250, 50));
            cadastroOrdemProducaoButton.setPreferredSize(new Dimension(250, 50));
            cadastroProdutoButton.setPreferredSize(new Dimension(250, 50));

            // Painel para os botões (centraliza os botões verticalmente)
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS)); // Layout vertical
            buttonPanel.setBackground(new Color(240, 248, 255));  // Mesmo fundo da janela
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50)); // Espaçamento interno

            // Adicionando os botões no painel
            buttonPanel.add(cadastroMaquinaButton);
            buttonPanel.add(Box.createVerticalStrut(10));  // Espaçamento entre os botões
            buttonPanel.add(cadastroMateriaPrimaButton);
            buttonPanel.add(Box.createVerticalStrut(10));  // Espaçamento entre os botões
            buttonPanel.add(cadastroOrdemProducaoButton);
            buttonPanel.add(Box.createVerticalStrut(10));  // Espaçamento entre os botões
            buttonPanel.add(cadastroProdutoButton);

            // Adicionando o título e o painel de botões à janela
            frame.add(titleLabel, BorderLayout.NORTH);
            frame.add(buttonPanel, BorderLayout.CENTER);

            // Definindo o tamanho da janela
            frame.setSize(400, 500); // Aumentando a altura para acomodar o novo botão

            // Centralizando a janela
            frame.setLocationRelativeTo(null);

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
                    new CadastroMateriaPrimaScreen(frame);  // Passando a tela principal (IndexScreen)
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

            // Ação do botão "Cadastro de Produto"
            cadastroProdutoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Fechar a tela principal e abrir a tela de Cadastro de Produto
                    frame.dispose();  // Fechar a tela principal
                    new CadastroProdutoScreen(frame);  // Passando a tela principal (IndexScreen)
                }
            });
        }

        // Método para estilizar os botões
        private static void styleButton(JButton button) {
            button.setFont(new Font("Arial", Font.BOLD, 16)); // Definir uma fonte maior e mais forte
            button.setBackground(new Color(0, 123, 255)); // Cor de fundo azul vibrante
            button.setForeground(Color.WHITE); // Cor da fonte branca
            button.setFocusPainted(false); // Remover o contorno ao clicar
            button.setBorder(BorderFactory.createLineBorder(new Color(0, 123, 255), 2)); // Bordas azuis
        }
    }
