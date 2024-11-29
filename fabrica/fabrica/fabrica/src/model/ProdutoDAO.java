package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controler.BD;

public class ProdutoDAO {

	public Produto produto;
	public BD bd;
	private String sql, men; // variaveis alxiliares
	
	public ProdutoDAO() {
	    bd = new BD(); // Cria uma nova instância de BD
	}
	
	public String cadastrar(Produto produto) {
		sql = "INSERT INTO PRODUTO VALUES (?,?,?,?)";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, produto.getCodigoProduto());
			bd.st.setString(2, produto.getNomeProduto());
			bd.st.setString(3, produto.getTipoProduto());
			bd.st.setDouble(4, produto.getQuantidadeProduto());
			bd.st.executeUpdate();
			men = "Produto cadastrado com sucesso!";
		}catch(SQLException e) {
			men = "Falha no cadastro" + e;
		}finally {
			bd.close();
		}
		System.out.println(men);
		return men;
	}
	
	public String alterar(Produto produto) {
		sql = "INSERT INTO PRODUTO VALUES (?,?,?,?)";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, produto.getCodigoProduto());
			bd.st.setString(2, produto.getNomeProduto());
			bd.st.setString(3, produto.getTipoProduto());
			bd.st.setDouble(4, produto.getQuantidadeProduto());
			bd.st.executeUpdate();
			men = "Produto cadastrado com sucesso!";
		}catch(SQLException e) {
			sql = "UPDATE PRODUTO SET NOME_PRODUTO=?,TIPO_PRODUTO=?, QUANTIDADE_PRODUTO=? WHERE CODIGO_PRODUTO=?";			
			try {
				bd.st = bd.con.prepareStatement(sql);
				bd.st.setInt(4, produto.getCodigoProduto());
				bd.st.setString(1, produto.getNomeProduto());
				bd.st.setString(2, produto.getTipoProduto());
				bd.st.setDouble(3, produto.getQuantidadeProduto());
				bd.st.executeUpdate();
				men = "Produto alterado com sucesso!";
			}catch(SQLException erro) {
				men = "Falha" + erro;
			}
			men = "Falha no cadastro" + e;
		}finally {
			bd.close();
		}
		System.out.println(men);
		return men;
	}
	
	public Produto obterProduto(int codigoProduto) {
		BD bd = new BD();
		Produto produto = null;

		String sql = "SELECT * FROM PRODUTO WHERE CODIGO_PRODUTO=?;";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, codigoProduto);
			bd.rs = bd.st.executeQuery();
			if (bd.rs.next()) {
				produto = new Produto(bd.rs.getInt("CODIGO_PRODUTO"), 
						bd.rs.getString("NOME_PRODUTO"), 
						bd.rs.getString("TIPO_PRODUTO"), 
						bd.rs.getDouble("QUANTIDADE_PRODUTO"));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			bd.close();
		}

		return produto;
	}

	public String excluir(Object codigoProduto) {
			sql = "DELETE FROM PRODUTO WHERE CODIGO_PRODUTO = ?";
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
			System.out.println(men);
			return men;
		}
	
	public List<Produto> listarTodosProdutos() {
	    List<Produto> produtos = new ArrayList<>();

	    if (bd.getConnection()) {
	        String sql = "SELECT * FROM produto";
	        try {
	            bd.st = bd.con.prepareStatement(sql);
	            bd.rs = bd.st.executeQuery();
	            while (bd.rs.next()) {
	                Produto produto = new Produto(
	                    bd.rs.getInt("CODIGO_PRODUTO"),
	                    bd.rs.getString("NOME_PRODUTO"),
	                    bd.rs.getString("TIPO_PRODUTO"),
	                	bd.rs.getDouble("QUANTIDADE_PRODUTO"));
	                produtos.add(produto);
	            }
	        } catch (SQLException e) {
	            System.out.println("Erro ao buscar produtos: " + e.getMessage());
	        } finally {
	            try {
	                if (bd.rs != null) bd.rs.close();
	                if (bd.st != null) bd.st.close();
	                if (bd.con != null) bd.con.close();
	            } catch (SQLException e) {
	                System.out.println("Erro ao fechar recursos: " + e.getMessage());
	            }
	        }
	    } else {
	        System.out.println("Falha na conexão.");
	    }
	    return produtos;
	}
	
	/*public List<String> listarProduto(String tipoProduto) {
		List<String> produtos = new ArrayList<String>();
		produtos.add("-- selecione um tipo --");
		if (bd.getConnection()) {
			String sql = "SELECT * FROM PRODUTO";
			try {
				bd.st = bd.con.prepareStatement(sql);
				bd.st.setString(3, tipoProduto);
				bd.rs = bd.st.executeQuery();

				while (bd.rs.next()) {
					produtos.add(bd.rs.getString("semestre_disciplina") + "° SEM");
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				bd.close();
			}
		} else {
			System.out.println("Falha na conexão.");
		}

		return produtos;
	}*/
	
	/*public List<String> listarTodosCodigosProdutos() {
	    List<String> produtos = new ArrayList<>();
	    //produtos.add("-- selecione um produto --");

	    if (bd.getConnection()) {
	        String sql = "SELECT * FROM produto"; // Query para listar todos os produtos
	        try {
	            bd.st = bd.con.prepareStatement(sql);
	            bd.rs = bd.st.executeQuery();

	            while (bd.rs.next()) {
	                produtos.add(bd.rs.getString("codigo_produto"));
	            }
	        } catch (SQLException e) {
	            System.out.println("Erro ao buscar produtos: " + e.getMessage());
	        } finally {
	            try {
	                if (bd.rs != null) bd.rs.close();
	                if (bd.st != null) bd.st.close();
	                if (bd.con != null) bd.con.close();
	            } catch (SQLException e) {
	                System.out.println("Erro ao fechar recursos: " + e.getMessage());
	            }
	        }
	    } else {
	        System.out.println("Falha na conexão.");
	    }

	    return produtos;
	}*/

	
}
