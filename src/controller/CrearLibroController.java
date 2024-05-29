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
public class CrearLibroController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField txtIsbn;
    @FXML
    private TextField txtTitulo;
    @FXML
    private TextField txtAutor;
    @FXML
    private TextField txtPublicacion;
    @FXML
    private TextField txtEditorial;
    @FXML
    private TextField txtCantidadLibros;
    @FXML
    private Button btnRegistrarLibro;
    
    Mensajes mostrarAlerta = new Mensajes();
    LibroBd nuevoLibro = new LibroBd();
    
    @FXML
    private void eventKey (KeyEvent event){
        
    }
    
    @FXML
    private void eventKeyCrearLibro(ActionEvent event){
        
        String isbn = txtIsbn.getText();
        String titulo = txtTitulo.getText();
        String autor = txtAutor.getText();
        String anioTemp = txtPublicacion.getText();
        String editorial = txtEditorial.getText();
        String cantidadTemp = txtCantidadLibros.getText();
        int anioPublicacion;
        int cantidadLibros;
        
        if (isbn.isEmpty()
                || titulo.isEmpty()
                || autor.isEmpty()
                || anioTemp.isEmpty()
                || editorial.isEmpty()
                || cantidadTemp.isEmpty()){
            mostrarAlerta.crearMensaje("Error", "Todos los campos son obligatorios");
            return;
        }
        
        try{
            anioPublicacion = Integer.parseInt(anioTemp);
            cantidadLibros = Integer.parseInt(cantidadTemp);
        } catch (NumberFormatException e){
            mostrarAlerta.crearMensaje("Error", "Formato incorrecto");
        return;
        }
        
        if (nuevoLibro.verificarLibro(isbn)){
            mostrarAlerta.crearMensaje("Error", "Libro ya existe");
        } else {
            Libro nuevoLibro = new Libro(isbn, titulo, autor, anioPublicacion, editorial, cantidadLibros);
            nuevoLibro.agregarLibro(nuevoLibro);
        
            limpiarCamposLibro();
        
            mostrarAlerta.crearMensaje("Aviso", "Libro agregado correctamente");
        }
                
    }
    
    private void limpiarCamposLibro(){
        txtIsbn.clear();
        txtTitulo.clear();
        txtAutor.clear();
        txtPublicacion.clear();
        txtEditorial.clear();
        txtCantidadLibros.clear();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
