package com.company.LP;

import com.company.LN.GestorLN;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase se va a utilizar para sacar por pantalla la ventana del menu principal de la aplicacion
 */
public class ventanaMenu extends JFrame  implements ActionListener {

    private JPanel contentPane;
    private GestorLN gln;
    private final String ABRIR_NOTICIAS="noticias";

    /**
     * Create the frame.
     */
    public ventanaMenu(GestorLN gln_) {
        gln=gln_;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenuItem mntmNewMenuItem = new JMenuItem("Bienvenido a 'Nombre de la aplicación'!!");
        menuBar.add(mntmNewMenuItem);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(50, 50));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnNoticias = new JButton("Noticias");
        btnNoticias.setActionCommand(ABRIR_NOTICIAS);
        btnNoticias.addActionListener(this);
        panel.add(btnNoticias);

        JButton btnClasificacion = new JButton("Clasificacion");
        panel.add(btnClasificacion);

        JButton btnJornada = new JButton("Jornada");
        panel.add(btnJornada);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case ABRIR_NOTICIAS:
                wdwClasificacion w=new wdwClasificacion(gln);
                w.setVisible(true);
                break;
        }
    }
}
