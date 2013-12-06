/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import negocio.Comentario;
import negocio.ComentarioList;
import negocio.Usuario;
import persistencia.ComentarioDAO;
import persistencia.ComentarioDAOSQL;
import util.Util;
/**
 *
 * @author admin
 */
public class ComentarioControlador {
    
   public static void AgregarComentario (String texto, int idAlbum, int idComenta, Usuario delComentado){
   ComentarioDAO comentariodao= new ComentarioDAOSQL();
   Date date= new Date();
   DateFormat formato= new SimpleDateFormat("mm/dd/yyyy");
   String fecha= formato.format(date);
   Comentario comentario= new Comentario(fecha,0,0,"t",idComenta,idAlbum,texto);
   comentariodao.insertarComentario(comentario);
   ComentarioList comentarios= comentariodao.traerComentarios(delComentado.getUsuario_albums().get(Util.posAlbum));
   Util.listaComentario = comentarios;
   
   
   
   }
    
}
