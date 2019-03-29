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
    private Equipo favorito;

    public Aficionado() {

    }

    /**
     * Este método va a recoger los datos referidos a un tipo de usuario que va a ser el aficionado
     *
     * @param id
     * @param usuario
     * @param contrasena
     * @param tipo
     * @param favorito
     */
    public Aficionado(int id, String usuario, String contrasena, String tipo, Equipo favorito) {
        super(id, usuario, contrasena, tipo);
        this.favorito = favorito;
    }

    public Equipo getFavorito() {
        return favorito;
    }

    public void setFavorito(Equipo favorito) {
        this.favorito = favorito;
    }

    /**
     * metodo get property de la interfaz itfProperty
     *
     * @param prop
     * @return
     */

    @Override
    public Object getProperty(String prop) {
        switch (prop) {
            case AFICIONADO_FAVORITO:
                return this.favorito;
            default:
                return null;
        }
    }
}
