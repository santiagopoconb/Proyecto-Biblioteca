/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author santi
 */
public class MantenimientoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btnAgregarLibro;
    @FXML
    private Button btnModificarLibro;
    @FXML
    private Button btnEliminarLibro;
    @FXML
    private Button btnCrearUsuario;
    @FXML
    private Button btnModificarUsuario;
    @FXML
    private Button btnEliminarUsuario;
    @FXML
    private StackPane stackLibro;
    @FXML
    private StackPane stackUsuario;
    @FXML
    public void eventKeyAgregarLibro(){
        
    }
    @FXML
    public void eventKeyModificarLibro(){
        
    }
    @FXML
    public void eventKeyElminarLIibro(){
        
    }
    @FXML
    public void eventKeyCrearUsuario(){
        
    }
    @FXML
    public void eventKeyModificarUsuario(){
        
    }
    @FXML
    public void eventKeyEliminarUsuario(){
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btnCrearUsuario.setOnAction(event -> vistaVentanaUsuario("/visual/CrearUsuarioAdmin.fxml"));
        btnModificarUsuario.setOnAction(event -> vistaVentanaUsuario("/visual/ModificarUsuario.fxml"));
        btnEliminarUsuario.setOnAction(event -> vistaVentanaUsuario("/visual/EliminarUsuario.fxml"));
        
        btnAgregarLibro.setOnAction(event -> vistaVentanaLibro("/visual/CrearLibro.fxml"));
        btnModificarLibro.setOnAction(event -> vistaVentanaLibro("/visual/ModificarLibro.fxml"));
        btnEliminarLibro.setOnAction(event -> vistaVentanaLibro("/visual/EliminarLibro.fxml"));
        
    }    
    
    private void vistaVentanaUsuario (String fxml){
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            
            stackUsuario.getChildren().clear();
            stackUsuario.getChildren().add(root);
            
        } catch (IOException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void vistaVentanaLibro (String fxml){
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            
            stackLibro.getChildren().clear();
            stackLibro.getChildren().add(root);
            
        } catch (IOException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
