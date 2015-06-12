package ejercicio2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class AlmacenarUsuario {

	private JFrame frmUsuario;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTextField textFieldEmail;
	private JTextField textFieldLogin;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlmacenarUsuario window = new AlmacenarUsuario();
					window.frmUsuario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AlmacenarUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUsuario = new JFrame();
		frmUsuario.setTitle("Usuario");
		frmUsuario.setBounds(100, 100, 526, 402);
		frmUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNombre = new JLabel("Nombre");
		
		JLabel lblApellidos = new JLabel("Apellidos");
		
		JLabel lblEmail = new JLabel("Email");
		
		JLabel lblLogin = new JLabel("Login");
		
		JLabel lblPassword = new JLabel("Password");
		
		JButton btnGuardar = new JButton("Guardar");
		
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
			}
		});
		
		JLabel labelEmailNoValido = new JLabel("<< Email no valido");
		labelEmailNoValido.setVisible(false);
		
		JLabel label_1 = new JLabel("<< Contrase\u00F1a no valida");
		label_1.setVisible(false);
		
		textFieldNombre = new JTextField();
		textFieldNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(textFieldApellidos.getText().length()>0){
					textFieldLogin.setText((textFieldNombre.getText().substring(0, 1)+textFieldApellidos.getText()).toLowerCase().replace(" ", ""));
				}
			}
		});
		textFieldNombre.setColumns(10);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.addFocusListener(new FocusAdapter() {
			
			public void focusLost(FocusEvent e) {
				
				if(textFieldNombre.getText().length()>0){
					textFieldLogin.setText((textFieldNombre.getText().substring(0, 1)+textFieldApellidos.getText()).toLowerCase().replace(" ", ""));
				}
			}
		});
		textFieldApellidos.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(textFieldEmail.getText().matches(".*[@].*")|| textFieldEmail.getText().equals("")){
					labelEmailNoValido.setVisible(false);
				} else {
					labelEmailNoValido.setVisible(true);
				}
			}
		});
		textFieldEmail.setColumns(10);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setEnabled(false);
		textFieldLogin.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(passwordField.getPassword().length >= 6){
					label_1.setVisible(false);
				} else {
					label_1.setVisible(true);
				}
			}
		});
		
		JLabel labelNombreNoValido = new JLabel("<< Introduzca su nombre");
		labelNombreNoValido.setVisible(false);
		
		JLabel labelApellidosNoValidos = new JLabel("<<Introduzca sus apellidos");
		labelApellidosNoValidos.setVisible(false);
		
		JLabel labelLog = new JLabel("");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textFieldLogin.equals("") && textFieldEmail.getText().matches(".*[@].*") && passwordField.getPassword().length >= 6){
					labelLog.setText("El usuario se ha guardado con exito");
					labelNombreNoValido.setVisible(false);
					labelApellidosNoValidos.setVisible(false);
					try(PrintWriter out = new PrintWriter(new File("C:\\Users\\berna\\Desktop\\workspace\\usuarios.csv"))){
						out.println(textFieldNombre+";"+textFieldApellidos+";"+textFieldEmail+";"+textFieldLogin+";"+"xxxx"+";");
						
					}catch (IOException ex){
						ex.printStackTrace();
					}
				} else {
					labelLog.setText("El usuario no se ha guardado");
					if(textFieldNombre.getText().equals("")) labelNombreNoValido.setVisible(true);
					else labelNombreNoValido.setVisible(false);
					if(textFieldApellidos.getText().equals("")) labelApellidosNoValidos.setVisible(true);
					else labelApellidosNoValidos.setVisible(false) ; 
				}
				
				
				
				
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(frmUsuario.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombre)
								.addComponent(lblApellidos)
								.addComponent(lblEmail)
								.addComponent(lblLogin)
								.addComponent(lblPassword))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordField)
								.addComponent(textFieldLogin)
								.addComponent(textFieldEmail)
								.addComponent(textFieldApellidos)
								.addComponent(textFieldNombre, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(labelApellidosNoValidos)
								.addComponent(labelNombreNoValido)
								.addComponent(label_1)
								.addComponent(labelEmailNoValido)))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(labelLog, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addComponent(btnGuardar)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnSalir))))
					.addContainerGap(69, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelNombreNoValido))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellidos)
						.addComponent(textFieldApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelApellidosNoValidos))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelEmailNoValido))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLogin)
						.addComponent(textFieldLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(label_1)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
					.addComponent(labelLog)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGuardar)
						.addComponent(btnSalir))
					.addContainerGap())
		);
		frmUsuario.getContentPane().setLayout(groupLayout);
	}
}
