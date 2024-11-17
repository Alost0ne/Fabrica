package model;

import java.sql.SQLException;

public class MaquinaDAO {

	private Maquina maquina;
	private BD bd;
	private String sql, men; // variaveis alxiliares
	
	public MaquinaDAO() {
	    bd = new BD(); // Cria uma nova instância de BD
	}
	
	public String inserir(Maquina maquina) {
		sql = "insert into maquina values (?,?)";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, maquina.getNumMaquina());
			bd.st.setString(2, maquina.getNomeMaquina());
			bd.st.executeUpdate();
			men = "Máquina inserida com sucesso!";
		}catch(SQLException e) {
			men = "Falha na inclusão" + e;
		}finally {
			bd.close();
		}
		return men;
	}

	public String excluir(Object numMaquina) {
			sql = "delete from maquina where numMaquina = ?";
			bd.getConnection();
			try {
				bd.st = bd.con.prepareStatement(sql);
				bd.st.setObject(1, numMaquina);
				int n = bd.st.executeUpdate();
				System.out.println("Linhas excluídas: " + n);
				if (n == 1) {
					men = "Máquina excluído com sucesso!";
				} else {
					men = "Máquina não encontrada!";
				}
			} catch (SQLException e) {
				men = "Falha" + e;
			} finally {
				bd.close();
			}
			return men;
		}
	
}
