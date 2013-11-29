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
public class IdComparatorLikes implements Comparator, Serializable  {
    
     @Override
    //Retorna 0 si son iguales
    public int compare(Object firstObject,Object secondObject) {
        
        int firstID = ((Like)firstObject).getLike_id();
        int secondID = ((Like)secondObject).getLike_id();
        
        if (firstID==secondID)
            return 0;
        else
            return 1;
    }
    
}
