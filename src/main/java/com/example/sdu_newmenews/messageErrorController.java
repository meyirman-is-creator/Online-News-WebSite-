package com.example.sdu_newmenews;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class messageErrorController {
    Stage stage;
    void setStage(Stage stage){
        this.stage = stage;
    }

    @FXML
    private Label messageAboutError;

    void writeInMessage(String message){
        messageAboutError.setText(message);
    }
    @FXML
    void closeWindow(ActionEvent event) {
        stage.close();
    }
}
