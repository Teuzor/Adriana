package org.example.Imagem4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import org.example.App;
import java.io.IOException;

public class Imagem4Controller {

    @FXML private TextArea txtResultado;

    @FXML
    void resultadoTraco(ActionEvent event) {
        Traco traco = new Traco(0.3, "Preto Nanquim", false);
        traco.engrossar(0.2);
        StringBuilder sb = new StringBuilder();
        sb.append("Cor: ").append(traco.getCor()).append("\n");
        sb.append("Espessura: ").append(traco.getEspessuraMm()).append(" mm\n");
        sb.append("Suave: ").append(traco.isEhSuave() ? "Sim" : "Não").append("\n");
        txtResultado.setText(sb.toString());
    }

    @FXML
    void resultadoModeloCabelo(ActionEvent event) {
        ModeloCabelo cabelo = new ModeloCabelo("Anime Spiky", "Curto", true);
        StringBuilder sb = new StringBuilder();
        sb.append("Estilo: ").append(cabelo.getEstilo()).append("\n");
        sb.append("Comprimento: ").append(cabelo.getComprimento()).append("\n");
        sb.append("Franja: ").append(cabelo.isPossuiFranja() ? "Sim" : "Não").append("\n");
        txtResultado.setText(sb.toString());
    }

    @FXML
    void resultadoReferencia(ActionEvent event) {
        Referencia ref = new Referencia("Pinterest", "Anatomia / Cabelos", true);
        StringBuilder sb = new StringBuilder();
        sb.append("Fonte: ").append(ref.getFonte()).append("\n");
        sb.append("Categoria: ").append(ref.getCategoria()).append("\n");
        sb.append("Digital: ").append(ref.isEhDigital() ? "Sim" : "Não").append("\n");
        txtResultado.setText(sb.toString());
    }

    @FXML
    void voltarMenu(ActionEvent event) throws IOException {
        App.setRoot("Menu");
    }
}