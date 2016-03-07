package my_interface;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PanelFour extends JPanel{
	
	private JScrollPane scrollPane;
	private JTable table;
	private JComboBox comboBox;
	private DefaultTableModel model;
	private JButton btnStart;

	public PanelFour(){
		
		super();
		
		setBackground(new Color(70, 130, 180));
	    setBounds(0, 0, 1350, 750);
		setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 12, 545, 541);
		add(scrollPane);
		
		table= new JTable();
	    model= new DefaultTableModel();
		Object[]s={"NOM","CAPTITAL","TYPE"};
		model.setColumnIdentifiers(s);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		 btnStart = new JButton("START");
			btnStart.setBounds(1004, 505, 153, 46);
			add(btnStart);
		
		comboBox = new JComboBox();
		comboBox.setBounds(807, 184, 297, 36);
		add(comboBox);
		
	}
	
	public void addSSSaction(ActionListener l){
		getBtnStart().addActionListener(l);;
	}

	public JButton getBtnStart() {
		return btnStart;
	}

	public void setBtnStart(JButton btnStart) {
		this.btnStart = btnStart;
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

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}
	

}
