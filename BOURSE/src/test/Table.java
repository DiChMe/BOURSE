package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import data.AchatN;
import data.CarnetOrdre;
import data.Execution;
import data.Main;
import data.Ordre;
import data.Vente;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.awt.event.ActionEvent;

public class Table {

	private JFrame frame;
	private JScrollPane scrollPane;
	private JButton btnOk;
	private JTable table;
	
	private CarnetOrdre carnet= new CarnetOrdre();
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private JButton btnTest;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Table window = new Table();
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
	public Table() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
        table= new JTable();
        Object[] s ={"Prix","quantité","date"};
        DefaultTableModel model= new DefaultTableModel();
        DefaultTableModel model_1= new DefaultTableModel();
		model.setColumnIdentifiers(s);
		model_1.setColumnIdentifiers(s);
		model.addRow(s);
		model.addRow(s);
		model.addRow(s);
		model.addRow(s);
		table.setModel(model);
		
	    scrollPane = new JScrollPane();
		scrollPane.setBounds(351, 38, 298, 403);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
	    btnOk = new JButton("ok");
	    btnOk.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		DefaultTableModel model = (DefaultTableModel) table.getModel();
    		   // model.setRowCount(0);
    		   // table.revalidate();
    		    
    		    DefaultTableModel model_1 = (DefaultTableModel) table_1.getModel();
    		   // model_1.setRowCount(0);
    		   // table_1.revalidate();
    		    
    		    Random k =new Random();
	    		for(int index=0; index<1000;index++)
	    		{
	    			 if(Main.aleatoire(5)){
	    				   double l=Main.prix(40,50);
	    				   int m=k.nextInt(47)+89;
	    			   Ordre ach = new AchatN(1,l,m,55,new Date(),"achat");
	    			   
	    			   System.out.println("achattttt");
	    			   Execution.insertAchat(carnet.getAchats(), ach);
	    			   re(model,carnet.getAchats(),table);
	    			   
	    			   }else{
	    				   System.out.println("vvvvvvtttt");
	    				   
	    				   double l=Main.prix(40,50);
	    				   int m=k.nextInt(47)+89;
	    			   Ordre ven = new Vente(1,l,m,55,new Date(),"vente");
	    			   Execution.insertVente(carnet.getVentes(), ven);
	    			      re(model_1,carnet.getVentes(),table_1);
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
	    				
	    				   re(model_1,carnet.getVentes(),table_1);
	    				   re(model,carnet.getAchats(),table);
	    				  
	    			   }
	    			   
	    			
	    			   }
	    			   else{
	    				   continue;
	    			   }
	    			   
	    			  
	    		   }
	    			
	    		
	    		
	    		
	    		 
	    		    /*dm.getDataVector().removeAllElements();
dm.fireTableDataChanged(); // notifies the JTable that the model has changed*/
	    		    /**/

	    	}
	    });
		btnOk.setBounds(532, 494, 117, 25);
		frame.getContentPane().add(btnOk);
		table_1= new JTable();
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(31, 38, 276, 403);
		frame.getContentPane().add(scrollPane_1);
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(model_1);
		
		btnTest = new JButton("test");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Ordre> items= carnet.getVentes();
				
				Object[] row= new Object[3];
				for(int i=0;i<carnet.getVentes().size();i++){
					
					Ordre or= items.get(0);
					row[0]=or.getPrix();
					row[1]=or.getQuantitée();
					row[2]=or.getDate().toString();
					//model.addRow(row);
					if(or.getType().equals("vente")){
					Execution.rec(items, or);}
					else{
						Execution.recachat(items, or);
					}
					
				} 
			  	  
			
			}
		});
		btnTest.setBounds(96, 494, 117, 25);
		frame.getContentPane().add(btnTest);
	}
	
	public static void re(DefaultTableModel model,ArrayList<Ordre>ordre,JTable table){
		
		model.setRowCount(0);
		table.revalidate();
		ArrayList<Ordre> items= ordre;
		Object[] row= new Object[3];
		int l=ordre.size();
		for(int i=0;i<l;i++){
			
			Ordre or= items.get(0);
			row[0]=or.getPrix();
			row[1]=or.getQuantitée();
			row[2]=or.getDate().toString();
			model.addRow(row);
			if(or.getType().equals("vente")){
			Execution.rec(items, or);}
			else{
				Execution.recachat(items, or);
			}
			
		}
		
		
		
		
	}
}
