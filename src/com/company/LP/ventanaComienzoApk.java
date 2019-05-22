package com.company.LP;

import com.company.LN.GestorLN;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ventanaComienzoApk extends JFrame implements ActionListener, WindowListener {
    private JPanel contentPane;
    private GestorLN gln;
    private final String COMENZAR = "comenzar";


    public ventanaComienzoApk(GestorLN gln_) {
        this.setTitle("BASKET LIVE ⛹️");
        gln = gln_;
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(this);
        setBounds(100, 100, 450, 120);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenuItem mntmNewMenuItem = new JMenuItem("BASKET LIVE \uD83C\uDFC0");
        menuBar.add(mntmNewMenuItem);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(50, 50));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnComenzar = new JButton("Comenzar");
        btnComenzar.setActionCommand(COMENZAR);
        btnComenzar.addActionListener(this);
        panel.add(btnComenzar);


    }

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
