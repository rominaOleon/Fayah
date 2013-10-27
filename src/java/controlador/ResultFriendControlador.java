/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import negocio.Amigo;
import persistencia.AmigoDAO;
import persistencia.AmigoDAOSQL;
import util.Util;

/**
 *
 * @author romina
 */
public class ResultFriendControlador {
    
    public static void AgregarAmigo (int id){
        
        Amigo amigo = new Amigo(Util.usuario.getUsuario_id(),id);
        
        AmigoDAO amigodao = new AmigoDAOSQL();
        
        amigodao.InsertarAmigo(amigo);
        
    }
    
}
