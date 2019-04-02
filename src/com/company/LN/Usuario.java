package com.company.LN;

import com.company.comun.itfProperty;

import static com.company.comun.clsConstantes.USUARIO_ID;
import static com.company.comun.clsConstantes.USUARIO_USERNAME;
import static com.company.comun.clsConstantes.USUARIO_CONTRASENA;
import static com.company.comun.clsConstantes.USUARIO_TIPO;

/**
 * clase para gestionar las cuentas de usuario
 */
public class Usuario implements itfProperty {
    /**
     * atributo id para el usuario
     */
    private int id;
    /**
     * atributo nombre de usuario
     */
    private String username;
    /**
     * atributo para la contraseña de la cuenta
     */
    private String contrasena;
    /**
     * atributo para identificar el tipo de cuenta
     */
    private String tipo;


    public Usuario() {
    }

    /**
     * Este metodo va a recoger los datos de los usuarios de la aplicacion
     *
     * @param id id
     * @param usuario usuario
     * @param contrasena contrasena
     * @param tipo tipo
     */
    public Usuario(int id, String usuario, String contrasena, String tipo) {
        this.id = id;
        this.username = usuario;
        this.contrasena = contrasena;
        this.tipo = tipo;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getContrasena() {
        return contrasena;
    }


    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }


    public String getTipo() {
        return tipo;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * metodo get property de la interfaz itfProperty
     *
     * @param prop prop
     * @return return
     */
    @Override
    public Object getProperty(String prop) {
        switch (prop) {
            case USUARIO_ID:
                return this.id;
            case USUARIO_USERNAME:
                return this.username;
            case USUARIO_CONTRASENA:
                return this.contrasena;
            case USUARIO_TIPO:
                return this.tipo;
            default:
                return null;
        }
    }

}
