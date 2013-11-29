/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import negocio.Comentario;
import negocio.ComentarioList;
import negocio.Reply;

/**
 *
 * @author romina
 */
public interface ReplyDAO {
    public void insertarReply(Reply reply);
    public ComentarioList traerReplys (Comentario comentario);    
}
