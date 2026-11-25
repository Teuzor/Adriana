package org.example.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.App;
import org.example.Imagem2.Trilha;
import org.example.dao.TrilhaDAO;

import java.io.IOException;

public class TrilhaController {

    @FXML private TextField txtTerreno;
    @FXML private TextField txtDistancia;
    @FXML private TextField txtDificuldade;
    @FXML private TextField txtDeletar;

    @FXML private TableView<Trilha> tabelaTrilhas;
    @FXML private TableColumn<Trilha, String> colTerreno;
    @FXML private TableColumn<Trilha, Double> colDistancia;
    @FXML private TableColumn<Trilha, String> colDificuldade;

    private final TrilhaDAO dao = new TrilhaDAO();

    @FXML
    public void initialize() {
        colTerreno.setCellValueFactory(new PropertyValueFactory<>("tipoTerreno"));
        colDistancia.setCellValueFactory(new PropertyValueFactory<>("distanciaKm"));
        colDificuldade.setCellValueFactory(new PropertyValueFactory<>("dificuldade"));

        atualizarListaNaTela();
    }

    @FXML
    void cadastrar(ActionEvent event) {
        try {
            String terreno = txtTerreno.getText();
            double distancia = Double.parseDouble(txtDistancia.getText());
            String dificuldade = txtDificuldade.getText();

            Trilha trilha = new Trilha(terreno, distancia, dificuldade);
            dao.inserirRegisto(trilha);
            atualizarListaNaTela();
            limparCampos();
            mostrarAlerta("Sucesso", "Trilha cadastrada com sucesso!");
        } catch (Exception e) {
            mostrarAlerta("Erro", "Verifique os valores preenchidos: " + e.getMessage());
        }
    }

    @FXML
    void deletar(ActionEvent event) {
        try {
            String terreno = txtDeletar.getText();
            if (terreno.isEmpty()) {
                mostrarAlerta("Aviso", "Digite o terreno da trilha para apagar.");
                return;
            }
            dao.deletar(terreno);
            atualizarListaNaTela();
            txtDeletar.clear();
            mostrarAlerta("Sucesso", "Trilha apagada com sucesso!");
        } catch (Exception e) {
            mostrarAlerta("Erro", "Não foi possível apagar: " + e.getMessage());
        }
    }

    @FXML
    void voltar(ActionEvent event) throws IOException {
        App.setRoot("Menu");
    }

    private void atualizarListaNaTela() {
        tabelaTrilhas.setItems(FXCollections.observableArrayList(dao.getLista()));
    }

    private void limparCampos() {
        txtTerreno.clear();
        txtDistancia.clear();
        txtDificuldade.clear();
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}