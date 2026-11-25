package org.example.Imagem3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.example.App;
import java.io.IOException;

public class Imagem3Controller {

    @FXML
    private void abrirMascara(ActionEvent event) throws IOException {
        App.setRoot("mascara");
    }

    @FXML
    private void abrirEscultura(ActionEvent event) throws IOException {
        App.setRoot("escultura");
    }

    @FXML
    private void abrirPainel(ActionEvent event) throws IOException {
        App.setRoot("painel");
    }

    @FXML
    private void voltarMenu(ActionEvent event) throws IOException {
        App.setRoot("Menu");
    }
}