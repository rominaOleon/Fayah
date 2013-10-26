/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import negocio.Usuario;

/**
 *
 * @author romina
 */
public abstract class Util {

    
    public static Usuario usuario = new Usuario();
    public static final String DRIVER_BD = "org.postgresql.Driver";
    public static final String URL_BD = "jdbc:postgresql://ec2-54-235-83-5.compute-1.amazonaws.com:5432/d90thl54rosfe3?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
    public static final String USERNAME_BD = "ezfrmsdwmxsdku";
    public static final String PASSWORD_BD = "0LsDzLMI8KFNe-pkM6iQSHuAHI";
}
