package com.company.LN;

import com.company.comun.itfProperty;

import static com.company.comun.clsConstantes.AFICIONADO_FAVORITO;

/**
 * clase para gestionar los usuarios no administradores
 * es decir un usuario cualquiera que podra elegir su equipo favorito
 */
public class Aficionado extends Usuario implements itfProperty {
    /**
     * atributo equipo favorito del usuario
     */
    private int favorito;

    public Aficionado() {

    }

    /**
     * Este metodo va a recoger los datos referidos a un tipo de usuario que va a ser el aficionado
     *
     * @param id         id
     * @param usuario    usuario
     * @param contrasena contrasena
     * @param correo     correo
     * @param tipo       tipo
     * @param favorito   favorito
     */
    public Aficionado(int id, String usuario, String contrasena, String correo, String tipo, int favorito) {
        super(id, usuario, contrasena, tipo, correo);
        this.favorito = favorito;
    }

    public int getFavorito() {
        return favorito;
    }

    public void setFavorito(int favorito) {
        this.favorito = favorito;
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
            case AFICIONADO_FAVORITO:
                return this.favorito;
            default:
                return super.getProperty(prop);
        }
    }
}
