package test;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import data.Entreprise;
import data.Evenement;
import data.GroupeEntreprise;
import my_interface.*;

public class TestDEuxPanel extends JFrame implements Runnable{

	private PanelOne p1;
	private PanelTwo p2;
	private PanelThree p3;
	private static GroupeEntreprise entrprises=new GroupeEntreprise();
	private static HashMap<String,Evenement> tev=new HashMap<String, Evenement>();
	private static ArrayList<Evenement> tevv=new ArrayList<Evenement>();
    private Integer x=0;
	private PanelFour p4;
	private boolean stop=false;
	private TestDEuxPanel instance=this;
	private static int y=0;
	public TestDEuxPanel() {
		super("testedsv");
		init();
		
	}
	public void init(){
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(1350,750);
			setLayout(null);
		  
		    
		     
		     p1 = new PanelOne();
			 p2= new PanelTwo();
			 p3=new PanelThree();
			 p4=new PanelFour();
			 
			 p2.setVisible(false);
			 p3.setVisible(false);
			 p4.setVisible(false);
			 
			 add(p1);add(p2);add(p3);add(p4);
			 
			 if( entrprises.size()>0){
				 p1.getBtnSuivant().setVisible(true);
			 }else{
				 p1.getBtnSuivant().setVisible(false);
			 }
			 
			 p1.addSSuivantListener(new suivant());
			 p1.addAjouterListener(new ajouter());
			 p1.addSupprimerListener(new supprimer());
		     p1.addModifierListener(new modifier());
		     
			 p2.addPrecedentListener(new precedent());
			 p2.getComboBoxEntrprise().addItemListener(new actionlabel());;
		     p2.addEvenEntListener(new AjoutEvenEn());
		     p2.addEventTypeListener(new AjoutEvenType());
		     p2.addSuivantListener(new suivant2());
		     
		    p3.addAction(new StartAction());
		    p4.addSSSaction(new SS());
	}
	
