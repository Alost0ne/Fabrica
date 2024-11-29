package model;

import java.sql.SQLException;

import controler.BD;

public class MaquinaDAO {

	private BD bd;
	private String sql, men; // variaveis alxiliares
	
	public MaquinaDAO() {
	    bd = new BD(); // Cria uma nova instância de BD
	}
	
	public String cadastrar(Maquina maquina) {
		sql = "insert into maquina values (?,?)";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, maquina.getNumMaquina());
			bd.st.setString(2, maquina.getNomeMaquina());
			bd.st.executeUpdate();
			men = "Máquina cadastrada com sucesso!";
		}catch(SQLException e) {
			men = "Falha no cadastro" + e;
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
					men = "Máquina excluída com sucesso!";
				} else {
					men = "Máquina não encontrada!";
				}
			} catch (SQLException e) {
				men = "Falha na exclusão" + e;
			} finally {
				bd.close();
			}
			return men;
		}
	
}
