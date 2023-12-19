package com.example.sdu_newmenews;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePage implements Initializable {
    @FXML
    private Pane id_scenePage;

    @FXML
    private Pane id_techPage;

    @FXML
    private AnchorPane id_page5;

    @FXML
    private AnchorPane id_page6;

    @FXML
    private AnchorPane id_page7;

    @FXML
    private AnchorPane id_page8;

    @FXML
    private AnchorPane id_page9;
    @FXML
    private AnchorPane id_page1;

    @FXML
    private AnchorPane id_page10;

    @FXML
    private AnchorPane id_page11;

    @FXML
    private AnchorPane id_page12;

    @FXML
    private AnchorPane id_page13;

    @FXML
    private AnchorPane id_page14;

    @FXML
    private AnchorPane id_page15;

    @FXML
    private AnchorPane id_page16;

    @FXML
    private AnchorPane id_page17;

    @FXML
    private AnchorPane id_page18;

    @FXML
    private AnchorPane id_page19;

    @FXML
    private AnchorPane id_page2;

    @FXML
    private AnchorPane id_page20;

    @FXML
    private AnchorPane id_page21;

    @FXML
    private AnchorPane id_page22;

    @FXML
    private AnchorPane id_page23;

    @FXML
    private AnchorPane id_page24;

    @FXML
    private AnchorPane id_page3;

    @FXML
    private AnchorPane id_page4;
    @FXML
    private AnchorPane id_contactPage;
    @FXML
    private Button id_menu_businessBtn_Active;

    @FXML
    private Button id_menu_businessBtn_nonActive;

    @FXML
    private Button id_menu_climateBtn_Active;

    @FXML
    private Button id_menu_climateBtn_nonActive;

    @FXML
    private Button id_menu_sceneBtn_Active;

    @FXML
    private Button id_menu_sceneBtn_nonActive;

    @FXML
    private Button id_menu_techBtn_Active;

    @FXML
    private Button id_menu_techBtn_nonActive;


    @FXML
    private ImageView id_helloPage_progressBar;
    @FXML
    private Pane id_businessPage;

    @FXML
    private Pane id_climatePage;

    @FXML
    private Pane id_climatePage1;

    @FXML
    private AnchorPane id_helloPage;

    @FXML
    private VBox id_menuPage;

    @FXML
    private AnchorPane id_page;
    @FXML
    private Pane id_menu_sceneItems;
    @FXML
    private Pane id_menu_businessItems;
    @FXML
    private Pane id_menu_techItems;
    @FXML
    private Pane id_menu_climateItems;


    @FXML
    void action_fogot_toCreateNewPassword_btn(ActionEvent event) {

    }
    @FXML
    void action_logout(MouseEvent event) {
        File file = new File("src/main/java/com/example/sdu_newmenews/BaseOfUser/fileRam.txt");
        file.delete();
        File file1 = new File("src/main/java/com/example/sdu_newmenews/BaseOfUser/fileRam.txt");
        RandomAccessFile r=null;
        try{
            r=new RandomAccessFile(file1, "rw");
            r.writeBytes("");
            r.close();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        onOff();
        javafx.application.Platform.exit();
    }
    void onOff() {
        File file = new File("src/main/java/com/example/sdu_newmenews/BaseOfUser/fileRam.txt");
        if(file.exists()) {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    this.ram = line;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        if (this.ram.length() == 0) {
            id_news_page_start.setVisible(true);
            id_new_page_logout.setVisible(false);
        } else if (this.ram.equals("user")) {
            id_new_page_logout.setVisible(true);
            id_news_page_start.setVisible(false);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        id_contactPage.setVisible(false);
        id_helloPage.setVisible(true);
        id_helloPage_progressBar.setVisible(true);
        id_page.setVisible(false);
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(8));
        pt.setOnFinished(e -> {
            id_helloPage.setVisible(false);
            id_helloPage_progressBar.setVisible(false);
            id_page.setVisible(true);
            id_menuPage.setVisible(true);
            id_scenePage.setVisible(true);
            id_menu_businessBtn_Active.setVisible(false);
            id_menu_climateBtn_Active.setVisible(false);
            id_menu_techBtn_Active.setVisible(false);
            id_menu_sceneBtn_Active.setVisible(true);

            id_menu_techBtn_nonActive.setVisible(true);
            id_menu_sceneBtn_nonActive.setVisible(false);
            id_menu_climateBtn_nonActive.setVisible(true);
            id_menu_businessBtn_nonActive.setVisible(true);

            id_menu_sceneItems.setVisible(true);
            id_menu_techItems.setVisible(false);
            id_menu_climateItems.setVisible(false);
            id_menu_businessItems.setVisible(false);
        });
        pt.play();
        id_scenePage.setVisible(false);
        id_climatePage.setVisible(false);
        id_techPage.setVisible(false);
        id_businessPage.setVisible(false);

        id_page1.setVisible(false);
        id_page2.setVisible(false);
        id_page3.setVisible(false);
        id_page4.setVisible(false);
        id_page5.setVisible(false);
        id_page6.setVisible(false);
        id_page7.setVisible(false);
        id_page8.setVisible(false);
        id_page9.setVisible(false);
        id_page10.setVisible(false);
        id_page11.setVisible(false);
        id_page12.setVisible(false);
        id_page13.setVisible(false);
        id_page14.setVisible(false);
        id_page15.setVisible(false);
        id_page16.setVisible(false);
        id_page17.setVisible(false);
        id_page18.setVisible(false);
        id_page19.setVisible(false);
        id_page20.setVisible(false);
        id_page21.setVisible(false);
        id_page22.setVisible(false);
        id_page23.setVisible(false);
        id_page24.setVisible(false);
        id_menu_sceneItems.setVisible(false);
        id_menu_techItems.setVisible(false);
        id_menu_climateItems.setVisible(false);
        id_menu_businessItems.setVisible(false);
        onOff();


    }



    @FXML
    void action_toCloseMenuBar(MouseEvent event) {
        id_menuPage.setVisible(false);
    }

    @FXML
    void action_toOpenMenuBar(MouseEvent event) {
        id_menuPage.setVisible(true);
    }

    @FXML
    void action_startLogin(ActionEvent event) throws IOException {
        try{
            Parent parent = FXMLLoader.load(getClass().getResource("sign.fxml"));
            Stage stage1 = (Stage) id_news_page_start.getScene().getWindow();
            stage1.setScene(new Scene(parent));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private Button id_new_page_logout;
    @FXML
    private Button id_news_page_start;
    String ram = "";



    @FXML
    void action_openBusinessPage(ActionEvent event) {
        id_businessPage.setVisible(true);
        id_climatePage.setVisible(false);
        id_techPage.setVisible(false);
        id_scenePage.setVisible(false);

        id_menu_businessBtn_Active.setVisible(true);
        id_menu_climateBtn_Active.setVisible(false);
        id_menu_techBtn_Active.setVisible(false);
        id_menu_sceneBtn_Active.setVisible(false);

        id_menu_techBtn_nonActive.setVisible(true);
        id_menu_sceneBtn_nonActive.setVisible(true);
        id_menu_climateBtn_nonActive.setVisible(true);
        id_menu_businessBtn_nonActive.setVisible(false);

        id_menu_sceneItems.setVisible(false);
        id_menu_techItems.setVisible(false);
        id_menu_climateItems.setVisible(false);
        id_menu_businessItems.setVisible(true);
    }

    @FXML
    void action_openClimatePage(ActionEvent event) {
        id_businessPage.setVisible(false);
        id_climatePage.setVisible(true);
        id_techPage.setVisible(false);
        id_scenePage.setVisible(false);

        id_menu_businessBtn_Active.setVisible(false);
        id_menu_climateBtn_Active.setVisible(true);
        id_menu_techBtn_Active.setVisible(false);
        id_menu_sceneBtn_Active.setVisible(false);

        id_menu_techBtn_nonActive.setVisible(true);
        id_menu_sceneBtn_nonActive.setVisible(true);
        id_menu_climateBtn_nonActive.setVisible(false);
        id_menu_businessBtn_nonActive.setVisible(true);

        id_menu_sceneItems.setVisible(false);
        id_menu_techItems.setVisible(false);
        id_menu_climateItems.setVisible(true);
        id_menu_businessItems.setVisible(false);
    }

    @FXML
    void action_openScenePage(ActionEvent event) {
        id_businessPage.setVisible(false);
        id_climatePage.setVisible(false);
        id_techPage.setVisible(false);
        id_scenePage.setVisible(true);

        id_menu_businessBtn_Active.setVisible(false);
        id_menu_climateBtn_Active.setVisible(false);
        id_menu_techBtn_Active.setVisible(false);
        id_menu_sceneBtn_Active.setVisible(true);

        id_menu_techBtn_nonActive.setVisible(true);
        id_menu_sceneBtn_nonActive.setVisible(false);
        id_menu_climateBtn_nonActive.setVisible(true);
        id_menu_businessBtn_nonActive.setVisible(true);

        id_menu_sceneItems.setVisible(true);
        id_menu_techItems.setVisible(false);
        id_menu_climateItems.setVisible(false);
        id_menu_businessItems.setVisible(false);
    }

    @FXML
    void action_openTechPage(ActionEvent event) {
        id_businessPage.setVisible(false);
        id_climatePage.setVisible(false);
        id_techPage.setVisible(true);
        id_scenePage.setVisible(false);

        id_menu_businessBtn_Active.setVisible(false);
        id_menu_climateBtn_Active.setVisible(false);
        id_menu_techBtn_Active.setVisible(true);
        id_menu_sceneBtn_Active.setVisible(false);

        id_menu_techBtn_nonActive.setVisible(false);
        id_menu_sceneBtn_nonActive.setVisible(true);
        id_menu_climateBtn_nonActive.setVisible(true);
        id_menu_businessBtn_nonActive.setVisible(true);

        id_menu_sceneItems.setVisible(false);
        id_menu_techItems.setVisible(true);
        id_menu_climateItems.setVisible(false);
        id_menu_businessItems.setVisible(false);

    }

    @FXML
    void action_con_closeContactPage_btn(MouseEvent event) {
        id_contactPage.setVisible(false);
    }

    @FXML
    void action_openContactPage_btn(ActionEvent event) {
        id_contactPage.setVisible(true);
    }

    @FXML
    void action_open1(MouseEvent event) {
        id_page.setVisible(false);
        id_page1.setVisible(true);
    }

    @FXML
    void action_open2(MouseEvent event) {
        id_page.setVisible(false);
        id_page2.setVisible(true);
    }

    @FXML
    void action_open3(MouseEvent event) {
        id_page.setVisible(false);
        id_page3.setVisible(true);
    }

    @FXML
    void action_open4(MouseEvent event) {
        id_page.setVisible(false);
        id_page4.setVisible(true);
    }

    @FXML
    void action_open5(MouseEvent event) {
        id_page.setVisible(false);
        id_page5.setVisible(true);
    }

    @FXML
    void action_open6(MouseEvent event) {
        id_page.setVisible(false);
        id_page6.setVisible(true);
    }

    @FXML
    void action_open7(MouseEvent event) {
        id_page.setVisible(false);
        id_page7.setVisible(true);
    }

    @FXML
    void action_open8(MouseEvent event) {
        id_page.setVisible(false);
        id_page8.setVisible(true);
    }

    @FXML
    void action_open9(MouseEvent event) {
        id_page.setVisible(false);
        id_page9.setVisible(true);
    }

    @FXML
    void action_open10(MouseEvent event) {
        id_page.setVisible(false);
        id_page10.setVisible(true);
    }

    @FXML
    void action_open11(MouseEvent event) {
        id_page.setVisible(false);
        id_page11.setVisible(true);
    }

    @FXML
    void action_open12(MouseEvent event) {
        id_page.setVisible(false);
        id_page12.setVisible(true);
    }

    @FXML
    void action_open13(MouseEvent event) {
        id_page.setVisible(false);
        id_page13.setVisible(true);
    }

    @FXML
    void action_open14(MouseEvent event) {
        id_page.setVisible(false);
        id_page14.setVisible(true);
    }

    @FXML
    void action_open15(MouseEvent event) {
        id_page.setVisible(false);
        id_page15.setVisible(true);
    }

    @FXML
    void action_open16(MouseEvent event) {
        id_page.setVisible(false);
        id_page16.setVisible(true);
    }

    @FXML
    void action_open17(MouseEvent event) {
        id_page.setVisible(false);
        id_page17.setVisible(true);
    }

    @FXML
    void action_open18(MouseEvent event) {
        id_page.setVisible(false);
        id_page7.setVisible(true);
    }

    @FXML
    void action_open19(MouseEvent event) {
        id_page.setVisible(false);
        id_page19.setVisible(true);
    }

    @FXML
    void action_open20(MouseEvent event) {
        id_page.setVisible(false);
        id_page20.setVisible(true);
    }

    @FXML
    void action_open21(MouseEvent event) {
        id_page.setVisible(false);
        id_page21.setVisible(true);
    }

    @FXML
    void action_open22(MouseEvent event) {
        id_page.setVisible(false);
        id_page22.setVisible(true);
    }

    @FXML
    void action_open23(MouseEvent event) {
        id_page.setVisible(false);
        id_page23.setVisible(true);
    }

    @FXML
    void action_open24(MouseEvent event) {
        id_page.setVisible(false);
        id_page24.setVisible(true);
    }

    @FXML
    void go_to_back(MouseEvent event) {
        id_page.setVisible(true);
        id_page1.setVisible(false);
        id_page2.setVisible(false);
        id_page3.setVisible(false);
        id_page4.setVisible(false);
        id_page5.setVisible(false);
        id_page6.setVisible(false);
        id_page7.setVisible(false);
        id_page8.setVisible(false);
        id_page9.setVisible(false);
        id_page10.setVisible(false);
        id_page11.setVisible(false);
        id_page12.setVisible(false);
        id_page13.setVisible(false);
        id_page14.setVisible(false);
        id_page15.setVisible(false);
        id_page16.setVisible(false);
        id_page17.setVisible(false);
        id_page18.setVisible(false);
        id_page19.setVisible(false);
        id_page20.setVisible(false);
        id_page21.setVisible(false);
        id_page22.setVisible(false);
        id_page23.setVisible(false);
        id_page24.setVisible(false);
    }

    @FXML
    void action_menu_1open(ActionEvent event) {
        id_page1.setVisible(true);
        id_page.setVisible(false);
    }

    @FXML
    void action_menu_2open(ActionEvent event) {
        id_page2.setVisible(true);
        id_page.setVisible(false);
    }

    @FXML
    void action_menu_3open(ActionEvent event) {
        id_page3.setVisible(true);
        id_page.setVisible(false);
    }

    @FXML
    void action_menu_4open(ActionEvent event) {
        id_page4.setVisible(true);
        id_page.setVisible(false);
    }

    @FXML
    void action_menu_5open(ActionEvent event) {
        id_page5.setVisible(true);
        id_page.setVisible(false);
    }

    @FXML
    void action_menu_6open(ActionEvent event) {
        id_page6.setVisible(true);
        id_page.setVisible(false);
    }

    @FXML
    void action_menu_7open(ActionEvent event) {
        id_page7.setVisible(true);
        id_page.setVisible(false);
    }

    @FXML
    void action_menu_8open(ActionEvent event) {
        id_page8.setVisible(true);
        id_page.setVisible(false);
    }

    @FXML
    void action_menu_9open(ActionEvent event) {
        id_page9.setVisible(true);
        id_page.setVisible(false);
    }

    @FXML
    void action_menu_10open(ActionEvent event) {
        id_page10.setVisible(true);
        id_page.setVisible(false);
    }

    @FXML
    void action_menu_11open(ActionEvent event) {
        id_page11.setVisible(true);
        id_page.setVisible(false);
    }

    @FXML
    void action_menu_12open(ActionEvent event) {
        id_page12.setVisible(true);
        id_page.setVisible(false);
    }

    @FXML
    void action_menu_13open(ActionEvent event) {
        id_page13.setVisible(true);
        id_page.setVisible(false);
    }

    @FXML
    void action_menu_14open(ActionEvent event) {
        id_page14.setVisible(true);
        id_page.setVisible(false);
    }

    @FXML
    void action_menu_15open(ActionEvent event) {
        id_page15.setVisible(true);
        id_page.setVisible(false);
    }

    @FXML
    void action_menu_16open(ActionEvent event) {
        id_page16.setVisible(true);
        id_page.setVisible(false);
    }

    @FXML
    void action_menu_17open(ActionEvent event) {
        id_page17.setVisible(true);
        id_page.setVisible(false);
    }

    @FXML
    void action_menu_18open(ActionEvent event) {
        id_page18.setVisible(true);
        id_page.setVisible(false);
    }

    @FXML
    void action_menu_19open(ActionEvent event) {
        id_page19.setVisible(true);
        id_page.setVisible(false);
    }

    @FXML
    void action_menu_20open(ActionEvent event) {
        id_page20.setVisible(true);
        id_page.setVisible(false);
    }

    @FXML
    void action_menu_21open(ActionEvent event) {
        id_page21.setVisible(true);
        id_page.setVisible(false);
    }

    @FXML
    void action_menu_22open(ActionEvent event) {
        id_page22.setVisible(true);
        id_page.setVisible(false);
    }

    @FXML
    void action_menu_23open(ActionEvent event) {
        id_page23.setVisible(true);
        id_page.setVisible(false);
    }

    @FXML
    void action_menu_24open(ActionEvent event) {
        id_page24.setVisible(true);
        id_page.setVisible(false);
    }

}
