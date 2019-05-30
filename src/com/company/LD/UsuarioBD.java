package com.company.LD;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Clase que utulizaremos para registrar y actualizar un usuarios, además de recuperar los datos del usuario logeado.
 */
public class UsuarioBD extends Conexion {

    public static final String TEMPLATE = "usr.id,usr.usuario,usr.contrasena,usr.correo,usr.tipo,usr.equipo_favorito";

    /**
     * Metodo para recuperar el usuario logeado
     *
     * @param con conexion de BD
     * @return result set de datos
     * @throws Exception cualquier fallo que pueda tener la select
     */
    public static ResultSet getLogin(Connection con, String usuario, String contrasena) throws Exception {
        Object[] params = {usuario, contrasena};
        System.out.println(usuario);
        System.out.println(contrasena);
        return query(con, "SELECT " + TEMPLATE + " FROM usuario usr where usuario=? and contrasena=?", params);
    }

    /**
     * Metodo para registrar usuario en la BD
     *
     * @param con     conecion
     * @param usuario nombre de usuaario
     * @param passw   contrsensa
     * @param equipo  equipo favorito del usuario
     * @param tipo    tipo de usuario
     * @param correo  correo del usuario
     * @return id del usuario
     * @throws Exception exxcepcion producida por SQL
     */
    public static int registrarUsuario(Connection con, String usuario, String passw, int equipo, String tipo, String correo) throws Exception {
        Object[] parametros = {usuario, passw, equipo, tipo, correo};
        return insert(con, "INSERT INTO usuario (`usuario`,`contrasena`,`equipo_favorito`,`tipo`,`correo`) VALUES (?,?,?,?,?)", parametros);
    }

    /**
     * Metodo para actualizar el usuario
     *
     * @param con      con
     * @param idequipo id
     * @param iduser   id
     * @return return
     * @throws Exception Exception
     */
    public static int updateUsuario(Connection con, int idequipo, int iduser) throws Exception {
        Object[] parametros = {idequipo, iduser};
        return update(con, "UPDATE usuario SET equipo_favorito=? WHERE id=?", parametros);

    }

}
