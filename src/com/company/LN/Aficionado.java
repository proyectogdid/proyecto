package com.company.LN;

/**
 * clase para gestionar los usuarios no administradores
 * es decir un usuario cualquiera que podra elegir su equipo favorito
 */
public class Aficionado extends  Usuario{
    /**
     * atributo equipo favorito del usuario
     */
    private Equipo favorito;

    public Aficionado() {

    }

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
}
