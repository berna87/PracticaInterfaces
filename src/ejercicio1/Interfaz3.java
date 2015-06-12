package ejercicio1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class Interfaz3 {

	private JFrame frmInterfazEclipse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz3 window = new Interfaz3();
					window.frmInterfazEclipse.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInterfazEclipse = new JFrame();
		frmInterfazEclipse.setTitle("Interfaz Eclipse");
		frmInterfazEclipse.setBounds(100, 100, 800, 596);
		frmInterfazEclipse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmInterfazEclipse.setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu 1");
		menuBar.add(mnMenu);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mnMenu.add(mntmNuevo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mnMenu.add(mntmAbrir);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mnMenu.add(mntmGuardar);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnMenu.add(mntmSalir);
		
		JMenu mnMenu_1 = new JMenu("Menu 2");
		menuBar.add(mnMenu_1);
		
		JMenu mnMenu_2 = new JMenu("Menu 3");
		menuBar.add(mnMenu_2);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerLocation(200);
		frmInterfazEclipse.getContentPane().add(splitPane, BorderLayout.CENTER);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		splitPane.setLeftComponent(tabbedPane);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane_2, null);
		
		JTree tree = new JTree();
		scrollPane_2.setViewportView(tree);
		
		JLabel lblExplorador = new JLabel("Explorador");
		scrollPane_2.setColumnHeaderView(lblExplorador);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JRadioButton rdbtnOpcion = new JRadioButton("Opcion1");
		panel_1.add(rdbtnOpcion);
		
		JRadioButton rdbtnOpcion_1 = new JRadioButton("Opcion2");
		panel_1.add(rdbtnOpcion_1);
		
		JRadioButton rdbtnOpcion_2 = new JRadioButton("Opcion3");
		panel_1.add(rdbtnOpcion_2);
		
		JCheckBox chckbxCasilla = new JCheckBox("Casilla1");
		panel_1.add(chckbxCasilla);
		
		JCheckBox chckbxCasilla_1 = new JCheckBox("Casilla2");
		panel_1.add(chckbxCasilla_1);
		
		JCheckBox chckbxCasilla_2 = new JCheckBox("Casilla3");
		panel_1.add(chckbxCasilla_2);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		splitPane_1.setRightComponent(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEnabled(false);
		scrollPane.setViewportView(textArea);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		splitPane_1.setLeftComponent(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		splitPane_1.setDividerLocation(400);
		
		JPanel panel = new JPanel();
		frmInterfazEclipse.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JButton btnNewButton = new JButton("Boton1");
		panel.add(btnNewButton);
		
		JButton btnBoton = new JButton("Boton2");
		panel.add(btnBoton);
		
		JButton btnBoton_1 = new JButton("Boton3");
		panel.add(btnBoton_1);
		
		JButton btnBoton_2 = new JButton("Boton4");
		panel.add(btnBoton_2);
	}

}
