/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;

import java.sql.*;
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
            Logger.getLogger(UsuarioBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}

