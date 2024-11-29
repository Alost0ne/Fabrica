package controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BD {
   public Connection con = null;
   public PreparedStatement st = null;
   public ResultSet rs = null;
   public final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
   public final String DATABASE = "fabrica";
   public final String URL = "jdbc:sqlserver://localhost:1433;databaseName=fabrica"; // Corrigido para databaseName
   public final String LOGIN = "sa";
   public final String SENHA = "123456SETE";

   public BD() {
   }

   public boolean getConnection() {
      try {
         // Carregando o driver JDBC
         Class.forName(DRIVER);
         System.out.println("Driver carregado!");

         // Tentando estabelecer a conexão
         this.con = DriverManager.getConnection(URL, LOGIN, SENHA);
         System.out.println("Conexão estabelecida com sucesso!");

         return true;
      } catch (ClassNotFoundException var2) {
         System.out.println("Driver não encontrado: " + var2.getMessage());
         return false;
      } catch (SQLException var3) {
         System.out.println("Falha na conexão: " + var3.getMessage());
         return false;
      }
   }

   public void close() {
      try {
         if (this.rs != null) {
            this.rs.close();
         }
      } catch (SQLException var4) {
         System.out.println("Erro ao fechar ResultSet: " + var4.getMessage());
      }

      try {
         if (this.st != null) {
            this.st.close();
         }
      } catch (SQLException var3) {
         System.out.println("Erro ao fechar Statement: " + var3.getMessage());
      }

      try {
         if (this.con != null) {
            System.out.println("Desconectou...");
            this.con.close();
         }
      } catch (SQLException var2) {
         System.out.println("Erro ao fechar a conexão: " + var2.getMessage());
      }
   }
}
