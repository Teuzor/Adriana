package org.example.dao;

import org.example.Imagem3.Painel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PainelDAO {
    public void inserirRegisto(Painel painel) {
        String sql = "INSERT INTO painel (quantidade_itens, textura_fundo, fixado_na_parede) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoDAO.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, painel.getQuantidadeItens());
            stmt.setString(2, painel.getTexturaFundo());
            stmt.setBoolean(3, painel.isFixadoNaParede());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Painel> getLista() {
        List<Painel> lista = new ArrayList<>();
        String sql = "SELECT * FROM painel";
        try (Connection conn = ConexaoDAO.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Painel p = new Painel();
                p.setQuantidadeItens(rs.getInt("quantidade_itens"));
                p.setTexturaFundo(rs.getString("textura_fundo"));
                p.setFixadoNaParede(rs.getBoolean("fixado_na_parede"));
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void deletar(String textura) {
        String sql = "DELETE FROM painel WHERE textura_fundo = ?";
        try (Connection conn = ConexaoDAO.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, textura);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}