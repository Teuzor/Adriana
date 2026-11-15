package org.example.Imagem2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.example.App;
import java.io.IOException;

public class Imagem2Controller {

    @FXML
    private void abrirCiclista(ActionEvent event) throws IOException {
        App.setRoot("ciclista");
    }

    @FXML
    private void abrirBicicleta(ActionEvent event) throws IOException {
        App.setRoot("bicicleta");
    }

    @FXML
    private void abrirTrilha(ActionEvent event) throws IOException {
        App.setRoot("trilha");
    }

    @FXML
    private void voltarMenu(ActionEvent event) throws IOException {
        App.setRoot("Menu");
    }
}