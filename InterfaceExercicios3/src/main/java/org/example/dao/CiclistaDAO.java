package org.example.dao;

import org.example.Imagem2.Ciclista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Ciclista> getLista() {
        List<Ciclista> lista = new ArrayList<>();
        String sql = "SELECT * FROM ciclista";
        try (Connection conn = ConexaoDAO.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Ciclista c = new Ciclista();
                c.setNome(rs.getString("nome"));
                c.setIdade(rs.getInt("idade"));
                c.setUsaCapacete(rs.getBoolean("usa_capacete"));
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void deletar(String nome) {
        String sql = "DELETE FROM ciclista WHERE nome = ?";
        try (Connection conn = ConexaoDAO.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}