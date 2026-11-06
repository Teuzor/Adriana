package org.example.Imagem2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import org.example.App;
import org.example.dao.BicicletaDAO;
import org.example.dao.CiclistaDAO;
import org.example.dao.TrilhaDAO;

import java.io.IOException;

public class Imagem2Controller {

    @FXML private TextArea txtResultado;

    private void mostrarAlerta(String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Sucesso");
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }

    @FXML
    void resultadoCiclista(ActionEvent event) {
        Ciclista ciclista = new Ciclista("Carlos", 30);

        CiclistaDAO dao = new CiclistaDAO();
        dao.inserirRegisto(ciclista);

        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(ciclista.getNome()).append("\n");
        sb.append("Idade: ").append(ciclista.getIdade()).append("\n");
        sb.append("Usa Capacete: ").append(ciclista.isUsaCapacete() ? "Sim" : "Não").append("\n");
        txtResultado.setText(sb.toString());

        mostrarAlerta("Ciclista salvo no banco de dados!");
    }

    @FXML
    void resultadoBicicleta(ActionEvent event) {
        Bicicleta bike = new Bicicleta("Mountain Bike", 3, 15.0);
        bike.acelerar(5.5);

        BicicletaDAO dao = new BicicletaDAO();
        dao.inserirRegisto(bike);

        StringBuilder sb = new StringBuilder();
        sb.append("Modelo: ").append(bike.getModelo()).append("\n");
        sb.append("Marcha: ").append(bike.getMarchaAtual()).append("\n");
        sb.append("Velocidade: ").append(bike.getVelocidade()).append(" km/h\n");
        txtResultado.setText(sb.toString());

        mostrarAlerta("Bicicleta salva no banco de dados!");
    }

    @FXML
    void resultadoTrilha(ActionEvent event) {
        Trilha trilha = new Trilha("Terra batida", 18.0, "Moderada");

        TrilhaDAO dao = new TrilhaDAO();
        dao.inserirRegisto(trilha);

        StringBuilder sb = new StringBuilder();
        sb.append("Terreno: ").append(trilha.getTipoTerreno()).append("\n");
        sb.append("Distância: ").append(trilha.getDistanciaKm()).append(" km\n");
        sb.append("Dificuldade: ").append(trilha.getDificuldade()).append("\n");
        txtResultado.setText(sb.toString());

        mostrarAlerta("Trilha salva no banco de dados!");
    }

    @FXML
    void voltarMenu(ActionEvent event) throws IOException {
        App.setRoot("Menu");
    }
}