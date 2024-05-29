/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import baseDatos.UsuarioBd;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import modelado.Mensajes;
import modelado.Usuario;

/**
 * FXML Controller class
 *
 * @author santi
 */
public class EliminarLibroController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField txtEliminarUsuario;
    @FXML
    private TextField txtNombreUsuario;
    @FXML
    private TextField txtApellidosUsuario;
    @FXML
    private TextField txtCorreoUsuario;
    @FXML
    private Button btnBuscarUsuario;
    @FXML
    private Button btnEliminarUsuario;
    
    Mensajes mostrarAlerta = new Mensajes();
    
    @FXML
    private void eventKey(KeyEvent event){
    }
    
    @FXML
    private void eventKeyBuscarUsuario(ActionEvent event){
        String identificion = txtEliminarUsuario.getText();
        
        UsuarioBd nuevaConsulta = new UsuarioBd();
        Usuario id = nuevaConsulta.leerUsuario(identificion);
       
        if(id != null){
            txtNombreUsuario.setText(id.getNombres());
            
            txtApellidosUsuario.setText(id.getApellidos());
            txtCorreoUsuario.setText(id.getCorrreo());
        } else {
            mostrarAlerta.crearMensaje("Error", "Usuario no existe");
        }        
        
    }
    
    @FXML
    private void eventKeyEliminarUsuario(ActionEvent event){
        String identificion = txtEliminarUsuario.getText();
        UsuarioBd eliminarRegistro = new UsuarioBd();
        eliminarRegistro.eliminarUsuario(identificion);
        mostrarAlerta.crearMensaje("Aviso", "Registro eliminado correctamente");
        limpiarCampos();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void limpiarCampos(){
        txtEliminarUsuario.clear();
        txtNombreUsuario.clear();
        txtApellidosUsuario.clear();
        txtCorreoUsuario.clear();
    }
}
