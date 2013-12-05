/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import negocio.ComentarioList;
import negocio.Usuario;
import persistencia.ComentarioDAO;
import persistencia.ComentarioDAOSQL;
import persistencia.ReplyDAO;
import persistencia.ReplyDAOSQL;
import util.Util;

/**
 *
 * @author admin
 */
public class CargarComentarioControlador {
    
   public static void cargarComentario(Usuario delComentario){
   
       ComentarioDAO comentariodao= new ComentarioDAOSQL();
       ComentarioList comentarios= comentariodao.traerComentarios(delComentario.getUsuario_albums().get(Util.posAlbum));
       Util.listaComentario= comentarios;
   
   
   
   }
   
   public static void cargarReply(int posComentario){
       
       ReplyDAO replydao= new ReplyDAOSQL();
       Util.listaReply= replydao.traerReplys(Util.listaComentario.get(posComentario));
       
   
   }
    
}
