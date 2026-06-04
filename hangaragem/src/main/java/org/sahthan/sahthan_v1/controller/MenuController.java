package org.sahthan.sahthan_v1.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML
    public void irParaCadastrar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/sahthan/sahthan_v1/CadastrarAeronave/CadastrarAeronaves.fxml"));
            Parent root = loader.load();

            Scene novaCena = new Scene(root);

            Stage stageAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stageAtual.setScene(novaCena);
            stageAtual.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void irParaVisualizar(ActionEvent event) {
        try {
            // 1. Carrega o arquivo FXML da nova tela
            // Ajuste o caminho de acordo com a estrutura do seu projeto (ex: /org/sahthan/sahthan_v1/view/...)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/sahthan/sahthan_v1/CadastrarAeronave/VisualizarAeronaves.fxml"));
            Parent root = loader.load();

            // 2. Cria a nova cena com o arquivo FXML carregado
            Scene novaCena = new Scene(root);

            // 3. Pega a Stage (janela) atual a partir do evento do clique
            Stage stageAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // 4. Muda a cena da janela para a nova tela
            stageAtual.setScene(novaCena);
            stageAtual.show();

        } catch (IOException e) {
            e.printStackTrace();
            // Dica: Trate o erro adequadamente (ex: mostrando um alerta na tela)
        }
    }
}
