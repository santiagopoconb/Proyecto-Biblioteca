/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelado.Libro;
/**
 *
 * @author santi
 */
public class LibroBd {
    Connection conn;
    
    public LibroBd (){
        conn = ConexionBd.getConnection();
    }

    public void crearLibro(Libro i){
        PreparedStatement st = null;
        
        try {
                        
            String sql = """
                                 INSERT INTO libro (isbn, titulo, autor, anio_publicacion, editorial, cantidad_libros)
                                 VALUES (?, ?, ?, ?, ?, ?)
                                 """;
            st = conn.prepareStatement(sql);
            
            st.setString(1, i.getIsbn());
            st.setString(2, i.getTitulo());
            st.setString(3, i.getAutor());
            st.setInt(4, i.getAnioPublicacion());
            st.setString(5, i.getEditorial());
            st.setInt(6, i.getCantidadLibros());
            
            st.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(LibroBd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null){
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LibroBd.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public boolean verificarLibro(String isb){
        PreparedStatement st = null;
        
        String sql = """
                    SELECT COUNT(*) FROM libro WHERE isbn = ?;
                     """;
        
        try {
            st = conn.prepareStatement(sql);
            
            st.setString(1, isb);
                        
            try (ResultSet rs = st.executeQuery()){
            if (rs.next()){
                return rs.getInt(1) > 0;
            }
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(LibroBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public Libro leerLibro(String isb){
        PreparedStatement st = null;
            ResultSet rs = null;
            Libro u1 = null;
            
        try {
           String sql = """
                        SELECT * FROM libro WHERE isbn = ?;
                        """;
            
            st = conn.prepareStatement(sql);
            st.setString(1, isb);
            rs = st.executeQuery();
            
            if (rs.next()){
                u1 = new Libro();
                u1.setIsbn(rs.getString("isbn"));
                u1.setTitulo(rs.getString("titulo"));
                u1.setAutor(rs.getString("autor"));
                u1.setAnioPublicacion(rs.getInt("anio_publicacion"));
                u1.setEditorial(rs.getString("editorial"));
                u1.setCantidadLibros(rs.getInt("cantidad_libros"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroBd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null){
                    rs.close();
                } 
                
                if (st != null){
                st.close();
                }        
            } catch (SQLException ex) {
                    Logger.getLogger(LibroBd.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        return u1;
    }
    
    public void eliminarLibro(String isb){
        PreparedStatement st = null;
        
        try {
                    
            String sql = """
                                 DELETE FROM libro WHERE isbn = ?;
                                 """;
            
            st = conn.prepareStatement(sql);
            st.setString(1, isb);
            st.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(LibroBd.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (st != null){
            try {
                st.close();
                }        
             catch (SQLException ex) {
                    Logger.getLogger(LibroBd.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }    
    }
    
    public void actualizarLibro(Libro u2){
        PreparedStatement st = null;
        
        try {
                    
            String sql = """
                                 UPDATE libro SET titulo = ?, autor = ?, anio_publicacion = ?, editorial = ?, cantidad_libros = ?
                                    WHERE isbn = ?;
                                 """;
            
            st = conn.prepareStatement(sql);
            
            st.setString(1, u2.getTitulo());
            st.setString(2, u2.getAutor());
            st.setInt(3, u2.getAnioPublicacion());
            st.setString(4, u2.getEditorial());
            st.setInt(5, u2.getCantidadLibros());
            st.setString(6, u2.getIsbn());
            
            st.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(LibroBd.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (st != null){
            try {
                st.close();
                }        
             catch (SQLException ex) {
                    Logger.getLogger(LibroBd.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
    }
    
    public ArrayList<Libro> mostrarTodo(){
        Statement st = null;
        ResultSet rs = null;
        ArrayList<Libro> a = new ArrayList();
        
        try {          
            String sql ="""
                                    SELECT * FROM libro
                                    """;
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                Libro e = new Libro();
                
                e.setIsbn(rs.getString("isbn"));
                e.setTitulo(rs.getString("titulo"));
                e.setAutor(rs.getString("autor"));
                e.setAnioPublicacion(rs.getInt("anio_publicacion"));
                e.setEditorial(rs.getString("editorial"));
                e.setCantidadLibros(rs.getInt("cantidad_libros"));
                
                a.add(e);
            }
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(LibroBd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null){
                    rs.close();
                } 
                
                if (st != null){
                st.close();
                }        
            } catch (SQLException ex) {
                    Logger.getLogger(LibroBd.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        return null;
    }
    
}

