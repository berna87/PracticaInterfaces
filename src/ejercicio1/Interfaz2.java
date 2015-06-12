package ejercicio1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

public class Interfaz2 {

	private JFrame frmPersona;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz2 window = new Interfaz2();
					window.frmPersona.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPersona = new JFrame();
		frmPersona.setResizable(false);
		frmPersona.setTitle("Persona");
		frmPersona.setBounds(100, 100, 805, 599);
		frmPersona.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNombre = new JLabel("Nombre");
		
		JLabel lblApellidos = new JLabel("Apellidos");
		
		JLabel lblDni = new JLabel("DNI");
		
		JLabel lblEdad = new JLabel("Edad");
		
		JLabel lblTelefono = new JLabel("Telefono");
		
		JLabel lblDireccion = new JLabel("Direccion");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar Persona");
		
		JButton btnModificarPersona = new JButton("Modificar Persona");
		
		JButton btnBorrarPersona = new JButton("Borrar Persona");
		
		JButton btnAnterior = new JButton("Anterior");
		
		JButton btnSiguiente = new JButton("Siguiente");
		
		JLabel lblBuscador = new JLabel("Buscar por");
		lblBuscador.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JCheckBox chckbxNombre = new JCheckBox("Nombre");
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		JCheckBox chckbxApellidos = new JCheckBox("Apellidos");
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		JCheckBox chckbxDni = new JCheckBox("DNI");
		
		JCheckBox chckbxEdad = new JCheckBox("Edad");
		
		JCheckBox chckbxTelefono = new JCheckBox("Telefono");
		
		JCheckBox chckbxDireccion = new JCheckBox("Direccion");
		
		JButton btnNewButton = new JButton("Mostrar");
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JButton btnNewButton_1 = new JButton("Salir");
		GroupLayout groupLayout = new GroupLayout(frmPersona.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTelefono)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDireccion)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombre)
								.addComponent(lblApellidos)
								.addComponent(lblDni)
								.addComponent(lblEdad))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
								.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
								.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAnterior)
							.addPreferredGap(ComponentPlacement.RELATED, 476, Short.MAX_VALUE)
							.addComponent(btnSiguiente))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(chckbxDireccion)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_11))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(chckbxTelefono)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_10))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(chckbxEdad)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_9))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(chckbxDni)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_8))
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(chckbxApellidos)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_7))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(chckbxNombre)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 373, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnGuardar)
								.addComponent(lblBuscador))
							.addGap(136)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblResultado)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnModificarPersona)
									.addPreferredGap(ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
									.addComponent(btnBorrarPersona)))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellidos)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDni)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEdad)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefono)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDireccion)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGuardar)
						.addComponent(btnBorrarPersona)
						.addComponent(btnModificarPersona))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAnterior)
						.addComponent(btnSiguiente))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBuscador)
						.addComponent(lblResultado))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(chckbxNombre)
								.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(chckbxApellidos)
								.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(chckbxDni)
								.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(chckbxEdad)
								.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(chckbxTelefono)
								.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(chckbxDireccion)
								.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_1))
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		JLabel lblPersonas = new JLabel("Personas");
		scrollPane.setColumnHeaderView(lblPersonas);
		
		JTree tree = new JTree();
		scrollPane.setViewportView(tree);
		frmPersona.getContentPane().setLayout(groupLayout);
	}
}
