package com.company.LP;

import java.awt.BorderLayout;
import static com.company.comun.clsConstantes.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.company.comun.itfProperty;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JComboBox;
import java.awt.Button;

public class wdwJugador extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JComboBox cbEquipo;
	private JComboBox cbPosicion;
	private JComboBox cbEstado;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wdwJugador frame = new wdwJugador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public wdwJugador() {
		
	}
	/**
	 * Create the frame.
	 */
	public wdwJugador(ArrayList<itfProperty>equipos,ArrayList<itfProperty> posiciones, ArrayList<itfProperty> estados ) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(72, 50, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(158, 47, 212, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(72, 102, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(158, 99, 212, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(159, 147, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(158, 178, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(159, 219, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(158, 268, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(72, 150, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(72, 181, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(72, 222, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(72, 271, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(176, 329, -12, 14);
		contentPane.add(comboBox);
		
		cbEquipo = new JComboBox();
		cbEquipo.setBounds(160, 329, 86, 20);
		contentPane.add(cbEquipo);
		
		cbPosicion = new JComboBox();
		cbPosicion.setBounds(158, 376, 87, 20);
		contentPane.add(cbPosicion);
		
		cbEstado = new JComboBox();
		cbEstado.setBounds(158, 421, 86, 20);
		contentPane.add(cbEstado);
		
		lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(72, 329, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(72, 379, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		Button button = new Button("New button");
		button.setBounds(399, 462, 70, 22);
		contentPane.add(button);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(72, 424, 46, 14);
		contentPane.add(lblNewLabel_8);
		for(int i=0;i<equipos.size();i++) {
			cbEquipo.addItem(equipos.get(i).getProperty(EQUIPO_NOMBRE));
		}
		
		for(int i=0;i<posiciones.size();i++) {
			cbPosicion.addItem(posiciones.get(i).getProperty(POSICION_NOMBRE));
		}
		for(int i=0;i<estados.size();i++) {
			cbEstado.addItem(estados.get(i).getProperty(ESTADO_NOMBRE));
		}
	}
}
