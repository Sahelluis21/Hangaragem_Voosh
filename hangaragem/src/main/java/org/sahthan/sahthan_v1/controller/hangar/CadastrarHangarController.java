package org.sahthan.sahthan_v1.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.sahthan.sahthan_v1.application.MenuApllication;
import org.sahthan.sahthan_v1.model.Hangar;
import org.sahthan.sahthan_v1.model.Localidade;
import org.sahthan.sahthan_v1.model.StatusHangar;
import org.sahthan.sahthan_v1.service.HangarService;
import org.sahthan.sahthan_v1.service.LocalidadeService;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static org.sahthan.sahthan_v1.model.StatusHangar.DISPONIVEL;
import static org.sahthan.sahthan_v1.model.StatusHangar.LOCADO;

public class CadastrarHangarController implements Initializable {

    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtAltura;
    @FXML
    private TextField txtComprimento;
    @FXML
    private TextField txtLargura;

    LocalidadeService localidadeService = new LocalidadeService();
    HangarService hangarService = new HangarService();

    //combo box para exibir localidades existentes
    @FXML
    private ComboBox<Localidade> comboLocalidade;

    private List<Localidade> listaLocalidade;

    private ObservableList<Localidade> observableListLocalidade;

    public void carregarComboBox(){

        listaLocalidade = localidadeService.listarLocalidade();

        //carrega observable list com as localidade para serem exibidads
        observableListLocalidade = FXCollections.observableArrayList(listaLocalidade);

        comboLocalidade.setItems(observableListLocalidade);
    }

    @FXML
    private void onSalvar() {
        try {

            String nome = txtNome.getText();
            int altura = Integer.parseInt(txtAltura.getText());
            int largura = Integer.parseInt(txtLargura.getText());
            int comprimento = Integer.parseInt(txtComprimento.getText());
            StatusHangar statusHangar = DISPONIVEL;

            Localidade localidade = comboLocalidade.getSelectionModel().getSelectedItem();


            Hangar novohangar = new Hangar(nome, altura, largura, comprimento, localidade, statusHangar);


            hangarService.inserirHangar(novohangar);


            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Modelo cadastrado com sucesso!");
            onLimpar();

        }catch (Exception e) {
            exibirAlerta(Alert.AlertType.ERROR, "Erro no Sistema", e.getMessage());
        }
    }

    @FXML
    private void onLimpar() {
        txtNome.clear();
        txtAltura.clear();
        txtLargura.clear();
        txtComprimento.clear();
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carregarComboBox();

        //tableViewAeronave.getSelectionModel().selectedItemProperty().addListener(
                //(observable, oldValue, newValue) -> selecionarAeronave(newValue));
    }


}
