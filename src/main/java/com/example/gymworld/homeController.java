package com.example.gymworld;

import com.example.gymworld.databasefiles.Database;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.Member;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class homeController implements Initializable {
    @FXML
    private ListView<String> ServiceList;

    @FXML
    private SplitPane splitPane;

    private AnchorPane CurrentPane=null;

    //SignUp related variables
    @FXML
    private AnchorPane SignUpMain;
    @FXML
    private TextField SignUpID;
    @FXML
    private TextField SignUpName;
    @FXML
    private TextField SignUpPhone;
    @FXML
    private TextField SignUpAddress;
    @FXML
    private TextField SignUpDob;
    @FXML
    private TextField SignUpProfession;
    @FXML
    private ChoiceBox<String> SignUpMembership;
    String[] Plans={"1 MONTH","6 MONTH","12 MONTH","LIFETIME"};

    //
    private Stage stage;
    private String currentService;

    //Database Related variables for all the functions
    private Connection connect=null;
    private PreparedStatement preparedStatement=null;
    private ResultSet result=null;

    String[] Services = {"NEW MEMBER","PAYMENT","ID ON/OFF","FINGERPRINT","ADMIN"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ServiceList.getItems().addAll(Services);

        ServiceList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                //checking the name of the menu selected
                currentService=ServiceList.getSelectionModel().getSelectedItem();
                switch(currentService){
                    case "NEW MEMBER":
                        loadNewMemberPage();
                        break;
                    case "PAYMENT":
                        loadPaymentPage();
                        break;
                    case "ID ON/OFF":
                        loadIdOnOffPage();
                        break;
                    case "FINGERPRINT":
                        loadFingerPrintPage();
                        break;
                    case "ADMIN":
                        loadAdminPage();
                        break;
                    default:
                }
                System.out.println(currentService);
            }
        });

        //SIGNUP PAGE:
        SignUpMembership.getItems().addAll(Plans);

    }

    /*
     New Member Page:
      Date created-17.03.2024 by Imran
     */
    protected void loadNewMemberPage(){
        if(CurrentPane!=null){ CurrentPane.setVisible(false);}
        SignUpMain.setVisible(true);
        CurrentPane=SignUpMain;
    }

    public void Submit(){
        Alert alert;
        Member newMember;
        if(SignUpID.getText().isEmpty()||
                SignUpName.getText().isEmpty()||
                SignUpAddress.getText().isEmpty()||
                SignUpDob.getText().isEmpty()||
                SignUpPhone.getText().isEmpty()||
                SignUpMembership.getValue().isEmpty()
        ){
            alert =new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
        }
        else{
            newMember=new Member(
                    Integer.parseInt(SignUpID.getText()),
                    SignUpName.getText(),
                    SignUpPhone.getText(),
                    SignUpAddress.getText(),
                    SignUpProfession.getText(),
                    Date.valueOf(SignUpDob.getText()),
                    SignUpMembership.getValue(),
                    "Photo Name");
            boolean memberAdded=newMember.addNewMember();
            if(memberAdded){
                alert=new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("SUCCESS");
                alert.setContentText("Member added Successfully");
                alert.showAndWait();
            }
            else{
                alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Sql Query Error");
                alert.setContentText("Unable to add new Member.SQL query cannot be executed");
                alert.showAndWait();
            }
        }
    }
    public void clear(){
        System.out.println("cleared");
    }

    /*
     PAYMENT PAGE:
      Date Created:24.03.2024
     */
    @FXML
    AnchorPane PaymentPage;
    private void loadPaymentPage() {
        if(CurrentPane!=null){ CurrentPane.setVisible(false);}
        PaymentPage.setVisible(true);
        CurrentPane=PaymentPage;
    }

    private void loadAdminPage() {

    }

    private void loadFingerPrintPage() {
    }

    private void loadIdOnOffPage() {
    }







}