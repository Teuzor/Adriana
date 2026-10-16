package org.example.Imagem3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import org.example.App;
import java.io.IOException;

public class Imagem3Controller {

    @FXML private TextArea txtResultado;

    @FXML
    void resultadoMascara(ActionEvent event) {
        Mascara mascara = new Mascara("Madeira", "Tribal Africana");
        mascara.expor();
        StringBuilder sb = new StringBuilder();
        sb.append("Material: ").append(mascara.getMaterial()).append("\n");
        sb.append("Origem: ").append(mascara.getOrigemCultural()).append("\n");
        sb.append("Exposta: ").append(mascara.isEstaExposta() ? "Sim" : "Não").append("\n");
        txtResultado.setText(sb.toString());
    }

    @FXML
    void resultadoEscultura(ActionEvent event) {
        Escultura escultura = new Escultura("Étnico", 45.0, 4.2);
        StringBuilder sb = new StringBuilder();
        sb.append("Estilo: ").append(escultura.getEstilo()).append("\n");
        sb.append("Altura: ").append(escultura.getAlturaCm()).append(" cm\n");
        sb.append("Peso: ").append(escultura.getPesoKg()).append(" kg\n");
        txtResultado.setText(sb.toString());
    }

    @FXML
    void resultadoPainel(ActionEvent event) {
        Painel painel = new Painel("Trança de Bambu");
        for (int i = 0; i < 15; i++) {
            painel.adicionarItem();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Textura: ").append(painel.getTexturaFundo()).append("\n");
        sb.append("Itens: ").append(painel.getQuantidadeItens()).append("\n");
        sb.append("Fixado: ").append(painel.isFixadoNaParede() ? "Sim" : "Não").append("\n");
        txtResultado.setText(sb.toString());
    }

    @FXML
    void voltarMenu(ActionEvent event) throws IOException {
        App.setRoot("Menu");
    }
}