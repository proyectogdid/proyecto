package com.company.LP;

import com.company.LN.GestorLN;
import com.company.comun.itfProperty;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import static com.company.comun.clsConstantes.EQUIPO_ID;
import static com.company.comun.clsConstantes.ESTADO_ID;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que utilizaremos para visualizar el marcador de un partido
 */
public class wdwMarcador extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField ptosEquipo1;
	private JTextField ptosEquipo2;
	private JLabel lblNewLabel_1;
	private GestorLN gln;
	private JButton btnGuardar;
	private itfProperty partido;
	/**
	 * Create the frame.
	 */
	public wdwMarcador(GestorLN gln_,itfProperty partido_) {
		gln = gln_;
		partido=partido_;
		this.setTitle("MARCADOR");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 628, 232);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Ptos.'Equipo1'");
		lblNewLabel.setBounds(72, 50, 100, 14);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Ptos.'Equipo2'");
		lblNewLabel_1.setBounds(339, 50, 100, 14);
		contentPane.add(lblNewLabel_1);

		ptosEquipo1 = new JTextField();
		ptosEquipo1.setBounds(72, 70, 86, 20);
		contentPane.add(ptosEquipo1);
		ptosEquipo1.setColumns(10);

		ptosEquipo2 = new JTextField();
		ptosEquipo2.setBounds(353, 70, 86, 20);
		contentPane.add(ptosEquipo2);
		ptosEquipo2.setColumns(10);

		btnGuardar = new JButton("guardar");
		btnGuardar.setBounds(350, 145, 89, 23);
		btnGuardar.addActionListener(this);
		btnGuardar.setActionCommand("guardarPartido");
		contentPane.add(btnGuardar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "guardarPartido":
			try {
				gln.updatePartido(partido, Integer.parseInt(ptosEquipo1.getText()), Integer.parseInt(ptosEquipo2.getText()));
				dispose();
			} catch (Exception e1) {
				javax.swing.JOptionPane.showMessageDialog(this, "introduce numero de ptos");
				e1.printStackTrace();
			}
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
