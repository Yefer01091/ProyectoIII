/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.Estudiante;

/**
 * 
 * @author Sergio Enrique Jair Gonzalez Arcos>
 */
public class EstudianteDaoJDBC {
     private  static  final  String sql_select="SELECT * FROM  alumno";
    private  static  final  String sql_select_by_id="SELECT * FROM  alumno where id = ? ";
    private  static  final  String sql_insert="INSERT INTO  alumno (sexo,edad,cedula,telefono,semestre,idusuario,nombre,apellido)  VALUES ( ?,?,?,?,?,?,?,?)";
    private  static  final  String sql_update="UPDATE  alumno set(sexo=?,edad=?,cedula=?,telefono=?,semestre=?,idusuario=?,nombre=?,apellido=?) where id = ? ";
    private  static  final  String sql_delete ="DELETE FROM alumno  where id = ? ";
    
    public List<Estudiante> listar () {
        
            Connection  conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            Estudiante  estudiante = null;
            List<Estudiante> estudiantes = new ArrayList<>();
            
            try {
            conn=Conexion.getConnection();
            stmt=conn.prepareStatement(sql_select);
            rs =stmt.executeQuery();
            
            while(rs.next()){
            int id =rs.getInt("id");
            String sexo = rs.getString("sexo");
            int edad = rs.getInt("edad");
            String cedula = rs.getString("cedula");
            String telefono = rs.getString("telefono");
            String semestre = rs.getString("semestre");
            int idusuario = rs.getInt("idusuario");
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
           
            estudiante  = new Estudiante(id,sexo,edad,cedula,telefono,semestre,idusuario,nombre,apellido);
            estudiantes.add(estudiante);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
            finally{
            Conexion.close(stmt);
            Conexion.close(rs);
            Conexion.close(conn);
            
            }
        
            return  estudiantes;
    
    }
    
      public int insertar (Estudiante estudiante){
           Connection  conn = null;
            PreparedStatement stmt = null;
            int rows=0;
            
            
            try {
            conn=Conexion.getConnection();
            stmt=conn.prepareStatement(sql_insert);
            stmt.setString(1,estudiante.getSexo());
            stmt.setInt(2, estudiante.getEdad());
            stmt.setString(3,estudiante.getCedula() );
            stmt.setString(4, estudiante.getTelefono());
            stmt.setString(5,estudiante.getSemestre());
            stmt.setInt(6, estudiante.getIdusuario());
            stmt.setString(7,estudiante.getNombre() );
            stmt.setString(8, estudiante.getApellido());
           rows=stmt.executeUpdate();
            
           
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
            finally{
            Conexion.close(stmt);
            Conexion.close(conn);
            
            }
         return rows;
    }
    

}
