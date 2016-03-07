package panel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelTwo extends JPanel {

	private JButton btn;

	public PanelTwo() {
		super();
		setLayout(null);
		 setBackground(Color.blue);
		 setSize(400,400);
		// setVisible(true);
		 btn= new JButton("précedent");
		 btn.setVisible(true);
		 btn.setBounds(10,10,100,40);
		 //setSize(400,400);
		 add(btn);
	}
void addPrecedentListner(ActionListener action){
		
		btn.addActionListener(action);
	}

	public JButton getBtn() {
		return btn;
	}
	
}
