package my_interface;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PanelOne  extends JPanel{
	
	
    private JComboBox comboCapital;
	private JComboBox comboType;
	private JButton btnAjouter;
	private JButton btnSupprimer;
	

	private JButton btnModifier;
	private JScrollPane scrollPane;
	
	private JTable table;
	private DefaultTableModel model;
	private JButton btnSuivant;
	private JTextField textField;

	public PanelOne(){
    	  super();
    	  
    	  setBounds(0, 0, 1350, 750);
    	  setLayout(null);
    	  setBackground(new Color(70, 130, 180));
    	  
    	JLabel lblCreationDentreprise = new JLabel("creation d'entreprise");
  		lblCreationDentreprise.setHorizontalAlignment(SwingConstants.CENTER);
  		lblCreationDentreprise.setBounds(112, 12, 1200, 40);
  		add(lblCreationDentreprise);
  		
  		JLabel lblNom = new JLabel("NOM");
  		lblNom.setBounds(15, 113, 184, 20);
  		add(lblNom);
  		
  		JLabel lblCapital = new JLabel("CAPITAL");
  		lblCapital.setBounds(15, 165, 184, 20);
  		add(lblCapital);
  		
  		JLabel lblType = new JLabel("TYPE");
  		lblType.setBounds(15, 214, 184, 20);
  		add(lblType);
  		setVisible(true);
  		comboCapital = new JComboBox();
  		comboCapital.setModel(new DefaultComboBoxModel(new String[] {"10000000", "15000000", "25000000", "40000000", "60000000", "80000000", "100000000", "500000000", "1000000000", "2000000000"}));
  		comboCapital.setMaximumRowCount(4);
  		comboCapital.setBounds(129, 164, 184, 22);
  		add(comboCapital);
  		
  		comboType = new JComboBox();
  		comboType.setModel(new DefaultComboBoxModel(new String[] {"TÉLÉCOMMUNICATION", "COMMERCIAL", "AGRICOLE", "TRANSPORT"}));
  		comboType.setMaximumRowCount(4);
  		comboType.setBounds(129, 212, 184, 22);
  		add(comboType);
  		
  	    btnAjouter = new JButton("AJOUTER");
  		btnAjouter.setBounds(150, 317, 117, 25);
  		add(btnAjouter);
  		
  		btnSupprimer = new JButton("SUPPRIMER");
  		btnSupprimer.setBounds(150, 368, 117, 25);
  		add(btnSupprimer);
  		
  	    btnModifier = new JButton("MODIFIER");
  		btnModifier.setBounds(150, 423, 117, 25);
  		add(btnModifier);
  		
  	    scrollPane = new JScrollPane();
  		scrollPane.setBounds(451, 141, 572, 391);
  		add(scrollPane);
  		
  		table= new JTable();
  		model= new DefaultTableModel();
  		Object[]s={"NOM","TYPE","CAPITAL"};
  		model.setColumnIdentifiers(s);
  		table.setModel(model);
  		 scrollPane.setViewportView(table);
  		 table.setRowHeight(40);
  		
  		btnSuivant = new JButton("SUIVANT");
  		btnSuivant.setBounds(1080, 578, 117, 25);
  		add(btnSuivant);
  		textField = new JTextField();
		textField.setBounds(129, 111, 184, 25);
		add(textField);
		textField.setColumns(10);
    	  
      }
	
	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JComboBox getComboCapital() {
		return comboCapital;
	}

	public void setComboCapital(JComboBox comboCapital) {
		this.comboCapital = comboCapital;
	}

	public JComboBox getComboType() {
		return comboType;
	}

	public void setComboType(JComboBox comboType) {
		this.comboType = comboType;
	}

	public JButton getBtnAjouter() {
		return btnAjouter;
	}

	public void setBtnAjouter(JButton btnAjouter) {
		this.btnAjouter = btnAjouter;
	}

	public JButton getBtnSupprimer() {
		return btnSupprimer;
	}

	public void setBtnSupprimer(JButton btnSupprimer) {
		this.btnSupprimer = btnSupprimer;
	}

	public JButton getBtnModifier() {
		return btnModifier;
	}

	public void setBtnModifier(JButton btnModifier) {
		this.btnModifier = btnModifier;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public JButton getBtnSuivant() {
		return btnSuivant;
	}

	public void setBtnSuivant(JButton btnSuivant) {
		this.btnSuivant = btnSuivant;
	}
     
	 public void addAjouterListener(ActionListener l){
		 this.btnAjouter.addActionListener(l);
 		 
	 }
	 
	 public void addSupprimerListener(ActionListener l){
		 this.btnSupprimer.addActionListener(l);
		 
	 }
	 
	public  void addSSuivantListener(ActionListener l){
		 this.btnSuivant.addActionListener(l);
		 
	 }
	public  void addModifierListener(ActionListener l){
		 this.btnModifier.addActionListener(l);
		 
	 }
	 
	 
}
