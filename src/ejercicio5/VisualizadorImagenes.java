package ejercicio5;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisualizadorImagenes {

	private JFrame frmVisualizadorDeImagenes;
	private JFileChooser fileChooser;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizadorImagenes window = new VisualizadorImagenes();
					window.frmVisualizadorDeImagenes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VisualizadorImagenes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVisualizadorDeImagenes = new JFrame();
		frmVisualizadorDeImagenes.setTitle("Visualizador de imagenes");
		frmVisualizadorDeImagenes.setBounds(100, 100, 450, 300);
		frmVisualizadorDeImagenes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FiltroIMG());
		
		
		JDesktopPane desktopPane = new JDesktopPane();
		frmVisualizadorDeImagenes.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		frmVisualizadorDeImagenes.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = fileChooser.showOpenDialog(frmVisualizadorDeImagenes);
				if (res == JFileChooser.APPROVE_OPTION && desktopPane.countComponents()<5){
					
					JInternalFrame internalFrame = new JInternalFrame(fileChooser.getSelectedFile().getName());
					ImageIcon img = new ImageIcon(fileChooser.getSelectedFile().getPath());
					
					JLabel label = new JLabel(img);
					internalFrame.setSize(200, 300);
					
					internalFrame.setVisible(true);
					internalFrame.setClosable(true);
					internalFrame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
					internalFrame.add(label);
					desktopPane.add(internalFrame);
					
					
					
				}
				
				
			}
		});
		mnNewMenu.add(mntmAbrir);
		
	}
}
