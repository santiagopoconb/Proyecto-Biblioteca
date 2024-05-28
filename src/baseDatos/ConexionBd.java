/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santi
 */
public class ConexionBd {
    
    private String url = "jdbc:postgresql://bubble.db.elephantsql.com:5432/icqkmfir";
    private Properties properties = new Properties();
    private static Connection conn = null;

    private ConexionBd() {
        properties.setProperty("user", "icqkmfir");
        properties.setProperty("password", "lPB9Gs_aonXmnDSCpKJ3cpK1XIM9HQ2H");
        
        try {
            conn = DriverManager.getConnection(url, properties);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getConnection(){
        if (conn == null){
            ConexionBd c = new ConexionBd();
            return c.conn;
        } else {
            return conn;
        }
    }
    
}
