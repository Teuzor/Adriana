package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.App;
import org.example.Imagem3.Painel;
import org.example.dao.PainelDAO;

import java.io.IOException;
import java.util.List;

public class PainelController {

    @FXML private TextField txtTextura;
    @FXML private TextField txtQtdItens;
    @FXML private CheckBox chkFixado;
    @FXML private TextField txtDeletar;
    @FXML private TextArea txtAreaLista;

    private final PainelDAO dao = new PainelDAO();

    @FXML
    public void initialize() {
        atualizarListaNaTela();
    }

    @FXML
    void cadastrar(ActionEvent event) {
        try {
            String textura = txtTextura.getText();
            int qtdItens = Integer.parseInt(txtQtdItens.getText());
            boolean fixado = chkFixado.isSelected();

            Painel painel = new Painel(textura);
            for (int i = 0; i < qtdItens; i++) {
                painel.adicionarItem();
            }
            painel.setFixadoNaParede(fixado);

            dao.inserirRegisto(painel);
            atualizarListaNaTela();
            limparCampos();
            mostrarAlerta("Sucesso", "Painel cadastrado com sucesso!");
        } catch (Exception e) {
            mostrarAlerta("Erro", "Verifique os dados preenchidos: " + e.getMessage());
        }
    }

    @FXML
    void deletar(ActionEvent event) {
        try {
            String textura = txtDeletar.getText();
            if (textura.isEmpty()) {
                mostrarAlerta("Aviso", "Digite a textura do painel para apagar.");
                return;
            }
            dao.deletar(textura);
            atualizarListaNaTela();
            txtDeletar.clear();
            mostrarAlerta("Sucesso", "Painel apagado com sucesso!");
        } catch (Exception e) {
            mostrarAlerta("Erro", "Não foi possível apagar: " + e.getMessage());
        }
    }

    @FXML
    void voltar(ActionEvent event) throws IOException {
        App.setRoot("Menu");
    }

    private void atualizarListaNaTela() {
        List<Painel> lista = dao.getLista();
        StringBuilder sb = new StringBuilder();
        for (Painel p : lista) {
            sb.append("Textura: ").append(p.getTexturaFundo())
                    .append(" | Itens: ").append(p.getQuantidadeItens())
                    .append(" | Fixado: ").append(p.isFixadoNaParede() ? "Sim" : "Não")
                    .append("\n----------------------------------------\n");
        }
        txtAreaLista.setText(sb.toString());
    }

    private void limparCampos() {
        txtTextura.clear();
        txtQtdItens.clear();
        chkFixado.setSelected(false);
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}