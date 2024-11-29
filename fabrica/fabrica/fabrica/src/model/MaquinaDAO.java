package model;

import java.sql.SQLException;
import controler.BD;

public class MaquinaDAO {

    private BD bd;
    private String sql, men; // variáveis auxiliares

    public MaquinaDAO() {
        bd = new BD(); // Cria uma nova instância de BD
    }

    public String cadastrar(Maquina maquina) {
        sql = "INSERT INTO maquina (numMaquina, nomeMaquina) VALUES (?, ?)";
        bd.getConnection(); // Estabelece a conexão

        try {
            if (bd.con != null) {
                // Prepare o statement
                bd.st = bd.con.prepareStatement(sql);
                bd.st.setInt(1, maquina.getNumMaquina());
                bd.st.setString(2, maquina.getNomeMaquina());
                int rowsAffected = bd.st.executeUpdate();

                if (rowsAffected > 0) {
                    men = "Máquina cadastrada com sucesso!";
                } else {
                    men = "Falha no cadastro: Nenhuma linha afetada.";
                }
            } else {
                men = "Falha na conexão com o banco de dados!";
            }
        } catch (SQLException e) {
            men = "Falha no cadastro: " + e.getMessage();
        } finally {
            bd.close(); // Fecha a conexão
        }
        return men;
    }

    public String excluir(Object numMaquina) {
        sql = "DELETE FROM maquina WHERE numMaquina = ?";
        bd.getConnection(); // Estabelece a conexão

        try {
            if (bd.con != null) {
                bd.st = bd.con.prepareStatement(sql);
                bd.st.setObject(1, numMaquina);
                int rowsAffected = bd.st.executeUpdate();

                if (rowsAffected == 1) {
                    men = "Máquina excluída com sucesso!";
                } else {
                    men = "Máquina não encontrada!";
                }
            } else {
                men = "Falha na conexão com o banco de dados!";
            }
        } catch (SQLException e) {
            men = "Falha na exclusão: " + e.getMessage();
        } finally {
            bd.close(); // Fecha a conexão
        }
        return men;
    }
}
