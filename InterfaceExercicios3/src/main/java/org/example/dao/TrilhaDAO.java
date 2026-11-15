package org.example.dao;

import org.example.Imagem2.Trilha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Trilha> getLista() {
        List<Trilha> lista = new ArrayList<>();
        String sql = "SELECT * FROM trilha";
        try (Connection conn = ConexaoDAO.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Trilha t = new Trilha();
                t.setTipoTerreno(rs.getString("tipo_terreno"));
                t.setDistanciaKm(rs.getDouble("distancia_km"));
                t.setDificuldade(rs.getString("dificuldade"));
                lista.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void deletar(String terreno) {
        String sql = "DELETE FROM trilha WHERE tipo_terreno = ?";
        try (Connection conn = ConexaoDAO.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, terreno);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}