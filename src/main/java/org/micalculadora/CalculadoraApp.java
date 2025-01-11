package org.micalculadora;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculadoraApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Mi calculadora");

        // Cargar la vista principal desde el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RootView.fxml"));
        Parent root = loader.load();

        // Crear la escena y aplicar el CSS
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/css/classicstyles.css").toExternalForm());

        // Configurar la escena en el escenario
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
