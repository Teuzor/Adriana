package org.example.dao;

import org.example.Imagem2.Trilha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TrilhaDAO {
    public void inserirRegisto(Trilha trilha) {
        String sql = "INSERT INTO trilha (tipo_terreno, distancia_km, dificuldade) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoDAO.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, trilha.getTipoTerreno());
            stmt.setDouble(2, trilha.getDistanciaKm());
            stmt.setString(3, trilha.getDificuldade());
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}