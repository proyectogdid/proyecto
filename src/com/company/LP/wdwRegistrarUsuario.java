package com.company.LP;

import com.company.LN.GestorLN;
import com.company.comun.itfProperty;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.company.comun.clsConstantes.EQUIPO_ID;

public class wdwRegistrarUsuario extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JTextField txtRegistrousername;
    private JTextField txtRegistropassw;
    private JTextField txtRegistroemail;
    private GestorLN gln;
    private JComboBox<itfProperty> cbEquipo;
    private final String BOTON_ACEPTAR_REGISTRO="aceptarRegistro";


    /**
     * Create the frame.
     */
    public wdwRegistrarUsuario(GestorLN gln_) {
        gln=gln_;
        ArrayList<itfProperty> equipos=gln.leerEquipos();
        cbEquipo =new JComboBox<>();
        for (int i = 0; i <equipos.size() ; i++) {
            cbEquipo.addItem(equipos.get(i));
        }
        cbEquipo.setBounds(198, 190, 120, 34);

        this.setTitle("Registrar nuevo usuario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 628, 548);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(cbEquipo);
        lblNewLabel = new JLabel("Nombre de usuario");
        lblNewLabel.setBounds(72, 50, 60, 14);
        contentPane.add(lblNewLabel);

        txtRegistrousername = new JTextField();
        txtRegistrousername.setBounds(198, 50, 212, 20);
        contentPane.add(txtRegistrousername);
        txtRegistrousername.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Contraseña");
        lblNewLabel_1.setBounds(72, 102, 100, 14);
        contentPane.add(lblNewLabel_1);

        txtRegistropassw = new JTextField();
        txtRegistropassw.setBounds(198, 99, 212, 20);
        contentPane.add(txtRegistropassw);
        txtRegistropassw.setColumns(10);

        lblNewLabel = new JLabel("Correo electrónico");
        lblNewLabel.setBounds(72, 154, 60, 14);
        contentPane.add(lblNewLabel);

        txtRegistroemail = new JTextField();
        txtRegistroemail.setBounds(198, 151, 212, 20);
        contentPane.add(txtRegistroemail);
        txtRegistroemail.setColumns(10);

        Button button = new Button("Aceptar");
        button.setBounds(399, 214, 70, 22);
        contentPane.add(button);
        button.setActionCommand(BOTON_ACEPTAR_REGISTRO);
        button.addActionListener(this);


        Button button1 = new Button("Cancelar");
        button1.setBounds(480, 214, 70, 22);
        contentPane.add(button1);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case BOTON_ACEPTAR_REGISTRO:
                System.out.println("entro aqui");
                try{
                    gln.registrarUsuario(txtRegistrousername.getText(),txtRegistropassw.getText(),(int)((itfProperty)cbEquipo.getSelectedItem()).getProperty(EQUIPO_ID),txtRegistroemail.getText());
                }catch (Exception ex){
                   javax.swing.JOptionPane.showMessageDialog(this,"error en el registro");
                }
            break;
        }

    }
}
