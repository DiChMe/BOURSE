package test;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

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

import java.awt.event.ActionEvent;

public class LastTest implements Runnable {

	private static final long CHRONO_SPEED = 1000;
	private JFrame frame;
	private JTable table;
	 Object[] s ={"Prix","quantité","date"};
	private JScrollPane scrollPane;
	private static CarnetOrdre carnet=new CarnetOrdre();
	private boolean stop=true;
   
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LastTest window = new LastTest();
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
	public LastTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		 scrollPane = new JScrollPane();
		scrollPane.setBounds(84, 78, 426, 208);
		frame.getContentPane().add(scrollPane);
		
		JButton btnThread = new JButton("thread");
		btnThread.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				if (!stop) {
					stop = true;
					
				} else {
					stop = false;
					
					Thread chronoThread = new Thread();
					chronoThread.start();
				}
			}
				
			
		});
		btnThread.setBounds(143, 24, 117, 25);
		frame.getContentPane().add(btnThread);
		
		 table= new JTable();
		 
	       
	        DefaultTableModel model= new DefaultTableModel();
	        model.setColumnIdentifiers(s);
	        table.setModel(model);
	     scrollPane.setViewportView(table);
	        
	}

	@Override
	public void run() {
		while (!stop) {
			try {
				Thread.sleep(CHRONO_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			tt();
			table.setModel(re(carnet.getVentes()));
			
		}
		
		
		
	}
public static  DefaultTableModel re(ArrayList<Ordre>ordre){
	DefaultTableModel model=new DefaultTableModel();
		//model.setRowCount(0);
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
			if(or.getType().equals("vente")){
			Execution.rec(items, or);}
			else{
				Execution.recachat(items, or);
			}
			
		}
		return model;
}
public static void tt(){
	
	  
	    
	    Random k =new Random();
		for(int index=0; index<1000;index++)
		{
			 if(Main.aleatoire(5)){
				   double l=Main.prix(40,50);
				   int m=k.nextInt(47)+89;
			   Ordre ach = new AchatN(1,l,m,55,new Date(),"achat");
			   
			   System.out.println("achattttt");
			   Execution.insertAchat(carnet.getAchats(), ach);
			  
			   
			   }else{
				   System.out.println("vvvvvvtttt");
				   
				   double l=Main.prix(40,50);
				   int m=k.nextInt(47)+89;
			   Ordre ven = new Vente(1,l,m,55,new Date(),"vente");
			   Execution.insertVente(carnet.getVentes(), ven);
			      
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
}

}
