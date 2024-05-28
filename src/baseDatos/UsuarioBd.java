/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelado.Usuario;
/**
 *
 * @author santi
 */
public class UsuarioBd {
    Connection conn;
    
    public UsuarioBd (){
        conn = ConexionBd.getConnection();
    }
    
    public void crearUsuario (Usuario u){
        PreparedStatement st = null;
        
        try {
            String sql ="""
                                INSERT INTO usuario (identificacion, nombres, apellidos, direccion, telefono, correo, contrasenia, tipo_usuario, id_usuario)
                                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
                                             """;
            
            st = conn.prepareStatement(sql);
            
            st.setString(1, u.getIdentificacion());
            st.setString(2, u.getNombres());
            st.setString(3, u.getApellidos());
            st.setString(4, u.getDireccion());
            st.setInt(5, u.getTelefono());
            st.setString(6, u.getCorrreo());
            st.setString(7, u.getPassword());
            st.setString(8, u.getRol().name());
            st.setString(9, u.getIdUsuario());
            
            st.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null){
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioBd.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
