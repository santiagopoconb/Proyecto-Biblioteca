/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import baseDatos.UsuarioBd;
import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import modelado.Mensajes;

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
    
    Mensajes mostrarAlerta = new Mensajes();
    UsuarioBd nuevoUsuarioBd = new UsuarioBd();
    
    @FXML
    private void eventKey(KeyEvent event){
        
    }
    
    @FXML // Login principal del programa
    private void eventAction (ActionEvent event){
        
        String identificacion = txUsuario.getText();
        String contrasenia = txContrasenia.getText();
        
        if (nuevoUsuarioBd.verificarUsuario(identificacion, contrasenia)){
        
            try {
                cerrarVentana();
                
                Parent root = FXMLLoader.load(getClass().getResource("/visual/Principal.fxml"));
                Scene scene = new Scene(root);
                Stage primaryStage = new Stage();
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        } else {

            mostrarAlerta.crearMensaje("Error", "Usuario o contraseña incorrectos");
        }
        
    }
    
    @FXML // Llama a la ventana para crear usuario cliente
    private void eventAction2(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/visual/CrearUsuario.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setScene(scene);
            primaryStage.show();
            
            //Stage stage = (Stage) btnAgregarUsuarioCliente.getScene().getWindow();
            //stage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void eventAction3(ActionEvent event){
    
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
