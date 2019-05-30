package com.company.LP.Updates;


import com.company.comun.itfProperty;

import java.util.LinkedList;

import javax.swing.DefaultListModel;

/**
 * Clase que se utilizara para rellenar la JList de la ventana updateJugadores
 */

public class ListaJugadoresModel extends DefaultListModel<itfProperty>{

    protected LinkedList <itfProperty> lista;

    public ListaJugadoresModel(LinkedList <itfProperty> lista)
    {
        this.lista = lista;
    }

    public itfProperty getElementAt(int index)
    {
        return lista.get(index);
    }

    public int getSize()
    {
        return lista.size();
    }

    @Override
    public void addElement(itfProperty element)
    {
        lista.add(element);
        this.fireContentsChanged(this, lista.size(), lista.size());
    }
    public void actualizar(){
        this.fireContentsChanged(this,lista.size(),lista.size());
    }
}
