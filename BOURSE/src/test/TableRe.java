package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import data.*;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.awt.event.ActionEvent;

public class TableRe implements Runnable{

	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnNewButton;
	private static DefaultTableModel model;
	private static DefaultTableModel model1;
	private static Object[] s ={"aa","bb","cc"};
	private static Object[] sa ={"boussad","merhane","merhaneboussad"};
	private static int x=0;
	private TableRe instance= this;
	private JScrollPane scrollPane_1;
	private JTable table1;
	private DefaultTableModel model2;
	private static CarnetOrdre carnet=new CarnetOrdre();
	private JButton btnLol;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableRe window = new TableRe();
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
	public TableRe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Random k=new Random();
		for(int index=0; index<100;index++)
		{
			 if(Main.aleatoire(5)){
				   double l=Main.prix(40,50);
				   int m=k.nextInt(47)+89;
			   Ordre ach = new AchatN(1,l,m,55,new Date(),"achat");
			   
			   System.out.println("achattttt");
			   Execution.insertAchat(carnet.getAchats(), ach);
			  //table.setModel(re(carnet.getAchats()));
			   
			   }else{
				   System.out.println("vvvvvvtttt");
				   
				   double l=Main.prix(40,50);
				   int m=k.nextInt(47)+89;
			   Ordre ven = new Vente(1,l,m,55,new Date(),"vente");
			   Execution.insertVente(carnet.getVentes(), ven);
			   //table1.setModel(re(carnet.getVentes()));
			   }
			   System.err.println(carnet.getAchats());
			   
			   if(carnet.getVentes().size()>0 && carnet.getAchats().size()>0){
			   Ordre gvente=carnet.getVentes().get(0);
			   Ordre fachat=carnet.getAchats().get(0);
			   
			  
			   if(gvente.getPrix()>=fachat.getPrix()){
				 
				   System.err.println(carnet.getAchats());
				   Execution.rec(carnet.getVentes(), fachat);
				   Execution.recachat(carnet.getAchats(), gvente);
				   
				 
				   //System.out.println(carnet.getAchats());
			   }
			   }
			   else{
				   continue;
			   }
			   
			}
	   
		
		   
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(410, 61, 260, 297);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model= new DefaultTableModel();
		model.setColumnIdentifiers(s);	
		model.addRow(s);model.addRow(s);model.addRow(s);model.addRow(s);
		
		
		model1= new DefaultTableModel();
		model1.setColumnIdentifiers(s);	
		model1.addRow(sa);model1.addRow(sa);model1.addRow(sa);model1.addRow(sa);
		
		
	    btnNewButton = new JButton("New button");
	    btnNewButton.addActionListener(new ActionListener() {
	    	

			

			public void actionPerformed(ActionEvent arg0) {
	    		Thread thr= new Thread(instance);
	    		thr.start();
	    	}
	    });
		btnNewButton.setBounds(51, 12, 204, 43);
		frame.getContentPane().add(btnNewButton);
		
		scrollPane_1 = new JScrollPane();
		table1 = new JTable();
		scrollPane_1.setViewportView(table1);
		model2= new DefaultTableModel();
		model2.setColumnIdentifiers(s);	
		model2.addRow(s);model2.addRow(s);model2.addRow(s);model2.addRow(s);
		table1.setModel(model2);
		model2.addRow(s);model2.addRow(s);model2.addRow(s);model2.addRow(s);
		scrollPane_1.setBounds(61, 75, 277, 258);
		frame.getContentPane().add(scrollPane_1);
		
		btnLol = new JButton("lol");
		btnLol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				   table.setModel(model);
				   table1.setModel(model);
				   }
				
			
		});
		btnLol.setBounds(148, 356, 117, 25);
		frame.getContentPane().add(btnLol);
	}

	@Override
	public void run() {
		Random k=new Random();
		  try {
		for(int index=0; index<100;index++)
		{
			 if(Main.aleatoire(5)){
				   double l=Main.prix(40,50);
				   int m=k.nextInt(47)+89;
			   Ordre ach = new AchatN(1,l,m,55,new Date(),"achat");
			   
			  // System.out.println("achattttt");
			   Execution.insertAchat(carnet.getAchats(), ach);
			 // table.setModel(re(carnet.getAchats()));
			   
			   }else{
				   System.out.println("vvvvvvtttt");
				   
				   double l=Main.prix(40,50);
				   int m=k.nextInt(47)+89;
			   Ordre ven = new Vente(1,l,m,55,new Date(),"vente");
			   Execution.insertVente(carnet.getVentes(), ven);
			  // table1.setModel(ree(carnet.getVentes()));
			   }
			  // System.err.println(carnet.getAchats());
			   
			  /* if(carnet.getVentes().size()>0 && carnet.getAchats().size()>0){
			   Ordre gvente=carnet.getVentes().get(0);
			   Ordre fachat=carnet.getAchats().get(0);
			   
			  
			  if(gvente.getPrix()>=fachat.getPrix()){
				 
				   System.err.println(carnet.getAchats());
				   Execution.rec(carnet.getVentes(), fachat);
				   Execution.recachat(carnet.getAchats(), gvente);
				
				   //System.out.println(carnet.getAchats());
			   }
			   }
			   else{
				   continue;
			   }*/
				   table.setModel(re(carnet.getAchats()));
				   table1.setModel(ree(carnet.getVentes())); 
		  
				Thread.sleep(3000);
		}
		  }
				  
			 catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		   }
		

	
	
	public static  DefaultTableModel re(ArrayList<Ordre>ordre){
		
			model.setRowCount(0);
			//table.revalidate();
			ArrayList<Ordre> items= ordre;
			Object[] row= new Object[3];
			int l=ordre.size();
			for(int i=0;i<l;i++){
				
				Ordre or= items.get(0);
				row[0]=or.getPrix();
				row[1]=or.getQuantitée();
				row[2]=or.getDate().toString();
				model.addRow(row);
				
					Execution.recachat(items, or);
				
				
			}
			return model;
	}
	public static  DefaultTableModel ree(ArrayList<Ordre>ordre){
		
		model1.setRowCount(0);
		//table.revalidate();
		ArrayList<Ordre> items= ordre;
		Object[] row= new Object[3];
		int l=ordre.size();
		for(int i=0;i<l;i++){
			
			Ordre or= items.get(0);
			row[0]=or.getPrix();
			row[1]=or.getQuantitée();
			row[2]=or.getDate().toString();
			model1.addRow(row);
			
				Execution.rec(items, or);
			
			
		}
		return model1;
				
			
	}
}
