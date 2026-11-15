package org.example.dao;

import org.example.Imagem3.Mascara;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MascaraDAO {
    public void inserirRegisto(Mascara mascara) {
        String sql = "INSERT INTO mascara (material, origem_cultural, esta_exposta) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoDAO.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, mascara.getMaterial());
            stmt.setString(2, mascara.getOrigemCultural());
            stmt.setBoolean(3, mascara.isEstaExposta());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Mascara> getLista() {
        List<Mascara> lista = new ArrayList<>();
        String sql = "SELECT * FROM mascara";
        try (Connection conn = ConexaoDAO.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Mascara m = new Mascara();
                m.setMaterial(rs.getString("material"));
                m.setOrigemCultural(rs.getString("origem_cultural"));
                m.setEstaExposta(rs.getBoolean("esta_exposta"));
                lista.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void deletar(String material) {
        String sql = "DELETE FROM mascara WHERE material = ?";
        try (Connection conn = ConexaoDAO.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, material);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}