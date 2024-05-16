/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelado;

import java.util.Scanner;

/**
 *
 * @author santi
 */
public class Admin extends Usuario{
    public String mensajeUsuario = "Ingrese su usuario:";
    public String mensajePassword = "Ingrese su contraseña:";
    Scanner teclado = new Scanner(System.in);
    
    
    public void agregarUsuario(String identificacion, String password){
        System.out.println(mensajeUsuario);
        String intUsuario = teclado.nextLine();
        System.out.println(mensajePassword);
        String intPassword = teclado.nextLine();
        
        if (intUsuario.equals(identificacion) && intPassword.equals(password)) {
            System.out.println("Ingrese los datos del nuevo usuario:");
        } else {
            System.out.println("Usuario o contraseña incorrecta");
        }
        
    }
    
    public void eliminarUsuario(){
        
    }
    
    public void modificarUsuario(){
        
    }
    
}
