package com.company.LP;

import com.company.LN.GestorLN;
import com.company.LP.imagenes.clsImagen;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Clase que utilizaremos para diseñar la ventana de inicio de la apk
 */
public class ventanaComienzoApk extends JFrame implements ActionListener, WindowListener {

    private clsImagen contentPane;
    private GestorLN gln;
    private final String COMENZAR = "comenzar";

    /**
     * Create the frame
     * @param gln_ gln_
     */
    public ventanaComienzoApk(GestorLN gln_) {
        this.setTitle("BASKET LIVE");

        gln = gln_;
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(this);
        this.setResizable(false);
        setBounds(100, 100, 500, 500);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenuItem mntmNewMenuItem = new JMenuItem("BASKET LIVE \uD83C\uDFC0");
        menuBar.add(mntmNewMenuItem);
        contentPane = new clsImagen();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackgroundImage(contentPane.createImage("/com/company/LP/imagenes/Inicio.png").getImage());
        contentPane.setLayout(new BorderLayout(50, 50));
        setContentPane(contentPane);

        JButton btnComenzar = new JButton("Comenzar");
        btnComenzar.setActionCommand(COMENZAR);
        btnComenzar.addActionListener(this);
        getContentPane().add(btnComenzar, BorderLayout.NORTH);
        btnComenzar.setForeground(Color.WHITE);
        btnComenzar.setOpaque(false);
        btnComenzar.setContentAreaFilled(false);
        btnComenzar.setBorderPainted(false);

    }

    /**
     * Metodo que realiza las acciones del evento
     * @param e e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case COMENZAR:
                wdwRegistrarUsuario ru = new wdwRegistrarUsuario(gln);
                ru.setVisible(true);
                this.dispose();
                break;

        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        int eleccion = JOptionPane.showConfirmDialog(this, "¿Estás seguro?", "Salir",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
        if (eleccion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
