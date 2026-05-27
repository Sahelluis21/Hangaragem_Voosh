package org.sahthan.sahthan_v1.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.sahthan.sahthan_v1.Launcher; // Importa o Launcher

import java.io.IOException;
import java.net.URL;

public class CadastrarModeloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        URL fxmlLocation = Launcher.class.getResource("/org/sahthan/sahthan_v1/CadastrarModelo.fxml");

        if (fxmlLocation == null) {
            throw new IllegalStateException("Arquivo FXML não foi encontrado na pasta de recursos!");
        }

        FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);
        Scene scene = new Scene(fxmlLoader.load(), 600, 500);
        stage.setTitle("Hangar - Cadastro de Modelos");
        stage.setScene(scene);
        stage.show();
    }


    }
