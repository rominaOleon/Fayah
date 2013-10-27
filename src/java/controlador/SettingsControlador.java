/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import negocio.Usuario;
import persistencia.UsuarioDAO;
import persistencia.UsuarioDAOSQL;
import util.Util;

/**
 *
 * @author romina
 */
public class SettingsControlador { 
    
    public static void ModificarPerfil(String newusername, String newnombre, 
            String newapellido,String newfecha_nacimiento, String newubicacion, 
            String newprivacidad) {
        
        String username = Util.usuario.getUsuario_username();
        String nombre = Util.usuario.getUsuario_nombre();
        String apellido= Util.usuario.getUsuario_apellido();
        String fecha_nacimiento= Util.usuario.getUsuario_fecha_nacimiento();
        String ubicacion= Util.usuario.getUsuario_ubicacion();
        String privacidad= Util.usuario.getUsuario_privacidad();
        
        if (newusername!=null)
            username = newusername;
        
        if (newnombre!=null)
            nombre = newnombre;
        
        if (newapellido!=null)
            apellido = newapellido;
        
        if (newfecha_nacimiento!=null)
            fecha_nacimiento = newfecha_nacimiento;
        
        if (newubicacion!=null)
            ubicacion = newubicacion;
        
        if (newprivacidad!=null)
            privacidad = newprivacidad;
       
        Usuario usuario = new Usuario(Util.usuario.getUsuario_id(),username,
                nombre, apellido,Util.usuario.getUsuario_email(), 
                fecha_nacimiento,ubicacion, privacidad, 
                Util.usuario.getUsuario_albums(),
                Util.usuario.getUsuario_amigos(), 
                Util.usuario.getUsuario_foto());

        UsuarioDAO usuariodao = new UsuarioDAOSQL();

        usuariodao.ModificarUsuario(usuario);
        usuario = usuariodao.ConsultarUsuario(Util.usuario.getUsuario_email());
        Util.usuario = usuario;
      
 }

}
