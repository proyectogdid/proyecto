package com.company.LP;

import com.company.LN.GestorLN;
import com.company.comun.itfProperty;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class wdwEquipo extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JTextField textoNombre;
    private JTextField textoPatrocinador;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JComboBox<itfProperty> cbCampo;
    private GestorLN gln;




    public wdwEquipo(GestorLN gln_) {
        ArrayList<itfProperty> campos=gln_.leerCampos();
        gln=gln_;
        this.setTitle("Inserte un equipo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 628, 548);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewLabel = new JLabel("Nombre");
        lblNewLabel.setBounds(72, 50, 60, 14);
        contentPane.add(lblNewLabel);

        textoNombre = new JTextField();
        textoNombre.setBounds(198, 47, 212, 20);
        contentPane.add(textoNombre);
        textoNombre.setColumns(10);

        lblNewLabel_1 = new JLabel("Patrocinador");
        lblNewLabel_1.setBounds(72, 102, 100, 14);
        contentPane.add(lblNewLabel_1);

        textoPatrocinador = new JTextField();
        textoPatrocinador.setBounds(198, 99, 212, 20);
        contentPane.add(textoPatrocinador);
        textoPatrocinador.setColumns(10);

        lblNewLabel_2 = new JLabel("Campo");
        lblNewLabel_2.setBounds(72, 154, 55, 14);
        contentPane.add(lblNewLabel_2);

        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(176, 329, -12, 14);
        contentPane.add(comboBox);

        cbCampo = new JComboBox<itfProperty>();
        cbCampo.setBounds(198, 154, 86, 20);
        contentPane.add(cbCampo);

        Button button = new Button("Aceptar");
        button.addActionListener(this);
        button.setBounds(399, 214, 70, 22);
        contentPane.add(button);

        Button button1 = new Button("Cancelar");
        button1.setBounds(480, 214, 70, 22);
        contentPane.add(button1);
  //     itfProperty[] a=campos.toArray();
        DefaultComboBoxModel model=new DefaultComboBoxModel();

        for (int i = 0; i <campos.size() ; i++) {
            cbCampo.addItem(campos.get(i));
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {

       gln.anadirEquipo(textoNombre.getText(),textoPatrocinador.getText(), (Integer) cbCampo.getSelectedItem());
    }
}
