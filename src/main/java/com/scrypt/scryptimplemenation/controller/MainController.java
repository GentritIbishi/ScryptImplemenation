package com.scrypt.scryptimplemenation.controller;

import com.scrypt.scryptimplemenation.utils.SCryptUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static com.scrypt.scryptimplemenation.utils.Constants.*;


public class MainController implements Initializable {
    private double x, y;
    private String status;
    private String generatedSecuredPasswordHash = "";
    @FXML
    private ImageView scryptImage;

    @FXML
    private Label lab;

    @FXML
    private TextField hashGeneratedField, booleanResultField,
            plaintextField, plaintextCheckField, nField, rField, pField;

    @FXML
    private Button btnGenerate, btnCheck;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }

    @FXML
    private void btnGenerateClicked(ActionEvent event) {
        if (!(plaintextField.getText().length() > 6)) {
            lab.setText("Password Length should be bigger than 6 characters.");
            lab.setStyle("-fx-text-fill: #FF073A;");
        } else {
            try {
                // generate hash

                if(nField.getText().matches("[0-9#]+"))
                {
                    lab.setText("Ensure that the 'N' parameter only consists of numerical values.");
                    lab.setStyle("-fx-text-fill: #FF073A;");
                }

                if(pField.getText().matches("[0-9#]+"))
                {
                    lab.setText("Ensure that the 'P' parameter only consists of numerical values.");
                    lab.setStyle("-fx-text-fill: #FF073A;");
                }

                if(rField.getText().matches("[0-9#]+"))
                {
                    lab.setText("Ensure that the 'R' parameter only consists of numerical values.");
                    lab.setStyle("-fx-text-fill: #FF073A;");
                }

                if(plaintextField.getText().isEmpty())
                {
                    lab.setText("Require non-empty plaintext for hash generation.");
                    lab.setStyle("-fx-text-fill: #FF073A;");
                }
                else {
                    generatedSecuredPasswordHash = SCryptUtil.scrypt(plaintextField.getText(),
                            Integer.parseInt(nField.getText()),
                            Integer.parseInt(rField.getText()),
                            Integer.parseInt(pField.getText()));

                    // show the hashPassword to tView
                    hashGeneratedField.setText(generatedSecuredPasswordHash);
                    hashGeneratedField.setEditable(true);
                    hashGeneratedField.setDisable(false);
                    lab.setText("Hash Password has generated successfully!");
                    lab.setStyle("-fx-text-fill: #00FF00;");
                }
            }catch (Exception e) {
                lab.setText(STATUS + ": "+e.getMessage());
            }
        }

    }


    @FXML
    private void btnCheckClicked(ActionEvent event) {

        String plaintextCheck = plaintextCheckField.getText();

        if (plaintextCheck.isEmpty()) {
            lab.setText("Plaintext for checking shouldn't be empty!");
            lab.setStyle("-fx-text-fill: #FF073A;");
        } else if (!(plaintextCheck.length() > 6)) {
            lab.setText("Character size limit is bigger than six.!");
            lab.setStyle("-fx-text-fill: #FF073A;");
        } else if (hashGeneratedField.getText().isEmpty()) {
            lab.setText("You should have the hash for checking.!");
            lab.setStyle("-fx-text-fill: #FF073A;");
        } else {
            try {
                // do the checking
                boolean matched = SCryptUtil.check(plaintextCheckField.getText(), hashGeneratedField.getText());
                if (matched) {
                    booleanResultField.setText(TRUE);
                    booleanResultField.setStyle("    -fx-border-color: #00FF00;\n" +
                            "    -fx-background-color: #00FF00;\n" +
                            "    -fx-border-radius: 0;\n" +
                            "    -fx-border-width: 2px;\n" +
                            "    -fx-text-fill: #000;\n" +
                            "    -fx-prompt-text-fill: #58656D;");
                    lab.setText(STATUS_TRUE);
                    lab.setStyle("-fx-text-fill: #19ea19;");
                } else {
                    booleanResultField.setText(FALSE);
                    booleanResultField.setStyle(" -fx-border-color: red;\n" +
                            "    -fx-background-color: red;\n" +
                            "    -fx-border-radius: 0;\n" +
                            "    -fx-border-width: 2px;\n" +
                            "    -fx-text-fill: #000;\n" +
                            "    -fx-prompt-text-fill: #000;");
                    lab.setText(STATUS_FALSE);
                    lab.setStyle("-fx-text-fill: #ec0b0b;");
                }
                booleanResultField.setEditable(false);
                booleanResultField.setDisable(true);
                booleanResultField.setCursor(Cursor.HAND);
            }catch (Exception e) {
                lab.setText(STATUS + ": "+e.getMessage());
            }
        }
    }

    @FXML
    private void plaintextCheckFieldClicked(ActionEvent event) throws Exception {

    }

    @FXML
    private void plaintextFieldClicked(ActionEvent event) throws Exception {

    }

    @FXML
    private void hashGeneratedFieldClicked(ActionEvent event) throws Exception {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
