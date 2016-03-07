package my_interface;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import data.Entreprise;

public class PanelTwo extends JPanel{
     
	   private JRadioButton rdbtnTlcomunication;
	private JRadioButton rdbtnAgricole;
	private JRadioButton rdbtnTransport;
	private JRadioButton rdbtnCommercial;
	private ButtonGroup grp;
	private JLabel lblEvT1;
	private JLabel lblEvT2;
	private JLabel lblEvT3;
	private JLabel lblEvT4;
	private JSlider slider1;
	private JSlider slider2;
	private JSlider slider3;
	private JSlider slider4;
	private JSlider slider5;
	private JSlider slider6;
	private JSlider slider7;
	private JSlider slider8;
	private JComboBox comboBoxEntrprise;
	private JLabel lblEv1;
	private JLabel lblEv2;
	private JLabel lblEv4;
	private JLabel lblEv3;
	private JButton btnAjEvEnt;
	private JButton btnAjEvType;
	private JButton btnSuivant;
	private JButton btnPrcedent;
	private DefaultComboBoxModel model;

	public PanelTwo(){
		   
		  
			setBounds(0, 0, 1350, 700);
			
			setLayout(null);
			
			JLabel lblParametrage = new JLabel("PARAMETRAGE DES EVENEMENTS");
			lblParametrage.setHorizontalAlignment(SwingConstants.CENTER);
			lblParametrage.setBounds(112, 12, 1200, 40);
			add(lblParametrage);
			
			JLabel lblDuredeLaSimulation = new JLabel("Duréede la simulation");
			lblDuredeLaSimulation.setHorizontalAlignment(SwingConstants.CENTER);
			lblDuredeLaSimulation.setBounds(12, 114, 232, 34);
			add(lblDuredeLaSimulation);
			
			JComboBox comboBoxTime = new JComboBox();
			comboBoxTime.setModel(new DefaultComboBoxModel(new String[] {"5", "10", "15", "20", "25", "30", "60"}));
			comboBoxTime.setMaximumRowCount(4);
			comboBoxTime.setBounds(265, 114, 65, 34);
			add(comboBoxTime);
			
			JLabel lblEvenementParType = new JLabel("EVENEMENT PAR TYPE D'ENTREPRISE");
			lblEvenementParType.setHorizontalAlignment(SwingConstants.CENTER);
			lblEvenementParType.setBounds(12, 215, 272, 25);
			add(lblEvenementParType);
			
			setBackground(new Color(70, 130, 180));
			
			rdbtnTlcomunication = new JRadioButton("TÉLÉCOMMUNICATION");
			rdbtnTlcomunication.setBounds(22, 294, 190, 23);
			add(rdbtnTlcomunication);
			
			rdbtnAgricole = new JRadioButton("AGRICOLE");
			rdbtnAgricole.setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnAgricole.setBounds(202, 294, 149, 23);
			add(rdbtnAgricole);
			
			rdbtnTransport = new JRadioButton("TRANSPORT");
			rdbtnTransport.setBounds(355, 294, 149, 23);
			add(rdbtnTransport);
			
			rdbtnCommercial = new JRadioButton("COMMERCIAL");
			rdbtnCommercial.setBounds(524, 294, 149, 23);
			add(rdbtnCommercial);
			grp= new ButtonGroup();
			grp.add(rdbtnTlcomunication);
			grp.add(rdbtnAgricole);
			grp.add(rdbtnCommercial);
			grp.add(rdbtnTransport);
			rdbtnTlcomunication.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					lblEvT1.setText("Télécommunication1");
					lblEvT2.setText("Télécommunication2");
					lblEvT3.setText("Télécommunication3");
					lblEvT4.setText("Télécommunication4");
				}
				
			});
			rdbtnCommercial.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					lblEvT1.setText("Commercial1");
					lblEvT2.setText("Commercial2");
					lblEvT3.setText("Commercial3");
					lblEvT4.setText("Commercial4");
				}
				
			});
			
			rdbtnAgricole.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					lblEvT1.setText("agricole1");
					lblEvT2.setText("agricole2");
					lblEvT3.setText("agricole3");
					lblEvT4.setText("agricole4");
				}
				
			});
			rdbtnTransport.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					lblEvT1.setText("transport1");
					lblEvT2.setText("Transport2");
					lblEvT3.setText("Transport3");
					lblEvT4.setText("Transport4");
				}
				
			});
			
			lblEvT1 = new JLabel("EV1");
			lblEvT1.setBounds(12, 385, 141, 23);
			add(lblEvT1);
			
			lblEvT2 = new JLabel("EV1");
			lblEvT2.setBounds(12, 441, 141, 23);
			add(lblEvT2);
			
			lblEvT3 = new JLabel("EV1");
			lblEvT3.setBounds(12, 492, 141, 23);
			add(lblEvT3);
			
			lblEvT4 = new JLabel("EV1");
			lblEvT4.setBounds(12, 550, 141, 23);
			add(lblEvT4);
			
			slider1 = new JSlider();
			slider1.setValue(0);
			slider1.setMaximum(80);
			slider1.setPaintTicks(true);
			slider1.setMajorTickSpacing(1);
			slider1.setBounds(151, 385, 200, 16);
			add(slider1);
			
			slider2 = new JSlider();
			slider2.setValue(0);
			slider2.setMajorTickSpacing(1);
			slider2.setPaintTicks(true);
			slider2.setSnapToTicks(true);
			slider2.setMinimum(-80);
			slider2.setMaximum(0);
			slider2.setBounds(151, 492, 200, 16);
			add(slider2);
			
			slider3 = new JSlider();
			slider3.setValue(0);
			slider3.setSnapToTicks(true);
			slider3.setPaintTicks(true);
			slider3.setMinimum(-80);
			slider3.setMaximum(0);
			slider3.setMajorTickSpacing(1);
			slider3.setBounds(151, 550, 200, 16);
			add(slider3);
			
			slider4 = new JSlider();
			slider4.setValue(0);
			slider4.setPaintTicks(true);
			slider4.setMaximum(80);
			slider4.setMajorTickSpacing(1);
			slider4.setBounds(151, 441, 200, 16);
			add(slider4);
			
			JLabel lblEvenementParDentreprise = new JLabel("EVENEMENT PAR ENTREPRISE");
			lblEvenementParDentreprise.setHorizontalAlignment(SwingConstants.CENTER);
			lblEvenementParDentreprise.setBounds(767, 215, 272, 25);
			add(lblEvenementParDentreprise);
			
			slider5 = new JSlider();
			slider5.setValue(0);
			slider5.setPaintTicks(true);
			slider5.setMaximum(80);
			slider5.setMajorTickSpacing(1);
			slider5.setBounds(1043, 385, 200, 16);
			add(slider5);
			
			slider6 = new JSlider();
			slider6.setValue(0);
			slider6.setPaintTicks(true);
			slider6.setMaximum(80);
			slider6.setMajorTickSpacing(1);
			slider6.setBounds(1043, 441, 200, 16);
			add(slider6);
			
			slider7 = new JSlider();
			slider7.setValue(0);
			slider7.setSnapToTicks(true);
			slider7.setPaintTicks(true);
			slider7.setMinimum(-80);
			slider7.setMaximum(0);
			slider7.setMajorTickSpacing(1);
			slider7.setBounds(1043, 492, 200, 16);
			add(slider7);
			
			slider8 = new JSlider();
			slider8.setValue(0);
			slider8.setSnapToTicks(true);
			slider8.setPaintTicks(true);
			slider8.setMinimum(-80);
			slider8.setMaximum(0);
			slider8.setMajorTickSpacing(1);
			slider8.setBounds(1043, 550, 200, 16);
			add(slider8);
			
			comboBoxEntrprise = new JComboBox();
			comboBoxEntrprise.setMaximumRowCount(5);
			comboBoxEntrprise.setBounds(1024, 289, 219, 25);
			add(comboBoxEntrprise);
			
			 model= new DefaultComboBoxModel(); 
			 comboBoxEntrprise.setModel(model);
			 lblEv1 = new JLabel("agricole");
			 lblEv1.setBounds(819, 385, 141, 23);
			 add(lblEv1);
			
			lblEv2 = new JLabel("AGRICOLE");
			lblEv2.setBounds(819, 441, 141, 23);
			add(lblEv2);
			
			lblEv4 = new JLabel("AGRICOLE");
			lblEv4.setBounds(819, 550, 141, 23);
			add(lblEv4);
			
			lblEv3 = new JLabel("AGRICOLE");
			lblEv3.setBounds(819, 492, 141, 23);
			add(lblEv3);
			
			btnAjEvEnt = new JButton("ajouter");
			btnAjEvEnt.setBounds(1126, 616, 117, 25);
			add(btnAjEvEnt);
			
			btnAjEvType = new JButton("ajouter");
			btnAjEvType.setBounds(22, 616, 117, 25);
			add(btnAjEvType);
			
			btnSuivant = new JButton("suivant");
			btnSuivant.setBounds(661, 663, 117, 25);
			add(btnSuivant);
			
			btnPrcedent = new JButton("précedent");
			btnPrcedent.setBounds(513, 663, 117, 25);
			add(btnPrcedent);
		
		   
	   }

	public DefaultComboBoxModel getModel() {
		return model;
	}

	public void DefaultComboBoxModel(DefaultComboBoxModel model) {
		this.model = model;
		
	}
	public void reconstract(ArrayList<Entreprise> en){
		model.removeAllElements();
		for(Entreprise e:en){
			model.addElement(e);
		}
	}

	public JRadioButton getRdbtnTlcomunication() {
		return rdbtnTlcomunication;
	}

	public void setRdbtnTlcomunication(JRadioButton rdbtnTlcomunication) {
		this.rdbtnTlcomunication = rdbtnTlcomunication;
	}

	public JRadioButton getRdbtnAgricole() {
		return rdbtnAgricole;
	}

	public void setRdbtnAgricole(JRadioButton rdbtnAgricole) {
		this.rdbtnAgricole = rdbtnAgricole;
	}

	public JRadioButton getRdbtnTransport() {
		return rdbtnTransport;
	}

	public void setRdbtnTransport(JRadioButton rdbtnTransport) {
		this.rdbtnTransport = rdbtnTransport;
	}

	public JRadioButton getRdbtnCommercial() {
		return rdbtnCommercial;
	}

	public void setRdbtnCommercial(JRadioButton rdbtnCommercial) {
		this.rdbtnCommercial = rdbtnCommercial;
	}

	public JLabel getLblEvT1() {
		return lblEvT1;
	}

	public void setLblEvT1(JLabel lblEvT1) {
		this.lblEvT1 = lblEvT1;
	}

	public JLabel getLblEvT2() {
		return lblEvT2;
	}

	public void setLblEvT2(JLabel lblEvT2) {
		this.lblEvT2 = lblEvT2;
	}

	public JLabel getLblEvT3() {
		return lblEvT3;
	}

	public void setLblEvT3(JLabel lblEvT3) {
		this.lblEvT3 = lblEvT3;
	}

	public JLabel getLblEvT4() {
		return lblEvT4;
	}

	public void setLblEvT4(JLabel lblEvT4) {
		this.lblEvT4 = lblEvT4;
	}

	public JSlider getSlider1() {
		return slider1;
	}

	public void setSlider1(JSlider slider1) {
		this.slider1 = slider1;
	}

	public JSlider getSlider2() {
		return slider2;
	}

	public void setSlider2(JSlider slider2) {
		this.slider2 = slider2;
	}

	public JSlider getSlider3() {
		return slider3;
	}

	public void setSlider3(JSlider slider3) {
		this.slider3 = slider3;
	}

	public JSlider getSlider4() {
		return slider4;
	}

	public void setSlider4(JSlider slider4) {
		this.slider4 = slider4;
	}

	public JSlider getSlider5() {
		return slider5;
	}

	public void setSlider5(JSlider slider5) {
		this.slider5 = slider5;
	}

	public JSlider getSlider6() {
		return slider6;
	}

	public void setSlider6(JSlider slider6) {
		this.slider6 = slider6;
	}

	public JSlider getSlider7() {
		return slider7;
	}

	public void setSlider7(JSlider slider7) {
		this.slider7 = slider7;
	}

	public JSlider getSlider8() {
		return slider8;
	}

	public void setSlider8(JSlider slider8) {
		this.slider8 = slider8;
	}

	public JComboBox getComboBoxEntrprise() {
		return comboBoxEntrprise;
	}

	public void setComboBoxEntrprise(JComboBox comboBoxEntrprise) {
		this.comboBoxEntrprise = comboBoxEntrprise;
	}

	public JLabel getLblEv1() {
		return lblEv1;
	}

	public void setLblEv1(JLabel lblEv1) {
		this.lblEv1 = lblEv1;
	}

	public JLabel getLblEv2() {
		return lblEv2;
	}

	public void setLblEv2(JLabel lblEv2) {
		this.lblEv2 = lblEv2;
	}

	public JLabel getLblEv4() {
		return lblEv4;
	}

	public void setLblEv4(JLabel lblEv4) {
		this.lblEv4 = lblEv4;
	}

	public JLabel getLblEv3() {
		return lblEv3;
	}

	public void setLblEv3(JLabel lblEv3) {
		this.lblEv3 = lblEv3;
	}

	public JButton getBtnAjEvEnt() {
		return btnAjEvEnt;
	}

	public void setBtnAjEvEnt(JButton btnAjEvEnt) {
		this.btnAjEvEnt = btnAjEvEnt;
	}

	public JButton getBtnAjEvType() {
		return btnAjEvType;
	}

	public void setBtnAjEvType(JButton btnAjEvType) {
		this.btnAjEvType = btnAjEvType;
	}

	public JButton getBtnSuivant() {
		return btnSuivant;
	}

	public void setBtnSuivant(JButton btnSuivant) {
		this.btnSuivant = btnSuivant;
	}

	public JButton getBtnPrcedent() {
		return btnPrcedent;
	}

	public void setBtnPrcedent(JButton btnPrcedent) {
		this.btnPrcedent = btnPrcedent;
	}
	
	public void addPrecedentListener(ActionListener l){
		getBtnPrcedent().addActionListener(l);
	}
	public void addSuivantListener(ActionListener l){
		getBtnSuivant().addActionListener(l);
	}
	public void addEventTypeListener(ActionListener l){
		getBtnAjEvType().addActionListener(l);
	}
	public void addEvenEntListener(ActionListener l){
		getBtnAjEvEnt().addActionListener(l);
	}
	
	public String SelectedRbButton(){
		if(this.rdbtnAgricole.isSelected()){
			
			return this.rdbtnAgricole.getLabel();
		}else{
			if(this.rdbtnCommercial.isSelected()){
				  return this.rdbtnCommercial.getLabel();
			}else{
				if(this.rdbtnTlcomunication.isSelected()){
					return this.rdbtnTlcomunication.getLabel();
				}else{
					if(this.rdbtnTransport.isSelected()){
						return this.rdbtnTransport.getLabel();
				
					}else{
						return null;
					}
				}
			}
		}
		
	}
	
}
