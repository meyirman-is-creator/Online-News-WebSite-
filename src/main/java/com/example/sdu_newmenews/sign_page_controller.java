    package com.example.sdu_newmenews;

import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.nio.BufferOverflowException;
import java.nio.charset.StandardCharsets;
import java.util.EmptyStackException;
import java.util.Random;
import java.util.RandomAccess;
import java.util.ResourceBundle;


public class sign_page_controller implements Initializable {
    String ram = "";
    @FXML
    private Label id_fogot_discribe_email;
    @FXML
    private Pane id_fogot_closeEye_repeat_btn;
    @FXML
    private Label id_fogot_discribe_repeat_password;
    @FXML
    private PasswordField id_fogot_hide_repeat_password;

    @FXML
    private Pane id_fogot_openEye_repeat_btn;
    @FXML
    private TextField id_fogot_show_repeat_password;

    @FXML
    void action_fogot_hide_repeat_password(KeyEvent event) {
        id_fogot_show_repeat_password.setText(id_fogot_hide_repeat_password.getText());
    }

    @FXML
    void action_fogot_show_repeat_password(KeyEvent event) {
        id_fogot_hide_repeat_password.setText(id_fogot_show_repeat_password.getText());

    }

    @FXML
    void action_fogot_toCloseEyeRepeat_btn(MouseEvent event) {
        id_fogot_closeEye_repeat_btn.setVisible(true);
        id_fogot_hide_repeat_password.setVisible(true);
        id_fogot_show_repeat_password.setVisible(false);
        id_fogot_openEye_repeat_btn.setVisible(false);
    }

    @FXML
    void action_fogot_toOpenEyeRepeat_btn(MouseEvent event) {
        id_fogot_closeEye_repeat_btn.setVisible(false);
        id_fogot_hide_repeat_password.setVisible(false);
        id_fogot_show_repeat_password.setVisible(true);
        id_fogot_openEye_repeat_btn.setVisible(true);
    }


    @FXML
    private Pane id_fogot_closeEye_new_btn;

    @FXML
    private Label id_fogot_discribe_new_password;

    @FXML
    private PasswordField id_fogot_hide_new_password;

    @FXML
    private Pane id_fogot_openEye_new_btn;
    @FXML
    private TextField id_fogot_show_new_password;

    @FXML
    void action_fogot_hide_new_password(KeyEvent event) {
        id_fogot_show_new_password.setText(id_fogot_hide_new_password.getText());
    }

    @FXML
    void action_fogot_show_new_password(KeyEvent event) {
        id_fogot_hide_new_password.setText(id_fogot_show_new_password.getText());
    }

    @FXML
    void action_fogot_toOpenEyeNew_btn(MouseEvent event) {
        id_fogot_openEye_new_btn.setVisible(true);
        id_fogot_show_new_password.setVisible(true);
        id_fogot_closeEye_new_btn.setVisible(false);
        id_fogot_hide_new_password.setVisible(false);
    }

    @FXML
    void action_fogot_toCloseEyeNew_btn(MouseEvent event) {
        id_fogot_openEye_new_btn.setVisible(false);
        id_fogot_show_new_password.setVisible(false);
        id_fogot_closeEye_new_btn.setVisible(true);
        id_fogot_hide_new_password.setVisible(true);
    }

    boolean fileHave;
    String[] usernameRememberMeOn;
    String usernames = "";

    void fileList(File dir) {
        for (File entry : dir.listFiles()) {
            if (entry.isDirectory()) {
                fileList(entry);
            } else {
                usernames += entry.getName() + "-==-";
            }
        }
    }

