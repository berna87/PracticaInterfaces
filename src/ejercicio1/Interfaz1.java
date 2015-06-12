package ejercicio1;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;

public class Interfaz1 {

	private JFrame frmPreferences;
	private JTextField txtTypeFilterText;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz1 window = new Interfaz1();
					window.frmPreferences.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPreferences = new JFrame();
		frmPreferences.setTitle("Preferences");
		frmPreferences.setBounds(100, 100, 726, 606);
		frmPreferences.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPreferences.getContentPane().setLayout(new BorderLayout(20, 5));
		
		JPanel panel = new JPanel();
		frmPreferences.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		Component verticalStrut = Box.createVerticalStrut(50);
		panel.add(verticalStrut);
		Component horizontalGlue = Box.createHorizontalGlue();
		panel.add(horizontalGlue);
		
		JButton btnOk = new JButton("         Ok        ");
		
		panel.add(btnOk);
		
		Component horizontalStrut = Box.createHorizontalStrut(10);
		panel.add(horizontalStrut);
		
		JButton btnCancel = new JButton("      Cancel      ");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		
		panel.add(btnCancel);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerLocation(150);
		frmPreferences.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		
		txtTypeFilterText = new JTextField();
		txtTypeFilterText.setText("type filter text");
		scrollPane.setColumnHeaderView(txtTypeFilterText);
		txtTypeFilterText.setColumns(10);
		
		JTree tree = new JTree();
		
		scrollPane.setViewportView(tree);
		
		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		panel_1.setLayout(new BorderLayout(10, 10));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		panel_2.add(horizontalGlue_1);
		
		JButton btnNewButton = new JButton("Restore Defaults");
		panel_2.add(btnNewButton);
		
		JButton btnApply = new JButton("       Apply       ");
		panel_2.add(btnApply);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		Component verticalStrut_1 = Box.createVerticalStrut(8);
		panel_3.add(verticalStrut_1);
		
		JLabel lblGeneral = new JLabel("General");
		lblGeneral.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblGeneral);
		
		Component verticalStrut_2 = Box.createVerticalStrut(8);
		panel_3.add(verticalStrut_2);
		
		JCheckBox chckbxAlwaysRunIn = new JCheckBox("Always run in background");
		panel_3.add(chckbxAlwaysRunIn);
		
		JCheckBox chckbxKeepNextpreviousEditor = new JCheckBox("Keep next/previous editor, view and perspectives dialog open");
		panel_3.add(chckbxKeepNextpreviousEditor);
		
		JCheckBox chckbxShowHeapStatus = new JCheckBox("Show heap status");
		panel_3.add(chckbxShowHeapStatus);
		
		Component verticalGlue = Box.createVerticalGlue();
		panel_3.add(verticalGlue);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_4.add(panel_5, BorderLayout.NORTH);
		
		JLabel lblWorkbenchSaveInterval = new JLabel("Workbench save interval (in minutes) :");
		panel_5.add(lblWorkbenchSaveInterval);
		
		textField = new JTextField();
		textField.setText("5");
		panel_5.add(textField);
		textField.setColumns(20);
		
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Open mode", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));
		
		JRadioButton rdbtnDoubleClick = new JRadioButton("Double Click");
		panel_6.add(rdbtnDoubleClick);
		
		
		JRadioButton rdbtnSingleClik = new JRadioButton("Single Clik");
		panel_6.add(rdbtnSingleClik);
		
		JCheckBox chckbxSelectOnHover = new JCheckBox("Select on hover");
		panel_6.add(chckbxSelectOnHover);
		
		JCheckBox chckbxOpenWhenUse = new JCheckBox("Open when using arrow keys");
		panel_6.add(chckbxOpenWhenUse);
		rdbtnDoubleClick.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(rdbtnDoubleClick.isSelected()==true){
					chckbxSelectOnHover.setEnabled(false);
					chckbxOpenWhenUse.setEnabled(false);
					rdbtnSingleClik.setSelected(false);
					rdbtnDoubleClick.setSelected(true);
				}
			}
		});
		rdbtnSingleClik.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(rdbtnSingleClik.isSelected()==true){
					chckbxSelectOnHover.setEnabled(true);
					chckbxOpenWhenUse.setEnabled(true);
					rdbtnDoubleClick.setSelected(false);
					rdbtnSingleClik.setSelected(true);
				}
			}
		});
		rdbtnDoubleClick.setSelected(true);
		chckbxSelectOnHover.setEnabled(false);
		chckbxOpenWhenUse.setEnabled(false);
		
		JLabel lblNoteThisPreference = new JLabel("Note: This preference may not take effect on all views");
		lblNoteThisPreference.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_6.add(lblNoteThisPreference);
		
		Component verticalStrut_3 = Box.createVerticalStrut(198);
		panel_4.add(verticalStrut_3, BorderLayout.SOUTH);
	}

}
