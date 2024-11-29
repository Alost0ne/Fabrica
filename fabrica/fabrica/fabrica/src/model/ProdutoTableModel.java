package model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ProdutoTableModel extends AbstractTableModel {

    private List<Produto> produtos;  // Lista de produtos
    private String[] colunas = {"Código", "Nome", "Tipo", "Quantidade"};  // Nomes das colunas da tabela

    public ProdutoTableModel() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        this.produtos = produtoDAO.listarTodosProdutos();  // Carregando os produtos ao inicializar o modelo
    }

    @Override
    public int getRowCount() {
        return produtos.size();  // Retorna o número de produtos
    }

    @Override
    public int getColumnCount() {
        return colunas.length;  // Retorna o número de colunas
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto produto = produtos.get(rowIndex);  // Obtendo o produto pela linha

        switch (columnIndex) {
            case 0:
                return produto.getCodigoProduto();  // Código do produto
            case 1:
                return produto.getNomeProduto();  // Nome do produto
            case 2:
                return produto.getTipoProduto();  // Tipo do produto
            case 3:
                return produto.getQuantidadeProduto();  // Quantidade do produto
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];  // Retorna o nome da coluna
    }

    // Método para atualizar a tabela após alterações
    public void atualizarTabela() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        this.produtos = produtoDAO.listarTodosProdutos();  // Recarregando a lista de produtos
        fireTableDataChanged();  // Notifica que os dados foram alterados e a tabela precisa ser atualizada
    }
}
