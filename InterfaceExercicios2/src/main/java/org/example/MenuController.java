package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class MenuController {

    @FXML
    private void abrirImagem1(ActionEvent event) throws IOException { App.setRoot("Imagem1"); }

    @FXML
    private void abrirImagem2(ActionEvent event) throws IOException { App.setRoot("Imagem2"); }

    @FXML
    private void abrirImagem3(ActionEvent event) throws IOException { App.setRoot("Imagem3"); }

    @FXML
    private void abrirImagem4(ActionEvent event) throws IOException { App.setRoot("Imagem4"); }


}
