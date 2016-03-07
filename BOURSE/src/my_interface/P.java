package my_interface;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.events.Event;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import java.awt.Color;

public class P {

	private JFrame frame;
	private JTextField textField;
	private JComboBox comboBox;
	private JScrollPane scrollPane;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					P window = new P();
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
	public P() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(70, 130, 180));
		frame.setBounds(100, 100, 1350, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 12, 545, 541);
		frame.getContentPane().add(scrollPane);
		
		table= new JTable();
		DefaultTableModel model= new DefaultTableModel();
		Object[]s={"NOM","CAPTITAL","TYPE"};
		model.setColumnIdentifiers(s);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		
		comboBox = new JComboBox();
		comboBox.setBounds(807, 184, 297, 36);
		frame.getContentPane().add(comboBox);
		
		
	
}
}