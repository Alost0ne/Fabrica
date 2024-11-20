package model;

import java.sql.SQLException;

public class ProdutoDAO {

	public Produto produto;
	public BD bd;
	private String sql, men; // variaveis alxiliares
	
	public ProdutoDAO() {
	    bd = new BD(); // Cria uma nova instância de BD
	}
	
	public String cadastrar(Produto produto) {
		sql = "insert into produto values (?,?,?)";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, produto.getCodigoProduto());
			bd.st.setString(2, produto.getNomeProduto());
			bd.st.setString(3, produto.getTipo());
			bd.st.executeUpdate();
			men = "Produto cadastrado com sucesso!";
		}catch(SQLException e) {
			men = "Falha no cadastro" + e;
		}finally {
			bd.close();
		}
		return men;
	}
	
	public String alterar() {	
		sql = "insert into produto values (?,?,?)";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, produto.getCodigoProduto());
			bd.st.setString(2, produto.getNomeProduto());
			bd.st.setString(3, produto.getTipo());
			bd.st.executeUpdate();
			men = "Produto cadastrado com sucesso!";
		}catch(SQLException e) {
			men = "Falha no cadastro" + e;
			
			sql = "update produto values (?,?,?)";
			try {
				bd.st = bd.con.prepareStatement(sql);
				bd.st.setInt(1, produto.getCodigoProduto());
				bd.st.setString(2, produto.getNomeProduto());
				bd.st.setString(3, produto.getTipo());
				bd.st.executeUpdate();
				men = "Produto cadastrado com sucesso!";
			}catch(SQLException erro) {
				men = "Falha" + e.toString();
			}
		}finally {
			bd.close();
		}
		return men;
	}

	public String excluir(Object codigoProduto) {
			sql = "delete from produto where codigoProduto = ?";
			bd.getConnection();
			try {
				bd.st = bd.con.prepareStatement(sql);
				bd.st.setObject(1, codigoProduto);
				int n = bd.st.executeUpdate();
				System.out.println("Linhas excluídas: " + n);
				if (n == 1) {
					men = "Produto excluído com sucesso!";
				} else {
					men = "Produto não encontrado!";
				}
			} catch (SQLException e) {
				men = "Falha na exclusão" + e;
			} finally {
				bd.close();
			}
			return men;
		}
	
	
}
