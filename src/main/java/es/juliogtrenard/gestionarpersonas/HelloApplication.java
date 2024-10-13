package es.juliogtrenard.gestionarpersonas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/img/library_icon.png"))));
        stage.setTitle("PERSONAS");
        stage.setScene(scene);

        stage.setMinWidth(700);
        stage.setMinHeight(400);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}