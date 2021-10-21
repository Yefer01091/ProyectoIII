/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Sergio Enrique Jair Gonzalez Arcos>
 */
public class Estudiante {

    private int id;
    private String sexo;
    private int edad;
    private String cedula;
    private String telefono;
    private String semestre;
    private int idusuario;
    private String nombre;
    private String apellido;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Estudiante(String sexo, int edad, String cedula, String telefono, String semestre, int idusuario, String nombre, String apellido) {
        this.sexo = sexo;
        this.edad = edad;
        this.cedula = cedula;
        this.telefono = telefono;
        this.semestre = semestre;
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Estudiante() {
    }

    public Estudiante(int id) {
        this.id = id;
    }

    public Estudiante(int id, String sexo, int edad, String cedula, String telefono, String semestre, int idusuario, String nombre, String apellido) {
        this.id = id;
        this.sexo = sexo;
        this.edad = edad;
        this.cedula = cedula;
        this.telefono = telefono;
        this.semestre = semestre;
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.apellido = apellido;
    }

 

    @Override
    public String toString() {
        return "Estudiante{" + "id=" + id + ", sexo=" + sexo + ", edad=" + edad + ", cedula=" + cedula + ", telefono=" + telefono + ", semestre=" + semestre + ", idusuario=" + idusuario + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }
    

}
