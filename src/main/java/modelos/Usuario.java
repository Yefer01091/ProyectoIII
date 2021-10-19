/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;

/**
 * 
 * @author Sergio Enrique Jair Gonzalez Arcos>
 */
public class Usuario {
   private int Id; 
   private String correo;
   private String contrasena;

    public Usuario() {
    }

    public Usuario(int Id, String correo, String contrasena) {
        this.Id = Id;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public Usuario(String correo, String contrasena) {
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
  

   
}
