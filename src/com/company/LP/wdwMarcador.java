package com.company.LP;

import com.company.LN.GestorLN;
import com.company.LP.imagenes.clsImagen;
import com.company.comun.itfProperty;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que utilizaremos para visualizar el marcador de un partido
 */
public class wdwMarcador extends JFrame implements ActionListener {
	private JLabel local;
	private JTextField ptosEquipo1;
	private JTextField ptosEquipo2;
	private JLabel visitante;
	private GestorLN gln;
	private itfProperty partido;
	private final String VOLVER="volver";
	private final String GUARDAR="guardar";
	private clsImagen contentPane;
	/**
	 * Create the frame.
	 */
	public wdwMarcador(GestorLN gln_,itfProperty partido_) {
		gln = gln_;
		partido=partido_;
		this.setTitle("MARCADOR");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 232);
		contentPane = new clsImagen();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackgroundImage(contentPane.createImage("/com/company/LP/imagenes/marcador.png").getImage());
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		this.setResizable(false);

		local = new JLabel("LOCAL");
		local.setBounds(32, 50, 100, 14);
		local.setForeground(Color.WHITE);
		contentPane.add(local);

		visitante = new JLabel("VISITANTE");
		visitante.setBounds(405, 50, 100, 14);
		visitante.setForeground(Color.WHITE);
		contentPane.add(visitante);

		ptosEquipo1 = new JTextField();
		ptosEquipo1.setBounds(10, 70, 86, 20);
		contentPane.add(ptosEquipo1);
		ptosEquipo1.setColumns(10);

		ptosEquipo2 = new JTextField();
		ptosEquipo2.setBounds(393, 70, 86, 20);
		contentPane.add(ptosEquipo2);
		ptosEquipo2.setColumns(10);


		Button btnGuardar = new Button("Guardar");
		btnGuardar.setBounds(10, 120, 100, 23);
		btnGuardar.addActionListener(this);
		btnGuardar.setActionCommand(GUARDAR);
		contentPane.add(btnGuardar);

		Button volver = new Button("Volver");
		volver.addActionListener(this);
		volver.setActionCommand(VOLVER);
		getContentPane().add(volver, BorderLayout.SOUTH);

		/*
		 * Este boton se ha creado para que el boton iniciar sesion no de fallo y ocupe toda la pantalla
		 */
		Button bfixed = new Button("Arreglo de iniciar sesion");
		contentPane.add(bfixed);
		bfixed.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case GUARDAR:
			try {
				gln.updatePartido(partido, Integer.parseInt(ptosEquipo1.getText()), Integer.parseInt(ptosEquipo2.getText()));
				dispose();
			} catch (Exception e1) {
				javax.swing.JOptionPane.showMessageDialog(this, "introduce numero de ptos");
				e1.printStackTrace();
			}
			break;
			case VOLVER:
				wdwJornadas j=new wdwJornadas(gln);
				j.setVisible(true);
				this.dispose();
				break;
		}
	}

	/*
	 * private int buscarEquipo(int id){ for (int i = 0; i <equipos.size() ; i++) {
	 * if((int)equipos.get(i).getProperty(EQUIPO_ID)==id){ return i; } } return -1;
	 * 
	 * } private int buscarEstado(int id){ for (int i = 0; i <estados.size() ; i++)
	 * {
	 * 
	 * if((int)estados.get(i).getProperty(ESTADO_ID)==id){ return i; } } return -1;
	 * }
	 */
}
