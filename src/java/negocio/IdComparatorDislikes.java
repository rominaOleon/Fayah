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
public class IdComparatorDislikes implements Comparator, Serializable {
    
     @Override
    //Retorna 0 si son iguales
    public int compare(Object firstObject,Object secondObject) {
        
        int firstID = ((Dislike)firstObject).getDislike_id();
        int secondID = ((Dislike)secondObject).getDislike_id();
        
        if (firstID==secondID)
            return 0;
        else
            return 1;
    }
    
}
