package org.example.dao;

import org.example.Imagem2.Bicicleta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BicicletaDAO {
    public void inserirRegisto(Bicicleta bicicleta) {
        String sql = "INSERT INTO bicicleta (modelo, marcha_atual, velocidade) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoDAO.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, bicicleta.getModelo());
            stmt.setInt(2, bicicleta.getMarchaAtual());
            stmt.setDouble(3, bicicleta.getVelocidade());
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}