/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelado.Usuario;
import modelado.Usuario.TipoUsuario;
/**
 *
 * @author santi
 */
public class UsuarioBd {
    Connection conn;
    
    public UsuarioBd (){
        conn = ConexionBd.getConnection();
    }
    
    //Crear usuario en la base de datos
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
    
    public boolean verificarUsuario(String identificacion, String contrasenia){
        PreparedStatement st = null;
        
        String sql = """
                     SELECT COUNT(*) FROM usuario WHERE identificacion = ? AND contrasenia = ?;
                     """;
        
        try {
            st = conn.prepareStatement(sql);
            
            st.setString(1, identificacion);
            st.setString(2, contrasenia);
            
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
    
    public boolean verificarIdentificacion (String identificacion){
        PreparedStatement st = null;
        
        String sql = """
                     SELECT COUNT(*) FROM usuario WHERE identificacion = ?;
                     """;
        
        try {
            st = conn.prepareStatement(sql);
            
            st.setString(1, identificacion);
                        
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
    
    //Leer usuario de la base de datos
    
    public Usuario leerUsuario(String identificacion){
        PreparedStatement st = null;
            ResultSet rs = null;
            Usuario u1 = null;
            
        try {
           String sql = """
                        SELECT * FROM usuario WHERE identificacion = ?;
                        """;
            
            st = conn.prepareStatement(sql);
            st.setString(1, identificacion);
            rs = st.executeQuery();
            
            if (rs.next()){
                u1 = new Usuario();
                u1.setIdentificacion(rs.getString("identificacion"));
                u1.setNombres(rs.getString("nombres"));
                u1.setApellidos(rs.getString("apellidos"));
                u1.setDireccion(rs.getString("direccion"));
                u1.setTelefono(rs.getInt("telefono"));
                u1.setCorreo(rs.getString("correo"));
                u1.setPassword(rs.getString("contrasenia"));
                u1.setRol(TipoUsuario.valueOf(rs.getString("tipo_usuario")));
                u1.setIdUsuario(rs.getString("id_usuario"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null){
                    rs.close();
                } 
                
                if (st != null){
                st.close();
                }        
            } catch (SQLException ex) {
                    Logger.getLogger(UsuarioBd.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        return u1;
    }
        
    public void eliminarUsuario(String identificacion){
        PreparedStatement st = null;
        
        try {
                    
            String sql = """
                                 DELETE FROM usuario WHERE identificacion = ?;
                                 """;
            
            st = conn.prepareStatement(sql);
            st.setString(1, identificacion);
            st.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBd.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (st != null){
            try {
                st.close();
                }        
             catch (SQLException ex) {
                    Logger.getLogger(UsuarioBd.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }    
    }
    
    public void actualizarUsuario(Usuario u2){
        PreparedStatement st = null;
        
        try {
                    
            String sql = """
                                 UPDATE usuario SET nombres = ?, apellidos = ?, direccion = ?, telefono = ?, correo = ?, contrasenia = ?
                                    WHERE identificacion = ?;
                                 """;
            
            st = conn.prepareStatement(sql);
            
            st.setString(1, u2.getNombres());
            st.setString(2, u2.getApellidos());
            st.setString(3, u2.getDireccion());
            st.setInt(4, u2.getTelefono());
            st.setString(5, u2.getCorrreo());
            st.setString(6, u2.getPassword());
            st.setString(7, u2.getIdentificacion());
            
            st.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBd.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (st != null){
            try {
                st.close();
                }        
             catch (SQLException ex) {
                    Logger.getLogger(UsuarioBd.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
    }
    
}
