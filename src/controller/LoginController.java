/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author santi
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txUsuario;
    
    @FXML
    private PasswordField txContrasenia;
    
    @FXML
    private Button btnIngresar;
    
    @FXML
    private Button btnAgregarUsuarioCliente;
    
    @FXML
    private Button btnResetContrasenia;
    
    @FXML
    private void eventKey(KeyEvent event){
        
    }
    
    @FXML
    private void eventAction (ActionEvent event){
        String cui = "abc";
        String pass = "12345";
        
        String identificacion = txUsuario.getText();
        String contrasenia = txContrasenia.getText();
        
        if (identificacion.equals(cui) && contrasenia.equals(pass)){
        mostrarAlerta("Bienvenido","Ingreso existoso");
        cerrarVentana();
        } else {
            mostrarAlerta("Error", "Usuario o contrasenia incorrecta");
        }
        
    }
    
    @FXML
    private void eventAction2(ActionEvent event){
        mostrarAlerta("Crear Usuario", "Metodo para agrebar usuario cliente");
    }
    
    @FXML
    private void eventAction3(ActionEvent event){
        mostrarAlerta("Reset", "Metodo poara reinicio de contrasenia");
    }
    
    private void mostrarAlerta (String titulo, String mensaje){
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
    
    private void cerrarVentana (){
        Stage stage = (Stage) btnIngresar.getScene().getWindow();
        stage.close();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
