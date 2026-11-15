package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.App;
import org.example.Imagem2.Bicicleta;
import org.example.dao.BicicletaDAO;

import java.io.IOException;
import java.util.List;

public class BicicletaController {

    @FXML private TextField txtModelo;
    @FXML private TextField txtMarcha;
    @FXML private TextField txtVelocidade;
    @FXML private TextField txtDeletar;
    @FXML private TextArea txtAreaLista;

    private final BicicletaDAO dao = new BicicletaDAO();

    @FXML
    public void initialize() {
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
        List<Bicicleta> lista = dao.getLista();
        StringBuilder sb = new StringBuilder();
        for (Bicicleta b : lista) {
            sb.append("Modelo: ").append(b.getModelo())
                    .append(" | Marcha: ").append(b.getMarchaAtual())
                    .append(" | Velocidade: ").append(b.getVelocidade()).append(" km/h")
                    .append("\n----------------------------------------\n");
        }
        txtAreaLista.setText(sb.toString());
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