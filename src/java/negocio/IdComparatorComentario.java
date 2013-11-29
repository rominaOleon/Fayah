/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author romina
 */
public class IdComparatorComentario implements Comparator, Serializable {
    
    @Override
    
    public int compare(Object firstObject,Object secondObject) {
        
        int firstID = ((Comentario)firstObject).getComentario_id();
        int secondID = ((Comentario)secondObject).getComentario_id();
        
        if (firstID==secondID)
            return 0;
        else
            return 1;
    }
}
