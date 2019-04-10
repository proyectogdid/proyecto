package com.company.Excepciones;

public class EquiposInsuficientesException extends Throwable {
    public String getMessage(){
        return "no hay equipos suficientes para montar una liga, (ten en cuenta que tienen que ser un numero de equipos par)";
    }
}
