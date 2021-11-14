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
import modelos.Usuario;
import modelos.encriptar;

/**
 *
 * @author Sergio Enrique Jair Gonzalez Arcos>
 */
public class UsuarioDaoJDBC {

    private static final String sql_select = "SELECT * FROM  usuario";
    private static final String sql_select_by_id = "SELECT * FROM  usuario where id = ? ";
    private static final String sql_consulta = "SELECT * FROM usuario WHERE correo = ? AND contrasena = ?";
    private static final String sql_consultacorreo = "SELECT * FROM usuario WHERE correo = ? ";
    private static final String sql_insert = "INSERT INTO  usuario(correo,contrasena)  VALUES ( ?,?)";
    private static final String sql_update = "UPDATE  usuario set(correo= ?,contrasena = ? ) where id = ? ";
    private static final String sql_delete = "DELETE FROM usuario  where id = ? ";

    public List<Usuario> listar() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql_select);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String correo = rs.getString("correo");
                String contrasena = rs.getString("contrasena");

                usuario = new Usuario(id, correo, contrasena);
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(rs);
            Conexion.close(conn);

        }

        return usuarios;

    }

    public Usuario encontar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql_select_by_id);
            stmt.setInt(1, usuario.getId());
            rs = stmt.executeQuery();
            rs.absolute(1);//nos proporciona el primer registro devuelto

            String correo = rs.getString("correo");
            String contrasena = rs.getString("contrasena");

            usuario.setCorreo(correo);
            usuario.setContrasena(contrasena);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(rs);
            Conexion.close(conn);

        }
        return usuario;
    }

    public int insertar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql_insert);
            stmt.setString(1, usuario.getCorreo());
            stmt.setString(2, usuario.getContrasena());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);

        }
        return rows;
    }

    public int actualizar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql_update);
            stmt.setString(1, usuario.getCorreo());
            stmt.setString(2, usuario.getContrasena());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);

        }
        return rows;
    }

    public int eliminar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql_delete);
            stmt.setInt(1, usuario.getId());
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);

        }
        return rows;

    }

    public Usuario Validar(String correo, String contrasena) {
        Usuario usuario = new Usuario();
        encriptar contraseñaencriptada = new encriptar();
        //System.out.println("la contraseña es"+contraseñaencriptada.ecnode(contrasena));

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql_consulta);
            stmt.setString(1, correo);
            stmt.setString(2, contraseñaencriptada.ecnode(contrasena));
            rs = stmt.executeQuery();
            rs.next();
            do {
                usuario.setId(rs.getInt("id"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setContrasena("contrasena");

            } while (rs.next());

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(rs);
            Conexion.close(conn);

        }
        return usuario;
    }
    //si existe el usuario con ese correo o retornara

    public Usuario RecuperarContrasena(String correo) {
        Usuario usuario = new Usuario();
        encriptar contraseñaencriptada = new encriptar();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql_consultacorreo);
            stmt.setString(1, correo);
            rs = stmt.executeQuery();
            rs.next();
            do {
                usuario.setId(rs.getInt("id"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setContrasena(rs.getString("contrasena"));

            } while (rs.next());

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(rs);
            Conexion.close(conn);

        }
        //si hay un usuario  desencriptamos la contraseña
       usuario.setContrasena(contraseñaencriptada.deecnode(usuario.getContrasena()));
        return usuario;

    }

}
