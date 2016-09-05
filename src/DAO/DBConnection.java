package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    
	private static final String URL_MYSQL = "jdbc:mysql://localhost/dsiii";
    private static final String DRIVER_CLASS_MYSQL = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASS = "";
 
    public static Connection getConnection() {
        System.out.println("Conectando ao Banco de Dados!");
        try {
            Class.forName(DRIVER_CLASS_MYSQL);
            return DriverManager.getConnection(URL_MYSQL, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
 
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (conn!= null) {
                conn.close();
            }
 
            if (stmt!= null) {
                stmt.close();
            }
 
            if (rs!= null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public static void createTables() {
        Connection connection = getConnection();
        PreparedStatement stmt = null;
        String sql = "CREATE TABLE IF NOT EXISTS Aluno("
        		+ "Matricula INT UNSIGNED AUTO_INCREMENT Primary key,"
        		+ "Nome VARCHAR(100) NOT NULL,"
        		+ "CPF VARCHAR(15) NOT NULL,"
        		+ "DT_Nascimento DATE NOT NULL,"
        		+ "Sexo VARCHAR(10) NOT NULL "
        		+ ");";
        
        try {
            stmt = connection.prepareStatement(sql);
            stmt.execute();
            System.out.println("Tabelas Criadas com Sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, stmt, null);
        }
    }
}
