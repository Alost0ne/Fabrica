package model;

import java.sql.SQLException;

import controler.BD;

public class OrdemProducaoDAO {

    private BD bd; // Instância da classe BD
    private String sql; // Variável auxiliar para SQL
    
    // Construtor para inicializar a conexão com o banco de dados
    public OrdemProducaoDAO() {
        bd = new BD(); // Cria uma nova instância de BD
    }

    // Método para cadastrar uma nova ordem de produção
    public String cadastrar(OrdemProducao ordemProducao) {
        String sqlVerificaProduto = "SELECT COUNT(*) FROM PRODUTO WHERE codigoProduto = ?";
		String sqlInsereOrdem = "INSERT INTO ORDEM_PRODUCAO (codigoProduto, numMaquina, quantidadeProduto) VALUES (?, ?, ?, ?)";
        String mensagem = "";

        bd.getConnection(); // Conecta ao banco
        try {
            // Passo 1: Verificar se o Produto existe
            bd.st = bd.con.prepareStatement(sqlVerificaProduto);
            bd.st.setInt(1, ordemProducao.getProduto().getCodigoProduto()); // ID do Produto
            bd.rs = bd.st.executeQuery();

            // Verifica se o produto existe
            if (bd.rs.next() && bd.rs.getInt(1) > 0) {
                // Produto existe, prosseguir com a inserção
                bd.st = bd.con.prepareStatement(sqlInsereOrdem);
                bd.st.setInt(2, ordemProducao.getProduto().getCodigoProduto()); // Código do Produto
                bd.st.setInt(3, ordemProducao.getMaquina().getNumMaquina()); // ID da Máquina
                bd.st.setDouble(4, ordemProducao.getQtdProducao());   // Quantidade de Produção
                bd.st.executeUpdate(); // Executa a inserção

                mensagem = "Ordem de produção cadastrada com sucesso!";
            } else {
                // Produto não encontrado
                mensagem = "Produto não cadastrado no sistema. Cadastre o Produto antes de criar a Ordem de Produção.";
            }
        } catch (SQLException e) {
            // Caso ocorra um erro
            mensagem = "Falha no cadastro: " + e.getMessage();
        } finally {
            bd.close(); // Fecha a conexão com o banco
        }
        return mensagem;
    }

    // Método para excluir uma ordem de produção
    public String excluir(int numOrdemProducao) {
        sql = "DELETE FROM ORDEM_PRODUCAO WHERE NUMERO_ORDEM_PRODUCAO = ?";
        String mensagem = "";

        bd.getConnection(); // Conecta ao banco
        try {
            // Executa o comando DELETE
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setInt(1, numOrdemProducao);
            int rowsAffected = bd.st.executeUpdate(); // Executa a exclusão

            // Verifica se a exclusão foi bem-sucedida
            if (rowsAffected > 0) {
                mensagem = "Ordem de produção excluída com sucesso!";
            } else {
                mensagem = "Ordem de Produção não encontrada no sistema.";
            }
        } catch (SQLException e) {
            // Caso ocorra um erro
            mensagem = "Falha na exclusão: " + e.getMessage();
        } finally {
            bd.close(); // Fecha a conexão com o banco
        }
        return mensagem;
    }

    // Método de produção - Este método ainda precisa ser implementado
    public void produzir() {
        // Implementação necessária conforme os requisitos
    }
}
