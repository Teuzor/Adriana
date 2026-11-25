package org.example.dao;

import org.example.Imagem3.Escultura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Escultura> getLista() {
        List<Escultura> lista = new ArrayList<>();
        String sql = "SELECT * FROM escultura";
        try (Connection conn = ConexaoDAO.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Escultura e = new Escultura();
                e.setEstilo(rs.getString("estilo"));
                e.setAlturaCm(rs.getDouble("altura_cm"));
                e.setPesoKg(rs.getDouble("peso_kg"));
                lista.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void deletar(String estilo) {
        String sql = "DELETE FROM escultura WHERE estilo = ?";
        try (Connection conn = ConexaoDAO.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, estilo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}