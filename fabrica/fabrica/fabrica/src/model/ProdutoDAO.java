package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import controler.BD;

public class ProdutoDAO {

    private BD bd;
    private String sql, men; // Variáveis auxiliares

    public ProdutoDAO() {
        bd = new BD(); // Cria uma nova instância de BD
    }

    // Método para cadastrar um novo produto
    public String cadastrar(Produto produto) {
        sql = "INSERT INTO PRODUTO (codigoProduto, nomeProduto, tipoProduto, quantidadeProduto) VALUES (?, ?, ?, ?)";
        bd.getConnection();
        try {
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setInt(1, produto.getCodigoProduto());
            bd.st.setString(2, produto.getNomeProduto());
            bd.st.setString(3, produto.getTipoProduto());
            bd.st.setDouble(4, produto.getQuantidadeProduto());
            bd.st.executeUpdate();
            men = "Produto cadastrado com sucesso!";
        } catch (SQLException e) {
            men = "Falha no cadastro: " + e.getMessage();
        } finally {
            bd.close();
        }
        System.out.println(men);
        return men;
    }

    // Método para alterar um produto existente
    public String alterar(Produto produto) {
        sql = "UPDATE PRODUTO SET NOME_PRODUTO=?, TIPO_PRODUTO=?, QUANTIDADE_PRODUTO=? WHERE CODIGO_PRODUTO=?";
        bd.getConnection();
        try {
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setString(1, produto.getNomeProduto());
            bd.st.setString(2, produto.getTipoProduto());
            bd.st.setDouble(3, produto.getQuantidadeProduto());
            bd.st.setInt(4, produto.getCodigoProduto());
            bd.st.executeUpdate();
            men = "Produto alterado com sucesso!";
        } catch (SQLException e) {
            men = "Falha na atualização: " + e.getMessage();
        } finally {
            bd.close();
        }
        System.out.println(men);
        return men;
    }

    // Método para obter um produto pelo código
    public Produto obterProduto(int codigoProduto) {
        Produto produto = null;
        sql = "SELECT * FROM PRODUTO WHERE CODIGO_PRODUTO=?";
        bd.getConnection();
        try {
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setInt(1, codigoProduto);
            bd.rs = bd.st.executeQuery();
            if (bd.rs.next()) {
                produto = new Produto(
                        bd.rs.getInt("CODIGO_PRODUTO"),
                        bd.rs.getString("NOME_PRODUTO"),
                        bd.rs.getString("TIPO_PRODUTO"),
                        bd.rs.getDouble("QUANTIDADE_PRODUTO")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar produto: " + e.getMessage());
        } finally {
            bd.close();
        }
        return produto;
    }

    // Método para excluir um produto
    public String excluir(int codigoProduto) {
        sql = "DELETE FROM PRODUTO WHERE codigoProduto=?";
        bd.getConnection();
        try {
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setInt(1, codigoProduto);
            int n = bd.st.executeUpdate();
            if (n == 1) {
                men = "Produto excluído com sucesso!";
            } else {
                men = "Produto não encontrado!";
            }
        } catch (SQLException e) {
            men = "Falha na exclusão: " + e.getMessage();
        } finally {
            bd.close();
        }
        return men;
    }

    // Método para listar todos os produtos
    public List<Produto> listarTodosProdutos() {
        List<Produto> produtos = new ArrayList<>();
        sql = "SELECT * FROM PRODUTO";
        bd.getConnection();
        try {
            bd.st = bd.con.prepareStatement(sql);
            bd.rs = bd.st.executeQuery();
            while (bd.rs.next()) {
                Produto produto = new Produto(
                        bd.rs.getInt("codigoProduto"),
                        bd.rs.getString("nomeProduto"),
                        bd.rs.getString("tipoProduto"),
                        bd.rs.getDouble("quantidadeProduto")
                );
                produtos.add(produto);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
        } finally {
            bd.close();
        }
        return produtos;
    }
}
