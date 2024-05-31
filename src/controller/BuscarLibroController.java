/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import baseDatos.LibroBd;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import modelado.Libro;

/**
 * FXML Controller class
 *
 * @author santi
 */
public class BuscarLibroController implements Initializable {

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
    private Button btnBuscarIsbn;
    @FXML
    private Button btnBuscarTitulo;
    @FXML
    private Button btnBuscarAutor;
    @FXML
    private Button btnOrdenIsbn;
    @FXML
    private Button btnOrdenTitulo;
    @FXML
    private Button btnOrdenAutor;
    @FXML
    private Button btnLimpiar;
    @FXML
    private Button btnPrestar;
    @FXML
    private TableView tablaLibro;
    @FXML
    private TableColumn<Libro, Boolean> seleccionColumna;
    @FXML
    private TableColumn<Libro, String> isbnColumna;
    @FXML
    private TableColumn<Libro, String> tituloColumna;
    @FXML
    private TableColumn<Libro, String> autorColumna;
    @FXML
    private TableColumn<Libro, Integer> anioColumna;
    @FXML        
    private TableColumn<Libro, String> editorialColumna;
    @FXML        
    private TableColumn<Libro, Integer> cantidadColumna;
    
    private ObservableList<Libro> libros;
    
    @FXML
    public void eventKey (KeyEvent event){
        
    }
    
    @FXML
    public void eventKeyBuscarIsbn (ActionEvent event){
        
        String isbn = txtIsbn.getText().trim();
        if (!isbn.isEmpty()) {
            ObservableList<Libro> filteredList = libros.stream()
                    .filter(libro -> libro.getIsbn().contains(isbn))
                    .collect(Collectors.toCollection(FXCollections::observableArrayList));
            tablaLibro.setItems(filteredList);
        } else {
            tablaLibro.setItems(libros);
        }
    }
    
    @FXML
    public void eventKeyOrdenIsbn(ActionEvent event){
        FXCollections.sort(libros, Comparator.comparing(Libro::getIsbn));
        tablaLibro.setItems(libros);
    }
    
    @FXML
    public void eventKeyBuscarTitulo (ActionEvent event){
        String titulo = txtTitulo.getText().trim();
        if (!titulo.isEmpty()) {
            ObservableList<Libro> filteredList = libros.stream()
                    .filter(libro -> libro.getTitulo().contains(titulo))
                    .collect(Collectors.toCollection(FXCollections::observableArrayList));
            tablaLibro.setItems(filteredList);
        } else {
            tablaLibro.setItems(libros);
        }
    }
    
    @FXML
    public void eventKeyOrdenTitulo (ActionEvent event){
        FXCollections.sort(libros, Comparator.comparing(Libro::getTitulo));
        tablaLibro.setItems(libros);
    }
    
    @FXML
    public void eventKeyBuscarAutor (ActionEvent event){
        String autor = txtAutor.getText().trim();
        if (!autor.isEmpty()) {
            ObservableList<Libro> filteredList = libros.stream()
                    .filter(libro -> libro.getAutor().contains(autor))
                    .collect(Collectors.toCollection(FXCollections::observableArrayList));
            tablaLibro.setItems(filteredList);
        } else {
            tablaLibro.setItems(libros);
        }
    }
    
    @FXML
    public void eventKeyOrdenAutor (ActionEvent event){
        FXCollections.sort(libros, Comparator.comparing(Libro::getAutor));
        tablaLibro.setItems(libros);
    }
    
    @FXML
    public void eventKeyLimpiar (ActionEvent event){
    txtIsbn.clear();
    txtTitulo.clear();
    txtAutor.clear();
    tablaLibro.setItems(libros);
    }
   
    @FXML
    public void eventKeyPrestar (ActionEvent event){
  
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        isbnColumna.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        tituloColumna.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        autorColumna.setCellValueFactory(new PropertyValueFactory<>("autor"));
        anioColumna.setCellValueFactory(new PropertyValueFactory<>("anioPublicacion"));
        editorialColumna.setCellValueFactory(new PropertyValueFactory<>("editorial"));
        cantidadColumna.setCellValueFactory(new PropertyValueFactory<>("cantidadLibros"));

        seleccionColumna.setCellValueFactory(cellData -> cellData.getValue().seleccionProperty());
        seleccionColumna.setCellFactory(CheckBoxTableCell.forTableColumn(seleccionColumna));

        libros = FXCollections.observableArrayList();
        tablaLibro.setItems(libros);

        cargarLibros();


    }
    
    
    private void cargarLibros() {
        LibroBd libroBd = new LibroBd();
        ArrayList<Libro> listaLibros = libroBd.mostrarTodo();
        libros.addAll(listaLibros);
    }
  
}

