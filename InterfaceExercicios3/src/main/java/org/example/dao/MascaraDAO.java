package org.example.dao;

import org.example.Imagem3.Mascara;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}