package ru.geekbrains.Jawa2.Lesson4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Lesson4 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("Les4.fxml"));

        primaryStage.setTitle("Alone in the chat.");
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }


}
