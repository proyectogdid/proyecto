package com.company.LN;

/**
 * clase para gestionar las cuentas de usuario
 */
public class Usuario {
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

}
