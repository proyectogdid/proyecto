package com.company.LP.Updates;

import com.company.LN.Jugador;

import java.util.LinkedList;

import javax.swing.DefaultListModel;



public class ListaJugadoresModel extends DefaultListModel<Jugador>{

    protected LinkedList <Jugador> lista;

    public ListaJugadoresModel(LinkedList <Jugador> lista)
    {
        this.lista = lista;
    }

    public Jugador getElementAt(int index)
    {
        return lista.get(index);
    }

    public int getSize()
    {
        return lista.size();
    }

    @Override
    public void addElement(Jugador element)
    {
        lista.add(element);
        this.fireContentsChanged(this, lista.size(), lista.size());
    }
}
