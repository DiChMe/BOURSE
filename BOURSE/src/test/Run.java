package test;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
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

public class Run  extends JFrame implements Runnable{
	
	private static final long CHRONO_SPEED =1000;
	private static CarnetOrdre carnet =new CarnetOrdre();
	private JScrollPane scrollePane;
	private JTable table;
	private DefaultTableModel model;
	static Object []s={"aa","aff"};
	private JButton btnOk;
	
	private Run instance= this;
	private boolean stop=false;

	public Run(){
		super("sdf");
		init();
	}
	public void init(){
		
		setVisible(true);
		pack();
		setBounds(100, 100, 750, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		table= new JTable();
		model=new DefaultTableModel();
		scrollePane= new JScrollPane();
		model.setColumnIdentifiers(s);
		table.setModel(model);
		scrollePane.setBounds(54, 69, 541, 304);
		scrollePane.setViewportView(table);
		getContentPane().add(scrollePane);
		
		btnOk = new JButton("ok");
		btnOk.setVisible(true);
		getContentPane().add(btnOk);
		
		btnOk.setBounds(0, 1, 117, 25);
		btnOk.addActionListener(new ActionListener(){

			private boolean stop;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!stop) {
					stop = true;
					
				} else {
					stop = false;
					
					Thread chronoThread = new Thread(instance);
					chronoThread.start();
				}
				
			}
			
			
			
		});
		
	}

	@Override
	public void run() {
		while (!stop) {
			try {
				Thread.sleep(CHRONO_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			DefaultTableModel m=(DefaultTableModel)table.getModel();
			m.setRowCount(0);
			table.setModel(ree());
		}
	
	}
	
	public static void main(String[]args){
		
		new Run();
		
		
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
public static DefaultTableModel ree(){
	
	DefaultTableModel model=new DefaultTableModel();
	model.setColumnIdentifiers(s);
	
	model.addColumn(s);
	model.addColumn(s);
	model.addColumn(s);
	
	
	return model;
}
}
