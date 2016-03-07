package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import data.Main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Carr {

	private JFrame frame;
	private JScrollPane scrollPane;
	private JTable table;
	private  Object[] s={"Prix","quantité","date"};
	private  Object[] m={"boussad","boussa","boussad"};
	private  Object[] m1={"merhane","merhane","merhane"};
	private JButton btnTestt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Carr window = new Carr();
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
	public Carr() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnOk = new JButton("ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				DefaultTableModel mode1=new DefaultTableModel();
				mode1.setColumnIdentifiers(s);
				model.setRowCount(0);
				table.revalidate();
				Object[]h= new Object[3];
				for(int g=0;g<10;g++){
					mode1.setRowCount(0);
				  for(int l=0;l<10;l++){	
				h[0]=Main.prix(50, 60);
				h[1]=8;
				h[2]=Main.prix(50, 60);
				mode1.addRow(h);
					
				}
				  table.setModel(mode1);
			}
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnOk.setBounds(12, 12, 117, 25);
		frame.getContentPane().add(btnOk);
		
	    scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 69, 541, 304);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		 
	     DefaultTableModel model= new DefaultTableModel();
	     model.setColumnIdentifiers(s);
	     table.setModel(model);
	     scrollPane.setViewportView(table);
	     
	     btnTestt = new JButton("testt");
	     btnTestt.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		
	     		DefaultTableModel model= new DefaultTableModel();
	     		DefaultTableModel model1= new DefaultTableModel();
	     		model.setColumnIdentifiers(s);
	     		model1.setColumnIdentifiers(s);
	     		
	     		model.addRow(m);model.addRow(m);model.addRow(m);
	     		model1.addRow(m1);	model1.addRow(m1);	model1.addRow(m1);
	     		
	     		for(int i=0;i<5;i++){
	     			
	     			table.setModel(model);
	     			try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
						
					}
	     			table.setModel(model1);
	     		}
	     		
	     		
	     	}
	     });
	     btnTestt.setBounds(150, 12, 117, 25);
	     frame.getContentPane().add(btnTestt);
	        
	}

}
