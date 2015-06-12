package ejercicio3_6_7;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AlmacenarUsuario2 {

	private JFrame frame;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTextField textFieldEmail;
	private JTextField textFieldLogin;
	private JPasswordField passwordField;
	private int indice = 0;
	List<Usuario> lista;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlmacenarUsuario2 window = new AlmacenarUsuario2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AlmacenarUsuario2() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 535, 395);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lista = new ArrayList<Usuario>();
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FiltroCSV());
		
		JLabel lblNombre = new JLabel("Nombre");
		
		JLabel lblApellidos = new JLabel("Apellidos");
		
		JLabel lblEmail = new JLabel("Email");
		
		JLabel lblLogin = new JLabel("Login");
		table= new JTable();
		JLabel lblPassword = new JLabel("Password");
		JLabel lblLogs = new JLabel("");
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
			@Override
			public void focusLost(FocusEvent arg0) {
				if(textFieldNombre.getText().length()>0){
					textFieldLogin.setText((textFieldNombre.getText().substring(0, 1)+textFieldApellidos.getText()).toLowerCase().replace(" ", ""));
				}
			}
		});
		textFieldApellidos.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
			}
		});
		textFieldEmail.setColumns(10);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setEnabled(false);
		textFieldLogin.setColumns(10);
		
		passwordField = new JPasswordField();
		
		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(indice > 0){
					indice--;
					textFieldNombre.setText(lista.get(indice).getNombre());
					textFieldApellidos.setText(lista.get(indice).getApellidos());
					textFieldLogin.setText(lista.get(indice).getLogin());
					textFieldEmail.setText(lista.get(indice).getEmail());			
					passwordField.setText(lista.get(indice).getPasswd());
				}
					
			}
		});
		
		JButton btnAdd = new JButton("A\u00F1adir");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textFieldNombre.getText().length()>0 && textFieldApellidos.getText().length()>0 
						&& textFieldLogin.getText().length()>0 && passwordField.getPassword().length >=6 &&
						textFieldEmail.getText().matches(".*[@].*")){
					String aux="";
					for (int i = 0; i < passwordField.getPassword().length; i++) {
						aux+=passwordField.getPassword()[i];
					}
					
					
					
					Usuario u = new Usuario(textFieldNombre.getText(), textFieldApellidos.getText(), 
							textFieldEmail.getText(), textFieldLogin.getText(), aux);
					if(!lista.contains(u)) {
						lista.add(u);					
						indice++;
						textFieldNombre.setText("");
						textFieldApellidos.setText("");
						textFieldLogin.setText("");
						textFieldEmail.setText("");
						passwordField.setText("");
					lblLogs.setText("Usuario añadido con exito");
					actualizarTabla();
					} else {
						lblLogs.setText("La lista ya contiene este usuario");
					}
				} else {
					lblLogs.setText("No se ha podido añadir el usuario");
					
				}
			}
		});
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String aux="";
				for (int i = 0; i < passwordField.getPassword().length; i++) {
					aux+=passwordField.getPassword()[i];
				}
				
				Usuario u = new Usuario(textFieldNombre.getText(), textFieldApellidos.getText(), 
						textFieldEmail.getText(), textFieldLogin.getText(),aux);
				if(lista.contains(u)) {
					lista.remove(u);
					indice--;
					if (indice < 0 ) indice =0;
					lblLogs.setText("Usuario eliminado de la lista");
					textFieldNombre.setText("");
					textFieldApellidos.setText("");
					textFieldLogin.setText("");
					textFieldEmail.setText("");
					passwordField.setText("");
					actualizarTabla();
				} else {
					lblLogs.setText("Usuario no encontrado en la lista");
				}
				
				
			}
		});
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				indice++;
				if (indice >= lista.size() )indice--;
				textFieldNombre.setText(lista.get(indice).getNombre());
				textFieldApellidos.setText(lista.get(indice).getApellidos());
				textFieldLogin.setText(lista.get(indice).getLogin());
				textFieldEmail.setText(lista.get(indice).getEmail());
				
				passwordField.setText(lista.get(indice).getPasswd());
				
			}
		});
		
		JLabel lblEmailNoValido = new JLabel("Email no valido");
		lblEmailNoValido.setVisible(false);
		
		JLabel lblPassNoValida = new JLabel("Pass no valida");
		lblPassNoValida.setVisible(false);
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(passwordField.getPassword().length>=6 || passwordField.getPassword().length == 0)
					lblPassNoValida.setVisible(false);
				else 
					lblPassNoValida.setVisible(true);	
			}
		});
		textFieldEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(textFieldEmail.getText().matches(".*[@].*") || textFieldEmail.getText().equals(""))
					lblEmailNoValido.setVisible(false);
				else 
					lblEmailNoValido.setVisible(true);	
			}
		});
		
		JLabel label = new JLabel(">>>");
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
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
								.addComponent(textFieldNombre, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPassNoValida)
								.addComponent(lblEmailNoValido)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAnterior)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAdd)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBorrar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSiguiente))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblLogs, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(96, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellidos)
						.addComponent(textFieldApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmailNoValido))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLogin)
						.addComponent(textFieldLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassNoValida))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAnterior)
						.addComponent(btnAdd)
						.addComponent(btnBorrar)
						.addComponent(btnSiguiente))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(lblLogs))
					.addContainerGap())
		);
		
		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int resultado = fileChooser.showOpenDialog(frame);
				if (resultado == JFileChooser.APPROVE_OPTION){
					File ficheroCSV = fileChooser.getSelectedFile();
					try (Scanner in = new Scanner(ficheroCSV);){
						lista.clear();
						String [] aux;
						while (in.hasNext()) {
							aux = in.nextLine().split(";");

							lista.add(new Usuario(aux[0],aux[1],aux[2],aux[3],aux[4]));
							textFieldNombre.setText(lista.get(indice).getNombre());
							textFieldApellidos.setText(lista.get(indice).getApellidos());
							textFieldLogin.setText(lista.get(indice).getLogin());
							textFieldEmail.setText(lista.get(indice).getEmail());
							passwordField.setText(lista.get(indice).getPasswd());
						}
						if(lista.size()>0){
						textFieldNombre.setText(lista.get(0).getNombre());
						textFieldApellidos.setText(lista.get(0).getApellidos());
						textFieldLogin.setText(lista.get(0).getLogin());
						textFieldEmail.setText(lista.get(0).getEmail());
						passwordField.setText(lista.get(0).getPasswd());
						actualizarTabla();
						}
						
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		mnArchivo.add(mntmAbrir);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (fileChooser.getSelectedFile()!=null){
					File fichero = fileChooser.getSelectedFile();
					try (PrintWriter out = new PrintWriter(fichero);){
						
						for (Usuario usuario : lista) {
							out.write(usuario.getNombre()+";"+usuario.getApellidos()+";"+usuario.getEmail()+
									";"+usuario.getLogin()+";"+usuario.getPasswd()+"\n");
							out.flush();
						}
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				} else {
					int resultado = fileChooser.showSaveDialog(frame);
					if(resultado == JFileChooser.APPROVE_OPTION){
						try (PrintWriter out = new PrintWriter(fileChooser.getSelectedFile());){
							
							for (Usuario usuario : lista) {
								out.write(usuario.getNombre()+";"+usuario.getApellidos()+";"+usuario.getEmail()+
										";"+usuario.getLogin()+";"+usuario.getPasswd()+"\n");
								out.flush();
							}
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
					}
					
				}
				
				
			}
		});
		mnArchivo.add(mntmGuardar);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
			}
		});
		mnArchivo.add(mntmSalir);
	}
	private void actualizarTabla(){
		String [] s = {"Nombre","Apellidos","Email","Login","Contraseña"};
		table.setModel(new UsuarioTableModel(lista, s));
	}
	
}