    void main() {
        try {
            File file = new File("src/main/java/com/example/sdu_newmenews/BaseOfUser");
            fileList(file);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    String[] tempArr;
    String nameToArray = "";

    void Main() throws IOException {
        File folder = new File("src/main/java/com/example/sdu_newmenews/BaseOfUser");
        if (folder.isDirectory()) {
            File file = new File("src/main/java/com/example/sdu_newmenews/BaseOfUser/user.txt");
            if (!file.exists()) {
                fileHave = false;
            } else {
                if (file.length() == 0) {
                    fileHave = false;
                } else {
                    fileHave = true;
                    String nameToArray = "";
                    String names = "";
                    String temp = "";
                    BufferedReader br = null;
                    try {
                        br = new BufferedReader(new FileReader(file));
                        String line;
                        while ((line = br.readLine()) != null) {
                            if (line != ".") {
                                temp += line + "-=-=-";
                            }
                        }
                        br.close();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    temp = temp.replaceAll("~~~~~-=-=-", "");
                    tempArr = temp.split("-=-=-");
                    String textUsername = "Username";
                    String bool = "";
                    String textRemember = "Remember me";
                    for (int i = 0; i < tempArr.length; i++) {
                        int r = 0;
                        for (int i1 = 0; i1 < textRemember.length(); i1++) {
                            if (tempArr[i].charAt(i1) == textRemember.charAt(i1)) {
                                r++;
                                if (r == textRemember.length()) {
                                    for (int i2 = 0; i2 < tempArr[i].length(); i2++) {
                                        if (tempArr[i].charAt(i2) == ':') {
                                            for (int i3 = i2 + 1; i3 < tempArr[i].length(); i3++) {
                                                bool += tempArr[i].charAt(i3);
                                            }
                                            if (bool.equals("true")) {
                                                for (int j = 0; j < tempArr[i + 1].length(); j++) {
                                                    if (tempArr[i + 1].charAt(j) == ':') {
                                                        for (int j1 = j + 1; j1 < tempArr[i + 1].length(); j1++) {
                                                            names += tempArr[i + 1].charAt(j1);
                                                        }
                                                        nameToArray += names += "==-==";
                                                        names = "";
                                                    }
                                                }
                                                bool = "";
                                            } else {
                                                bool = "";
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    this.nameToArray = nameToArray;
                    usernameRememberMeOn = nameToArray.split("==-==");
                }
            }
        } else {
        }
    }

    @FXML
    private Label id_su_discribeEmail;

    @FXML
    private Label id_su_discribePassword;

    @FXML
    private Label id_su_discribeUsername;
    @FXML
    private TextField id_su_email_textfield_emptyON;

    @FXML
    private ImageView id_SIGNINorSIGNUP_progress;
    @FXML
    private BorderPane id_SIGNINorSIGNUP_page;
    @FXML
    private BorderPane id_start_page;
    @FXML
    private ImageView id_start_progress;
    @FXML
    private TextField id_adm_usernameORemail;
    @FXML
    private ImageView id_fogot_progressBar_btn;

    @FXML
    private ImageView id_adm_progressBar;
    @FXML
    private Label id_si_emptyInPassword_discribeText;

    @FXML
    private Label id_si_emptyInUsername_discribeText;

    @FXML
    private ImageView id_su_progress;
    @FXML
    private ImageView id_si_progressBar;
    @FXML
    private Pane id_adm_closeEye_btn;
    @FXML
    private PasswordField id_su_hidePassword_passwordField;

    @FXML
    private Pane id_su_openEye_btn;

    @FXML
    private Pane id_adm_openEye_btn;
    @FXML
    private TextField id_su_showPassword_passwordField;
    @FXML
    private ComboBox id_su_username_combobox;
    @FXML
    private TextField id_su_email_textfield;

    @FXML
    private BorderPane id_su_page;
    @FXML
    private ImageView id_su_progressBar;
    @FXML
    private TextField id_si_username_textfield_emptyON;
    @FXML
    private BorderPane id_fogot_page;
    @FXML
    private BorderPane id_adm_page;
    @FXML
    private BorderPane id_si_page;

    @FXML
    private Pane id_su_closeEye_btn;


    @FXML
    private PasswordField id_adm_passwordField_password;

    @FXML
    private TextField id_adm_showPassword_textField;
    boolean list_combobox_empty;
    boolean list_combobox_empty_register;

    @FXML
    private ComboBox id_su_email_combobox;

    String[][] si_vremennaON = {{"Duman", "Duman's_password"}, {"Meyirman", "Meyirman's_password"}, {"Azamat", "Azamat's_password"}, {"Salamat", "Salamat's_password"}, {"Magzhan", "Magzhan's_password"}};
    String[][] su_vremennaON = {{"Duman", "Duman's_email_@", "Duman's_password"}, {"Meyirman", "Meyirman's_email_@", "Meyirman's_password"}, {"Azamat", "Azamat's_email_@", "Azamat's_password"}, {"Salamat", "Salamat's_email_@", "Salamat's_password"}, {"Magzhan", "Magzhan's_email_@", "Magzhan's_password"}};
    //    String[][] su_vremennaON = {};
//    String[][] si_vremennaON = {};
    String[][] login_baseON = si_vremennaON;
    String[][] register_baseON = su_vremennaON;

    void checkLoginBaseOn() {
        if (nameToArray.length() > 0) {
            list_combobox_empty = true;
        } else {
            list_combobox_empty = false;
        }
    }

    void checkRegisterBaseON() {
        if (register_baseON.length > 0) {
            list_combobox_empty_register = true;
        } else {
            list_combobox_empty_register = false;
        }
    }

    @FXML
    private Pane id_si_remembermeOFF_btn;

    @FXML
    private TextField id_su_username_textfield;

    @FXML
    private TextField id_su_username_textfield_emptyON;
    @FXML
    private Pane id_si_remembermeON;
    public boolean rememberME;
    @FXML
    private ComboBox id_si_combobox;

    @FXML
    private TextField id_si_username_textfield;

    @FXML
    void action_si_select(ActionEvent event) {
        String si_element_name = id_si_combobox.getSelectionModel().getSelectedItem().toString();
        id_si_username_textfield.setText(si_element_name);
        String textUsername = "Username";
        String name = "";
        String password = "";
        for (int i = 0; i < tempArr.length; i++) {
            int r = 0;
            for (int i1 = 0; i1 < textUsername.length(); i1++) {
                if (tempArr[i].charAt(i1) == textUsername.charAt(i1)) {
                    r++;
                    if (r == textUsername.length()) {
                        for (int i2 = 0; i2 < tempArr[i].length(); i2++) {
                            if (tempArr[i].charAt(i2) == ':') {
                                for (int i3 = i2 + 1; i3 < tempArr[i].length(); i3++) {
                                    name += tempArr[i].charAt(i3);
                                }
                                if (name.equals(si_element_name)) {
                                    for (int j = 0; j < tempArr[i + 1].length(); j++) {
                                        if (tempArr[i + 1].charAt(j) == ':') {
                                            for (int j1 = j + 1; j1 < tempArr[i + 1].length(); j1++) {
                                                password += tempArr[i + 1].charAt(j1);
                                            }
                                        }
                                    }
                                } else {
                                    name = "";
                                }
                            }
                        }
                    }
                } else {
                    r = 0;
                }
            }
        }
        id_si_remembermeON.setVisible(true);
        id_si_remembermeOFF_btn.setVisible(false);

        id_si_hidePassword_passwordField.setText(password);
        id_si_showPassword_passwordField.setText(password);


    }

    @FXML
    void action_su_select_username(ActionEvent event) {
        String su_element_name = id_su_username_combobox.getSelectionModel().getSelectedItem().toString();
        id_su_username_textfield.setText(su_element_name);
        String email = "";
        String[][] array = register_baseON;
        for (int i = 0; i < array.length; i++) {
            if (array[i][0].equals(su_element_name)) {
                email = array[i][1];
            }
        }
        id_su_email_textfield.setText(email);
    }

    public boolean next_page;


    @FXML
    private PasswordField id_si_hidePassword_passwordField;

    @FXML
    private TextField id_si_showPassword_passwordField;
    @FXML
    private Pane id_si_openEye_btn;
    @FXML
    private Pane id_si_closeEye_btn;
    String messageAboutError = "";

    @FXML
    private Button id_new_page_logout;

    @FXML
    private Button id_news_page_start;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id_fogot_progressBar_btn.setVisible(false);
        id_fogot_createNewPassword.setVisible(false);
        id_fogot_repeatPassword.setVisible(false);
        id_fogot_newPassword.setVisible(false);
        id_fogot_openEye_new_btn.setVisible(false);
        id_fogot_show_new_password.setVisible(false);
        id_fogot_openEye_repeat_btn.setVisible(false);
        id_fogot_show_repeat_password.setVisible(false);
        id_fogot_discribe_new_password.setVisible(false);
        id_fogot_discribe_repeat_password.setVisible(false);
        id_fogot_discribe_email.setVisible(false);
        main();
        try {
            Main();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (fileHave) {
            checkLoginBaseOn();
            if (list_combobox_empty) {
                id_si_username_textfield_emptyON.setVisible(false);
                id_si_combobox.setVisible(true);
                id_si_username_textfield.setVisible(true);
                String[] array = usernameRememberMeOn;
                ObservableList<String> list = FXCollections.observableArrayList(array);
                id_si_combobox.setItems(list);
            } else {
                id_si_username_textfield_emptyON.setVisible(true);
                id_si_combobox.setVisible(false);
                id_si_username_textfield.setVisible(false);
            }
        } else {
            id_si_username_textfield_emptyON.setVisible(true);
            id_si_combobox.setVisible(false);
            id_si_username_textfield.setVisible(false);
        }
        id_si_emptyInPassword_discribeText.setVisible(false);
        id_si_emptyInUsername_discribeText.setVisible(false);
        id_su_username_combobox.setVisible(false);
        id_su_email_combobox.setVisible(false);
        id_su_username_textfield.setVisible(false);
        id_su_email_textfield.setVisible(false);
        id_si_showPassword_passwordField.setVisible(false);
        id_si_openEye_btn.setVisible(false);

        id_si_remembermeON.setVisible(false);

        id_adm_showPassword_textField.setVisible(false);
        id_adm_openEye_btn.setVisible(false);

        id_adm_page.setVisible(false);
        id_fogot_page.setVisible(false);
        id_si_progressBar.setVisible(false);
        id_su_page.setVisible(false);
        id_si_page.setVisible(false);
        id_su_showPassword_passwordField.setVisible(false);
        id_su_openEye_btn.setVisible(false);
        id_su_progress.setVisible(false);
        id_adm_progressBar.setVisible(false);
        id_fogot_progressBar_btn.setVisible(false);
        id_start_page.setVisible(true);
        id_start_progress.setVisible(false);
        id_SIGNINorSIGNUP_page.setVisible(false);
        id_SIGNINorSIGNUP_progress.setVisible(false);
        id_su_discribeEmail.setVisible(false);
        id_su_discribePassword.setVisible(false);
        id_su_discribeUsername.setVisible(false);
    }

    @FXML
    void action_si_hidePassword_passwordField(KeyEvent event) {
        id_si_showPassword_passwordField.setText(id_si_hidePassword_passwordField.getText());
    }

    @FXML
    void action_si_showPassword_passwordField(KeyEvent event) {
        id_si_hidePassword_passwordField.setText(id_si_showPassword_passwordField.getText());
    }

    @FXML
    void action_si_toOpenEye_btn(MouseEvent event) {
        id_si_openEye_btn.setVisible(true);
        id_si_closeEye_btn.setVisible(false);
        id_si_showPassword_passwordField.setVisible(true);
        id_si_hidePassword_passwordField.setVisible(false);
    }

    @FXML
    void action_si_toShowEye_btn(MouseEvent event) {
        id_si_openEye_btn.setVisible(false);
        id_si_closeEye_btn.setVisible(true);
        id_si_showPassword_passwordField.setVisible(false);
        id_si_hidePassword_passwordField.setVisible(true);
    }

    @FXML
    void action_si_remembermeOFF(MouseEvent event) {
        id_si_remembermeOFF_btn.setVisible(true);
        id_si_remembermeON.setVisible(false);
        rememberME = false;
    }

    @FXML
    void action_si_remembermeON(MouseEvent event) {
        id_si_remembermeON.setVisible(true);
        id_si_remembermeOFF_btn.setVisible(false);
        rememberME = true;
    }

    @FXML
    void action_si_rememberme_ONorOFF(MouseEvent event) {
        if (id_si_remembermeOFF_btn.isVisible()) {
            id_si_remembermeOFF_btn.setVisible(false);
            id_si_remembermeON.setVisible(true);
            rememberME = true;
        } else if (id_si_remembermeON.isVisible()) {
            id_si_remembermeON.setVisible(false);
            id_si_remembermeOFF_btn.setVisible(true);
            rememberME = false;
        }
    }

    @FXML
    void action_adm_hidePassword_btn(MouseEvent event) {
        id_adm_openEye_btn.setVisible(false);
        id_adm_closeEye_btn.setVisible(true);
        id_adm_passwordField_password.setVisible(true);
        id_adm_showPassword_textField.setVisible(false);
    }

    @FXML
    void action_adm_hidePassword_passwordField(KeyEvent event) {
        id_adm_showPassword_textField.setText(id_adm_passwordField_password.getText());
    }

    @FXML
    void action_adm_showPassword_btn(MouseEvent event) {
        id_adm_openEye_btn.setVisible(true);
        id_adm_closeEye_btn.setVisible(false);
        id_adm_passwordField_password.setVisible(false);
        id_adm_showPassword_textField.setVisible(true);
    }

    @FXML
    void action_adm_showPassword_textField(KeyEvent event) {
        id_adm_passwordField_password.setText(id_adm_showPassword_textField.getText());
    }

    @FXML
    void action_adm_toLoginPage_btn(MouseEvent event) {
        id_si_page.setVisible(true);
        id_adm_page.setVisible(false);
        id_fogot_page.setVisible(false);
        id_su_page.setVisible(false);
    }

    @FXML
    void action_si_toAdminLoginPage_btn(MouseEvent event) {
        id_si_progressBar.setVisible(true);
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(2));
        pt.setOnFinished(e -> {
            try {
                Parent parent = FXMLLoader.load(getClass().getResource("admin.fxml"));
                Stage stage = (Stage) id_start_toAdmin_btn.getScene().getWindow();
                stage.setScene(new Scene(parent));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            id_si_page.setVisible(false);
            id_si_progressBar.setVisible(false);
            id_si_username_textfield_emptyON.setText("");
            id_si_username_textfield.setText("");
            id_si_hidePassword_passwordField.setText("");
            id_si_showPassword_passwordField.setText("");
            id_si_remembermeOFF_btn.setVisible(true);
            id_si_remembermeON.setVisible(false);
        });
        pt.play();
        id_adm_page.setVisible(false);
        id_fogot_page.setVisible(false);
        id_su_page.setVisible(false);
    }

    @FXML
    void action_si_toFogotPage_btn(MouseEvent event) {
        id_fogot_page.setVisible(true);
        id_si_page.setVisible(false);
        id_adm_page.setVisible(false);
        id_su_page.setVisible(false);
        id_si_username_textfield_emptyON.setText("");
        id_si_username_textfield.setText("");
        id_si_hidePassword_passwordField.setText("");
        id_si_showPassword_passwordField.setText("");
        id_si_remembermeOFF_btn.setVisible(true);
        id_si_remembermeON.setVisible(false);
    }

    @FXML
    void action_si_toSignUpPage_btn(MouseEvent event) {
        id_fogot_page.setVisible(false);
        id_si_page.setVisible(false);
        id_adm_page.setVisible(false);
        id_su_page.setVisible(true);
        id_si_username_textfield_emptyON.setText("");
        id_si_username_textfield.setText("");
        id_si_hidePassword_passwordField.setText("");
        id_si_showPassword_passwordField.setText("");
        id_si_remembermeOFF_btn.setVisible(true);
        id_si_remembermeON.setVisible(false);


    }

    @FXML
    private Button id_si_signin_btn;

    @FXML
    void action_fogot_toLoginPage_btn(MouseEvent event) {
        id_si_page.setVisible(true);
        id_fogot_page.setVisible(false);
        id_fogot_progressBar_btn.setVisible(false);
        id_adm_page.setVisible(false);
        id_su_page.setVisible(false);
        id_fogot_hide_repeat_password.setText("");
        id_fogot_email_textField.setText("");
        id_fogot_hide_new_password.setText("");
        id_fogot_show_repeat_password.setText("");
        id_fogot_show_new_password.setText("");
        id_fogot_find_btn.setVisible(true);
        id_fogot_createNewPassword.setVisible(false);
        id_fogot_newPassword.setVisible(false);
        id_fogot_repeatPassword.setVisible(false);
    }

    StringBuilder sb = new StringBuilder();
    private Stage obshyStage;

    void setObshyStage(Stage stage) {
        this.obshyStage = stage;
    }

    @FXML
    void action_si_signINToNextPage_btn(ActionEvent event) throws IOException {
        id_si_progressBar.setVisible(true);
        CheckField checkField = new CheckField();
        try {
            String username = "";
            String password = "";
            String rememberme = "";
            boolean rememberME;
            if (id_si_username_textfield_emptyON.isVisible()) {
                if (id_si_username_textfield_emptyON.getText().length() > 0) {
                    username = id_si_username_textfield_emptyON.getText();
                    checkField.setLoginUsername(username);
                    id_si_emptyInPassword_discribeText.setVisible(false);

                } else {
                    id_si_emptyInUsername_discribeText.setText("Username should not be empty!");
                    id_si_emptyInUsername_discribeText.setVisible(true);
                    throw new IOException("Username should not be empty!");
                }
            } else if (id_si_username_textfield.isVisible()) {
                if (id_si_username_textfield.getText().length() > 0) {
                    username = id_si_username_textfield.getText();
                    checkField.setLoginUsername(username);
                    id_si_emptyInUsername_discribeText.setVisible(false);
                } else {
                    id_si_emptyInUsername_discribeText.setText("Username should not be empty!");
                    id_si_emptyInUsername_discribeText.setVisible(true);
                    throw new IOException("Username should not be empty!");
                }
            }


            if (id_si_openEye_btn.isVisible()) {
                if (id_si_showPassword_passwordField.getText().length() > 0) {
                    password = id_si_showPassword_passwordField.getText();
                    checkField.setLoginPassword(password);
                    id_si_emptyInPassword_discribeText.setVisible(false);

                } else {
                    id_si_emptyInPassword_discribeText.setText("Password should not be empty!");
                    id_si_emptyInPassword_discribeText.setVisible(true);
                    throw new IOException("Password should not be empty!");
                }
            } else if (id_si_closeEye_btn.isVisible()) {
                if (id_si_hidePassword_passwordField.getText().length() > 0) {
                    password = id_si_hidePassword_passwordField.getText();
                    checkField.setLoginPassword(password);
                    id_si_emptyInPassword_discribeText.setVisible(false);
                } else {
                    id_si_emptyInPassword_discribeText.setText("Password should not be empty!");
                    id_si_emptyInPassword_discribeText.setVisible(true);
                    throw new IOException("Password should not be empty!");
                }
            }
            if (id_si_remembermeOFF_btn.isVisible()) {
                rememberME = false;
                rememberme = "false";
            } else if (id_si_remembermeON.isVisible()) {
                rememberME = true;
                rememberme = "true";

            }
            File file1 = new File("src/main/java/com/example/sdu_newmenews/BaseOfUser/user.txt");

            if (file1.length() > 0) {
                String textUsername = "Username";
                String textPassword = "Password";
                String vremennaPassword = "";
                int t = 0;
                int p = 0;
                int po = 0;
                String vremennaName = "";
                int index = 0;
                for (int i = 0; i < tempArr.length; i++) {
                    int r = 0;
                    for (int i1 = 0; i1 < textUsername.length(); i1++) {
                        if (tempArr[i].charAt(i1) == textUsername.charAt(i1)) {
                            r++;
                        }
                        if (r == textUsername.length()) {
                            t++;
                            for (int i2 = 0; i2 < tempArr[i].length(); i2++) {
                                if (tempArr[i].charAt(i2) == ':') {
                                    for (int i3 = i2 + 1; i3 < tempArr[i].length(); i3++) {
                                        vremennaName += tempArr[i].charAt(i3);
                                    }
                                    if (vremennaName.equals(username)) {
                                        p++;
                                        t = 0;
                                        for (int j = 0; j < textPassword.length(); j++) {
                                            if (tempArr[i + 1].charAt(j) == textPassword.charAt(j)) {
                                                po++;
                                            }
                                            if (po == textPassword.length()) {
                                                for (int j1 = 0; j1 < tempArr[i + 1].length(); j1++) {
                                                    if (tempArr[i + 1].charAt(j1) == ':') {
                                                        for (int j2 = j1 + 1; j2 < tempArr[i + 1].length(); j2++) {
                                                            vremennaPassword += tempArr[i + 1].charAt(j2);
                                                        }
                                                        if (vremennaPassword.equals(password)) {
                                                            tempArr[i - 1] = "Remember me :" + rememberme;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        vremennaName = "";
                                    }
                                }
                            }
                        }
                    }
                }
                if (t == tempArr.length / 5 && p == 0) {

                    throw new IOException("There is no such username!\nThe username and password are not correct!");
                } else {
                    if (vremennaPassword.equals(password)) {
                        File file = new File("src/main/java/com/example/sdu_newmenews/BaseOfUser/user.txt");
                        if (file.exists()) {
                            file.delete();
                            File file3 = new File("src/main/java/com/example/sdu_newmenews/BaseOfUser/user.txt");
                            String content = "";
                            for (int i = 0; i < tempArr.length; i++) {
                                int mod = i % 5;
                                if (tempArr.length - 1 == i) {
                                    content += tempArr[i] + "\n~~~~~\n";
                                } else if (mod == 0 && i != 0) {
                                    content += "~~~~~\n" + tempArr[i] + "\n";
                                } else {
                                    content += tempArr[i] + "\n";
                                }
                            }
                            RandomAccessFile r = new RandomAccessFile(file3, "rw");
                            r.writeBytes(content);
                            r.close();
                            PauseTransition pt = new PauseTransition();
                            pt.setDuration(Duration.seconds(3));
                            pt.setOnFinished(e -> {
                                File fileRam = new File("src/main/java/com/example/sdu_newmenews/BaseOfUser/fileRam.txt");
                                RandomAccessFile ram = null;
                                try {
                                    ram = new RandomAccessFile(fileRam, "rw");
                                    ram.writeBytes("user");
                                    ram.close();
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                                try {
                                    Parent parent = FXMLLoader.load(getClass().getResource("guest_page.fxml"));
                                    Stage stage1 = (Stage) id_si_signin_btn.getScene().getWindow();
                                    stage1.setScene(new Scene(parent));
                                } catch (Exception ex) {
                                    System.out.println(ex.getMessage());
                                }
                                id_si_progressBar.setVisible(false);
                                System.out.println("Login successfully!");
                                id_si_username_textfield_emptyON.setText("");
                                id_si_username_textfield.setText("");
                                id_si_hidePassword_passwordField.setText("");
                                id_si_showPassword_passwordField.setText("");
                                id_si_remembermeOFF_btn.setVisible(true);
                            });
                            pt.play();
                        }
                    } else {
                        throw new IOException("The password is not correct!");
                    }
                }
            } else {
                throw new IOException("There is no such username!\nThe username and password are not correct!");
            }


        } catch (Exception e) {
            id_si_progressBar.setVisible(false);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("errorMessage.fxml"));
            stage.setScene(new Scene(fxmlLoader.load(), 600, 400));
            messageErrorController messageErrorController1 = fxmlLoader.getController();
            messageErrorController1.writeInMessage(e.getMessage());
            System.out.println(e.getMessage());
            InputStream iconStream = getClass().getResourceAsStream("image/icon_logo.png");
            Image image = new Image(iconStream);
            stage.setResizable(false);
            stage.getIcons().add(image);
            stage.setTitle("NewMENews");
            messageErrorController1.setStage(stage);
            stage.show();
        }
    }

    @FXML
    void action_su_toLogin_page_btn(MouseEvent event) {
        id_si_page.setVisible(true);
        id_fogot_page.setVisible(false);
        id_adm_page.setVisible(false);
        id_su_page.setVisible(false);
        id_su_username_textfield_emptyON.setText("");
        id_su_email_textfield_emptyON.setText("");
        id_su_hidePassword_passwordField.setText("");
        id_su_showPassword_passwordField.setText("");
        id_su_other_radio.setSelected(true);
    }


    @FXML
    void action_su_showPassword_passwordField(KeyEvent event) {
        id_su_hidePassword_passwordField.setText(id_su_showPassword_passwordField.getText());
    }

    @FXML
    void action_su_toCloseEye_btn(MouseEvent event) {
        id_su_openEye_btn.setVisible(false);
        id_su_closeEye_btn.setVisible(true);
        id_su_showPassword_passwordField.setVisible(false);
        id_su_hidePassword_passwordField.setVisible(true);
    }

    @FXML
    void action_su_toOpenEye_btn(MouseEvent event) {
        id_su_openEye_btn.setVisible(true);
        id_su_closeEye_btn.setVisible(false);
        id_su_showPassword_passwordField.setVisible(true);
        id_su_hidePassword_passwordField.setVisible(false);
    }

    @FXML
    void action_su_hidePassword_passwordField(KeyEvent event) {
        id_su_showPassword_passwordField.setText(id_su_hidePassword_passwordField.getText());
    }

    @FXML
    private RadioButton id_su_female_radio;
    @FXML
    private RadioButton id_su_male_radio;
    @FXML
    private RadioButton id_su_other_radio;

    @FXML
    void action_su_signUPToNextPage_btn(ActionEvent event) throws Exception {

        id_su_progress.setVisible(true);

        CheckField checkField = new CheckField();
        try {
            if (id_su_username_textfield_emptyON.getText().length() > 0) {
                checkField.setRegUsername(id_su_username_textfield_emptyON.getText());
                checkField.setRegisterUsername(id_su_username_textfield_emptyON.getText());
                id_su_discribeUsername.setVisible(false);
            } else {
                id_su_progress.setVisible(false);

                id_su_discribeUsername.setText("Username name should not be empty!");
                id_su_discribeUsername.setVisible(true);
            }
            if (id_su_email_textfield_emptyON.getText().length() > 0) {
                checkField.setRegEmail(id_su_email_textfield_emptyON.getText());
                checkField.setRegisterEmail(id_su_email_textfield_emptyON.getText());
                id_su_discribeEmail.setVisible(false);
            } else {
                id_su_progress.setVisible(false);

                id_su_discribeEmail.setText("Email name should not be empty!");
                id_su_discribeEmail.setVisible(true);
            }
            if (id_su_openEye_btn.isVisible()) {
                if (id_su_showPassword_passwordField.getText().length() > 0) {
                    checkField.setRegPassword(id_su_showPassword_passwordField.getText());
                    checkField.setRegisterPassword(id_su_showPassword_passwordField.getText());
                    id_su_discribePassword.setVisible(false);
                } else {
                    id_su_progress.setVisible(false);

                    id_su_discribePassword.setText("Password should not be empty!");
                    id_su_discribePassword.setVisible(true);
                }
            } else {
                if (id_su_hidePassword_passwordField.getText().length() > 0) {
                    checkField.setRegPassword(id_su_hidePassword_passwordField.getText());
                    checkField.setRegisterPassword(id_su_hidePassword_passwordField.getText());
                    id_su_discribePassword.setVisible(false);
                } else {
                    id_su_progress.setVisible(false);

                    id_su_discribePassword.setText("Password should not be empty!");
                    id_su_discribePassword.setVisible(true);
                }
            }
            if (!(id_su_discribeEmail.isVisible()) && !(id_su_discribePassword.isVisible()) && !(id_su_discribeUsername.isVisible())) {
                String email = id_su_email_textfield_emptyON.getText();
                String username = id_su_username_textfield_emptyON.getText();
                String password = "";
                if (id_su_openEye_btn.isVisible()) {
                    password = id_su_showPassword_passwordField.getText();
                } else if (id_su_closeEye_btn.isVisible()) {
                    password = id_su_hidePassword_passwordField.getText();
                }


                String username1 = id_su_username_textfield_emptyON.getText();
                String email1 = id_su_email_textfield_emptyON.getText();
                String password1 = "";
                if (id_su_openEye_btn.isVisible()) {
                    password1 = id_su_showPassword_passwordField.getText();
                } else if (id_su_closeEye_btn.isVisible()) {
                    password1 = id_su_hidePassword_passwordField.getText();
                }

                if (tempArr == null) {
                    boolean emailCorrect;
                    boolean usernameCorrect;
                    if (username1.equals(password1)) {
                        usernameCorrect = false;
                        throw new IOException("Username and password match");
                    } else {
                        usernameCorrect = true;
                    }

                    if (email1.equals(password1)) {
                        emailCorrect = false;
                        throw new IOException("Email and password match");
                    } else {
                        emailCorrect = true;
                    }
                    if (emailCorrect && usernameCorrect) {
                        String gender = "";
                        if (id_su_male_radio.isSelected()) {
                            gender = "Male";
                        } else if (id_su_female_radio.isSelected()) {
                            gender = "Female";
                        } else if (id_su_other_radio.isSelected()) {
                            gender = "Other";
                        }
                        CreateUsername createUsername = new CreateUsername(username, email, password, gender);
                        createUsername.creteFile();
                        Main();

                        PauseTransition pt = new PauseTransition();
                        pt.setDuration(Duration.seconds(3));
                        pt.setOnFinished(e -> {
                            System.out.println("Registration successfully");
                            id_si_username_textfield.setText("");
                            id_si_showPassword_passwordField.setText("");
                            id_si_hidePassword_passwordField.setText("");
                            id_adm_showPassword_textField.setText("");
                            id_adm_passwordField_password.setText("");
                            id_si_page.setVisible(true);
                            id_su_page.setVisible(false);
                            id_su_progress.setVisible(false);
                            id_su_email_textfield_emptyON.setText("");
                            id_su_username_textfield_emptyON.setText("");
                            id_su_showPassword_passwordField.setText("");
                            id_su_hidePassword_passwordField.setText("");
                        });
                        pt.play();
                    }
                } else {

                    boolean usernameHave;
                    int y = 0;
                    int x = 0;
                    String textUsername = "Username";
                    for (int i = 0; i < tempArr.length; i++) {
                        int r = 0;
                        for (int i1 = 0; i1 < textUsername.length(); i1++) {
                            if (textUsername.charAt(i1) == tempArr[i].charAt(i1)) {
                                r++;
                            }
                            if (r == textUsername.length()) {
                                for (int i2 = 0; i2 < tempArr[i].length(); i2++) {
                                    if (tempArr[i].charAt(i2) == ':') {
                                        String vremennaUsername = "";
                                        for (int i3 = i2 + 1; i3 < tempArr[i].length(); i3++) {
                                            vremennaUsername += tempArr[i].charAt(i3);
                                        }
                                        if (vremennaUsername.equals(username1)) {
                                            throw new Exception("This username already exists");
                                        } else {
                                            y++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    String textEmail = "Email";
                    for (int i = 0; i < tempArr.length; i++) {
                        int r = 0;
                        for (int i1 = 0; i1 < textEmail.length(); i1++) {
                            if (textEmail.charAt(i1) == tempArr[i].charAt(i1)) {
                                r++;
                            }
                            if (r == textEmail.length()) {
                                for (int i2 = 0; i2 < tempArr[i].length(); i2++) {
                                    if (tempArr[i].charAt(i2) == ':') {
                                        String vremennaEmail = "";
                                        for (int i3 = i2 + 1; i3 < tempArr[i].length(); i3++) {
                                            vremennaEmail += tempArr[i].charAt(i3);
                                        }
                                        if (vremennaEmail.equals(email1)) {
                                            throw new IOException("This email already exists");
                                        } else {
                                            x++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (y == tempArr.length / 5 && x == tempArr.length / 5) {
                        boolean emailCorrect;
                        boolean usernameCorrect;
                        if (username1.equals(password1)) {
                            usernameCorrect = false;
                            throw new IOException("Username and password match");
                        } else {
                            usernameCorrect = true;
                        }

                        if (email1.equals(password1)) {
                            emailCorrect = false;
                            throw new IOException("Email and password match");
                        } else {
                            emailCorrect = true;
                        }
                        if (emailCorrect && usernameCorrect) {
                            String gender = "";
                            if (id_su_male_radio.isSelected()) {
                                gender = "Male";
                            } else if (id_su_female_radio.isSelected()) {
                                gender = "Female";
                            } else if (id_su_other_radio.isSelected()) {
                                gender = "Other";
                            }
                            CreateUsername createUsername = new CreateUsername(username, email, password, gender);
                            createUsername.creteFile();
                            Main();

                            PauseTransition pt = new PauseTransition();
                            pt.setDuration(Duration.seconds(3));
                            pt.setOnFinished(e -> {
                                System.out.println("Registration successfully");
                                id_si_username_textfield.setText("");
                                id_si_showPassword_passwordField.setText("");
                                id_si_hidePassword_passwordField.setText("");
                                id_adm_showPassword_textField.setText("");
                                id_adm_passwordField_password.setText("");
                                id_si_page.setVisible(true);
                                id_su_page.setVisible(false);
                                id_su_progress.setVisible(false);
                                id_su_email_textfield_emptyON.setText("");
                                id_su_username_textfield_emptyON.setText("");
                                id_su_showPassword_passwordField.setText("");
                                id_su_hidePassword_passwordField.setText("");
                            });
                            pt.play();
                        }
                    }
                }

            }
        } catch (Exception e) {
            if (e.getMessage().equals("Email name should not be empty!")) {
                id_su_discribeEmail.setText("Email name should not be empty!");
                id_su_discribeEmail.setVisible(true);
            }
            if (e.getMessage().equals("Username name should not be empty!")) {
                id_su_discribeUsername.setText("Username name should not be empty!");
                id_su_discribeUsername.setVisible(true);
            }
            if (e.getMessage().equals("Password should not be empty!")) {
                id_su_discribePassword.setText(e.getMessage());
                id_su_discribePassword.setVisible(true);
            }

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("errorMessage.fxml"));
            stage.setScene(new Scene(fxmlLoader.load(), 600, 400));
            messageErrorController messageErrorController1 = fxmlLoader.getController();
            messageErrorController1.writeInMessage(e.getMessage());
            InputStream iconStream = getClass().getResourceAsStream("image/icon_logo.png");
            Image image = new Image(iconStream);
            stage.setResizable(false);
            stage.getIcons().add(image);
            stage.setTitle("NewMENews");
            messageErrorController1.setStage(stage);
            stage.show();
            System.out.println(e.getMessage());
            id_su_progress.setVisible(false);
        }


    }

    @FXML
    void action_adm_TOLoginPage_btn(ActionEvent event) throws Exception {
        id_adm_progressBar.setVisible(true);
        String username = id_adm_usernameORemail.getText();
        CheckField checkField = new CheckField();
        try {
            checkField.setAdminUsername(username);
            if (id_adm_openEye_btn.isVisible()) {
                checkField.setAdminPassword(id_adm_showPassword_textField.getText());
            } else if (id_adm_closeEye_btn.isVisible()) {
                checkField.setAdminPassword(id_adm_passwordField_password.getText());
            }


            PauseTransition pt = new PauseTransition();
            pt.setDuration(Duration.seconds(3));
            pt.setOnFinished(e -> {
                System.out.println("Admin Login Failed");
                id_adm_progressBar.setVisible(false);
            });
            pt.play();
        } catch (Exception e) {
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("errorMessage.fxml"));
            stage.setScene(new Scene(fxmlLoader.load(), 600, 400));
            messageErrorController messageErrorController1 = fxmlLoader.getController();
            messageErrorController1.writeInMessage(e.getMessage());
            InputStream iconStream = getClass().getResourceAsStream("image/icon_logo.png");
            Image image = new Image(iconStream);
            stage.setResizable(false);
            stage.getIcons().add(image);
            stage.setTitle("NewMENews");
            messageErrorController1.setStage(stage);
            stage.show();

            System.out.println(e.getMessage());
        }
    }

    @FXML
    void action_fogot_toCreateNewPassword_btn(ActionEvent event) throws IOException {
        id_fogot_progressBar_btn.setVisible(true);

        String Rpassword = "";
        String Npassword = "";
        String password = "";
        String email = "";
        try {
            email = id_fogot_email_textField.getText();
            if (id_fogot_openEye_repeat_btn.isVisible()) {
                Rpassword = id_fogot_show_repeat_password.getText();
            } else if (id_fogot_closeEye_repeat_btn.isVisible()) {
                Rpassword = id_fogot_hide_repeat_password.getText();
            }

            if (id_fogot_openEye_new_btn.isVisible()) {
                Npassword = id_fogot_show_new_password.getText();
            } else if (id_fogot_closeEye_new_btn.isVisible()) {
                Npassword = id_fogot_hide_new_password.getText();
            }
            if (Npassword.length() > 0) {
                id_fogot_discribe_new_password.setVisible(false);
            } else {
                id_fogot_discribe_new_password.setText("The new password should not be empty!");
                id_fogot_discribe_new_password.setVisible(true);
                throw new IOException("The new password should not be empty!");

            }
            if (Rpassword.length() > 0) {
                id_fogot_discribe_repeat_password.setVisible(false);
            } else {
                id_fogot_discribe_repeat_password.setText("The repeat password should not be empty!");
                id_fogot_discribe_repeat_password.setVisible(true);
                throw new IOException("The repeat password should not be empty!");
            }
            int t = 0;
            int m = 0;
            if (Npassword.equals(Rpassword)) {
                password = Npassword;
                if (!password.equals(email)) {
                    if (5 <= password.length() && password.length() <= 9) {
                        String textEmail = "Email";
                        String emailCatch = "";
                        for (int i = 0; i < tempArr.length; i++) {
                            int r = 0;
                            for (int i1 = 0; i1 < textEmail.length(); i1++) {
                                if (tempArr[i].charAt(i1) == textEmail.charAt(i1)) {
                                    r++;
                                }
                                if (r == textEmail.length()) {
                                    t++;
                                    for (int i2 = 0; i2 < tempArr[i].length(); i2++) {
                                        if (tempArr[i].charAt(i2) == ':') {
                                            for (int i3 = i2 + 1; i3 < tempArr[i].length(); i3++) {
                                                emailCatch += tempArr[i].charAt(i3);
                                            }
                                            if (emailCatch.equals(email)) {
                                                m++;
                                                t = 0;
                                                tempArr[i - 1] = "Password    :" + password;


                                                File file = new File("src/main/java/com/example/sdu_newmenews/BaseOfUser/user.txt");
                                                file.delete();
                                                File file1 = new File("src/main/java/com/example/sdu_newmenews/BaseOfUser/user.txt");
                                                String content = "";
                                                for (int j = 0; j < tempArr.length; j++) {
                                                    int mod = j % 5;
                                                    if (tempArr.length - 1 == j) {
                                                        content += tempArr[j] + "\n~~~~~\n";
                                                    } else if (mod == 0 && j != 0) {
                                                        content += "~~~~~\n" + tempArr[j] + "\n";
                                                    } else {
                                                        content += tempArr[j] + "\n";
                                                    }
                                                }
                                                RandomAccessFile roy = new RandomAccessFile(file1, "rw");
                                                roy.seek(file1.length());
                                                roy.writeBytes(content);
                                                roy.close();

                                                PauseTransition pt = new PauseTransition();
                                                pt.setDuration(Duration.seconds(3));
                                                pt.setOnFinished(e -> {
                                                    System.out.println("Create new password successfully!");
                                                    id_fogot_page.setVisible(false);
                                                    id_si_page.setVisible(true);
                                                    id_fogot_email_textField.setText("");
                                                    id_fogot_hide_new_password.setText("");
                                                    id_fogot_show_new_password.setText("");
                                                    id_fogot_show_repeat_password.setText("");
                                                    id_fogot_hide_repeat_password.setText("");
                                                    id_si_progressBar.setVisible(false);
                                                    id_fogot_progressBar_btn.setVisible(false);
                                                    id_fogot_find_btn.setVisible(true);
                                                    id_fogot_createNewPassword.setVisible(false);
                                                    id_fogot_newPassword.setVisible(false);
                                                    id_fogot_repeatPassword.setVisible(false);
                                                });
                                                pt.play();
                                            } else {
                                                emailCatch = "";
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (t == tempArr.length / 5 && m == 0) {
                            throw new IOException("Do not change email");
                        }
                    } else {
                        throw new IOException("The password length should be from 5 to 9.\nYou have the length: " + password.length());
                    }
                } else {
                    throw new IOException("Email and password match");
                }
            } else {
                throw new IOException("Passwords don't match!");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeight(250);
            alert.setHeaderText("Error");
            alert.setContentText(e.getMessage());
            alert.setTitle("NewMENews");
            alert.showAndWait();
        }
    }

    @FXML
    private Button id_fogot_createNewPassword;
    @FXML
    private Button id_fogot_find_btn;
    @FXML
    private TextField id_fogot_email_textField;
    @FXML
    private Pane id_fogot_newPassword;

    @FXML
    private Pane id_fogot_repeatPassword;

    @FXML
    void action_fogot_toFindEmail_btn(ActionEvent event) {
        id_fogot_progressBar_btn.setVisible(true);
        String email = "";
        int t = 0;
        int m = 0;
        int index = 0;
        try {
            if (tempArr != null) {
                email = id_fogot_email_textField.getText();
                if (email.length() > 0) {
                    String textEmail = "Email";
                    String emailCatch = "";
                    for (int i = 0; i < tempArr.length; i++) {
                        int r = 0;
                        for (int i1 = 0; i1 < textEmail.length(); i1++) {
                            if (tempArr[i].charAt(i1) == textEmail.charAt(i1)) {
                                r++;
                            }
                            if (r == textEmail.length()) {
                                t++;
                                for (int i2 = 0; i2 < tempArr[i].length(); i2++) {
                                    if (tempArr[i].charAt(i2) == ':') {
                                        for (int i3 = 1 + i2; i3 < tempArr[i].length(); i3++) {
                                            emailCatch += tempArr[i].charAt(i3);
                                        }
                                        if (emailCatch.equals(email)) {
                                            index = i;
                                            m++;
                                            t = 0;
                                            PauseTransition pt = new PauseTransition();
                                            pt.setDuration(Duration.seconds(3));
                                            pt.setOnFinished(e -> {
                                                id_fogot_discribe_email.setVisible(false);
                                                id_fogot_progressBar_btn.setVisible(false);
                                                id_fogot_find_btn.setVisible(false);
                                                id_fogot_createNewPassword.setVisible(true);
                                                id_fogot_repeatPassword.setVisible(true);
                                                id_fogot_newPassword.setVisible(true);
                                            });
                                            pt.play();

                                        } else {
                                            emailCatch = "";
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (t == tempArr.length / 5 && m == 0) {
                        throw new IOException("The Email is not correct!");
                    }
                } else {
                    id_fogot_discribe_email.setText("The Email should not be empty!");
                    id_fogot_discribe_email.setVisible(true);
                    throw new IOException("The Email should not be empty!");
                }
            } else {
                throw new IOException("The Email is not correct!");
            }
        } catch (Exception e) {
            id_fogot_progressBar_btn.setVisible(false);
            System.out.println(e.getMessage());
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("NewMENews");
            alert.setWidth(250);
            alert.setHeight(250);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }


    }

    @FXML
    void action_start_toUserPage_btn(ActionEvent event) {
        id_start_progress.setVisible(true);
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(2));
        pt.setOnFinished(e -> {
            id_SIGNINorSIGNUP_page.setVisible(true);
            id_start_page.setVisible(false);
            id_start_progress.setVisible(false);
        });
        pt.play();
    }

    @FXML
    private Button id_start_toAdmin_btn;

    @FXML
    void action_start_adminLoginPage_btn(ActionEvent event) {
        id_start_progress.setVisible(true);
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(2));
        pt.setOnFinished(e -> {

            try {
                Parent parent = FXMLLoader.load(getClass().getResource("admin.fxml"));
                Stage stage = (Stage) id_start_toAdmin_btn.getScene().getWindow();
                stage.setScene(new Scene(parent));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            id_start_page.setVisible(false);
            id_start_progress.setVisible(false);
        });
        pt.play();
    }

    @FXML
    void action_SIGNINorSIGNUP_toLoginPage_btn(ActionEvent event) {
        id_SIGNINorSIGNUP_progress.setVisible(true);
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(2));
        pt.setOnFinished(e -> {
            id_si_page.setVisible(true);
            id_SIGNINorSIGNUP_progress.setVisible(false);
            id_SIGNINorSIGNUP_page.setVisible(false);
        });
        pt.play();
    }

    @FXML
    void action_SIGNINorSIGNUP_toRegisterPage_btn(ActionEvent event) {
        id_SIGNINorSIGNUP_progress.setVisible(true);
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(2));
        pt.setOnFinished(e -> {
            id_su_page.setVisible(true);
            id_SIGNINorSIGNUP_progress.setVisible(false);
            id_SIGNINorSIGNUP_page.setVisible(false);
        });
        pt.play();
    }

}
