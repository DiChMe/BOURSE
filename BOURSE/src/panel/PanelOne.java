package panel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelOne extends JPanel{
	 private JButton btn;

	public PanelOne(){
		 
		 super();
		 setLayout(new FlowLayout());
		 setBackground(Color.red);
		 setVisible(true);
		 setSize(400,400);
		 btn= new JButton("suivant");
		 //btn.setVisible(true);
		 btn.setBounds(10,10,10,10);
		 add(btn);
		 
	 }
	
	void addSuivantListner(ActionListener action){
		
		btn.addActionListener(action);
	}

	public JButton getBtn() {
		return btn;
	}
	

}
