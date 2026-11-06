package org.example.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/adrianabd";
    private static final String USER = "root";
    private static final String PASSWORD = "melissa111";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}