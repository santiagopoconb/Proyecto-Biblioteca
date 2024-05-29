/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelado;

import baseDatos.LibroBd;
import java.util.ArrayList;


/**
 *
 * @author santi
 */
public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private String editorial;
    private int cantidadLibros;
    ArrayList<Libro> listaLibros = new ArrayList<>();
    
    public Libro(){
        
    }
    
    public Libro(String isbn, String titulo, String autor, int anioPublicacion, String editorial, int cantidadLibros) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.editorial = editorial;
        this.cantidadLibros = cantidadLibros;
    }  
    
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getCantidadLibros() {
        return cantidadLibros;
    }

    public void setCantidadLibros(int cantidadLibros) {
        this.cantidadLibros = cantidadLibros;
    }
    
    public void agregarLibro(Libro nuevoLibro){
        LibroBd nuevoLibroBd = new LibroBd();
        nuevoLibroBd.crearLibro(nuevoLibro);
    }
    
    public void listaLibros (){
        LibroBd a = new LibroBd();
        
        ArrayList <Libro> e = a.mostrarTodo();
        for(Libro libro:e){
            System.out.println(libro);
        }
        //return e;
    }
    
    /*public void agregarLibro(Libro nuevoLibro){
        listaLibros.add(nuevoLibro);
        for (Libro impresion:listaLibros){
            System.out.println(impresion.getIsbn() + "-"
                    + impresion.getTitulo() + "-"
                    + impresion.getAutor() + "-"
                    + impresion.getAnioPublicacion() + "-"
                    + impresion.getEditorial() + "-"
                    + impresion.getCantidadLibros());
        }
    }
    */

    @Override
    public String toString() {
        return  isbn + titulo +  autor +  anioPublicacion +  editorial +  cantidadLibros;
    }
    
}
