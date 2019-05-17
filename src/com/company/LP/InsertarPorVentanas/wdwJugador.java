package com.company.LP.InsertarPorVentanas;

//import com.company.Excepciones.DorsalRepetidoException;
import com.company.LN.GestorLN;
import com.company.comun.itfProperty;
import com.toedter.calendar.JDateChooser;
import com.company.comun.clsConstantes.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;

import static com.company.comun.clsConstantes.*;
/**
 * Clase que utilizaremos para crear la ventana de insertar jugadores en la BD
 */
public class wdwJugador extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JTextField textoNombre;
    private JTextField textoPrimerApellido;
    private JTextField textoSegundoApellido;
    private JTextField textoDorsal;
    private JTextField textoTextoCamiseta;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
    private JComboBox<itfProperty> cbEquipo;
    private JComboBox<itfProperty> cbPosicion;
    private JComboBox<itfProperty> cbEstado;
    private JLabel lblNewLabel_6;
    private JLabel lblNewLabel_7;
    private JLabel lblNewLabel_8;
    private GestorLN gln;
    private JDateChooser fechaNcto;
    private DateFormat miFormato;


    /**
     * Create the frame.
     */
    public wdwJugador(GestorLN gln_) {
        ArrayList<itfProperty> equipos=gln_.leerEquipos();
        ArrayList<itfProperty> posiciones=gln_.leerPosiciones();
        ArrayList<itfProperty> estados= gln_.leerEstados();
        gln=gln_;

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

        fechaNcto = new JDateChooser();
        fechaNcto.setDateFormatString("dd-MM-yyyy");
        fechaNcto.setBounds(198, 178, 86, 20);
        contentPane.add(fechaNcto);

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

        Button aceptar = new Button("Aceptar");
        aceptar.setBounds(399, 462, 70, 22);
        aceptar.addActionListener(this);
        aceptar.setActionCommand("1");
        contentPane.add(aceptar);

        Button cancelar = new Button("Cancelar");
        cancelar.setBounds(480, 462, 70, 22);
        cancelar.addActionListener(this);
        cancelar.setActionCommand("0");
        contentPane.add(cancelar);

        lblNewLabel_8 = new JLabel("Estado");
        lblNewLabel_8.setBounds(72, 424, 46, 14);
        contentPane.add(lblNewLabel_8);

        for (int i = 0; i <equipos.size() ; i++) {
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
     * @param e e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "1":
                try {
                    miFormato = DateFormat.getDateInstance(DateFormat.SHORT);
                    gln.anadirJugador(textoNombre.getText(),textoPrimerApellido.getText(), textoSegundoApellido.getText(),
                            fechaNcto.getDate(),textoDorsal.getText(), textoTextoCamiseta.getText(),(int) ((itfProperty)cbEquipo.getSelectedItem()).getProperty(EQUIPO_ID),
                            (int)((itfProperty)cbPosicion.getSelectedItem()).getProperty(POSICION_ID),(int)((itfProperty)cbEstado.getSelectedItem()).getProperty(ESTADO_ID));
                } catch (Exception ex) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Fallo en la inserción del jugador");
                }
                break;
            case "0":
                break;



        }

    }


}

