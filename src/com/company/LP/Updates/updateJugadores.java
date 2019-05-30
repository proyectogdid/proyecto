package com.company.LP.Updates;

import com.company.LN.GestorLN;
import com.company.LP.InsertarPorVentanas.wdwJugador;

import com.company.comun.itfProperty;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

import static com.company.comun.clsConstantes.*;
import com.toedter.calendar.JDateChooser;

/**
 * Clase que utilizaremos los admin para actualizar los jugadores de la BD
 */
public class updateJugadores extends JFrame implements ActionListener , ListSelectionListener, WindowListener {

    private GestorLN gln;
    private JPanel contentPane;
    private JTextField txtNombre;
    private  LinkedList<itfProperty> lista;
    private JList<itfProperty> list;
    private final String BORRAR="borrar";
    private final String SALIR ="salir";
    private final String ACTUALIZAR="actualizar";

    private ListaJugadoresModel modelo;
    private JTextField txtApellido1;
    private JTextField txtApellido2;
    private JTextField txtDorsal;
    private JTextField txtCamiseta;
    private JDateChooser datechooser;
    private JComboBox <itfProperty>cbEquipo,cbEstado;
    private ArrayList<itfProperty>jugadores,estados,equipos;
    private int listSelected=0;
    public updateJugadores(GestorLN gln_) {



        this.setTitle("Actualizar Jugador");
        gln = gln_;
        jugadores=gln.leerJugadores();
        equipos=gln.leerEquipos();
        estados=gln.leerEstados();
        this.setResizable(false);


        
        lista=new LinkedList<>(jugadores);
        System.out.println("tamaño lista");
        System.out.println(lista.size());
        modelo=new ListaJugadoresModel(lista);

        list=new JList<>(modelo);
        list.addListSelectionListener(this);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(this);
        setBounds(100, 100, 459, 542);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(238, 48, 161, 389);
        contentPane.add(scrollPane);

        scrollPane.setViewportView(list);

        JTextField textField = new JTextField();
        textField.setBounds(56, 47, 86, 20);
        contentPane.add(textField);
        textField.setColumns(10);


        txtNombre = new JTextField();
        txtNombre.setBounds(56, 47, 86, 20);
        contentPane.add(txtNombre);
        txtNombre.setColumns(10);


        JButton borrar = new JButton("Borrar");
        borrar.setActionCommand(BORRAR);
        borrar.addActionListener(this);
        borrar.setBounds(56, 368, 86, 23);
        contentPane.add(borrar);


        JButton salir = new JButton("Salir");
        salir.setActionCommand(SALIR);
        salir.addActionListener(this);
        salir.setBounds(53, 402, 86, 23);
        contentPane.add(salir);

        JButton actualizar = new JButton("Actualizar");
        actualizar.setActionCommand(ACTUALIZAR);
        actualizar.addActionListener(this);
        actualizar.setBounds(53, 436, 86, 23);
        contentPane.add(actualizar);
        
        txtApellido1 = new JTextField();
        txtApellido1.setBounds(56, 81, 86, 20);
        contentPane.add(txtApellido1);
        txtApellido1.setColumns(10);
        
        txtApellido2 = new JTextField();
        txtApellido2.setBounds(56, 123, 86, 20);
        contentPane.add(txtApellido2);
        txtApellido2.setColumns(10);
        
        txtDorsal = new JTextField();
        txtDorsal.setBounds(56, 168, 86, 20);
        contentPane.add(txtDorsal);
        txtDorsal.setColumns(10);
        
        txtCamiseta = new JTextField();
        txtCamiseta.setBounds(56, 212, 86, 20);
        contentPane.add(txtCamiseta);
        txtCamiseta.setColumns(10);
        
         datechooser = new JDateChooser();
        datechooser.setBounds(56, 256, 113, 20);
        contentPane.add(datechooser);
        
        cbEquipo = new JComboBox();
        cbEquipo.setBounds(56, 298, 86, 20);
        contentPane.add(cbEquipo);

         cbEstado = new JComboBox();
        cbEstado.setBounds(56, 337, 86, 20);
        contentPane.add(cbEstado);
        for (itfProperty item:equipos) {
            cbEquipo.addItem(item);
        }for (itfProperty item:estados) {
            cbEstado.addItem(item);
        }




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case BORRAR:
                try{


                int posicion = list.getSelectedIndex();
                //System.out.println(posicion);
                //System.out.println("tamaño:"+modelo.size());
                gln.borrarJugador(list.getSelectedValue());
                lista.remove(posicion);
                modelo.actualizar();

                jugadores.remove(posicion);
                }catch (Exception exc){
                    javax.swing.JOptionPane.showMessageDialog(this,"error al borrar jugador");
                    exc.printStackTrace();
                }
                break;
            case SALIR:
                wdwJugador j=new wdwJugador(gln);
                j.setVisible(true);
                this.dispose();
                break;
            case ACTUALIZAR:

                break;
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int i=e.getLastIndex();
        listSelected=i;

        System.out.println(lista.size());
        //System.out.println(list.getSelectedIndex());
        txtNombre.setText((String) list.getSelectedValue().getProperty(JUGADOR_NOMBRE));
        txtApellido1.setText((String)list.getSelectedValue().getProperty(JUGADOR_APELLIDO1));
        txtApellido2.setText((String)list.getSelectedValue().getProperty(JUGADOR_APELLIDO2));
        txtCamiseta.setText((String)list.getSelectedValue().getProperty(JUGADOR_TEXTO_CAMISETA));
        txtDorsal.setText((String)list.getSelectedValue().getProperty(JUGADOR_DORSAL));
        datechooser.setDate((Date)list.getSelectedValue().getProperty(JUGADOR_FECHA_NACIMIENTO));
        cbEquipo.setSelectedIndex(buscarEquipo((int)list.getSelectedValue().getProperty(JUGADOR_EQUIPO)));
        cbEstado.setSelectedIndex(buscarEstado((int)list.getSelectedValue().getProperty(JUGADOR_ESTADO)));

    }

    private int buscarEquipo(int id){
        for (int i = 0; i <equipos.size() ; i++) {
            if((int)equipos.get(i).getProperty(EQUIPO_ID)==id){
                return i;
            }
        }
        return -1;

    }
    private int buscarEstado(int id){
        for (int i = 0; i <estados.size() ; i++) {

            if((int)estados.get(i).getProperty(ESTADO_ID)==id){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
    this.dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}

