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
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
    private JComboBox cbEquipo;
    private JComboBox cbPosicion;
    private JComboBox cbEstado;
    private JLabel lblNewLabel_6;
    private JLabel lblNewLabel_7;

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 628, 548);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewLabel = new JLabel("Nombre");
        lblNewLabel.setBounds(72, 50, 60, 14);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(198, 47, 212, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Primer apellido");
        lblNewLabel_1.setBounds(72, 102, 100, 14);
        contentPane.add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setBounds(198, 99, 212, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(198, 147, 86, 20);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setBounds(198, 178, 86, 20);
        contentPane.add(textField_3);
        textField_3.setColumns(10);

        textField_4 = new JTextField();
        textField_4.setBounds(198, 219, 86, 20);
        contentPane.add(textField_4);
        textField_4.setColumns(10);

        textField_5 = new JTextField();
        textField_5.setBounds(198, 268, 86, 20);
        contentPane.add(textField_5);
        textField_5.setColumns(10);

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
        contentPane.add(button);

        Button button1 = new Button("Cancelar");
        button1.setBounds(480, 462, 70, 22);
        contentPane.add(button1);

        JLabel lblNewLabel_8 = new JLabel("Estado");
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

