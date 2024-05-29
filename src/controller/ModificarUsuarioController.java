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
public class ModificarUsuarioController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField txtModificarUs;
    @FXML
    private TextField txtNombresUs;
    @FXML
    private TextField txtApellidosUs;
    @FXML
    private TextField txtDireccionUs;
    @FXML
    private TextField txtTelefonoUs;
    @FXML
    private TextField txtCorreoUs;
    @FXML
    private TextField txtContraseniaUs;
    @FXML
    private TextField txtNombresUsEd;
    @FXML
    private TextField txtApellidosUsEd;
    @FXML
    private TextField txtDireccionUsEd;
    @FXML
    private TextField txtTelefonoUsEd;
    @FXML
    private TextField txtCorreoUsEd;
    @FXML
    private TextField txtContraseniaUsEd;
    @FXML
    private Button btnBuscarUs;
    @FXML
    private Button btnActualizarUs;
    
    Mensajes mostrarAlerta = new Mensajes();
    
    @FXML
    public void eventKey(KeyEvent event){
        
    }
    
    @FXML
    public void eventKeyBuscarUsuario (ActionEvent event){
        String identificion = txtModificarUs.getText();
        
        UsuarioBd nuevaConsulta = new UsuarioBd();
        Usuario id = nuevaConsulta.leerUsuario(identificion);
       
        if(id != null){
            txtNombresUs.setText(id.getNombres());
            txtApellidosUs.setText(id.getApellidos());
            txtDireccionUs.setText(id.getDireccion());
            txtTelefonoUs.setText(String.valueOf(id.getTelefono()));
            txtCorreoUs.setText(id.getCorrreo());
            txtContraseniaUs.setText(id.getPassword());
            
        } else {
            mostrarAlerta.crearMensaje("Error", "Usuario no existe");
        }      
    }
    
    @FXML
    public void eventKeyActualizarUsuario (ActionEvent event){
        String identificion = txtModificarUs.getText();
        String nombres = txtNombresUsEd.getText();
        String apellidos = txtApellidosUsEd.getText();
        String direccion = txtDireccionUsEd.getText();
        String telefonoTemp = txtTelefonoUsEd.getText();
        String correo = txtCorreoUsEd.getText();
        String password = txtContraseniaUsEd.getText();
        
        if(nombres.isEmpty()
                && apellidos.isEmpty()
                && direccion.isEmpty()
                && telefonoTemp.isEmpty()
                && correo.isEmpty()
                && password.isEmpty()){
            mostrarAlerta.crearMensaje("Aviso", "No hay campos a modificar");
        return;
        }
                
        UsuarioBd nuevaConsulta = new UsuarioBd();
        Usuario id = nuevaConsulta.leerUsuario(identificion);
        
        
        if(!nombres.isEmpty()){
            id.setNombres(nombres);
        }
        
        if(!apellidos.isEmpty()){
            id.setApellidos(apellidos);
        }
        
        if(!direccion.isEmpty()){
            id.setDireccion(direccion);
        }
        
        if(!telefonoTemp.isEmpty()){
            int telefono;
                try{
                telefono = Integer.parseInt(telefonoTemp);
                id.setTelefono(telefono);
                } catch (NumberFormatException e){
                mostrarAlerta.crearMensaje("Error", "Formato incorrecto");
                return;
                }
        }
        
        if(!correo.isEmpty()){
            id.setCorreo(correo);
        }
        
        if(!password.isEmpty()){
            id.setPassword(password);
        }
                
        nuevaConsulta.actualizarUsuario(id);
        limpiarCampos();
        
        mostrarAlerta.crearMensaje("Aviso", "Usuario modificado correctamente");
    }
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void limpiarCampos(){
    txtModificarUs.clear();
    txtNombresUs.clear();
    txtApellidosUs.clear();
    txtDireccionUs.clear();
    txtTelefonoUs.clear();
    txtCorreoUs.clear();
    txtContraseniaUs.clear();
    txtNombresUsEd.clear();
    txtApellidosUsEd.clear();
    txtDireccionUsEd.clear();
    txtTelefonoUsEd.clear();
    txtCorreoUsEd.clear();
    txtContraseniaUsEd.clear();
    }
}
