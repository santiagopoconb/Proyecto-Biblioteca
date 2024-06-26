/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelado;

import java.sql.*;
import baseDatos.UsuarioBd;
import java.util.ArrayList;

/**
 *
 * @author santi
 */
public class Usuario {
    private String identificacion;
    private String nombres;
    private String apellidos;
    private String direccion;
    private int telefono;
    private String correo;
    private String correoConfirmacion;
    private String password;
    private String passwordConfirmacion;
    private TipoUsuario rol;
    private String idUsuario;
    private static int contadorIdUsuario = 1;
    
    public enum TipoUsuario{
        admin,
        cliente
    }
    
    ArrayList <Usuario> listaUsuario = new ArrayList<>();
    
    public String getIdentificacion() {
        return identificacion;
    }
    
    public Usuario(){
        
    }
    
    public Usuario(String identificacion, String nombres, String apellidos, String direccion, int telefono, String corrreo, String correoConfirmacion, String password, String passwordConfirmacion, TipoUsuario rol) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = corrreo;
        this.correoConfirmacion = correoConfirmacion;
        this.password = password;
        this.passwordConfirmacion = passwordConfirmacion;
        this.rol = rol;
        this.idUsuario = generarIdUusario();
    }

    public String getIdUsuario() {
        return idUsuario;
    }
    
    public String getCorreoConfirmacion() {
        return correoConfirmacion;
    }

    public void setCorreoConfirmacion(String correoConfirmacion) {
        this.correoConfirmacion = correoConfirmacion;
    }

    public String getPasswordConfirmacion() {
        return passwordConfirmacion;
    }

    public void setPasswordConfirmacion(String passwordConfirmacion) {
        this.passwordConfirmacion = passwordConfirmacion;
    }

    public ArrayList<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(ArrayList<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public TipoUsuario getRol() {
        return rol;
    }

    public void setRol(TipoUsuario rol) {
        this.rol = rol;
    }

    public String getCorrreo() {
    return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public void agregarUsuario (Usuario usuarioNuevo){
        UsuarioBd nuevoUsuariobd = new UsuarioBd();
        nuevoUsuariobd.crearUsuario(usuarioNuevo);
    }
    
    public static Usuario leerUsuario (String identificacion){
        UsuarioBd nuevaConsulta = new UsuarioBd();
        Usuario u1 = nuevaConsulta.leerUsuario(identificacion);
        System.out.println(u1);
        return u1;
    }
    
    /*public void agregarUsuario(Usuario usuarioNuevo){
     listaUsuario.add(usuarioNuevo);
     for (Usuario impresion:listaUsuario){
         System.out.println(impresion.getIdentificacion()
         + impresion.getNombres()
         + impresion.getApellidos()
         + impresion.getTelefono()
         + impresion.getDireccion()
         + impresion.getCorrreo()
         + impresion.getPassword()
         + impresion.getRol()
         + impresion.getIdUsuario());
     }
    }
    */
    
    private String generarIdUusario(){
        return identificacion + contadorIdUsuario++;
    }

    @Override
    public String toString() {
        return "Usuario{" + "identificacion=" + identificacion + ", nombres=" + nombres + ", apellidos=" + apellidos + ", direccion=" + direccion + ", telefono=" + telefono + ", correo=" + correo + ", password=" + password + ", rol=" + rol + ", idUsuario=" + idUsuario + '}';
    }
    
    
}
