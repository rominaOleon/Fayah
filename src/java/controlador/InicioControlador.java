/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import negocio.Usuario;
import negocio.UsuariosList;
import persistencia.UsuarioDAO;
import persistencia.UsuarioDAOSQL;

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
}
