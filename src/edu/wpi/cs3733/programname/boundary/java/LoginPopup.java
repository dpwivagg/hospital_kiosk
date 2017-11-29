package edu.wpi.cs3733.programname.boundary.java;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import edu.wpi.cs3733.programname.ManageController;

public class LoginPopup {
    @FXML
    private Button btnSubmit;
    @FXML
    private Button btnCancel;
    @FXML
    private JFXTextField txtUser;
    @FXML
    private JFXPasswordField txtPass;

    private ManageController manager;
    boolean succesfulLogin;

    public void buttonHandler(ActionEvent e){
        System.out.println("a button was clicked");
        if(e.getSource() == btnSubmit){
            succesfulLogin = true;
            //succesfulLogin = manager.login(txtUser.getText(), txtPass.getText());
            if(succesfulLogin) {
                System.out.println("logging in");
                btnSubmit.getScene().getWindow().hide();
            }
            else{
                System.out.println("login failed");
                txtPass.setText("");
                txtUser.setText("");
            }
        }
        else{
            btnSubmit.getScene().getWindow().hide();
            succesfulLogin = false;
        }
    }
    public boolean getLoggedIn(){
        return succesfulLogin;
    }
}