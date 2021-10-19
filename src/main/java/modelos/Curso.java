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
public class Curso {
   private int id;
   private String profesor;
   private String nombre;
   private String jornada;
   private int codigo;

    public Curso() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    

    public Curso(int idCurso) {
        this.id = idCurso;
    }

    public Curso(String profesor, String nombre, String jornada, int codigo) {
        this.profesor = profesor;
        this.nombre = nombre;
        this.jornada = jornada;
        this.codigo = codigo;
    }

    public Curso(int id, String profesor, String nombre, String jornada, int codigo) {
        this.id = id;
        this.profesor = profesor;
        this.nombre = nombre;
        this.jornada = jornada;
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Curso{" + "idCurso=" + id + ", profesor=" + profesor + ", nombre=" + nombre + ", jornada=" + jornada + ", codigo=" + codigo + '}';
    }
   

}
