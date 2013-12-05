/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.Album;
import negocio.AlbumList;
import negocio.Amigo;
import negocio.AmigoList;
import negocio.Usuario;
import negocio.UsuariosList;

/**
 *
 * @author romina
 */
public class UsuarioDAOSQL extends Object implements UsuarioDAO {

    @Override
    public void insertarUsuario(Usuario usuario) {
        try {
            System.out.println("Agregando nuevo usuario a la base de datos: "
                    +usuario.getUsuario_nombre()+" "+usuario.getUsuario_apellido());
            Connection connection = ConexionBaseDeDatos.getConnection();
            String query = "INSERT INTO usuario VALUES (nextval('usuario_usuario_id_seq'),'"
                    + usuario.getUsuario_username() + "','"
                    + usuario.getUsuario_nombre() + "','"
                    + usuario.getUsuario_apellido() + "','"
                    + usuario.getUsuario_email() + "','"
                    + usuario.getUsuario_fecha_nacimiento() + "','"
                    + usuario.getUsuario_ubicacion() + "','"
                    + usuario.getUsuario_privacidad() + "','"
                    + usuario.getUsuario_foto() + "')";
            Statement st = connection.createStatement();
            int rs = st.executeUpdate(query);
            st.close();
            ConexionBaseDeDatos.closeConnection(connection);
            System.out.println("Un nuevo usuario ha sido insertado: "
                    +usuario.getUsuario_nombre()+" "+usuario.getUsuario_apellido());
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Ocurrio un error de SQL al intentar insertar el usuario: "
                    +usuario.getUsuario_nombre()+" "+usuario.getUsuario_apellido()
                    +". Error: "+ex.getMessage());
        }
    }

    @Override
    public Usuario consultarUsuario(int id) {
        
            String idString = "";
            idString = String.valueOf(id);
            
        Usuario usuario = null;
        try {
            System.out.println("Consultando la informacion del usuario: "+id+" ...");
            Connection connection = ConexionBaseDeDatos.getConnection();
            String query = "SELECT * FROM usuario WHERE usuario_id="
                    + idString;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            String username = "";
            String nombre = "";
            String apellido = "";
            String fecha_nacimiento = "";
            String ubicacion = "";
            String privacidad = "";
            String foto = "";
            String email = "";
            while (rs.next()) {
                id = Integer.parseInt(rs.getString("usuario_id"));
                username = rs.getString("usuario_username");
                nombre = rs.getString("usuario_nombre");
                apellido = rs.getString("usuario_apellido");
                email = rs.getString("usuario_email");
                fecha_nacimiento = rs.getString("usuario_fecha_nacimiento");
                ubicacion = rs.getString("usuario_ubicacion");
                privacidad = rs.getString("usuario_privacidad");
                foto = rs.getString("usuario_foto");
            }
            rs.close();
            st.close();
            ConexionBaseDeDatos.closeConnection(connection);
            usuario = new Usuario(id, username, nombre, apellido, email, fecha_nacimiento,
                    ubicacion, privacidad, foto);
            System.out.println("Se ha cargado la informacion del usuario: "
                    +nombre+" "+apellido);
            return usuario;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Ocurrio un error de SQL al intentar consultar el usuario: "
                    +id+". Error: "+ex.getMessage());
        }
        return usuario;
    }
    
    @Override
    public Usuario consultarUsuario(String email) {
        Usuario usuario = null;
        try {
            System.out.println("Consultando la informacion del usuario: "+email+" ...");
            Connection connection = ConexionBaseDeDatos.getConnection();
            String query = "SELECT * FROM usuario WHERE usuario_email='"
                    + email + "'";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            int id = 0;
            String username = "";
            String nombre = "";
            String apellido = "";
            String fecha_nacimiento = "";
            String ubicacion = "";
            String privacidad = "";
            String foto = "";
            while (rs.next()) {
                id = Integer.parseInt(rs.getString("usuario_id"));
                username = rs.getString("usuario_username");
                nombre = rs.getString("usuario_nombre");
                apellido = rs.getString("usuario_apellido");
                fecha_nacimiento = rs.getString("usuario_fecha_nacimiento");
                ubicacion = rs.getString("usuario_ubicacion");
                privacidad = rs.getString("usuario_privacidad");
                foto = rs.getString("usuario_foto");
            }
            rs.close();
            st.close();
            ConexionBaseDeDatos.closeConnection(connection);
            usuario = new Usuario(id, username, nombre, apellido, email, fecha_nacimiento,
                    ubicacion, privacidad, foto);
            System.out.println("Se ha cargado la informacion del usuario: "+nombre+" "+apellido);
            return usuario;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Ocurrio un error de SQL al intentar consultar el usuario: " +email+". Error: "+ex.getMessage());
        }
        return usuario;
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
        try {
            System.out.println("Modificando la informacion del usuario: "+usuario.getUsuario_nombre()+" "+usuario.getUsuario_apellido()+" ...");
            Connection connection = ConexionBaseDeDatos.getConnection();
            int id = usuario.getUsuario_id();
            String idString = "";
            idString = String.valueOf(id);
            String query = "UPDATE usuario SET "
                    + "usuario_username='" + usuario.getUsuario_username() + "', "
                    + "usuario_nombre='" + usuario.getUsuario_nombre() + "', "
                    + "usuario_apellido='" + usuario.getUsuario_apellido() + "', "
                    + "usuario_fecha_nacimiento='" + usuario.getUsuario_fecha_nacimiento() + "', "
                    + "usuario_ubicacion='" + usuario.getUsuario_ubicacion() + "', "
                    + "usuario_privacidad='" + usuario.getUsuario_privacidad() + "' "
                    + "WHERE usuario_id=" + idString;
            Statement st = connection.createStatement();
            int rs = st.executeUpdate(query);
            st.close();
            System.out.println("Se ha modificado la informacion del usuario: "
                    +usuario.getUsuario_nombre()+" "+usuario.getUsuario_apellido());
            ConexionBaseDeDatos.closeConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Ocurrio un error de SQL al intentar modificar"
                    +" el usuario: " +usuario.getUsuario_nombre()+" "
                    +usuario.getUsuario_apellido()+". Error: "+ex.getMessage());
        }
    }

    @Override
    public AmigoList traerAmigos(Usuario usuario) {
        AmigoList amigos = new AmigoList();
        try {
            System.out.println("Consultando el grafo social del usuario: "
                    +usuario.getUsuario_nombre()+" "
                    +usuario.getUsuario_apellido()+" ...");
            Connection connection = ConexionBaseDeDatos.getConnection();
            int id = usuario.getUsuario_id();
            String idString = "";
            idString = String.valueOf(id);
            String query = "SELECT * FROM amigo WHERE fk_usuario1_id="
                    + idString + " OR fk_usuario2_id="
                    + idString;
            
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            int idamigo;
            int fkamigo1;
            int fkamigo2;
            while (rs.next()) {
                idamigo  = Integer.parseInt(rs.getString("amigo_id"));
                fkamigo1 = Integer.parseInt(rs.getString("fk_usuario1_id"));
                fkamigo2 = Integer.parseInt(rs.getString("fk_usuario2_id"));
                
                Amigo amigo = new Amigo(idamigo, fkamigo1, fkamigo2);
                amigos.addAmigo(amigo);
            }
            st.close();
            rs.close();
            System.out.println("Se ha cargado el grafo social del usuario: "
                    +usuario.getUsuario_nombre()+" "+usuario.getUsuario_apellido());
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Ocurrio un error de SQL al intentar cargar"+
                    " el grafo social del usuario: " +usuario.getUsuario_nombre()
                    +" "+usuario.getUsuario_apellido()+". Error: "+ex.getMessage());
        }
        return amigos;
    }

    @Override
       public AlbumList traerAlbums(Usuario usuario) {
        AlbumList albums = new AlbumList();
        try {
            System.out.println("Consultando albums del usuario: "+usuario.getUsuario_nombre()+" "+usuario.getUsuario_apellido()+" ...");
            Connection connection = ConexionBaseDeDatos.getConnection();
            int id = usuario.getUsuario_id();
            String idString = "";
            idString = String.valueOf(id);
            String query = "SELECT * FROM album WHERE fk_usuario_id="
                    + idString;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            int idalbum = 0;
            String nombre = "";
            String descripcion = "";
            String privacidad = "";
            String fecha = "";
            String show = "";
            int likes = 0;
            int dislikes = 0;
            String miniatura ="";
            while (rs.next()) {
                idalbum = Integer.parseInt(rs.getString("album_id"));
                nombre = rs.getString("album_nombre");
                descripcion = rs.getString("album_descripcion");
                privacidad = rs.getString("album_privacidad");
                fecha = rs.getString("album_fecha_creacion");
                likes = Integer.parseInt(rs.getString("album_likes"));
                dislikes = Integer.parseInt(rs.getString("album_dislikes"));
                miniatura = rs.getString("album_miniatura");
                show = rs.getString("album_show");
                Album album = new Album(idalbum, nombre, descripcion, privacidad, fecha, likes, dislikes,miniatura,show);
                albums.addAlbum(album);
            }
            
            System.out.println("Se han cargado los albums del usuario: "
                    +usuario.getUsuario_nombre()+" "+usuario.getUsuario_apellido());
            st.close();
            rs.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Ocurrio un error de SQL al intentar cargar los albums del usuario: " 
                    +usuario.getUsuario_nombre()+" "+usuario.getUsuario_apellido()
                    +". Error: "+ex.getMessage());
        }
        return albums;
    }

    @Override
    public int usuarioExiste(String email) {
        int id = 0;
        if (email != null) {
            if (email.compareTo("") != 0) {
                try {
                    System.out.println("Consultando la existencia del usuario: "+email+" ...");
                    Connection connection = ConexionBaseDeDatos.getConnection();
                    String query = "SELECT usuario_id FROM usuario WHERE usuario_email='"
                            + email + "'";
                    Statement st = connection.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    while (rs.next()) {
                        id = Integer.parseInt(rs.getString("usuario_id"));
                    }
                    rs.close();
                    st.close();
                    ConexionBaseDeDatos.closeConnection(connection);
                    System.out.println("El usuario es: "+id);
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
                    System.err.println("Ocurrio un error de SQL al intentar consultar el usuario: "+email+". Error: "+ex.getMessage());
                }
            }
        }
        return id;
    }

    @Override
    public UsuariosList buscarUsuario(String busqueda) {
        
        UsuariosList usuarios= new UsuariosList();

        try {
       System.out.println("Buscando a los usuarios que coincidan con: "+busqueda+" ...");
       Connection connection = ConexionBaseDeDatos.getConnection();
            String query = "SELECT * FROM usuario WHERE lower(usuario_nombre ||"
           +" ' ' || usuario_apellido) LIKE ('%"+busqueda+"%')";
            Statement st = connection.createStatement();

            ResultSet rs = st.executeQuery(query);
            int id = 0;
            String username = "";
            String nombreusuario = "";
            String apellidousuario = "";
            String email = "";
            String fecha_nacimiento = "";
            String ubicacion = "";
            String privacidad = "";
            String foto = "";
            while (rs.next()) {
                id = Integer.parseInt(rs.getString("usuario_id"));
                username = rs.getString("usuario_username");
                nombreusuario = rs.getString("usuario_nombre");
                apellidousuario = rs.getString("usuario_apellido");
                email = rs.getString("usuario_email");
                fecha_nacimiento = rs.getString("usuario_fecha_nacimiento");
                ubicacion = rs.getString("usuario_ubicacion");
                privacidad = rs.getString("usuario_privacidad");
                foto = rs.getString("usuario_foto");
       
                Usuario usuario = new Usuario(id, username, nombreusuario, apellidousuario, email, fecha_nacimiento,ubicacion, privacidad, foto);

            usuarios.addUsuario(usuario);
                
            }
            rs.close();
            st.close();
            System.out.println("Se ha retornado la respuesta de la busqueda: "+busqueda);
            ConexionBaseDeDatos.closeConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Ocurrio un error de SQL al intentar realizar la busqueda: "
                    +busqueda+". Error: "+ex.getMessage());
        }
        return usuarios;
    }
}
