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
public class PrincipalController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btnBuscarLibro;
    
    @FXML
    private Button btnHistorial;
    
    @FXML
    private Button btnMatenimiento;
    
    @FXML
    private Button btnPrestamo;
    
    @FXML
    private StackPane stackContenido;
    
    @FXML
    public void eventKeyBuscarLibro(){
        
    }
    
    @FXML
    public void eventKeyHistorial (){
        
    }
    
    @FXML
    public void eventKeyMantenimiento() {
        
    }
    
    @FXML
    public void eventKeyPrestamo () {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        btnBuscarLibro.setOnAction(event -> vistaVentana("/visual/BuscarLibro.fxml"));
        btnMatenimiento.setOnAction(event -> vistaVentana("/visual/Mantenimiento.fxml"));
    }  
    
    // Metodo que llama a la venta a mostar según el boton seleccionado
     private void vistaVentana (String fxml){
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            
            stackContenido.getChildren().clear();
            stackContenido.getChildren().add(root);
            
        } catch (IOException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
