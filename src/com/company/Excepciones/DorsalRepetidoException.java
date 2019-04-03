package com.company.Excepciones;

public class DorsalRepetidoException extends Exception {

private final String Mensaje ="No puede haber dos jugadores con el mismo dorsal";

 public DorsalRepetidoException(){

 }
 public String getMensaje(){
     return "No puede haber dos jugadores con el mismo dorsal";
 }
 public String toString(){
     return "No puede haber dos jugadores con el mismo dorsal";
 }
}
