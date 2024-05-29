/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import baseDatos.LibroBd;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import modelado.Libro;
import modelado.Mensajes;

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
    private TextField txtEliminarLibro;
    @FXML
    private TextField txtTituloLibro;
    @FXML
    private TextField txtAutorLibro;
    @FXML
    private TextField txtCantidadLibro;
    @FXML
    private Button btnBuscarLibro;
    @FXML
    private Button btnEliminarLibro;
    
    Mensajes mostrarAlerta = new Mensajes();
    
    @FXML
    private void eventKey(KeyEvent event){
        
    }
    
    @FXML
    private void eventKeyBuscarLibro(ActionEvent event){
        String isbn = txtEliminarLibro.getText();
        
        LibroBd nuevaConsulta = new LibroBd();
        Libro id = nuevaConsulta.leerLibro(isbn);
       
        if(id != null){
            txtTituloLibro.setText(id.getTitulo());
            txtAutorLibro.setText(id.getAutor());
            txtCantidadLibro.setText(String.valueOf(id.getCantidadLibros()));
        } else {
            mostrarAlerta.crearMensaje("Error", "Libro no existe");
        }
    }
    
    @FXML
    private void eventKeyEliminarLibro(ActionEvent event){
        String isbn = txtEliminarLibro.getText();
        LibroBd eliminarRegistro = new LibroBd();
        eliminarRegistro.eliminarLibro(isbn);
        mostrarAlerta.crearMensaje("Aviso", "Registro eliminado correctamente");
        limpiarCampos();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void limpiarCampos(){
    txtEliminarLibro.clear();
    txtTituloLibro.clear();
    txtAutorLibro.clear();
    txtCantidadLibro.clear();
    }
}
