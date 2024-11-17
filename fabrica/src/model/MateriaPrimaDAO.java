package model;

import java.sql.SQLException;

public class MateriaPrimaDAO {

	private MateriaPrima materiaPrima;
	private BD bd;
	private String sql, men; // variaveis alxiliares
	
	public MateriaPrimaDAO() {
	    bd = new BD(); // Cria uma nova instância de BD
	}
	
	public String inserir(MateriaPrima materiaPrima) {
		sql = "insert into materiaPrima values (?,?)";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, materiaPrima.getCodMateriaPrima());
			bd.st.setString(2, materiaPrima.getNomeMateriaPrima());
			bd.st.executeUpdate();
			men = "Materia-prima inserido com sucesso!";
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

	public String excluir(Object codMateriaPrima) {
			sql = "delete from materiaPrima where codMateriaPrima = ?";
			bd.getConnection();
			try {
				bd.st = bd.con.prepareStatement(sql);
				bd.st.setObject(1, codMateriaPrima);
				int n = bd.st.executeUpdate();
				System.out.println("Linhas excluídas: " + n);
				if (n == 1) {
					men = "Materia-prima excluída com sucesso!";
				} else {
					men = "Materia-prima não encontrada!";
				}
			} catch (SQLException e) {
				men = "Falha" + e;
			} finally {
				bd.close();
			}
			return men;
		}
}
