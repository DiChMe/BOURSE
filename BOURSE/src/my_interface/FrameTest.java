package my_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class FrameTest extends JFrame {
	
	private PanelTwo p1;
	

	public FrameTest(){
		super("boussad's tests");
		
		setLayout(null);
		setSize(1350,750);
		JButton f=new JButton("fg");
		setVisible(true);
		 p1= new PanelTwo();
				//p1.setVisible(true);
		add(p1);
		
		
		
	}

	
	public static void main(String[]args){
		
		new FrameTest();
	}
	
	
}
