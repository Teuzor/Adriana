package org.example.dao;

import org.example.Imagem3.Escultura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EsculturaDAO {
    public void inserirRegisto(Escultura escultura) {
        String sql = "INSERT INTO escultura (estilo, altura_cm, peso_kg) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoDAO.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, escultura.getEstilo());
            stmt.setDouble(2, escultura.getAlturaCm());
            stmt.setDouble(3, escultura.getPesoKg());
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}