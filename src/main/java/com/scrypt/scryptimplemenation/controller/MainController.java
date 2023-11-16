package com.scrypt.scryptimplemenation.controller;

import com.scrypt.scryptimplemenation.utils.SCryptUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static com.scrypt.scryptimplemenation.utils.Constants.FALSE;
import static com.scrypt.scryptimplemenation.utils.Constants.TRUE;


public class MainController implements Initializable {

    private double x, y;

    private String password = "", passwordCheck = "";
    private String generatedSecuredPasswordHash = "";
    @FXML
    private ImageView scryptImage, imgEyeForPassword, imgEyeForPasswordCheck, imgEyeHideForPassword, imgEyeHideForPasswordCheck;

    @FXML
    private Label lab;

    @FXML
    private TextField hashGeneratedField, booleanResultField, passwordTextFieldUnlocked, passwordCheckTextFieldUnlocked;
    @FXML
    private PasswordField passwordField, passwordCheckField;

    @FXML
    private Button btnEncrypt, btnCheck;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {}

    @FXML
    private void btnEncryptClicked(ActionEvent event) throws Exception {

        String password = passwordField.getText();
        String testing = passwordTextFieldUnlocked.getText();

        if (!(passwordField.getText().length() > 6)) {
            lab.setText("Password Length should be bigger than 6 characters.");
            lab.setStyle("-fx-text-fill: #FF073A;");
        } else {
            // generate password
            generatedSecuredPasswordHash = SCryptUtil.scrypt(password, 16, 16, 16);

            // show the hashPassword to tView
            hashGeneratedField.setText(generatedSecuredPasswordHash);
            hashGeneratedField.setEditable(true);
            hashGeneratedField.setDisable(false);
            lab.setText("Hash Password has generated successfully!");
            lab.setStyle("-fx-text-fill: #008000;");
        }

    }


    @FXML
    private void btnCheckClicked(ActionEvent event) throws Exception {

        String passwordForCheck = passwordCheckField.getText();

        if (passwordForCheck.isEmpty()) {
            lab.setText("Password shouldn't be empty!");
            lab.setStyle("-fx-text-fill: #FF073A;");
        } else if (!(passwordForCheck.length() > 6)) {
            lab.setText("Character size limit is bigger than six.!");
            lab.setStyle("-fx-text-fill: #FF073A;");
        } else {
            // do the checking
            if (generatedSecuredPasswordHash.isEmpty()) {
                lab.setText("You should have the hash for checking.!");
                lab.setStyle("-fx-text-fill: #FF073A;");
            } else {
                boolean matched = SCryptUtil.check(passwordForCheck, generatedSecuredPasswordHash);
                if (matched) {
                    booleanResultField.setText(TRUE);
                    lab.setText("Checking DONE!");
                    lab.setStyle("-fx-text-fill: #008000;");
                } else {
                    booleanResultField.setText(FALSE);
                    booleanResultField.setText(TRUE);
                    lab.setText("Checking DONE!");
                }
                booleanResultField.setEditable(false);
                booleanResultField.setDisable(true);
                booleanResultField.setCursor(Cursor.HAND);
            }
        }
    }

    @FXML
    private void imgEyeHideForPasswordCheckClicked(ActionEvent event) throws Exception {
        if (imgEyeHideForPasswordCheck.isVisible()) {
            // update passwordCheckTextFieldUnlocked with value of passwordCheckField
            passwordCheckTextFieldUnlocked.setText(passwordCheckField.getText());

            //update the password
            passwordField.setText(passwordCheckField.getText());
            //show password word
            passwordCheckTextFieldUnlocked.setText(passwordCheckField.getText());
            passwordCheckTextFieldUnlocked.setVisible(false);
            passwordCheckField.setVisible(true);
            // change image
            imgEyeForPasswordCheck.setVisible(true);
            imgEyeHideForPasswordCheck.setVisible(false);
        }
    }

    @FXML
    private void imgEyeHideForPasswordClicked(ActionEvent event) throws Exception {
        if (imgEyeHideForPassword.isVisible()) {
            // update passwordField with value of passwordTextFieldUnlocked
            passwordField.setText(passwordTextFieldUnlocked.getText());

            //show password word
            passwordTextFieldUnlocked.setText(passwordField.getText());
            passwordTextFieldUnlocked.setVisible(false);
            passwordField.setVisible(true);
            // change image
            imgEyeForPassword.setVisible(true);
            imgEyeHideForPassword.setVisible(false);
        }
    }

    @FXML
    private void passwordCheckTextFieldUnlockedClicked(ActionEvent event) throws Exception {
    }

    @FXML
    private void imgEyeForPasswordClicked(ActionEvent event) throws Exception {
        if (imgEyeForPassword.isVisible()) {

            // update passwordTextFieldUnlocked with value of passwordField
            passwordTextFieldUnlocked.setText(passwordField.getText());

            //show password word
            passwordTextFieldUnlocked.setText(passwordField.getText());
            passwordTextFieldUnlocked.setVisible(true);
            passwordField.setVisible(false);
            // change image
            imgEyeForPassword.setVisible(false);
            imgEyeHideForPassword.setVisible(true);
        }
    }

    @FXML
    private void imgEyeForPasswordCheckClicked(ActionEvent event) throws Exception {
        if (imgEyeForPasswordCheck.isVisible()) {
            // update passwordCheckField with value of passwordCheckTextFieldUnlocked
            passwordCheckField.setText(passwordCheckTextFieldUnlocked.getText());

            //show password word
            passwordCheckTextFieldUnlocked.setText(passwordCheckField.getText());
            passwordCheckTextFieldUnlocked.setVisible(true);
            passwordCheckField.setVisible(false);
            // change image
            imgEyeForPasswordCheck.setVisible(false);
            imgEyeHideForPasswordCheck.setVisible(true);
        }
    }

    @FXML
    private void passwordTextFieldUnlockedClicked(ActionEvent event) throws Exception {

    }

    @FXML
    private void hashGeneratedFieldClicked(ActionEvent event) throws Exception {
    }

    @FXML
    private void passwordFieldClicked(ActionEvent event) throws Exception {

    }

    @FXML
    private void passwordCheckFieldClicked(ActionEvent event) throws Exception {

    }

    @FXML
    private void booleanResultFieldClicked(ActionEvent event) throws Exception {

    }

    @FXML
    void dragged(MouseEvent event) {

        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setX(event.getScreenX() - x);
        primaryStage.setY(event.getScreenY() - y);
    }

    @FXML
    void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    @FXML
    private void min(MouseEvent event) {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setIconified(true);
    }

    @FXML
    private void close(MouseEvent event) {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.close();
    }

}
