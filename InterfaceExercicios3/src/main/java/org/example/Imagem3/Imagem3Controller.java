package org.example.Imagem3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import org.example.App;
import org.example.dao.EsculturaDAO;
import org.example.dao.MascaraDAO;
import org.example.dao.PainelDAO;

import java.io.IOException;

public class Imagem3Controller {

    @FXML private TextArea txtResultado;

    private void mostrarAlerta(String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Sucesso");
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }

    @FXML
    void resultadoMascara(ActionEvent event) {
        Mascara mascara = new Mascara("Madeira", "Tribal Africana");
        mascara.expor();

        MascaraDAO dao = new MascaraDAO();
        dao.inserirRegisto(mascara);

        StringBuilder sb = new StringBuilder();
        sb.append("Material: ").append(mascara.getMaterial()).append("\n");
        sb.append("Origem: ").append(mascara.getOrigemCultural()).append("\n");
        sb.append("Exposta: ").append(mascara.isEstaExposta() ? "Sim" : "Não").append("\n");
        txtResultado.setText(sb.toString());

        mostrarAlerta("Máscara salva no banco de dados!");
    }

    @FXML
    void resultadoEscultura(ActionEvent event) {
        Escultura escultura = new Escultura("Étnico", 45.0, 4.2);

        EsculturaDAO dao = new EsculturaDAO();
        dao.inserirRegisto(escultura);

        StringBuilder sb = new StringBuilder();
        sb.append("Estilo: ").append(escultura.getEstilo()).append("\n");
        sb.append("Altura: ").append(escultura.getAlturaCm()).append(" cm\n");
        sb.append("Peso: ").append(escultura.getPesoKg()).append(" kg\n");
        txtResultado.setText(sb.toString());

        mostrarAlerta("Escultura salva no banco de dados!");
    }

    @FXML
    void resultadoPainel(ActionEvent event) {
        Painel painel = new Painel("Trança de Bambu");
        for (int i = 0; i < 15; i++) {
            painel.adicionarItem();
        }

        PainelDAO dao = new PainelDAO();
        dao.inserirRegisto(painel);

        StringBuilder sb = new StringBuilder();
        sb.append("Textura: ").append(painel.getTexturaFundo()).append("\n");
        sb.append("Itens: ").append(painel.getQuantidadeItens()).append("\n");
        sb.append("Fixado: ").append(painel.isFixadoNaParede() ? "Sim" : "Não").append("\n");
        txtResultado.setText(sb.toString());

        mostrarAlerta("Painel salvo no banco de dados!");
    }

    @FXML
    void voltarMenu(ActionEvent event) throws IOException {
        App.setRoot("Menu");
    }
}