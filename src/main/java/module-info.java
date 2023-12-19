module com.example.sdu_newmenews {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sdu_newmenews to javafx.fxml;
    exports com.example.sdu_newmenews;
}