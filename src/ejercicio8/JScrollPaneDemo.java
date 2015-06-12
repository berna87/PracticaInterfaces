package ejercicio8;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class JScrollPaneDemo {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JScrollPaneDemo window = new JScrollPaneDemo();
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
	public JScrollPaneDemo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		splitPane.setDividerLocation(200);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane.setLeftComponent(splitPane_1);
		splitPane_1.setDividerLocation(200);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane_1.setLeftComponent(scrollPane);
		
		JTextArea textoIzq = new JTextArea();
		scrollPane.setViewportView(textoIzq);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		splitPane_1.setRightComponent(scrollPane_1);
		
		JTextArea textoDch = new JTextArea();
		scrollPane_1.setViewportView(textoDch);
		
		JTextArea textoRes = new JTextArea();
		textoRes.setEnabled(false);
		JScrollPane js = new JScrollPane(textoRes);
		splitPane.setRightComponent(js);
		
		JTextArea txtrIndiceres = new JTextArea();
		js.setRowHeaderView(txtrIndiceres);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmCargarArchivoIzquierdo = new JMenuItem("Cargar archivo izquierdo");
		mnArchivo.add(mntmCargarArchivoIzquierdo);
		
		mntmCargarArchivoIzquierdo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int opcion = fileChooser.showOpenDialog(frame);
				if(opcion == JFileChooser.APPROVE_OPTION){
					File f = fileChooser.getSelectedFile();
					String s="";
					try {
						Scanner in = new Scanner(f);
						while(in.hasNext()){
							s += (in.nextLine()+"\n");
						}
						in.close();
						textoIzq.setText(s);
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			}
		});
		
		JMenuItem mntmCargarArchivoDerecho = new JMenuItem("Cargar archivo derecho");
		mnArchivo.add(mntmCargarArchivoDerecho);
		
		mntmCargarArchivoDerecho.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int opcion = fileChooser.showOpenDialog(frame);
				if(opcion == JFileChooser.APPROVE_OPTION){
					File f = fileChooser.getSelectedFile();
					String s="";
					try {
						Scanner in = new Scanner(f);
						while(in.hasNext()){
							s += (in.nextLine()+"\n");
						}
						in.close();
						textoDch.setText(s);
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			}
		});
		
		
		
		JMenuItem mntmComparar = new JMenuItem("Comparar");
		mnArchivo.add(mntmComparar);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnArchivo.add(mntmSalir);
		mntmSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
				
			}
		});
		
		mntmComparar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String [] l1 = textoIzq.getText().split("[\n]");
				String [] l2 = textoDch.getText().split("[\n]");
				String diferencias="";
				String lineas="";
				if(l1.length > l2.length){
					for (int i = 0; i < l2.length; i++) {
						if(!l1[i].equals(l2[i])){
							diferencias+="Diferencia encontrada: "+l1[i] +" != "+l2[i]+"\n";
							lineas+=(i+1)+"- \n";
						}
					}
				}
				if(l1.length <= l2.length){
					for (int i = 0; i < l1.length; i++) {
						if(!l1[i].equals(l2[i])){
							diferencias+="Diferencia encontrada: "+l1[i] +" != "+l2[i]+"\n";
							lineas+=(i+1)+"- \n";
						}
					}
				}
				if(diferencias.equals("")){
					diferencias+="Los ficheros son iguales";
				}
				textoRes.setText(diferencias);
				txtrIndiceres.setText(lineas);
			}
		});
		JPanel sur = new JPanel();
		JLabel etiqueta = new JLabel();
		
		
	}
}
