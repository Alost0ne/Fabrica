package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.MaquinaDAO;
import model.Maquina;
import model.ProdutoDAO;
import model.Produto;
import model.OrdemProducao;
import model.OrdemProducaoDAO;

public class CadastroOrdemProducaoScreen {

    private JFrame frame;
    private JTextField txtNumOrdem;
    private JComboBox<Produto> cmbProduto;
    private JComboBox<Maquina> cmbMaquina;
    private JTextField txtQuantidade;
    private OrdemProducaoDAO ordemProducaoDAO;

    public CadastroOrdemProducaoScreen(JFrame mainFrame) {
        ordemProducaoDAO = new OrdemProducaoDAO(); // Instância do DAO

        // Criando a janela de cadastro
        frame = new JFrame("Cadastro de Ordem de Produção");

        // Definindo a operação de fechamento
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Layout da janela
        frame.setLayout(new BorderLayout(10, 20));

        // Definindo a cor de fundo da janela
        frame.getContentPane().setBackground(new Color(240, 248, 255));

        // Título da tela
        JLabel titleLabel = new JLabel("Cadastro de Ordem de Produção", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0, 123, 255));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // Painel para campos do formulário
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        panel.setBackground(new Color(240, 248, 255));

        // Campos de entrada
        JLabel lblNumOrdem = new JLabel("Número da Ordem:");
        txtNumOrdem = new JTextField(10);
        
        JLabel lblProduto = new JLabel("Produto:");
        cmbProduto = new JComboBox<>();
        carregarProdutos();
        
        JLabel lblMaquina = new JLabel("Máquina:");
        cmbMaquina = new JComboBox<>();
        carregarMaquinas();
        
        JLabel lblQuantidade = new JLabel("Quantidade de Produção:");
        txtQuantidade = new JTextField(10);

        // Adicionando os campos ao painel
        panel.add(lblNumOrdem);
        panel.add(txtNumOrdem);
        panel.add(lblProduto);
        panel.add(cmbProduto);
        panel.add(lblMaquina);
        panel.add(cmbMaquina);
        panel.add(lblQuantidade);
        panel.add(txtQuantidade);

        // Botões de ação
        JButton btnSalvar = new JButton("Salvar");
        JButton btnCancelar = new JButton("Cancelar");

        // Estilizando os botões
        styleButton(btnSalvar);
        styleButton(btnCancelar);

        // Painel de botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(240, 248, 255));
        buttonPanel.add(btnSalvar);
        buttonPanel.add(btnCancelar);

        // Adicionando componentes à janela
        frame.add(titleLabel, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Tamanho da janela
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); // Centraliza a janela
        frame.setVisible(true);

        // Ação do botão "Salvar"
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarOrdem();
            }
        });

        // Ação do botão "Cancelar"
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Fecha a janela de cadastro
            }
        });
    }

    // Método para carregar os produtos no JComboBox
    private void carregarProdutos() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        for (Produto produto : produtoDAO.listarTodosProdutos()) {
            cmbProduto.addItem(produto);
        }
    }

    // Método para carregar as máquinas no JComboBox
    private void carregarMaquinas() {
        MaquinaDAO maquinaDAO = new MaquinaDAO();
        for (Maquina maquina : maquinaDAO.listarMaquinas()) {
            cmbMaquina.addItem(maquina);
        }
    }

    // Método para salvar a ordem de produção
    private void salvarOrdem() {
        Produto produtoSelecionado = (Produto) cmbProduto.getSelectedItem();
        Maquina maquinaSelecionada = (Maquina) cmbMaquina.getSelectedItem();
        String quantidadeStr = txtQuantidade.getText();

        // Verificar se os campos estão preenchidos corretamente
        if (produtoSelecionado == null || maquinaSelecionada == null || quantidadeStr.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos corretamente!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Convertendo a quantidade para um tipo numérico
            double quantidade = Double.parseDouble(quantidadeStr);

            // Criar a ordem de produção
            OrdemProducao ordemProducao = new OrdemProducao();
            ordemProducao.setProduto(produtoSelecionado);
            ordemProducao.setMaquina(maquinaSelecionada);
            ordemProducao.setQtdProducao(quantidade);

            // Definir o número da ordem de produção
            int numeroOrdemProducao = Integer.parseInt(txtNumOrdem.getText()); // Assumindo que é um número inteiro
            ordemProducao.setNumOrdemProducao(numeroOrdemProducao);

            // Agora, insira a ordem de produção no banco de dados
            String mensagem = ordemProducaoDAO.cadastrar(ordemProducao);
            
            // Mostrar a mensagem ao usuário
            JOptionPane.showMessageDialog(frame, mensagem, "Cadastro de Ordem de Produção", JOptionPane.INFORMATION_MESSAGE);

            // Limpar os campos se o cadastro for bem-sucedido
            if (mensagem.equals("Ordem de produção cadastrada com sucesso!")) {
                txtNumOrdem.setText("");
                cmbProduto.setSelectedIndex(0);
                cmbMaquina.setSelectedIndex(0);
                txtQuantidade.setText("");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Quantidade inválida. Por favor, insira um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para estilizar o botão
    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(0, 123, 255));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }
}
