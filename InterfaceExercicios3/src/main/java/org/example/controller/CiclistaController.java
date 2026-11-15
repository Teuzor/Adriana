package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.App;
import org.example.Imagem2.Ciclista;
import org.example.dao.CiclistaDAO;

import java.io.IOException;
import java.util.List;

public class CiclistaController {

    @FXML private TextField txtNome;
    @FXML private TextField txtIdade;
    @FXML private CheckBox chkUsaCapacete;
    @FXML private TextField txtDeletar;
    @FXML private TextArea txtAreaLista;

    private final CiclistaDAO dao = new CiclistaDAO();

    @FXML
    public void initialize() {
        atualizarListaNaTela();
    }

    @FXML
    void cadastrar(ActionEvent event) {
        try {
            String nome = txtNome.getText();
            int idade = Integer.parseInt(txtIdade.getText());
            boolean usaCapacete = chkUsaCapacete.isSelected();

            Ciclista ciclista = new Ciclista(nome, idade);
            ciclista.setUsaCapacete(usaCapacete);

            dao.inserirRegisto(ciclista);
            atualizarListaNaTela();
            limparCampos();
            mostrarAlerta("Sucesso", "Ciclista cadastrado com sucesso!");
        } catch (Exception e) {
            mostrarAlerta("Erro", "Verifique os dados preenchidos: " + e.getMessage());
        }
    }

    @FXML
    void deletar(ActionEvent event) {
        try {
            String nome = txtDeletar.getText();
            if (nome.isEmpty()) {
                mostrarAlerta("Aviso", "Digite o nome do ciclista para apagar.");
                return;
            }
            dao.deletar(nome);
            atualizarListaNaTela();
            txtDeletar.clear();
            mostrarAlerta("Sucesso", "Ciclista apagado com sucesso!");
        } catch (Exception e) {
            mostrarAlerta("Erro", "Não foi possível apagar: " + e.getMessage());
        }
    }

    @FXML
    void voltar(ActionEvent event) throws IOException {
        App.setRoot("Menu");
    }

    private void atualizarListaNaTela() {
        List<Ciclista> lista = dao.getLista();
        StringBuilder sb = new StringBuilder();
        for (Ciclista c : lista) {
            sb.append("Nome: ").append(c.getNome())
                    .append(" | Idade: ").append(c.getIdade())
                    .append(" | Capacete: ").append(c.isUsaCapacete() ? "Sim" : "Não")
                    .append("\n----------------------------------------\n");
        }
        txtAreaLista.setText(sb.toString());
    }

    private void limparCampos() {
        txtNome.clear();
        txtIdade.clear();
        chkUsaCapacete.setSelected(false);
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}