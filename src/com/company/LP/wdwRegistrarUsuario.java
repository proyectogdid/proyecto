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
    private JTextField txtLoginusername,txtLoginpassw;
    private GestorLN gln;
    private JComboBox<itfProperty> cbEquipo;
    private final String BOTON_ACEPTAR_REGISTRO="aceptarRegistro";
    private final String BOTON_CANCELAR_REGISTRO="cancelarRegistro";
    private final String BOTON_ACEPTAR_LOGIN="aceptarLogin";

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
        button1.setActionCommand(BOTON_CANCELAR_REGISTRO);
        button1.addActionListener(this);

        txtLoginusername = new JTextField();
        txtLoginusername.setBounds(198, 260, 212, 20);
        contentPane.add(txtLoginusername);
        txtLoginusername.setColumns(10);

        txtLoginpassw = new JTextField();
        txtLoginpassw.setBounds(198, 300, 212, 20);
        contentPane.add(txtLoginpassw);
        txtLoginpassw.setColumns(10);

        Button blogin = new Button("Iniciar Sesion");
        blogin.setBounds(480, 254, 70, 22);
        contentPane.add(blogin);
        blogin.setActionCommand(BOTON_ACEPTAR_LOGIN);
        blogin.addActionListener(this);
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
            case BOTON_CANCELAR_REGISTRO:
                cbEquipo.setSelectedIndex(0);
                txtRegistroemail.setText("");
                txtRegistropassw.setText("");
                txtRegistrousername.setText("");
                break;
            case BOTON_ACEPTAR_LOGIN:
                try {
                    if(gln.login(txtLoginusername.getText(), txtLoginpassw.getText())){
                        ventanaMenu vm=new ventanaMenu(gln);
                        vm.setVisible(true);
                        this.dispose();
                    }
                }catch (Exception ex){
                    javax.swing.JOptionPane.showMessageDialog(this,"error con en login");
                    ex.printStackTrace();
                }
        }

    }
}
