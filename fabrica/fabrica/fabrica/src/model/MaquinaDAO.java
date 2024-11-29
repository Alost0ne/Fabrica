package model;

import java.sql.SQLException;
import controler.BD;

public class MaquinaDAO {

    private BD bd;
    private String sql, men; // Variáveis auxiliares

    public MaquinaDAO() {
        bd = new BD(); // Cria uma nova instância de BD
    }

    // Método para cadastrar máquina
    public String cadastrar(Maquina maquina) {
        sql = "INSERT INTO maquina (numMaquina, nomeMaquina) VALUES (?, ?)";
        
        if (!bd.getConnection()) {  // Verifica se a conexão foi bem-sucedida
            return "Falha na conexão com o banco de dados!";
        }

        try {
            // Prepare o statement
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setInt(1, maquina.getNumMaquina());
            bd.st.setString(2, maquina.getNomeMaquina());
            int rowsAffected = bd.st.executeUpdate();
    
            if (rowsAffected > 0) {
                return "Máquina cadastrada com sucesso!";
            } else {
                return "Falha no cadastro: Nenhuma linha afetada.";
            }
        } catch (SQLException e) {
            return "Falha no cadastro: " + e.getMessage();
        } finally {
            bd.close();  // Fecha a conexão
        }
    }

    // Método para excluir máquina
    public String excluir(Object numMaquina) {
        sql = "DELETE FROM maquina WHERE numMaquina = ?";
        
        if (!bd.getConnection()) {  // Verifica se a conexão foi bem-sucedida
            return "Falha na conexão com o banco de dados!";
        }

        try {
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setObject(1, numMaquina);
            int rowsAffected = bd.st.executeUpdate();

            if (rowsAffected == 1) {
                return "Máquina excluída com sucesso!";
            } else {
                return "Máquina não encontrada!";
            }
        } catch (SQLException e) {
            return "Falha na exclusão: " + e.getMessage();
        } finally {
            bd.close();  // Fecha a conexão
        }
    }
}
