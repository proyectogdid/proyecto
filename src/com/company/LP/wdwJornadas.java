package com.company.LP;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.company.LN.GestorLN;
import com.company.LP.imagenes.clsImagen;
import com.company.comun.itfProperty;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class wdwJornadas extends JFrame implements ActionListener {

	private clsImagen contentPane;
	private JList<itfProperty> list;
	private GestorLN gln;
	private DefaultListModel<itfProperty> modelo;
	private final String VOLVER = "volver";
	/**
	 * Create the frame.
	 */
	public wdwJornadas(GestorLN gln_) {
		this.setTitle("Jornada");
		gln=gln_;
		LinkedList<itfProperty> Linklist=new LinkedList<itfProperty>(gln.leerJornadas());
		modelo=new DefaultListModel<itfProperty>();
		for (int i = 0; i < Linklist.size(); i++) {
			modelo.addElement(Linklist.get(i));	
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new clsImagen();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackgroundImage(contentPane.createImage("/com/company/LP/imagenes/jornadas.png").getImage());
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		this.setResizable(false);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(10, 170, 100, 23);
		btnActualizar.setEnabled(gln.isAdmin());
		contentPane.add(btnActualizar);
		btnActualizar.addActionListener(this);
		btnActualizar.setActionCommand("actualizar");

		Button volver = new Button("Volver");
		volver.addActionListener(this);
		volver.setActionCommand(VOLVER);
		getContentPane().add(volver, BorderLayout.SOUTH);

		list = new JList(modelo);
		list.setBounds(10, 11, 178, 200);
		contentPane.add(list);
		/*
		 * Este boton se ha creado para que el boton iniciar sesion no de fallo y ocupe toda la pantalla
		 */
		Button bfixed = new Button("Arreglo de iniciar sesion");
		contentPane.add(bfixed);
		bfixed.setVisible(false);



		
		 
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getActionCommand()) {
		case"actualizar":
			wdwMarcador w=new wdwMarcador(gln, list.getSelectedValue());
			w.setVisible(true);
			this.dispose();
			break;
			case VOLVER:
				ventanaMenu vm=new ventanaMenu(gln);
				vm.setVisible(true);
				this.dispose();
				break;
		}
	}
}
