package com.company.LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.company.LN.GestorLN;
import com.company.comun.itfProperty;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class wdwJornadas extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JList<itfProperty> list;
	private GestorLN gln;
	private DefaultListModel<itfProperty> modelo;
	/**
	 * Create the frame.
	 */
	public wdwJornadas(GestorLN gln_) {
		gln=gln_;
		LinkedList<itfProperty> Linklist=new LinkedList<itfProperty>(gln.leerJornadas());
		modelo=new DefaultListModel<itfProperty>();
		for (int i = 0; i < Linklist.size(); i++) {
			modelo.addElement(Linklist.get(i));	
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 593);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		 contentPane.setLayout(null);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(335, 520, 89, 23);
		btnActualizar.setEnabled(gln.isAdmin());
		contentPane.add(btnActualizar);
		btnActualizar.addActionListener(this);
		btnActualizar.setActionCommand("actualizar");
		
		 list = new JList(modelo);
	
		 list.setBounds(10, 11, 414, 498);
		
		contentPane.add(list);
		
		 
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getActionCommand()) {
		case"actualizar":
			wdwMarcador w=new wdwMarcador(gln, list.getSelectedValue());
			w.setVisible(true);
			break;
		}
	}
}
