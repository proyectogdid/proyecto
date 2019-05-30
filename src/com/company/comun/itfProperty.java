package com.company.comun;

/**
 * Interfaz que implemenetaremos en las clases de ln para poder acceder a los atributos desde lp
 */
public interface itfProperty {
    /**
     * Metodo get property por el que accederemos a los atributos de las clases que implementen esta itf
     *
     * @param prop prop
     * @return object
     */
    Object getProperty(String prop);

    String toString();
}
