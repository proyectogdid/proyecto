package com.company.Excepciones;

public class PropiedadIncorrecta extends RuntimeException {
    private String prop;

    public PropiedadIncorrecta(String prop) {
        this.prop = prop;
    }

    public String getMessage(){
        return this.prop;
    }
}
