package model;

import java.sql.SQLException;

public class ProdutoDAO {

	public Produto produto;
	public BD bd;
	private String sql, men; // variaveis alxiliares
	
	public ProdutoDAO() {
	    bd = new BD(); // Cria uma nova instância de BD
	}
	
	public String inserir(Produto produto) {
		sql = "insert into produto values (?,?)";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, produto.getCodigoProduto());
			bd.st.setString(2, produto.getNomeProduto());
			bd.st.executeUpdate();
			men = "Produto inserido com sucesso!";
		}catch(SQLException e) {
			men = "Falha na inclusão" + e;
		}finally {
			bd.close();
		}
		return men;
	}
	
	public String alterar() {	
		// TODO Auto-generated method stub
		return null;
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
				men = "Falha" + e;
			} finally {
				bd.close();
			}
			return men;
		}
	
	
}
