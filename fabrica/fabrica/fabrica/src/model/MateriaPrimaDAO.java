package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controler.BD;

public class MateriaPrimaDAO {

    private BD bd;
    private String sql, men;

    public MateriaPrimaDAO() {
        bd = new BD();
    }

	public String cadastrar(MateriaPrima materiaPrima) {
		sql = "INSERT INTO MateriaPrima (nomeMateriaPrima, tipoMateriaPrima, quantidadeMateriaPrima) VALUES (?, ?, ?)";
		bd.getConnection(); // Abre a conexão
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, materiaPrima.getNomeMateriaPrima());
			bd.st.setString(2, materiaPrima.getTipoMateriaPrima());
			bd.st.setDouble(3, materiaPrima.getQuantidadeMateriaPrima());
			bd.st.executeUpdate();  // Executa o comando de inserção
			men = "Matéria-prima cadastrada com sucesso!";
		} catch (SQLException e) {
			men = "Falha no cadastro: " + e.getMessage();
		} finally {
			bd.close(); // Fecha a conexão
		}
		return men;
	}

    public String alterar(MateriaPrima materiaPrima) {
        sql = "UPDATE MateriaPrima SET nomeMateriaPrima=?, tipoMateriaPrima=?, quantidadeMateriaPrima=? WHERE codigoMateriaPrima=?";	
        bd.getConnection();
        try {
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setString(1, materiaPrima.getNomeMateriaPrima());
            bd.st.setString(2, materiaPrima.getTipoMateriaPrima());
            bd.st.setDouble(3, materiaPrima.getQuantidadeMateriaPrima());
            bd.st.setInt(4, materiaPrima.getCodigoMateriaPrima());
            bd.st.executeUpdate();
            men = "Matéria-prima alterada com sucesso!";
        } catch (SQLException e) {
            men = "Falha na alteração: " + e.getMessage();
        } finally {
            bd.close();
        }
        return men;
    }

    public MateriaPrima obterMateriaPrima(int codigoMateriaPrima) {
        BD bd = new BD();
        MateriaPrima materiaPrima = null;

        String sql = "SELECT * FROM MateriaPrima WHERE codigoMateriaPrima=?;";
        bd.getConnection();
        try {
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setInt(1, codigoMateriaPrima);
            bd.rs = bd.st.executeQuery();
            if (bd.rs.next()) {
                materiaPrima = new MateriaPrima(
						bd.rs.getInt("codigoMateriaPrima"),
                        bd.rs.getString("nomeMateriaPrima"),
                        bd.rs.getString("tipoMateriaPrima"),
                        bd.rs.getDouble("quantidadeMateriaPrima"));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            bd.close();
        }

        return materiaPrima;
    }

    public String excluir(Object codigoMateriaPrima) {
        sql = "DELETE FROM MateriaPrima WHERE codigoMateriaPrima = ?";
        bd.getConnection();
        try {
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setObject(1, codigoMateriaPrima);
            int n = bd.st.executeUpdate();
            if (n == 1) {
                men = "Matéria-prima excluída com sucesso!";
            } else {
                men = "Matéria-prima não encontrada!";
            }
        } catch (SQLException e) {
            men = "Falha na exclusão: " + e.getMessage();
        } finally {
            bd.close();
        }
        return men;
    }

    public List<MateriaPrima> listarTodasMateriasPrimas() {
        List<MateriaPrima> materiasPrimas = new ArrayList<>();

        if (bd.getConnection()) {
            String sql = "SELECT * FROM MateriaPrima";
            try {
                bd.st = bd.con.prepareStatement(sql);
                bd.rs = bd.st.executeQuery();
                while (bd.rs.next()) {
                    MateriaPrima materiaPrima = new MateriaPrima(
                            bd.rs.getInt("codigoMateriaPrima"),
                            bd.rs.getString("nomeMateriaPrima"),
                            bd.rs.getString("tipoMateriaPrima"),
                            bd.rs.getDouble("quantidadeMateriaPrima")
                    );
                    materiasPrimas.add(materiaPrima);
                }
            } catch (SQLException e) {
                System.out.println("Erro ao listar todas as matérias-primas: " + e.getMessage());
            } finally {
                bd.close();
            }
        }

        return materiasPrimas;
    }
}
