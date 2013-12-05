/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import negocio.Album;
import negocio.Amigo;
import negocio.Comentario;
import negocio.Usuario;
import negocio.UsuariosList;
import persistencia.AlbumDAO;
import persistencia.AlbumDAOSQL;
import persistencia.AmigoDAO;
import persistencia.AmigoDAOSQL;
import persistencia.ComentarioDAO;
import persistencia.ComentarioDAOSQL;
import persistencia.UsuarioDAO;
import persistencia.UsuarioDAOSQL;
import util.Util;
/**
 *
 * @author romina
 */
public class InicioControlador {
    
    public static UsuariosList BuscarUsuario(String busqueda) {
    
        UsuarioDAO usuariodao = new UsuarioDAOSQL();

        UsuariosList usuarios = usuariodao.buscarUsuario(busqueda);

        return usuarios;
    }
    
    public static int idAmigo (int idTabla){
    AmigoDAO amigodao= new AmigoDAOSQL();
    Amigo amigo = amigodao.consultarAmigo(idTabla);
    
    
    return amigo.getAmigo_fkusuario1();
    }
    
    
    public static int idAlbum (int idComentario){
       
    ComentarioDAO comentariodao= new ComentarioDAOSQL();
    Comentario comentario = comentariodao.consultarComentario(idComentario);
    AlbumDAO albumdao = new AlbumDAOSQL();
    
    Album album= albumdao.consultarAlbum(comentario.getFk_album_id());
    ResultFriendControlador.TraerAmigo(album.getFk_usuario());
    for (int pos=0; pos<=Util.amigoPerfil.getUsuario_albums().size()-1;pos++){
     
        
        if (album.getAlbum_id()==Util.amigoPerfil.getUsuario_albums().get(pos).getAlbum_id())
            Util.posAlbum = pos;
    }
    if (album.getFk_usuario()==Util.usuario.getUsuario_id()){
       Util.amigoPerfil= new Usuario();
       return 1;
    }
    else{
        return 0;
    }
    

    }
    
}
