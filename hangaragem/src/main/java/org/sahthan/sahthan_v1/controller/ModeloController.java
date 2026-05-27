package org.sahthan.sahthan_v1.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.sahthan.sahthan_v1.model.Modelo;
import org.sahthan.sahthan_v1.service.ModeloService;

public class ModeloController {

    @FXML
    private TextField txtNome;
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


    private final ModeloService service = new ModeloService();

    @FXML
    private void onSalvar() {
        try {
            // 1. Coletar dados e converter tipos numéricos
            String nome = txtNome.getText();
            String fabricante = txtFabricante.getText();
            double comprimento = Double.parseDouble(txtComprimento.getText());
            double largura = Double.parseDouble(txtLargura.getText());
            double altura = Double.parseDouble(txtAltura.getText());
            double peso = Double.parseDouble(txtPesoMedio.getText());


            Modelo novoModelo = new Modelo(nome, fabricante, comprimento, largura, peso, altura);


            service.salvarModelo(novoModelo);


            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Modelo cadastrado com sucesso!");
            onLimpar();

        } catch (NumberFormatException e) {
            exibirAlerta(Alert.AlertType.ERROR, "Erro de Preenchimento", "Verifique os campos numéricos (use ponto em vez de vírgula).");
        } catch (Exception e) {
            exibirAlerta(Alert.AlertType.ERROR, "Erro no Sistema", e.getMessage());
        }
    }

    @FXML
    private void onLimpar() {
        txtNome.clear();
        txtFabricante.clear();
        txtComprimento.clear();
        txtLargura.clear();
        txtAltura.clear();
        txtPesoMedio.clear();
        txtNome.requestFocus();
    }

    private void exibirAlerta(Alert.AlertType tipo, String titulo, String mensagem) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
}