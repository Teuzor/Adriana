package org.example.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.App;
import org.example.Imagem2.Bicicleta;
import org.example.dao.BicicletaDAO;

import java.io.IOException;

public class BicicletaController {

    @FXML private TextField txtModelo;
    @FXML private TextField txtMarcha;
    @FXML private TextField txtVelocidade;
    @FXML private TextField txtDeletar;

    @FXML private TableView<Bicicleta> tabelaBicicletas;
    @FXML private TableColumn<Bicicleta, String> colModelo;
    @FXML private TableColumn<Bicicleta, Integer> colMarcha;
    @FXML private TableColumn<Bicicleta, Double> colVelocidade;

    private final BicicletaDAO dao = new BicicletaDAO();

    @FXML
    public void initialize() {
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        colMarcha.setCellValueFactory(new PropertyValueFactory<>("marchaAtual"));
        colVelocidade.setCellValueFactory(new PropertyValueFactory<>("velocidade"));

        atualizarListaNaTela();
    }

    @FXML
    void cadastrar(ActionEvent event) {
        try {
            String modelo = txtModelo.getText();
            int marcha = Integer.parseInt(txtMarcha.getText());
            double velocidade = Double.parseDouble(txtVelocidade.getText());

            Bicicleta bicicleta = new Bicicleta(modelo, marcha, velocidade);
            dao.inserirRegisto(bicicleta);
            atualizarListaNaTela();
            limparCampos();
            mostrarAlerta("Sucesso", "Bicicleta cadastrada com sucesso!");
        } catch (Exception e) {
            mostrarAlerta("Erro", "Verifique os dados preenchidos: " + e.getMessage());
        }
    }

    @FXML
    void deletar(ActionEvent event) {
        try {
            String modelo = txtDeletar.getText();
            if (modelo.isEmpty()) {
                mostrarAlerta("Aviso", "Digite o modelo da bicicleta para apagar.");
                return;
            }
            dao.deletar(modelo);
            atualizarListaNaTela();
            txtDeletar.clear();
            mostrarAlerta("Sucesso", "Bicicleta apagada com sucesso!");
        } catch (Exception e) {
            mostrarAlerta("Erro", "Não foi possível apagar: " + e.getMessage());
        }
    }

    @FXML
    void voltar(ActionEvent event) throws IOException {
        App.setRoot("Menu");
    }

    private void atualizarListaNaTela() {
        tabelaBicicletas.setItems(FXCollections.observableArrayList(dao.getLista()));
    }

    private void limparCampos() {
        txtModelo.clear();
        txtMarcha.clear();
        txtVelocidade.clear();
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}