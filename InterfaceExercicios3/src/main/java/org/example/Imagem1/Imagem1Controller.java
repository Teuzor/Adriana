package org.example.Imagem1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import org.example.App;
import java.io.IOException;

public class Imagem1Controller {

    @FXML private TextArea txtResultado;

    @FXML
    void resultadoLoja(ActionEvent event) {
        Loja loja = new Loja("Dorinho's", "São José dos Campos");
        loja.abrir();
        StringBuilder sb = new StringBuilder();
        sb.append("Nome da loja: ").append(loja.getNome()).append("\n");
        sb.append("Cidade: ").append(loja.getCidade()).append("\n");
        sb.append("Status: ").append(loja.isAberta() ? "Aberta" : "Fechada").append("\n");
        txtResultado.setText(sb.toString());
    }

    @FXML
    void resultadoManequim(ActionEvent event) {
        Manequim manequim = new Manequim("Fachada", "Terno Completo");
        manequim.alternarDestaque();
        StringBuilder sb = new StringBuilder();
        sb.append("Posição: ").append(manequim.getPosicao()).append("\n");
        sb.append("Roupa Vestida: ").append(manequim.getRoupaVestida()).append("\n");
        sb.append("Em Destaque: ").append(manequim.isEmDestaque() ? "Sim" : "Não").append("\n");
        txtResultado.setText(sb.toString());
    }

    @FXML
    void resultadoTerno(ActionEvent event) {
        Terno terno = new Terno("Azul Marinho", "M", 650.00);
        terno.aplicarDesconto(15);
        StringBuilder sb = new StringBuilder();
        sb.append("Cor: ").append(terno.getCor()).append("\n");
        sb.append("Tamanho: ").append(terno.getTamanho()).append("\n");
        sb.append("Preço: R$ ").append(terno.getPreco()).append("\n");
        txtResultado.setText(sb.toString());
    }

    @FXML
    void voltarMenu(ActionEvent event) throws IOException {
        App.setRoot("Menu");
    }
}