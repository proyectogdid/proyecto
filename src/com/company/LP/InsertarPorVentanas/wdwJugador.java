package com.company.LP.InsertarPorVentanas;

import com.company.LN.GestorLN;
import com.company.LP.Updates.updateJugadores;
import com.company.comun.itfProperty;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.ArrayList;

import static com.company.comun.clsConstantes.*;

/**
 * Clase que utilizaremos para crear la ventana de insertar jugadores en la BD
 */
public class wdwJugador extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JLabel nombre;
    private JTextField textoNombre;
    private JTextField textoPrimerApellido;
    private JTextField textoSegundoApellido;
    private JTextField textoDorsal;
    private JTextField textoTextoCamiseta;
    private JLabel primerApellido;
    private JLabel segundoApellido;
    private JLabel fechaNcto;
    private JLabel dorsal;
    private JLabel camiseta;
    private JComboBox<itfProperty> cbEquipo;
    private JComboBox<itfProperty> cbPosicion;
    private JComboBox<itfProperty> cbEstado;
    private JLabel equipo;
    private JLabel posicion;
    private JLabel estado;
    private GestorLN gln;
    private JDateChooser fechaNcto_;
    private DateFormat miFormato;
    private final String BOTON_ACEPTAR = "aceptar";
    private final String BOTON_CANCELAR = "cancelar";
    private final String BOTON_VER = "ver";


    /**
     * Create the frame.
     */
    public wdwJugador(GestorLN gln_) {
        ArrayList<itfProperty> equipos = gln_.leerEquipos();
        ArrayList<itfProperty> posiciones = gln_.leerPosiciones();
        ArrayList<itfProperty> estados = gln_.leerEstados();
        gln = gln_;

        this.setTitle("Inserte un jugador");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 628, 548);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        nombre = new JLabel("Nombre");
        nombre.setBounds(72, 50, 60, 14);
        contentPane.add(nombre);

        primerApellido = new JLabel("Primer apellido");
        primerApellido.setBounds(72, 102, 100, 14);
        contentPane.add(primerApellido);

        segundoApellido = new JLabel("Segundo apellido");
        segundoApellido.setBounds(72, 150, 120, 14);
        contentPane.add(segundoApellido);

        fechaNcto = new JLabel("Fecha de nacimiento");
        fechaNcto.setBounds(72, 181, 130, 14);
        contentPane.add(fechaNcto);

        dorsal = new JLabel("Dorsal");
        dorsal.setBounds(72, 222, 70, 14);
        contentPane.add(dorsal);

        camiseta = new JLabel("Texto camiseta");
        camiseta.setBounds(72, 271, 110, 14);
        contentPane.add(camiseta);

        textoNombre = new JTextField();
        textoNombre.setBounds(198, 47, 212, 20);
        contentPane.add(textoNombre);
        textoNombre.setColumns(10);

        textoPrimerApellido = new JTextField();
        textoPrimerApellido.setBounds(198, 99, 212, 20);
        contentPane.add(textoPrimerApellido);
        textoPrimerApellido.setColumns(10);

        textoSegundoApellido = new JTextField();
        textoSegundoApellido.setBounds(198, 147, 212, 20);
        contentPane.add(textoSegundoApellido);
        textoSegundoApellido.setColumns(10);

        fechaNcto_ = new JDateChooser();
        fechaNcto_.setDateFormatString("dd-MM-yyyy");
        fechaNcto_.setBounds(198, 178, 86, 20);
        contentPane.add(fechaNcto_);

        textoDorsal = new JTextField();
        textoDorsal.setBounds(198, 219, 212, 20);
        contentPane.add(textoDorsal);
        textoDorsal.setColumns(10);

        textoTextoCamiseta = new JTextField();
        textoTextoCamiseta.setBounds(198, 268, 212, 20);
        contentPane.add(textoTextoCamiseta);
        textoTextoCamiseta.setColumns(10);

        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(176, 329, -12, 14);
        contentPane.add(comboBox);

        cbEquipo = new JComboBox();
        cbEquipo.setBounds(198, 329, 86, 20);
        contentPane.add(cbEquipo);

        cbPosicion = new JComboBox();
        cbPosicion.setBounds(198, 376, 87, 20);
        contentPane.add(cbPosicion);

        cbEstado = new JComboBox();
        cbEstado.setBounds(198, 421, 86, 20);
        contentPane.add(cbEstado);

        equipo = new JLabel("Equipo");
        equipo.setBounds(72, 329, 55, 14);
        contentPane.add(equipo);

        posicion = new JLabel("Posición");
        posicion.setBounds(72, 379, 50, 14);
        contentPane.add(posicion);

        estado = new JLabel("Estado");
        estado.setBounds(72, 424, 46, 14);
        contentPane.add(estado);

        Button aceptar = new Button("Aceptar");
        aceptar.setBounds(399, 442, 70, 22);
        aceptar.addActionListener(this);
        aceptar.setActionCommand(BOTON_ACEPTAR);
        contentPane.add(aceptar);
        aceptar.setBackground(Color.GREEN);

        Button cancelar = new Button("Cancelar");
        cancelar.setBounds(480, 442, 70, 22);
        cancelar.addActionListener(this);
        cancelar.setActionCommand(BOTON_CANCELAR);
        contentPane.add(cancelar);
        cancelar.setBackground(Color.ORANGE);

        Button ver = new Button("Ver jugadores");
        ver.setBounds(480, 472, 90, 22);
        ver.addActionListener(this);
        ver.setActionCommand(BOTON_VER);
        contentPane.add(ver);


        for (int i = 0; i < equipos.size(); i++) {
            cbEquipo.addItem(equipos.get(i));
        }
        for (int i = 0; i < posiciones.size(); i++) {
            cbPosicion.addItem(posiciones.get(i));
        }
        for (int i = 0; i < estados.size(); i++) {
            cbEstado.addItem(estados.get(i));
        }
    }

    /**
     * Metodo para realizar las acciones de los eventos de la ventana
     *
     * @param e e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case BOTON_ACEPTAR:
                try {
                    miFormato = DateFormat.getDateInstance(DateFormat.SHORT);
                    gln.anadirJugador(textoNombre.getText(), textoPrimerApellido.getText(), textoSegundoApellido.getText(),
                            fechaNcto_.getDate(), textoDorsal.getText(), textoTextoCamiseta.getText(), (int) ((itfProperty) cbEquipo.getSelectedItem()).getProperty(EQUIPO_ID),
                            (int) ((itfProperty) cbPosicion.getSelectedItem()).getProperty(POSICION_ID), (int) ((itfProperty) cbEstado.getSelectedItem()).getProperty(ESTADO_ID));
                } catch (Exception ex) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Fallo en la inserción del jugador");
                }
                break;
            case BOTON_CANCELAR:
                cbEquipo.setSelectedIndex(0);
                cbEstado.setSelectedIndex(0);
                cbPosicion.setSelectedIndex(0);
                textoNombre.setText("");
                textoPrimerApellido.setText("");
                textoSegundoApellido.setText("");
                fechaNcto_.setDate(null);
                textoDorsal.setText("");
                textoTextoCamiseta.setText("");

                this.dispose();
                break;
            case BOTON_VER:
                updateJugadores uj = new updateJugadores(gln);
                uj.setVisible(true);
                this.dispose();
                break;


        }

    }


}

