package com.company.LN;

import java.util.ArrayList;

public class GestorLN {

    ArrayList<Campo>campos=new ArrayList<>();

    public void anadirCampo(int id, String nombre, String ciudad, String calle, String numero, String cp, int aforo){

        Campo campo=new Campo( id,nombre,ciudad,calle,numero,cp,aforo);
        campos.add(campo);
    }
    public ArrayList<Campo>leerCampos(){
        return campos;
    }
}
