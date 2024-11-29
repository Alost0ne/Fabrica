package model;

import controler.BD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaquinaDAO {

    private BD bd;
    private String sql; // Variável auxiliar para consulta SQL

    public MaquinaDAO() {
        bd = new BD(); // Cria uma nova instância de BD
    }

    // Método para cadastrar máquina
    public String cadastrar(Maquina maquina) {
        sql = "INSERT INTO maquina (numMaquina, nomeMaquina) VALUES (?, ?)";

        if (!bd.getConnection()) {  // Verifica se a conexão foi bem-sucedida
            return "Falha na conexão com o banco de dados!";
        }

        try (PreparedStatement st = bd.con.prepareStatement(sql)) {
            st.setInt(1, maquina.getNumMaquina());
            st.setString(2, maquina.getNomeMaquina());
            int rowsAffected = st.executeUpdate();

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

        try (PreparedStatement st = bd.con.prepareStatement(sql)) {
            st.setObject(1, numMaquina);
            int rowsAffected = st.executeUpdate();

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

    // Método para listar todas as máquinas
    public List<Maquina> listarMaquinas() {
        List<Maquina> maquinas = new ArrayList<>();
        sql = "SELECT * FROM maquina"; // Consulta SQL para selecionar todas as máquinas

        if (!bd.getConnection()) {  // Verifica se a conexão foi bem-sucedida
            System.out.println("Falha na conexão com o banco de dados!");
            return maquinas;
        }

        try (PreparedStatement st = bd.con.prepareStatement(sql); ResultSet rs = st.executeQuery()) {
            // Preenche a lista de máquinas com os dados do banco
            while (rs.next()) {
                Maquina maquina = new Maquina(
                        rs.getInt("numMaquina"),
                        rs.getString("nomeMaquina")
                );
                maquinas.add(maquina);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar máquinas: " + e.getMessage());
        } finally {
            bd.close();  // Fecha a conexão
        }

        return maquinas;  // Retorna a lista de máquinas
    }
}
