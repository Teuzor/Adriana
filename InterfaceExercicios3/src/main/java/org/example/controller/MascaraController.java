package org.example.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.App;
import org.example.Imagem3.Mascara;
import org.example.dao.MascaraDAO;

import java.io.IOException;

public class MascaraController {

    @FXML private TextField txtMaterial;
    @FXML private TextField txtOrigem;
    @FXML private CheckBox chkExposta;
    @FXML private TextField txtDeletar;

    @FXML private TableView<Mascara> tabelaMascaras;
    @FXML private TableColumn<Mascara, String> colMaterial;
    @FXML private TableColumn<Mascara, String> colOrigem;
    @FXML private TableColumn<Mascara, String> colExposta;

    private final MascaraDAO dao = new MascaraDAO();

    @FXML
    public void initialize() {
        colMaterial.setCellValueFactory(new PropertyValueFactory<>("material"));
        colOrigem.setCellValueFactory(new PropertyValueFactory<>("origemCultural"));
        colExposta.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().isEstaExposta() ? "Sim" : "Não"));

        atualizarListaNaTela();
    }

    @FXML
    void cadastrar(ActionEvent event) {
        try {
            String material = txtMaterial.getText();
            String origem = txtOrigem.getText();
            boolean exposta = chkExposta.isSelected();

            Mascara mascara = new Mascara(material, origem);
            if (exposta) mascara.expor();

            dao.inserirRegisto(mascara);
            atualizarListaNaTela();
            limparCampos();
            mostrarAlerta("Sucesso", "Máscara cadastrada com sucesso!");
        } catch (Exception e) {
            mostrarAlerta("Erro", "Verifique os dados preenchidos: " + e.getMessage());
        }
    }

    @FXML
    void deletar(ActionEvent event) {
        try {
            String material = txtDeletar.getText();
            if (material.isEmpty()) {
                mostrarAlerta("Aviso", "Digite o material da máscara para apagar.");
                return;
            }
            dao.deletar(material);
            atualizarListaNaTela();
            txtDeletar.clear();
            mostrarAlerta("Sucesso", "Máscara apagada com sucesso!");
        } catch (Exception e) {
            mostrarAlerta("Erro", "Não foi possível apagar: " + e.getMessage());
        }
    }

    @FXML
    void voltar(ActionEvent event) throws IOException {
        App.setRoot("Menu");
    }

    private void atualizarListaNaTela() {
        tabelaMascaras.setItems(FXCollections.observableArrayList(dao.getLista()));
    }

    private void limparCampos() {
        txtMaterial.clear();
        txtOrigem.clear();
        chkExposta.setSelected(false);
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}