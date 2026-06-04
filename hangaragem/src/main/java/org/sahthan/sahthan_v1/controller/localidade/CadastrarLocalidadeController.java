package org.sahthan.sahthan_v1.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.sahthan.sahthan_v1.application.MenuApllication;
import org.sahthan.sahthan_v1.model.Aeronave;
import org.sahthan.sahthan_v1.model.Localidade;
import org.sahthan.sahthan_v1.service.AeronaveService;
import org.sahthan.sahthan_v1.service.LocalidadeService;

import java.io.IOException;

public class CadastrarLocalidadeController {

    @FXML
    private TextField txtNomeAeroporto;
    @FXML
    private TextField txtnPistas;
    @FXML
    private TextField txtCidade;
    @FXML
    private TextField txtUF;

    private final LocalidadeService localidadeService = new LocalidadeService();

    @FXML
    private void onSalvar() {
        try {

            String nomeAeroporto = txtNomeAeroporto.getText();
            String uf = txtCidade.getText();
            String cidade = txtUF.getText();
            int nPistas = Integer.parseInt(txtnPistas.getText());


            Localidade novaLocalidade = new Localidade(nomeAeroporto, nPistas, cidade, uf);


            localidadeService.inserirLocalidade(novaLocalidade);


            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Modelo cadastrado com sucesso!");
            onLimpar();

        }catch (Exception e) {
            exibirAlerta(Alert.AlertType.ERROR, "Erro no Sistema", e.getMessage());
        }
    }

    @FXML
    private void onLimpar() {
        txtNomeAeroporto.clear();
        txtnPistas.clear();
        txtCidade.clear();
        txtUF.clear();
    }

    private void exibirAlerta(Alert.AlertType tipo, String titulo, String mensagem) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }

    @FXML
    public void voltarMenu(ActionEvent event) {
        try {
            MenuApllication app = new MenuApllication();

            Stage stageAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();

            app.start(stageAtual);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
