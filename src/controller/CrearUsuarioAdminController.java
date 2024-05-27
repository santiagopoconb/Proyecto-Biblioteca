/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import modelado.Admin;
import modelado.Mensajes;
import modelado.Usuario;
import modelado.Usuario.TipoUsuario;

/**
 * FXML Controller class
 *
 * @author santi
 */
public class CrearUsuarioAdminController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField txtIdentificacionAdmin;
    @FXML
    private TextField txtNombresAdmin;
    @FXML
    private TextField txtApellidosAdmin;
    @FXML
    private TextField txtTelefonoAdmin;
    @FXML
    private TextField txtDireccionAdmin;
    @FXML
    private TextField txtCorreoAdmin;
    @FXML
    private TextField txtCorreoConfirmacionAdmin;
    @FXML
    private PasswordField txtConraseniaAdmin;
    @FXML
    private PasswordField txtContraseniaConfirmacionAdmin;
    @FXML
    private ComboBox<TipoUsuario> txtRolAdmin;
    @FXML
    private Button btnCrearUsuarioAdmin;
    Mensajes mostrarAlerta = new Mensajes();
    @FXML
    private void eventKey(KeyEvent event){
    }
    
    @FXML
    private void eventKeyNewUsuarioAdmin(ActionEvent event){
        
        String identificacion = txtIdentificacionAdmin.getText();
        String nombres = txtNombresAdmin.getText();
        String apellidos = txtApellidosAdmin.getText();
        String telefonoTemp =  txtTelefonoAdmin.getText();
        String direccion = txtDireccionAdmin.getText();
        String correo = txtCorreoAdmin.getText();
        String correoConfirmacion = txtCorreoConfirmacionAdmin.getText();
        String password = txtConraseniaAdmin.getText();
        String passwordConfirmacion = txtContraseniaConfirmacionAdmin.getText();
        Usuario.TipoUsuario rolAdmin = txtRolAdmin.getValue();
        int idUsuario= 1;
        int telefono;
        
        if (identificacion.isEmpty()
            || nombres.isEmpty()
            || apellidos.isEmpty()
            || telefonoTemp.isEmpty()
            || direccion.isEmpty()
            || correo.isEmpty()
            || correoConfirmacion.isEmpty()
            || password.isEmpty()
            || passwordConfirmacion.isBlank()
            || rolAdmin == null){
        
            mostrarAlerta.crearMensaje("Error", "Todos los campos son obligatorios");
        return;
    }
        try{
        telefono = Integer.parseInt(telefonoTemp);
    } catch (NumberFormatException e){
        mostrarAlerta.crearMensaje("Error", "Formato incorrecto");
        return;
    }
        
    if(!correo.equals(correoConfirmacion) || !password.equals(passwordConfirmacion)){
        mostrarAlerta.crearMensaje("Error", "Error en confirmación de correo o contraseña");
        return;
    }
        Admin usuarioNuevo = new Admin (identificacion, nombres, apellidos, direccion, telefono, correo, correoConfirmacion, password, passwordConfirmacion, rolAdmin, idUsuario);
        usuarioNuevo.agregarUsuario(usuarioNuevo);
        
        limpiarCampos();
        
        Stage stage = (Stage) btnCrearUsuarioAdmin.getScene().getWindow();
        stage.close();
    
        mostrarAlerta.crearMensaje("Felicidades", "Usuario creado exitosamente");
    }
       
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        txtRolAdmin.getItems().setAll(TipoUsuario.values());
    }    
    
    public void limpiarCampos(){
        txtIdentificacionAdmin.clear();
        txtNombresAdmin.clear();
        txtApellidosAdmin.clear();
        txtTelefonoAdmin.clear();
        txtDireccionAdmin.clear();
        txtCorreoAdmin.clear();
        txtCorreoConfirmacionAdmin.clear();
        txtConraseniaAdmin.clear();
        txtContraseniaConfirmacionAdmin.clear();
        txtRolAdmin.setValue(null);
    }
    
}
