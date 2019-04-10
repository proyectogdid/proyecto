package com.company.LP;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class wdwRegistrarUsuario extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JTextField textField;
    private JTextField textField_1;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    wdwRegistrarUsuario frame = new wdwRegistrarUsuario();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public wdwRegistrarUsuario() {

        this.setTitle("Registrar nuevo usuario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 628, 548);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewLabel = new JLabel("Nombre de usuario");
        lblNewLabel.setBounds(72, 50, 60, 14);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(198, 47, 212, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Contraseña");
        lblNewLabel_1.setBounds(72, 102, 100, 14);
        contentPane.add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setBounds(198, 99, 212, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        lblNewLabel = new JLabel("Correo electrónico");
        lblNewLabel.setBounds(72, 154, 60, 14);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(198, 151, 212, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        Button button = new Button("Aceptar");
        button.setBounds(399, 214, 70, 22);
        contentPane.add(button);

        Button button1 = new Button("Cancelar");
        button1.setBounds(480, 214, 70, 22);
        contentPane.add(button1);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
