package ru.geekbrains.Jawa2.Lesson4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

//
import java.io.IOException;

public class Lesson4 extends Application {

    public TextField inputTextStr;
    public TextArea bigField;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("Les4.fxml"));

        Image image = new Image("file:src\\ru\\geekbrains\\Jawa2\\Lesson4\\icon.png");

        primaryStage.getIcons().add(image);
        primaryStage.setTitle("Alone in the chat.");
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }

    public void pressKey(ActionEvent actionEvent) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(bigField.getText());
        bigField.setText(stringBuffer.toString() + inputTextStr.getText()+"\n");
        inputTextStr.clear();

    }
}

