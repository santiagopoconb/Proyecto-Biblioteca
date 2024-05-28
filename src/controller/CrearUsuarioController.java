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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import modelado.Usuario;
import static modelado.Usuario.TipoUsuario.cliente;
import modelado.Cliente;
import modelado.Mensajes;

/**
 * FXML Controller class
 *
 * @author santi
 */
public class CrearUsuarioController implements Initializable {
    @FXML
    private TextField txtIdentificacion;
    
    @FXML
    private TextField txtNombres;
    
    @FXML
    private TextField txtApellidos;
    
    @FXML
    private TextField txtTelefono;
    
    @FXML
    private TextField txtDireccion;
    
    @FXML
    private TextField txtCorreo;
    
    @FXML
    private TextField txtCorreoConfirmacion;
    
    @FXML
    private PasswordField txtConrasenia;
    
    @FXML
    private PasswordField txtContraseniaConfirmacion;
    
    @FXML
    private Button btnCrearUsuarioCliente;
        
    Mensajes mostrarAlerta = new Mensajes(); 
        
    @FXML
    private void eventKey(KeyEvent event){
    }
    
    @FXML
    private void eventKeyNewUsuarioClient(ActionEvent event){
        
    String identificacion = txtIdentificacion.getText();
    String nombres = txtNombres.getText();
    String apellidos = txtApellidos.getText();
    String direccion = txtDireccion.getText();
    String telefonoTemp = txtTelefono.getText();
    String correo = txtCorreo.getText();
    String correoConfirmacion = txtCorreoConfirmacion.getText();
    String password = txtConrasenia.getText();
    String passwordConfirmacion = txtContraseniaConfirmacion.getText();
    Usuario.TipoUsuario rol = cliente;
    int telefono;
    
    if (identificacion.isEmpty()
            || nombres.isEmpty()
            || apellidos.isEmpty()
            || direccion.isEmpty()
            || telefonoTemp.isEmpty()
            || correo.isEmpty()
            || correoConfirmacion.isEmpty()
            || password.isEmpty()
            || passwordConfirmacion.isBlank()){
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
        
    Cliente usuarioNuevo = new Cliente(identificacion, nombres, apellidos, direccion, telefono, correo, correoConfirmacion, password, passwordConfirmacion, rol);
    usuarioNuevo.agregarUsuario(usuarioNuevo);
    
    limpiarCampos();

    Stage stage = (Stage) btnCrearUsuarioCliente.getScene().getWindow();
    stage.close();
    
    mostrarAlerta.crearMensaje("Felicidades", "Usuario creado exitosamente");
    
    }
    
    private void limpiarCampos (){
        txtIdentificacion.clear();
        txtNombres.clear();
        txtApellidos.clear();
        txtDireccion.clear();
        txtTelefono.clear();
        txtCorreo.clear();
        txtCorreoConfirmacion.clear();
        txtConrasenia.clear();
        txtContraseniaConfirmacion.clear();
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
