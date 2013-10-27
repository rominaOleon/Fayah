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
public class IdComparatorUsuario implements Comparator, Serializable {
    
     @Override
    //Retorna 0 si son iguales
    public int compare(Object firstObject,Object secondObject) {
        
        int firstID = ((Usuario)firstObject).getUsuario_id();
        int secondID = ((Usuario)secondObject).getUsuario_id();
        
        if (firstID==secondID)
            return 0;
        else
            return 1;
    }
    
}
