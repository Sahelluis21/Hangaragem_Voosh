package org.sahthan.sahthan_v1.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.sahthan.sahthan_v1.application.MenuApllication;
import org.sahthan.sahthan_v1.model.Aeronave;
import org.sahthan.sahthan_v1.service.AeronaveService;

import java.io.IOException;

public class CadastrarAeronaveController {

    @FXML
    private TextField txtModelo;
    @FXML
    private TextField txtMatricula;
    @FXML
    private TextField txtFabricante;
    @FXML
    private TextField txtComprimento;
    @FXML
    private TextField txtLargura;
    @FXML
    private TextField txtAltura;
    @FXML
    private TextField txtPesoMedio;


    private final AeronaveService aeronaveService = new AeronaveService();

    @FXML
    private void onSalvar() {
        try {
            // 1. Coletar dados e converter tipos numéricos
            String modelo = txtModelo.getText();
            String matricula = txtMatricula.getText();
            String fabricante = txtFabricante.getText();
            double comprimento = Double.parseDouble(txtComprimento.getText());
            double largura = Double.parseDouble(txtLargura.getText());
            double altura = Double.parseDouble(txtAltura.getText());
            double peso = Double.parseDouble(txtPesoMedio.getText());


            Aeronave novoAeronave = new Aeronave(modelo, matricula, fabricante, comprimento, largura, peso, altura);


            aeronaveService.salvarAeronave(novoAeronave);


            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Modelo cadastrado com sucesso!");
            onLimpar();

        }catch (Exception e) {
            exibirAlerta(Alert.AlertType.ERROR, "Erro no Sistema", e.getMessage());
        }
    }

    @FXML
    private void onLimpar() {
        txtModelo.clear();
        txtMatricula.clear();
        txtFabricante.clear();
        txtComprimento.clear();
        txtLargura.clear();
        txtAltura.clear();
        txtPesoMedio.clear();
        txtMatricula.requestFocus();
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
