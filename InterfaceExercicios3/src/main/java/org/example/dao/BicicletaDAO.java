package org.example.dao;

import org.example.Imagem2.Bicicleta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Bicicleta> getLista() {
        List<Bicicleta> lista = new ArrayList<>();
        String sql = "SELECT * FROM bicicleta";
        try (Connection conn = ConexaoDAO.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Bicicleta b = new Bicicleta();
                b.setModelo(rs.getString("modelo"));
                b.setMarchaAtual(rs.getInt("marcha_atual"));
                b.setVelocidade(rs.getDouble("velocidade"));
                lista.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void deletar(String modelo) {
        String sql = "DELETE FROM bicicleta WHERE modelo = ?";
        try (Connection conn = ConexaoDAO.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, modelo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}