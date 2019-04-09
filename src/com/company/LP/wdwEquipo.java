package com.company.LP;

import com.company.comun.itfProperty;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.company.comun.clsConstantes.CAMPO_NOMBRE;

public class wdwEquipo extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JTextField textField;
    private JTextField textField_1;
    private JLabel lblNewLabel_2;
    private JComboBox cbCampo;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    wdwEquipo frame = new wdwEquipo();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public wdwEquipo() {

    }

    public wdwEquipo(ArrayList<itfProperty> campos) {

        this.setTitle("Inserte un equipo");
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

        JLabel lblNewLabel_1 = new JLabel("Patrocinador");
        lblNewLabel_1.setBounds(72, 102, 100, 14);
        contentPane.add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setBounds(198, 99, 212, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        lblNewLabel_2 = new JLabel("Campo");
        lblNewLabel_2.setBounds(72, 329, 55, 14);
        contentPane.add(lblNewLabel_2);

        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(176, 329, -12, 14);
        contentPane.add(comboBox);

        cbCampo = new JComboBox();
        cbCampo.setBounds(198, 329, 86, 20);
        contentPane.add(cbCampo);

        Button button = new Button("Aceptar");
        button.setBounds(399, 462, 70, 22);
        contentPane.add(button);

        Button button1 = new Button("Cancelar");
        button1.setBounds(480, 462, 70, 22);
        contentPane.add(button1);

        for (int i = 0; i < campos.size(); i++) {
            cbCampo.addItem(campos.get(i).getProperty(CAMPO_NOMBRE));
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
