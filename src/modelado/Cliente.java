/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelado;

/**
 *
 * @author santi
 */
public class Cliente extends Usuario{
    
    public Cliente(String identificacion, String nombres, String apellidos, String direccion, int telefono, String corrreo, String correoConfirmacion, String password, String passwordConfirmacion, TipoUsuario rol) {
        super(identificacion, nombres, apellidos, direccion, telefono, corrreo, correoConfirmacion, password, passwordConfirmacion, rol);
    }
    
}
