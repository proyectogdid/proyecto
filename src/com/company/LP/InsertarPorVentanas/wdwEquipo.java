package com.company.LP.InsertarPorVentanas;

import com.company.LN.GestorLN;
import com.company.comun.itfProperty;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.company.comun.clsConstantes.CAMPO_ID;

/**
 * Clase que utilizaremos para crear la ventana de insertar equipos en la BD
 */
public class wdwEquipo extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JLabel nombre;
    private JTextField textoNombre;
    private JTextField textoPatrocinador;
    private JLabel patrocinador;
    private JLabel campo;
    private JComboBox<itfProperty> cbCampo;
    private GestorLN gln;
    private final String BOTON_ACEPTAR = "aceptar";
    private final String BOTON_CANCELAR = "cancelar";

    /**
     * Create the frame
     * @param gln_ gln_
     */
    public wdwEquipo(GestorLN gln_) {
        ArrayList<itfProperty> campos = gln_.leerCampos();
        gln = gln_;
        this.setTitle("Inserte un equipo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 610, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        this.setResizable(false);

        nombre = new JLabel("Nombre");
        nombre.setBounds(72, 50, 60, 14);
        contentPane.add(nombre);

        textoNombre = new JTextField();
        textoNombre.setBounds(198, 47, 212, 20);
        contentPane.add(textoNombre);
        textoNombre.setColumns(10);

        patrocinador = new JLabel("Patrocinador");
        patrocinador.setBounds(72, 102, 100, 14);
        contentPane.add(patrocinador);

        textoPatrocinador = new JTextField();
        textoPatrocinador.setBounds(198, 99, 212, 20);
        contentPane.add(textoPatrocinador);
        textoPatrocinador.setColumns(10);

        campo = new JLabel("Campo");
        campo.setBounds(72, 154, 55, 14);
        contentPane.add(campo);

        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(176, 329, -12, 14);
        contentPane.add(comboBox);

        cbCampo = new JComboBox<itfProperty>();
        cbCampo.setBounds(198, 154, 86, 20);
        contentPane.add(cbCampo);

        DefaultComboBoxModel model = new DefaultComboBoxModel();

        Button aceptar = new Button("Aceptar");
        aceptar.setBounds(399, 214, 70, 22);
        aceptar.addActionListener(this);
        aceptar.setActionCommand(BOTON_ACEPTAR);
        contentPane.add(aceptar);
        aceptar.setBackground(Color.GREEN);

        Button cancelar = new Button("Cancelar");
        cancelar.setBounds(480, 214, 70, 22);
        cancelar.addActionListener(this);
        cancelar.setActionCommand(BOTON_CANCELAR);
        contentPane.add(cancelar);
        cancelar.setBackground(Color.ORANGE);

        //itfProperty[] a=campos.toArray();
        for (int i = 0; i < campos.size(); i++) {
            cbCampo.addItem(campos.get(i));
        }


    }

    /**
     * Metodo para realizar acciones en funcion del evento
     *
     * @param e e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case BOTON_ACEPTAR:
                try {
                    gln.anadirEquipo(textoNombre.getText(), textoPatrocinador.getText(), (int) ((itfProperty) cbCampo.getSelectedItem()).getProperty(CAMPO_ID));
                } catch (Exception ex) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Fallo en la inserción del equipo");
                }
                break;
            case BOTON_CANCELAR:
                textoNombre.setText("");
                textoPatrocinador.setText("");
                cbCampo.setSelectedIndex(0);
                this.dispose();
                break;
        }

    }
}
