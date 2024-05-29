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
public class ModificarLibroController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField txtModificarLi;
    @FXML
    private TextField txtTitulo;
    @FXML
    private TextField txtAutor;
    @FXML
    private TextField txtAnio;
    @FXML
    private TextField txtEditorial;
    @FXML
    private TextField txtCantidad;
    @FXML
    private TextField txtTituloEd;
    @FXML
    private TextField txtAutorEdi;
    @FXML
    private TextField txtAnioEd;
    @FXML
    private TextField txtEditorialEd;
    @FXML
    private TextField txtCantidadEd;
    @FXML
    private Button btnBuscarLi;
    @FXML
    private Button btnActualizarLi;
    
    Mensajes mostrarAlerta = new Mensajes();
    
    @FXML
    public void eventKey(KeyEvent event){
        
    }
    
    @FXML
    public void eventKeyBuscarLibro(ActionEvent event){
        String isbn = txtModificarLi.getText();
        
        LibroBd nuevaConsulta = new LibroBd();
        Libro id = nuevaConsulta.leerLibro(isbn);
       
        if(id != null){
            txtTitulo.setText(id.getTitulo());
            txtAutor.setText(id.getAutor());
            txtAnio.setText(String.valueOf(id.getAnioPublicacion()));
            txtEditorial.setText(id.getEditorial());
            txtCantidad.setText(String.valueOf(id.getCantidadLibros()));
            
            
        } else {
            mostrarAlerta.crearMensaje("Error", "Usuario no existe");
        }
    }
    
    @FXML
    public void eventKeyActualizarLibro(ActionEvent event){
        String isbn = txtModificarLi.getText();
        String titulo = txtTituloEd.getText();
        String autor = txtAutorEdi.getText();
        String anioTemp = txtAnioEd.getText();
        String editorial = txtEditorialEd.getText();
        String cantidadTemp = txtCantidadEd.getText();
                
        if(titulo.isEmpty()
                && autor.isEmpty()
                && anioTemp.isEmpty()
                && editorial.isEmpty()
                && cantidadTemp.isEmpty()){
            mostrarAlerta.crearMensaje("Aviso", "No hay campos a modificar");
        return;
        }
                
        LibroBd nuevaConsulta = new LibroBd();
        Libro id = nuevaConsulta.leerLibro(isbn);
        
        
        if(!titulo.isEmpty()){
            id.setTitulo(titulo);
        }
        
        if(!autor.isEmpty()){
            id.setAutor(autor);
        }
        
        if(!anioTemp.isEmpty()){
            int anio;
                try{
                anio = Integer.parseInt(anioTemp);
                id.setAnioPublicacion(anio);
                } catch (NumberFormatException e){
                mostrarAlerta.crearMensaje("Error", "Formato incorrecto");
                return;
                }
        }
        
        if(!editorial.isEmpty()){
            id.setEditorial(editorial);
        }
        
        if(!cantidadTemp.isEmpty()){
            int cantidad;
                try{
                cantidad = Integer.parseInt(cantidadTemp);
                id.setCantidadLibros(cantidad);
                } catch (NumberFormatException e){
                mostrarAlerta.crearMensaje("Error", "Formato incorrecto");
                return;
                }
        }
                
        nuevaConsulta.actualizarLibro(id);
        limpiarCampos();
        
        mostrarAlerta.crearMensaje("Aviso", "Usuario modificado correctamente");
    }
            
            
            
            
            
            
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void limpiarCampos(){
        txtModificarLi.clear();
        txtTitulo.clear();
        txtAutor.clear();
        txtAnio.clear();
        txtEditorial.clear();
        txtCantidad.clear();
        txtTituloEd.clear();
        txtAutorEdi.clear();
        txtAnioEd.clear();
        txtEditorialEd.clear();
        txtCantidadEd.clear();
    }
}
