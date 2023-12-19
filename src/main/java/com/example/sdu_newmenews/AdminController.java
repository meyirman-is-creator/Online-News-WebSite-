package com.example.sdu_newmenews;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    @FXML
    private Label id_adm_discribeEmail;

    @FXML
    private Label id_adm_discribePassword;

    @FXML
    private Pane id_adm_closeEye_btn;

    @FXML
    private Pane id_adm_openEye_btn;

    @FXML
    private BorderPane id_adm_page;

    @FXML
    private PasswordField id_adm_passwordField_password;

    @FXML
    private ImageView id_adm_progressBar;

    @FXML
    private TextField id_adm_showPassword_textField;

    @FXML
    private TextField id_adm_usernameORemail;
    @FXML
    private Label id_adm_toLogin_btn;
    @FXML
    private Button id_adm_toLoginPage;
    @FXML
    void action_adm_TOLoginPage_btn(ActionEvent event) {
        id_adm_progressBar.setVisible(true);
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(3));
        pt.setOnFinished(e->{
            try{
                Parent parent = FXMLLoader.load(getClass().getResource("sign.fxml"));
                Stage stage = (Stage) id_adm_toLoginPage.getScene().getWindow();
                stage.setScene(new Scene(parent));
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            id_adm_progressBar.setVisible(false);
            id_adm_page.setVisible(false);
        });
        pt.play();
    }

    @FXML
    void action_adm_hidePassword_btn(MouseEvent event) {
        id_adm_passwordField_password.setVisible(true);
        id_adm_showPassword_textField.setVisible(false);
        id_adm_closeEye_btn.setVisible(true);
        id_adm_openEye_btn.setVisible(false);
    }

    @FXML
    void action_adm_TOSignInAdmin(ActionEvent event) throws IOException {
        id_adm_progressBar.setVisible(true);
        String EMAIL="mr.sarsenbay_the_creator@";
        String PASSWORD="meyirTheCreator";
        String email="";
        String password="";
        File file = new File("src/main/java/com/example/sdu_newmenews/BaseOfUser/user.txt");
        int r=0;
        String temp="";
        if(file.exists()){
            BufferedReader br = null;
            try{
                br = new BufferedReader(new FileReader(file));
                String line;
                while((line=br.readLine())!=null){
                    if (line != ".") {
                        temp += line + "-=-=-";
                    }
                }
                br.close();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        temp = temp.replaceAll("~~~~~-=-=-","");
        String[] tempArr = temp.split("-=-=-");


        try{
            if(!(id_adm_usernameORemail.getText().length()>0)){
                id_adm_discribeEmail.setText("The Email should not be empty!");
                id_adm_discribeEmail.setVisible(true);
                id_adm_progressBar.setVisible(false);
            } else{
                email=id_adm_usernameORemail.getText();

                if(!(email.equals(EMAIL))){
                    throw new Exception("There is no such email!\nThe email and password are not correct!");
                }

                id_adm_discribeEmail.setVisible(false);


            }
            if(id_adm_openEye_btn.isVisible()){
                if(!(id_adm_showPassword_textField.getText().length()>0)){
                    id_adm_discribePassword.setText("The password should not be empty!");
                    id_adm_discribePassword.setVisible(true);
                    id_adm_progressBar.setVisible(false);

                } else {
                    password=id_adm_showPassword_textField.getText();

                    if(!(password.equals(PASSWORD))){
                        throw new Exception("The password is not correct!");
                    }

                    id_adm_discribePassword.setVisible(false);

                }
            } else if(id_adm_closeEye_btn.isVisible()){
                if(!(id_adm_passwordField_password.getText().length()>0)){
                    id_adm_discribePassword.setText("The password should not be empty!");
                    id_adm_discribePassword.setVisible(true);
                    id_adm_progressBar.setVisible(false);

                } else{
                    password=id_adm_passwordField_password.getText();
                    if(!(password.equals(PASSWORD))){
                        throw new Exception("The password is not correct!");
                    }
                    id_adm_discribePassword.setVisible(false);

                }
            }
            if(password.equals(PASSWORD) && email.equals(EMAIL)){
                PauseTransition pt = new PauseTransition();
                pt.setDuration(Duration.seconds(3));
                pt.setOnFinished(e->{
                    if(tempArr.length<5){
                        System.out.println("There don't have line!");
                        System.out.println("There don't have account!");
                    } else if(tempArr.length>=5){
                        System.out.println("Here have "+tempArr.length+" lines!");
                        System.out.println("Here have "+tempArr.length/5+" accounts!");
                    }
                    System.out.println("Admin Login Successful");
                    id_adm_progressBar.setVisible(false);
                });
                pt.play();
            }
        }catch (Exception e){
            id_adm_progressBar.setVisible(false);
            System.out.println(e.getMessage());
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("NewMENews");
            alert.setHeight(250);
            alert.setWidth(250);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
    @FXML
    void action_adm_hidePassword_passwordField(KeyEvent event) {
        id_adm_showPassword_textField.setText(id_adm_passwordField_password.getText());
    }

    @FXML
    void action_adm_showPassword_btn(MouseEvent event) {
        id_adm_passwordField_password.setVisible(false);
        id_adm_showPassword_textField.setVisible(true);
        id_adm_closeEye_btn.setVisible(false);
        id_adm_openEye_btn.setVisible(true);
    }

    @FXML
    void action_adm_showPassword_textField(KeyEvent event) {
        id_adm_passwordField_password.setText(id_adm_showPassword_textField.getText());

    }

    @FXML
    void action_adm_toLoginPage_btn(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id_adm_openEye_btn.setVisible(false);
        id_adm_showPassword_textField.setVisible(false);
        id_adm_progressBar.setVisible(false);
        id_adm_discribeEmail.setVisible(false);
        id_adm_discribePassword.setVisible(false);
    }
}
