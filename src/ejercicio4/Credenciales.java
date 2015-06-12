package ejercicio4;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPasswordField;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Credenciales {

	private JFrame frmCredenciales;
	private JTextField textFieldSitio;
	private JTextField textFieldDescrip;
	private JTextField textFieldUrl;
	private JTextField textFieldUsuario;
	private JTextField textFieldpass;
	private JScrollPane scrollPane;
	private JTextArea textField;
	private JMenuBar menuBar;
	private JMenu mnBaseDeDatos;
	private JMenuItem mntmCargarFichero;
	private JMenuItem mntmGuardar;
	private JMenu mnSitioWeb;
	private JMenuItem mntmSiguiente;
	private JMenuItem mntmAnterior;
	private JMenuItem mntmNuevo;
	private JMenuItem mntmEliminar;
	private JMenu mnAyuda;
	private JMenuItem mntmAcercaDe;
	private JPasswordField passwordField;
	private String password;
	private int indice = 0;
	private List<Login> listaLogin;
	private JButton btnNewButton;
	private JPanel panelPass;
	private JLabel lblRegistro;
	private JFileChooser fileChooser;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Credenciales window = new Credenciales();
					window.frmCredenciales.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Credenciales() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCredenciales = new JFrame();
		frmCredenciales.setTitle("Credenciales");
		frmCredenciales.setBounds(100, 100, 450, 300);
		frmCredenciales.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelPass = new JPanel();
		fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FiltroCSV());
		
		JLabel lblNombreDelSitio = new JLabel("Nombre del Sitio");
		textFieldpass = new JTextField();
		textFieldSitio = new JTextField();
		textFieldSitio.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				listaLogin.get(indice).setNombreSitio(textFieldSitio.getText());
			}
		});
		textFieldSitio.setColumns(10);
		
		listaLogin = new ArrayList<Login>();
		listaLogin.add(new Login("", "", "", "", "", ""));
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		
		textFieldDescrip = new JTextField();
		textFieldDescrip.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				listaLogin.get(indice).setDescripSitio(textFieldDescrip.getText());
			}
		});
		textFieldDescrip.setColumns(10);
		
		JLabel lblUrlAcceso = new JLabel("URL acceso");
		
		textFieldUrl = new JTextField();
		textFieldUrl.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				listaLogin.get(indice).setUrlAcceso(textFieldUrl.getText());
			}
		});
		textFieldUrl.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				listaLogin.get(indice).setUsuario(textFieldUsuario.getText());
			}
		});
		textFieldUsuario.setColumns(10);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a");
		
		JLabel lblMasInformacion = new JLabel("Mas info");
		
		scrollPane = new JScrollPane();
		
		btnNewButton = new JButton("Mostrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (btnNewButton.getText().equals("Mostrar")) {
					btnNewButton.setText("Ocultar");
						password = String.valueOf(passwordField.getPassword());
						panelPass.remove(passwordField);
						panelPass.add(textFieldpass, BorderLayout.CENTER);
						textFieldpass.setText(password);
				} else {
					btnNewButton.setText("Mostrar");
					password = textFieldpass.getText();
					panelPass.remove(textFieldpass);
					panelPass.add(passwordField, BorderLayout.CENTER);
					passwordField.setText(password);
				}
			}
		});
		
		lblRegistro = new JLabel("Registro : "+(indice+1));
		
		
		GroupLayout groupLayout = new GroupLayout(frmCredenciales.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombreDelSitio)
								.addComponent(lblDescripcion)
								.addComponent(lblUrlAcceso)
								.addComponent(lblUsuario)
								.addComponent(lblContrasena)
								.addComponent(lblMasInformacion))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
								.addComponent(textFieldDescrip, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
								.addComponent(textFieldSitio, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
								.addComponent(textFieldUrl, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
								.addComponent(textFieldUsuario, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(panelPass, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))))
						.addComponent(lblRegistro))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreDelSitio)
						.addComponent(textFieldSitio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescripcion)
						.addComponent(textFieldDescrip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUrlAcceso)
						.addComponent(textFieldUrl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsuario)
						.addComponent(textFieldUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblContrasena)
							.addComponent(btnNewButton))
						.addComponent(panelPass, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMasInformacion)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
					.addComponent(lblRegistro)
					.addContainerGap())
		);
		panelPass.setLayout(new BorderLayout(0, 0));
		
		passwordField = new JPasswordField();
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				listaLogin.get(indice).setPasswd(String.valueOf(passwordField.getPassword()));
			}
		});
		textFieldpass.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				listaLogin.get(indice).setPasswd(textFieldpass.getText());
			}
		});
		passwordField.setEchoChar('*');
		panelPass.add(passwordField, BorderLayout.CENTER);
		
		textField = new JTextArea();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				listaLogin.get(indice).setInfo(textField.getText());
			}
		});
		scrollPane.setViewportView(textField);
		textField.setColumns(10);
		frmCredenciales.getContentPane().setLayout(groupLayout);
		
		menuBar = new JMenuBar();
		frmCredenciales.setJMenuBar(menuBar);
		
		mnBaseDeDatos = new JMenu("Base de Datos");
		menuBar.add(mnBaseDeDatos);
		
		mntmCargarFichero = new JMenuItem("Cargar fichero");
		mntmCargarFichero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = fileChooser.showOpenDialog(frmCredenciales);
				if(res == JFileChooser.APPROVE_OPTION){
					try (Scanner in = new Scanner(fileChooser.getSelectedFile());){
						String aux[] = new String [6];
						listaLogin.clear();
						while(in.hasNextLine()){
							aux = in.nextLine().split(";");
							listaLogin.add(new Login(aux[0], aux[1], aux[2], aux[3], aux[4], aux[5]));
						}
						if(listaLogin.size()>0){
							refrescar();
						}
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
				}	
				
				
			}
		});
		mnBaseDeDatos.add(mntmCargarFichero);
		
		mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = fileChooser.showSaveDialog(frmCredenciales);
				if(res == JFileChooser.APPROVE_OPTION){
					try (PrintWriter out = new PrintWriter(fileChooser.getSelectedFile());) {
						for (Login login : listaLogin) {
							out.write(login.getNombreSitio()+";"+login.getDescripSitio() +";"+login.getUrlAcceso() +";"+login.getUsuario() +";"+login.getPasswd() +";"+login.getInfo()+"\n");
						}
						
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
				}
				
				
			}
		});
		mnBaseDeDatos.add(mntmGuardar);
		
		mnSitioWeb = new JMenu("Sitio Web");
		menuBar.add(mnSitioWeb);
		
		mntmSiguiente = new JMenuItem("Siguiente");
		mntmSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (indice < listaLogin.size()-1){
					indice++;
					refrescar();
				}
			}
		});
		mnSitioWeb.add(mntmSiguiente);
		
		mntmAnterior = new JMenuItem("Anterior");
		mntmAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(indice > 0){
					indice--;
					refrescar();
				}
			}
		});
		mnSitioWeb.add(mntmAnterior);
		
		mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listaLogin.add(new Login("", "", "", "", "", ""));
				indice = listaLogin.size()-1;
				refrescar();	
			}
		});
		mnSitioWeb.add(mntmNuevo);
		
		mntmEliminar = new JMenuItem("Eliminar");
		mntmEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaLogin.remove(indice);
				if(listaLogin.size()>0){
					indice--;
					refrescar();
				} else {
					listaLogin.add(new Login("", "", "", "", "", ""));
					indice = listaLogin.size()-1;
					refrescar();
				}
				
			}
		});
		mnSitioWeb.add(mntmEliminar);
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		mntmAcercaDe = new JMenuItem("Acerca de");
		mnAyuda.add(mntmAcercaDe);
	}
	private void refrescar(){
		if(listaLogin.get(indice)!=null){
			textFieldSitio.setText(listaLogin.get(indice).getNombreSitio());
			textFieldDescrip.setText(listaLogin.get(indice).getDescripSitio());
			textFieldUrl.setText(listaLogin.get(indice).getUrlAcceso());
			textFieldUsuario.setText(listaLogin.get(indice).getUsuario());
			if (btnNewButton.getText().equals("Mostrar")) {
				passwordField.setText(listaLogin.get(indice).getPasswd());
			} else {
				textFieldpass.setText(listaLogin.get(indice).getPasswd());
			}
			textField.setText(listaLogin.get(indice).getInfo());
			lblRegistro.setText("Registro : "+(indice+1));
		}
	}
}
