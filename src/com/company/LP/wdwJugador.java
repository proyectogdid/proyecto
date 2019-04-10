package com.company.LP;

import com.company.comun.itfProperty;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.company.comun.clsConstantes.*;

public class wdwJugador extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JTextField textoNombre;
    private JTextField textoPrimerApellido;
    private JTextField textoSegundoApellido;
    private JTextField textoFechaNcto;
    private JTextField textoDorsal;
    private JTextField textoTextoCamiseta;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
    private JComboBox cbEquipo;
    private JComboBox cbPosicion;
    private JComboBox cbEstado;
    private JLabel lblNewLabel_6;
    private JLabel lblNewLabel_7;
    private JLabel lblNewLabel_8;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    wdwJugador frame = new wdwJugador();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public wdwJugador() {

    }

    /**
     * Create the frame.
     */
    public wdwJugador(ArrayList<itfProperty> equipos, ArrayList<itfProperty> posiciones, ArrayList<itfProperty> estados) {

        this.setTitle("Inserte un jugador");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 628, 548);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewLabel = new JLabel("Nombre");
        lblNewLabel.setBounds(72, 50, 60, 14);
        contentPane.add(lblNewLabel);

        lblNewLabel_1 = new JLabel("Primer apellido");
        lblNewLabel_1.setBounds(72, 102, 100, 14);
        contentPane.add(lblNewLabel_1);

        lblNewLabel_2 = new JLabel("Segundo apellido");
        lblNewLabel_2.setBounds(72, 150, 120, 14);
        contentPane.add(lblNewLabel_2);

        lblNewLabel_3 = new JLabel("Fecha de nacimiento");
        lblNewLabel_3.setBounds(72, 181, 130, 14);
        contentPane.add(lblNewLabel_3);

        lblNewLabel_4 = new JLabel("Dorsal");
        lblNewLabel_4.setBounds(72, 222, 70, 14);
        contentPane.add(lblNewLabel_4);

        lblNewLabel_5 = new JLabel("Texto camiseta");
        lblNewLabel_5.setBounds(72, 271, 110, 14);
        contentPane.add(lblNewLabel_5);

        textoNombre = new JTextField();
        textoNombre.setBounds(198, 47, 212, 20);
        contentPane.add(textoNombre);
        textoNombre.setColumns(10);

        textoPrimerApellido = new JTextField();
        textoPrimerApellido.setBounds(198, 99, 212, 20);
        contentPane.add(textoPrimerApellido);
        textoPrimerApellido.setColumns(10);

        textoSegundoApellido = new JTextField();
        textoSegundoApellido.setBounds(198, 147, 86, 20);
        contentPane.add(textoSegundoApellido);
        textoSegundoApellido.setColumns(10);

        textoFechaNcto = new JTextField();
        textoFechaNcto.setBounds(198, 178, 86, 20);
        contentPane.add(textoFechaNcto);
        textoFechaNcto.setColumns(10);

        textoDorsal = new JTextField();
        textoDorsal.setBounds(198, 219, 86, 20);
        contentPane.add(textoDorsal);
        textoDorsal.setColumns(10);

        textoTextoCamiseta = new JTextField();
        textoTextoCamiseta.setBounds(198, 268, 86, 20);
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

        lblNewLabel_6 = new JLabel("Equipo");
        lblNewLabel_6.setBounds(72, 329, 55, 14);
        contentPane.add(lblNewLabel_6);

        lblNewLabel_7 = new JLabel("Posición");
        lblNewLabel_7.setBounds(72, 379, 50, 14);
        contentPane.add(lblNewLabel_7);

        Button button = new Button("Aceptar");
        button.setBounds(399, 462, 70, 22);
        button.addActionListener(this);
        contentPane.add(button);

        Button button1 = new Button("Cancelar");
        button1.setBounds(480, 462, 70, 22);
        contentPane.add(button1);

        lblNewLabel_8 = new JLabel("Estado");
        lblNewLabel_8.setBounds(72, 424, 46, 14);
        contentPane.add(lblNewLabel_8);
        for (int i = 0; i < equipos.size(); i++) {
            cbEquipo.addItem(equipos.get(i).getProperty(EQUIPO_NOMBRE));
        }

        for (int i = 0; i < posiciones.size(); i++) {
            cbPosicion.addItem(posiciones.get(i).getProperty(POSICION_NOMBRE));
        }
        for (int i = 0; i < estados.size(); i++) {
            cbEstado.addItem(estados.get(i).getProperty(ESTADO_NOMBRE));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }


}

