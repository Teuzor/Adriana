package org.example.dao;

import org.example.Imagem2.Ciclista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CiclistaDAO {
    public void inserirRegisto(Ciclista ciclista) {
        String sql = "INSERT INTO ciclista (nome, idade, usa_capacete) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoDAO.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, ciclista.getNome());
            stmt.setInt(2, ciclista.getIdade());
            stmt.setBoolean(3, ciclista.isUsaCapacete());
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}