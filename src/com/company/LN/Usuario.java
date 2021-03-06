package com.company.LN;

import com.company.Excepciones.PropiedadIncorrecta;
import com.company.comun.itfPersistable;
import com.company.comun.itfProperty;

import java.sql.ResultSet;

import static com.company.comun.clsConstantes.*;

/**
 * Clase para gestionar las cuentas de usuario
 */
public class Usuario implements itfProperty, itfPersistable {
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
    /**
     * atributo correo del usuario
     */
    private String correo;

    public Usuario() {
    }

    /**
     * Metodo que enseñaremos en los datos personales
     * @param usuario usuario
     * @param correo correo
     * @param tipo tipo
     */
    public Usuario(String usuario, String correo,String tipo){
        this.username=usuario;
        this.correo=correo;
        this.tipo=tipo;
    }

    /**
     * Este metodo va a recoger los datos de los usuarios de la aplicacion
     *
     * @param id         id
     * @param usuario    usuario
     * @param contrasena contrasena
     * @param tipo       tipo
     */
    public Usuario(int id, String usuario, String contrasena, String tipo, String correo) {
        this.id = id;
        this.username = usuario;
        this.contrasena = contrasena;
        this.correo = correo;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isAdmin(){
        return this.tipo.equalsIgnoreCase(USUARIO_TIPO_ADMIN);
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo get property de la interfaz itfProperty
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
            case USUARIO_CORREO:
                return this.correo;
            case USUARIO_TIPO:
                return this.tipo;
            default:
                throw new PropiedadIncorrecta(prop);
        }
    }

    @Override
    public void resultsetLoad(ResultSet rs) throws Exception {
        id = rs.getInt(BD_USUARIO_ID);
        username = rs.getString(BD_USUARIO_USERNAME);
        contrasena = rs.getString(BD_USUARIO_CONTRASENA);
        correo = rs.getString(BD_USUARIO_CORREO);
        tipo = rs.getString(BD_USUARIO_TIPO);


    }
}
