package com.company.Excepciones;

/**
 * Runtime exception para itfProperty cuando se pida una propiedad que no exista para la clase
 *
 */
public class PropiedadIncorrecta extends RuntimeException {
    private String prop;

    public PropiedadIncorrecta(String prop) {
        this.prop = prop;
    }

    public String getMessage() {
        return this.prop;
    }
}
