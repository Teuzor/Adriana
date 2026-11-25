package org.example.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.App;
import org.example.Imagem3.Escultura;
import org.example.dao.EsculturaDAO;

import java.io.IOException;

public class EsculturaController {

    @FXML private TextField txtEstilo;
    @FXML private TextField txtAltura;
    @FXML private TextField txtPeso;
    @FXML private TextField txtDeletar;

    @FXML private TableView<Escultura> tabelaEsculturas;
    @FXML private TableColumn<Escultura, String> colEstilo;
    @FXML private TableColumn<Escultura, Double> colAltura;
    @FXML private TableColumn<Escultura, Double> colPeso;

    private final EsculturaDAO dao = new EsculturaDAO();

    @FXML
    public void initialize() {
        colEstilo.setCellValueFactory(new PropertyValueFactory<>("estilo"));
        colAltura.setCellValueFactory(new PropertyValueFactory<>("alturaCm"));
        colPeso.setCellValueFactory(new PropertyValueFactory<>("pesoKg"));

        atualizarListaNaTela();
    }

    @FXML
    void cadastrar(ActionEvent event) {
        try {
            String estilo = txtEstilo.getText();
            double altura = Double.parseDouble(txtAltura.getText());
            double peso = Double.parseDouble(txtPeso.getText());

            Escultura escultura = new Escultura(estilo, altura, peso);
            dao.inserirRegisto(escultura);
            atualizarListaNaTela();
            limparCampos();
            mostrarAlerta("Sucesso", "Escultura cadastrada com sucesso!");
        } catch (Exception e) {
            mostrarAlerta("Erro", "Verifique os dados preenchidos: " + e.getMessage());
        }
    }

    @FXML
    void deletar(ActionEvent event) {
        try {
            String estilo = txtDeletar.getText();
            if (estilo.isEmpty()) {
                mostrarAlerta("Aviso", "Digite o estilo da escultura para apagar.");
                return;
            }
            dao.deletar(estilo);
            atualizarListaNaTela();
            txtDeletar.clear();
            mostrarAlerta("Sucesso", "Escultura apagada com sucesso!");
        } catch (Exception e) {
            mostrarAlerta("Erro", "Não foi possível apagar: " + e.getMessage());
        }
    }

    @FXML
    void voltar(ActionEvent event) throws IOException {
        App.setRoot("Menu");
    }

    private void atualizarListaNaTela() {
        tabelaEsculturas.setItems(FXCollections.observableArrayList(dao.getLista()));
    }

    private void limparCampos() {
        txtEstilo.clear();
        txtAltura.clear();
        txtPeso.clear();
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}