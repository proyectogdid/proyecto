package com.company.LP;

import com.company.LN.GestorLN;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class insertar extends JFrame implements ActionListener {

    private JPanel contentPane;
    private GestorLN gln;
    private final String INSERTAR_JUGADOR = "jugador";
    private final String INSERTAR_EQUIPO = "equipo";

    /**
     * Create the frame.
     */
    public insertar(GestorLN gln_) {
        gln = gln_;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenuItem mntmNewMenuItem = new JMenuItem("Ventana para insertar Equipos y Jugadores");
        menuBar.add(mntmNewMenuItem);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(50, 50));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnJugador = new JButton("Insertar jugador");
        btnJugador.setActionCommand(INSERTAR_JUGADOR);
        btnJugador.addActionListener(this);
        panel.add(btnJugador);

        JButton btnEquipo = new JButton("Insertar equipo");
        btnEquipo.setActionCommand(INSERTAR_EQUIPO);
        btnEquipo.addActionListener(this);
        panel.add(btnEquipo);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case INSERTAR_JUGADOR:
                wdwJugador j = new wdwJugador(gln);
                j.setVisible(true);
                break;
            case INSERTAR_EQUIPO:
                wdwEquipo eq = new wdwEquipo(gln);
                eq.setVisible(true);
                break;
        }
    }
}