	class suivant implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
		p1.setVisible(false);
		p2.setVisible(true);
		p2.getComboBoxEntrprise().setModel(mo());
			
		}
		
		
		
	}
	class precedent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
		p2.setVisible(false);
		p1.setVisible(true);
			
		}

	}
	class ajouter implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
		
			if(!p1.getTextField().getText().equals("")){
		      
			
			Object[] row=new Object[3];
			row[0]=p1.getTextField().getText();
			String nom=p1.getTextField().getText();
			
			row[1]=p1.getComboCapital().getSelectedItem();
			double capital=(double)Integer.parseInt((String) p1.getComboCapital().getSelectedItem());
			
			row[2]=p1.getComboType().getSelectedItem();
			String type=(String) p1.getComboType().getSelectedItem();
			
			Entreprise en= new Entreprise(nom,entrprises.size(),capital,type);
			
			if(entrprises.addEntrprise(en)){
				p1.getModel().addRow(row);
				 p1.getTextField().setText("");
			};
			System.out.println(entrprises);
			
			 if( entrprises.size()>0){
				 p1.getBtnSuivant().setVisible(true);
			 }else{
				 p1.getBtnSuivant().setVisible(false);
			 }
			
			}
			
		}

	}
	
	class supprimer implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			int select= p1.getTable().getSelectedRow();
			if(select>=0){
				p1.getModel().removeRow(select);
				entrprises.getEntreprises().remove(select);
				System.err.println(entrprises);
			}
			 if( entrprises.size()>0){
				 p1.getBtnSuivant().setVisible(true);
			 }else{
				 p1.getBtnSuivant().setVisible(false);
			 }
			
		}	
		
	}
	
	class modifier implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
		////	int i = table.getSelectedRow();
		//	if(i>=0){
		//	model.setValueAt("sa marche",i, 2)
			int select= p1.getTable().getSelectedRow();
			if(select>=0 && !p1.getTextField().getText().equals("")){
				
				String nom=p1.getTextField().getText();
				double capital=(double)Integer.parseInt((String) p1.getComboCapital().getSelectedItem());
				
				Object t= p1.getComboCapital().getSelectedItem();
				String type=(String) p1.getComboType().getSelectedItem();
				
				entrprises.getEntreprises().get(select).setNom(nom);
				entrprises.getEntreprises().get(select).setType(type);
				entrprises.getEntreprises().get(select).setCapital(capital);
				
			       p1.getModel().setValueAt(nom, select, 0);	
			       p1.getModel().setValueAt(t, select, 1);	
			       p1.getModel().setValueAt(type, select, 2);
			       p1.getTextField().setText("");
			       
			       System.out.println(entrprises);
			       
			       
			}
			
		}	
		
	}
	class actionlabel implements ItemListener{

		@Override
		
		
		public void itemStateChanged(ItemEvent event) {
			if(event.getSource()==p2.getComboBoxEntrprise()){
				
				Entreprise en=(Entreprise) p2.getComboBoxEntrprise().getSelectedItem();
				
				if(en.getType().equals("TÉLÉCOMMUNICATION")){
					p2.getLblEv1().setText("po1");
					p2.getLblEv2().setText("po2");
					p2.getLblEv3().setText("ne3");
					p2.getLblEv4().setText("ne4");
					}else{
						if(en.getType().equals("COMMERCIAL")){
							p2.getLblEv1().setText("commercial");
							p2.getLblEv2().setText("potl2");
							p2.getLblEv3().setText("netl3");
							p2.getLblEv4().setText("netl4");	
						}else{
							if(en.getType().equals("AGRICOLE")){
								p2.getLblEv1().setText("poAg1");
								p2.getLblEv2().setText("poAg2");
								p2.getLblEv3().setText("neAg3");
								p2.getLblEv4().setText("neAg4");
							}else{
									p2.getLblEv1().setText("transport");
									p2.getLblEv2().setText("poTr2");
									p2.getLblEv3().setText("neTr3");
									p2.getLblEv4().setText("neTr4");
							}
							
					}
			}
				
		}
	}
			
		
}	
	
	public static DefaultComboBoxModel mo(){
		DefaultComboBoxModel model=new DefaultComboBoxModel();
		for(Entreprise en: entrprises.getEntreprises()){
			model.addElement(en);
		}
		
		return model;
	}
	
	public static DefaultTableModel moT(){
		DefaultTableModel model=new DefaultTableModel();
		Object [] s= {"NOM","CAPITAL","TYPE"};
		model.setColumnIdentifiers(s);
		
		Object row[]=new Object[3];
		for(Entreprise en: entrprises.getEntreprises()){
			row[0]=en.getNom();
			row[1]=en.getCapital();
			row[2]=en.getType();
			model.addRow(row);
		}
		
		return model;
	}
	
	
	class AjoutEvenType implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String type=p2.SelectedRbButton();
			
			if(type!=null){
			
			String ev1=p2.getLblEvT1().getText();int v1=p2.getSlider1().getValue();
			String ev2=p2.getLblEvT2().getText();int v2=p2.getSlider2().getValue();
			String ev3=p2.getLblEvT3().getText();int v3=p2.getSlider3().getValue();
			String ev4=p2.getLblEvT4().getText();int v4=p2.getSlider4().getValue();
			
			entrprises.addEvenementParType(new Evenement(ev1,v1), type);
			entrprises.addEvenementParType(new Evenement(ev2,v2), type);
			entrprises.addEvenementParType(new Evenement(ev3,v3), type);
			entrprises.addEvenementParType(new Evenement(ev4,v4), type);
			
			tev.put(ev1,new Evenement(ev1,v1) );
			tev.put(ev2,new Evenement(ev2,v2) );
			tev.put(ev3,new Evenement(ev3,v3) );
			tev.put(ev4,new Evenement(ev4,v4) );
			
			tevv.add(new Evenement(ev1,v1));tevv.add(new Evenement(ev2,v2));
			tevv.add(new Evenement(ev4,v4));tevv.add(new Evenement(ev4,v4));
			
			
			p2.getSlider1().setValue(0);
			p2.getSlider2().setValue(0);
			p2.getSlider3().setValue(0);
			p2.getSlider4().setValue(0);
		}
	}
		
	}
	
	class AjoutEvenEn implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String ev1=p2.getLblEv1().getText();int v1=p2.getSlider5().getValue();
			String ev2=p2.getLblEv2().getText();int v2=p2.getSlider6().getValue();
			String ev3=p2.getLblEv3().getText();int v3=p2.getSlider7().getValue();
			String ev4=p2.getLblEv4().getText();int v4=p2.getSlider7().getValue();
			
			Entreprise en=(Entreprise) p2.getComboBoxEntrprise().getSelectedItem();
			
			en.addEvenements(new Evenement(ev1,v1));
			en.addEvenements(new Evenement(ev2,v2));
			en.addEvenements(new Evenement(ev3,v3));
			en.addEvenements(new Evenement(ev4,v4));
			
			tev.put(ev1,new Evenement(ev1,v1) );
			tev.put(ev2,new Evenement(ev2,v2) );
			tev.put(ev3,new Evenement(ev3,v3) );
			tev.put(ev4,new Evenement(ev4,v4) );
			
			tevv.add(new Evenement(ev1,v1));tevv.add(new Evenement(ev2,v2));
			tevv.add(new Evenement(ev4,v4));tevv.add(new Evenement(ev4,v4));
			
			
			p2.getSlider5().setValue(0);
			p2.getSlider6().setValue(0);
			p2.getSlider7().setValue(0);
			p2.getSlider8().setValue(0);
		}
		
	}
	
	class suivant2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int i=JOptionPane.showConfirmDialog(null, "VOULEZ_VOUS TERMINER LE RÉGLAGE DES PARAMÉTRE?");
			if(i==0){
				p2.setVisible(false);
				p3.setVisible(true);
			}
			
		}
