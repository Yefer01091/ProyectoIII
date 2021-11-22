

package datos;

import modelos.Curso;
import java.sql.*;
import java.util.*;

/**
 * 
 * @author Sergio Enrique Jair Gonzalez Arcos>
 */
public class CursoDaoJDBC {
    private  static  final  String sql_select="SELECT * FROM  curso";
    private  static  final  String sql_select_by_id="SELECT * FROM  curso where id = ? ";
    private  static  final  String sql_insert="INSERT INTO   curso( profesor , nombre ,jornada,codigo)  VALUES ( ?,?,?,?)";
    private  static  final  String sql_update="UPDATE  curso set profesor = ?,nombre = ?,jornada = ? , codigo = ?  where id = ? ";
    private  static  final  String sql_delete ="DELETE FROM curso  where id = ? ";

    public List<Curso> listar () {
        
            Connection  conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            Curso curso = null;
            List<Curso> cursos = new ArrayList<>();
            
            try {
            conn=Conexion.getConnection();
            stmt=conn.prepareStatement(sql_select);
            rs =stmt.executeQuery();
            
            while(rs.next()){
            int id =rs.getInt("id");
            String nombre = rs.getString("nombre");
            String profesor = rs.getString("profesor");           
            String jornada = rs.getString("jornada");
            int codigo =rs.getInt("codigo");
            
            curso =new Curso (profesor,nombre,jornada,codigo,id);
            cursos.add(curso);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
            finally{
            Conexion.close(stmt);
            Conexion.close(rs);
            Conexion.close(conn);
            
            }
        
            return  cursos;
    
    }
    
    public Curso encontar (Curso curso){
            Connection  conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            try {
            conn=Conexion.getConnection();
            stmt=conn.prepareStatement(sql_select_by_id);
            stmt.setInt( 1, curso.getId());
            rs =stmt.executeQuery();
            
            
           while(rs.next()){
                curso.setCodigo(rs.getInt("id"));
                curso.setNombre(rs.getString("nombre"));
                curso.setProfesor(rs.getString("profesor"));
                curso.setJornada(rs.getString("jornada"));
                curso.setCodigo(rs.getInt("codigo"));
                               
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
            finally{
            Conexion.close(stmt);
            Conexion.close(rs);
            Conexion.close(conn);
            
            }
        return curso;
    }
           
    public int insertar (Curso curso){
           Connection  conn = null;
            PreparedStatement stmt = null;
            int rows=0;
            
            
            try {
            conn=Conexion.getConnection();
            stmt=conn.prepareStatement(sql_insert);
            stmt.setString(1,curso.getProfesor() );
            stmt.setString(2, curso.getNombre());
            stmt.setString(3,curso.getJornada() );
            stmt.setInt(4, curso.getCodigo());
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
    
 public int actualizar(Curso curso){
            Connection  conn = null;
            PreparedStatement stmt = null;
            int rows=0;
            
            
            try {
            conn=Conexion.getConnection();
            stmt=conn.prepareStatement(sql_update);
            stmt.setString(1,curso.getProfesor() );
            stmt.setString(2, curso.getNombre());
            stmt.setString(3,curso.getJornada() );
            stmt.setInt(4, curso.getCodigo());
            stmt.setInt(5, curso.getId() );
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
 
 public void eliminar(int id){
            Connection  conn = null;
            PreparedStatement stmt = null;
            int rows=0;
            
            
            try {
            conn=Conexion.getConnection();    
            stmt=conn.prepareStatement(sql_delete);         
            stmt.setInt(1, id );
             rows=stmt.executeUpdate();
            
           
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
            finally{
            Conexion.close(stmt);
            Conexion.close(conn);
            
            }
         
 
 
 }
}
