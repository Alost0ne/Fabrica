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
		sql = "INSERT INTO MATERIA_PRIMA VALUES (?,?,?)";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, materiaPrima.getCodigoMateriaPrima());
			bd.st.setString(2, materiaPrima.getNomeMateriaPrima());
			bd.st.setString(3, materiaPrima.getTipoMateriaPrima());
			bd.st.setDouble(4, materiaPrima.getQuantidadeMateriaPrima());
			bd.st.executeUpdate();
			men = "Materia-prima cadastrada com sucesso!";
		}catch(SQLException e) {
			men = "Falha no cadastro" + e;
		}finally {
			bd.close();
		}
		return men;
	}
	
	public String alterar(MateriaPrima materiaPrima) {
		sql = "INSERT INTO MATERIA_PRIMA VALUES (?,?,?,?)";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, materiaPrima.getCodigoMateriaPrima());
			bd.st.setString(2, materiaPrima.getNomeMateriaPrima());
			bd.st.setString(3, materiaPrima.getTipoMateriaPrima());
			bd.st.setDouble(4, materiaPrima.getQuantidadeMateriaPrima());
			bd.st.executeUpdate();
			men = "Materia-prima alterada com sucesso!";
		}catch(SQLException e) {
			sql = "UPDATE MATERIA_PRIMA SET NOME_MATERIA_PRIMA=?,TIPO_MATERIA_PRIMA=?, QUANTIDADE_MATERIA_PRIMA=? WHERE CODIGO_MATERIA_PRIMA=?";			
			try {
				bd.st = bd.con.prepareStatement(sql);
				bd.st.setInt(4, materiaPrima.getCodigoMateriaPrima());
				bd.st.setString(1, materiaPrima.getNomeMateriaPrima());
				bd.st.setString(2, materiaPrima.getTipoMateriaPrima());
				bd.st.setDouble(3, materiaPrima.getQuantidadeMateriaPrima());
				bd.st.executeUpdate();
				men = "Materia-prima alterada com sucesso!";
			}catch(SQLException erro) {
				men = "Falha" + erro;
			}
			men = "Falha no alterar" + e;
		}finally {
			bd.close();
		}
		System.out.println(men);
		return men;
	}
	
	public MateriaPrima obterMateriaPrima(int codigoMateriaPrima) {
		BD bd = new BD();
		MateriaPrima materiaPrima = null;

		String sql = "SELECT * FROM MATERIA_PRIMA WHERE CODIGO_MATERIA_PRIMA=?;";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, codigoMateriaPrima);
			bd.rs = bd.st.executeQuery();
			if (bd.rs.next()) {
				materiaPrima = new MateriaPrima(bd.rs.getInt("CODIGO_MATERIA_PRIMA"), 
						bd.rs.getString("NOME_MATERIA_PRIMA"), 
						bd.rs.getString("TIPO_MATERIA_PRIMA"), 
						bd.rs.getDouble("QUANTIDADE_MATERIA_PRIMA"));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			bd.close();
		}

		return materiaPrima;
	}

	public String excluir(Object codigoMateriaPrima) {
			sql = "DELETE FROM MATERIA_PRIMA WHERE CODIGO_MATERIA_PRIMA = ?";
			bd.getConnection();
			try {
				bd.st = bd.con.prepareStatement(sql);
				bd.st.setObject(1, codigoMateriaPrima);
				int n = bd.st.executeUpdate();
				System.out.println("Linhas excluídas: " + n);
				if (n == 1) {
					men = "Materia-prima excluída com sucesso!";
				} else {
					men = "Materia-prima não encontrada!";
				}
			} catch (SQLException e) {
				men = "Falha na exclusão" + e;
			} finally {
				bd.close();
			}
			return men;
		}
	
	public List<MateriaPrima> listarTodasMateriasPrimas() {
	    List<MateriaPrima> materiasPrimas = new ArrayList<>();

	    if (bd.getConnection()) {
	        String sql = "SELECT * FROM MATERIA_PRIMA";
	        try {
	            bd.st = bd.con.prepareStatement(sql);
	            bd.rs = bd.st.executeQuery();
	            while (bd.rs.next()) {
	                MateriaPrima materiaPrima = new MateriaPrima(
	                    bd.rs.getInt("CODIGO_MATERIA_PRIMA"),
	                    bd.rs.getString("NOME_MATERIA_PRIMA"),
	                    bd.rs.getString("TIPO_MATERIA_PRIMA"),
	                	bd.rs.getDouble("QUANTIDADE_MATERIA_PRIMA"));
	                materiasPrimas.add(materiaPrima);
	            }
	        } catch (SQLException e) {
	            System.out.println("Erro ao buscar Materias-primas: " + e.getMessage());
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
	    return materiasPrimas;
	}
	
}