//	
	}
	class StartAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int i=JOptionPane.showConfirmDialog(null, "VOULEZ_VOUS COMMENCER?");
			if(i==0){
				p3.setVisible(false);
				p4.setVisible(true);
				p4.getTable().setModel(moT());
				//p4.setComboBox(p2.getComboBoxEntrprise());;
				p4.getComboBox().setModel(mo());
				
				//Thread time=new Thread(instance);
				//time.start();
			}
			
		}	
	}
	class SS implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.err.println("alorssssss");
			
			p4.getTable().removeAll();
			p4.getTable().revalidate();
			    for(Entreprise en:entrprises.getEntreprises()){
			    	if(en.getEvenements().containsValue(tevv.get(y))){
			    		
			    		
			    		double val=((double)(100+tevv.get(y).getVal()))/100;
			    		en.setCapital(en.getCapital()*val);
			    		
			    	}
			    }
				p4.getTable().setModel(moT());
				//p4.setComboBox(p2.getComboBoxEntrprise());;
		}	
	}
	public static void main(String[]args){
		
		new TestDEuxPanel();
	}
	@Override
	public void run() {
		int k=0;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Collection<Evenement> collection= tev.values();
		
		while(!stop && k<20){
		for(Evenement ev:collection){
			
			for(Entreprise entr:entrprises.getEntreprises()){
				
				if(entr.getEvenements().containsValue(ev)){
					
					double pr=(double)((100+ev.getVal()))/100;
					entr.setCapital(entr.getCapital()*pr);
					
				}
				
			}
			
			System.out.println(tev);
			p4.getTable().removeAll();
			p4.getTable().setModel(moT());
			System.err.println("change");
			stop=!stop;
			k++;
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			stop=!stop;
	 		
			
		}
		
	}
	}
	
			
			
		
		
	
}
