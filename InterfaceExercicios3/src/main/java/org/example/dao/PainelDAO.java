package org.example.dao;

import org.example.Imagem3.Painel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}