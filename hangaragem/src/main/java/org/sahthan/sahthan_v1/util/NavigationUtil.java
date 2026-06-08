package org.sahthan.sahthan_v1.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NavigationUtil {

    public static void trocarTela(Stage stage, String fxml, String titulo) {
        try {
            Parent root = FXMLLoader.load(
                    NavigationUtil.class.getResource(fxml)
            );

            stage.setScene(new Scene(root));
            stage.setTitle(titulo);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar FXML: " + fxml, e);
        }
    }
}